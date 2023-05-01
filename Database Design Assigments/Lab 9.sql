create database if not exists insurance;
use insurance;

drop table if exists car;
drop table if exists accident;
drop table if exists customer;

create table if not exists customer (
	id			int,
    name 		varchar(50),
    address 	varchar(100),

	primary 	key (id)
);

create table if not exists car (
	license		varchar(8),
    owner		int,
    make		varchar(50),
    model		varchar(50),
    
    primary key (license),
    foreign key (owner) references customer (id)
);

create table if not exists accident (
	report_number	int,
    location		varchar(100),
    date			date,
    
    primary key (report_number)
);

create table if not exists participation (
	damage_amount 	double,
    customer_id		int,
    license			varchar(8),
    report_number	int,
    
    foreign key (customer_id) references customer (id),
    foreign key (license) references car (license),
    foreign key (report_number) references accident (report_number)
);