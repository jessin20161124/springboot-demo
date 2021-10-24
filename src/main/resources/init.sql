
create database if not exists spring;

create table if not existstb_user  (
 id bigint auto_increment ,
 name varchar(100) not null default '',
 sex tinyint(2) not null default '0',
 age tinyint(2) not null default '0',
 note varchar(512) not null default '',
 create_time datetime not null default CURRENT_TIMESTAMP ,
 last_modified_time datetime not null default CURRENT_TIMESTAMP,
 primary key(id)
);