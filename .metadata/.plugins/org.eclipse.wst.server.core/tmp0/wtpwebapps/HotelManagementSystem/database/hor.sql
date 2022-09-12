-- MySQL dump 10.10
--
-- Host: localhost    Database: hor
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL auto_increment,
  `name` varchar(30) NOT NULL,
  `username` varchar(24) NOT NULL,
  `password` varchar(24) NOT NULL,
  PRIMARY KEY  (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--


/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
LOCK TABLES `admin` WRITE;
INSERT INTO `admin` VALUES (2,'Kishor Kadam','kadamk329','java@1991'),(4,'Sagar Kharmale','sagar','sagar@123'),(5,'Govind Raut','govind','raut@12345'),(7,'Santosh Karvekar','santosh','santosh@123');
UNLOCK TABLES;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

--
-- Table structure for table `guest`
--

DROP TABLE IF EXISTS `guest`;
CREATE TABLE `guest` (
  `guest_id` int(11) NOT NULL auto_increment,
  `firstname` varchar(50) NOT NULL,
  `middlename` varchar(30) NOT NULL,
  `lastname` varchar(40) NOT NULL,
  `address` varchar(50) NOT NULL,
  `contactno` varchar(13) NOT NULL,
  PRIMARY KEY  (`guest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guest`
--


/*!40000 ALTER TABLE `guest` DISABLE KEYS */;
LOCK TABLES `guest` WRITE;
INSERT INTO `guest` VALUES (1,'Kishor','Balasaheb','Kadam','Wakad,Pune','9404308673'),(2,'Sagar','Prakash','Kharmale','Malwadi,Pune','7276763516'),(3,'Raju','Balasaheb','Kadam','A/P: Bhalawani Tal: Parner Dist: Ahmednagar','9889898965'),(4,'Santosh','Ramchandra','Karvekar','Chipurde,Sangali','8855743651'),(5,'Shivaji','Abc','Manchare','MIDC,Ahmednagar','9638527410'),(6,'Dharmesh','Xyz','Mourya','Andheri,Mumbai','8474563214');
UNLOCK TABLES;
/*!40000 ALTER TABLE `guest` ENABLE KEYS */;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(11) NOT NULL auto_increment,
  `room_type` varchar(50) NOT NULL,
  `price` varchar(11) NOT NULL,
  `photo` varchar(100) NOT NULL,
  `photo_path` varchar(500) default NULL,
  PRIMARY KEY  (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--


/*!40000 ALTER TABLE `room` DISABLE KEYS */;
LOCK TABLES `room` WRITE;
INSERT INTO `room` VALUES (1,'Standard','700','1.jpg','F:/Java-Programming-All-Work/All Webbased Programs/HotelManagementSystemDashboard/WebContent/uploads/1.jpg'),(2,'Superior','1700','2.jpg','F:/Java-Programming-All-Work/All Webbased Programs/HotelManagementSystemDashboard/WebContent/uploads/2.jpg'),(3,'Super Deluxe','3000','6.jpg','F:/Java-Programming-All-Work/All Webbased Programs/HotelManagementSystemDashboard/WebContent/uploads/6.jpg'),(6,'Jr. Suite','500','11.jpg','F:/Java-Programming-All-Work/All Webbased Programs/HotelManagementSystemDashboard/WebContent/uploads/11.jpg'),(7,'Executive Suite','4500','5.jpg','F:/Java-Programming-All-Work/All Webbased Programs/HotelManagementSystemDashboard/WebContent/uploads/5.jpg');
UNLOCK TABLES;
/*!40000 ALTER TABLE `room` ENABLE KEYS */;

--
-- Table structure for table `travel`
--

DROP TABLE IF EXISTS `travel`;
CREATE TABLE `travel` (
  `id` int(11) NOT NULL auto_increment,
  `apply_date` date default NULL,
  `day` int(11) default NULL,
  `departure_date` date default NULL,
  `status` varchar(45) default NULL,
  `guest_id` int(11) default NULL,
  `room_id` int(11) default NULL,
  `room_no` int(11) default NULL,
  `extra_bed` int(11) default NULL,
  `bill` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `travel`
--


/*!40000 ALTER TABLE `travel` DISABLE KEYS */;
LOCK TABLES `travel` WRITE;
INSERT INTO `travel` VALUES (1,'2019-07-20',4,'2019-07-24','CheckOut',1,7,101,3,20400),(2,'2019-07-20',2,'2019-07-22','CheckIn',2,2,401,0,3400),(3,'2019-07-20',7,'2019-07-27','CheckOut',3,3,201,5,25000),(4,'2019-07-20',9,'2019-07-29','CheckOut',4,1,301,1,7100),(5,'2019-07-20',1,'2019-07-21','CheckOut',5,6,501,7,6100),(6,'2019-07-20',8,'2019-07-28','Pending',6,3,0,0,0);
UNLOCK TABLES;
/*!40000 ALTER TABLE `travel` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

