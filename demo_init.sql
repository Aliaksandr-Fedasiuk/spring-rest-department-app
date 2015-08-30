DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS employees;

CREATE TABLE IF NOT EXISTS departments (
    DEPARTMENT_ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    DEPARTMENT_NAME VARCHAR(100) NOT NULL,
    PRIMARY KEY (DEPARTMENT_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS employees (
    EMPLOYEE_ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    EMPLOYEE_DEPARTMENT_ID INT(10) UNSIGNED NOT NULL,
    EMPLOYEE_SURNAME VARCHAR(100) NOT NULL,
    EMPLOYEE_NAME VARCHAR(100) NOT NULL,
    EMPLOYEE_PATRONYMIC VARCHAR(100) NOT NULL,
    EMPLOYEE_DATE_OF_BIRTHDAY DATETIME NOT NULL,
    EMPLOYEE_SALARY INT(10) NOT NULL,
    PRIMARY KEY (EMPLOYEE_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO departments ( DEPARTMENT_ID, DEPARTMENT_NAME ) VALUES
(1, 'Department A'),
(2, 'Department B'),
(3, 'Department C'),
(4, 'Department D');

INSERT INTO employees ( EMPLOYEE_ID, EMPLOYEE_DEPARTMENT_ID, EMPLOYEE_SURNAME, EMPLOYEE_NAME, EMPLOYEE_PATRONYMIC, EMPLOYEE_DATE_OF_BIRTHDAY, EMPLOYEE_SALARY) VALUES
(1, 1, 'Williamson', 'Precious', 'John', '1990-04-05 00:00:00', 3500),
(2, 1, 'Ibarra', 'Helen', 'Lee', '1987-01-15 00:00:00', 1500),
(3, 1, 'Walsh', 'Max', 'John', '1991-09-12 00:00:00', 2500),
(4, 1, 'Thomas', 'Isaac', 'Houston', '1995-07-07 00:00:00', 1900),
(5, 1, 'Mike', 'Gordon', 'Iris', '1992-09-03 00:00:00', 2000),

(6, 2, 'Ella', 'Gutierrez', 'Martin', '1990-04-01 00:00:00', 1200),
(7, 2, 'Shiloh', 'Acosta', 'Coffey', '1990-03-10 00:00:00', 1100),
(8, 2, 'Alessandro', 'Mccullough', 'Molly', '1989-11-13 00:00:00', 2100),
(9, 2, 'Briana', 'Green', 'Immanuel', '1996-01-06 00:00:00', 1250),
(10, 2, 'Kieran', 'Mathis', 'Yates', '1972-02-09 00:00:00', 4300),

(11, 3, 'Elijah', 'Marquez', 'Brandon', '1988-05-02 00:00:00', 1900),
(12, 3, 'Aniya', 'Ballard', 'Dario', '1994-05-06 00:00:00', 2230),
(13, 3, 'Aurora', 'Bright', 'Guerra', '1994-02-06 00:00:00', 1890),

(14, 4, 'Zariah', 'Marks', 'Austin', '1990-03-09 00:00:00', 1290),
(15, 4, 'Cordell', 'Wilson', 'Azul', '1991-04-05 00:00:00', 3200);

     
    