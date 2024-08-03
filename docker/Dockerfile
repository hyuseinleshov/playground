FROM amazoncorretto:21
WORKDIR /app
COPY build/libs/docker-0.0.1-SNAPSHOT.jar docker-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-0.0.1-SNAPSHOT.jar"]