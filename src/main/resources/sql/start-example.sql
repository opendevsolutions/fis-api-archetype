CREATE DATABASE IF NOT EXISTS `demo`;
USE `demo`;

CREATE TABLE IF NOT EXISTS `TableExample` (
  `id` int(11) DEFAULT NULL
);

INSERT IGNORE INTO `TableExample` (`id`) VALUES
	(1);
