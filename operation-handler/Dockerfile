FROM maven:3.8.4-openjdk-17-slim AS build
COPY src /home/operation-handler/src
COPY pom.xml /home/operation-handler
RUN mvn -f /home/operation-handler/pom.xml clean package

FROM ghcr.io/graalvm/jdk:java17-21.3.0
COPY --from=build /home/operation-handler/target/operation-handler-0.0.1-SNAPSHOT.jar /usr/local/lib/operation-handler-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","/usr/local/lib/operation-handler-0.0.1-SNAPSHOT.jar"]