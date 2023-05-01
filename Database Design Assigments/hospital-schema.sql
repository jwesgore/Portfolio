drop database if exists hospital;
create database hospital;
use hospital;

create table if not exists physician(
	id					int,
    name				varchar(50),
    address				varchar(100),
    phone_num			int,
    certificate_num		int,
    field_exp			varchar(50),
    
	primary key auto_increment (id),
    unique (certificate_num)
);

create table if not exists nurse(
	id					int,
    name				varchar(50),
    address				varchar(100),
    phone_num			int,
    certificate_num		int,
    
    primary key auto_increment (id),
    unique (certificate_num)
);

create table if not exists room(
	room_num	int,
	capacity	int,
    fee			double,
    
    primary key (room_num)
);

create table if not exists patient(
	id			int,
    room_num	int,
    name		varchar(50),
    address		varchar(100),
    phone_num	int,
    
    primary key auto_increment (id),
    foreign key (room_num) references room (room_num)
);

create table if not exists physician_monitors_patient(
	physician_id	int,
    patient_id		int,
    duration		time,
    
    foreign key (physician_id) 	references physician (id),
    foreign key (patient_id) 	references patient (id)
);

create table if not exists health_record(
	patient_id			int,
    date				date,
    description 		text,
    status				varchar(50),
    disease_history 	text,
    
    foreign key (patient_id) references patient (id)
);

create table if not exists medication(
	nurse_id		int,
    patient_id		int,
    name			varchar(50),
    amount			int,
    
    foreign key (nurse_id) 		references nurse (id),
    foreign key (patient_id)	references patient (id)
);

create table if not exists instruction(
	code 			int,
    physician_id	int,
    fee				double,
    description		text,
    date			date,
    status			varchar(50),
    
    primary key auto_increment (code),
    foreign key (physician_id) references physician (id)
);

create table if not exists given_instruction(
	code		int,
    nurse_id	int,
    
    foreign key (code)		references instruction (code),
    foreign key (nurse_id)	references nurse (id)
);

create table if not exists payment(
	patient_id	int,
    date		date,
    amount		double,
    
    foreign key (patient_id) references patient (id)
);