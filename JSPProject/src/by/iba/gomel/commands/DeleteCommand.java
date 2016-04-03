package by.iba.gomel.commands;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.logicdb.DeleteRecordLogic;
import by.iba.gomel.managers.ConfigurationManager;
import by.iba.gomel.managers.MessageManager;

/**
 * This class implements interface IActionCommand and realizes method execute. This class uses for
 * deleting records from db.
 */
public class DeleteCommand implements IActionCommand {

    @Override
    public String execute(final SessionRequest request) {
        if (request.isUser()) {
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_LOGIN_PAGE);
        }
        final int item = Integer.parseInt(request.getRequest().getParameter(
                Constants.PARAMETER_ITEM));
        if (DeleteRecordLogic.deleteRecord(item)) {
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
