create database management;
\c management
create table categories (id serial primary key, category varchar(200));
create table role (id serial primary key, role_name varchar(200));
create table roles (id serial primary key, rights varchar(200));
create table role_roles (
	id serial primary key,
	role_id int references role(id),
	roles_id int references roles(id)
);
create table users (
	id serial primary key, 
	name varchar(200), 
	role_id int references role(id)
);
create table state (id serial primary key, status varchar(200));
create table items (
	id serial primary key,
	description varchar(200),
	users_id int references users(id),
	categories_id int references categories(id),
	state_id int references state(id)
);
create table comments (
	id serial primary key, 
	comment varchar(200), 
	items_id int references items(id)
);
create table attachs (
	id serial primary key, 
	link varchar(200), 
	items_id int references items(id)
);
insert into categories (category) values ('category_1');
insert into role (role_name) values ('role_1');
insert into roles (rights) values ('right_1');
insert into role_roles (role_id, roles_id) values (1, 1);
insert into users (name, role_id) values ('User_1', 1);
insert into state (status) values ('status_1');
insert into items (description, users_id, categories_id, state_id) values ('desc_1', 1, 1, 1);
insert into comments (comment, items_id) values ('comment_1', 1);
insert into attachs (link, items_id) values ('link_1', 1);