FROM openjdk:11 AS BUILD_IMAGE
RUN apt update && apt install maven -y
RUN git clone https://github.com/umerali0986/Back_end_EmployeeManagement.git
RUN cd Back_end_EmployeeManagement && mvn install -DskipTests

FROM openjdk:11
WORKDIR /usr/src/app/

COPY --from=BUILD_IMAGE /Back_end_EmployeeManagement/target/Employee_Management-v1.war ./Employee_Management.war

EXPOSE 9000
ENTRYPOINT ["java","-war","Employee_Management.war"]