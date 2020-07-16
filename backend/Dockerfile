FROM maven:3.5.2-jdk-8-alpine AS build
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /build/target/*.jar ./app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]