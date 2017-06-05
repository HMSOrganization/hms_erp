/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.0.27-community-nt : Database - hospital_management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hospital_management` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `hospital_management`;

/*Table structure for table `bloodgroup` */

DROP TABLE IF EXISTS `bloodgroup`;

CREATE TABLE `bloodgroup` (
  `id` int(11) NOT NULL,
  `bloodgroup_type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bloodgroup` */

insert  into `bloodgroup`(`id`,`bloodgroup_type`) values (1,'O+'),(2,'O-'),(3,'A+'),(4,'A-'),(5,'B+'),(6,'B-'),(7,'AB+'),(8,'AB-'),(0,'select'),(1,'O+'),(2,'O-'),(3,'A+'),(4,'A-'),(5,'B+'),(6,'B-'),(7,'AB+'),(8,'AB-'),(0,'select');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `department_id` int(11) NOT NULL auto_increment,
  `department_type` varchar(40) NOT NULL,
  PRIMARY KEY  (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `department` */

insert  into `department`(`department_id`,`department_type`) values (1,'Radiology'),(2,'Cardiology'),(3,'Pathology'),(4,'physio');

/*Table structure for table `doctor_info` */

DROP TABLE IF EXISTS `doctor_info`;

CREATE TABLE `doctor_info` (
  `doctor_id` int(11) NOT NULL auto_increment,
  `doctor_name` varchar(30) NOT NULL,
  `blood_group` varchar(11) NOT NULL,
  `gender` varchar(40) NOT NULL,
  `religion` varchar(40) NOT NULL,
  `marital_status` varchar(30) NOT NULL,
  `date_of_birth` date NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(9) NOT NULL,
  PRIMARY KEY  (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `doctor_info` */

insert  into `doctor_info`(`doctor_id`,`doctor_name`,`blood_group`,`gender`,`religion`,`marital_status`,`date_of_birth`,`email`,`password`) values (1,'Dr. raj joshi','35','jjj','hj','Cardiology','0000-00-00','Raj@gmail.com','123456'),(2,'Dr. Ram soni','34','MD','5 years','Radiology','0000-00-00','ram@gmail.com','123456');

/*Table structure for table `icons` */

DROP TABLE IF EXISTS `icons`;

CREATE TABLE `icons` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `src` varchar(50) NOT NULL,
  `doctor_access` tinyint(1) NOT NULL default '0',
  `nurse_access` int(11) NOT NULL default '0',
  `receptionist_access` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `icons` */

insert  into `icons`(`id`,`name`,`src`,`doctor_access`,`nurse_access`,`receptionist_access`) values (1,'Patient','images/patient.png',1,0,0),(2,'Nurse','images/nurse.png',1,0,0),(3,'Billing','images/billing.png',1,0,0),(4,'Financial Management','images/financial.png',0,0,0),(5,'Laboratory','images/laboratory.png',0,0,0),(6,'OT Management','images/OT.png',0,0,0),(7,'Reports','images/report(1).png',0,0,0),(8,'Departments','images/departments.png',0,0,0),(9,'EMR Management','images/EMR.png',0,0,0),(10,'HR Management','images/HR.png',0,0,0),(11,'OPD/IPD','images/OPDIPD.png',0,0,0),(12,'Resource Management','images/resource.png',0,0,0);

/*Table structure for table `patient_general_room` */

DROP TABLE IF EXISTS `patient_general_room`;

CREATE TABLE `patient_general_room` (
  `Room_No` int(20) default NULL,
  `Room_status` int(20) default NULL,
  `Bed_No` int(20) default NULL,
  `Bed_status` int(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `patient_general_room` */

insert  into `patient_general_room`(`Room_No`,`Room_status`,`Bed_No`,`Bed_status`) values (120,0,1,1),(120,0,2,0),(120,0,3,0),(120,0,4,0),(121,0,1,0),(122,0,2,0);

/*Table structure for table `patient_indoor_registration` */

DROP TABLE IF EXISTS `patient_indoor_registration`;

CREATE TABLE `patient_indoor_registration` (
  `patient_ID` int(20) NOT NULL,
  `patient_bookroomType` varchar(20) default NULL,
  `patient_bookroomNo` int(20) default NULL,
  `patient_bookbedNo` int(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `patient_indoor_registration` */

/*Table structure for table `patient_outdoor_registration` */

DROP TABLE IF EXISTS `patient_outdoor_registration`;

CREATE TABLE `patient_outdoor_registration` (
  `Hospital_id` bigint(20) NOT NULL,
  `Receptionist_id` bigint(20) NOT NULL,
  `Patient_Date_of_registration` date default NULL,
  `Patient_registration_time` time default NULL,
  `Patient_id` bigint(20) NOT NULL,
  `Patient_name` varchar(40) default NULL,
  `Patient_dateOfBirth` date default NULL,
  `Patient_sex` varchar(20) default NULL,
  `Patient_cardname` varchar(20) default NULL,
  `Patient_SSN` bigint(30) default NULL,
  `Patient_occupation` varchar(20) default NULL,
  `Patient_religion` varchar(20) default NULL,
  `Patient_language` varchar(15) default NULL,
  `Patient_address` varchar(30) default NULL,
  `Patient_country` varchar(20) default NULL,
  `Patient_state` varchar(20) default NULL,
  `Patient_city` varchar(20) default NULL,
  `Patient_emergency_contactno` bigint(20) default NULL,
  `Patient_mobileno` bigint(20) default NULL,
  `Patient_relationship` varchar(20) default NULL,
  `Patient_department` varchar(20) default NULL,
  `Patient_reffering_physician` varchar(20) default NULL,
  `Patient_symptoms` varchar(50) default NULL,
  PRIMARY KEY  (`Patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `patient_outdoor_registration` */

