package br.com.previsao.model.exception;

import br.com.previsao.model.exception.generic.EntityNaoEncontradaException;

public class CidadeNaoEncontradaException extends EntityNaoEncontradaException {

    public CidadeNaoEncontradaException() {
        super("Cidade não encontrada");
    }

    public CidadeNaoEncontradaException(String s) {
        super(s);
    }

    public CidadeNaoEncontradaException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CidadeNaoEncontradaException(Throwable throwable) {
        super(throwable);
    }

    public CidadeNaoEncontradaException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
