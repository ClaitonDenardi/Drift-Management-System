DROP DATABASE IF EXISTS pgbd;
CREATE DATABASE IF NOT EXISTS pgbd;
USE pgbd;

DROP TABLE IF EXISTS corrida;
DROP TABLE IF EXISTS piloto;
DROP TABLE IF EXISTS evento;

CREATE TABLE IF NOT EXISTS evento (
    id_evento            INTEGER          AUTO_INCREMENT,
    nome_evento          VARCHAR(255)     NOT NULL,
    descricao_evento     VARCHAR(255)     NULL,
    autodromo            VARCHAR(255)     NOT NULL,
    circuito             VARCHAR(255)     NOT NULL,
    data_inicio          DATE             NOT NULL,
    data_fim             DATE             NOT NULL,
    PRIMARY KEY          (id_evento)
);

CREATE TABLE IF NOT EXISTS piloto (
    id_piloto	         INTEGER          AUTO_INCREMENT,
    nome_piloto          VARCHAR(255)     NOT NULL,
    genero               CHAR(1)          NOT NULL,
    veiculo		 VARCHAR(255)     NOT NULL,
    ano_veiculo          INTEGER          NOT NULL,
    hp                   INTEGER          NOT NULL,
    PRIMARY KEY          (id_piloto)
);

CREATE TABLE IF NOT EXISTS corrida (
    id_corrida           INTEGER          AUTO_INCREMENT,
    id_piloto	         INTEGER          NOT NULL,
    id_evento            INTEGER          NOT NULL,
    titulo               VARCHAR(255)     NOT NULL,
    pontos               INTEGER          NULL,
    data_corrida         DATE             NOT NULL,
    hora_inicio          TIME         	  NOT NULL,
    hora_fim             TIME             NOT NULL,
    PRIMARY KEY          (id_corrida),
    FOREIGN KEY          (id_piloto) REFERENCES piloto (id_piloto),
    FOREIGN KEY          (id_evento) REFERENCES evento (id_evento) ON DELETE CASCADE
);
