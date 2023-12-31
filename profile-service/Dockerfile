# Step 1: Use a Maven image to build the project
FROM maven:3.9.6-amazoncorretto-21 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

# Step 2: Use an OpenJDK image to run the JAR
FROM openjdk:21
COPY --from=build /usr/src/app/target/*.jar /usr/app/app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/app/app.jar"]
