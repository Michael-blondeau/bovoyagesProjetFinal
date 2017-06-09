-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: localhost    Database: bovoyage
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dates_voyages`
--
DROP DATABASE IF EXISTS `bovoyage`;
CREATE DATABASE IF NOT EXISTS `bovoyage` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `bovoyage`;


DROP TABLE IF EXISTS `dates_voyages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dates_voyages` (
  `pk_date_voyage` int(11) NOT NULL AUTO_INCREMENT,
  `date_depart` datetime DEFAULT NULL,
  `date_retour` datetime DEFAULT NULL,
  `nb_voyageurs` int(11) DEFAULT NULL,
  `prixHT` double DEFAULT NULL,
  `fk_destination` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_date_voyage`),
  KEY `FKtp66myrd7xxmkxot7agqra4nq` (`fk_destination`),
  CONSTRAINT `FKtp66myrd7xxmkxot7agqra4nq` FOREIGN KEY (`fk_destination`) REFERENCES `destinations` (`pk_destination`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `dates_voyages` (`pk_date_voyage`, `date_depart`, `date_retour`,`nb_voyageurs`, `prixHT`, `fk_destination`) VALUES
(1, '2017-06-12 00:00:00', '2017-06-24 00:00:00',2, 359, 1),
(2, '2017-08-01 00:00:00', '2017-08-15 00:00:00',3, 1450, 1),
(3, '2017-09-03 00:00:00', '2017-09-15 00:00:00',1, 1420, 1),
(4, '2017-06-03 00:00:00', '2017-06-15 00:00:00',4, 1250, 2),
(5, '2017-07-08 00:00:00', '2017-07-18 00:00:00',2, 1300, 2),
(6, '2017-07-02 00:00:00', '2017-07-15 00:00:00',1, 1700, 3),
(7, '2017-11-12 00:00:00', '2017-11-25 00:00:00',3, 1890, 3),
(8, '2017-12-27 00:00:00', '2017-01-10 00:00:00',5, 2200, 4);



DROP TABLE IF EXISTS `destinations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destinations` (
  `pk_destination` int(11) NOT NULL AUTO_INCREMENT,
  `continent` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `pays` varchar(255) DEFAULT NULL,
  `promotion` bit(1) NOT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_destination`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `destinations` (`pk_destination`, `continent`, `region`, `pays`, `description`, `promotion`) VALUES
(1, 'Amerique du nord','Guadeloupe', 'France', 'Dans un site exceptionnel,en bordure d''un petit lagon turquoise, tout est réuni pour un séjour paradisiaque à la découverte des merveilles de la terre et de la mer', TRUE),
(2, 'Amerique du nord','Saint-Barthélémy', 'France', 'Imaginez une île où il fait 26 à 28 °C toute l''année, et où la température de la mer est la même que celle de l''air',TRUE),
(3, 'Asie','Myanmar', 'Birmanie', 'La Birmanie est un pays passionnat pour tous ceux qui s''interessent à l''art, aux civilisations, à l''inddhouisme. Ce pays s''ouvre et a conservé toute la richesse de son patrimoine culturel',FALSE),
(4, 'Amerique du nord','Canada', 'Canada', 'Découvrez la nature généreuse et les grandes villes du Canada en toute saison, grâce aux nombreux circuits que nous avons élaborés.',FALSE),
(5, 'Europe','Alpes suisses', 'Suisse', 'Venez découvrir les paysages somptueux de la Suisse, aussi bien en été qu''en hiver.',FALSE);


-- Dump completed on 2017-06-09 10:32:19
