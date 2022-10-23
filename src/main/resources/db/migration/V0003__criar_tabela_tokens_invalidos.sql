CREATE TABLE `tokens_invalidos` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `token` TEXT NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL
)