CREATE DATABASE IF NOT EXISTS TextSpectaclesDB;
USE TextSpectaclesDB;

CREATE TABLE IF NOT EXISTS shared_keys (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    role_name VARCHAR(20) NOT NULL,
    secret_key VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY uk_username (username)
);

CREATE TABLE IF NOT EXISTS messages (
    id INT PRIMARY KEY AUTO_INCREMENT,
    agent_name VARCHAR(50) NOT NULL,
    agent_id VARCHAR(3) NOT NULL,
    ciphertext TEXT NOT NULL,
    classification VARCHAR(10) NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_classification CHECK (classification IN ('Low', 'High', 'Critical'))
);

INSERT INTO shared_keys (username, role_name, secret_key)
VALUES ('agent1', 'agent', 'INITIAL_PLACEHOLDER_KEY')
ON DUPLICATE KEY UPDATE role_name = VALUES(role_name);
