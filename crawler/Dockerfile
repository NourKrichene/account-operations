FROM gradle:7.4.1-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 

FROM openjdk:17-jdk-slim
COPY --from=build /home/gradle/src/build/libs/crawler-0.0.1-SNAPSHOT.jar /usr/local/lib/crawler-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","/usr/local/lib/crawler-0.0.1-SNAPSHOT.jar"]