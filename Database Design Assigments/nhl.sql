create database if not exists nhl;
use nhl;

set FOREIGN_KEY_CHECKS = 0;

drop table if exists captain;
drop table if exists game;
drop table if exists injury;
drop table if exists player;
drop table if exists team;

create table if not exists team(
	id 			int 		auto_increment,
    name		varchar(50)	unique not null,
    city		varchar(50)	not null,
    coach		varchar(50),
    captain_id	int,
    
    primary key (id),
    foreign key (captain_id) references player (id)
);

create table if not exists player (
	id 			int				auto_increment,
    name 		varchar(50)		not null,
    skill 		int,
    team_id 	int,
	
    primary key (id),
    foreign key (team_id) references team (id)
);

create table if not exists game (
	host	int,
    guest	int,
	date	date,
    score	varchar(10),
    
    foreign key (host) references team (id),
    foreign key (guest) references team (id)
);

create table if not exists injury (
    player_id		int,
    description		text,

    foreign key (player_id) references player (id)
);

insert into team values (id,'Rangers', 'New York City', 'David Quinn', NULL);
insert into team values (id,'Coyotes', 'Glendale', 'Rick Tocchet', NULL);

insert into player values 
	(id, 'Chris Kreider', 0, 1),
    (id, 'Tony DeAngelo', 0, 1),
    (id, 'Oliver Ekman-Larsson', 0, 2),
    (id, 'Lawson Crouse', 0, 2);

update team set captain_id = (select id from player where player.name = 'Chris Kreider')
	where team.name = 'Rangers';
    
update team set captain_id = (select id from player where player.name = 'Oliver Ekman-Larsson')
	where team.name = 'Coyotes';

insert into game (host, guest, date, score)
	select a.id, b.id, str_to_date('03/04/2019', '%m/%d/%Y'), '4-2' from team a, team b
    where a.name = 'Rangers' and b.name = 'Coyotes';
    
insert into game (host, guest, date, score)
	select a.id, b.id, str_to_date('10/22/2020', '%m/%d/%Y'), '3-4' from team a, team b
    where a.name = 'Coyotes' and b.name = 'Rangers';

insert into injury (player_id, description) 
	select id, 'Pulled hamstring on 10/22/2020. Cannot play for two weeks.' from player 
    where name = 'Tony DeAngelo';

select * from team;
select * from player;
select * from game;
select * from injury;

select p1.name as host, p2.name as guest, date, score 
from game g 
join team t1 	on g.host = t1.id
join player p1 	on t1.captain_id = p1.id
join team t2 	on g.guest = t2.id
join player p2 	on t2.captain_id = p2.id;