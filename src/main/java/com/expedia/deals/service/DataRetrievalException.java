package com.expedia.deals.service;

/**
 * Thrown in case data can't be retrieved for any reason.
 *
 */
public class DataRetrievalException extends RuntimeException {

	private static final long serialVersionUID = -8910083103923557439L;

	public DataRetrievalException() {
		super();
	}

	public DataRetrievalException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DataRetrievalException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataRetrievalException(String message) {
		super(message);
	}

	public DataRetrievalException(Throwable cause) {
		super(cause);
	}

}
