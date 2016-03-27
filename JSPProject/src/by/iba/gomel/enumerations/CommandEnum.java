package by.iba.gomel.enumerations;

import by.iba.gomel.commands.AddCommand;
import by.iba.gomel.commands.ChangeCommand;
import by.iba.gomel.commands.ControlCommand;
import by.iba.gomel.commands.DeleteCommand;
import by.iba.gomel.commands.DeleteUserCommand;
import by.iba.gomel.commands.EditCommand;
import by.iba.gomel.commands.EditProfileCommand;
import by.iba.gomel.commands.ForwardMainPageCommand;
import by.iba.gomel.commands.LoginCommand;
import by.iba.gomel.commands.LogoutCommand;
import by.iba.gomel.commands.ProfileCommand;
import by.iba.gomel.commands.RegistrationCommand;
import by.iba.gomel.commands.SearchCommand;
import by.iba.gomel.commands.ViewCommand;
import by.iba.gomel.interfaces.IActionCommand;

/**
 * This enumeration contains all command used by this application.
 */
public enum CommandEnum {
    LOGIN {
        {
            command = new LoginCommand();
        }
    },
    VIEW {
        {
            command = new ViewCommand();
        }
    },
    ADD {
        {
            command = new AddCommand();
        }
    },
    EDIT {
        {
            command = new EditCommand();
        }
    },
    SEARCH {
        {
            command = new SearchCommand();
        }
    },
    EDIT_PROFILE {
        {
            command = new ChangeCommand();
        }
    },
    EDIT_BD_PROFILE {
        {
            command = new EditProfileCommand();
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
    PROFILE {
        {
            command = new ProfileCommand();
        }
    },
    DELETE {
        {
            command = new DeleteCommand();
        }
    },
    DELETE_USER {
        {
            command = new DeleteUserCommand();
        }
    },
    CONTROL {
        {
            command = new ControlCommand();
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
