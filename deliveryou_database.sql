CREATE DATABASE  IF NOT EXISTS `deliveryou` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `deliveryou`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: deliveryou
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `province` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `district` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `ward` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `street` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'sdsfsd','234234','dfgdgf','5746'),(2,'123213','wdwer','1232','dfgd3'),(3,'213123','2323','asdasfd','asfsa'),(4,'213123','2323','asdasfd','asfsa'),(5,'213123','2323','asdasfd','asfsa'),(6,'213123','2323','asdasfd','asfsa'),(7,'213123','2323','asdasfd','asfsa'),(8,'sadasd','sadasd','sadasd','sadasd'),(9,'213123','2323','asdasfd','asfsa'),(10,'sadasd','sadasd','sadasd','sadasd'),(11,'Tỉnh Cao Bằng','Huyện Hạ Lang','Xã Đồng Loan','342323'),(12,'Tỉnh Cao Bằng','Huyện Hạ Lang','Xã Đức Quang','123122'),(13,'Tỉnh Cao Bằng','Huyện Quảng Hòa','Xã Hồng Quang','3123424'),(14,'Tỉnh Bến Tre','Thành phố Bến Tre','Xã Mỹ Thạnh An','232'),(15,'Tỉnh Cao Bằng','Huyện Quảng Hòa','Xã Hồng Quang','3123424'),(16,'Tỉnh Bến Tre','Thành phố Bến Tre','Xã Mỹ Thạnh An','232'),(17,'Tỉnh Cao Bằng','Huyện Quảng Hòa','Xã Hồng Quang','3123424'),(18,'Tỉnh Bến Tre','Thành phố Bến Tre','Xã Mỹ Thạnh An','232'),(19,'Tỉnh Tuyên Quang','Huyện Na Hang','Xã Yên Hoa','234234'),(20,'Tỉnh Bến Tre','Huyện Mỏ Cày Nam','Xã An Thạnh','23423423'),(21,'Tỉnh Tuyên Quang','Huyện Na Hang','Xã Yên Hoa','234234'),(22,'Tỉnh Bến Tre','Huyện Mỏ Cày Nam','Xã An Thạnh','23423423'),(23,'Tỉnh Tuyên Quang','Huyện Na Hang','Xã Yên Hoa','234234'),(24,'Tỉnh Bến Tre','Huyện Mỏ Cày Nam','Xã An Thạnh','23423423'),(25,'Tỉnh Tuyên Quang','Huyện Na Hang','Xã Yên Hoa','234234'),(26,'Tỉnh Bến Tre','Huyện Mỏ Cày Nam','Xã An Thạnh','23423423'),(27,'Tỉnh Cao Bằng','Huyện Hạ Lang','Xã Đồng Loan','aaaa'),(28,'Tỉnh Cao Bằng','Huyện Hạ Lang','Xã Đồng Loan','aas'),(29,'Tỉnh Cao Bằng','Huyện Hạ Lang','Xã Đồng Loan','aaaa'),(30,'Tỉnh Cao Bằng','Huyện Hạ Lang','Xã Đồng Loan','aas'),(31,'Tỉnh Cao Bằng','Huyện Hạ Lang','Xã Đồng Loan','aaaa'),(32,'Tỉnh Cao Bằng','Huyện Hạ Lang','Xã Đồng Loan','aas'),(33,'Tỉnh Lạng Sơn','Thành phố Lạng Sơn','Xã Mai Pha','234234'),(34,'Tỉnh Cao Bằng','Huyện Hạ Lang','Xã Đức Quang','3423432'),(35,'213123','2323','asdasfd','asfsa'),(36,'sadasd','sadasd','sadasd','sadasd'),(37,'Tỉnh Cao Bằng','Huyện Hạ Lang','Xã Đức Quang','123213233'),(38,'Tỉnh Cao Bằng','Huyện Bảo Lạc','Xã Phan Thanh','123123123'),(39,'Tỉnh Cao Bằng','Huyện Hạ Lang','Xã Đồng Loan','2332'),(40,'Tỉnh Hà Giang','Huyện Bắc Quang','Xã Tân Quang','a213'),(41,'Tỉnh Sơn La','Huyện Quỳnh Nhai','Xã Pá Ma Pha Khinh','124234'),(42,'Tỉnh Điện Biên','Huyện Tủa Chùa','Xã Lao Xả Phình','124322'),(47,'Tỉnh Cao Bằng','Thành phố Cao Bằng','Phường Tân Giang','123'),(48,'Tỉnh Cao Bằng','Huyện Bảo Lâm','Xã Nam Cao','er');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `description` mediumtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Other',NULL),(2,'Food',NULL),(3,'Clothes',NULL),(4,'Electronics',NULL),(5,'Fragile',NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_registration`
--

