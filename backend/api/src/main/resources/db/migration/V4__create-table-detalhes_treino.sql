CREATE TABLE detalhes_treino (
    id BIGINT NOT NULL AUTO_INCREMENT,
    treino_id BIGINT,
    FOREIGN KEY (treino_id) REFERENCES treinos(id),
    exercicio_id BIGINT,
    FOREIGN KEY (exercicio_id) REFERENCES exercicios(id),
    series INT NOT NULL,
    repeticoes INT NOT NULL,
    tecnica VARCHAR(255),
    exercicio_adicional_id BIGINT,
    PRIMARY KEY(id)
);

