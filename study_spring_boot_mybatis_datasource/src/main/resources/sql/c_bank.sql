CREATE TABLE `c_bank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(24) DEFAULT NULL,
  `name` varchar(64) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;