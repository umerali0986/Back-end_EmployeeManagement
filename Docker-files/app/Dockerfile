FROM openjdk:11 AS app_image
WORKDIR /usr/src/app/
RUN apt update && apt install maven -y
RUN git clone https://github.com/umerali0986/Back_end_EmployeeManagement.git
RUN cd Back_end_EmployeeManagement && mvn install -DskipTests

FROM openjdk:11
WORKDIR /usr/src/app/

COPY --from=app_image /Back_end_EmployeeManagement/target/Employee_Management-0.0.1-SNAPSHOT.jar ./Employee_Management-0.0.1-SNAPSHOT.jar

EXPOSE 9000
ENTRYPOINT ["java","-jar","Employee_Management-0.0.1.jar"]