package by.iba.gomel.commands;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.Constants;
import by.iba.gomel.Record;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.logicDB.EditLogic;
import by.iba.gomel.managers.ConfigurationManager;
import by.iba.gomel.managers.MessageManager;

/**
 * This class implements interface IActionCommand and realizes method execute. This class uses for
 * editing profile.
 */
public class EditProfileCommand implements IActionCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(EditProfileCommand.class);

    @Override
    public String execute(final SessionRequest request) {
        if (request.isUser()) {
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_LOGIN_PAGE);
        }
        final SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(Constants.DATE_PATTERN);
        final Record editedRecord = new Record();
        editedRecord.setItem(Integer.parseInt(getParameter(request, Constants.PARAMETER_ITEM)));
        editedRecord.setFullName(getParameter(request, Constants.PARAMETER_FULL_NAME));
        editedRecord.setAddress(getParameter(request, Constants.PARAMETER_ADDRESS));
        editedRecord.setPhoneNumber(getParameter(request, Constants.PARAMETER_PHONE_NUMBER));
        editedRecord.setMail(getParameter(request, Constants.PARAMETER_MAIL));
        try {
            editedRecord.setBirthDate(format.parse(getParameter(request,
                    Constants.PARAMETER_BIRTH_DATE)));
        } catch (final ParseException e) {
            EditProfileCommand.LOGGER.error(Constants.PARSE_EXCEPTION, e);
        }
        if (EditLogic.editRecord(editedRecord)) {
            request.getRequest().setAttribute(Constants.MESSAGE_RESULT_ADDITION,
                    MessageManager.getProperty(Constants.MESSAGE_EDITING_SUCCESS));
        } else {
            request.getRequest().setAttribute(Constants.MESSAGE_RESULT_ADDITION,
                    MessageManager.getProperty(Constants.MESSAGE_ADDITION_ERROR));
        }
        return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_EDIT_PROFILE_PAGE);
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
