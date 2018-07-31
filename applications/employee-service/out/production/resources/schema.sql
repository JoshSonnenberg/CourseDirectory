DROP TABLE IF EXISTS employee;

CREATE TABLE employee
(
    id varchar(36) NOT NULL,
    firstName varchar(50) NOT NULL,
    lastName varchar(50) NOT NULL,
    employeeNumber integer NOT NULL,
    office varchar(200),
    title varchar(200),
    email varchar(200),
    imageURL varchar(500),
    PRIMARY KEY (id)
);
