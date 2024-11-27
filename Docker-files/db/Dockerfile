FROM mysql:8.0

ENV MYSQL_ROOT_PASSWORD="root123"
ENV MYSLQ_DATABASE="employee_management"

ADD ./employee_management.sql /docker-entrypoint-initdb.d/employee_management.sql
EXPOSE 3306