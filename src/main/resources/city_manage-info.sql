create database city_manage;
use city_manage;
create table info(
	id bigint(20) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
	number int ,
	name varchar(64),
	entrance_time bigint,
	create_time bigint,
	update_time bigint
);

create table consume(
	id bigint(20) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
	money float,
	consume_time long
);