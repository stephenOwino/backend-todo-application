FROM gradle:jdk-21-and-22-jammy AS build
COPY . .
RUN gradle clean package -DskpTests

FROM openjdk:21-jdk-slim
COPY --from=build /target/todo-application-0.0.1-SNAPSHOT.jar todo-application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "todo-application.jar"]


