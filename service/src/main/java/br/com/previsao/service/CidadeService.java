package br.com.previsao.service;

import br.com.previsao.impl.OpenWeatherMapImpl;
import br.com.previsao.model.converter.CidadeConverter;
import br.com.previsao.model.dto.CidadeDTO;
import br.com.previsao.model.dto.openweathermap.OpenWeatherMapDTO;
import br.com.previsao.model.entity.CidadeEntity;
import br.com.previsao.model.exception.CidadeNaoEncontradaException;
import br.com.previsao.repository.ICidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CidadeService extends ServiceAbstract<ICidadeRepository>{

    @Autowired
    private OpenWeatherMapImpl openWeatherMap;

    /**
     * Método que busca as cidades no end-point do open weather map com base no nome da cidade e sigla do pais
     * @param nome
     * @param codPais
     * @return
     */
    public OpenWeatherMapDTO buscarOpenWeatherMap(String nome, String codPais) {
        return openWeatherMap.buscarCidades(nome, codPais);
    }


    /**
     * Método que busca a previsão dos 5 ultimos dias de uma cidade no open weather map
     * @param id
     * @return
     */
    public OpenWeatherMapDTO previsaoOpenWeatherMap(String id) {
        return this.openWeatherMap.privisaoDetalhada(id);
    }

    /**
     * Metódo que salva um cidade para que se possa berificar posteriormente a previsão da mesma.
     * @param dto
     * @return
     */
    public CidadeDTO save(CidadeDTO dto) {
        CidadeEntity cidadeEntity = CidadeConverter.of(dto);
        cidadeEntity = this.getRepository().save(cidadeEntity);
        return CidadeConverter.of(cidadeEntity);
    }

    /**
     * Método que deleta uma cidade da base de dados
     * @param id
     */
    public void delete(Long id) {
        Optional<CidadeEntity> cidadeEntity = this.getRepository().findById(id);
        if (!cidadeEntity.isPresent()) throw new CidadeNaoEncontradaException();
        this.getRepository().delete(cidadeEntity.get());
    }

    /**
     * Metodo que busca uma cidade por id
     * @param id
     * @return
     */
    public CidadeDTO find(Long id) {
        Optional<CidadeEntity> cidadeEntity = this.getRepository().findById(id);
        if (!cidadeEntity.isPresent()) throw new CidadeNaoEncontradaException();
        return CidadeConverter.of(cidadeEntity.get());
    }

    /**
     * Método que busca uma lista das cidaes cadastradas
     * @return
     */
    public List<CidadeDTO> findAll() {
        List<CidadeEntity> cidadeEntities = this.getRepository().findAll();
        List<CidadeDTO> cidadeDTOS = new ArrayList<>();
        cidadeEntities.forEach(c -> cidadeDTOS.add(CidadeConverter.of(c)));
        return cidadeDTOS;
    }
}
