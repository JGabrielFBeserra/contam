CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_completo VARCHAR(255) NOT NULL,
    primeiro_nome VARCHAR(255) NOT NULL,
    ultimo_nome VARCHAR(255) NOT NULL,
    nome_usuario VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) UNIQUE,
    matricula VARCHAR(30) UNIQUE,
    senha VARCHAR(255) NOT NULL,
    status TINYINT(1) NOT NULL DEFAULT 1
)
