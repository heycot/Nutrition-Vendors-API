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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `birthday` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `avatar` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `address` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `create_date` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `status` int(11) NOT NULL,
  `token` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'Callie','callie@enclave.vn','0336025122','123456','2019-04-09 03:15:10.632939','callie.jpg','60 Ngô Sỹ Liên - Liên Chiểu - Đà Nẵng','2019-03-30 02:39:02.692869',1,'TzMzJENimV06F7YVqX55SGGDinQbQCw5OHbqPdRgCnhpWoKTsn2'),(3,'Tavia','tavia@enclave.vn','0395793687','123456','2019-04-09 03:15:10.641341','tavia.PNG','60 Ngô Sỹ Liên - Liên Chiểu - Đà Nẵng','2019-03-30 02:39:02.692869',1,''),(4,'Wyatt','wyatt@enclave.vn','09696969','123456','2019-04-09 03:15:10.641893','wyatt.PNG','60 Ngô Sỹ Liên - Liên Chiểu - Đà Nẵng','2019-03-30 02:39:02.692869',1,''),(5,'Aiden','aiden@enclave.vn','09696969','123456','2019-04-09 03:15:10.642433','aiden.PNG','K80/28 Nguyễn Bằng - Liên Chiểu - Đà Nẵng','2019-03-30 02:39:02.692869',1,''),(6,'Hardy','hardy@enclave.vn','0365623256','123456','2019-04-09 03:15:10.643334','hardy.PNG','KTC DMC Liên Chiểu Đà Nẵng','2019-03-30 02:39:02.692869',1,''),(7,'Roger','roger@enclave.vn','0365623256','123456','2019-04-09 03:15:10.643886','roger.PNG','Hải Châu Đà Nẵng','2019-03-30 02:39:02.692869',1,''),(8,'Nodin','nodin@enclave.vn','0365623256','123456','2019-04-09 03:15:10.644382','nodin.jpg','Ngô Sỹ Liên - Chiểu - Đà Nẵng','2019-03-30 02:39:02.692869',1,''),(9,'Clay','clay@enclave.vn','0365623256','123456','2019-04-09 03:15:10.644916','clay.PNG','Ngô Sỹ Liên - Chiểu - Đà Nẵng','2019-03-30 02:39:02.692869',1,''),(10,'Ronald','ronald@enclave.vn','0336025122','123456','2019-04-09 03:15:23.479296','ronald.jpg','60 Ngô Sỹ Liên - Liên Chiểu - Đà Nẵng','2019-03-30 02:39:02.692869',1,'');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-15 18:11:14
