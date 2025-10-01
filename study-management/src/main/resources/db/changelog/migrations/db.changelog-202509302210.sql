--liquibase formatted sql
--changeset ArthDroid1:20250902210
--comment Criação da tabela DISCIPLINA

CREATE TABLE DISCIPLINA (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(500),
    horas_planejadas INT
) ENGINE=InnoDB;

--rollback DROP TABLE DISCIPLINA;
