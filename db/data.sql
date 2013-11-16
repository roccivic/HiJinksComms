-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 16, 2013 at 09:08 PM
-- Server version: 5.5.34-0ubuntu0.12.04.1
-- PHP Version: 5.3.10-1ubuntu3.8

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Announcement`
--

INSERT INTO `Announcement` (`id`, `title`, `text`, `communityId`, `date`, `createdBy`) VALUES
(1, 'HiJinks web app begining', 'The beginning date of the HiJinks project is 29.08.2020. Until then chill out ...', 1, '2013-11-16 20:54:54', 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `Community`
--

INSERT INTO `Community` (`id`, `name`, `owner`, `description`, `keywords`, `keywordsEnabled`, `visibilityLevel`, `accessLevel`, `created`) VALUES
(1, 'SoftwareTeam1', 1, 'Community for software team 1', 'community,software,team,1', 1, 'open', 'unrestricted', '2013-11-16 20:47:03'),
(2, 'SoftwareDevTeam2', 4, 'Community for software development team 2', '', 0, 'open', 'restricted', '2013-11-16 20:50:56'),
(3, 'SoftwareTeam1&2', 1, 'Community for software teams 1 and 2', 'software,team,community,1,2', 1, 'private', 'restricted', '2013-11-16 20:57:14'),
(4, 'Managers', 1, 'Community for managers', 'software,manager,community', 1, 'private', 'unrestricted', '2013-11-16 20:59:21'),
(5, 'TEST1', 1, 'test 1', 'test', 1, 'open', 'unrestricted', '2013-11-16 21:04:29'),
(6, 'TEST2', 1, 'test 2', 'test', 1, 'open', 'unrestricted', '2013-11-16 21:04:42'),
(7, 'TEST3', 1, 'test 3', 'test', 1, 'open', 'unrestricted', '2013-11-16 21:04:58'),
(8, 'TEST4', 1, 'test 4', 'test', 1, 'open', 'unrestricted', '2013-11-16 21:05:06'),
(9, 'TEST5', 1, 'test 5', 'test', 1, 'open', 'unrestricted', '2013-11-16 21:05:21'),
(16, 'TEST6', 1, 'test 6', 'test', 1, 'open', 'unrestricted', '2013-11-16 21:06:52'),
(17, 'TEST7', 1, 'test 7', 'test', 1, 'open', 'unrestricted', '2013-11-16 21:06:52'),
(18, 'TEST8', 1, 'test 8', 'test', 1, 'open', 'unrestricted', '2013-11-16 21:06:52'),
(19, 'TEST5', 1, 'test 7', 'test', 1, 'open', 'unrestricted', '2013-11-16 21:06:52'),
(20, 'TEST5', 1, 'test 5', 'test', 1, 'open', 'unrestricted', '2013-11-16 21:06:52'),
(21, 'TEST9', 1, 'test 9', 'test', 1, 'open', 'unrestricted', '2013-11-16 21:06:52'),
(22, 'TEST10', 1, 'test 10', 'test', 1, 'open', 'unrestricted', '2013-11-16 21:06:52'),
(23, 'TEST11', 1, 'test 11', 'test', 1, 'open', 'unrestricted', '2013-11-16 21:06:52');

-- --------------------------------------------------------

--
-- Table structure for table `CommunityUsers`
--

CREATE TABLE IF NOT EXISTS `CommunityUsers` (
  `community` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  KEY `user` (`user`),
  KEY `community` (`community`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CommunityUsers`
--

INSERT INTO `CommunityUsers` (`community`, `user`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 5),
(2, 4),
(3, 1),
(3, 2),
(3, 3),
(3, 4),
(3, 5),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(16, 1),
(17, 1),
(18, 1),
(19, 1),
(20, 1),
(21, 1),
(22, 1),
(23, 1);

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
  `type` enum('developer','tester','manager') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`id`, `fname`, `lname`, `email`, `password`, `salt`, `type`) VALUES
(1, 'Michael', 'Holmes', 'michael.holmes@doesnotexist.com', '1a285d92fd529438d78647885ec87ffb', 'b0e603b215aa2da0e6c605301d79efe4', 'manager'),
(2, 'Steven', 'Obrian', 'stevan.obrian@doesnotexist.com', 'e8958f3d6b192507d3a979e6b0f5c4fe', '1a285d92fd529438d78647885ec87ffb', 'tester'),
(3, 'Kieran', 'Omahony', 'threetimes@doesnotexists.com', '0d76743dc32cda487f248341a735d88d', 'e8958f3d6b192507d3a979e6b0f5c4fe', 'developer'),
(4, 'Preslav', 'Petkov', 'preslav.petkov@mycit.ie', '9970371f7b276436fc8456b558cf192e', '0d76743dc32cda487f248341a735d88d', 'developer'),
(5, 'Rouslan', 'Placella', 'rouslan.placella@mycit.ie', 'e10adc3949ba59abbe56e057f20f883e', '9970371f7b276436fc8456b558cf192e', 'developer');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Announcement`
--
ALTER TABLE `Announcement`
  ADD CONSTRAINT `Announcement_ibfk_1` FOREIGN KEY (`communityId`) REFERENCES `Community` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Announcement_ibfk_2` FOREIGN KEY (`createdBy`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Community`
--
ALTER TABLE `Community`
  ADD CONSTRAINT `Community_ibfk_1` FOREIGN KEY (`owner`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `CommunityUsers`
--
ALTER TABLE `CommunityUsers`
  ADD CONSTRAINT `CommunityUsers_ibfk_1` FOREIGN KEY (`user`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `CommunityUsers_ibfk_2` FOREIGN KEY (`community`) REFERENCES `Community` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Invitation`
--
ALTER TABLE `Invitation`
  ADD CONSTRAINT `Invitation_ibfk_1` FOREIGN KEY (`communityId`) REFERENCES `Community` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Invitation_ibfk_2` FOREIGN KEY (`invitedBy`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Invitation_ibfk_3` FOREIGN KEY (`invitee`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Request`
--
ALTER TABLE `Request`
  ADD CONSTRAINT `Request_ibfk_1` FOREIGN KEY (`communityId`) REFERENCES `Community` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Request_ibfk_2` FOREIGN KEY (`user`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
