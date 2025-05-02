FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . /app
RUN mvn clean install -DskipTests -pl config-server -am

FROM eclipse-temurin:21-jre
WORKDIR /app
EXPOSE 8888
COPY --from=build /app/config-server/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]