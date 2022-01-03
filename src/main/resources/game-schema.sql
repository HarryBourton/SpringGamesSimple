CREATE TABLE `game` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `genre` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `release_year` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
);