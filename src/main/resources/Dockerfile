# Use an official Gradle image to build the app
FROM gradle:jdk-21-and-22-jammy AS build

# Set the working directory in the container
WORKDIR /app

# Copy Gradle wrapper and build files
COPY gradlew /app/
COPY gradle /app/gradle/
COPY build.gradle /app/
COPY settings.gradle /app/

# Copy the source code
COPY src /app/src

# Run Gradle build
RUN gradle clean build -x test --no-daemon

# Use an official OpenJDK runtime as a parent image for the runtime stage
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/build/libs/todo-application-0.0.1-SNAPSHOT.jar todo-application.jar

# Expose the port your application will run on
EXPOSE 8080

# Specify the command to run your app
ENTRYPOINT ["java", "-jar", "todo-application.jar"]





