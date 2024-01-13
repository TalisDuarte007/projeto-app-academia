CREATE TABLE treinos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_aluno BIGINT, -- Corrigido para 'BIGINT'
    FOREIGN KEY (id_aluno) REFERENCES aluno(id),
    nome_treino VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);