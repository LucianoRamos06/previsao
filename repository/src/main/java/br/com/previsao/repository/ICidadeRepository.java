package br.com.previsao.repository;

import br.com.previsao.model.entity.CidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICidadeRepository extends JpaRepository<CidadeEntity, Long> {
}
