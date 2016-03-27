package by.iba.gomel.commands;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.Constants;
import by.iba.gomel.Record;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.logicDB.AdditionLogic;
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
        final SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(Constants.DATE_PATTERN);
        final Record addedRecord = new Record();
        addedRecord.setFullName(getParameter(request, Constants.PARAMETER_FULL_NAME));
        addedRecord.setAddress(getParameter(request, Constants.PARAMETER_ADDRESS));
        addedRecord.setPhoneNumber(getParameter(request, Constants.PARAMETER_ADDRESS));
        addedRecord.setMail(getParameter(request, Constants.PARAMETER_MAIL));
        try {
            addedRecord.setBirthDate(format.parse(getParameter(request,
                    Constants.PARAMETER_BIRTH_DATE)));
        } catch (final ParseException e) {
            AddCommand.LOGGER.error(Constants.PARSE_EXCEPTION, e);
        }
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
        return request.getRequest().getParameter(parameter);
    }

}
