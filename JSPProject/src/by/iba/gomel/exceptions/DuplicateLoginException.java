package by.iba.gomel.exceptions;

/**
 * This exception arise if username have already had in db.
 */
public class DuplicateLoginException extends Exception {
    private static final long serialVersionUID = 1L;

    public DuplicateLoginException(final String login, final Throwable e) {
        super(e);
    }

}
