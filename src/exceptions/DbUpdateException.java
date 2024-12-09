package exceptions;

public class DbUpdateException extends DbException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DbUpdateException (String message, Throwable cause) {
		super(message,cause);
	}
}
