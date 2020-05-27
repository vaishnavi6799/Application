
CREATE TABLE department (DEPARTMENT_ID int(11) NOT NULL AUTO_INCREMENT,CODE_NAME varchar(10) DEFAULT NULL,DEPARTMENT_NAME varchar(100) DEFAULT NULL,PRIMARY KEY (DEPARTMENT_ID));

INSERT INTO department VALUES (1,'HR','Human Resources');
INSERT INTO department VALUES (2,'IT','Information Technology');
INSERT INTO department VALUES (3,'MK','Marketing');
INSERT INTO department VALUES (4,'R&D','Research and Development');
INSERT INTO department VALUES (5,'ACNT','Accounting');


CREATE TABLE employee (EMPLOYEE_ID int(11) NOT NULL AUTO_INCREMENT,FIRST_NAME varchar(50) DEFAULT NULL,LAST_NAME varchar(50) DEFAULT NULL,EMAIL varchar(50) DEFAULT NULL,department_id int(11) NOT NULL,PRIMARY KEY (EMPLOYEE_ID),FOREIGN KEY (department_id) REFERENCES department (DEPARTMENT_ID));

INSERT INTO employee VALUES (1,'Chandler','Bing','Chandler@gmail.com',2);
INSERT INTO employee VALUES (2,'Joey','Tribbiani','Joey@gmail.com',3);
INSERT INTO employee VALUES (3,'Rachel','Green','rachel@gmail.com',2);
INSERT INTO employee VALUES (4,'Monica','Geller','monica@gmail.com',1);
INSERT INTO employee VALUES (5,'Phoebe','Buffay','pheebs@gmail.com',3);
INSERT INTO employee VALUES (6,'Ross','Geller','ross@gmail.com',4);
INSERT INTO employee VALUES (7,'Janice','Hosenstein','janice@gmail.com',2);
INSERT INTO employee VALUES (8,'Gunther','CP','gunther@gmail.com',4);