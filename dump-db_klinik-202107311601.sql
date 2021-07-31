-- MySQL dump 10.13  Distrib 8.0.25, for macos11.3 (x86_64)
--
-- Host: localhost    Database: db_klinik
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booked_rooms`
--

DROP TABLE IF EXISTS `booked_rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booked_rooms` (
  `id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `room_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `patient_id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `from` date NOT NULL,
  `until` date NOT NULL,
  `cost` double(15,2) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `booked_rooms_FK` (`patient_id`),
  KEY `booked_rooms_FK_1` (`room_id`),
  CONSTRAINT `booked_rooms_FK` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `booked_rooms_FK_1` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booked_rooms`
--

LOCK TABLES `booked_rooms` WRITE;
/*!40000 ALTER TABLE `booked_rooms` DISABLE KEYS */;
/*!40000 ALTER TABLE `booked_rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `str_number` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `birth_date` date NOT NULL,
  `specialization` enum('Gigi','Jantung','Paru-paru','Umum') COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` enum('Pria','Wanita') COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` text COLLATE utf8mb4_unicode_ci,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicines`
--

DROP TABLE IF EXISTS `medicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicines` (
  `id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `use` enum('1x3','1x2','2x1') COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` enum('Pill','Sirup','Salep') COLLATE utf8mb4_unicode_ci NOT NULL,
  `stock` int NOT NULL,
  `price` double(15,2) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicines`
--

