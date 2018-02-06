package com.ssm.exception;

/**
 * 异常--重复秒杀
 */
public class SeckillRepeatException extends SeckillException {

	private static final long serialVersionUID = 7293862095247415338L;

	public SeckillRepeatException() {
    }

    public SeckillRepeatException(String message) {
        super(message);
    }

    public SeckillRepeatException(String message, Throwable cause) {
        super(message, cause);
    }
}
