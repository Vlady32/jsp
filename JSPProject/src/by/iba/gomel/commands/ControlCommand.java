package by.iba.gomel.commands;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.User;
import by.iba.gomel.exceptions.ViewException;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.logicdb.ControlLogic;
import by.iba.gomel.managers.ConfigurationManager;
import by.iba.gomel.managers.MessageManager;

/**
 * This class implements interface IActionCommand and realizes method execute. This class uses for
 * working with users.
 */
public class ControlCommand implements IActionCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControlCommand.class);

    @Override
    public String execute(final SessionRequest request) {
        if (request.isUser()) {
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_LOGIN_PAGE);
        }
        int qualityPages;
        try {
            final int startPosition = Integer.parseInt(request.getRequest().getParameter(
                    Constants.PARAMETER_START_POSITION));
            final List<User> listUsers = ControlLogic.extract(startPosition);
            qualityPages = (int) Math.ceil(ControlLogic.getQualityUsers()
                    / Constants.DEFAULT_QUALITY_RECORDS_AND_USERS_ON_PAGE);
            request.getRequest().setAttribute(Constants.ATTRIBUTE_CURRENT_POSITION, startPosition);
            request.getRequest().setAttribute(Constants.ATTRIBUTE_QUALITY_PAGES, qualityPages);
            request.getRequest().setAttribute(Constants.ATTRIBUTE_NAME_LIST_USERS, listUsers);
        } catch (final ViewException e) {
            request.getRequest().setAttribute(Constants.MESSAGE_ERROR_VIEW,
                    MessageManager.getProperty(Constants.MESSAGE_WRONG_VIEW));
            ControlCommand.LOGGER.error(Constants.VIEW_EXCEPTION, e);
        }
        return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_CONTROL_PAGE);
    }

}
