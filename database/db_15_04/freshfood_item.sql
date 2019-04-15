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
INSERT INTO `item` VALUES (1,'Táo Xanh Mỹ',2,1),(2,'NHo Đen',2,1),(3,'Cam Xã Đoài',2,1),(4,'Mận',2,1),(5,'Đào Nhật Bản',2,1),(6,'Mâm Xôi Đen',2,1),(7,'Lê',2,1),(8,'Nho Xanh',2,1),(9,'Dâu Tây',2,1),(10,'Bơ',2,1),(11,'Chuối',2,1),(12,'Ổi',2,1),(13,'Dứa',2,1),(14,'Dưa Hấu',2,1),(15,'Xoài',2,1),(16,'Lựu',2,1),(17,'Đu Đủ',2,1),(18,'Hồng Xiêm',2,1),(19,'Dâu Tây',2,1),(20,'Vải',2,1),(21,'Nhãn',2,1),(22,'Cóc',2,1),(23,'Thanh Long',2,1),(24,'Dưa Gang',2,1),(25,'Na',2,1),(26,'Cherry',2,1),(27,'Vũ Sữa',2,1),(28,'Cà Rốt',1,1),(29,'Xu Hào',1,1),(30,'Bắp Cải',1,1),(31,'Xà Lách',1,1),(32,'Ớt Chuông Đà Lạt',1,1),(33,'Mớp',1,1),(34,'Hành Tây',1,1),(35,'Xúp Lơ',1,1),(37,'Hành Tăm',1,1),(38,'Khoai Lang',1,1),(39,'Cà Chua',1,1),(40,'Dưa Leo',1,1),(41,'Bí Đỏ',1,1),(42,'Củ Cải Đỏ',1,1),(43,'Củ Cải Trắng',1,1),(44,'Rau thơm',1,1),(45,'Rau Răm',1,1),(46,'Khổ qua',1,1),(47,'Rau Mùng Tơi',1,1),(48,'Rau Cải Ngọt',1,1),(49,'Rau Cải Đắng',1,1),(50,'Rau Ngót',1,1),(51,'Rau Dền',1,1),(52,'Cải Bó Xôi',1,1),(53,'Rau Chân Vịt',1,1),(54,'Rau Muống',1,1),(55,'Rau Lang',1,1),(56,'Măng Tây',1,1),(57,'Đậu Hà Lan',1,1),(58,'Khoai Từ',1,1),(59,'Khoai Vạc',1,1),(60,'Hành Tím',3,1),(61,'Tỏi',3,1),(62,'Ớt',3,1),(63,'Tiêu',3,1),(64,'Gừng',3,1),(65,'Mớp',3,1),(66,'Sả',3,1),(67,'Nghệ',3,1),(68,'Húng Quế',3,1),(69,'Mùi Tàu',3,1),(70,'Lộc Mơ',3,1),(71,'Rau Mùi',3,1),(72,'Mì Chính',3,1),(73,'Hạt Nêm',3,1),(74,'Nước Mắm',3,1),(75,'Đường',3,1),(76,'Muối',3,1),(77,'Xì dầu',3,1),(78,'Tương Ớt',3,1),(79,'Mù Tạt',3,1),(80,'Mắm Ruốc',3,1),(81,'Mắm Cái',3,1),(82,'Chanh',3,1),(83,'Gạo Tám Thơm Hải Hậu',5,1),(84,'Gạo Tám Xoan Hải Hậu',5,1),(85,'Gạo Tám Thái Đỏ',5,1),(86,'Gạo Bắc Thái Bình',5,1),(87,'Gạo Bắc hải Hậu',5,1),(88,'Gạo Khang Dân',5,1),(89,'Gạo Xi Dẻo',5,1),(90,'Gạo Tám Thơm Nam Bình',5,1),(91,'Gạo Tám Thái Loại 1',5,1),(92,'Gạo Tám Biên Trắng',5,1),(93,'Gạo tấm Babyplus',5,1),(94,'Gạo lứt Mường Khương',5,1),(95,'Gạo tấm còn phôi',5,1),(96,'Gạo Phadin',5,1),(97,'Gạo Séng Cù',5,1),(98,'Gạo nếp cái Hoa Vàng',5,1),(99,'Gạo nếp nương Điện Biên',5,1),(100,'Gạo huyết rồng',5,1),(101,'Sữa MILO',5,1),(102,'Yến Mạch Ăn Liền Quaker',5,1),(103,'Bột Cacao Chất',5,1),(104,'Thức Uống yến Mạch Quảker 3 in 1',5,1),(105,'Ngũ Cốc Sấy Khô Calbee Nhật Bản',5,1),(106,'Bột Mần Đậu Nành Vũ Phát',5,1),(107,'Bột Trà Xanh Matcha Meiyo',5,1),(108,'Bột Trà Xanh Nguyên Chast Bảo Lộc',5,1),(109,'Bột Tinh Than Tre Thực Phẩm',5,1),(110,'Bột Diếp Cá Sấy Lạnh Quảng Thanh',5,1),(111,'Ngũ Cốc Lợi Sữa Qeen Nature',5,1),(112,'Yến Mạch',5,1),(113,'Đậu Xanh Đen Lòng',5,1),(114,'Bột Trà Rang Sato Hojicha Nhật Bản',5,1),(115,'Yến Mạch Organic Cán Cỡ Vừa Bobs Red Mill',5,1),(116,'Ngũ cốc siêu dinh dưỡng bà bầu QUEEN NATURE',5,1),(117,'Bột cacao nguyên chất Việt Nam',5,1),(118,'Bột ngũ cốc tập thể hình loại 1 Phương Uyên',5,1),(119,'Bột Đậu Đỏ Vũ Phát',5,1),(120,'Ngũ Cốc Nestle Fitnesse Socola',5,1),(121,'Thị Heo',6,1),(122,'Thịt Sườn Heo',6,1),(123,'Thịt Thủ Heo',6,1),(124,'Thịt Ba Chỉ Heo',6,1),(125,'Giò Heo',6,1),(126,'Thị Vai Heo',6,1),(127,'Thịt Diềm Heo',6,1),(128,'Thịt Má Heo',6,1),(129,'Lòng Heo',6,1),(130,'Sách Bò',6,1),(131,'Lòng Bò',6,1),(132,'Nạc Bò',6,1),(133,'Chân Bò',6,1),(134,'Xương Bò',6,1),(135,'Thịt Gà',6,1),(136,'Thịt Vịt',6,1),(137,'Thịt Dê',6,1),(138,'Trứng Gà',6,1),(139,'Trứng Vịt',6,1),(140,'Cá Thu',7,1),(141,'Cá Ngừ',7,1),(142,'Cá Cơm',7,1),(143,'Cá Chép',7,1),(144,'Lươn',7,1),(145,'Chạch',7,1),(146,'Cá Rô Phi',7,1),(147,'Cá Ba Sa',7,1),(148,'Cá Trắm',7,1),(149,'Cá Mè',7,1),(150,'Cá Trích',7,1),(151,'Cá Nục',7,1),(152,'Cá Liệt',7,1),(153,'Cá Trôi',7,1),(154,'Cá Chim',7,1),(155,'Cá Rô Đồng',7,1),(156,'Sữa',7,1),(157,'Mực',7,1),(158,'Bạch Tuộc',7,1),(159,'Cua Hoàng Đế',7,1),(160,'Ghẹ',7,1),(161,'Cua Tuyết',7,1),(162,'Ngao',7,1),(163,'Nghêu',7,1),(164,'Sò',7,1),(165,'Hến',7,1),(166,'Ốc Nhảy',7,1),(167,'Ốc Móng Tay',7,1),(168,'Ốc Hút',7,1),(169,'Ốc Gạo',7,1),(170,'Sò Điệp',7,1),(171,'Cua Đá',7,1),(172,'Ốc Hương',7,1),(173,'Ốc Gai',7,1),(174,'Ốc Giấy',7,1),(175,'Ốc Cùi',7,1);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-15 18:11:13
