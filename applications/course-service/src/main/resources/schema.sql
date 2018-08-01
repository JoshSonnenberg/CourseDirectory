DROP TABLE IF EXISTS course;

CREATE TABLE course
(
    id varchar(36) NOT NULL,
    name varchar(200) NOT NULL,
    tags varchar(1000),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS enrollment;

CREATE TABLE enrollment
(
    employeeId varchar(36) NOT NULL,
    courseId varchar(36) NOT NULL,
    completed varchar(1) DEFAULT 'N',
    PRIMARY KEY (employeeId, courseId)
);
