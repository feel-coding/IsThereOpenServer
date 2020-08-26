SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `isthereopen`;

CREATE TABLE `bar` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `running_time` VARCHAR(255) NULL DEFAULT NULL,
  `avg_rate` DOUBLE NULL DEFAULT NULL,
  `phone_num` VARCHAR(45) DEFAULT NULL,
  `current_state` TINYINT(4) NULL DEFAULT NULL,
  `photo_url` VARCHAR(255) NULL,
  `last_update` DATETIME DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `bar_info_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `bar_seq` BIGINT(20) UNSIGNED NOT NULL,
  `rate` TINYINT(4) NULL DEFAULT NULL,
  `toilet` TINYINT(3) NULL DEFAULT NULL,
  `mood` TINYINT(3) NULL DEFAULT NULL,
  `main_alcohol` TINYINT(4) NULL DEFAULT NULL,
  `price` TINYINT(3) NULL DEFAULT NULL,
  `cleanness` TINYINT(3) NULL DEFAULT NULL,
  `open_style` TINYINT(3) NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `bar_open_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `bar_seq` BIGINT(20) UNSIGNED NOT NULL,
  `open_state` TINYINT(4) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `patron_bar` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `bar_seq` BIGINT(20) UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `cafe` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `phone_num` VARCHAR(45) DEFAULT NULL,
  `running_time` VARCHAR(255) NULL DEFAULT NULL,
  `avg_rate` DOUBLE NULL DEFAULT NULL,
  `current_state` TINYINT(3) NULL DEFAULT NULL,
  `photo_url` VARCHAR(255) DEFAULT NULL,
  `last_update` DATETIME DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `cafe_info_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `cafe_seq` BIGINT(20) UNSIGNED NOT NULL,
  `waiting_time` TINYINT(4) NULL DEFAULT NULL,
  `price` TINYINT(4) NULL DEFAULT NULL,
  `customer_num` TINYINT(4) NULL DEFAULT NULL,
  `plug_num` TINYINT(4) NULL DEFAULT NULL,
  `rate` TINYINT(5) NULL DEFAULT NULL,
  `table_height` TINYINT(4) NULL DEFAULT NULL,
  `lightness` TINYINT(4) NULL DEFAULT NULL,
  `stay_long` TINYINT(4) NULL DEFAULT NULL,
  `open_style` TINYINT(4) NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `cafe_open_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `cafe_seq` BIGINT(20) UNSIGNED NOT NULL,
  `open_state` TINYINT(4) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `patron_cafe` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `cafe_seq` BIGINT(20) UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `restaurant` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `phone_num` VARCHAR(45) DEFAULT NULL,
  `running_time` VARCHAR(255) NULL DEFAULT NULL,
  `avg_rate` DOUBLE NULL DEFAULT NULL,
  `current_state` TINYINT(4) NULL DEFAULT NULL,
  `photo_url` VARCHAR(255) DEFAULT NULL,
  `last_update` DATETIME DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `restaurant_info_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `restaurant_seq` BIGINT(20) UNSIGNED NOT NULL,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `rate` TINYINT(4) NULL DEFAULT NULL,
  `waiting_time` TINYINT(4) NULL DEFAULT NULL,
  `cleanness` TINYINT(4) NULL DEFAULT NULL,
  `price` TINYINT(4) NULL DEFAULT NULL,
  `take_out` TINYINT(4) NULL DEFAULT NULL,
  `eat_alone` TINYINT(4) NULL DEFAULT NULL,
  `open_style` TINYINT(4) NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `restaurant_open_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `restaurant_seq` BIGINT(20) UNSIGNED NOT NULL,
  `open_state` TINYINT(4) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `patron_restaurant` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `restaurant_seq` BIGINT(20) UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `user` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4;
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `user_auth` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `type` TINYINT(3) UNSIGNED NOT NULL,
  `id` VARCHAR(255) NOT NULL,
  `pw` VARCHAR(255) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
