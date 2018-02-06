package com.ssm.exception;

/**
 * 异常--秒杀关闭
 */
public class SeckillCloseException extends SeckillException {

	private static final long serialVersionUID = -2736455505338666998L;

	public SeckillCloseException() {
    }

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
