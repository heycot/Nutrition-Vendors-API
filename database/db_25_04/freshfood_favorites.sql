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
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `favorites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `shopitem_id` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `shopitem_id` (`shopitem_id`),
  KEY `favorites_ibfk_2` (`user_id`),
  CONSTRAINT `FK1uphh0glinnprjknyl68k1hw1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKjaet6kpfcupnhurb722h8b5l3` FOREIGN KEY (`shopitem_id`) REFERENCES `shopitem` (`id`),
  CONSTRAINT `favorites_ibfk_1` FOREIGN KEY (`shopitem_id`) REFERENCES `shopitem` (`id`),
  CONSTRAINT `favorites_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` VALUES (1,2,26,1,'2019-04-10 10:19:50',NULL),(2,2,69,1,'2019-04-10 10:19:50',NULL),(3,2,58,1,'2019-04-10 10:19:50',NULL),(4,2,78,1,'2019-04-10 10:19:50',NULL),(5,2,68,1,'2019-04-10 10:19:50',NULL),(6,2,56,1,'2019-04-10 10:19:50',NULL),(7,2,84,1,'2019-04-10 10:19:50','2019-04-11 03:47:31'),(8,2,89,1,'2019-04-10 10:19:50',NULL),(9,2,156,1,'2019-03-30 03:45:01','2019-04-10 10:19:50'),(10,2,157,1,'2019-03-30 03:45:01','2019-04-11 03:22:46'),(11,2,135,1,'2019-03-30 03:45:01','2019-04-11 03:22:46'),(12,2,148,1,'2019-03-30 03:45:01','2019-04-11 03:22:46'),(14,3,135,1,'2019-03-30 03:45:01','2019-04-11 03:22:46'),(15,3,25,1,'2019-03-30 03:45:01','2019-04-11 03:22:46'),(16,3,15,1,'2019-03-30 03:45:01','2019-04-11 03:22:46'),(17,3,6,1,'2019-03-30 03:45:01','2019-04-11 03:22:46'),(18,3,65,1,'2019-03-30 03:45:01','2019-04-11 03:22:46'),(19,3,45,1,'2019-03-30 03:45:01','2019-04-11 03:22:46'),(20,3,89,1,'2019-03-30 03:45:01','2019-04-11 03:22:46'),(21,3,36,1,'2019-03-30 03:45:01','2019-04-11 03:22:46'),(23,3,25,1,'2019-03-30 03:45:01','2019-04-11 03:30:29'),(24,3,36,1,NULL,NULL),(25,3,14,1,NULL,NULL),(26,3,96,1,NULL,NULL),(27,3,56,1,NULL,NULL),(28,3,124,1,NULL,NULL),(29,3,123,1,NULL,NULL),(30,3,100,1,NULL,NULL),(31,3,101,1,NULL,NULL),(32,4,3,1,NULL,NULL),(33,4,32,1,NULL,NULL),(34,4,36,1,NULL,NULL),(36,4,25,1,NULL,NULL),(37,4,24,1,NULL,NULL),(39,4,15,1,NULL,NULL),(41,4,4,1,NULL,NULL),(42,4,45,1,NULL,NULL),(43,4,48,1,NULL,NULL),(44,4,102,1,NULL,NULL),(45,4,150,1,NULL,NULL),(46,4,145,1,NULL,NULL),(47,4,144,1,NULL,NULL),(48,4,146,1,NULL,NULL),(49,4,17,1,NULL,NULL),(50,4,65,1,NULL,NULL),(51,4,68,1,NULL,NULL),(52,4,59,1,NULL,NULL),(53,4,57,1,NULL,NULL),(54,4,69,1,NULL,NULL),(55,4,96,1,NULL,NULL),(56,4,85,1,NULL,NULL),(57,4,74,1,NULL,NULL),(58,5,4,1,NULL,NULL),(59,5,45,1,NULL,NULL),(60,5,46,1,NULL,NULL),(61,5,47,1,NULL,NULL),(62,5,48,1,NULL,NULL),(64,5,35,1,NULL,NULL),(65,5,29,1,NULL,NULL),(66,5,96,1,NULL,NULL),(67,5,85,1,NULL,NULL),(68,5,86,1,NULL,NULL),(69,5,84,1,NULL,NULL),(70,5,95,1,NULL,NULL),(71,5,91,1,NULL,NULL),(72,5,92,1,NULL,NULL),(73,5,93,1,NULL,NULL),(74,5,97,1,NULL,NULL),(75,5,125,1,NULL,NULL),(76,5,114,1,NULL,NULL),(77,5,118,1,NULL,NULL),(80,5,138,1,NULL,NULL),(82,5,12,1,NULL,NULL),(83,5,126,1,NULL,NULL),(84,5,127,1,NULL,NULL),(85,5,128,1,NULL,NULL),(86,5,135,1,NULL,NULL),(87,5,26,1,NULL,NULL),(89,6,18,1,NULL,NULL),(90,6,16,1,NULL,NULL),(91,6,14,1,NULL,NULL),(92,6,13,1,NULL,NULL),(93,6,125,1,NULL,NULL),(95,6,124,1,NULL,NULL),(96,6,126,1,NULL,NULL),(97,6,135,1,NULL,NULL),(98,6,136,1,NULL,NULL),(99,6,137,1,NULL,NULL),(100,6,125,1,NULL,NULL),(101,6,122,1,NULL,NULL),(102,6,16,1,NULL,NULL),(103,6,24,1,NULL,NULL),(104,6,35,1,NULL,NULL),(105,6,22,1,NULL,NULL),(106,6,33,1,NULL,NULL),(107,7,88,1,NULL,NULL),(108,7,86,1,NULL,NULL),(109,7,55,1,NULL,NULL),(110,7,16,1,NULL,NULL),(111,7,35,1,NULL,NULL),(112,7,45,1,NULL,NULL),(113,7,52,1,NULL,NULL),(114,7,16,1,NULL,NULL),(115,7,57,1,NULL,NULL),(116,7,29,1,NULL,NULL),(117,7,86,1,NULL,NULL),(118,7,15,1,NULL,NULL),(119,7,53,1,NULL,NULL),(120,7,58,1,NULL,NULL),(121,7,68,1,NULL,NULL),(122,7,30,1,NULL,NULL),(124,7,36,1,NULL,NULL),(125,7,62,1,NULL,NULL),(126,7,71,1,NULL,NULL),(127,7,70,1,NULL,NULL),(128,8,62,1,NULL,NULL),(129,8,85,1,NULL,NULL),(130,8,15,1,NULL,NULL),(131,2,3,1,NULL,'2019-04-24 07:24:22'),(133,2,4,1,NULL,NULL),(134,2,124,1,NULL,NULL),(135,2,60,0,NULL,NULL),(136,2,6,0,NULL,NULL),(137,2,64,0,NULL,NULL),(138,2,160,0,NULL,NULL);
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-26 15:38:45
