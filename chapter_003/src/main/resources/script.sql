create table users (id serial primary key, name varchar(20) unique not null);

create table meeting (id serial primary key, name varchar (20) unique not null);

create table statuses (id serial primary key,
user_id int REFERENCES users (id) not null,
meeting_id int REFERENCES meeting (id) not null);

select m.name, count(m.name) from statuses s
join meeting m on s.meeting_id = m.id
group by m.name;

select m.name from meeting m left
join statuses s on m.id = s.meeting_id where s.meeting_id is null;