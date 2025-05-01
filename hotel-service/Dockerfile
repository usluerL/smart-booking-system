FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY . .

COPY .m2 /root/.m2

WORKDIR /app/hotel-service

RUN mvn clean package -DskipTests -Dmaven.repo.local=/root/.m2/repository

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

COPY --from=build /app/hotel-service/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]