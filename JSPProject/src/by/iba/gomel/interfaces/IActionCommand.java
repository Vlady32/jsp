package by.iba.gomel.interfaces;

import by.iba.gomel.SessionRequest;

/**
 * This interface defines method execute.
 */
public interface IActionCommand {

    /**
     * This method extracts command from request.
     * 
     * @param request
     *            request from client.
     * @return page according to command.
     */
    String execute(SessionRequest request);
}
