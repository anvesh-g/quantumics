CREATE TABLE IF NOT EXISTS Employee (
    employee_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name varchar(255),
    last_name varchar(255),
    gender char(1),
	email_id varchar(255),
	date_of_birth date,
	date_of_joining date,
    salary int
);



INSERT INTO public.employee(
	employee_id, first_name, last_name, gender, email_id, date_of_birth, date_of_joining, salary)
	VALUES (1, 'Anvesh', 'Gatadi', 'M', 'anvesh.gatadi@gmail.com', '1992-11-19', '2017-01-17', 15000);