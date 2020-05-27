# Application
A SpringBoot Application<br>
<b>About Application:</b><br>
● This application is the basic design of the employee management system.The entities used in this project are Employee and Department with a many to one relation between them.<br>
● Department(department_id,code_name,department_name)<br>
● Employee(employee_id,firstname,lastname,email,department_id)<br>
<b>Technologies Used:</b><br>
● Maven Project<br>
● SpringBoot<br>
● Spring Data Jpa dependency<br>
● Thymeleaf dependency<br>
● Mysql database<br>
● Intellij IDE<br>
<b>Steps to run the application:</b><br>
● Open mysql server and create a database with name ”EmpApp”.<br>
Command :CREATE DATABASE EmpApp;<br>
USE EmpApp;<br>
(Or)
Create a database with a name and write that in the place of “EmpApp” in the following line of code in ‘application.properties’ file.
spring.datasource.url​=​jdbc:mysql://localhost:3306/EmpApp<br>
● Place your mysql server username and password in the following lines of code in ‘application.properties’.
spring.datasource.username​=​root<br>
spring.datasource.password​=​password<br>
● Run ‘Application.java’ file<br>
● Application runs on ​http://localhost:8080/<br>
<b> Some screenshots of the application</b> <br>
![](images/list_emp.png)
<br>
![](images/list_dept.png)
<br>
![](images/edit_emp.png)
<br>
![](images/edit_dept.png)
<br>
![](images/add_emp.png)
<br>
![](images/add_dept.png)
