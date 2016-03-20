package by.iba.gomel.connectors;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.factories.ActionFactory;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.managers.ConfigurationManager;
import by.iba.gomel.managers.MessageManager;

/**
 * This servlet process all commands from pages.
 */
@WebServlet("/actionController")
public class ActionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding(Constants.ENCODING_UTF_8);
        final SessionRequest requestContent = new SessionRequest(request);
        String page = null;
        final ActionFactory client = new ActionFactory();
        final IActionCommand command = client.defineCommand(requestContent);
        // call method execute
        page = command.execute(requestContent);
        if (page != null) {
            final RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(requestContent.getRequest(), response);
        } else {
            page = ConfigurationManager.getProperty(Constants.PROPERTY_PATH_INDEX_PAGE);
            requestContent.insertAttribute(Constants.PARAMETER_NULL_PAGE,
                    MessageManager.getProperty(Constants.MESSAGE_NULL_PAGE));
            response.sendRedirect(requestContent.getRequest().getContextPath() + page);
        }
    }

}
