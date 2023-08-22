CREATE TABLE person
(
id SERIAL primary key,
name varchar(50),
age integer,
got_license boolean,
car_id integer references car (id)
);

create table car
(
id serial primary key,
brand varchar(50),
model varchar(50),
price decimal
)