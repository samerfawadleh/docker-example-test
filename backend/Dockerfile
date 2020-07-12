#FROM tomcat:9
#COPY ./target/Library-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
#EXPOSE 8080
#CMD ["catalina.sh", "run"]

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]