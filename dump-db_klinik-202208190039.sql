-- MySQL dump 10.13  Distrib 8.0.30, for macos11.6 (x86_64)
--
-- Host: localhost    Database: db_klinik
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_47bvqemyk6vlm0w7crc3opdd4` (`email`),
  UNIQUE KEY `UK_t7lspe46d49rf6ce5h660ve5t` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES ('db87bff2-ace9-4075-aa04-cc1ceb81fed4','oke ','2022-08-07 09:05:16.563000','admin@mail.com','admin1','$2a$12$9y.R/p6YpILyHnrjfws/HOj.LYIP5t/w6I4vyj6MwNsmBtp1sYhZa','021','2022-08-07 09:05:16.563000');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booked_rooms`
--

DROP TABLE IF EXISTS `booked_rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booked_rooms` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cost` double DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `from` date DEFAULT NULL,
  `patient_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `room_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `until` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9pg2x6hs5k469cu16fwhw9f0c` (`patient_id`),
  KEY `FK2yfwbd67fs461b8wjld84ct28` (`room_id`),
  CONSTRAINT `FK2yfwbd67fs461b8wjld84ct28` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`),
  CONSTRAINT `FK9pg2x6hs5k469cu16fwhw9f0c` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`)
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
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `birth_date` date NOT NULL,
  `specialization` enum('Gigi','Jantung','ParuParu','Umum') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` enum('Pria','Wanita') COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` text COLLATE utf8mb4_unicode_ci,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `specialize_doctor_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa9lhgjsbv5bnw8onfd7xebwvq` (`specialize_doctor_id`),
  CONSTRAINT `FKa9lhgjsbv5bnw8onfd7xebwvq` FOREIGN KEY (`specialize_doctor_id`) REFERENCES `specialize_doctors` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES ('33d687cb-492a-4637-9bde-a4c5a4d095f2','003','Dr. Budi','1982-08-21','Gigi','Pria','Munjul','2022-08-18 16:30:20','2022-08-18 17:31:24','$2a$12$XkEb1vPe7c1RbiIpXkx5WO4DDjwa9uYYcpr4.hI1t39626URGEXqe','budi@mail.com','098123123','8749700b-aaf6-4374-896a-1bb69014fd1a'),('791dbf36-4952-4447-b8e2-01c763c13bf2','0001','Dr. Yulinia','1979-08-10','Gigi','Wanita','zc','2022-08-17 07:37:43','2022-08-18 14:55:09','$2a$12$9y.R/p6YpILyHnrjfws/HOj.LYIP5t/w6I4vyj6MwNsmBtp1sYhZa','yuliania@mail.com','076123123','8749700b-aaf6-4374-896a-1bb69014fd1a'),('f59beeba-ad47-4fc7-a46e-e5d2af6a70de','0004','Dr. Sudirman','1976-08-13','Gigi','Pria','munjl','2022-08-08 14:28:34','2022-08-08 14:28:34','$2a$12$9y.R/p6YpILyHnrjfws/HOj.LYIP5t/w6I4vyj6MwNsmBtp1sYhZa','sudirman@mail.com','08123123','1648b9a7-bcf2-447c-88de-89ce1be7a9cd');
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratorium_divisions`
--

DROP TABLE IF EXISTS `laboratorium_divisions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratorium_divisions` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cost` double DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratorium_divisions`
--

LOCK TABLES `laboratorium_divisions` WRITE;
/*!40000 ALTER TABLE `laboratorium_divisions` DISABLE KEYS */;
INSERT INTO `laboratorium_divisions` VALUES ('6c0c63cc-b34a-4e93-8350-1ed9c02bc6c5',200000,'2022-08-16 22:26:32.540000','USG','2022-08-19 00:31:23.612000'),('bba4ecb4-3af2-452f-9eae-4503073531d4',300000,'2022-08-18 23:33:31.763000','Radiologi','2022-08-18 23:33:31.763000'),('db9f8f90-8a52-41fa-8de9-30c142d09f23',500000,'2022-08-16 22:54:07.922000','Orthopedi','2022-08-18 21:55:09.184000');
/*!40000 ALTER TABLE `laboratorium_divisions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratoriums`
--

DROP TABLE IF EXISTS `laboratoriums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratoriums` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `division_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_l0uwtm7t2ns0r9r3srfdw5hoq` (`email`),
  UNIQUE KEY `UK_il71y9cxtrg5cs1kugcv6bnj1` (`phone`),
  KEY `FKliodij4esqvvnv7bhs7or06rx` (`division_id`),
  CONSTRAINT `FKliodij4esqvvnv7bhs7or06rx` FOREIGN KEY (`division_id`) REFERENCES `laboratorium_divisions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratoriums`
--

LOCK TABLES `laboratoriums` WRITE;
/*!40000 ALTER TABLE `laboratoriums` DISABLE KEYS */;
INSERT INTO `laboratoriums` VALUES ('103c254b-afb7-4a86-9ce2-15a94f131286','a','2022-08-16 23:34:13.576000','sara@mail.com','Sara','$2a$12$jdkeEImdflxNqOYYPstWje88aSYGSHF5XauI.iL0bahYFdiC2vvH.','08777123','2022-08-18 21:55:09.276000','db9f8f90-8a52-41fa-8de9-30c142d09f23'),('1e15ba94-2de1-424a-87ee-d51715b21cf4','ad','2022-08-16 23:20:16.420000','sinta@mail.com','sinta','$2a$12$jdkeEImdflxNqOYYPstWje88aSYGSHF5XauI.iL0bahYFdiC2vvH.','081212312','2022-08-19 00:31:23.633000','6c0c63cc-b34a-4e93-8350-1ed9c02bc6c5'),('a60a7728-6967-4de8-98d3-e7d48b877f01','x','2022-08-13 08:36:46.165000','lab@mail.com','labUser','$2a$12$nSC51eSx22aj/T6v5eONvuLK0xH55ES3hJFojZIldMRqBqlD1cfCC','012312312','2022-08-13 08:36:46.165000',NULL);
/*!40000 ALTER TABLE `laboratoriums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaders`
--

DROP TABLE IF EXISTS `leaders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leaders` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3v8sft4xucwtj3e0j57rdry2a` (`email`),
  UNIQUE KEY `UK_tfnu7i7tp2kflkgjigpq62afp` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaders`
--

LOCK TABLES `leaders` WRITE;
/*!40000 ALTER TABLE `leaders` DISABLE KEYS */;
INSERT INTO `leaders` VALUES ('855d7776-d76b-4214-b8f3-cf571478c336','Cibubur','2022-07-12 22:31:32.388000','pimpinan@mail.com','pimpinan1','$2a$12$LWAPASDfLwDvT6g71wlDV.lavYo9VNDn2zeTQcYuAShZ14fPtiui2','08123123','2022-08-18 23:31:42.905000');
/*!40000 ALTER TABLE `leaders` ENABLE KEYS */;
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
  `use` enum('ONE_TIME_THREE','ONE_TIME_TWO','TWO_TIME_ONE') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
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
INSERT INTO `medicines` VALUES ('6aaa9d20-3b21-43b0-b99d-e84023a5f3f5','Paramex','ONE_TIME_THREE','Pill',10,5000.00,'2022-07-08 07:48:37','2022-07-08 07:48:37'),('a8701d6e-df88-4afa-8461-9d0c6a618cb2','Parasetamol','ONE_TIME_THREE','Pill',21,5000.00,'2022-07-06 11:29:35','2022-07-07 09:34:36'),('a8f72310-fc6e-4359-b78d-a0438517ed5a','Miconazole','ONE_TIME_THREE','Salep',19,7000.00,'2022-07-08 07:56:15','2022-07-08 07:56:15');
/*!40000 ALTER TABLE `medicines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_checkup_doctors`
--

DROP TABLE IF EXISTS `patient_checkup_doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_checkup_doctors` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `patient_checkup_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `doctor_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmlhg150m5n42ajjqjf0qy0jkh` (`patient_checkup_id`),
  KEY `FKol44wuweixcuqmn3jmiga36db` (`doctor_id`),
  CONSTRAINT `FKmlhg150m5n42ajjqjf0qy0jkh` FOREIGN KEY (`patient_checkup_id`) REFERENCES `patient_checkups` (`id`),
  CONSTRAINT `FKol44wuweixcuqmn3jmiga36db` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_checkup_doctors`
--

LOCK TABLES `patient_checkup_doctors` WRITE;
/*!40000 ALTER TABLE `patient_checkup_doctors` DISABLE KEYS */;
INSERT INTO `patient_checkup_doctors` VALUES ('a88ffd12-e932-486d-9499-f369f4e3933a','2022-08-19 00:23:38.855000','Mengalami Sakit kepala, \nperiksa kepala','76c3c4de-b05a-495b-a645-00c449310865','2022-08-19 00:31:23.639000','33d687cb-492a-4637-9bde-a4c5a4d095f2'),('fcac6fb3-9508-4010-a4e8-e163d0f8d333','2022-08-17 17:51:42.761000','periksa kepala, bagian belakang','28b031d8-6aef-4039-b9d5-2de4fe4f6c14','2022-08-18 21:55:09.280000','791dbf36-4952-4447-b8e2-01c763c13bf2');
/*!40000 ALTER TABLE `patient_checkup_doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_checkup_labs`
--

DROP TABLE IF EXISTS `patient_checkup_labs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_checkup_labs` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `patient_checkup_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `result_lab_checkup` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `laboratorium_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5p77f11yn8xqpdr7vl3jwdp3n` (`patient_checkup_id`),
  KEY `FK8yqwl1tciotd5bvtmabqkdha0` (`laboratorium_id`),
  CONSTRAINT `FK5p77f11yn8xqpdr7vl3jwdp3n` FOREIGN KEY (`patient_checkup_id`) REFERENCES `patient_checkups` (`id`),
  CONSTRAINT `FK8yqwl1tciotd5bvtmabqkdha0` FOREIGN KEY (`laboratorium_id`) REFERENCES `laboratoriums` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_checkup_labs`
--

LOCK TABLES `patient_checkup_labs` WRITE;
/*!40000 ALTER TABLE `patient_checkup_labs` DISABLE KEYS */;
INSERT INTO `patient_checkup_labs` VALUES ('052b409c-8005-4163-9df4-8a1764403cd5','2022-08-17 20:48:17.685000','28b031d8-6aef-4039-b9d5-2de4fe4f6c14','Sakit Ringan, bagian belakang','2022-08-18 21:55:09.208000','103c254b-afb7-4a86-9ce2-15a94f131286'),('dabed06f-1532-4104-8764-c3c03384c5c8','2022-08-19 00:28:45.924000','76c3c4de-b05a-495b-a645-00c449310865','Beri obat sakit kepala','2022-08-19 00:31:23.627000','1e15ba94-2de1-424a-87ee-d51715b21cf4');
/*!40000 ALTER TABLE `patient_checkup_labs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_checkup_medicines`
--

DROP TABLE IF EXISTS `patient_checkup_medicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_checkup_medicines` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `medicine_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `patient_checkup_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbu5p7lmu6wpul5fyxfa16x2al` (`medicine_id`),
  KEY `FK9chypk5jwrucoegrhakvv22uo` (`patient_checkup_id`),
  CONSTRAINT `FK9chypk5jwrucoegrhakvv22uo` FOREIGN KEY (`patient_checkup_id`) REFERENCES `patient_checkups` (`id`),
  CONSTRAINT `FKbu5p7lmu6wpul5fyxfa16x2al` FOREIGN KEY (`medicine_id`) REFERENCES `medicines` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_checkup_medicines`
--

LOCK TABLES `patient_checkup_medicines` WRITE;
/*!40000 ALTER TABLE `patient_checkup_medicines` DISABLE KEYS */;
INSERT INTO `patient_checkup_medicines` VALUES ('03788ee9-df9e-465c-93bc-6c93dacd9c9b','6aaa9d20-3b21-43b0-b99d-e84023a5f3f5','28b031d8-6aef-4039-b9d5-2de4fe4f6c14','2022-08-18 12:57:39.237000','2022-08-18 21:55:09.191000',1),('16bb8bda-ddb3-4e21-99db-3f2a17a01b85','a8701d6e-df88-4afa-8461-9d0c6a618cb2','28b031d8-6aef-4039-b9d5-2de4fe4f6c14','2022-08-18 12:57:51.755000','2022-08-18 21:55:09.192000',2),('326ec16e-8173-49d4-a29e-b14571a6fc30','a8701d6e-df88-4afa-8461-9d0c6a618cb2','76c3c4de-b05a-495b-a645-00c449310865','2022-08-19 00:30:55.435000','2022-08-19 00:30:55.435000',3),('9986a05d-8686-4647-8c41-159069729c35','6aaa9d20-3b21-43b0-b99d-e84023a5f3f5','76c3c4de-b05a-495b-a645-00c449310865','2022-08-19 00:31:04.026000','2022-08-19 00:31:04.026000',1);
/*!40000 ALTER TABLE `patient_checkup_medicines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_checkups`
--

DROP TABLE IF EXISTS `patient_checkups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_checkups` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cost` double DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `patient_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `checkup_date` date DEFAULT NULL,
  `checkup_number` int DEFAULT NULL,
  `pharmacist_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `specialize_doctor_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `laboratorium_division_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `checkup_status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8k78aflocgya4rfpymwbnve00` (`patient_id`),
  KEY `FK1pwwyrmluasfv228jogc2k5b5` (`pharmacist_id`),
  KEY `FKlg09itwwlf68niltsthcvmgdj` (`specialize_doctor_id`),
  KEY `FKbudyo8i95f70o3atcs6a3i1qu` (`laboratorium_division_id`),
  CONSTRAINT `FK1pwwyrmluasfv228jogc2k5b5` FOREIGN KEY (`pharmacist_id`) REFERENCES `pharmacists` (`id`),
  CONSTRAINT `FK8k78aflocgya4rfpymwbnve00` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `FKbudyo8i95f70o3atcs6a3i1qu` FOREIGN KEY (`laboratorium_division_id`) REFERENCES `laboratorium_divisions` (`id`),
  CONSTRAINT `FKlg09itwwlf68niltsthcvmgdj` FOREIGN KEY (`specialize_doctor_id`) REFERENCES `specialize_doctors` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_checkups`
--

LOCK TABLES `patient_checkups` WRITE;
/*!40000 ALTER TABLE `patient_checkups` DISABLE KEYS */;
INSERT INTO `patient_checkups` VALUES ('28b031d8-6aef-4039-b9d5-2de4fe4f6c14',665000,'2022-08-17 08:58:00.073000','73c9ece2-849a-46d3-9fc9-4b55d61b1c1b','2022-08-18 21:55:09.044000',NULL,'2022-08-17',2,'e8a15e07-fadb-4874-9b0d-8b43a505c44d','8749700b-aaf6-4374-896a-1bb69014fd1a','db9f8f90-8a52-41fa-8de9-30c142d09f23',3),('29e51be5-bfb8-4637-b7e4-2f9de847aea6',0,'2022-08-18 23:55:47.214000','cf4a7c3f-00b0-433e-9177-cb696f61c216','2022-08-18 23:55:47.214000',NULL,'2022-08-18',5,NULL,'8749700b-aaf6-4374-896a-1bb69014fd1a',NULL,0),('3a606e30-00ea-4c5d-bf79-5a7dbf556d27',0,'2022-08-17 07:55:41.896000','cf4a7c3f-00b0-433e-9177-cb696f61c216','2022-08-17 07:55:41.896000',NULL,'2022-08-17',1,NULL,'8749700b-aaf6-4374-896a-1bb69014fd1a',NULL,1),('45df5b1b-6b34-403a-902a-516709c740ba',0,'2022-08-18 23:47:12.482000','cf4a7c3f-00b0-433e-9177-cb696f61c216','2022-08-18 23:47:12.482000',NULL,'2022-08-18',4,NULL,'8749700b-aaf6-4374-896a-1bb69014fd1a',NULL,0),('76c3c4de-b05a-495b-a645-00c449310865',370000,'2022-08-19 00:21:22.861000','d1dd5bb1-524e-4af5-9c0f-d2698545b31b','2022-08-19 00:31:23.565000',NULL,'2022-08-19',6,'0cefe7b0-24dd-453f-b6fb-59ea068b2e6c','8749700b-aaf6-4374-896a-1bb69014fd1a','6c0c63cc-b34a-4e93-8350-1ed9c02bc6c5',3),('e999cc02-9dc5-48ed-bb7b-1262538082de',0,'2022-08-18 23:40:52.876000','d1dd5bb1-524e-4af5-9c0f-d2698545b31b','2022-08-18 23:40:52.876000',NULL,'2022-08-18',3,NULL,'8749700b-aaf6-4374-896a-1bb69014fd1a',NULL,0);
/*!40000 ALTER TABLE `patient_checkups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `birth_date` datetime(6) DEFAULT NULL,
  `blood_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `patient_number` int NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8u6p47bdb5ku435q2d64yav3b` (`patient_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES ('73c9ece2-849a-46d3-9fc9-4b55d61b1c1b','Cibubur','1997-12-28 08:57:25.610000','A','2022-08-17 08:57:36.476000','Wanita',_binary '\0','Yuli',4,'2022-08-17 08:57:36.476000'),('76f536c1-ab17-42a5-86bf-8bf00c3dbc00','CPM','1991-12-29 07:36:54.450000','A','2022-08-13 07:37:08.320000','Wanita',_binary '\0','Putri ',3,'2022-08-13 07:37:08.320000'),('cf4a7c3f-00b0-433e-9177-cb696f61c216','z','2021-12-26 05:23:49.994000','A','2022-08-11 05:23:53.512000','Pria',_binary '\0','noval',1,'2022-08-11 05:23:53.512000'),('d1dd5bb1-524e-4af5-9c0f-d2698545b31b','z','1981-12-27 07:36:15.466000','A','2022-08-13 07:36:23.418000','Pria',_binary '\0','Novan Dimas',2,'2022-08-13 07:36:23.418000');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacists`
--

DROP TABLE IF EXISTS `pharmacists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pharmacists` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9c1wxrqbvw6bljpm4imn9exuh` (`email`),
  UNIQUE KEY `UK_3a9gh6d2rjrv3xdaeu36nkbmh` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacists`
--

LOCK TABLES `pharmacists` WRITE;
/*!40000 ALTER TABLE `pharmacists` DISABLE KEYS */;
INSERT INTO `pharmacists` VALUES ('0cefe7b0-24dd-453f-b6fb-59ea068b2e6c','Bekasi','2022-08-18 23:31:23.805000','dwi@mail.com','Dwi','$2a$12$djnTnley0SF2xTMB9rhVPutPJ5eYkGaMegEZH9NskbbX2BgyHUgfa','02137123','2022-08-18 23:31:23.805000'),('e8a15e07-fadb-4874-9b0d-8b43a505c44d','sss','2022-07-12 22:19:12.379000','apotek1@mail.com','Apoteker1','$2a$12$Bqqcu6..x.TPne/gbXXUCuYGzhr327l2j5RLULOILBvFTOakX0kPq','012313','2022-07-12 22:19:12.379000');
/*!40000 ALTER TABLE `pharmacists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receptionists`
--

DROP TABLE IF EXISTS `receptionists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receptionists` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_e7mtrybj6gaj9hsswxer43jl1` (`email`),
  UNIQUE KEY `UK_ek3npsa03lmsom55geb97f9fn` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receptionists`
--

LOCK TABLES `receptionists` WRITE;
/*!40000 ALTER TABLE `receptionists` DISABLE KEYS */;
INSERT INTO `receptionists` VALUES ('26e313cb-5f2e-4cf4-b749-7049125750dd','recep','recep@mail.com','recep','$2a$12$hywKL.gzEz.MY4Vx065eWuySi/gR.Xa8yFGluUO//dxMTnMCsrKE.','62123123','2022-07-16 21:58:16.805000','2022-07-16 21:58:16.805000'),('3852f01b-ec23-4283-8c39-eccab9214936','Bekasi','sri@mail.com','sri','$2a$12$2DiL8RxNva1pP8AHld6DBOCl1uKRmctSz4CHCjf0ljKiONi2Z5X9.','08122281','2022-08-18 23:30:57.777000','2022-08-18 23:30:57.777000');
/*!40000 ALTER TABLE `receptionists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `records`
--

DROP TABLE IF EXISTS `records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `records` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `booked_room_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `patient_checkup_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `patient_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `doctor_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgk80ixr1mbdf2lnsajk2rbiy4` (`booked_room_id`),
  KEY `FKpxac6qhdvi86k87vh1e7ckauh` (`doctor_id`),
  KEY `FKlb1y06gix17qag2l0m9gtoj44` (`patient_id`),
  CONSTRAINT `FKgk80ixr1mbdf2lnsajk2rbiy4` FOREIGN KEY (`booked_room_id`) REFERENCES `booked_rooms` (`id`),
  CONSTRAINT `FKlb1y06gix17qag2l0m9gtoj44` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `FKpxac6qhdvi86k87vh1e7ckauh` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
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
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `in_use` int DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
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
-- Table structure for table `specialize_doctors`
--

DROP TABLE IF EXISTS `specialize_doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialize_doctors` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `checkup_fee` double DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialize_doctors`
--

LOCK TABLES `specialize_doctors` WRITE;
/*!40000 ALTER TABLE `specialize_doctors` DISABLE KEYS */;
INSERT INTO `specialize_doctors` VALUES ('1648b9a7-bcf2-447c-88de-89ce1be7a9cd',200000,'2022-08-07 22:12:12.791000','gigi','2022-08-07 22:23:31.631000'),('806d5237-e4d0-4705-a06d-fa15b07c533a',120000,'2022-08-18 23:32:23.074000','Paru-paru','2022-08-18 23:32:23.074000'),('8749700b-aaf6-4374-896a-1bb69014fd1a',150000,'2022-08-07 22:11:48.684000','Umum','2022-08-19 00:31:23.624000');
/*!40000 ALTER TABLE `specialize_doctors` ENABLE KEYS */;
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

-- Dump completed on 2022-08-19  0:39:59
