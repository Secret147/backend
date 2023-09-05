FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY pom.xml /app/pom.xml
COPY target/phone2-0.0.1-SNAPSHOT.jar phone2-0.0.1-SNAPSHOT.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/phone2-0.0.1-SNAPSHOT.jar"]
