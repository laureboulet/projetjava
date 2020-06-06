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
-- Table structure for table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_utilisateur` int(11) NOT NULL,
  `Numero` int(11) NOT NULL,
  `ID_groupe` int(11) NOT NULL,
  PRIMARY KEY (`ID_utilisateur`),
  KEY `ID_groupe` (`ID_groupe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`ID_utilisateur`, `Numero`, `ID_groupe`) VALUES
(4, 4, 5);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`ID_utilisateur`) REFERENCES `utilisateur` (`ID`),
  ADD CONSTRAINT `etudiant_ibfk_2` FOREIGN KEY (`ID_groupe`) REFERENCES `groupe` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
