-- phpMyAdmin SQL Dump
-- version 4.1.0-beta2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 15, 2013 at 07:19 PM
-- Server version: 5.5.32-0ubuntu0.12.10.1
-- PHP Version: 5.4.6-1ubuntu1.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `HiJinksComms`
--

-- --------------------------------------------------------

--
-- Table structure for table `Announcement`
--

CREATE TABLE IF NOT EXISTS `Announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) NOT NULL,
  `text` text NOT NULL,
  `communityId` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `createdBy` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `communityId` (`communityId`),
  KEY `createdBy` (`createdBy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Community`
--

CREATE TABLE IF NOT EXISTS `Community` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `owner` int(11) NOT NULL,
  `description` varchar(100) NOT NULL,
  `keywords` varchar(100) NOT NULL DEFAULT '',
  `keywordsEnabled` tinyint(1) NOT NULL,
  `visibilityLevel` enum('open','private') NOT NULL,
  `accessLevel` enum('restricted','unrestricted') NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `owner` (`owner`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Invitation`
--

CREATE TABLE IF NOT EXISTS `Invitation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `communityId` int(11) NOT NULL,
  `invitedBy` int(11) NOT NULL,
  `invitee` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `communityId` (`communityId`,`invitedBy`,`invitee`),
  KEY `invitedBy` (`invitedBy`),
  KEY `invitee` (`invitee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Request`
--

CREATE TABLE IF NOT EXISTS `Request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `communityId` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `communityId` (`communityId`,`user`),
  KEY `user` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE IF NOT EXISTS `Users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(32) NOT NULL,
  `salt` varchar(32) NOT NULL,
  `type` enum('developer','tester','manager','') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Announcement`
--
ALTER TABLE `Announcement`
  ADD CONSTRAINT `Announcement_ibfk_2` FOREIGN KEY (`createdBy`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Announcement_ibfk_1` FOREIGN KEY (`communityId`) REFERENCES `Community` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Community`
--
ALTER TABLE `Community`
  ADD CONSTRAINT `Community_ibfk_1` FOREIGN KEY (`owner`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Invitation`
--
ALTER TABLE `Invitation`
  ADD CONSTRAINT `Invitation_ibfk_3` FOREIGN KEY (`invitee`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Invitation_ibfk_1` FOREIGN KEY (`communityId`) REFERENCES `Community` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Invitation_ibfk_2` FOREIGN KEY (`invitedBy`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Request`
--
ALTER TABLE `Request`
  ADD CONSTRAINT `Request_ibfk_2` FOREIGN KEY (`user`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Request_ibfk_1` FOREIGN KEY (`communityId`) REFERENCES `Community` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
