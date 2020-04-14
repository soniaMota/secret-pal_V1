
CREATE SEQUENCE hibernate_sequence START 100;

create table "user" (
	id Integer PRIMARY KEY,
    mail varchar(256) not null,
    password_hash varchar(256),
    fullname varchar(45) not null,
    age int not null,
    phone_number varchar(20),
    last_update timestamp not null
);

create table "group" (
	id Integer PRIMARY KEY,
    name varchar(45) not null
);

create table "event" (
	id Integer PRIMARY KEY,
    name varchar(45) not null,
    event_date timestamp not null,
    budget float4 not null,
    children_budget float4,
    place varchar(45),
    raffled_of boolean,
    group_id int,
    foreign key (group_id) references "group"(id)
);

create table "raffle"
(
	id Integer PRIMARY KEY,
    assigned_friend varchar(45),
    event_id int,
    foreign key (event_id) references "event"(id)
);

create table "user_group" (
	id Integer PRIMARY KEY,
    user_id int,
    group_id int,
    foreign key (user_id) references "user"(id) on delete cascade,
    foreign key (group_id) references "group"(id) on delete cascade
);
