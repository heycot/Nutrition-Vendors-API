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
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `name` varchar(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `city_id` (`city_id`),
  CONSTRAINT `FK7gpdo1p011b4rddf8gbf3afqx` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `area_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,1,'Liên Chiểu'),(3,1,'Cẩm Lệ'),(4,1,'Ngũ Hành Sơn'),(5,1,'Hải Châu'),(6,1,'Thanh Khê'),(7,1,'Sơn Trà'),(8,1,'Hoà Vang'),(9,1,'Hoàng Sa');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `icon` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Rau Củ','vegtable.png'),(2,'Trái Cây','fruit.png'),(3,'Gia Vị','pepper.png'),(5,'Ngũ Cốc','rice.png'),(6,'Thịt Cá','meat.png'),(7,'Hải Sản','oyster.png');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Đà Nẵng');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `shopitem_id` int(11) NOT NULL,
  `rating` double NOT NULL,
  `create_date` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shopitem_id` (`shopitem_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKhhmv6v1vbfqf2mgd2hkx8eekq` FOREIGN KEY (`shopitem_id`) REFERENCES `shopitem` (`id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`shopitem_id`) REFERENCES `shopitem` (`id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (5,7,'Tuyệt vời','Mình khá thích quán này, chất lượng tốt, hoa quả tươi sạch, đảm bảo xuất xứ,. Giá cả lại hợp lý, Cô chủ thì nhiệt tình',3,4.6,'2019-03-30 03:45:01.332772',1),(6,6,'Khá Ổn','Giá cả lại hợp lý, Cô chủ thì nhiệt tình',3,4.6,'2019-03-30 03:45:01.332772',1),(7,8,'Mọi thứ đều OK','Táo cực ngon, giá cả phải chăng, đồ tươi và sạch sẽ, quán dễ tìm',3,4.6,'2019-03-30 03:45:01.332772',1),(8,9,'Mình thích quán này','Đến nơi là cả thiên đường trái cây để chọn, cực kì ngon và tốt',3,4.8,'2019-03-30 03:45:01.332772',1),(9,3,'Yêu thích','Tối làm về khuya nên ghé mua hoa quả cho ngày mai, gần đóng quán mà cô chủ vẫn mở bán cho mình, rất nhiệt tình',3,4.8,'2019-03-30 03:45:01.332772',1),(10,4,'Cực kì nên mua luôn ạ','Táo ngon và sạch',3,4.8,'2019-03-30 03:45:01.332772',1),(11,5,'Khá ổn','Táo chất lượng mỹ mà giá cả việt nam, nhưng táo hơn to, mình thích táo nhỏ hơn :))',3,3.8,'2019-03-30 03:45:01.332772',1),(12,4,'Tuyệt vời quá luôn','Rất thích mua trái cây ở đây',3,4,'2019-03-31 04:48:19.000000',1);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopitem_id` int(11) NOT NULL,
  `link` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `priority` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `shopitem_id` (`shopitem_id`),
  CONSTRAINT `FKpe2jhtb6uqsq12pm4swbafaed` FOREIGN KEY (`shopitem_id`) REFERENCES `shopitem` (`id`),
  CONSTRAINT `document_ibfk_1` FOREIGN KEY (`shopitem_id`) REFERENCES `shopitem` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=350 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES (1,3,'31.jpg',1),(2,3,'32.jpg',0),(3,3,'33.jpg',0),(4,3,'34.jpg',0),(5,4,'41.jpg',1),(6,4,'42.jpg',0),(7,4,'43.jpg',0),(8,4,'44.jpg',0),(99,5,'51.jpg',1),(100,5,'52.jpg',0),(101,5,'53.jpg',0),(102,5,'54.jpg',0),(103,6,'61.jpg',1),(104,6,'62.jpg',0),(105,6,'63.jpg',0),(106,6,'64.jpg',0),(107,7,'71.jpg',1),(108,7,'72.jpg',0),(109,7,'73.jpg',0),(110,7,'74.jpg',0),(111,8,'81.jpg',1),(112,8,'82.jpg',0),(113,8,'83.jpg',0),(114,8,'84.jpg',0),(115,9,'91.jpg',1),(116,9,'92.jpg',0),(117,9,'93.jpg',0),(118,9,'94.jpg',0),(119,10,'101.jpg',1),(120,10,'102.jpg',0),(121,10,'103.jpg',0),(122,10,'104.jpg',0),(123,11,'111.jpg',1),(124,11,'112.jpg',0),(125,11,'113.jpg',0),(126,11,'114.jpg',0),(127,12,'121.jpg',1),(128,12,'122.jpg',0),(129,12,'123.jpg',0),(130,12,'54.jpg',0),(131,13,'131.jpg',1),(132,13,'132.jpg',0),(133,13,'133.jpg',0),(134,13,'134.jpg',0),(135,14,'141.jpg',1),(136,14,'142.jpg',0),(137,14,'143.jpg',0),(138,14,'144.jpg',0),(139,15,'151.jpg',1),(140,15,'152.jpg',0),(141,15,'153.jpg',0),(142,15,'154.jpg',0),(143,16,'161.jpg',1),(144,16,'162.jpg',0),(145,16,'163.jpg',0),(146,16,'164.jpg',0),(147,17,'171.jpg',1),(148,17,'172.jpg',0),(149,17,'173.jpg',0),(150,17,'174.jpg',0),(151,18,'181.jpg',1),(152,18,'182.jpg',0),(153,18,'183.jpg',0),(154,18,'184.jpg',0),(155,20,'201.jpg',1),(156,20,'202.jpg',0),(157,20,'203.jpg',0),(158,21,'211.jpg',1),(159,21,'212.jpg',0),(160,21,'213.jpg',0),(161,22,'221.jpg',1),(162,22,'222.jpg',0),(163,22,'223.jpg',0),(164,23,'231.jpg',1),(165,23,'232.jpg',0),(166,23,'233.jpg',0),(167,24,'241.jpg',1),(168,24,'242.jpg',0),(169,24,'243.jpg',0),(170,25,'251.jpg',1),(171,25,'252.jpg',0),(172,25,'253.jpg',0),(173,26,'261.jpg',1),(174,26,'262.jpg',0),(175,26,'263.jpg',0),(176,27,'271.jpg',1),(177,27,'272.jpg',0),(178,27,'273.jpg',0),(179,28,'281.jpg',1),(180,28,'282.jpg',0),(181,28,'283.jpg',0),(182,29,'291.jpg',1),(183,29,'292.jpg',0),(184,29,'293.jpg',0),(185,30,'301.jpg',1),(186,30,'302.jpg',0),(187,31,'311.jpg',1),(188,31,'312.jpg',0),(189,32,'321.jpg',1),(190,32,'322.jpg',0),(191,33,'331.jpg',1),(192,33,'332.jpg',0),(193,34,'341.jpg',1),(194,34,'342.jpg',0),(195,35,'351.jpg',1),(196,35,'352.jpg',0),(197,36,'361.jpg',1),(198,36,'362.jpg',0),(199,37,'371.jpg',1),(200,37,'372.jpg',0),(201,38,'381.jpg',1),(202,38,'382.jpg',0),(203,39,'391.jpg',1),(204,39,'392.jpg',0),(205,40,'401.jpg',1),(206,41,'412.jpg',0),(207,42,'421.jpg',1),(208,42,'422.jpg',0),(209,43,'431.jpg',1),(210,43,'432.jpg',0),(211,44,'441.jpg',1),(212,44,'442.jpg',0),(213,45,'451.jpg',1),(214,45,'452.jpg',0),(215,46,'461.jpg',1),(216,46,'462.jpg',0),(217,47,'471.jpg',1),(218,47,'472.jpg',0),(219,48,'481.jpg',1),(220,48,'482.jpg',0),(221,50,'501.jpg',1),(222,51,'511.jpg',1),(223,52,'521.jpg',1),(224,53,'531.jpg',1),(225,54,'541.jpg',1),(226,55,'551.jpg',1),(227,56,'561.jpg',1),(228,57,'571.jpg',1),(229,58,'581.jpg',1),(230,59,'591.jpg',1),(231,60,'601.jpg',1),(232,61,'611.jpg',1),(233,62,'621.jpg',1),(234,63,'631.jpg',1),(235,64,'641.jpg',1),(236,65,'651.jpg',1),(237,66,'661.jpg',1),(238,73,'731.jpg',1),(239,73,'732.jpg',0),(240,74,'741.jpg',1),(241,74,'742.jpg',0),(242,75,'751.jpg',1),(243,75,'752.jpg',0),(244,76,'761.jpg',1),(245,76,'762.jpg',0),(246,77,'771.jpg',1),(247,77,'772.jpg',0),(248,67,'671.jpg',1),(249,68,'681.jpg',1),(250,69,'691.jpg',1),(251,70,'701.jpg',1),(252,71,'711.jpg',1),(253,72,'721.jpg',1),(254,78,'781.jpg',1),(255,79,'791.jpg',1),(256,80,'801.jpg',1),(257,81,'811.jpg',1),(258,82,'821.jpg',1),(259,83,'831.jpg',1),(260,84,'841.jpg',1),(261,85,'851.jpg',1),(262,86,'861.jpg',1),(263,87,'871.jpg',1),(264,88,'881.jpg',1),(265,89,'891.jpg',1),(266,90,'901.jpg',1),(267,91,'911.jpg',1),(268,92,'921.jpg',1),(269,93,'931.jpg',1),(270,94,'941.jpg',1),(271,95,'951.jpg',1),(272,96,'961.jpg',1),(273,98,'981.jpg',1),(274,97,'971.jpg',1),(275,99,'991.jpg',1),(276,100,'1001.jpg',1),(277,101,'1011.jpg',1),(278,102,'1021.jpg',1),(279,103,'1031.jpg',1),(280,104,'1041.jpg',1),(281,105,'1051.jpg',1),(282,106,'1061.jpg',1),(283,107,'1071.jpg',1),(284,108,'1081.jpg',1),(285,109,'1091.jpg',1),(286,110,'1101.jpg',1),(287,111,'1111.jpg',1),(288,112,'1121.jpg',1),(289,113,'1131.jpg',1),(290,114,'1141.jpg',1),(291,115,'1151.jpg',1),(292,116,'1161.jpg',1),(293,117,'1171.jpg',1),(294,118,'1181.jpg',1),(295,119,'1191.jpg',1),(296,120,'1201.jpg',1),(297,121,'1211.jpg',1),(298,122,'1221.jpg',1),(299,123,'1231.jpg',1),(300,124,'1241.jpg',1),(301,125,'1251.jpg',1),(302,126,'1261.jpg',1),(303,127,'1271.jpg',1),(304,128,'1281.jpg',1),(305,129,'1291.jpg',1),(306,130,'1301.jpg',1),(307,131,'1311.jpg',1),(308,132,'1321.jpg',1),(309,133,'1331.jpg',1),(310,134,'1341.jpg',1),(311,135,'1351.jpg',1),(312,136,'1361.jpg',1),(313,137,'1371.jpg',1),(314,138,'1381.jpg',1),(315,139,'1391.jpg',1),(316,140,'1401.jpg',1),(317,141,'1411.jpg',1),(318,142,'1421.jpg',1),(319,143,'1431.jpg',1),(320,144,'1441.jpg',1),(321,145,'1451.jpg',1),(322,146,'1461.jpg',1),(323,147,'1471.jpg',1),(324,148,'1481.jpg',1),(325,149,'1491.jpg',1),(326,150,'1501.jpg',1),(327,151,'1511.jpg',1),(328,152,'1521.jpg',1),(329,153,'1531.jpg',1),(330,154,'1541.jpg',1),(331,156,'1561.jpg',1),(332,155,'1551.jpg',1),(333,157,'1571.jpg',1),(334,158,'1581.jpg',1),(335,159,'1591.jpg',1),(336,160,'1601.jpg',1),(337,3,'35.jpg',0),(338,3,'36.jpg',0),(339,3,'37.jpg',0),(340,3,'38.jpg',0),(341,3,'39.jpg',0),(342,3,'310.jpg',0),(343,3,'3_11.jpg',0),(344,3,'3_12.jpg',0),(345,3,'3_13.jpg',0),(346,3,'3_14.jpg',0),(347,41,'411.jpg',1),(348,161,'1611.jpg',1),(349,161,'1612.jpg',0);
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `favorites` VALUES (1,2,26,1),(2,2,69,1),(3,2,58,1),(4,2,78,1),(5,2,68,1),(6,2,56,1),(7,2,84,1),(8,2,89,1),(9,2,156,1),(10,2,157,1),(11,2,135,1),(12,2,148,1),(13,2,135,1),(14,3,135,1),(15,3,25,1),(16,3,15,1),(17,3,6,1),(18,3,65,1),(19,3,45,1),(20,3,89,1),(21,3,36,1),(23,3,25,1),(24,3,36,1),(25,3,14,1),(26,3,96,1),(27,3,56,1),(28,3,124,1),(29,3,123,1),(30,3,100,1),(31,3,101,1),(32,4,3,1),(33,4,32,1),(34,4,36,1),(36,4,25,1),(37,4,24,1),(39,4,15,1),(41,4,4,1),(42,4,45,1),(43,4,48,1),(44,4,102,1),(45,4,150,1),(46,4,145,1),(47,4,144,1),(48,4,146,1),(49,4,17,1),(50,4,65,1),(51,4,68,1),(52,4,59,1),(53,4,57,1),(54,4,69,1),(55,4,96,1),(56,4,85,1),(57,4,74,1),(58,5,4,1),(59,5,45,1),(60,5,46,1),(61,5,47,1),(62,5,48,1),(64,5,35,1),(65,5,29,1),(66,5,96,1),(67,5,85,1),(68,5,86,1),(69,5,84,1),(70,5,95,1),(71,5,91,1),(72,5,92,1),(73,5,93,1),(74,5,97,1),(75,5,125,1),(76,5,114,1),(77,5,118,1),(80,5,138,1),(82,5,12,1),(83,5,126,1),(84,5,127,1),(85,5,128,1),(86,5,135,1),(87,5,26,1),(89,6,18,1),(90,6,16,1),(91,6,14,1),(92,6,13,1),(93,6,125,1),(95,6,124,1),(96,6,126,1),(97,6,135,1),(98,6,136,1),(99,6,137,1),(100,6,125,1),(101,6,122,1),(102,6,16,1),(103,6,24,1),(104,6,35,1),(105,6,22,1),(106,6,33,1),(107,7,88,1),(108,7,86,1),(109,7,55,1),(110,7,16,1),(111,7,35,1),(112,7,45,1),(113,7,52,1),(114,7,16,1),(115,7,57,1),(116,7,29,1),(117,7,86,1),(118,7,15,1),(119,7,53,1),(120,7,58,1),(121,7,68,1),(122,7,30,1),(124,7,36,1),(125,7,62,1),(126,7,71,1),(127,7,70,1),(128,8,62,1),(129,8,85,1),(130,8,15,1),(131,2,3,1),(133,2,4,1),(134,2,124,1),(135,2,60,0),(136,2,6,0),(137,2,64,0),(138,2,160,0);
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `category_id` int(11) NOT NULL,
  `measure_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `measure_id` (`measure_id`),
  CONSTRAINT `FK2n9w8d0dp4bsfra9dcg0046l4` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKoi6sdayfwxbtm6ec39f7om3ch` FOREIGN KEY (`measure_id`) REFERENCES `measure` (`id`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `item_ibfk_2` FOREIGN KEY (`measure_id`) REFERENCES `measure` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Táo Xanh Mỹ',2,1),(2,'NHo Đen',2,1),(3,'Cam Xã Đoài',2,1),(4,'Mận',2,1),(5,'Đào Nhật Bản',2,1),(6,'Mâm Xôi Đen',2,1),(7,'Lê',2,1),(8,'Nho Xanh',2,1),(9,'Dâu Tây',2,1),(10,'Bơ',2,1),(11,'Chuối',2,1),(12,'Ổi',2,1),(13,'Dứa',2,1),(14,'Dưa Hấu',2,1),(15,'Xoài',2,1),(16,'Lựu',2,1),(17,'Đu Đủ',2,1),(18,'Hồng Xiêm',2,1),(19,'Dâu Tây',2,1),(20,'Vải',2,1),(21,'Nhãn',2,1),(22,'Cóc',2,1),(23,'Thanh Long',2,1),(24,'Dưa Gang',2,1),(25,'Na',2,1),(26,'Cherry',2,1),(27,'Vũ Sữa',2,1),(28,'Cà Rốt',1,1),(29,'Xu Hào',1,1),(30,'Bắp Cải',1,1),(31,'Xà Lách',1,1),(32,'Ớt Chuông Đà Lạt',1,1),(33,'Mớp',1,1),(34,'Hành Tây',1,1),(35,'Xúp Lơ',1,1),(37,'Hành Tăm',1,1),(38,'Khoai Lang',1,1),(39,'Cà Chua',1,1),(40,'Dưa Leo',1,1),(41,'Bí Đỏ',1,1),(42,'Củ Cải Đỏ',1,1),(43,'Củ Cải Trắng',1,1),(44,'Rau thơm',1,1),(45,'Rau Răm',1,1),(46,'Khổ qua',1,1),(47,'Rau Mùng Tơi',1,1),(48,'Rau Cải Ngọt',1,1),(49,'Rau Cải Đắng',1,1),(50,'Rau Ngót',1,1),(51,'Rau Dền',1,1),(52,'Cải Bó Xôi',1,1),(53,'Rau Chân Vịt',1,1),(54,'Rau Muống',1,1),(55,'Rau Lang',1,1),(56,'Măng Tây',1,1),(57,'Đậu Hà Lan',1,1),(58,'Khoai Từ',1,1),(59,'Khoai Vạc',1,1),(60,'Hành Tím',3,1),(61,'Tỏi',3,1),(62,'Ớt',3,1),(63,'Tiêu',3,1),(64,'Gừng',3,1),(65,'Mớp',3,1),(66,'Sả',3,1),(67,'Nghệ',3,1),(68,'Húng Quế',3,1),(69,'Mùi Tàu',3,1),(70,'Lộc Mơ',3,1),(71,'Rau Mùi',3,1),(72,'Mì Chính',3,1),(73,'Hạt Nêm',3,1),(74,'Nước Mắm',3,1),(75,'Đường',3,1),(76,'Muối',3,1),(77,'Xì dầu',3,1),(78,'Tương Ớt',3,1),(79,'Mù Tạt',3,1),(80,'Mắm Ruốc',3,1),(81,'Mắm Cái',3,1),(82,'Chanh',3,1),(83,'Gạo Tám Thơm Hải Hậu',5,1),(84,'Gạo Tám Xoan Hải Hậu',5,1),(85,'Gạo Tám Thái Đỏ',5,1),(86,'Gạo Bắc Thái Bình',5,1),(87,'Gạo Bắc hải Hậu',5,1),(88,'Gạo Khang Dân',5,1),(89,'Gạo Xi Dẻo',5,1),(90,'Gạo Tám Thơm Nam Bình',5,1),(91,'Gạo Tám Thái Loại 1',5,1),(92,'Gạo Tám Biên Trắng',5,1),(93,'Gạo tấm Babyplus',5,1),(94,'Gạo lứt Mường Khương',5,1),(95,'Gạo tấm còn phôi',5,1),(96,'Gạo Phadin',5,1),(97,'Gạo Séng Cù',5,1),(98,'Gạo nếp cái Hoa Vàng',5,1),(99,'Gạo nếp nương Điện Biên',5,1),(100,'Gạo huyết rồng',5,1),(101,'Sữa MILO',5,1),(102,'Yến Mạch Ăn Liền Quaker',5,1),(103,'Bột Cacao Chất',5,1),(104,'Thức Uống yến Mạch Quảker 3 in 1',5,1),(105,'Ngũ Cốc Sấy Khô Calbee Nhật Bản',5,1),(106,'Bột Mần Đậu Nành Vũ Phát',5,1),(107,'Bột Trà Xanh Matcha Meiyo',5,1),(108,'Bột Trà Xanh Nguyên Chast Bảo Lộc',5,1),(109,'Bột Tinh Than Tre Thực Phẩm',5,1),(110,'Bột Diếp Cá Sấy Lạnh Quảng Thanh',5,1),(111,'Ngũ Cốc Lợi Sữa Qeen Nature',5,1),(112,'Yến Mạch',5,1),(113,'Đậu Xanh Đen Lòng',5,1),(114,'Bột Trà Rang Sato Hojicha Nhật Bản',5,1),(115,'Yến Mạch Organic Cán Cỡ Vừa Bobs Red Mill',5,1),(116,'Ngũ cốc siêu dinh dưỡng bà bầu QUEEN NATURE',5,1),(117,'Bột cacao nguyên chất Việt Nam',5,1),(118,'Bột ngũ cốc tập thể hình loại 1 Phương Uyên',5,1),(119,'Bột Đậu Đỏ Vũ Phát',5,1),(120,'Ngũ Cốc Nestle Fitnesse Socola',5,1),(121,'Thị Heo',6,1),(122,'Thịt Sườn Heo',6,1),(123,'Thịt Thủ Heo',6,1),(124,'Thịt Ba Chỉ Heo',6,1),(125,'Giò Heo',6,1),(126,'Thị Vai Heo',6,1),(127,'Thịt Diềm Heo',6,1),(128,'Thịt Má Heo',6,1),(129,'Lòng Heo',6,1),(130,'Sách Bò',6,1),(131,'Lòng Bò',6,1),(132,'Nạc Bò',6,1),(133,'Chân Bò',6,1),(134,'Xương Bò',6,1),(135,'Thịt Gà',6,1),(136,'Thịt Vịt',6,1),(137,'Thịt Dê',6,1),(138,'Trứng Gà',6,1),(139,'Trứng Vịt',6,1),(140,'Cá Thu',7,1),(141,'Cá Ngừ',7,1),(142,'Cá Cơm',7,1),(143,'Cá Chép',7,1),(144,'Lươn',7,1),(145,'Chạch',7,1),(146,'Ca Rô Phi',7,1),(147,'Cá Ba Sa',7,1),(148,'Cá Trắm',7,1),(149,'Cá Mè',7,1),(150,'Cá Trích',7,1),(151,'Cá Nục',7,1),(152,'Cá Liệt',7,1),(153,'Cá Trôi',7,1),(154,'Cá Chim',7,1),(155,'Cá Rô Đồng',7,1),(156,'Sữa',7,1),(157,'Mực',7,1),(158,'Bạch Tuộc',7,1),(159,'Cua Hoàng Đế',7,1),(160,'Ghẹ',7,1),(161,'Cua Tuyết',7,1),(162,'Ngao',7,1),(163,'Nghêu',7,1),(164,'Sò',7,1),(165,'Hến',7,1),(166,'Ốc Nhảy',7,1),(167,'Ốc Móng Tay',7,1),(168,'Ốc Hút',7,1),(169,'Ốc Gạo',7,1),(170,'Sò Điệp',7,1),(171,'Cua Đá',7,1),(172,'Ốc Hương',7,1),(173,'Ốc Gai',7,1),(174,'Ốc Giấy',7,1),(175,'Ốc Cùi',7,1);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `measure`
--

DROP TABLE IF EXISTS `measure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `measure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sign` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measure`
--

LOCK TABLES `measure` WRITE;
/*!40000 ALTER TABLE `measure` DISABLE KEYS */;
INSERT INTO `measure` VALUES (1,'kilogram','kg'),(2,'Bó','bó'),(3,'Chai','chai'),(4,'millimetre','ml');
/*!40000 ALTER TABLE `measure` ENABLE KEYS */;
UNLOCK TABLES;

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
  `create_date` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `phone` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `location_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `avatar` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `time_open` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `time_close` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
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
INSERT INTO `shop` VALUES (4,'Quán Cô Nga',3.6,'2019-03-30 03:22:54.961818','0336025122',1,2,'',1,'7:00','18:00'),(6,'Quán Cô Tavia',3.8,'2019-03-30 03:22:54.961818','0336025122',3,3,'',1,'7:00','18:00'),(7,'Quán Cô Quý',3.8,'2019-03-30 03:22:54.961818','0336025122',2,4,'',1,'7:00','18:00'),(8,'Quán Cô Bảo',3.8,'2019-03-30 03:22:54.961818','0336025122',4,4,'',1,'7:00','18:00'),(9,'Quán Cô An',2.7,'2019-03-30 03:22:54.961818','0336025122',7,5,'',1,'7:00','18:00'),(10,'Quán Cô Cường',4.7,'2019-03-30 03:22:54.961818','0336025122',10,6,'',1,'7:00','18:00'),(11,'Quán Cô Định',4.1,'2019-03-30 03:22:54.961818','0336025122',5,7,'',1,'8:00','17:00'),(13,'Quán Cô Nam',4.1,'2019-03-30 03:22:54.961818','0336025122',9,8,'',1,'8:00','17:00'),(14,'Quán Cô Cường Gầy',3.6,'2019-03-30 03:22:54.961818','0336025122',8,9,'',1,'10:00','17:00');
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopitem`
--

DROP TABLE IF EXISTS `shopitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shopitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `rating` double NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`),
  KEY `shop_id` (`shop_id`),
  CONSTRAINT `FK49pm8dghubgt1cfp7cg71pyyi` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  CONSTRAINT `FKn1cxt6dayguke4u8hvg5cetmp` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`),
  CONSTRAINT `shopitem_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  CONSTRAINT `shopitem_ibfk_2` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopitem`
--

LOCK TABLES `shopitem` WRITE;
/*!40000 ALTER TABLE `shopitem` DISABLE KEYS */;
INSERT INTO `shopitem` VALUES (3,4,1,6000,5,1),(4,4,2,6000,3.3,1),(5,4,3,86000,3.7,1),(6,4,4,36000,4.87,1),(7,4,5,16000,4.87,1),(8,4,6,35000,4.24,1),(9,4,7,34000,3.24,1),(10,4,8,34000,3.24,1),(11,4,9,34000,2.24,1),(12,4,10,25000,4.24,1),(13,4,11,36000,4.78,1),(14,4,12,26000,4.45,1),(15,4,13,19000,4.45,1),(16,4,14,58000,4.26,1),(17,4,15,58000,4.26,1),(18,4,16,15000,4.26,1),(20,6,60,15000,4.26,1),(21,6,61,15000,4.01,1),(22,6,62,10000,2.01,1),(23,6,63,45000,3.01,1),(24,6,64,15000,4.01,1),(25,6,65,5000,4.01,1),(26,6,66,5000,4.01,1),(27,6,67,30000,3.25,1),(28,6,68,45000,4.25,1),(29,6,69,25000,4.25,1),(30,6,70,25000,4.25,1),(31,6,71,24000,4.25,1),(32,6,72,36000,4.25,1),(33,6,73,45000,4.25,1),(34,6,74,26000,1.5,1),(35,6,75,12000,2.3,1),(36,6,76,26000,3.3,1),(37,6,78,16000,3.3,1),(38,6,79,16000,3.3,1),(39,6,80,16000,3.3,1),(40,6,81,18000,4.2,1),(41,6,82,26000,4.2,1),(42,7,28,26000,4.2,1),(43,7,29,15000,3.2,1),(44,7,30,16000,3.2,1),(45,7,31,40000,4.2,1),(46,7,32,31000,3.47,1),(47,7,33,15000,2.47,1),(48,7,35,25000,3.47,1),(50,7,37,26000,4.26,1),(51,7,38,15000,2.26,1),(52,7,39,15000,4.26,1),(53,7,40,15000,4.26,1),(54,7,41,25000,4.26,1),(55,7,42,35000,3.36,1),(56,7,43,35000,3.36,1),(57,7,44,15000,3.36,1),(58,7,45,42000,4.36,1),(59,7,46,15000,4.36,1),(60,7,47,15000,4.65,1),(61,7,48,16000,2.65,1),(62,7,49,16000,2.1,1),(63,7,50,36000,3.1,1),(64,7,51,25000,4.9,1),(65,7,52,25000,1.9,1),(66,7,53,24000,2.19,1),(67,7,54,18000,2.19,1),(68,7,55,19000,3.19,1),(69,7,56,19000,4.19,1),(70,7,57,20000,4.19,1),(71,7,58,17000,3.19,1),(72,7,59,35000,3.19,1),(73,8,83,15000,3.19,1),(74,8,84,16000,3.19,1),(75,8,85,17000,4.19,1),(76,8,86,16000,3.19,1),(77,8,87,15000,3.19,1),(78,8,88,10000,4.19,1),(79,8,89,16000,2.19,1),(80,8,90,14000,2.36,1),(81,8,91,15000,4.36,1),(82,8,92,20000,4.56,1),(83,8,93,15000,4.56,1),(84,8,94,16000,4.56,1),(85,8,95,16000,3.56,1),(86,8,96,18000,3.56,1),(87,8,96,18000,3.56,1),(88,8,97,17000,3.26,1),(89,8,98,25000,4.89,1),(90,8,99,24000,4.45,1),(91,8,100,15000,3.45,1),(92,8,101,15000,3.45,1),(93,8,102,14000,2.45,1),(94,8,103,13000,3.45,1),(95,8,104,45000,3.45,1),(96,8,105,60000,3.45,1),(97,8,106,69000,3.45,1),(98,8,107,86000,4.45,1),(99,8,108,109000,3.45,1),(100,8,109,136000,2.45,1),(101,8,110,96000,4.45,1),(102,8,111,97000,4.25,1),(103,8,112,68000,4.25,1),(104,8,113,85000,3.75,1),(105,8,114,84000,4.75,1),(106,8,115,89000,4.1,1),(107,8,116,89000,4.1,1),(108,8,117,112000,3.1,1),(109,8,118,100000,4.1,1),(110,9,121,100000,4.1,1),(111,9,122,98000,4.1,1),(112,9,123,70000,3.1,1),(113,9,124,75000,4.1,1),(114,9,125,45000,4.56,1),(115,9,126,40000,4,1),(116,9,127,80000,3.6,1),(117,9,128,80000,3.6,1),(118,9,129,50000,4.6,1),(119,9,130,150000,4.6,1),(120,9,131,50000,3.6,1),(121,9,132,200000,4.6,1),(122,9,133,70000,3.6,1),(123,9,134,75000,3.6,1),(124,9,135,120000,4.6,1),(125,9,136,110000,3.6,1),(126,9,137,175000,4.6,1),(127,9,138,45000,4.6,1),(128,9,139,40000,3.6,1),(129,10,140,140000,3.6,1),(130,10,141,90000,3.6,1),(131,10,142,35000,2.6,1),(132,10,143,50000,4.6,1),(133,10,144,150000,4.6,1),(134,10,145,175000,3.6,1),(135,10,146,30000,2.6,1),(136,10,147,45000,2.6,1),(137,10,148,60000,3.6,1),(138,10,149,65000,3.6,1),(139,10,150,35000,3.6,1),(140,10,151,40000,3.6,1),(141,10,152,35000,3.6,1),(142,10,153,65000,4.6,1),(143,10,154,70000,4.6,1),(144,10,155,45000,4.6,1),(145,10,156,80000,3.6,1),(146,10,157,350000,3.6,1),(147,10,158,250000,3.6,1),(148,10,159,1900000,3.6,1),(149,10,160,75000,4.6,1),(150,10,161,12000,4.6,1),(151,10,162,34000,4.6,1),(152,10,163,35000,4.6,1),(153,10,164,35000,3.6,1),(154,10,165,35000,3.6,1),(155,10,166,120000,3.6,1),(156,10,167,250000,4.6,1),(157,10,168,45000,4.6,1),(158,10,169,45000,3.6,1),(159,10,170,150000,4.6,1),(160,10,171,160000,5,1),(161,10,172,140000,4.6,1);
/*!40000 ALTER TABLE `shopitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `birthday` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `avatar` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `address` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `create_date` timestamp(6) NOT NULL DEFAULT '0000-00-00 00:00:00.000000',
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
INSERT INTO `user` VALUES (2,'Callie','callie@enclave.vn','0336025122','123456','2019-04-09 03:15:10.632939','callie.jpg','60 Ngô Sỹ Liên - Liên Chiểu - Đà Nẵng','2019-03-30 02:39:02.692869',1,'3IpU622wRsagUSKsQIkOn7CiNGxdZA2B40vBds3ynSTinQDJl92'),(3,'Tavia','tavia@enclave.vn','0395793687','123456','2019-04-09 03:15:10.641341','tavia.PNG','60 Ngô Sỹ Liên - Liên Chiểu - Đà Nẵng','2019-03-30 02:39:02.692869',1,''),(4,'Wyatt','wyatt@enclave.vn','09696969','123456','2019-04-09 03:15:10.641893','wyatt.PNG','60 Ngô Sỹ Liên - Liên Chiểu - Đà Nẵng','2019-03-30 02:39:02.692869',1,''),(5,'Aiden','aiden@enclave.vn','09696969','123456','2019-04-09 03:15:10.642433','aiden.PNG','K80/28 Nguyễn Bằng - Liên Chiểu - Đà Nẵng','2019-03-30 02:39:02.692869',1,''),(6,'Hardy','hardy@enclave.vn','0365623256','123456','2019-04-09 03:15:10.643334','hardy.PNG','KTC DMC Liên Chiểu Đà Nẵng','2019-03-30 02:39:02.692869',1,''),(7,'Roger','roger@enclave.vn','0365623256','123456','2019-04-09 03:15:10.643886','roger.PNG','Hải Châu Đà Nẵng','2019-03-30 02:39:02.692869',1,''),(8,'Nodin','nodin@enclave.vn','0365623256','123456','2019-04-09 03:15:10.644382','nodin.jpg','Ngô Sỹ Liên - Chiểu - Đà Nẵng','2019-03-30 02:39:02.692869',1,''),(9,'Clay','clay@enclave.vn','0365623256','123456','2019-04-09 03:15:10.644916','clay.PNG','Ngô Sỹ Liên - Chiểu - Đà Nẵng','2019-03-30 02:39:02.692869',1,''),(10,'Ronald','ronald@enclave.vn','0336025122','123456','2019-04-09 03:15:23.479296','ronald.jpg','60 Ngô Sỹ Liên - Liên Chiểu - Đà Nẵng','2019-03-30 02:39:02.692869',1,'');
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

-- Dump completed on 2019-04-09 13:24:00
