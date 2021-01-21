/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.32-log : Database - kgcnews
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kgcnews` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `kgcnews`;

/*Table structure for table `news_category` */

DROP TABLE IF EXISTS `news_category`;

CREATE TABLE `news_category` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='新闻分类表';

/*Data for the table `news_category` */

insert  into `news_category`(`id`,`name`,`createDate`) values (1,'国内','2016-09-16 14:41:24'),(2,'国际','2016-09-16 14:42:58'),(3,'娱乐','2016-09-16 14:42:58'),(4,'军事','2016-09-16 14:42:58'),(5,'财经','2016-09-16 14:42:58'),(6,'天气','2016-09-16 14:42:58');

/*Table structure for table `news_comment` */

DROP TABLE IF EXISTS `news_comment`;

CREATE TABLE `news_comment` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `newsId` bigint(10) DEFAULT NULL COMMENT '评论新闻id',
  `content` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '评论内容',
  `author` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '评论者',
  `ip` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '评论ip',
  `createDate` datetime DEFAULT NULL COMMENT '发表时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='新闻评论表';

/*Data for the table `news_comment` */

/*Table structure for table `news_detail` */

DROP TABLE IF EXISTS `news_detail`;

CREATE TABLE `news_detail` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `categoryId` bigint(10) DEFAULT NULL COMMENT '新闻类别id',
  `title` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '新闻标题',
  `summary` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '新闻摘要',
  `content` text COLLATE utf8_unicode_ci COMMENT '新闻内容',
  `picPath` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '新闻图片路径',
  `author` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发表者',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='新闻明细表';

/*Data for the table `news_detail` */

insert  into `news_detail`(`id`,`categoryId`,`title`,`summary`,`content`,`picPath`,`author`,`createDate`,`modifyDate`) values (1,1,'Java Web开课啦','Java Web课程重磅开课，学员福利','璇女神主讲，课工场倾力出品，Java Web课程开课了，等靠谱的你来报名！','','admin','2016-05-16 14:43:53','2015-05-16 14:43:53'),(2,1,' 520课工场Java狂欢节','课工场准备了一大波福利：Java大赛、折扣课程，免费线下福利……你准备好了吗？','在这个五月，课工场Java学员突破100万人。为感谢所有学员的支持，我们特将5月20日定为【课工场Java狂欢节】。课工场准备了一大波福利：Java大赛、折扣课程，免费线下福利……你准备好了吗？',NULL,'admin','2016-05-16 14:43:53','2016-05-16 14:43:53');

/*Table structure for table `news_user` */

DROP TABLE IF EXISTS `news_user`;

CREATE TABLE `news_user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'email',
  `userType` int(5) DEFAULT NULL COMMENT '用户类型  0：管理员 1：普通用户',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户表';

/*Data for the table `news_user` */

insert  into `news_user`(`id`,`userName`,`password`,`email`,`userType`) values (1,'admin','admin','admin@kgc.cn',0),(2,'user','user','user@kgc.cn',1),(3,'test','test','test@kgc.cn',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
