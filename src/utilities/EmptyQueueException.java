package utilities;

public class EmptyQueueException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3137043748681837412L;

	public EmptyQueueException()
	{
		super();
	}

	/**
	 * @param message error message specific to cause of error.
	 */
	public EmptyQueueException( String message )
	{
		super( message );
	}
}
