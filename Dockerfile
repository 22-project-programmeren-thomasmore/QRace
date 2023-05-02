# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine3.14

# Set the working directory to /app
WORKDIR /app

# Copy the executable jar file and the application.properties file to the container
COPY target/Team_5-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/application.properties application.properties

# Set the environment variables for the application
ENV SPRING_PROFILES_ACTIVE=prod

# Expose the port that the application will run on
EXPOSE 8080

# Run the jar file when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
