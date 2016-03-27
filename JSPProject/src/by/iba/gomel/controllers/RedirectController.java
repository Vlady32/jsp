package by.iba.gomel.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.gomel.Constants;
import by.iba.gomel.managers.ConfigurationManager;

/**
 * This servlet processes different redirections.
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
        if (request.getParameter(Constants.PARAMETER_PATH)
                .equals(Constants.PATH_VALUE_REGISTRATION)) {
            request.getRequestDispatcher(
                    ConfigurationManager.getProperty(Constants.PROPERTY_PATH_REGISTRATION_PAGE))
                    .forward(request, response);
        } else if (request.getParameter(Constants.PARAMETER_PATH)
                .equals(Constants.PATH_VALUE_LOGIN)) {
            request.getRequestDispatcher(
                    ConfigurationManager.getProperty(Constants.PROPERTY_PATH_LOGIN_PAGE)).forward(
                    request, response);
        } else if (request.getParameter(Constants.PARAMETER_PATH).equals(
                Constants.PATH_VALUE_SEARCH)) {
            request.getRequestDispatcher(
                    ConfigurationManager.getProperty(Constants.PROPERTY_PATH_SEARCH_PAGE)).forward(
                    request, response);
        } else if (request.getParameter(Constants.PARAMETER_PATH).equals(Constants.PATH_VALUE_ADD)) {
            request.getRequestDispatcher(
                    ConfigurationManager.getProperty(Constants.PROPERTY_PATH_ADD_PAGE)).forward(
                    request, response);
        } else if (request.getParameter(Constants.PARAMETER_PATH).equals(Constants.PATH_VALUE_EDIT)) {
            request.getRequestDispatcher(
                    ConfigurationManager.getProperty(Constants.PROPERTY_PATH_EDIT_PAGE)).forward(
                    request, response);
        } else {
            request.getRequestDispatcher(
                    ConfigurationManager.getProperty(Constants.PROPERTY_PATH_INDEX_PAGE)).forward(
                    request, response);
        }
    }

}
