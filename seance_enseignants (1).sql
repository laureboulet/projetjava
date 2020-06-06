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
-- Table structure for table `seance_enseignants`
--

DROP TABLE IF EXISTS `seance_enseignants`;
CREATE TABLE IF NOT EXISTS `seance_enseignants` (
  `Id_seance` int(11) NOT NULL,
  `Id_enseignant` int(11) NOT NULL,
  PRIMARY KEY (`Id_seance`,`Id_enseignant`),
  KEY `Id_enseignant` (`Id_enseignant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seance_enseignants`
--

INSERT INTO `seance_enseignants` (`Id_seance`, `Id_enseignant`) VALUES
(1, 3),
(2, 5);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `seance_enseignants`
--
ALTER TABLE `seance_enseignants`
  ADD CONSTRAINT `seance_enseignants_ibfk_1` FOREIGN KEY (`Id_enseignant`) REFERENCES `enseignant` (`Id_utilisateur`),
  ADD CONSTRAINT `seance_enseignants_ibfk_2` FOREIGN KEY (`Id_seance`) REFERENCES `seance` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
