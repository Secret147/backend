#
# Build stage
#
FROM maven:3.8.7-openjdk-8 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:8-jdk-slim
COPY --from=build /target/phonesale2-0.0.1-SNAPSHOT.jar phonesale2.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","phonesale2.jar"]
