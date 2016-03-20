package by.iba.gomel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * This class contains methods for extracting content from request and adding content to request.
 */
public class SessionRequest {
    private final HttpServletRequest request;
    private String                   command = null;
    private final HttpSession        session;

    public SessionRequest(final HttpServletRequest request) {
        this.request = request;
        session = request.getSession();
    }

    public HttpSession getSession() {
        return session;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public String extractCommand() {
        if (request.getMethod().equals(Constants.REQUEST_GET)) {
            command = (String) request.getAttribute(Constants.PARAMETER_COMMAND);
            return command;
        }
        command = request.getParameter(Constants.PARAMETER_COMMAND);
        return command;
    }

    public void insertAttribute(final String name, final Object value) {
        request.setAttribute(name, value);
    }

    public void setAttributesSession(final String name, final Object value) {
        session.setAttribute(name, value);
    }

}
