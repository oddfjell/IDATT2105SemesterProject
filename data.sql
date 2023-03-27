-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: mysql.stud.ntnu.no
-- Generation Time: 27. Mar, 2023 23:38 PM
-- Tjener-versjon: 8.0.32-0ubuntu0.22.04.2
-- PHP Version: 7.4.3-4ubuntu2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `emiloo_fullstack`
--

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `address`
--

CREATE TABLE `address` (
  `address_id` int NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `postal_code` int DEFAULT NULL,
  `street_name` varchar(255) DEFAULT NULL,
  `street_number` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dataark for tabell `address`
--

INSERT INTO `address` (`address_id`, `city`, `country`, `postal_code`, `street_name`, `street_number`) VALUES
(102, 'Molde', 'Norge', 6416, 'Herman Krags veg', '21');

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `address_seq`
--

CREATE TABLE `address_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dataark for tabell `address_seq`
--

INSERT INTO `address_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `category`
--

CREATE TABLE `category` (
  `id` int NOT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `category_seq`
--

CREATE TABLE `category_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dataark for tabell `category_seq`
--

INSERT INTO `category_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `item`
--

CREATE TABLE `item` (
  `item_id` int NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `brief_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `for_sale` bit(1) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `user` int DEFAULT NULL,
  `user_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dataark for tabell `item`
--

INSERT INTO `item` (`item_id`, `title`, `price`, `brief_description`, `description`, `image_url`, `for_sale`, `image`, `user`, `user_id`) VALUES
(1252, 'bob2', 2, '2', '2', NULL, NULL, 'https://i2-prod.mirror.co.uk/incoming/article26894483.ece/ALTERNATES/s1200c/1_TRMRMMGLPICT000021143162.jpg', 802, NULL),
(1302, 'Bob3', 2, '10', '10', NULL, NULL, 'https://i2-prod.mirror.co.uk/incoming/article26894483.ece/ALTERNATES/s1200c/1_TRMRMMGLPICT000021143162.jpg', 802, NULL),
(1352, 'Bob4', 2, '10', '2', NULL, NULL, 'https://i2-prod.mirror.co.uk/incoming/article26894483.ece/ALTERNATES/s1200c/1_TRMRMMGLPICT000021143162.jpg', 802, NULL),
(1402, 'Bob5', 2, '2', '2', NULL, NULL, 'https://i2-prod.mirror.co.uk/incoming/article26894483.ece/ALTERNATES/s1200c/1_TRMRMMGLPICT000021143162.jpg', 802, NULL),
(1452, 'Bob6', 2, '2', '2', NULL, NULL, 'https://i2-prod.mirror.co.uk/incoming/article26894483.ece/ALTERNATES/s1200c/1_TRMRMMGLPICT000021143162.jpg', 802, NULL),
(1502, 'Bob6', 2, '2', '2', NULL, NULL, 'https://i2-prod.mirror.co.uk/incoming/article26894483.ece/ALTERNATES/s1200c/1_TRMRMMGLPICT000021143162.jpg', 802, NULL);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `item_category`
--

CREATE TABLE `item_category` (
  `item_id` int NOT NULL,
  `category_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `item_seq`
--

CREATE TABLE `item_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dataark for tabell `item_seq`
--

INSERT INTO `item_seq` (`next_val`) VALUES
(1601);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `user`
--

CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `first_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `date_of_birth` date NOT NULL,
  `registered` date NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dataark for tabell `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`, `first_name`, `last_name`, `email`, `phone_number`, `date_of_birth`, `registered`, `role`, `address_id`, `image_url`, `image`) VALUES
(0, 'Sjokoladepudden', 'password', 'Emil', 'Olsson', 'emilols.eo@gmail.com', '92225477', '2014-10-20', '2023-03-24', NULL, 102, NULL, NULL),
(502, 'oddfjell', 'hei', 'Odd', 'Fjell', 'odd@fjell.no', '90909090', '2002-12-31', '2023-03-27', NULL, 102, NULL, NULL),
(666, 'jonas', 'jonas', 'jonas', 'morkland', 'jonasmorkland@outlook.comm', '46846578', '2000-01-25', '2023-03-27', 'USER-ADMIN', 102, 'test', NULL),
(802, 'Emiloo', 'test', 'Emil', 'Olsson', 'emilols.eo@gmail.no', '92225476', '2222-02-22', '2023-03-27', NULL, 102, NULL, NULL);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `user_seq`
--

CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dataark for tabell `user_seq`
--

INSERT INTO `user_seq` (`next_val`) VALUES
(951);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`address_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`item_id`),
  ADD KEY `FKbe7gmhlsuilujnl6bbkqlmexq` (`user`),
  ADD KEY `FKh4epdoqikj4sfedlxcc9dwwnl` (`user_id`);

--
-- Indexes for table `item_category`
--
ALTER TABLE `item_category`
  ADD KEY `FKpikirirfdxnbcpd4lod4ig34c` (`category_id`),
  ADD KEY `FKjlvge1dms1hf66yi8dkard983` (`item_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  ADD UNIQUE KEY `UK_4bgmpi98dylab6qdvf9xyaxu4` (`phone_number`),
  ADD KEY `FKddefmvbrws3hvl5t0hnnsv8ox` (`address_id`);

--
-- Begrensninger for dumpede tabeller
--

--
-- Begrensninger for tabell `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `FKbe7gmhlsuilujnl6bbkqlmexq` FOREIGN KEY (`user`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKh4epdoqikj4sfedlxcc9dwwnl` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Begrensninger for tabell `item_category`
--
ALTER TABLE `item_category`
  ADD CONSTRAINT `FKjlvge1dms1hf66yi8dkard983` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`),
  ADD CONSTRAINT `FKpikirirfdxnbcpd4lod4ig34c` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Begrensninger for tabell `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKddefmvbrws3hvl5t0hnnsv8ox` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
