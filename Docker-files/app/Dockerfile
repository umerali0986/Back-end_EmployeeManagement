FROM openjdk:11 AS BUILD_IMAGE
WORKDIR /usr/src/app/
RUN cd ../../ && apt update && apt install maven -y
COPY ./ /usr/src/app/
RUN mvn install -DskipTests

FROM tomcat:10-jdk11
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=BUILD_IMAGE /usr/src/app/target/Employee_Management-v1.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]