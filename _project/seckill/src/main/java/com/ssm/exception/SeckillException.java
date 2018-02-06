package com.ssm.exception;

/**
 * 秒杀相关异常
 */
public class SeckillException extends RuntimeException {

	private static final long serialVersionUID = -5265144140350694454L;

	public SeckillException() {
    }

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
