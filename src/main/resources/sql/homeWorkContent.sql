CREATE TABLE `homework_content` (
  `user_id` bigint(20) DEFAULT NULL,
  `content_description` varchar(500) DEFAULT NULL,
  `content_authority` varchar(2) DEFAULT NULL,
  `content_id` bigint(20) NOT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `content_time` datetime DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  UNIQUE KEY `homework_content_content_id_uindex` (`content_id`),
  KEY `homework_image_sys_users_id_fk` (`user_id`),
  KEY `homework_content_sys_users_username_fk` (`user_name`),
  CONSTRAINT `homework_content_sys_users_username_fk` FOREIGN KEY (`user_name`) REFERENCES `sys_users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片信息表'