DROP TABLE IF EXISTS `driver_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driver_registration` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `phone_number` varchar(20) NOT NULL,
  `citizen_id` varchar(45) NOT NULL,
  `avatar` longtext NOT NULL,
  `address_id` int DEFAULT NULL,
  `is_processed` tinyint NOT NULL,
  `message` text,
  `applied_date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`),
  KEY `fk_dr_address_idx` (`address_id`),
  CONSTRAINT `fk_dr_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_registration`
--

LOCK TABLES `driver_registration` WRITE;
/*!40000 ALTER TABLE `driver_registration` DISABLE KEYS */;
INSERT INTO `driver_registration` VALUES (1,'Kay','London','klondonay@gmail.com','0238475849','203748395734','https://d2qp0siotla746.cloudfront.net/img/use-cases/profile-picture/template_3.jpg',12,0,'My name is Kay London and I want to become your driver','2022-10-22');
/*!40000 ALTER TABLE `driver_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_method`
--

DROP TABLE IF EXISTS `payment_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_method` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `icon` longtext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_method`
--

LOCK TABLES `payment_method` WRITE;
/*!40000 ALTER TABLE `payment_method` DISABLE KEYS */;
INSERT INTO `payment_method` VALUES (1,'COD',''),(2,'Momo','');
/*!40000 ALTER TABLE `payment_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `shipper_id` int DEFAULT NULL,
  `receiver_name` varchar(100) NOT NULL,
  `receiver_phone` varchar(11) NOT NULL,
  `content` longtext NOT NULL,
  `order_date` datetime NOT NULL,
  `status_id` int NOT NULL,
  `payment_method_id` int NOT NULL,
  `promotion_id` int DEFAULT NULL,
  `category_id` int NOT NULL,
  `sender_address_id` int NOT NULL,
  `receiver_address_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_user_user_idx` (`user_id`),
  KEY `fk_order_user_shipper_idx` (`shipper_id`),
  KEY `fk_order_status_idx` (`status_id`),
  KEY `fk_order_payment_idx` (`payment_method_id`),
  KEY `fk_order_promotion_idx` (`promotion_id`),
  KEY `fk_order_category_idx` (`category_id`),
  KEY `fk_post_address_sender_idx` (`sender_address_id`),
  KEY `fk_post_address_receiver_idx` (`receiver_address_id`),
  CONSTRAINT `fk_order_payment` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`id`),
  CONSTRAINT `fk_order_promotion` FOREIGN KEY (`promotion_id`) REFERENCES `promotion` (`id`),
  CONSTRAINT `fk_order_status` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`),
  CONSTRAINT `fk_order_user_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_post_address_receiver` FOREIGN KEY (`receiver_address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `fk_post_address_sender` FOREIGN KEY (`sender_address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `fk_post_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_post_user_shipper` FOREIGN KEY (`shipper_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (15,2,NULL,'anne miller','0238384858','132123','2022-09-09 11:06:42',1,1,NULL,1,39,40),(16,2,NULL,'Ander','02374838493','','2022-09-09 14:57:19',2,1,NULL,4,41,42),(17,2,NULL,'NAssdf sdfsdf','0856485949','ewsdkfb','2022-09-09 15:37:22',3,1,NULL,1,47,48);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_auction`
--

DROP TABLE IF EXISTS `post_auction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_auction` (
  `post_id` int NOT NULL,
  `shipper_id` int NOT NULL,
  `request_time` datetime NOT NULL,
  `shipping_fee` int NOT NULL,
  `user_accepted` tinyint NOT NULL,
  PRIMARY KEY (`post_id`,`shipper_id`),
  KEY `fk_aution_user_shipper_idx` (`shipper_id`),
  CONSTRAINT `fk_aution_post` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
  CONSTRAINT `fk_aution_user_shipper` FOREIGN KEY (`shipper_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_auction`
--

LOCK TABLES `post_auction` WRITE;
/*!40000 ALTER TABLE `post_auction` DISABLE KEYS */;
INSERT INTO `post_auction` VALUES (15,3,'2022-09-26 15:14:37',20000,1),(16,3,'2022-10-06 22:57:27',2000,0);
/*!40000 ALTER TABLE `post_auction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_image`
--

DROP TABLE IF EXISTS `post_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` longtext NOT NULL,
  `post_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_orderimage_order_idx` (`post_id`),
  CONSTRAINT `fk_post_image_post` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_image`
--

LOCK TABLES `post_image` WRITE;
/*!40000 ALTER TABLE `post_image` DISABLE KEYS */;
INSERT INTO `post_image` VALUES (4,'http://res.cloudinary.com/de26tcplz/image/upload/v1662696397/UserPostsPreset/yry3qz2bynga6vvdl9bn.png',15),(5,'http://res.cloudinary.com/de26tcplz/image/upload/v1662710235/UserPostsPreset/kk2pmnakem3mtynppblp.png',16),(6,'http://res.cloudinary.com/de26tcplz/image/upload/v1662710235/UserPostsPreset/eshrofqzpwckdof3hxex.png',16),(7,'http://res.cloudinary.com/de26tcplz/image/upload/v1662712638/UserPostsPreset/p82xohuizrh0jibjo3jk.png',17);
/*!40000 ALTER TABLE `post_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promotion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `discount_amount` decimal(10,0) NOT NULL,
  `deleted` tinyint NOT NULL,
  `description` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating` (
  `user_id` int NOT NULL,
  `shipper_id` int NOT NULL,
  `comment` mediumtext,
  `rate` int NOT NULL,
  PRIMARY KEY (`user_id`,`shipper_id`),
  KEY `fk_rate_shipper_idx` (`shipper_id`),
  CONSTRAINT `fk_rate_shipper` FOREIGN KEY (`shipper_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_rate_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (3,'ROLE_ADMIN'),(2,'ROLE_SHIPPER'),(1,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `status_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`status_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (4,'CANCELED'),(3,'DELIVERED'),(1,'ONGOING'),(2,'PENDING');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `phone_number` varchar(20) NOT NULL,
  `password` varchar(200) NOT NULL,
  `citizen_id` varchar(45) DEFAULT NULL,
  `role_id` int NOT NULL,
  `avatar` longtext NOT NULL,
  `deleted` tinyint NOT NULL,
  `address_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `role_id` (`role_id`),
  KEY `fk_user_address_idx` (`address_id`),
  CONSTRAINT `fk_user_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'Andie','Warhol','Anne109@gmail.com','0838495831','$2a$10$Y4fn6PR9zA0szbDSj2Ui7OUmSgsKVDV9US/KTTBJT0bsnVRduSjT6',NULL,1,'https://wallpaperaccess.com/full/2213424.jpg',0,33),(3,'Styler','Bennecye','tlyer2342@gmail.com','0729384784','$2a$10$P/y8p1NqxuBlUQMzAgqDmO64gzaV3v0oZujdiGSRhsId/kY0L.F.O','16374657380',2,'https://blog-pixomatic.s3.appcnt.com/image/22/01/26/61f166e1e3b25/_orig/pixomatic_1572877090227.png',0,10),(4,'Kay','Brooke','BrookedKya@gmail.com','0238382830','$2a$10$9bvZ3yAWa.mzWOigIQIIdOYgYHKicIBp91kg7DUUmDMTRhhJoI7mq',NULL,3,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBwgu1A5zgPSvfE83nurkuzNEoXs9DMNr8Ww&usqp=CAU',0,29);
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

-- Dump completed on 2022-10-27  0:33:35
