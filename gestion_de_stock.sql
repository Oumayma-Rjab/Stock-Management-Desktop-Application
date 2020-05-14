-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 14, 2020 at 02:36 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestion_de_stock`
--

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_produit` varchar(50) DEFAULT NULL,
  `reference` varchar(50) DEFAULT NULL,
  `desegnation` varchar(50) DEFAULT NULL,
  `rangement` varchar(50) DEFAULT NULL,
  `fournisseur` varchar(50) DEFAULT NULL,
  `remise` int(11) DEFAULT NULL,
  `prix` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`id`, `code_produit`, `reference`, `desegnation`, `rangement`, `fournisseur`, `remise`, `prix`, `stock`) VALUES
(5, '125', 'réf6', 'hp', 'r1', 'ali', 4, 100, 497),
(6, '128', 'réf8', 'asus', 'r55', 'f1', 10, 650, 95),
(7, '965', 'réf1005', 'iphone', 'r89', 'jack', 1, 900, 50);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `id_user`, `username`, `password`, `type`) VALUES
(1, 1, 'd', 'd', 'directeur'),
(2, 2, 'c', 'c', 'cashier'),
(4, 3, 'oumayma', 'azerty', 'directeur'),
(5, 3, 'arij', 'azerty', 'cachier ');

-- --------------------------------------------------------

--
-- Table structure for table `vente`
--

DROP TABLE IF EXISTS `vente`;
CREATE TABLE IF NOT EXISTS `vente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_facture` varchar(50) DEFAULT NULL,
  `code_produit` int(11) DEFAULT NULL,
  `reference` varchar(50) DEFAULT NULL,
  `prix_vente` int(11) DEFAULT NULL,
  `stock_sortie` int(11) DEFAULT NULL,
  `subtotal` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vente`
--

INSERT INTO `vente` (`id`, `num_facture`, `code_produit`, `reference`, `prix_vente`, `stock_sortie`, `subtotal`) VALUES
(13, '10', 6, 'réf8', 585, 2, 1170),
(15, '10', 5, 'réf6', 96, 1, 96),
(18, '22', 965, 'réf1005', 891, 5, 4455),
(19, '11', 128, 'réf8', 585, 1, 585),
(20, '123', 125, 'réf6', 96, 100, 9600);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
