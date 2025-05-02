FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY . .

# install common module first
RUN mvn clean install -pl common -am -DskipTests -Dmaven.repo.local=/root/.m2/repository

WORKDIR /app/booking-composition-service

RUN mvn clean package -DskipTests -Dmaven.repo.local=/root/.m2/repository

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

COPY --from=build /app/booking-composition-service/target/*.jar app.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "app.jar"]