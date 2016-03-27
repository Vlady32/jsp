package by.iba.gomel.commands;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.managers.ConfigurationManager;

/**
 * This class implements interface IActionCommand and realizes method execute. This class uses for
 * getting page with records for editing in the next.
 */
public class EditCommand implements IActionCommand {

    @Override
    public String execute(final SessionRequest request) {
        new ViewCommand().execute(request);
        return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_EDIT_PAGE);
    }

}
