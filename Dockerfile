# Use a base image with Java installed
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file from the target directory into the container
COPY ./target/humansApp-0.0.1-SNAPSHOT.jar humans_app.jar

# Specify the command to run your application
ENTRYPOINT ["java", "-jar", "humans_app.jar"]


