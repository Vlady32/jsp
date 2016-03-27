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

/**
 * This class implements interface IActionCommand and realizes method execute. This class uses for
 * searching record from db.
 */
public class SearchCommand implements IActionCommand {

    @Override
    public String execute(final SessionRequest request) {
        if (request.isUser()) {
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_LOGIN_PAGE);
        }
        final String searchPhrase = request.getRequest().getParameter(
                Constants.PARAMETER_PHRASE_SEARCH);
        final String category = request.getRequest().getParameter(Constants.PARAMETER_CATEGORY);
        try {
            final List<Record> listRecords = SearchLogic.extract(searchPhrase, category);
            if (listRecords.size() > 0) {
                request.getRequest().setAttribute(Constants.ATTRIBUTE_NAME_LIST_RECORDS,
                        listRecords);
            } else {
                request.getRequest().setAttribute(Constants.MESSAGE_ERROR_VIEW,
                        MessageManager.getProperty(Constants.MESSAGE_EMPTY_VIEW));
            }
            request.getRequest().setAttribute(Constants.PARAMETER_PHRASE_SEARCH, searchPhrase);
            Record.setListRecords(listRecords);
        } catch (final ViewException e) {
            request.getRequest().setAttribute(Constants.MESSAGE_ERROR_VIEW,
                    MessageManager.getProperty(Constants.MESSAGE_WRONG_VIEW));
        }
        return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_SEARCH_PAGE);
    }

}
