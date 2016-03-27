package by.iba.gomel.commands;

import java.util.List;

import by.iba.gomel.Constants;
import by.iba.gomel.Record;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.logicDB.ViewLogic;
import by.iba.gomel.managers.ConfigurationManager;
import by.iba.gomel.managers.MessageManager;

/**
 * This class implements inerface IActionCommand and realizes method execute.
 */
public class ProfileCommand implements IActionCommand {

    @Override
    public String execute(final SessionRequest request) {
        String page = null;
        final String type = (String) request.getSession().getAttribute(
                Constants.ATTRIBUTE_NAME_TYPE);
        if ((type == null) || type.equals("guest") || type.equals("")) {
            request.getRequest().setAttribute(Constants.MESSAGE_ERROR_VIEW,
                    MessageManager.getProperty(Constants.MESSAGE_WRONG_VIEW));
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_LOGIN_PAGE);
        }
        final int item = Integer.parseInt(request.getRequest().getParameter("item"));
        final List<Record> listRecords = ViewLogic.getListRecords();
        Record foundRecord = null;
        for (final Record record : listRecords) {
            if (record.getItem() == item) {
                foundRecord = record;
            }
        }
        if (foundRecord != null) {
            request.getRequest().setAttribute(Constants.ATTRIBUTE_FOUND_RECORD, foundRecord);
            page = ConfigurationManager.getProperty(Constants.PROPERTY_PATH_PROFILE_PAGE);
        } else {
            request.getRequest().setAttribute(Constants.MESSAGE_ERROR_PROFILE,
                    MessageManager.getProperty(Constants.MESSAGE_WRONG_PROFILE));
            page = ConfigurationManager.getProperty(Constants.PROPERTY_PATH_VIEW_PAGE);
        }
        return page;
    }
}
