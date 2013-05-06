package br.com.gigio.db_adapter_kickstart.exception;

public class QueryExecutorException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3099995785212444324L;
	/**
	 * Constructor with message parameter.
	 * 
	 * @param message
	 */
	public QueryExecutorException(String message) {
		super(message);
	}

}
