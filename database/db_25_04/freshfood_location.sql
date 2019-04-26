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
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_id` int(11) NOT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `longitude` double NOT NULL,
  `latitude` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `area_id` (`area_id`),
  CONSTRAINT `FKkx17wmdxmy67gc9t04pghuwdp` FOREIGN KEY (`area_id`) REFERENCES `area` (`id`),
  CONSTRAINT `location_ibfk_1` FOREIGN KEY (`area_id`) REFERENCES `area` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,1,'Cầu Vượt Ngô Sỹ Liên','60 Ngô Sỹ Liên, Liên Chiểu, Đà Nẵng 550000, vietnam',108.155,16.0746),(2,1,'Hồ tùng Mậu','Hồ Tùng Mậu, Hoà Minh, Liên Chiểu, Đà Nẵng 550000, Vietnam',108.158,16.0752),(3,1,'276, Đường Âu Cơ','276, Đường Âu Cơ, Phường Hòa Khánh Bắc, Quận Liên Chiểu, Vietnam',108.147,16.0704),(4,1,'Chợ Hoà Khánh','Hòa Khánh Bắc, Liên Chiểu, Da Nang 550000, Vietnam',108.149,16.0703),(5,1,'Quán Cô Nga','k60 Ngô Sỹ Liên, Liên Chiểu, Đà Nẵng 550000, Vietnam',108.155,16.0731),(7,3,'','180-182 Nguyễn Hoàng, Nam Dương, Hải Châu, Đà Nẵng, Vietnam',108.214,16.061),(8,6,'','139 Nguyễn Văn Linh, Vĩnh Trung, Q. Thanh Khê, Đà Nẵng, Vietnam',108.215,16.0603),(9,5,'','3669+FW Da Nang, Hải Châu, Da Nang, Vietnam',108.22,16.0612),(10,6,'Tam Thuận Thanh Khê Đà Nẵng','Tam Thuận, Thanh Khê, Đà Nẵng 550000, Vietnam',108.204,16.0708);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
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
