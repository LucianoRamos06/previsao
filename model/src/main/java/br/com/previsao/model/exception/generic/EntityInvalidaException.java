package br.com.previsao.model.exception.generic;

public class EntityInvalidaException extends RuntimeException {

    public EntityInvalidaException() {
    }

    public EntityInvalidaException(String s) {
        super(s);
    }

    public EntityInvalidaException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public EntityInvalidaException(Throwable throwable) {
        super(throwable);
    }

    public EntityInvalidaException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
