FROM maven:3.8.7-openjdk-18-slim as build
COPY . /app
WORKDIR /app
RUN mvn clean install -DskipTests
FROM openjdk:18-jdk-slim
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]