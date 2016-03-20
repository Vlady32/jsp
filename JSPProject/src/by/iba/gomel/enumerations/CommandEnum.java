package by.iba.gomel.enumerations;

import by.iba.gomel.commands.ForwardMainPageCommand;
import by.iba.gomel.commands.LoginCommand;
import by.iba.gomel.commands.LogoutCommand;
import by.iba.gomel.commands.RegistrationCommand;
import by.iba.gomel.interfaces.IActionCommand;

public enum CommandEnum {
    LOGIN {
        {
            command = new LoginCommand();
        }
    },
    FORWARDMAINPAGE {
        {
            command = new ForwardMainPageCommand();
        }
    },
    LOGOUT {
        {
            command = new LogoutCommand();
        }
    },
    REGISTRATION {
        {
            command = new RegistrationCommand();
        }
    };

    IActionCommand command;

    public IActionCommand getCommand() {
        return command;
    }
}
