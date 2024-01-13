create table exercicios(
  id bigint not null auto_increment,
  nome varchar(100) not null unique,
  descricao varchar(255) not null,
  musculo_trabalhado VARCHAR(255) not null,
  categoria varchar(100) not null,
  link_gif TEXT,
  primary key(id)
);
