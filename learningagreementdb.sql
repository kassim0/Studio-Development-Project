-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 11 jan. 2023 à 01:09
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `learningagreementdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `credits` int(11) DEFAULT NULL,
  `definition` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `nationality` varchar(255) NOT NULL,
  `faculty` varchar(255) NOT NULL,
  `cycle_study` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `first_name`, `last_name`, `email`, `date_of_birth`, `nationality`, `faculty`, `cycle_study`, `role`, `password`) VALUES
(15, 'kassim', 'HADDAD', 'Kassim@haddad.com', '2023-01-10', 'French', 'computing', 'Master2', 'student', 'password'),
(16, 'test1', 'test', 'test1@test.com', '2023-01-11', 'pl', 'pc', '+5', 'student', 'test'),
(17, 'test2', 'test', 'test2@test.com', '2023-01-11', 'pl', 'pc', '+5', 'student', 'test'),
(18, 'test3', 'test', 'test3@test.com', '2023-01-11', 'pl', 'pc', '+5', 'student', 'test'),
(19, 'test4', 'test', 'test4@test.com', '2023-01-11', 'pl', 'pc', '+5', 'student', 'test'),
(20, 'test5', 'test', 'test5@test.com', '2023-01-11', 'pl', 'pc', '+5', 'student', 'test'),
(21, 'test6', 'test', 'test6@test.com', '2023-01-11', 'pl', 'pc', '+5', 'student', 'test'),
(22, 'test7', 'test', 'test7@test.com', '2023-01-11', 'pl', 'pc', '+5', 'student', 'test'),
(23, 'test8', 'test', 'test8@test.com', '2023-01-11', 'pl', 'pc', '+5', 'student', 'test'),
(24, 'test9', 'test', 'test9@test.com', '2023-01-11', 'pl', 'pc', '+5', 'student', 'test');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
