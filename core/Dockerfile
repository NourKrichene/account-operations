FROM maven:3.8.4-openjdk-17-slim AS build
COPY src /home/core/src
COPY pom.xml /home/core
RUN mvn -f /home/core/pom.xml clean package

FROM ghcr.io/graalvm/jdk:java17-21.3.0
COPY --from=build /home/core/target/core-0.0.1-SNAPSHOT.jar /usr/local/lib/core-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/core-0.0.1-SNAPSHOT.jar"]