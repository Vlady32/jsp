package by.iba.gomel.commands;

import java.util.List;

import by.iba.gomel.Constants;
import by.iba.gomel.Record;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.exceptions.ViewException;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.logicDB.ViewLogic;
import by.iba.gomel.managers.ConfigurationManager;
import by.iba.gomel.managers.MessageManager;

/**
 * This class implements inerface IActionCommand and realizes method execute.
 */
public class ViewCommand implements IActionCommand {

    @Override
    public String execute(final SessionRequest request) {
        String page = null;
        int qualityPages;
        if (request.getSession().getAttribute(Constants.ATTRIBUTE_NAME_TYPE)
                .equals(Constants.TYPE_GUEST)) {
            System.err.println("guest");
            request.getRequest().setAttribute(Constants.MESSAGE_ERROR_VIEW,
                    MessageManager.getProperty(Constants.MESSAGE_WRONG_VIEW));
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_LOGIN_PAGE);
        }
        try {
            final int startPosition = Integer.parseInt(request.getRequest().getParameter("start"));
            final List<Record> listRecords = ViewLogic.extract(startPosition);
            qualityPages = (int) Math.ceil(ViewLogic.getQualityRecords() / 30.0);
            request.getRequest().setAttribute(Constants.ATTRIBUTE_CURRENT_POSITION, startPosition);
            request.getRequest().setAttribute(Constants.ATTRIBUTE_QUALITY_PAGES, qualityPages);
            request.getRequest().setAttribute(Constants.ATTRIBUTE_NAME_LIST_RECORDS, listRecords);
            page = ConfigurationManager.getProperty(Constants.PROPERTY_PATH_VIEW_PAGE);
        } catch (final ViewException e) {
            request.getRequest().setAttribute(Constants.MESSAGE_ERROR_VIEW,
                    MessageManager.getProperty(Constants.MESSAGE_WRONG_VIEW));
            page = ConfigurationManager.getProperty(Constants.PROPERTY_PATH_VIEW_PAGE);
        }
        return page;
    }

}
