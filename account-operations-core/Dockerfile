FROM maven:3.8.4-openjdk-17-slim AS build
COPY src /home/account-operations-core/src
COPY pom.xml /home/account-operations-core
RUN mvn -f /home/account-operations-core/pom.xml clean package

FROM ghcr.io/graalvm/jdk:java17-21.3.0
COPY --from=build /home/account-operations-core/target/account-operations-core-0.0.1-SNAPSHOT.jar /usr/local/lib/account-operations-core-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","/usr/local/lib/account-operations-core-0.0.1-SNAPSHOT.jar"]