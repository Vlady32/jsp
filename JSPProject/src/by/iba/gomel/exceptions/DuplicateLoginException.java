package by.iba.gomel.exceptions;

public class DuplicateLoginException extends Exception {
    private static final long serialVersionUID = 1L;

    private final String      duplicateLogin;

    public DuplicateLoginException(final String login, final Throwable e) {
        super(e);
        duplicateLogin = login;
    }

    @Override
    public final String getMessage() {
        return "This login: " + duplicateLogin + "already exists";
    }

}
