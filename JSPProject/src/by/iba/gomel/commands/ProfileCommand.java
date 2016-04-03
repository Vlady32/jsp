package by.iba.gomel.commands;

import java.util.List;

import by.iba.gomel.Constants;
import by.iba.gomel.Record;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.managers.ConfigurationManager;
import by.iba.gomel.managers.MessageManager;

/**
 * This class implements interface IActionCommand and realizes method execute. This class uses for
 * viewing record's profile.
 */
public class ProfileCommand implements IActionCommand {

    @Override
    public String execute(final SessionRequest request) {
        if (request.isUser()) {
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_LOGIN_PAGE);
        }
        String page;
        final int item = Integer.parseInt(request.getRequest().getParameter(
                Constants.PARAMETER_ITEM));
        final List<Record> listRecords = Record.getListRecords();
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
