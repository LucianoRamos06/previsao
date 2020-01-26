package br.com.previsao.model.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@DynamicUpdate
@DynamicInsert
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private static final Logger LOGGER = LogManager.getLogger(AbstractEntity.class);

    private static final long serialVersionUID = -4332441880662770068L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_GENERATOR")
    @Column(name = "id", nullable = false)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
