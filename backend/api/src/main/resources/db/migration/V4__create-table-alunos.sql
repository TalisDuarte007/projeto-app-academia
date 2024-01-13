CREATE TABLE aluno (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_professor BIGINT,
    FOREIGN KEY (id) REFERENCES usuario(id),
    FOREIGN KEY (id_professor) REFERENCES professor(id)
);