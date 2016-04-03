package by.iba.gomel;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.managers.MessageManager;

/**
 * This class contains methods for extracting content from request and adding content to request.
 * Also this class uses for working with session.
 */
public class SessionRequest {

    private static final Logger       LOGGER        = LoggerFactory.getLogger(SessionRequest.class);
    private final HttpServletRequest  request;
    private String                    command       = null;
    private final HttpSession         session;
    private final Map<String, String> parametersAdd = new HashMap<String, String>();

    /**
     * 
     * @param request
     *            from actionController.
     */
    public SessionRequest(final HttpServletRequest request) {
        this.request = request;
        session = request.getSession();
    }

    public Map<String, String> getParametersAdd() {
        return parametersAdd;
    }

    public HttpSession getSession() {
        return session;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public String extractCommand() {
        if (ServletFileUpload.isMultipartContent(request)) {
            return getMultipartParameters();
        }
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

    /**
     * 
     * @param nameParameter
     *            name of parameter for extracting from request. Type request: multipart/form-data
     * @return value of parameter.
     * @throws UnsupportedEncodingException
     * @throws FileUploadException
     */
    public String getMultipartParameters() {
        List<FileItem> items = null;
        String commandMultipart = null;
        final DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(Constants.ONE_KILOBYTE_TO_BYTE * Constants.ONE_KILOBYTE_TO_BYTE
                * Constants.NUMBER_TWO);
        factory.setRepository(new File(request.getServletContext()
                .getRealPath(Constants.TYPE_EMPTY) + Constants.TEMPORARY_NAME_FOLDER));
        final ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(Constants.ONE_KILOBYTE_TO_BYTE * Constants.ONE_KILOBYTE_TO_BYTE
                * Constants.NUMBER_TWO);
        try {
            items = upload.parseRequest(request);
        } catch (final FileUploadException e) {
            request.setAttribute(Constants.PARAMETER_MAX_SIZE,
                    MessageManager.getProperty(Constants.MESSAGE_MAX_SIZE_ERROR));
            SessionRequest.LOGGER.error(Constants.FILE_UPLOAD_EXCEPTION, e);
        }
        for (final FileItem item : items) {
            if (item.isFormField()) {
                final String name = item.getFieldName();
                String value = null;
                try {
                    value = item.getString(Constants.ENCODING_UTF_8).trim();
                } catch (final UnsupportedEncodingException e) {
                    SessionRequest.LOGGER.error(Constants.UNSUPPORTED_ENCODING_EXCEPTION, e);
                }
                if ((commandMultipart != null)
                        && (commandMultipart.equals(Constants.PATH_VALUE_ADD) || commandMultipart
                                .equals(Constants.PATH_EDIT_BD_PROFILE))) {
                    parametersAdd.put(name, value);
                }
                if (name.equals(Constants.PARAMETER_COMMAND)) {
                    commandMultipart = value;
                }
            } else {
                final String fileName = item.getName();
                final String path = Constants.PATH_VALUE_PHOTOS + File.separator
                        + new Date().getTime() + fileName;
                parametersAdd.put(Constants.PARAMETER_PATH_FILE, path);
                final File file = new File(path);
                try {
                    item.write(file);
                } catch (final Exception e) {
                    SessionRequest.LOGGER.error(Constants.EXCEPTION, e);
                }

            }
        }
        return command;
    }
}
