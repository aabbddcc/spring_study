DROP DATABASE IF EXISTS course;
CREATE DATABASE course DEFAULT CHARACTER SET utf8;
 
use course;

CREATE TABLE `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `author` varchar(20) DEFAULT NULL COMMENT '作者',
  `title` varchar(100) DEFAULT NULL COMMENT '描述',
  `url` varchar(100) DEFAULT NULL COMMENT '地址链接',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1029 DEFAULT CHARSET=utf8;

insert into `course`(`id`,`author`,`title`,`url`) values (999,'spring','SpriongBoot官方例子1','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`id`,`author`,`title`,`url`) values (1000,'spring','SpriongBoot官方例子2','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`id`,`author`,`title`,`url`) values (1001,'spring','SpriongBoot官方例子3','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`id`,`author`,`title`,`url`) values (1002,'spring','SpriongBoot官方例子4','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`id`,`author`,`title`,`url`) values (1003,'spring','SpriongBoot官方例子5','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`id`,`author`,`title`,`url`) values (1004,'spring','SpriongBoot官方例子6','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`id`,`author`,`title`,`url`) values (1005,'spring','SpriongBoot官方例子7','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`id`,`author`,`title`,`url`) values (1006,'spring','SpriongBoot官方例子8','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`id`,`author`,`title`,`url`) values (1007,'spring','SpriongBoot官方例子9','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`id`,`author`,`title`,`url`) values (1008,'spring','SpriongBoot官方例子10','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`id`,`author`,`title`,`url`) values (1009,'spring','SpriongBoot官方例子11','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`id`,`author`,`title`,`url`) values (1010,'spring','SpriongBoot官方例子12','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
