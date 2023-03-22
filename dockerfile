FROM openjdk:21
MAINTAINER github/madelagracia
COPY ./target/backend-0.0.1-SNAPSHOT.jar /app/backend-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]
