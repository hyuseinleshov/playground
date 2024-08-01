# Use Amazon Corretto 21 base image
FROM amazoncorretto:21

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file into the container
COPY build/libs/docker-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port (e.g., 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]