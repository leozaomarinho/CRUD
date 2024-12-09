package exceptions;

public class connException extends DbException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public connException(String message, Throwable cause ){
		super(message,cause);
	}

}
