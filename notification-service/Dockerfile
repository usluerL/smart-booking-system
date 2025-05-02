FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY . .

RUN mvn clean install -pl common -am -DskipTests -Dmaven.repo.local=/root/.m2/repository

WORKDIR /app/notification-service

RUN mvn clean package -DskipTests -Dmaven.repo.local=/root/.m2/repository

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

COPY --from=build /app/notification-service/target/*.jar app.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "app.jar"]