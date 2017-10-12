CREATE TABLE `homework_content_location` (
  `content_id` int(11) DEFAULT NULL,
  `content_url` varchar(200) DEFAULT NULL,
  `content_type` varchar(10) DEFAULT NULL COMMENT '1：图片 2：视频',
  `content_time` datetime DEFAULT NULL,
  `content_location_id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`content_location_id`),
  UNIQUE KEY `homework_content_location_content_location_id_uindex` (`content_location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8