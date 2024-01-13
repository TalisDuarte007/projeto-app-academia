-- Remover a constraint de chave estrangeira em treinos referente a aluno
ALTER TABLE treinos
DROP FOREIGN KEY treinos_ibfk_1;

-- Remover a tabela aluno
DROP TABLE IF EXISTS aluno;

-- Criar a tabela aluno corrigida
CREATE TABLE aluno (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_usuario BIGINT,
    id_professor BIGINT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_professor) REFERENCES professor(id)
);

-- Adicionar a constraint de chave estrangeira novamente
ALTER TABLE treinos
ADD CONSTRAINT treinos_ibfk_1
FOREIGN KEY (id_aluno) REFERENCES aluno(id);