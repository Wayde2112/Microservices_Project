FROM maven:3.8.1-openjdk-17-slim as builder
ARG MVN_ARGS
ADD ./src /app/src/
ADD ./pom.xml /app/pom.xml
WORKDIR /app

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8102:8102
ENTRYPOINT ["java","-jar","app.jar"]