-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 04 jan. 2023 à 00:50
-- Version du serveur :  5.7.17
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bd_jfx`
--

-- --------------------------------------------------------

--
-- Structure de la table `adminlog`
--

CREATE TABLE `adminlog` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `adminlog`
--

INSERT INTO `adminlog` (`id`, `name`, `password`) VALUES
(1, 'adm', '000');

-- --------------------------------------------------------

--
-- Structure de la table `manag_log`
--

CREATE TABLE `manag_log` (
  `id_mang` int(11) NOT NULL,
  `nom` varchar(40) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `IDp` int(100) NOT NULL,
  `name` varchar(30) NOT NULL,
  `firstn` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `tel` varchar(9) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`IDp`, `name`, `firstn`, `date`, `tel`) VALUES
(27, 'ahmed', 'riali', '2023-01-04', '000'),
(26, 'mohammed', 'salhi', '2023-01-04', '22345'),
(25, 'feriel', 'dilmi', '2023-01-04', '0009809'),
(18, 'asma', 'chikour', '2023-01-03', '0000009'),
(19, 'asma', 'sili', '2023-01-03', '12345');

-- --------------------------------------------------------

--
-- Structure de la table `recu_vente`
--

CREATE TABLE `recu_vente` (
  `id_recu` int(11) NOT NULL,
  `id_vente` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `recu_vente`
--

INSERT INTO `recu_vente` (`id_recu`, `id_vente`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `stock`
--

CREATE TABLE `stock` (
  `ID_med` int(100) NOT NULL,
  `nom` varchar(40) NOT NULL,
  `grammage` int(100) NOT NULL COMMENT 'mg',
  `qte` int(100) NOT NULL DEFAULT '0',
  `categorie` varchar(40) NOT NULL,
  `prix` int(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `stock`
--

INSERT INTO `stock` (`ID_med`, `nom`, `grammage`, `qte`, `categorie`, `prix`) VALUES
(1, 'a', 10, 1, 'abc', 100);

-- --------------------------------------------------------

--
-- Structure de la table `vendeur`
--

CREATE TABLE `vendeur` (
  `id_v` int(100) NOT NULL,
  `name` varchar(40) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vendeur`
--

INSERT INTO `vendeur` (`id_v`, `name`, `password`) VALUES
(1, 'v1', '00');

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

CREATE TABLE `vente` (
  `Id_vente` int(11) NOT NULL,
  `ID_med` int(100) NOT NULL,
  `id_v` int(11) NOT NULL,
  `ID_pat` int(100) NOT NULL,
  `qte_vendu` int(100) NOT NULL,
  `date_vente` date NOT NULL,
  `prix` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vente`
--

INSERT INTO `vente` (`Id_vente`, `ID_med`, `id_v`, `ID_pat`, `qte_vendu`, `date_vente`, `prix`) VALUES
(1, 1, 1, 1, 1, '2023-01-10', 100);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adminlog`
--
ALTER TABLE `adminlog`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `manag_log`
--
ALTER TABLE `manag_log`
  ADD PRIMARY KEY (`id_mang`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`IDp`);

--
-- Index pour la table `recu_vente`
--
ALTER TABLE `recu_vente`
  ADD PRIMARY KEY (`id_recu`);

--
-- Index pour la table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`ID_med`);

--
-- Index pour la table `vendeur`
--
ALTER TABLE `vendeur`
  ADD PRIMARY KEY (`id_v`);

--
-- Index pour la table `vente`
--
ALTER TABLE `vente`
  ADD PRIMARY KEY (`Id_vente`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adminlog`
--
ALTER TABLE `adminlog`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `manag_log`
--
ALTER TABLE `manag_log`
  MODIFY `id_mang` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `IDp` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT pour la table `recu_vente`
--
ALTER TABLE `recu_vente`
  MODIFY `id_recu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `stock`
--
ALTER TABLE `stock`
  MODIFY `ID_med` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `vendeur`
--
ALTER TABLE `vendeur`
  MODIFY `id_v` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `vente`
--
ALTER TABLE `vente`
  MODIFY `Id_vente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
