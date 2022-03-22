FROM adoptopenjdk/openjdk11:alpine
EXPOSE 8080
ENV TZ America/Sao_Paulo
ADD /target/supports-0.0.1-SNAPSHOT.jar support.jar
ENTRYPOINT ["java", "-jar", "support.jar"]