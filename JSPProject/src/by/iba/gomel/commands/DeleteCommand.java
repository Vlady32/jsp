package by.iba.gomel.commands;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.logicDB.DeleteLogic;
import by.iba.gomel.managers.ConfigurationManager;
import by.iba.gomel.managers.MessageManager;

public class DeleteCommand implements IActionCommand {

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
        final int item = Integer.parseInt(request.getRequest().getParameter("item"));
        if (DeleteLogic.deleteRecord(item)) {
            new ViewCommand().execute(request);
            request.getRequest().setAttribute(Constants.MESSAGE_SUCCESS_VIEW,
                    MessageManager.getProperty(Constants.MESSAGE_DELETING_SUCCESS));
        } else {
            request.getRequest().setAttribute(Constants.MESSAGE_ERROR_VIEW,
                    MessageManager.getProperty(Constants.MESSAGE_DELETING_ERROR));
        }
        return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_EDIT_PAGE);
    }

}
