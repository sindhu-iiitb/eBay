CREATE DATABASE  IF NOT EXISTS `ecommerce` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ecommerce`;
-- MySQL dump 10.13  Distrib 5.5.49, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: ecommerce
-- ------------------------------------------------------
-- Server version	5.5.49-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `address_surkey` int(11) NOT NULL AUTO_INCREMENT,
  `u_surkey` int(11) NOT NULL,
  `line1` varchar(100) NOT NULL,
  `line2` varchar(100) DEFAULT NULL,
  `city` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `pincode` varchar(6) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `addresscol1` varchar(45) DEFAULT NULL,
  `addresscol2` varchar(45) DEFAULT NULL,
  `addresscol3` varchar(45) DEFAULT NULL,
  `addresscol4` varchar(45) DEFAULT NULL,
  `addresscol5` varchar(45) DEFAULT NULL,
  `addresscol6` varchar(45) DEFAULT NULL,
  `addresscol7` varchar(45) DEFAULT NULL,
  `addresscol8` varchar(45) DEFAULT NULL,
  `addresscol9` varchar(45) DEFAULT NULL,
  `addresscol10` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`address_surkey`),
  KEY `fk_address_1_idx` (`u_surkey`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (2,12,'Electronic city','Hosur road','banglore','Karnataka',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,15,'Electronic city','Hosur road','banglore','Karnataka','560100','9876543210',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,27,'26/c','electronic city ','banglore','karnataka','560100','9865328754',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,25,'26/g','electronic city ','banglore','karnataka','560100','9326586752',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,17,'26/g','electronic city ','banglore','karnataka','560100','9326586752',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,24,'Electronic city','Hosur road','banglore','Karnataka','560100','8985839066',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advt_detail_table`
--

