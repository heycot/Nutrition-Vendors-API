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
  `update_date` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  KEY `shopitem_id` (`shopitem_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKhhmv6v1vbfqf2mgd2hkx8eekq` FOREIGN KEY (`shopitem_id`) REFERENCES `shopitem` (`id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`shopitem_id`) REFERENCES `shopitem` (`id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (5,7,'Tuyệt vời','Mình khá thích quán này, chất lượng tốt, hoa quả tươi sạch, đảm bảo xuất xứ,. Giá cả lại hợp lý, Cô chủ thì nhiệt tình',3,4.6,'2019-03-30 03:45:01.332772',1,'2019-04-15 07:59:31.489796'),(6,6,'Khá Ổn','Giá cả lại hợp lý, Cô chủ thì nhiệt tình',3,4.6,'2019-03-30 03:45:01.332772',1,'2019-04-15 07:59:31.489796'),(7,8,'Mọi thứ đều OK','Táo cực ngon, giá cả phải chăng, đồ tươi và sạch sẽ, quán dễ tìm',3,4.6,'2019-03-30 03:45:01.332772',1,'2019-04-15 07:59:31.489796'),(8,9,'Mình thích quán này','Đến nơi là cả thiên đường trái cây để chọn, cực kì ngon và tốt',3,4.8,'2019-03-30 03:45:01.332772',1,'2019-04-15 07:59:31.489796'),(9,3,'Yêu thích','Tối làm về khuya nên ghé mua hoa quả cho ngày mai, gần đóng quán mà cô chủ vẫn mở bán cho mình, rất nhiệt tình',3,4.8,'2019-03-30 03:45:01.332772',1,'2019-04-15 07:59:31.489796'),(10,4,'Cực kì nên mua luôn ạ','Táo ngon và sạch',3,4.8,'2019-03-30 03:45:01.332772',1,'2019-04-15 07:59:31.489796'),(11,5,'Khá ổn','Táo chất lượng mỹ mà giá cả việt nam, nhưng táo hơn to, mình thích táo nhỏ hơn :))',3,3.8,'2019-03-30 03:45:01.332772',1,'2019-04-15 07:59:31.489796'),(12,4,'Tuyệt vời quá luôn','Rất thích mua trái cây ở đây',3,4,'2019-03-31 04:48:19.000000',1,'2019-04-15 07:59:31.489796'),(14,2,'Nên mua','Cua khá tươi giá lại phải chăng',160,2,'2019-04-10 10:19:50.274000',1,'2019-04-15 07:59:31.489796'),(15,2,'Thịt ngon và tươi','thijt cực ngon và tươi luôn ta. Giá cả lại OK.',121,4,'2019-04-15 06:27:01.792000',1,'2019-04-15 07:59:31.489796'),(16,2,'không hài lòng lắm','Cho để bột hơi bị bụi và cũng k ngon nữa',105,1,'2019-04-15 07:02:30.811000',1,'2019-04-15 07:59:31.489796'),(17,2,'Cực kỳ thích luôn an','Suwax ngon kinh khủng luôn ý',145,3,'2019-04-15 07:42:35.231000',1,'2019-04-15 07:59:31.489796'),(18,2,'Táo xanh và ngon','taso thì ngon cực ta. Ngọt nữa. Chất lương tốt. Mà nghe bảo đâu là trồng hữu cơ nên an toàn cho sức khoẻ người tiêu dùng. nói chung e thích mua táo kẻ đây lắm. Thích cực, nên cho hẳn 5 sao :))',3,4,'2019-04-15 07:54:54.679000',1,'2019-04-15 07:59:31.489796'),(19,2,'Đào ngọt và ngon','Đào cũng khá là ngon đấy. Nhưng quán kẻ trong hẻm hơi khó đi chút xíu thôi',7,3,'2019-04-15 08:32:39.438000',1,'2019-04-15 08:32:39.438000'),(20,2,'Ăn mỳ chính nhiều không tốt đâu mấy bạn ơiiiiii','Khoong nên ăn mỳ chính nhé các bạn',32,1,'2019-04-15 09:11:59.683000',1,'2019-04-15 09:11:59.683000'),(21,2,'Mỳ chính cũng ngon mà','Khas là ngon đấy',32,2,'2019-04-15 09:12:46.880000',1,'2019-04-15 09:12:46.880000'),(22,2,'Gạo tám thơm và ngon lắm','Gao ngon mà dẻo. Lại thơm nữa. Thêm nức nhà luôn. Bà mình ăn mà cứ khen mãi. Nên nhà mình chỉ mua gạo ở đây thôi',74,3,'2019-04-15 09:54:31.264000',1,'2019-04-15 09:54:31.264000');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
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
