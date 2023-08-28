#
# Build stage
#

FROM maven:3.8.1-openjdk-8 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:1.8-jdk-slim
COPY --from=build /target/phonesale-0.0.1-SNAPSHOT.jar phonesale-0.0.1-SNAPSHOT.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","phonesale-0.0.1-SNAPSHOT.jar"]
