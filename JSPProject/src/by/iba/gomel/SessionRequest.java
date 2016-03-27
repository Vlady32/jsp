package by.iba.gomel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.iba.gomel.managers.MessageManager;

/**
 * This class contains methods for extracting content from request and adding content to request.
 * Also this class uses for working with session.
 */
public class SessionRequest {
    private final HttpServletRequest request;
    private String                   command = null;
    private final HttpSession        session;

    /**
     * 
     * @param request
     *            from actionController.
     */
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

    public boolean isUser() {
        final String type = (String) request.getSession().getAttribute(
                Constants.ATTRIBUTE_NAME_TYPE);
        if ((type == null) || type.equals(Constants.TYPE_GUEST)
                || type.equals(Constants.TYPE_EMPTY)) {
            request.setAttribute(Constants.MESSAGE_ERROR_VIEW,
                    MessageManager.getProperty(Constants.MESSAGE_WRONG_VIEW));
            return true;
        }
        return false;
    }

}
