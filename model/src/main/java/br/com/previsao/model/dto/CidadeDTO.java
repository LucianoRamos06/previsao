package br.com.previsao.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CidadeDTO extends AbstractDTO {

    @NotNull(message = "identificador nao pode ser nulo")
    private Long identificador;

    @NotNull(message = "Nome nao pode ser nulo")
    @NotBlank(message = "Nome nao pode ser vazio")
    private String nome;

    @NotNull(message = "Sigla pais nao pode ser nulo")
    @NotBlank(message = "Sigla pais nao pode ser vazio")
    private String siglaPais;

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiglaPais() {
        return siglaPais;
    }

    public void setSiglaPais(String siglaPais) {
        this.siglaPais = siglaPais;
    }
}
