FROM maven:3.8.1-openjdk-17-slim as builder
ADD ./src /app/borrowing-service/src
ADD ./pom.xml /app/borrowing-service/pom.xml
RUN mvn -f /app/borrowing-service/pom.xml clean package

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/borrowing-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]