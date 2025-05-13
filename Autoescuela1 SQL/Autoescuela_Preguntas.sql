-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: database-1.cpwoqsmqg94x.us-east-1.rds.amazonaws.com    Database: Autoescuela
-- ------------------------------------------------------
-- Server version	8.0.40

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `Preguntas`
--

DROP TABLE IF EXISTS `Preguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Preguntas` (
  `id` int NOT NULL,
  `enunciado` varchar(400) DEFAULT NULL,
  `respuesta1` varchar(150) DEFAULT NULL,
  `respuesta3` varchar(150) DEFAULT NULL,
  `respuesta2` varchar(150) DEFAULT NULL,
  `correcta` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Preguntas`
--

LOCK TABLES `Preguntas` WRITE;
/*!40000 ALTER TABLE `Preguntas` DISABLE KEYS */;
INSERT INTO `Preguntas` VALUES (1,'Cuantas ruedas tiene un automovil','cuatro','Las adecuadas para circular por la via','3',3),(2,'Cual es la velocidad adecuada en la autovia','120','100','Depende de las circunstacias del tráfico',2),(3,'A que velocidad circula un vehiculo pesado','80','40','A la que el tráfico se lo permita',2),(4,'Es legal circular sin carnet','No','Si, a menos de 50km/h','Si no te pillan no hay multa',2),(5,'La señal de STOP para que sirve normalmente','Ceder al paso','Sirve para decorar la via, son preciosas','Parar',2),(6,'Cuanto cuesta sacarse el carnet de conducir ','1000€','Demasiado','Depende de cada persona',3),(7,'Es legal circular en el Piramide con una moto haciendo el caballito ','No','Solo si es de noche y no te ve nadie','Depende de que segurata este',3),(8,'Para que sirve las señales circulares','Depende de cada señal','Obligatoriedad','Parar',1),(9,'En España cuantos puntos de carnet tienes si aprobaste tu examen hace 145 dias','8','10','No estoy seguro',1),(10,'A que velocidad puedes circular en una autovia con un Monster Truck','120','Depende de que tipo de Monster Truck estes conduciendo','100',3);
/*!40000 ALTER TABLE `Preguntas` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-13 11:11:00
