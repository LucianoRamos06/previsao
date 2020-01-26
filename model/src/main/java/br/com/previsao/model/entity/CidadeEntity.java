package br.com.previsao.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
@SequenceGenerator(name  = "SQ_GENERATOR", sequenceName = "sequence_cidade", initialValue = 1, allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name="id_cidade"))
public class CidadeEntity extends AbstractEntity {

    private static final long serialVersionUID = 2721327294325727271L;

    @Column(name = "identificador")
    private Long identificador;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sigla_pais")
    private String siglaPais;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
