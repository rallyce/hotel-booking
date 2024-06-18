CREATE TABLE `t_bookings` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `booking_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
  );