package by.iba.gomel.interfaces;

import by.iba.gomel.SessionRequest;

/**
 * This interface defines method execute.
 */
public interface IActionCommand {

    /*
     * This method extracts command from request.
     */
    String execute(SessionRequest request);
}
