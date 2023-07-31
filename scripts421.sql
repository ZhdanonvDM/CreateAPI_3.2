ALTER table student add constraint age check (age>16);
ALTER table student alter column age set default 20;
ALTER table student add UNIQUE (name);
ALTER table student alter column name SET not null;

ALTER table faculty add UNIQUE (name, color);


CREATE TABLE faculties
(id bigint,
 color varchar (30),
 name varchar (30),
 UNIQUE (color, name)
);

