DROP TABLE IF EXISTS course;

CREATE TABLE course
(
    id varchar(36) NOT NULL,
    name varchar(200) NOT NULL,
    tags varchar(1000),
    PRIMARY KEY (id)
);
