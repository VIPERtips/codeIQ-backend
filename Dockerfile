# Stage 1: Build the application using a smaller JDK
FROM eclipse-temurin:17-jdk-alpine as builder
WORKDIR /app

# Copy the application files
COPY . .

# Make the mvnw script executable
RUN chmod +x ./mvnw

# Build the application using Maven
RUN ./mvnw clean package -DskipTests

# Stage 2: Create a lightweight runtime image
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy only the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar



# Reduce startup time with JVM optimizations
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:TieredStopAtLevel=1", "-jar", "app.jar"]
