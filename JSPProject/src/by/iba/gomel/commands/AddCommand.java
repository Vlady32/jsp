package by.iba.gomel.commands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.Constants;
import by.iba.gomel.Record;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.logicdb.AdditionLogic;
import by.iba.gomel.managers.ConfigurationManager;
import by.iba.gomel.managers.MessageManager;

/**
 * This class implements interface IActionCommand and realizes method execute. This class uses for
 * adding data from request and sends to addLogic.
 */
public class AddCommand implements IActionCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddCommand.class);

    @Override
    public String execute(final SessionRequest request) {
        if (request.isUser()) {
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_LOGIN_PAGE);
        }
        if (request.getRequest().getAttribute(Constants.PARAMETER_MAX_SIZE) != null) {
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_ADD_PAGE);
        }
        final SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(Constants.DATE_PATTERN);
        final Record addedRecord = new Record();

        final String fullName = getParameter(request, Constants.PARAMETER_FULL_NAME);
        if (checkInput(fullName, Constants.REG_FULL_NAME)) {
            addedRecord.setFullName(fullName);
        } else {
            request.getRequest().setAttribute(Constants.PARAMETER_CHECKING_FULL_NAME,
                    MessageManager.getProperty(Constants.MESSAGE_FULL_NAME_ERROR));
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_ADD_PAGE);
        }

        final String address = getParameter(request, Constants.PARAMETER_ADDRESS);
        if (checkInput(address, Constants.REG_ADDRESS)) {
            addedRecord.setAddress(address);
        } else {
            request.getRequest().setAttribute(Constants.PARAMETER_CHECKING_ADDRESS,
                    MessageManager.getProperty(Constants.MESSAGE_ADDRESS_ERROR));
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_ADD_PAGE);
        }

        final String phoneNumber = getParameter(request, Constants.PARAMETER_PHONE_NUMBER);
        if (checkInput(phoneNumber, Constants.REG_PHONE_NUMBER)) {
            addedRecord.setPhoneNumber(phoneNumber);
        } else {
            request.getRequest().setAttribute(Constants.PARAMETER_CHECKING_PHONE_NUMBER,
                    MessageManager.getProperty(Constants.MESSAGE_PHONE_NUMBER_ERROR));
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_ADD_PAGE);
        }

        final String mail = getParameter(request, Constants.PARAMETER_MAIL);
        if (!mail.equals(Constants.TYPE_EMPTY)) {
            if (checkInput(mail, Constants.REG_MAIL)) {
                addedRecord.setMail(mail);
            } else {
                request.getRequest().setAttribute(Constants.PARAMETER_CHECKING_MAIL,
                        MessageManager.getProperty(Constants.MESSAGE_MAIL_ERROR));
                return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_ADD_PAGE);
            }
        }

        try {
            addedRecord.setBirthDate(format.parse(getParameter(request,
                    Constants.PARAMETER_BIRTH_DATE)));
        } catch (final ParseException e) {
            AddCommand.LOGGER.error(Constants.PARSE_EXCEPTION, e);
        }
        addedRecord.setPathFile(getParameter(request, Constants.PARAMETER_PATH_FILE));
        System.err.println(addedRecord);
        if (AdditionLogic.addRecord(addedRecord)) {
            request.getRequest().setAttribute(Constants.MESSAGE_RESULT_ADDITION,
                    MessageManager.getProperty(Constants.MESSAGE_ADDITION_SUCCESS));
        } else {
            request.getRequest().setAttribute(Constants.MESSAGE_RESULT_ADDITION,
                    MessageManager.getProperty(Constants.MESSAGE_ADDITION_ERROR));
        }
        return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_ADD_PAGE);
    }

    /**
     * 
     * @param request
     *            request.
     * @param parameter
     *            parameter for extracting.
     * @return parameter.
     */
    private String getParameter(final SessionRequest request, final String parameter) {
        return request.getParametersAdd().get(parameter);
    }

    /**
     * 
     * @param value
     *            value from form input.
     * @param rexExp
     *            regular expression for certain value.
     * @return result.
     */
    private boolean checkInput(final String value, final String rexExp) {
        final Pattern p = Pattern.compile(rexExp);
        final Matcher m = p.matcher(value);
        return m.matches();
    }

}
