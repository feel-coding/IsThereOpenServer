-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema isthereopen
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema isthereopen
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `isthereopen` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `isthereopen` ;

-- -----------------------------------------------------
-- Table `isthereopen`.`bar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`bar` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `running_time` VARCHAR(255) NULL DEFAULT NULL,
  `avg_rate` DOUBLE NULL DEFAULT NULL,
  `current_state` TINYINT(4) NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`bar_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`bar_info` (
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`bar_info_review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`bar_info_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `bar_seq` BIGINT(20) UNSIGNED NOT NULL,
  `toilet` TINYINT(3) NULL DEFAULT NULL,
  `mood` TINYINT(3) NULL DEFAULT NULL,
  `main_acohole` TINYINT(4) NULL DEFAULT NULL,
  `price` TINYINT(3) NULL DEFAULT NULL,
  `open_style` TINYINT(3) NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`bar_open_review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`bar_open_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `bar_seq` BIGINT(20) UNSIGNED NOT NULL,
  `open_state` TINYINT(4) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`bar_patron`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`bar_patron` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `bar_seq` BIGINT(20) UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`cafe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`cafe` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `running_time` VARCHAR(255) NULL DEFAULT NULL,
  `avg_rate` DOUBLE NULL DEFAULT NULL,
  `current_state` TINYINT(3) NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`cafe_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`cafe_info` (
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`cafe_info_review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`cafe_info_review` (
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`cafe_open_review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`cafe_open_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `cafe_seq` BIGINT(20) UNSIGNED NOT NULL,
  `open_state` TINYINT(4) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`cafe_patron`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`cafe_patron` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `cafe_seq` BIGINT(20) UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`restaurant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`restaurant` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `running_time` VARCHAR(255) NULL DEFAULT NULL,
  `avg_rate` DOUBLE NULL DEFAULT NULL,
  `current_state` TINYINT(4) NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`restaurant_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`restaurant_info` (
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`restaurant_info_review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`restaurant_info_review` (
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`restaurant_open_review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`restaurant_open_review` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `restaurant_seq` BIGINT(20) UNSIGNED NOT NULL,
  `open_state` TINYINT(4) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`restaurant_patron`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`restaurant_patron` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `restaurant_seq` BIGINT(20) UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `isthereopen`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isthereopen`.`user` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `isthereopen`.`user_auth` (
  `seq` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_seq` BIGINT(20) UNSIGNED NOT NULL,
  `type` TINYINT(3) UNSIGNED NOT NULL,
  `id` VARCHAR(255) NOT NULL,
  `pw` VARCHAR(255) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
