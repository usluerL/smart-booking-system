# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21
WORKDIR /app
COPY --from=build /app/target/api-gateway-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]