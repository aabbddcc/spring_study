DROP DATABASE IF EXISTS study;
CREATE DATABASE study DEFAULT CHARACTER SET utf8;

use study;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) DEFAULT NULL COMMENT '登录账号',
  `password` varchar(20) DEFAULT NULL COMMENT '登录密码',
  `nicky` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT 'email地址',
  `sex` char(2) DEFAULT NULL COMMENT '性别',
  `birthday` varchar(20) DEFAULT NULL COMMENT '地址链接',
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1040 DEFAULT CHARSET=utf8;

INSERT INTO `user`(`name`, `password`, `nicky`, `phone`, `email`, `sex`, `birthday`) VALUES('user1', 'test', '王教授', '13456789123', 'admin@163.com', '男', '1986-06-15');
INSERT INTO `user`(`name`, `password`, `nicky`, `phone`, `email`, `sex`, `birthday`) VALUES('user2', 'test', '李教授', '15156789456', 'test6@163.com', '女', '1966-10-21');


CREATE TABLE `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `author` bigint(20) COMMENT '作者',
  `title` varchar(100) DEFAULT NULL COMMENT '描述',
  `url` varchar(100) DEFAULT NULL COMMENT '地址链接',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`author`) REFERENCES user(`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


insert into `course`(`author`,`title`,`url`) values (1040,'SpringBoot官方例子1','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`author`,`title`,`url`) values (1040,'SpringBoot官方例子2','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`author`,`title`,`url`) values (1040,'SpringBoot官方例子3','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`author`,`title`,`url`) values (1041,'SpringBoot官方例子4','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`author`,`title`,`url`) values (1041,'SpringBoot官方例子5','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`author`,`title`,`url`) values (1041,'SpringBoot官方例子6','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`author`,`title`,`url`) values (1040,'SpringBoot官方例子7','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`author`,`title`,`url`) values (1041,'SpringBoot官方例子8','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`author`,`title`,`url`) values (1041,'SpringBoot官方例子9','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`author`,`title`,`url`) values (1041,'SpringBoot官方例子10','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`author`,`title`,`url`) values (1041,'SpringBoot官方例子11','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert into `course`(`author`,`title`,`url`) values (1040,'SpringBoot官方例子12','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
