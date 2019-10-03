-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 03, 2019 at 10:30 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";
CREATE Database codechef
use codechef

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `codechef`
--

-- --------------------------------------------------------

--
-- Table structure for table `albumentity`
--

CREATE TABLE `albumentity` (
  `albumid` int(11) NOT NULL,
  `albumname` varchar(255) DEFAULT NULL,
  `albumtype` int(11) DEFAULT NULL,
  `albumuser` varchar(255) DEFAULT NULL,
  `coverpicture` longblob DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `likescount` int(11) DEFAULT NULL,
  `timeofcreation` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `photoentity`
--

CREATE TABLE `photoentity` (
  `photoid` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `likescount` int(11) DEFAULT NULL,
  `photoalbum` int(11) DEFAULT NULL,
  `photodata` longblob DEFAULT NULL,
  `phototype` int(11) DEFAULT NULL,
  `photouser` varchar(255) DEFAULT NULL,
  `timeofcreation` datetime DEFAULT NULL,
  `albumid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `userentity`
--

CREATE TABLE `userentity` (
  `username` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `profilepicture` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `albumentity`
--
ALTER TABLE `albumentity`
  ADD PRIMARY KEY (`albumid`),
  ADD KEY `FKpuo2t8lwvfdklyhnu9hfrj2yh` (`username`);

--
-- Indexes for table `photoentity`
--
ALTER TABLE `photoentity`
  ADD PRIMARY KEY (`photoid`),
  ADD KEY `FK4a6mq0wg5ai9feyma1oan6w` (`albumid`);

--
-- Indexes for table `userentity`
--
ALTER TABLE `userentity`
  ADD PRIMARY KEY (`username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `albumentity`
--
ALTER TABLE `albumentity`
  ADD CONSTRAINT `FKpuo2t8lwvfdklyhnu9hfrj2yh` FOREIGN KEY (`username`) REFERENCES `userentity` (`username`);

--
-- Constraints for table `photoentity`
--
ALTER TABLE `photoentity`
  ADD CONSTRAINT `FK4a6mq0wg5ai9feyma1oan6w` FOREIGN KEY (`albumid`) REFERENCES `albumentity` (`albumid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