LOCK TABLES `medicines` WRITE;
/*!40000 ALTER TABLE `medicines` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasien`
--

DROP TABLE IF EXISTS `pasien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pasien` (
  `id` varchar(30) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jk` varchar(20) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `goldar` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasien`
--

LOCK TABLES `pasien` WRITE;
/*!40000 ALTER TABLE `pasien` DISABLE KEYS */;
INSERT INTO `pasien` VALUES ('001','Sidik','Laki-laki','Cileungsi','O'),('002','Lulu','Perempuan','Cijeruk','B');
/*!40000 ALTER TABLE `pasien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_checkup_medicines`
--

DROP TABLE IF EXISTS `patient_checkup_medicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_checkup_medicines` (
  `id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `medicine_id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `patient_checkup_id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_checkup_medicines_FK` (`medicine_id`),
  KEY `patient_checkup_medicines_FK_1` (`patient_checkup_id`),
  CONSTRAINT `patient_checkup_medicines_FK` FOREIGN KEY (`medicine_id`) REFERENCES `medicines` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patient_checkup_medicines_FK_1` FOREIGN KEY (`patient_checkup_id`) REFERENCES `patient_checkups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_checkup_medicines`
--

LOCK TABLES `patient_checkup_medicines` WRITE;
/*!40000 ALTER TABLE `patient_checkup_medicines` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_checkup_medicines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_checkups`
--

DROP TABLE IF EXISTS `patient_checkups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_checkups` (
  `id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `patient_id` varchar(36) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `doctor_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `pain_complaint` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `diagnose` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `cost` double(15,2) NOT NULL COMMENT 'Harga checkup: 100.000',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `patient_checkups_FK` (`patient_id`),
  KEY `patient_checkups_FK_1` (`doctor_id`),
  CONSTRAINT `patient_checkups_FK` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patient_checkups_FK_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_checkups`
--

LOCK TABLES `patient_checkups` WRITE;
/*!40000 ALTER TABLE `patient_checkups` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_checkups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `patient_number` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `birth_date` date NOT NULL,
  `blood_type` enum('A','B','AB','O') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` enum('Pria','Wanita') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES ('0ed64348-bef6-4a0c-96be-9e3f25849299','1','Nopal','1999-09-17','B','Pria','Munjul','2021-07-28 10:17:17','2021-07-28 10:17:17'),('114c9024-73e5-4516-9432-9b5bc34bc7dc','13','Irna','2021-07-20','A','Wanita','a','2021-07-28 10:54:33','2021-07-28 10:54:33'),('23ab207b-5092-4486-a52a-49d0e847db4a','11','Fadilah','2021-07-15','A','Pria','d','2021-07-28 10:45:32','2021-07-28 10:45:32'),('2da214ef-60a9-4f89-93fc-701084680487','9','Nendra','2021-07-10','A','Pria','w','2021-07-28 10:41:41','2021-07-28 10:41:41'),('2f8690bc-8f06-4702-8678-9fd55e390e41','12','Ayu','2021-07-01','AB','Wanita','d','2021-07-28 10:46:50','2021-07-28 10:46:50'),('338ba690-964d-44e6-a9dd-42b1bbb9257a','8','Panca','2021-07-02','A','Pria','d','2021-07-28 10:40:28','2021-07-28 10:40:28'),('45c8f322-4b7e-41bd-af0b-6087fdc831a2','10','baim','2021-07-14','A','Pria','d','2021-07-28 10:43:54','2021-07-28 10:43:54'),('4c55e560-5259-4406-a5a4-bd778050f920','2','Jiwa','1982-09-06','B','Wanita','Jakarta','2021-07-20 14:42:49','2021-07-20 14:42:49'),('81151820-5147-4cd7-9622-060e1844c43d','6','Sidiq','2021-07-03','A','Pria','a','2021-07-28 10:29:28','2021-07-28 10:29:28'),('a260439e-7a04-46bb-a6f8-5da4cda45158','7','Dwi','2021-07-21','A','Wanita','d','2021-07-28 10:33:14','2021-07-28 10:33:14'),('a828810e-01de-437a-9e5a-0aa20d098120','4','Akmal','2021-07-15','A','Pria','dad','2021-07-28 10:22:44','2021-07-28 10:22:44'),('ae1fad28-d2ee-40a9-a047-3844eee3ad1d','3','Jamal','2021-07-22','A','Pria','bogor','2021-07-28 10:21:07','2021-07-28 10:21:07'),('b0028228-d492-4ef0-9521-76c41a01a7a4','5','Arifin','2021-07-07','A','Pria','d','2021-07-28 10:26:58','2021-07-28 10:26:58');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `records`
--

DROP TABLE IF EXISTS `records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `records` (
  `id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `patient_id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `booked_room_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `patient_checkup_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cost` double(15,2) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `records_FK` (`patient_id`),
  KEY `records_FK_1` (`patient_checkup_id`),
  KEY `records_FK_2` (`booked_room_id`),
  CONSTRAINT `records_FK` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `records_FK_1` FOREIGN KEY (`patient_checkup_id`) REFERENCES `patient_checkups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `records_FK_2` FOREIGN KEY (`booked_room_id`) REFERENCES `booked_rooms` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `records`
--

LOCK TABLES `records` WRITE;
/*!40000 ALTER TABLE `records` DISABLE KEYS */;
/*!40000 ALTER TABLE `records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rekam`
--

DROP TABLE IF EXISTS `rekam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rekam` (
  `no_daftar` varchar(20) NOT NULL,
  `tgl` date NOT NULL,
  `id_dok` varchar(50) NOT NULL,
  `id_pas` varchar(50) NOT NULL,
  `tb` int NOT NULL,
  `bb` int NOT NULL,
  `diagnosa` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rekam`
--

LOCK TABLES `rekam` WRITE;
/*!40000 ALTER TABLE `rekam` DISABLE KEYS */;
INSERT INTO `rekam` VALUES ('12345','2021-07-01','01','001',180,12345,'Meriang'),('123','2021-07-02','03','002',170,123,'Batuk'),('5555','2021-07-01','02','001',180,70,'Batuk');
/*!40000 ALTER TABLE `rekam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `in_use` tinyint(1) NOT NULL DEFAULT '0',
  `description` text COLLATE utf8mb4_unicode_ci,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_klinik'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-31 16:01:02
