package ds.stack;

public class SizeOverFlowException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errorMessage=null;
	public SizeOverFlowException(String message) {
		errorMessage=message;
	}
	@Override
	public String getMessage() {
		System.err.println(errorMessage);
		return super.getMessage();
	}
}
