FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY . .


WORKDIR /app/reservation-service

RUN mvn clean package -DskipTests -Dmaven.repo.local=/root/.m2/repository

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

COPY --from=build /app/reservation-service/target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]