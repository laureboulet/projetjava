-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 06, 2020 at 05:50 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Semaine` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Heure_debut` int(11) NOT NULL,
  `Heure_fin` int(11) NOT NULL,
  `Etat` int(11) NOT NULL,
  `ID_cours` int(11) NOT NULL,
  `ID_type` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_cours` (`ID_cours`),
  KEY `ID_type` (`ID_type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seance`
--

INSERT INTO `seance` (`ID`, `Semaine`, `Date`, `Heure_debut`, `Heure_fin`, `Etat`, `ID_cours`, `ID_type`) VALUES
(1, 4, '2000-09-12', 1230, 1400, 1, 1, 1),
(2, 5, '2020-05-06', 1700, 19, 1, 2, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `seance_ibfk_1` FOREIGN KEY (`ID_cours`) REFERENCES `cours` (`ID`),
  ADD CONSTRAINT `seance_ibfk_2` FOREIGN KEY (`ID_type`) REFERENCES `type_cours` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
