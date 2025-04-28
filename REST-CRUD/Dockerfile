#FROM ubuntu
#RUN apt-get update -y
#RUN apt-get update install -y openjdk-17.jdk
#EXPOSE 8082
#WORKDIR /app/source
#COPY . .
#RUN .mvnw packages
#RUN mv ./target/*.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]
FROM ubuntu:latest

# Install dependencies and OpenJDK 17
RUN apt-get update -y && \
    apt-get install -y openjdk-17-jdk maven curl

# Set the working directory
WORKDIR /app/source

# Copy the source code
COPY . .

# Build the project
RUN ./mvnw package -DskipTests

# Move the built jar to a known name
RUN mv ./target/*.jar app.jar

# Expose the app port
EXPOSE 8082

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
