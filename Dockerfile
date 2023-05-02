#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/Team_5-0.0.1-SNAPSHOT.jar Team_5.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","Team_5.jar"]