package br.com.previsao.model.converter;

import br.com.previsao.model.dto.CidadeDTO;
import br.com.previsao.model.entity.CidadeEntity;

public class CidadeConverter {

    public static CidadeDTO of(CidadeEntity entity) {
        CidadeDTO dto = new CidadeDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setSiglaPais(entity.getSiglaPais());
        dto.setIdentificador(entity.getIdentificador());

        return dto;
    }

    public static CidadeEntity of(CidadeDTO dto) {
        CidadeEntity entity = new CidadeEntity();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setSiglaPais(dto.getSiglaPais());
        entity.setIdentificador(dto.getIdentificador());

        return entity;
    }
}
