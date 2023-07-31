CREATE TABLE driver
(id bigint,
 name varchar (30) primary key ,
 age integer,
 driving_license boolean,
 car_id bigint references car (id)
);

CREATE TABLE car
(id bigint primary key ,
 brand varchar (30),
 mark varchar (30),
 cost integer
);

Select driver.id, driver.name, car.id, car.brand, car.mark from driver inner join car on car.id = driver.car_id;

Select student.id, student.name, student.age, avatar.id, avatar.data from student inner join avatar on avatar.id = student.avatar_id;

Select student.name, student.age, faculty.name from faculty inner join student on faculty.id = student.faculty_id