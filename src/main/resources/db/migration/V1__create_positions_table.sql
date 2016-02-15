/**
 * Created: 15-feb-2016
 */
-- SET NAMES utf8;
-- SET time_zone = '+00:00';
-- SET foreign_key_checks = 0;
-- SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

-- DROP TABLE IF EXISTS `positions`;
CREATE TABLE `positions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agency` varchar(255) DEFAULT NULL,
  `closed` bit(1) NOT NULL,
  `company` varchar(255) DEFAULT NULL,
  `notes` varchar(10000) DEFAULT NULL,
  `point_of_contact` varchar(255) DEFAULT NULL,
  `position` varchar(255) NOT NULL,
  `salary_min` double NOT NULL,
  `salary_max` double NOT NULL,
  `specifications_link` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
