CREATE DATABASE `telemedicine` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- telemedicine.allergy definition

CREATE TABLE `allergy` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- telemedicine.medical_condition definition

CREATE TABLE `medical_condition` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `diagnosis_date` date NOT NULL,
  `name` varchar(255) NOT NULL,
  `notes` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- telemedicine.medication definition

CREATE TABLE `medication` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `qty` double NOT NULL,
  `uom` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- telemedicine.users definition

CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `email` varchar(255) NOT NULL,
  `f_name` varchar(255) NOT NULL,
  `l_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- telemedicine.appointment definition

CREATE TABLE `appointment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `appointment_at` datetime(6) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `doctor_id` bigint DEFAULT NULL,
  `patient_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgwhur9oxtxd00p1ardeum1xao` (`doctor_id`),
  KEY `FKkmgspx6jj6lf80ayfwccy2n63` (`patient_id`),
  CONSTRAINT `FKgwhur9oxtxd00p1ardeum1xao` FOREIGN KEY (`doctor_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKkmgspx6jj6lf80ayfwccy2n63` FOREIGN KEY (`patient_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- telemedicine.billing definition

CREATE TABLE `billing` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `appointment_id` bigint DEFAULT NULL,
  `doctor_id` bigint DEFAULT NULL,
  `patient_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKetb5q1ilvi2bab1w9x3fk3oa1` (`appointment_id`),
  KEY `FKdtajnlfcnrsgitucie1hgrxq9` (`doctor_id`),
  KEY `FK5jniepijditp1t2veqol7a7e8` (`patient_id`),
  CONSTRAINT `FK5jniepijditp1t2veqol7a7e8` FOREIGN KEY (`patient_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKdtajnlfcnrsgitucie1hgrxq9` FOREIGN KEY (`doctor_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKetb5q1ilvi2bab1w9x3fk3oa1` FOREIGN KEY (`appointment_id`) REFERENCES `appointment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- telemedicine.health_record definition

CREATE TABLE `health_record` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `blood_type` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `height` double DEFAULT NULL,
  `updated_at` datetime(6) NOT NULL,
  `weight` double DEFAULT NULL,
  `doctor_id` bigint DEFAULT NULL,
  `patient_id` bigint DEFAULT NULL,
  `medication_id` bigint NOT NULL,
  `health_rec_id` bigint NOT NULL,
  `medical_con_id` bigint NOT NULL,
  `allergy_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7es8ycbaneslmd0b45b079t64` (`doctor_id`),
  KEY `FKbaqf2y9vghnj9fuihyluuie8m` (`patient_id`),
  KEY `FKgrjkufk5ms1qt7u755l9j8h9l` (`health_rec_id`),
  KEY `FK9mbvctjpfe4iy7phbj0gql3qw` (`medication_id`),
  KEY `FKf4sh83agi5kyogdl5w12j13sx` (`medical_con_id`),
  KEY `FKcssvf9lbf86w3qhh8gih8mdx9` (`allergy_id`),
  CONSTRAINT `FK7es8ycbaneslmd0b45b079t64` FOREIGN KEY (`doctor_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK9mbvctjpfe4iy7phbj0gql3qw` FOREIGN KEY (`medication_id`) REFERENCES `medication` (`id`),
  CONSTRAINT `FKbaqf2y9vghnj9fuihyluuie8m` FOREIGN KEY (`patient_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKcssvf9lbf86w3qhh8gih8mdx9` FOREIGN KEY (`allergy_id`) REFERENCES `allergy` (`id`),
  CONSTRAINT `FKf4sh83agi5kyogdl5w12j13sx` FOREIGN KEY (`medical_con_id`) REFERENCES `medical_condition` (`id`),
  CONSTRAINT `FKgrjkufk5ms1qt7u755l9j8h9l` FOREIGN KEY (`health_rec_id`) REFERENCES `health_record` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;