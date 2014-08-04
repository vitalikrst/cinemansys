SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cinedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cinedb` ;
CREATE SCHEMA IF NOT EXISTS `cinedb` DEFAULT CHARACTER SET utf8 ;
USE `cinedb` ;

-- -----------------------------------------------------
-- Table `cinedb`.`employees`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinedb`.`employees` ;

CREATE TABLE IF NOT EXISTS `cinedb`.`employees` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Group` VARCHAR(32) NOT NULL,
  `Password` VARCHAR(32) NULL DEFAULT NULL,
  `Active` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinedb`.`halls`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinedb`.`halls` ;

CREATE TABLE IF NOT EXISTS `cinedb`.`halls` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinedb`.`movies`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinedb`.`movies` ;

CREATE TABLE IF NOT EXISTS `cinedb`.`movies` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(255) NULL DEFAULT NULL,
  `ImageLink` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinedb`.`operations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinedb`.`operations` ;

CREATE TABLE IF NOT EXISTS `cinedb`.`operations` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `OperationType` INT(11) NOT NULL,
  `Date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Employee_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `toEmployees_idx` (`Employee_id` ASC),
  CONSTRAINT `toEmployees`
    FOREIGN KEY (`Employee_id`)
    REFERENCES `cinedb`.`employees` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinedb`.`reservations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinedb`.`reservations` ;

CREATE TABLE IF NOT EXISTS `cinedb`.`reservations` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Phone` VARCHAR(16) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinedb`.`seats`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinedb`.`seats` ;

CREATE TABLE IF NOT EXISTS `cinedb`.`seats` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `row` INT(11) NOT NULL,
  `seat` INT(11) NOT NULL,
  `Hall_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `toHalls_idx` (`Hall_id` ASC),
  CONSTRAINT `toHalls`
    FOREIGN KEY (`Hall_id`)
    REFERENCES `cinedb`.`halls` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinedb`.`sessions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinedb`.`sessions` ;

CREATE TABLE IF NOT EXISTS `cinedb`.`sessions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Status` INT(11) NOT NULL,
  `Hall_id` INT(11) NOT NULL,
  `Movie_id` INT(11) NOT NULL,
  `Price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `toMovies_idx` (`Movie_id` ASC),
  INDEX `toHalls_idx` (`Hall_id` ASC),
  CONSTRAINT `toHalls2`
    FOREIGN KEY (`Hall_id`)
    REFERENCES `cinedb`.`halls` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `toMovies`
    FOREIGN KEY (`Movie_id`)
    REFERENCES `cinedb`.`movies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinedb`.`tickets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinedb`.`tickets` ;

CREATE TABLE IF NOT EXISTS `cinedb`.`tickets` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Session_id` INT(11) NOT NULL,
  `Status` INT(11) NOT NULL,
  `Reservation_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `toSessions_idx` (`Session_id` ASC),
  INDEX `fk_Tickets_Reservations1_idx` (`Reservation_id` ASC),
  CONSTRAINT `fk_Tickets_Reservations1`
    FOREIGN KEY (`Reservation_id`)
    REFERENCES `cinedb`.`reservations` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `toSessions`
    FOREIGN KEY (`Session_id`)
    REFERENCES `cinedb`.`sessions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
