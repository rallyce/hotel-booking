CREATE TABLE `t_room_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
  );

insert into t_room_stock (name, quantity)
values ('Presidential_suit', 1),
       ('Vip_suit', 3),
       ('General_suit', 10);