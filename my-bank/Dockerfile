FROM maven:3.8.4-openjdk-17-slim AS build
COPY src /home/my-bank/src
COPY pom.xml /home/my-bank
RUN mvn -f /home/my-bank/pom.xml clean package

FROM ghcr.io/graalvm/jdk:java17-21.3.0
COPY --from=build /home/my-bank/target/my-bank-0.0.1-SNAPSHOT.jar /usr/local/lib/my-bank-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/my-bank-0.0.1-SNAPSHOT.jar"]