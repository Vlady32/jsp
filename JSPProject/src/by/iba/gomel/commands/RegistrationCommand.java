package by.iba.gomel.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.exceptions.DuplicateLoginException;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.logicDB.RegistrationLogic;
import by.iba.gomel.managers.ConfigurationManager;
import by.iba.gomel.managers.MessageManager;

/**
 * This class implements interface IActionCommand and realizes method execute. This class uses for
 * registration user in application.
 */
public class RegistrationCommand implements IActionCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationCommand.class);

    @Override
    public String execute(final SessionRequest request) {
        String page = null;
        final String login = request.getRequest().getParameter(Constants.PARAMETER_NAME_LOGIN);
        if (!checkLogin(login)) {
            request.getRequest().setAttribute(
                    Constants.MESSAGE_ERROR_LOGIN_PASS,
                    MessageManager
                            .getProperty(Constants.MESSAGE_REGISTRATION_INCORRECT_LOGIN_ERROR));
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_REGISTRATION_PAGE);
        }
        final String password = request.getRequest()
                .getParameter(Constants.PARAMETER_NAME_PASSWORD);
        final String confirmedPassword = request.getRequest().getParameter(
                Constants.PARAMETER_NAME_CONFIRMED_PASSWORD);
        final String typeUser = Constants.TYPE_USER;
        if (password.equals(confirmedPassword)) {
            try {
                RegistrationLogic.AddToDB(login, password, typeUser);
                page = ConfigurationManager
                        .getProperty(Constants.PROPERTY_PATH_REGISTRATION_SUCCESSFUL_PAGE);
            } catch (final DuplicateLoginException e) {
                RegistrationCommand.LOGGER.error(Constants.EXCEPTION_DUPLICATE_LOGIN, e);
                request.getRequest().setAttribute(Constants.MESSAGE_ERROR_LOGIN_PASS,
                        MessageManager.getProperty(Constants.MESSAGE_REGISTRATION_LOGIN_ERROR));
                page = ConfigurationManager.getProperty(Constants.PROPERTY_PATH_REGISTRATION_PAGE);
            }
        } else {
            request.getRequest().setAttribute(Constants.MESSAGE_ERROR_LOGIN_PASS,
                    MessageManager.getProperty(Constants.MESSAGE_REGISTRATION_PASSWORDS_ERROR));
            page = ConfigurationManager.getProperty(Constants.PROPERTY_PATH_REGISTRATION_PAGE);
        }
        return page;
    }

    /**
     * 
     * @param login
     *            login for checking.
     * @return validation result.
     */
    private boolean checkLogin(final String login) {
        final Pattern p = Pattern.compile(Constants.PATTERN_LOGIN);
        final Matcher m = p.matcher(login);
        return m.matches();
    }

}
