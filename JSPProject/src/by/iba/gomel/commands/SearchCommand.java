package by.iba.gomel.commands;

import java.util.List;

import by.iba.gomel.Constants;
import by.iba.gomel.Record;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.exceptions.ViewException;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.logicDB.SearchLogic;
import by.iba.gomel.managers.ConfigurationManager;
import by.iba.gomel.managers.MessageManager;

public class SearchCommand implements IActionCommand {

    @Override
    public String execute(final SessionRequest request) {
        System.err.println("here");
        final String type = (String) request.getSession().getAttribute(
                Constants.ATTRIBUTE_NAME_TYPE);
        if ((type == null) || type.equals("guest") || type.equals("")) {
            System.err.println("Type=null");
            request.getRequest().setAttribute(Constants.MESSAGE_ERROR_VIEW,
                    MessageManager.getProperty(Constants.MESSAGE_WRONG_VIEW));
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_LOGIN_PAGE);
        }
        final String searchPhrase = request.getRequest().getParameter("phraseSearch");
        final String category = request.getRequest().getParameter("category");
        System.err.println(searchPhrase + " " + category);

        try {
            final List<Record> listRecords = SearchLogic.extract(
                    request.getRequest().getParameter("phraseSearch"), request.getRequest()
                            .getParameter("category"));
            if (listRecords.size() > 0) {
                request.getRequest().setAttribute(Constants.ATTRIBUTE_NAME_LIST_RECORDS,
                        listRecords);
            } else {
                request.getRequest().setAttribute(Constants.MESSAGE_ERROR_VIEW,
                        MessageManager.getProperty(Constants.MESSAGE_EMPTY_VIEW));
            }
        } catch (final ViewException e) {
            request.getRequest().setAttribute(Constants.MESSAGE_ERROR_VIEW,
                    MessageManager.getProperty(Constants.MESSAGE_WRONG_VIEW));
        }
        return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_SEARCH_PAGE);
    }

}
