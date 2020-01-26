package br.com.previsao.model.exception.generic;

public class EntityNaoEncontradaException extends RuntimeException {

    public EntityNaoEncontradaException() {
    }

    public EntityNaoEncontradaException(String s) {
        super(s);
    }

    public EntityNaoEncontradaException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public EntityNaoEncontradaException(Throwable throwable) {
        super(throwable);
    }

    public EntityNaoEncontradaException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
