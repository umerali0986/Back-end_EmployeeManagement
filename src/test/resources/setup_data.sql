create table employee (
id bigint not null auto_increment,
email varchar(255) not null,
employee_code varchar(255) not null,
first_name varchar(255) not null,
image_url varchar(255),
 job_title varchar(255) not null,
last_name varchar(255) not null,
 phone varchar(255) not null,
 primary key (id)) engine=InnoDB;

 INSERT INTO employee (1,first_name,last_name,email,phone,image_url,employee_code,job_title)
 VALUES ('John','Smith','johnsmith@gmail.com',"7621345890",'https://bootdey.com/img,/content/avatar/avatar1.png','uj83aw','front');

INSERT INTO employee (2,first_name,last_name,email,phone,image_url,employee_code,job_title)
VALUES ('John','Mike','johnmike@gmail.com',"9087645890",'https://bootdey.com/img,/content/avatar/avatar2.png','asf79u','Back-end');

INSERT INTO employee (3,first_name,last_name,email,phone,image_url,employee_code,job_title)
VALUES ('Akil','Ahmed','akilahmed@gmail.com',"7621386430",'https://bootdey.com/img,/content/avatar/avatar3.png','89hger','Full-Stack');