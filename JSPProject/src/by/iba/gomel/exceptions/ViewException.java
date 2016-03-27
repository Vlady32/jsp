package by.iba.gomel.exceptions;

/**
 * This exception arise if db doesn't return data.
 */
public class ViewException extends Exception {
    private static final long serialVersionUID = 1L;

    public ViewException(final Throwable e) {
        super(e);
    }

}
