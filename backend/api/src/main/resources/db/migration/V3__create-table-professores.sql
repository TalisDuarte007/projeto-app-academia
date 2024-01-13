CREATE TABLE professor (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    usuario_id bigint,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);