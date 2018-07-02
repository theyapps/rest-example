-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema phonebook
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `phonebook` ;

-- -----------------------------------------------------
-- Schema phonebook
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `phonebook` DEFAULT CHARACTER SET utf8 ;
USE `phonebook` ;

-- -----------------------------------------------------
-- Table `phonebook`.`phonebook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phonebook`.`phonebook` ;

CREATE TABLE IF NOT EXISTS `phonebook`.`phonebook` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(255) NULL,
  `lastname` VARCHAR(255) NULL,
  `phonenumber` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO phonebook(firstname, lastname, phonenumber) VALUES ("Jack","Smith","555-584-5485");
INSERT INTO phonebook(firstname, lastname, phonenumber) VALUES ("Jill","Smith","555-528-5587");
INSERT INTO phonebook(firstname, lastname, phonenumber) VALUES ("John","Doe","555-255-4842");
INSERT INTO phonebook(firstname, lastname, phonenumber) VALUES ("Bob","Brown","555-848-2548");
INSERT INTO phonebook(firstname, lastname, phonenumber) VALUES ("Bill","Black","555-658-2248");
INSERT INTO phonebook(firstname, lastname, phonenumber) VALUES ("Joe","Green","555-145-6586");
INSERT INTO phonebook(firstname, lastname, phonenumber) VALUES ("Sally","Grey","555-658-8854");