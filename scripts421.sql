CREATE TABLE students
(id bigint,
 age integer  check (age>16) default 20,
 name varchar (30) UNIQUE not null
);

CREATE TABLE faculties
(id bigint,
 color varchar (30),
 name varchar (30),
 UNIQUE (color, name)
);

