package by.iba.gomel.controllers;

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
        } else if (request.getParameter("path").equals("view")) {
            request.getRequestDispatcher("/jsp/view.jsp").forward(request, response);
        } else if (request.getParameter("path").equals("search")) {
            request.getRequestDispatcher("/jsp/search.jsp").forward(request, response);
        } else if (request.getParameter("path").equals("add")) {
            request.getRequestDispatcher("/jsp/add.jsp").forward(request, response);
        } else if (request.getParameter("path").equals("edit")) {
            request.getRequestDispatcher("/jsp/edit.jsp").forward(request, response);
        } else if (request.getParameter("path").equals("control")) {
            request.getRequestDispatcher("/jsp/control.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
        }
    }

}
