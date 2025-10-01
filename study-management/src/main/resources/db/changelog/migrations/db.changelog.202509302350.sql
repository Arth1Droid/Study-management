--liquibase formatted sql
--changeset ArthDroid:20251001002
--comment Criação da tabela PROGRESSO

CREATE TABLE PROGRESSO (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    disciplina_id BIGINT NOT NULL,
    horas_estudadas INT,
    data_atualizacao DATETIME,
    CONSTRAINT fk_progresso_disciplina FOREIGN KEY (disciplina_id)
        REFERENCES DISCIPLINA(id)
        ON DELETE CASCADE
) ENGINE=InnoDB;

--rollback DROP TABLE PROGRESSO;
