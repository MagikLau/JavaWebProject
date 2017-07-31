
--
-- Table structure for table `content`
--
CREATE DATABASE Course;
USE Course;

DROP TABLE IF EXISTS `content`;

CREATE TABLE `content` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `price` bigint(20) DEFAULT NULL COMMENT '当前价格',
  `num` int(11) DEFAULT NULL COMMENT '销售数量',
  `sellerId` int(11) DEFAULT NULL COMMENT '卖家ID',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `icon` varchar(200) DEFAULT NULL COMMENT '图片',
  `summary` varchar(200) DEFAULT NULL COMMENT '摘要',
  `detail` longtext COMMENT '正文',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `content`
--

LOCK TABLES `content` WRITE;

INSERT INTO `content` VALUES (1,10,10,2,'TestTitle01','/static/image/image001.jpg','TestSummary01','TestDetail01')
  ,(2,20,20,2,'TestTitle02','/static/image/image002.jpg','TestSummary02','TestDetail02')
  ,(3,1,1,2,'TestPublish01','/static/image/image003.jpg','TestPublish01','TestPublish01')
  ,(4,2,1,2,'TestPublish02','/static/image/image004.jpg','TestPublish02','喵喵喵？')
  ,(5,3,1,2,'TestPublish03','/static/image/image005.jpg','TestPublish03','TestPublish03')
  ,(6,4,1,2,'TestPublish04','/static/image/image006.jpg','TestPublish04','TestPublish04')
  ,(7,299,1,2,'eekoo/壹酷 SSD 120G固态硬盘','/static/image/image007.jpg','eekoo/壹酷 SSD 120G固态硬盘 笔记本台式机SATA3高速2.5寸非128G','eekoo/壹酷 SSD 120G固态硬盘 笔记本台式机SATA3高速2.5寸非128G')
  ,(8,658,1,2,'AData/威刚 SU800 256G SSD','/static/image/image008.jpg','AData/威刚 SU800 256G SSD固态硬盘台式机笔记本固态硬盘非250G','AData/威刚 SU800 256G SSD固态硬盘台式机笔记本固态硬盘非250G');
UNLOCK TABLES;

--
-- Table structure for table `trx`
--

DROP TABLE IF EXISTS `trx`;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trx` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `contentId` int(11) DEFAULT NULL COMMENT '内容ID',
  `personId` int(11) DEFAULT NULL COMMENT '用户ID',
  `price` int(11) DEFAULT NULL COMMENT '购买价格',
  `num` int(11) DEFAULT NULL COMMENT '购买数量',
  `time` bigint(20) DEFAULT NULL COMMENT '购买时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `trx`
--

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userName` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码md5加密',
  `nickName` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `userType` tinyint(3) DEFAULT NULL COMMENT '类型，买家0，卖家1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;

INSERT INTO `user` VALUES (1,'buyer','37254660e226ea65ce6f1efd54233424','buyer',0)
  ,(2,'seller','981c57a5cfb0f868e064904b8745766f','seller',1);

UNLOCK TABLES;

-- Dump completed on 2017-07-12 14:46:27
