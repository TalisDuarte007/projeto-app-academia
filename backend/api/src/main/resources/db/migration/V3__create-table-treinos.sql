CREATE TABLE treinos (
    id bigint NOT NULL AUTO_INCREMENT,
    tipo_treino varchar(100) NOT NULL,
    aluno_id bigint, -- Alteração para bigint
    FOREIGN KEY (aluno_id) REFERENCES alunos(id),
    PRIMARY KEY(id)
);