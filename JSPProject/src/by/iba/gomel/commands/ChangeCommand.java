package by.iba.gomel.commands;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.managers.ConfigurationManager;

public class ChangeCommand implements IActionCommand {

    @Override
    public String execute(final SessionRequest request) {
        new ProfileCommand().execute(request);
        return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_EDIT_PROFILE_PAGE);
    }

}
