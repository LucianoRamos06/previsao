CREATE SEQUENCE sequence_cidade;

CREATE TABLE cidade (
  id_cidade bigint NOT NULL,
  identificador bigint NOT NULL,
  nome character VARYING(255) NOT NULL,
  sigla_pais character VARYING(255) NOT NULL,
  CONSTRAINT pk_cidade PRIMARY KEY (id_cidade)
)

