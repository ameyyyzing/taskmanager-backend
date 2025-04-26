# Stage 1: Build the application
FROM maven:3.9.4-eclipse-temurin-17 as builder

# Set working directory inside builder image
WORKDIR /app

# Copy all files (source code) into container
COPY . .

# Build the project with Maven Wrapper (skip tests to save time)
RUN ./mvnw package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk-slim

# Set working directory for running app
WORKDIR /app

# Copy only the generated JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port (8080)
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
