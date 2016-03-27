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
 * This class implements inerface IActionCommand and realizes method execute.
 */
public class AddCommand implements IActionCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddCommand.class);

    @Override
    public String execute(final SessionRequest request) {
        final String type = (String) request.getSession().getAttribute(
                Constants.ATTRIBUTE_NAME_TYPE);
        if ((type == null) || type.equals("guest") || type.equals("")) {
            System.err.println("Type=null");
            request.getRequest().setAttribute(Constants.MESSAGE_ERROR_VIEW,
                    MessageManager.getProperty(Constants.MESSAGE_WRONG_VIEW));
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_LOGIN_PAGE);
        }
        final SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        final Record addedRecord = new Record();
        addedRecord.setFullName(getParameter(request, "fullName"));
        addedRecord.setAddress(getParameter(request, "address"));
        addedRecord.setPhoneNumber(getParameter(request, "phoneNumber"));
        addedRecord.setMail(getParameter(request, "mail"));
        try {
            addedRecord.setBirthDate(format.parse(getParameter(request, "birthDate")));
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
