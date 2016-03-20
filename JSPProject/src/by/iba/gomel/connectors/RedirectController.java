package by.iba.gomel.connectors;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectController
 */
@WebServlet("/redirectController")
public class RedirectController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("path").equals("registration")) {
            request.getRequestDispatcher("/jsp/registration.jsp").forward(request, response);
        } else if (request.getParameter("path").equals("login")) {
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
        }
    }

}