DROP TABLE IF EXISTS `advt_detail_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advt_detail_table` (
  `adt_surkey` int(11) NOT NULL AUTO_INCREMENT,
  `advt_detail_id` varchar(45) NOT NULL,
  `cost` int(11) NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `advt_detail_tablecol` varchar(45) DEFAULT NULL,
  `advt_detail_tablecol1` varchar(45) DEFAULT NULL,
  `advt_detail_tablecol2` varchar(45) DEFAULT NULL,
  `advt_detail_tablecol3` varchar(45) DEFAULT NULL,
  `advt_detail_tablecol4` varchar(45) DEFAULT NULL,
  `advt_detail_tablecol5` varchar(45) DEFAULT NULL,
  `advt_detail_tablecol6` varchar(45) DEFAULT NULL,
  `advt_detail_tablecol7` varchar(45) DEFAULT NULL,
  `advt_detail_tablecol8` varchar(45) DEFAULT NULL,
  `advt_detail_tablecol9` varchar(45) DEFAULT NULL,
  `advt_detail_tablecol10` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`adt_surkey`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advt_detail_table`
--

LOCK TABLES `advt_detail_table` WRITE;
/*!40000 ALTER TABLE `advt_detail_table` DISABLE KEYS */;
INSERT INTO `advt_detail_table` VALUES (1,'advt1',1000,'0000-00-00','0000-00-00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `advt_detail_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank` (
  `b_surkey` int(11) NOT NULL AUTO_INCREMENT,
  `card_id` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `balance` int(11) DEFAULT NULL,
  `account_num` varchar(45) DEFAULT NULL,
  `u_surkey` int(11) DEFAULT NULL,
  `bankcol1` varchar(45) DEFAULT NULL,
  `bankcol2` varchar(45) DEFAULT NULL,
  `bankcol3` varchar(45) DEFAULT NULL,
  `bankcol4` varchar(45) DEFAULT NULL,
  `bankcol5` varchar(45) DEFAULT NULL,
  `bankcol6` varchar(45) DEFAULT NULL,
  `bankcol7` varchar(45) DEFAULT NULL,
  `bankcol8` varchar(45) DEFAULT NULL,
  `bankcol9` varchar(45) DEFAULT NULL,
  `bankcol10` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`b_surkey`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` VALUES (2,'54647667','abcd',99730700,'5757575',15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'2564456222','nvjs',39950,'5651521155',12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,'eBayAccount','ebay',-11050,'1234567890',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,'2564456222','nvjs',1200,'5651521155',17,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'2564456222','nvjs',1200,'5651521155',18,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'4444','siri',958100,'4444',19,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,'3333','dinesha',247100,'3333',20,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'5555','dummy',5829,'5555',24,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,'6666','6666',100000,'6666',27,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,'7777','7777',100000,'7777',25,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `cart_surkey` int(11) NOT NULL AUTO_INCREMENT,
  `u_surkey` int(11) NOT NULL,
  `i_surkey` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `deals_id` int(11) DEFAULT NULL,
  `freeitem` varchar(45) DEFAULT NULL,
  `freeitemprice` int(11) DEFAULT NULL,
  `freequantity` int(11) DEFAULT '0',
  `cartcol4` varchar(45) DEFAULT NULL,
  `cartcol5` varchar(45) DEFAULT NULL,
  `cartcol6` varchar(45) DEFAULT NULL,
  `cartcol7` varchar(45) DEFAULT NULL,
  `cartcol8` varchar(45) DEFAULT NULL,
  `cartcol9` varchar(45) DEFAULT NULL,
  `cartcol10` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cart_surkey`),
  KEY `fk_cart_1_idx` (`i_surkey`),
  KEY `fk_cart_2_idx` (`u_surkey`)
) ENGINE=InnoDB AUTO_INCREMENT=340 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (328,12,15,8,24,'No',0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(329,12,16,7,24,'No',0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(339,12,21,6,0,'No',0,6,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_sub_spec`
--

DROP TABLE IF EXISTS `cat_sub_spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_sub_spec` (
  `cat_id` int(11) DEFAULT NULL,
  `sub_cat_id` int(11) DEFAULT NULL,
  `specifications` varchar(1000) DEFAULT NULL,
  `cat_sub_spec_surkey` int(11) NOT NULL AUTO_INCREMENT,
  `cat_sub_speccol` varchar(45) DEFAULT NULL,
  `cat_sub_speccol1` varchar(45) DEFAULT NULL,
  `cat_sub_speccol2` varchar(45) DEFAULT NULL,
  `cat_sub_speccol3` varchar(45) DEFAULT NULL,
  `cat_sub_speccol4` varchar(45) DEFAULT NULL,
  `cat_sub_speccol5` varchar(45) DEFAULT NULL,
  `cat_sub_speccol6` varchar(45) DEFAULT NULL,
  `cat_sub_speccol7` varchar(45) DEFAULT NULL,
  `cat_sub_speccol8` varchar(45) DEFAULT NULL,
  `cat_sub_speccol9` varchar(45) DEFAULT NULL,
  `cat_sub_speccol10` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cat_sub_spec_surkey`),
  KEY `fk_cat_sub_spec_1` (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_sub_spec`
--

LOCK TABLES `cat_sub_spec` WRITE;
/*!40000 ALTER TABLE `cat_sub_spec` DISABLE KEYS */;
INSERT INTO `cat_sub_spec` VALUES (1,11,'x,y,z',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,21,'test1,test2,test3',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,14,'Lens size,Lens Focus,pixels',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1,10,'dfg,,',5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `cat_sub_spec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `parent` int(30) DEFAULT NULL,
  `class` int(30) DEFAULT NULL,
  `categorycol` varchar(45) DEFAULT NULL,
  `categorycol1` varchar(45) DEFAULT NULL,
  `categorycol2` varchar(45) DEFAULT NULL,
  `categorycol3` varchar(45) DEFAULT NULL,
  `categorycol4` varchar(45) DEFAULT NULL,
  `categorycol5` varchar(45) DEFAULT NULL,
  `categorycol6` varchar(45) DEFAULT NULL,
  `categorycol7` varchar(45) DEFAULT NULL,
  `categorycol8` varchar(45) DEFAULT NULL,
  `categorycol9` varchar(45) DEFAULT NULL,
  `categorycol10` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Audio and Home Entertainment',0,1,'null','null','null','null','null','null','null','null','null','null','null'),(2,'Cameras and Optics',0,2,'null','null','null','null','null','null','null','null','null','null','null'),(3,'Data Storage',0,3,'null','null','null','null','null','null','null','null','null','null','null'),(4,'Fashion',0,4,'null','null','null','null','null','null','null','null','null','null','null'),(5,'Home and Living',0,5,'null','null','null','null','null','null','null','null','null','null','null'),(6,'Laptops and Computer Peripherals',0,6,'null','null','null','null','null','null','null','null','null','null','null'),(7,'Mobile Phones and Accessories',0,7,'null','null','null','null','null','null','null','null','null','null','null'),(8,'Fragrances, Beauty & Health',0,8,'null','null','null','null','null','null','null','null','null','null','null'),(9,'Other',0,9,'null','null','null','null','null','null','null','null','null','null','null'),(10,'LCD LED and Televisions',1,1,'null','null','null','null','null','null','null','null','null','null','null'),(11,'Gaming Consoles',1,1,'null','null','null','null','null','null','null','null','null','null','null'),(12,'Home Theatre and Accessories',1,1,'null','null','null','null','null','null','null','null','null','null','null'),(13,'Portable audio and video',1,1,'null','null','null','null','null','null','null','null','null','null','null'),(14,'Digital Cameras',2,2,'null','null','null','null','null','null','null','null','null','null','null'),(15,'Cameras Camcorder Accessories',2,2,'null','null','null','null','null','null','null','null','null','null','null'),(16,'SLR Camera Lenses',2,2,'null','null','null','null','null','null','null','null','null','null','null'),(17,'Film Camera SLR',2,2,'null','null','null','null','null','null','null','null','null','null','null'),(18,'Pen Drives',3,3,'null','null','null','null','null','null','null','null','null','null','null'),(19,'Memory cards',3,3,'null','null','null','null','null','null','null','null','null','null','null'),(20,'Hard Drives',3,3,'null','null','null','null','null','null','null','null','null','null','null'),(21,'Internal Hard Drives',3,3,'null','null','null','null','null','null','null','null','null','null','null'),(22,'Clothing and Accessories',4,4,'null','null','null','null','null','null','null','null','null','null','null'),(23,'Watches',4,4,'null','null','null','null','null','null','null','null','null','null','null'),(24,'Shoes',4,4,'null','null','null','null','null','null','null','null','null','null','null'),(25,'Jewellery and precious Stones',4,4,'null','null','null','null','null','null','null','null','null','null','null'),(26,'Kitchen and Dining',5,5,'null','null','null','null','null','null','null','null','null','null','null'),(27,'Furniture',5,5,'null','null','null','null','null','null','null','null','null','null','null'),(28,'Home Appliances',5,5,'null','null','null','null','null','null','null','null','null','null','null'),(29,'Home Decor',5,5,'null','null','null','null','null','null','null','null','null','null','null'),(30,'Ipads and tablets',6,6,'null','null','null','null','null','null','null','null','null','null','null'),(31,'Laptops',6,6,'null','null','null','null','null','null','null','null','null','null','null'),(32,'Wireless Networking',6,6,'null','null','null','null','null','null','null','null','null','null','null'),(33,'PC tools and Laptop Accessories',6,6,'null','null','null','null','null','null','null','null','null','null','null'),(34,'Mobile Phones',7,7,'null','null','null','null','null','null','null','null','null','null','null'),(35,'Mobile Accessories',7,7,'null','null','null','null','null','null','null','null','null','null','null'),(36,'Cases Pouches',7,7,'null','null','null','null','null','null','null','null','null','null','null'),(37,'Bluetooth Devices',7,7,'null','null','null','null','null','null','null','null','null','null','null'),(38,'Bath and Spa',8,8,'null','null','null','null','null','null','null','null','null','null','null'),(39,'Perfumes',8,8,'null','null','null','null','null','null','null','null','null','null','null'),(40,'Make up',8,8,'null','null','null','null','null','null','null','null','null','null','null'),(41,'Body and skin Care',8,8,'null','null','null','null','null','null','null','null','null','null','null'),(42,'Auto accessories and parts',9,9,'null','null','null','null','null','null','null','null','null','null','null'),(43,'Books and magazines',9,9,'null','null','null','null','null','null','null','null','null','null','null'),(44,'Fitness and Sports',9,9,'null','null','null','null','null','null','null','null','null','null','null'),(45,'Toy games and baby',9,9,'null','null','null','null','null','null','null','null','null','null','null'),(46,'Airplanes',0,46,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deals`
--

DROP TABLE IF EXISTS `deals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deals` (
  `deals_id` int(11) NOT NULL AUTO_INCREMENT,
  `itemid1` int(11) DEFAULT NULL,
  `itemid2` int(11) DEFAULT NULL,
  `freeitemid` int(11) DEFAULT NULL,
  `sellerid` int(11) DEFAULT NULL,
  `dealstitle` varchar(45) DEFAULT NULL,
  `dealscost` int(11) DEFAULT NULL,
  `dealscol` varchar(45) DEFAULT NULL,
  `dealscol1` varchar(45) DEFAULT NULL,
  `dealscol2` varchar(45) DEFAULT NULL,
  `dealscol3` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`deals_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deals`
--

LOCK TABLES `deals` WRITE;
/*!40000 ALTER TABLE `deals` DISABLE KEYS */;
INSERT INTO `deals` VALUES (24,15,16,21,10,'Best Deal Ever',16000,NULL,NULL,NULL,NULL),(25,45,45,45,10,'Best Deal Ever1',2000,NULL,NULL,NULL,NULL),(26,23,23,22,10,'Best Deal Ever 2',4000,NULL,NULL,NULL,NULL),(27,26,25,25,10,'Best Deal Ever 3',10000,NULL,NULL,NULL,NULL),(28,47,46,47,10,'Best Deal Ever 4',10000,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `deals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `i_surkey` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(100) NOT NULL,
  `picture` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `item_desc` varchar(45) NOT NULL,
  `s_surkey` int(11) NOT NULL,
  `discount` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `num_of_items_sold` varchar(45) DEFAULT NULL,
  `warranty` varchar(45) NOT NULL,
  `advt_status` varchar(3) NOT NULL,
  `adt_surkey` int(11) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `condition` varchar(100) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `duration` varchar(100) DEFAULT NULL,
  `paymentmode` varchar(100) DEFAULT NULL,
  `shippingdetails` varchar(100) DEFAULT NULL,
  `handlingtime` int(100) DEFAULT NULL,
  `shippingcost` int(5) DEFAULT '0',
  `c_surkey` int(11) NOT NULL,
  `sc_surkey` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `serviced_in_india` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `material` varchar(45) DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `items_in_deal` varchar(100) DEFAULT NULL,
  `deal_eligible` varchar(45) DEFAULT NULL,
  `deal_added` varchar(45) DEFAULT 'No',
  `deal_title` varchar(45) DEFAULT NULL,
  `itemid` varchar(45) DEFAULT NULL,
  `itemcol` varchar(45) DEFAULT NULL,
  `itemcol1` varchar(45) DEFAULT NULL,
  `itemcol2` varchar(45) DEFAULT NULL,
  `itemcol3` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`i_surkey`),
  KEY `c_surkey` (`c_surkey`),
  KEY `s_surkey` (`s_surkey`),
  KEY `fk_item_1_idx` (`adt_surkey`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'MobilePhone','Images/1.jpg',5000,'BestMobilePhone',10,0,0,'','1','yes',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'courier',4,0,7,34,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(2,'Book 1','Images/bhagavad-gita.jpg',1000,'Best Book',13,0,4,'23','1','No',NULL,'white','old',50,'Pearson','2016-04-21','12','debit','courier',6,0,9,43,'Engineering book',NULL,'Raga',12,'Handmade paper',NULL,NULL,0,'','Yes','No','','Book 1_2',NULL,NULL,NULL,NULL),(3,'ittem1','Images/9.jpg',900,'hyunjn',1,0,0,'1','1','yes',1,'blue','bgr',3,'sony','2020-02-02','2','ede','flat',2,0,1,10,'gtg','hby','njn',0,'ujj',NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(4,'ninja','Images/1.jpg',5000,'good game',1,0,0,'1','1','yes',1,'','new',4,'easports','0000-00-00','14','debit','flat',5,0,1,11,'child game','yes','',0,'blueray',NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(5,'Speakers','Images/2.jpg',10000,'High quality speakers',1,0,10,'2','1','yes',1,'Black','new',50,'Bosch','0000-00-00','14','debit','courier',5,0,1,12,'Speakers','yes','DTS',10,'Silicon',NULL,NULL,NULL,NULL,'No','No',NULL,NULL,NULL,NULL,NULL,NULL),(6,'ipods','Images/3.jpg',5000,'Ipod 5 gen ',1,0,10,'2','1','yes',1,'white','new',10,'Apple','0000-00-00','14','debit','flat',7,0,1,13,'ipod','yes',NULL,0,'synthetic',NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(7,'Nikon Camera','Images/7.jpg',25000,'HD cam',1,0,10,'1','2','yes',1,'black','new',10,'Nikon','0000-00-00','14','debit','courier',7,0,2,14,'Lens','yes','Nikon',5,'Bluray',NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(8,'Nikon Camera Lens','Images/8.jpg',25000,'HD cam',1,0,3,'1','2','yes',1,'black','new',10,'Nikon','0000-00-00','14','debit','flat',7,0,2,16,'Lens','yes','Nikon',5,'Bluray',NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(9,'camcorder','Images/7.jpg',25000,'HD cam',1,0,3,'1','2','yes',1,'black','new',10,'Nikon','0000-00-00','14','debit','courier',7,0,2,15,'Lens','yes','Nikon',5,'Bluray',NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(10,'SLR Camera','Images/7.jpg',25000,'HD cam',1,0,3,'1','2','yes',1,'black','new',10,'Nikon','0000-00-00','14','debit','flat',7,0,2,17,'Lens','yes','Nikon',5,'Bluray',NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(11,'Samsung LED','Images/samsung.jpg',50000,'HD resolution',1,20,0,'2','1','no',1,'black','new',10,'onida','0000-00-00','21','debit','flat',7,0,1,10,'led tv','yes','samsung 5520',24,'Hd',NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(12,'Onida LED','Images/onida.png',70000,'HD resolution',1,15,1,'4','1','yes',1,'blue','new',8,'onida','0000-00-00','21','debit','courier',7,0,1,10,'led tv','yes','onida5520',24,'Hd',NULL,NULL,NULL,NULL,'No','No',NULL,NULL,NULL,NULL,NULL,NULL),(13,'Philips LED','Images/philips.jpeg',35000,'HD resolution',1,20,10,'2','1','no',1,'black','new',10,'sony','0000-00-00','21','debit','flat',7,0,1,10,'led tv','yes','Philips 520',24,'Hd',NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(14,'Sony LED','Images/sonytv.jpeg',65000,'HD resolution',1,20,10,'2','1','no',1,'green','new',10,'sony','0000-00-00','21','debit','courier',7,0,1,10,'led tv','yes','samsung 5520',24,'Hd',NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(15,'watch1','Images/china-mobile1.jpg',8000,'watch',10,0,10,'3','q','Yes',1,'pink','new',50,'sony','2016-04-22','1','1','q',1,0,1,11,'q','y','q',1,'q','2016-04-09','2016-04-16',7000,'15,16,21','Yes','Yes','Best Deal Ever','watch1_15',NULL,NULL,NULL,NULL),(16,'watch2','Images/$_1j16.jpg',8000,'watch',10,0,10,'3','q','yes',NULL,'q','old',NULL,'q',NULL,'1','1','q',1,0,1,11,'q','y','q',1,'q',NULL,NULL,NULL,'15,16,21','Yes','Yes','Best Deal Ever',NULL,NULL,NULL,NULL,NULL),(17,'watch3','Images/$_1j16.jpg',8000,'watch',22,0,1,'0','q','yes',NULL,'q','old',NULL,'fdwq',NULL,'1','1','dawdwq',1,0,1,11,'q','y','dbasjfd',1,'q',NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(18,'itemnew','Images/$_1j16.jpg',8000,'watch',22,0,0,'0','q','yes',NULL,'q','old',NULL,'q',NULL,'1','1','q',1,0,1,11,'q','y','q',1,'q',NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(19,'Console1','Images/$_1j16.jpg',5000,'Best Console',23,0,0,'0','1','yes',NULL,'white','new',NULL,'Nokia',NULL,'10','debit','With in India',1,0,1,11,'NA','y','123',1,'Plastic',NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(20,'dress100','Images/4.jpg',3,'dress',10,1,7,'0','q','yes',NULL,'q','old',NULL,'q',NULL,'1','1','q',1,0,1,11,'q','y','q',1,'q',NULL,NULL,NULL,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(21,'dress1','Images/4.jpg',3,'dress',10,1,6,'3','q','yes',NULL,'q','old',NULL,'q',NULL,'1','1','q',1,300,1,11,'q','y','q',1,'q',NULL,NULL,NULL,'15,16,21','Yes','Yes','Best Deal Ever',NULL,NULL,NULL,NULL,NULL),(22,'dress10','Images/Dress.jpg',3000,'dress',10,10,2,'4','1','yes',NULL,'q','old',NULL,'q',NULL,'1','1','q',1,50,1,11,'q','y','q',1,'q','2016-03-25','2016-03-27',2,'23,23,22','Yes','Yes','Best Deal Ever 2',NULL,NULL,NULL,NULL,NULL),(23,'dress11','Images/Saree.jpg',2000,'dress',10,30,8,'7','1','Yes',1,'black','new',50,'q','2016-04-22','1','1','q',1,100,1,11,'q','y','q',1,'q','2016-03-08','2016-03-18',10000,'23,23,22','Yes','Yes','Best Deal Ever 2','dress11_23',NULL,NULL,NULL,NULL),(24,'dress12','Images/Dress.jpg',1000,'dress',10,20,1,'1','1','yes',NULL,'q','old',NULL,'q',NULL,'1','1','q',1,100,1,11,'q','y','q',1,'q','2016-03-25','2016-03-27',2000,'','Yes','No','',NULL,NULL,NULL,NULL,NULL),(25,'cam1','Images/$_116.jpg',5000,'camera',10,1,1,'6','q','yes',1,'white','old',NULL,'q',NULL,'1','1','q',1,0,2,14,'q','y','q',1,'q','2016-03-25','2016-03-29',8000,'26,25,25','Yes','Yes','Best Deal Ever 3',NULL,NULL,NULL,NULL,NULL),(26,'cam2','Images/$_116.jpg',5000,'camera',10,1,2,'3','q','yes',1,'white','old',NULL,'q',NULL,'1','1','q',1,0,2,14,'q','y','q',1,'q','2016-03-25','2016-03-29',8000,'26,25,25','Yes','Yes','Best Deal Ever 3',NULL,NULL,NULL,NULL,NULL),(27,'dummy1','Images/1.jpg',5000,'dummy1',25,10,0,'0','1','yes',1,'white','new',0,'NA',NULL,'12','debit','NA',12,100,3,20,'NA','y','123',12,'ajksd','2015-03-26','2015-03-29',6000,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(28,'dummy2','Images/4.jpg',5000,'dummy2',25,5,0,'0','1','yes',1,'white','new',NULL,'NA',NULL,'12','debit','NA',13,50,3,21,'NA','y','133',12,'dnqwjdn','2015-03-26','2015-03-29',6000,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(29,'dummy3','Images/mxSHo9cTUqG2daSVO9fxlZQ.jpg',1000,'dummy3',25,10,0,'0','1','yes',1,'white','new',NULL,'dnajksnd',NULL,'12','debit','NA',5,50,3,21,'dasdq','y','16',12,'dqwdq','2015-03-26','2015-03-29',6000,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(30,'Titan watch','Images/watch.jpg',2000,'Best Watch',27,10,9,'1','1','yes',1,'pink','new',NULL,'Titan',NULL,'12','debit','NA',12,100,4,23,'Women','n','Raga',12,'Metal','2015-03-26','2015-03-29',3000,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(32,'it02','Images/china-mobile1.jpg',500,'item02',13,10,10,'0','4','Yes',1,'pink','new',5,'nike','2016-04-22','5','debit','bangalore',4,100,1,10,'new','y','2010',5,'new','2016-09-07','2017-09-21',379000,'','No','No','','it02_32',NULL,NULL,NULL,NULL),(33,'pendrive','Images/$_1j16.jpg',100,'pendrive',13,10,4,'0','1','yes',1,'white','new',1,'sony',NULL,'5','debit','bangalore',20,10,3,18,'new','y','pend1.0',3,'new','2015-11-04','2016-11-04',18000,'','Yes','No','',NULL,NULL,NULL,NULL,NULL),(34,'item12','Images/$_1j16.jpg',100,'item1',13,10,4,'0','4','Yes',1,'white','old',10,'onida','2016-04-18','5','debit','bangalore',65,100,1,11,'onida','y','2010',6,'','2016-11-04','2016-12-04',-19000,'','Yes','No','','item12_34',NULL,NULL,NULL,NULL),(36,'item102','Images/9.jpg',1000,'item01',13,10,10,'0','4','Yes',1,'black','old',5,'onida','2016-04-22','5','debit','bangalore',4,100,1,10,'new','y','2010',5,'neew','2016-04-06','2016-04-15',9000,'','Yes','No','','item102_36',NULL,NULL,NULL,NULL),(37,'item103','Images/blank-star.png',1000,'item01',13,10,10,'0','4','No',NULL,'green','new',5,'onida','2016-04-21','5','debit','bangalore',4,100,1,10,'new','y','2010',5,'neew',NULL,NULL,0,'','Yes','No','','item103_37',NULL,NULL,NULL,NULL),(38,'item104','Images/bhagavad-gita.jpg',1000,'item01',13,10,10,'0','4','No',NULL,'pink','refurbished',5,'onida','2016-04-21','5','debit','bangalore',4,100,1,10,'new','y','2010',5,'neew',NULL,NULL,0,'','Yes','No','','item104_38',NULL,NULL,NULL,NULL),(39,'item105','Images/5.jpg',1000,'item01',13,10,10,'0','4','yes',1,'white','new',5,'onida',NULL,'5','debit','bangalore',4,100,1,10,'new','y','2010',5,'neew','2015-11-04','2016-11-04',18000,'','Yes','No','',NULL,NULL,NULL,NULL,NULL),(40,'item106','Images/cal.gif',1000,'item01',13,10,10,'0','4','No',NULL,'grey','refurbished',5,'onida','2016-04-22','5','debit','bangalore',4,100,1,10,'new','y','2010',5,'neew',NULL,NULL,0,'','Yes','No','','item106_40',NULL,NULL,NULL,NULL),(41,'item107','Images/5.jpg',1000,'item01',13,10,8,'2','4','yes',1,'white','new',5,'onida',NULL,'5','debit','bangalore',4,100,1,10,'new','y','2010',5,'neew','2015-11-04','2016-11-04',18000,'','Yes','No','',NULL,NULL,NULL,NULL,NULL),(42,'item108','Images/5.jpg',1000,'item01',13,10,9,'1','4','yes',1,'white','new',5,'onida',NULL,'5','debit','bangalore',4,100,1,10,'new','y','2010',5,'neew','2015-11-04','2016-11-04',18000,'','Yes','No','',NULL,NULL,NULL,NULL,NULL),(43,'item109','Images/5.jpg',1000,'item01',13,10,10,'0','4','yes',1,'white','new',5,'onida',NULL,'5','debit','bangalore',4,100,1,10,'new','y','2010',5,'neew','2015-11-04','2016-11-04',18000,NULL,'Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(44,'Airplane1','Images/5.jpg',10000000,'Best airplane in the world',13,10,15,'0','1','no',NULL,'grey','new',50,'Pearson','2016-04-18','12','debit','fghfg',12,100,4,24,'NA','yes','Raga',12,'Metal',NULL,NULL,NULL,NULL,'yes','No',NULL,'Airplane1_44',NULL,NULL,NULL,NULL),(45,'Unix book','Images/unix-book.jpg',1000,'reference book for unix',10,5,7,'9','1','yes',1,'white','old',50,'Pearson','2016-04-18','12','debit','With in india - 18-04-16',12,50,3,20,'Engineering book','yes','Bulk',0,'Handmade paper','2016-04-18','2017-04-18',17000,'45,45,45','Yes','Yes','Best Deal Ever1','Unix book_45',NULL,NULL,NULL,NULL),(46,'hard disk','Images/mBfopjRa5M66mDNBvPJvEkA.jpg',5000,'best hd in the world',10,10,0,'12','1','yes',1,'black','new',50,'sandisk','2016-04-18','12','debit','with in india',12,100,3,20,'flash','yes','WD',12,'Metal','2016-04-18','2016-04-20',2000,'47,46,47','Yes','Yes','Best Deal Ever 4','hard disk_46',NULL,NULL,NULL,NULL),(47,'Perfume','Images/deodorant.jpg',5000,'Best Perfume',10,10,8,'6','1','Yes',1,'pink','new',50,'Blue lady','2016-05-07','12','debit','In india',12,100,8,38,'Women','yes','Raga',12,'Glass','2016-04-22','2016-04-30',8000,'47,46,47','Yes','Yes','Best Deal Ever 4','Perfume_47',NULL,NULL,NULL,NULL),(48,'pen','Images/6.jpg',6000,'best pen in the world',10,10,10,'0','1','Yes',1,'black','old',50,'Pearson','2016-04-22','12','debit','With in india',12,100,3,18,'Women','no','Raga',12,'Metal','2016-04-15','2016-04-23',8000,NULL,'No','No',NULL,'pen_48',NULL,NULL,NULL,NULL),(49,'Necklace','Images/mm4SHU4rCHT10VMf_u4fjdA.jpg',100000,'Diamond Necklace',13,10,10,'0','1','Yes',1,'white','new',50,'Ankur','2017-05-03','12','debit','Servied in India',10,500,4,25,'Diamond','yes','Cut',10,'stones','2016-04-22','2016-04-22',0,NULL,'No','No',NULL,'Necklace_49',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemspecattributes`
--

DROP TABLE IF EXISTS `itemspecattributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemspecattributes` (
  `is_surkey` int(11) NOT NULL AUTO_INCREMENT,
  `attribute` varchar(45) NOT NULL,
  `value` varchar(45) NOT NULL,
  `i_surkey` int(11) NOT NULL,
  `itemspecattributescol` varchar(45) DEFAULT NULL,
  `itemspecattributescol1` varchar(45) DEFAULT NULL,
  `itemspecattributescol2` varchar(45) DEFAULT NULL,
  `itemspecattributescol3` varchar(45) DEFAULT NULL,
  `itemspecattributescol4` varchar(45) DEFAULT NULL,
  `itemspecattributescol5` varchar(45) DEFAULT NULL,
  `itemspecattributescol6` varchar(45) DEFAULT NULL,
  `itemspecattributescol7` varchar(45) DEFAULT NULL,
  `itemspecattributescol8` varchar(45) DEFAULT NULL,
  `itemspecattributescol9` varchar(45) DEFAULT NULL,
  `itemspecattributescol10` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`is_surkey`),
  KEY `fk_itemspecattributes_1_idx` (`i_surkey`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemspecattributes`
--

LOCK TABLES `itemspecattributes` WRITE;
/*!40000 ALTER TABLE `itemspecattributes` DISABLE KEYS */;
INSERT INTO `itemspecattributes` VALUES (1,'x','null',10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'y','null',10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'z','null',10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'x','one',18,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'y','two',18,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'z','three',18,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'x','one',19,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'y','two',19,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'z','three',19,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'x','one',20,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'y','two',20,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'z','three',20,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,'x','one',20,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,'y','two',20,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'z','three',20,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'x','one',22,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,'y','two',22,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'z','three',22,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,'x','one',22,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,'y','two',22,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,'z','three',22,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,'x','one',22,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,'y','two',22,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(27,'z','three',22,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,'x','a',34,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,'y','b',34,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,'z','c',34,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `itemspecattributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `o_surkey` int(11) NOT NULL AUTO_INCREMENT,
  `u_surkey` int(11) NOT NULL,
  `orderdate` date NOT NULL,
  `reqdate` date DEFAULT NULL,
  `shipdate` date DEFAULT NULL,
  `salestax` decimal(2,2) NOT NULL,
  `status` varchar(100) NOT NULL,
  `timestamp` time NOT NULL,
  `numofdays` int(11) DEFAULT NULL,
  `deliverydate` date DEFAULT NULL,
  `totalamount` int(11) DEFAULT NULL,
  `line1` varchar(100) DEFAULT NULL,
  `line2` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `pincode` varchar(6) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `seller_status` varchar(45) DEFAULT NULL,
  `user_status` varchar(45) DEFAULT NULL,
  `user_cardnum` varchar(45) DEFAULT NULL,
  `ordercol` varchar(45) DEFAULT NULL,
  `ordercol1` varchar(45) DEFAULT NULL,
  `ordercol2` varchar(45) DEFAULT NULL,
  `ordercol3` varchar(45) DEFAULT NULL,
  `ordercol4` varchar(45) DEFAULT NULL,
  `ordercol5` varchar(45) DEFAULT NULL,
  `ordercol6` varchar(45) DEFAULT NULL,
  `ordercol7` varchar(45) DEFAULT NULL,
  `ordercol8` varchar(45) DEFAULT NULL,
  `ordercol9` varchar(45) DEFAULT NULL,
  `ordercol10` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`o_surkey`),
  KEY `u_surkey` (`u_surkey`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (34,15,'2016-04-17','2016-04-17','2016-04-17',0.25,'Money Paid','14:42:31',8,'2016-04-17',4000,'dummy','dummy2','Banglore','Karnataka','560100','8099','Payment Recieved','Payment Done','4444',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,15,'2016-04-17','2016-04-17','2016-04-17',0.25,'Money Paid','14:45:38',8,'2016-04-17',2000,'dummy','dummy2','Banglore','Karnataka','560100','8099','Payment Recieved','Payment Done','4444',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,15,'2016-04-17','2016-04-17','2016-04-17',0.25,'Money Paid','14:47:36',8,'2016-04-17',4000,'dummy','dummy2','Banglore','Karnataka','560100','8099','Payment Recieved','Payment Done','4444',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(37,15,'2016-04-17','2016-04-17','2016-04-17',0.25,'Money Paid','14:49:33',8,'2016-04-17',4000,'dummy','dummy2','Banglore','Karnataka','560100','8099','Payment Recieved','Payment Done','4444',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(38,15,'2016-04-17','2016-04-17','2016-04-17',0.25,'Received','15:18:27',8,'2016-04-17',63150,'Electronic city','Hosur road','banglore','Karnataka','0','0','Payment Recieved','Payment Done','4444',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(39,15,'2016-04-18','2016-04-18','2016-04-18',0.25,'Received','19:33:05',8,'2016-04-18',18100,'Electronic city','Hosur road','banglore','Karnataka','0','0','Payment Recieved','Payment Done','4444',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(40,15,'2016-04-18','2016-04-18','2016-04-18',0.25,'Received','19:44:03',8,'2016-04-18',9100,'Electronic city','Hosur road','banglore','Karnataka','0','0','Payment Recieved','Payment Done','4444',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,15,'2016-04-22','2016-04-22','2016-04-22',0.25,'Received','21:46:21',8,'2016-04-22',39950,'Electronic city','Hosur road','banglore','Karnataka','0','0','Payment Recieved','Payment Done','4444',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(42,15,'2016-04-22','2016-04-22','2016-04-22',0.25,'Received','22:09:21',8,'2016-04-22',39950,'Electronic city','Hosur road','banglore','Karnataka','0','0','Payment Recieved','Payment Done','4444',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(43,15,'2016-04-22','2016-04-22','2016-04-22',0.25,'Received','22:54:42',8,'2016-04-22',39950,'Electronic city','Hosur road','banglore','Karnataka','0','0','Payment Recieved','Payment Done','4444',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,12,'2016-04-25','2016-04-25','2016-04-25',0.25,'Money Paid','20:17:04',8,'2016-04-25',1950,'Electronic city','Hosur road','banglore','Karnataka','0','0','Payment Recieved','Payment Done','4444',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderspecific`
--

DROP TABLE IF EXISTS `orderspecific`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderspecific` (
  `os_surkey` int(11) NOT NULL AUTO_INCREMENT,
  `o_surkey` int(11) NOT NULL,
  `i_surkey` int(11) NOT NULL,
  `s_surkey` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `priceafterdiscount` int(11) NOT NULL,
  `salestax` int(11) DEFAULT NULL,
  `freequantity` int(11) DEFAULT NULL,
  `item_status` varchar(45) DEFAULT NULL,
  `orderspecificcol2` varchar(45) DEFAULT NULL,
  `orderspecificcol3` varchar(45) DEFAULT NULL,
  `orderspecificcol4` varchar(45) DEFAULT NULL,
  `orderspecificcol5` varchar(45) DEFAULT NULL,
  `orderspecificcol6` varchar(45) DEFAULT NULL,
  `orderspecificcol7` varchar(45) DEFAULT NULL,
  `orderspecificcol8` varchar(45) DEFAULT NULL,
  `orderspecificcol9` varchar(45) DEFAULT NULL,
  `orderspecificcol10` varchar(45) DEFAULT NULL,
  `orderspecificcol11` varchar(45) DEFAULT NULL,
  `orderspecificcol12` varchar(45) DEFAULT NULL,
  `orderspecificcol13` varchar(45) DEFAULT NULL,
  `orderspecificcol14` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`os_surkey`),
  KEY `o_surkey_idx` (`o_surkey`),
  KEY `i_surkey_idx` (`i_surkey`),
  KEY `s_surkey` (`s_surkey`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderspecific`
--

LOCK TABLES `orderspecific` WRITE;
/*!40000 ALTER TABLE `orderspecific` DISABLE KEYS */;
INSERT INTO `orderspecific` VALUES (24,34,2,13,5,1000,14,1,'Money Paid',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,35,42,13,1,1000,14,0,'Money Paid',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,35,41,13,2,1000,14,1,'Money Paid',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(27,36,2,13,6,1000,14,2,'Money Paid',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,37,2,13,6,1000,14,2,'Money Paid',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,38,22,10,1,2750,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,38,24,10,1,900,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(31,38,23,10,1,1500,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(32,38,12,13,1,59500,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(33,39,46,10,6,4600,14,2,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,40,46,10,3,4600,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,41,15,10,1,8000,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,41,16,10,1,8000,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(37,41,21,10,1,303,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(38,41,45,10,3,1000,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(39,41,23,10,2,1500,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(40,41,22,10,1,2750,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,41,26,10,1,4950,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(42,41,25,10,2,4950,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(43,41,47,10,2,4600,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,41,46,10,1,4600,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(45,41,15,10,1,8000,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(46,41,16,10,1,8000,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(47,41,21,10,1,303,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(48,42,15,10,1,8000,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(49,42,16,10,1,8000,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(50,42,21,10,1,303,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(51,42,45,10,3,1000,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(52,42,23,10,2,1500,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(53,42,22,10,1,2750,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(54,42,26,10,1,4950,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(55,42,25,10,2,4950,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(56,42,47,10,2,4600,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(57,42,46,10,1,4600,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(58,43,47,10,2,4600,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(59,43,46,10,1,4600,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(60,43,26,10,1,4950,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(61,43,25,10,2,4950,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(62,43,23,10,2,1500,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(63,43,22,10,1,2750,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(64,43,45,10,3,1000,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(65,43,15,10,1,8000,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(66,43,16,10,1,8000,14,0,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(67,43,21,10,1,303,14,1,'Shipped',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `orderspecific` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller`
--

DROP TABLE IF EXISTS `seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seller` (
  `s_surkey` int(11) NOT NULL AUTO_INCREMENT,
  `seller_id` varchar(45) DEFAULT NULL,
  `feedback` varchar(1000) DEFAULT NULL,
  `sellershop` varchar(2083) DEFAULT NULL,
  `u_surkey` int(11) NOT NULL,
  `b_surkey` int(11) NOT NULL,
  `rating` decimal(10,2) DEFAULT '0.00',
  `nature_of_business` varchar(1000) DEFAULT NULL,
  `line1` varchar(100) DEFAULT NULL,
  `line2` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `pincode` int(40) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `Num_of_buyers_rated` int(11) DEFAULT '0',
  `sellercol10` varchar(45) DEFAULT NULL,
  `sellercol` varchar(45) DEFAULT NULL,
  `sellercol1` varchar(45) DEFAULT NULL,
  `sellercol2` varchar(45) DEFAULT NULL,
  `sellercol3` varchar(45) DEFAULT NULL,
  `sellercol4` varchar(45) DEFAULT NULL,
  `sellercol5` varchar(45) DEFAULT NULL,
  `sellercol6` varchar(45) DEFAULT NULL,
  `sellercol7` varchar(45) DEFAULT NULL,
  `sellercol8` varchar(45) DEFAULT NULL,
  `sellercol11` varchar(45) DEFAULT NULL,
  `sellercol12` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`s_surkey`),
  KEY `u_surkey` (`u_surkey`),
  KEY `bank_surkey_idx` (`b_surkey`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller`
--

LOCK TABLES `seller` WRITE;
/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
INSERT INTO `seller` VALUES (1,'tata_17','positive','sellershop1',17,17,0.28,'retail','Bangalore','njkcn','ncn c','ncjkd',515001,'2147483647',18,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'sowmya_12','positive','sellershop',12,15,0.21,'retail','elejdc','njkcn','ncn c','ncjkd',515001,'2147483647',24,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'sirisha_15','positive','sellershop',15,2,5.00,'jhg','karnataka','gj','jh','gjh',67,'67',100,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,'Tata17',NULL,'NA',18,18,0.00,'NA','Electronic City','Hosur road','Banglore','Karnataka',560100,'8006740387',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,'t16','positive','NA',19,19,0.00,'NA','Electronic City','Hosur road','Banglore','Karnataka',560100,'9602840906',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,'12231','positive','dummyshop',22,2,0.00,'dummy','dummy','dummy2','dummy','dummy',560100,'809999000',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(27,'Anil_24','positive','sellershop',24,21,0.00,'dummy','Electronic city','Hosur road','Banglore','Karnataka',560100,'8985839066',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,'sindhu_27',NULL,'sellershop',27,22,0.00,'NA',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,'Annu_25',NULL,'sellershop',25,23,0.00,'NA',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `pwd` varchar(150) DEFAULT NULL,
  `u_surkey` int(11) NOT NULL AUTO_INCREMENT,
  `mode` varchar(1) DEFAULT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `list_of_item_surkeys_bought` varchar(1000) DEFAULT NULL,
  `usercol3` varchar(45) DEFAULT NULL,
  `usercol4` varchar(45) DEFAULT NULL,
  `usercol5` varchar(45) DEFAULT NULL,
  `usercol6` varchar(45) DEFAULT NULL,
  `usercol7` varchar(45) DEFAULT NULL,
  `usercol8` varchar(45) DEFAULT NULL,
  `usercol9` varchar(45) DEFAULT NULL,
  `usercol10` varchar(45) DEFAULT NULL,
  `usercol` varchar(45) DEFAULT NULL,
  `usercol1` varchar(45) DEFAULT NULL,
  `usercol2` varchar(45) DEFAULT NULL,
  `usercol11` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`u_surkey`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Sowmya','Desai','sowmya@gmail.com','sowmya',12,'U','sowmyade_12','1994-01-26','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Sirisha','Ch','siri@gmail.com','siri',15,'U','sirishaC_15','1992-12-04','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('admin','admin','admin@gmail.com','admin',16,NULL,'admin_16','0000-00-00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Tata','Birla','tata@gmail.com','tata',17,NULL,'TataBirl_17',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('sirisha','ch','lsirisha.sirisha@gmail.com','siri',18,NULL,'sirishac_18',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('tata1','ratan1','tata1@gmail.com','tata1',19,NULL,'tata1rat_19',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dinesha','K V','dinesha@gmail.com','dinesha',20,NULL,'dineshaK_20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('kp','kriti','@gmail.com','xyz',21,NULL,'kpkriti_21',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dummy','dummy','dummy@gmail.com','dummy',22,NULL,'dummydum_22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ulfa','ulfaa','ulfa@gmail.com','ulfa',23,NULL,'ulfaulfa_23',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Anil','Kumar','Anil@gmail.com','541541',24,NULL,'AnilKuma_24',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Annu','Anil','Annu@gmail.com','541541',25,NULL,'AnnuAnil_25',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('sirisha','siri','newuser@gmail.com','siri',26,NULL,'sirishas_26',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Sindhu','Priya','sindhup.101@gmail.com','123',27,NULL,'SindhuPr_27',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Sindhu','Priya','sindhup.11@gmail.com','541541',28,NULL,'SindhuPr_28',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Sindhu','priya','sindhu.priya@iiit.org','123',30,NULL,'Sindhupr_30',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Sindhu','Priya','sindhup.2@gmail.com','541541',31,NULL,'SindhuPr_31',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Buyer1','eBay','buyer1@gmail.com','12345',32,NULL,'Buyer1eB_32',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Buyer2','eBay','buyer2@gmail.com','12345',33,NULL,'Buyer2eB_33',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Buyer3','eBay','buyer3@gmail.com','12345',34,NULL,'Buyer3eB_34',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Buyer4','eBay','buyer4@gmail.com','12345',35,NULL,'Buyer4eB_35',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Buyer5','eBay','buyer5@gmail.com','12345',36,NULL,'Buyer5eB_36',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Buyer6','eBay','buyer6@gmail.com','12345',37,NULL,'Buyer6eB_37',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vat`
--

DROP TABLE IF EXISTS `vat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vat` (
  `vat_surkey` int(11) NOT NULL AUTO_INCREMENT,
  `vat_percentage` int(11) DEFAULT NULL,
  `changedOn` date DEFAULT NULL,
  `vatcol` varchar(45) DEFAULT NULL,
  `vatcol1` varchar(45) DEFAULT NULL,
  `vatcol2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`vat_surkey`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vat`
--

LOCK TABLES `vat` WRITE;
/*!40000 ALTER TABLE `vat` DISABLE KEYS */;
INSERT INTO `vat` VALUES (1,10,'2016-04-10',NULL,NULL,NULL);
/*!40000 ALTER TABLE `vat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-26  2:02:45
