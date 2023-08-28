#
# Build stage
#

FROM maven:3.9.1-openjdk-8 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:8-jdk-slim
COPY --from=build /target/phonesale-0.0.1-SNAPSHOT.jar phonesale2.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","phonesale2.jar"]
