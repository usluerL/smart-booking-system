FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY . .
RUN mvn clean install -DskipTests -pl discovery-service -am

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

COPY --from=build /app/discovery-service/target/*.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]