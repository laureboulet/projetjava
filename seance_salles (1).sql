-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 06, 2020 at 05:51 PM
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
-- Table structure for table `seance_salles`
--

DROP TABLE IF EXISTS `seance_salles`;
CREATE TABLE IF NOT EXISTS `seance_salles` (
  `Id_seance` int(11) NOT NULL,
  `Id_salles` int(11) NOT NULL,
  PRIMARY KEY (`Id_seance`,`Id_salles`),
  KEY `Id_salles` (`Id_salles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seance_salles`
--

INSERT INTO `seance_salles` (`Id_seance`, `Id_salles`) VALUES
(1, 1),
(2, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `seance_salles`
--
ALTER TABLE `seance_salles`
  ADD CONSTRAINT `seance_salles_ibfk_1` FOREIGN KEY (`Id_salles`) REFERENCES `salle` (`ID`),
  ADD CONSTRAINT `seance_salles_ibfk_2` FOREIGN KEY (`Id_seance`) REFERENCES `seance` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
