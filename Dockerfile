# Use the official OpenJDK image as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file into the container
COPY target/cambodia-0.0.1-SNAPSHOT.jar /app/cambodia.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/cambodia.jar"]
