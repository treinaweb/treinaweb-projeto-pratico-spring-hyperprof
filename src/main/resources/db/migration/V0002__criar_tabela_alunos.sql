CREATE TABLE `alunos` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `professor_id` BIGINT NOT NULL,
    `nome` VARCHAR(100) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `data_aula` DATETIME NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL
);

ALTER TABLE `alunos` ADD FOREIGN KEY (`professor_id`) REFERENCES `professores` (`id`);