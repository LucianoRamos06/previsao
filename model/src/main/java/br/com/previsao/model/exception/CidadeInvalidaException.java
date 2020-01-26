package br.com.previsao.model.exception;

import br.com.previsao.model.exception.generic.EntityNaoEncontradaException;

public class CidadeInvalidaException extends EntityNaoEncontradaException {

    public CidadeInvalidaException() {
        super("Cidade inválida");
    }

    public CidadeInvalidaException(String s) {
        super(s);
    }

    public CidadeInvalidaException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CidadeInvalidaException(Throwable throwable) {
        super(throwable);
    }

    public CidadeInvalidaException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
