create database meal_card;
use meal_card;

create table info(
	id bigint(20) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
	number int unique ,
	name varchar(64),
	entrance_time bigint,
	create_time bigint,
	update_time bigint
);

create table consume(
	id bigint(20) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
	number int,
	money float,
	consume_time long
);