insert  into `patient_outdoor_registration`(`Hospital_id`,`Receptionist_id`,`Patient_Date_of_registration`,`Patient_registration_time`,`Patient_id`,`Patient_name`,`Patient_dateOfBirth`,`Patient_sex`,`Patient_cardname`,`Patient_SSN`,`Patient_occupation`,`Patient_religion`,`Patient_language`,`Patient_address`,`Patient_country`,`Patient_state`,`Patient_city`,`Patient_emergency_contactno`,`Patient_mobileno`,`Patient_relationship`,`Patient_department`,`Patient_reffering_physician`,`Patient_symptoms`) values (567,123,'2017-06-03','14:14:44',12,'nullHardik null','1996-02-16',NULL,'Pancard',123454321789,'Student','Hindu','Gujrati','Sarvoday Society joshipura ','India','Gujrat','Ahemdabad',NULL,8155823008,'Brother','General','Do.Shuchi shah','General');

/*Table structure for table `patient_semispecial_room` */

DROP TABLE IF EXISTS `patient_semispecial_room`;

CREATE TABLE `patient_semispecial_room` (
  `Room_No` int(20) default NULL,
  `Room_status` int(20) default NULL,
  `Bed_No` int(20) default NULL,
  `Bed_status` int(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `patient_semispecial_room` */

insert  into `patient_semispecial_room`(`Room_No`,`Room_status`,`Bed_No`,`Bed_status`) values (211,1,1,1),(211,1,2,1),(212,0,1,0),(212,0,2,0);

/*Table structure for table `patient_special_room` */

DROP TABLE IF EXISTS `patient_special_room`;

CREATE TABLE `patient_special_room` (
  `Room_No` int(20) default NULL,
  `Room_status` int(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `patient_special_room` */

insert  into `patient_special_room`(`Room_No`,`Room_status`) values (102,1),(103,1),(104,0),(105,0),(101,0),(106,0),(107,0),(108,0),(109,0),(110,0);

/*Table structure for table `tbl_staffmaster_academic` */

DROP TABLE IF EXISTS `tbl_staffmaster_academic`;

CREATE TABLE `tbl_staffmaster_academic` (
  `staff_id` int(11) NOT NULL auto_increment,
  `qualification` varchar(30) NOT NULL,
  `univercity_name` varchar(30) NOT NULL,
  `main_subject` varchar(30) NOT NULL,
  `other_subject` varchar(30) NOT NULL,
  `passing_year` year(4) NOT NULL,
  `marks` float NOT NULL,
  PRIMARY KEY  (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_staffmaster_academic` */

/*Table structure for table `tbl_staffmaster_address` */

DROP TABLE IF EXISTS `tbl_staffmaster_address`;

CREATE TABLE `tbl_staffmaster_address` (
  `staff_id` int(11) NOT NULL auto_increment,
  `address` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL,
  `district` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `pincode` int(7) NOT NULL,
  `mobile` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY  (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_staffmaster_address` */

/*Table structure for table `tbl_staffmaster_employment` */

DROP TABLE IF EXISTS `tbl_staffmaster_employment`;

CREATE TABLE `tbl_staffmaster_employment` (
  `staff_id` int(11) NOT NULL auto_increment,
  `division` varchar(20) NOT NULL,
  `previous_workplace` varchar(30) NOT NULL,
  `designation` varchar(30) NOT NULL,
  `join_date` date NOT NULL,
  `leave_date` date NOT NULL,
  `address` varchar(70) NOT NULL,
  `salary` int(11) NOT NULL,
  `remarks` varchar(300) NOT NULL,
  PRIMARY KEY  (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_staffmaster_employment` */

/*Table structure for table `tbl_staffmaster_family` */

DROP TABLE IF EXISTS `tbl_staffmaster_family`;

CREATE TABLE `tbl_staffmaster_family` (
  `staff_id` int(11) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `relation` varchar(20) NOT NULL,
  `qualification` varchar(20) NOT NULL,
  `income` int(11) NOT NULL,
  `occupation` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY  (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_staffmaster_family` */

insert  into `tbl_staffmaster_family`(`staff_id`,`name`,`relation`,`qualification`,`income`,`occupation`,`address`) values (1,'ritu','sister','B.B.A',9000,'goldsmith','rajkot'),(2,'abc','hj','hj',9090,'hjh','hklll');

/*Table structure for table `tbl_staffmaster_general` */

DROP TABLE IF EXISTS `tbl_staffmaster_general`;

CREATE TABLE `tbl_staffmaster_general` (
  `staff_id` int(11) NOT NULL auto_increment,
  `staffname` varchar(30) NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `marital_status` varchar(30) NOT NULL,
  `blood_group` varchar(4) NOT NULL,
  `religion` varchar(30) NOT NULL,
  `branchname` varchar(30) NOT NULL,
  `date_of_birth` date NOT NULL,
  PRIMARY KEY  (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_staffmaster_general` */

/*Table structure for table `tbl_staffmaster_lab` */

DROP TABLE IF EXISTS `tbl_staffmaster_lab`;

CREATE TABLE `tbl_staffmaster_lab` (
  `staff_id` int(11) NOT NULL auto_increment,
  `lab_no` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `test_date_time` datetime NOT NULL,
  `reffered_doctor_name` varchar(30) NOT NULL,
  `lab_charge` int(11) NOT NULL,
  `report` varchar(300) NOT NULL,
  `test_id` int(11) NOT NULL,
  PRIMARY KEY  (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_staffmaster_lab` */

/*Table structure for table `tbl_staffmaster_officialinformation` */

DROP TABLE IF EXISTS `tbl_staffmaster_officialinformation`;

CREATE TABLE `tbl_staffmaster_officialinformation` (
  `staff_id` int(11) NOT NULL auto_increment,
  `department` varchar(30) NOT NULL,
  `category` varchar(30) NOT NULL,
  `designation` varchar(30) NOT NULL,
  `salary_plan` varchar(30) NOT NULL,
  `qualification` varchar(30) NOT NULL,
  `date_of_join` date NOT NULL,
  `date_of_leave` date NOT NULL,
  `leave_reason` varchar(300) NOT NULL,
  PRIMARY KEY  (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_staffmaster_officialinformation` */

/*Table structure for table `tbl_staffmaster_ot` */

DROP TABLE IF EXISTS `tbl_staffmaster_ot`;

CREATE TABLE `tbl_staffmaster_ot` (
  `ot_id` int(11) NOT NULL auto_increment,
  `material` varchar(300) NOT NULL,
  `ot_date_time` datetime NOT NULL,
  `surgeon_id` int(30) NOT NULL,
  `no_of_assistant_surgeon` int(11) NOT NULL,
  `id_of_assistants` varchar(50) NOT NULL,
  `no_of_nurses` int(11) NOT NULL,
  `id_of_nurses` varchar(50) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `report_details` varchar(500) NOT NULL,
  `special_drugs` varchar(300) NOT NULL,
  `instruments` varchar(300) NOT NULL,
  `operation_charge` int(11) NOT NULL,
  PRIMARY KEY  (`ot_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_staffmaster_ot` */

/*Table structure for table `tbl_staffmaster_reference` */

DROP TABLE IF EXISTS `tbl_staffmaster_reference`;

CREATE TABLE `tbl_staffmaster_reference` (
  `staff_id` int(11) NOT NULL auto_increment,
  `name` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `designation` varchar(30) NOT NULL,
  `phone` int(11) NOT NULL,
  PRIMARY KEY  (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_staffmaster_reference` */

/*Table structure for table `tbl_staffmaster_skillset` */

DROP TABLE IF EXISTS `tbl_staffmaster_skillset`;

CREATE TABLE `tbl_staffmaster_skillset` (
  `staff_id` int(11) NOT NULL auto_increment,
  `skillset` varchar(300) NOT NULL,
  `ratinng` int(11) NOT NULL,
  PRIMARY KEY  (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_staffmaster_skillset` */

/*Table structure for table `test_category` */

DROP TABLE IF EXISTS `test_category`;

CREATE TABLE `test_category` (
  `test_id` int(11) NOT NULL auto_increment,
  `test_name` int(11) NOT NULL,
  PRIMARY KEY  (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `test_category` */

/*Table structure for table `test_category_bloodtest` */

DROP TABLE IF EXISTS `test_category_bloodtest`;

CREATE TABLE `test_category_bloodtest` (
  `test_id` int(11) NOT NULL default '1',
  `patient_id` int(11) NOT NULL,
  `bloodgroup` varchar(4) NOT NULL,
  `haemoglobin` float NOT NULL,
  `bloodsugar` tinyint(1) NOT NULL,
  `white_cells` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `test_category_bloodtest` */

/*Table structure for table `test_category_urinetest` */

DROP TABLE IF EXISTS `test_category_urinetest`;

CREATE TABLE `test_category_urinetest` (
  `test_id` int(11) NOT NULL default '2',
  `patient_id` int(11) NOT NULL,
  `color` varchar(20) NOT NULL,
  `clarity` varchar(20) NOT NULL,
  `specific_gravity` float NOT NULL,
  `glucose` float NOT NULL,
  `description` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `test_category_urinetest` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
