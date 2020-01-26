package br.com.previsao.controller;

import br.com.previsao.model.dto.AbstractDTO;
import br.com.previsao.model.entity.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface ICrudController<E extends AbstractEntity, D extends AbstractDTO> {

    ResponseEntity<Void> delete( Long id) throws Exception;

    ResponseEntity<D> update(D dto) throws Exception;

    ResponseEntity<D> save(D dto) throws Exception;

    ResponseEntity<D> find(Long id) throws Exception;

    ResponseEntity<Page<D>> findAll(Pageable pageable) throws Exception;
}
