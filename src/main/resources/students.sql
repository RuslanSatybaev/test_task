DROP TABLE STUDENTS IF EXISTS;
CREATE TABLE STUDENTS
(
    ID         INT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    patronymic VARCHAR(255),
    birthday   DATE,
    group_name VARCHAR(255)
);