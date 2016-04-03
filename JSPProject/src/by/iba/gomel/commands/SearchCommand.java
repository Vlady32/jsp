package by.iba.gomel.commands;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.Constants;
import by.iba.gomel.Record;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.exceptions.ViewException;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.logicdb.SearchLogic;
import by.iba.gomel.managers.ConfigurationManager;
import by.iba.gomel.managers.MessageManager;

/**
 * This class implements interface IActionCommand and realizes method execute. This class uses for
 * searching record from db.
 */
public class SearchCommand implements IActionCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchCommand.class);

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
            if (!listRecords.isEmpty()) {
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
            SearchCommand.LOGGER.error(Constants.VIEW_EXCEPTION, e);
        }
        return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_SEARCH_PAGE);
    }

}
