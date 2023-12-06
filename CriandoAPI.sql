-- Criar um banco de dados (se não existir)
CREATE DATABASE IF NOT EXISTS Escola;

-- Selecionar o banco de dados
USE Escola;

-- Criar tabela para armazenar informações de presença
CREATE TABLE IF NOT EXISTS Presenca (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_aluno VARCHAR(100) NOT NULL,
    data_presenca DATE NOT NULL,
    presente BOOLEAN NOT NULL
);

-- Inserir exemplos de dados
INSERT INTO Presenca (nome_aluno, data_presenca, presente) VALUES
('João', '2023-12-06', true),
('Maria', '2023-12-06', false),
('Pedro', '2023-12-06', true);

-- Selecionar todos os registros da tabela
SELECT * FROM Presenca;
