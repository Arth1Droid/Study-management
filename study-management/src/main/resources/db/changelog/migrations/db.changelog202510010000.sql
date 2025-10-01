--liquibase formatted sql
--changeset ArthDroid:20251001003
--comment: Criação da tabela ESTUDO
CREATE TABLE ESTUDO (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    disciplina_id BIGINT NOT NULL,
    data_inicio DATETIME,
    data_fim DATETIME,
    observacoes VARCHAR(500),
    CONSTRAINT fk_estudo_disciplina FOREIGN KEY (disciplina_id)
        REFERENCES DISCIPLINA(id)
        ON DELETE CASCADE
) ENGINE=InnoDB;
--rollback DROP TABLE ESTUDO;