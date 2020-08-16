DROP TABLE IF EXISTS `bar`;
DROP TABLE IF EXISTS `bar_info`;
DROP TABLE IF EXISTS `bar_info_review`;
DROP TABLE IF EXISTS `bar_open_review`;
DROP TABLE IF EXISTS `bar_patron`;
DROP TABLE IF EXISTS `cafe`;
DROP TABLE IF EXISTS `cafe_info`;
DROP TABLE IF EXISTS `cafe_info_review`;
DROP TABLE IF EXISTS `cafe_open_review`;
DROP TABLE IF EXISTS `cafe_patron`;
DROP TABLE IF EXISTS `restaurant`;
DROP TABLE IF EXISTS `restaurant_info`;
DROP TABLE IF EXISTS `restaurant_info_review`;
DROP TABLE IF EXISTS `restaurant_open_review`;
DROP TABLE IF EXISTS `restaurant_patron`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `user_auth`;

CREATE SCHEMA IF NOT EXISTS `isthereopen`;

CREATE TABLE `bar` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `running_time` VARCHAR(255) NULL DEFAULT NULL,
  `avg_rate` DOUBLE NULL DEFAULT NULL,
  `current_state` TINYINT(4) NULL DEFAULT NULL,
  `photo_url` VARCHAR(255) DEFAULT NULL,
  `last_update` DATETIME DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `bar_info` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `bar_seq` BIGINT(20) UNSIGNED NOT NULL,
  `toilet` TINYINT(4) NULL DEFAULT NULL,
  `mood` TINYINT(4) NULL DEFAULT NULL,
  `main_acohole` TINYINT(4) NULL DEFAULT NULL,
  `price` TINYINT(4) NULL DEFAULT NULL,
  `open_style` TINYINT(4) NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `bar_info_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `bar_seq` BIGINT(20) UNSIGNED NOT NULL,
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

CREATE TABLE `bar_open_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `bar_seq` BIGINT(20) UNSIGNED NOT NULL,
  `open_state` TINYINT(4) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `bar_patron` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `bar_seq` BIGINT(20) UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `cafe` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `running_time` VARCHAR(255) NULL DEFAULT NULL,
  `avg_rate` DOUBLE NULL DEFAULT NULL,
  `current_state` TINYINT(3) NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `cafe_info` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `cafe_seq` BIGINT(20) UNSIGNED NOT NULL,
  `waiting_time` TINYINT(4) NULL DEFAULT NULL,
  `price` TINYINT(4) NULL DEFAULT NULL,
  `customer_num` TINYINT(4) NULL DEFAULT NULL,
  `plug_num` TINYINT(4) NULL DEFAULT NULL,
  `table_height` TINYINT(4) NULL DEFAULT NULL,
  `lightness` TINYINT(4) NULL DEFAULT NULL,
  `stay_long` TINYINT(4) NULL DEFAULT NULL,
  `open_style` TINYINT(4) NULL DEFAULT NULL,
  `avg_rate` DOUBLE NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `cafe_info_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `cafe_seq` BIGINT(20) UNSIGNED NOT NULL,
  `waiting_time` TINYINT(4) NULL DEFAULT NULL,
  `price` TINYINT(4) NULL DEFAULT NULL,
  `customer_num` TINYINT(4) NULL DEFAULT NULL,
  `plug_num` TINYINT(4) NULL DEFAULT NULL,
  `table_height` TINYINT(4) NULL DEFAULT NULL,
  `lightness` TINYINT(4) NULL DEFAULT NULL,
  `stay_long` TINYINT(4) NULL DEFAULT NULL,
  `open_style` TINYINT(4) NULL DEFAULT NULL,
  `avg_rate` DOUBLE NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `cafe_open_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `cafe_seq` BIGINT(20) UNSIGNED NOT NULL,
  `open_state` TINYINT(4) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `cafe_patron` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `cafe_seq` BIGINT(20) UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `restaurant` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `running_time` VARCHAR(255) NULL DEFAULT NULL,
  `avg_rate` DOUBLE NULL DEFAULT NULL,
  `current_state` TINYINT(4) NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `restaurant_info` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `restaurant_seq` BIGINT(20) UNSIGNED NOT NULL,
  `waiting_time` TINYINT(4) NULL DEFAULT NULL,
  `cleanness` TINYINT(4) NULL DEFAULT NULL,
  `price` TINYINT(4) NULL DEFAULT NULL,
  `takeout` TINYINT(4) NULL DEFAULT NULL,
  `eat_alone` TINYINT(4) NULL DEFAULT NULL,
  `open_style` TINYINT(4) NULL DEFAULT NULL,
  `avg_rate` DOUBLE NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `restaurant_info_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `restaurant_seq` BIGINT(20) UNSIGNED NOT NULL,
  `waiting_time` TINYINT(4) NULL DEFAULT NULL,
  `cleanness` TINYINT(4) NULL DEFAULT NULL,
  `price` TINYINT(4) NULL DEFAULT NULL,
  `takeout` TINYINT(4) NULL DEFAULT NULL,
  `eat_alone` TINYINT(4) NULL DEFAULT NULL,
  `open_style` TINYINT(4) NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `restaurant_open_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `restaurant_seq` BIGINT(20) UNSIGNED NOT NULL,
  `open_state` TINYINT(4) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `restaurant_patron` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `restaurant_seq` BIGINT(20) UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `user` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
DEFAULT CHARACTER SET = utf8mb4;

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

