CREATE DATABASE db_gta;
USE db_gta;

CREATE TABLE tb_partida (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    jogador VARCHAR(200) NOT NULL,
    pontuacao INT NOT NULL
);