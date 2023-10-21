# Use the official OpenJDK 11 base image
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file from your local machine into the container
COPY build/libs/*.jar app.jar

# Expose the port your application will run on (if needed)
# EXPOSE 8081

# Specify the command to run your Java 11 application
CMD ["java", "-jar", "app.jar"]

