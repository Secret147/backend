#
# Build stage
#
FROM maven:3.8.7-jdk-1.8 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:1.8-jdk-slim
COPY --from=build /target/phonesale2-0.0.1-SNAPSHOT.jar phonesale2.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","phonesale2.jar"]