package br.com.previsao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ServiceAbstract<R extends JpaRepository> {

    @Autowired
    private R repository;

    public R getRepository() {
        return repository;
    }
}
