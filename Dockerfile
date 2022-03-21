FROM adoptopenjdk/openjdk11:alpine
EXPOSE 8080
ADD /target/supports-0.0.1-SNAPSHOT.jar support.jar
ENTRYPOINT ["java", "-jar", "support.jar"]