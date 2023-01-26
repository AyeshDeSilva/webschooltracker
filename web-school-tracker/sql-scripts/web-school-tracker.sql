-- --------------------------------
-- CREATE SCHEMA web_school_tracker
-- --------------------------------
DROP SCHEMA IF EXISTS `web_school_tracker` ;
CREATE SCHEMA `web_school_tracker` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
use `web_school_tracker`;
SET FOREIGN_KEY_CHECKS = 1;


-- --------------------------------
-- CREATE TABLE INSTUCTOR 
-- --------------------------------
DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) DEFAULT NULL,
	`Last_name` VARCHAR(45) DEFAULT NULL,
    `email` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
)
ENGINE = InnoDB,
AUTO_INCREMENT = 20
DEFAULT CHARSET = latin1;

-- --------------------------------
-- CREATE TABLE STUDENT 
-- --------------------------------
DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

-- --------------------------------
-- CREATE TABLE COURSE 
-- --------------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `course_code`varchar(128) DEFAULT NULL,
  `course_title` varchar(128) DEFAULT NULL,
  `instructor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `TITLE_UNIQUE` (`course_code`),
  KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
  CONSTRAINT `FK_INSTRUCTOR` 
  FOREIGN KEY (`instructor_id`) 
  REFERENCES `instructor` (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- --------------------------------
-- CREATE TABLE COURSE_STUDENT
-- --------------------------------
DROP TABLE IF EXISTS `course_student`;
CREATE TABLE `course_student` (
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`course_id`,`student_id`),
  KEY `FK_STUDENT_idx` (`student_id`),
  CONSTRAINT `FK_COURSE_05` FOREIGN KEY (`course_id`) 
  REFERENCES `course` (`id`) ,
  CONSTRAINT `FK_STUDENT` FOREIGN KEY (`student_id`) 
  REFERENCES `student` (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



SET FOREIGN_KEY_CHECKS = 1;
