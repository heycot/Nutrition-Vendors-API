-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: freshfood
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `rating` double NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `phone` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `location_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `avatar` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `time_open` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `time_close` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sell` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comment_number` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `location_id` (`location_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FKj97brjwss3mlgdt7t213tkchl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKjl9y19hmcqv2p393qj1y8yxpg` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `shop_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES (4,'Quán Cô Nga',3.6,'2019-04-16 04:54:35','0336025122',1,2,'conga.jpg',1,'7:00','18:00','Trái Cây',0),(6,'Quán Cô Tavia',0,'2019-04-16 04:54:35','0336025122',3,3,'cotavia.jpg',1,'7:00','18:00','Gia Vị',0),(7,'Quán Cô Quý',0,'2019-04-16 04:54:35','0336025122',2,4,'coquy.jpg',1,'7:00','18:00','Rau Củ',0),(8,'Quán Cô Bảo',0,'2019-04-16 04:54:35','0336025122',10,4,'cobao.jpg',1,'7:00','18:00','Ngũ Cốc',0),(9,'Quán Cô An',0,'2019-04-16 04:54:35','0336025122',7,5,'coan.jpg',1,'7:00','18:00','Thịt',0),(10,'Quán Cô Cường Mập',0,'2019-04-16 04:54:35','0336025122',4,6,'cocuongmap.jpg',1,'7:00','18:00','Hải Sản',0),(11,'Quán Cô Định',0,'2019-04-16 04:54:35','0336025122',5,7,'codinh.jpg',1,'8:00','17:00',NULL,0),(13,'Quán Cô Nam',0,'2019-04-16 04:54:35','0336025122',9,8,'conam.jpg',1,'8:00','17:00',NULL,0),(14,'Quán Cô Cường Gầy',0,'2019-04-16 04:54:35','0336025122',8,9,'cocuonggay.jpg',1,'10:00','17:00',NULL,0);
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-26 15:38:44
