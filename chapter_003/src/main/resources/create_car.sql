create table car (
id serial primary key,
name varchar(20),
body_id int references car_body(id),
engine_id int references car_engine(id),
gearbox_id int references car_gearbox(id)
);
insert into car (name, body_id, engine_id, gearbox_id) VALUES ('машина 1', 1, 1, 2);
insert into car (name, body_id, engine_id, gearbox_id) VALUES ('машина 2', 3, 1, 2);
insert into car (name, body_id, engine_id, gearbox_id) VALUES ('машина 3', 3, 1, 1);
insert into car (name, body_id, engine_id, gearbox_id) VALUES ('машина 4', 2, 1, 2);
insert into car (name, body_id, engine_id, gearbox_id) VALUES ('машина 5', 1, 1, 4);
insert into car (name, body_id, engine_id, gearbox_id) VALUES ('машина 6', 3, 1, 4);
insert into car (name, body_id, engine_id, gearbox_id) VALUES ('машина 7', 2, 1, 1);