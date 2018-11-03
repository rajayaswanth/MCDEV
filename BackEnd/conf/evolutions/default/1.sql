# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  id                            integer auto_increment not null,
  name                          varchar(255),
  email                         varchar(255),
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists user;

