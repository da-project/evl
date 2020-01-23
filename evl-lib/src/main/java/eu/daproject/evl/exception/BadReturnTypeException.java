package eu.daproject.evl.exception;

public class BadReturnTypeException extends RuntimeException {

	private static final long serialVersionUID = 4L;

	/**
	 * Constructs an exception with predefined message.
	 * @param type the passed type
	 * @param expectedType the expected type
	 */
	public BadReturnTypeException(Class<?> expectedType, Class<?> type) {
		super("Bad return type: " + expectedType + " is not assignable from " + type);
	}
}