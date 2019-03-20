-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Gostitelj: 127.0.0.1
-- Čas nastanka: 14. mar 2019 ob 19.03
-- Različica strežnika: 10.1.35-MariaDB
-- Različica PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Zbirka podatkov: `zilkerdragutin`
--

-- --------------------------------------------------------

--
-- Struktura tabele `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `balance` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Odloži podatke za tabelo `account`
--

INSERT INTO `account` (`id`, `name`, `balance`) VALUES
(134, 'rob', 150),
(135, 'sean', 225),
(136, 'matt', 275);

-- --------------------------------------------------------

--
-- Struktura tabele `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `from_id` int(11) DEFAULT NULL,
  `to_id` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Odloži podatke za tabelo `transaction`
--

INSERT INTO `transaction` (`id`, `from_id`, `to_id`, `amount`, `status`) VALUES
(17, 134, 135, 50, 1),
(18, 135, 136, 100, 1),
(19, 134, 136, 200, 0),
(20, 136, 135, 125, 1);

--
-- Indeksi zavrženih tabel
--

--
-- Indeksi tabele `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indeksi tabele `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_t_idx` (`from_id`,`to_id`),
  ADD KEY `from_id` (`from_id`,`to_id`);

--
-- AUTO_INCREMENT zavrženih tabel
--

--
-- AUTO_INCREMENT tabele `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=137;

--
-- AUTO_INCREMENT tabele `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
