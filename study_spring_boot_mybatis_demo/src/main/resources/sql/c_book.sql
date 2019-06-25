CREATE TABLE `c_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(24) DEFAULT NULL,
  `book_number` varchar(64) DEFAULT NULL,
  `publish_company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;