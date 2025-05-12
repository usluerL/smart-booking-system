version: '3.9'

services:
  config-server:
    build:
      context: .
      dockerfile: config-server/Dockerfile
    ports:
      - "8888:8888"
    environment:
      - SPRING_PROFILES_ACTIVE=dev
    networks:
      - app-net

  discovery-service:
    build:
      context: .
      dockerfile: discovery-service/Dockerfile
    ports:
      - "8761:8761"
    depends_on:
      - config-server
    environment:
      - SPRING_PROFILES_ACTIVE=dev
    networks:
      - app-net

  gateway-service:
    build:
      context: .
      dockerfile: gateway-service/Dockerfile
    ports:
      - "8080:8080"
    depends_on:
      - config-server
      - discovery-service
    environment:
      - SPRING_PROFILES_ACTIVE=dev
    networks:
      - app-net

  reservation-service:
    build:
      context: .
      dockerfile: reservation-service/Dockerfile
    ports:
      - "8081:8081"
    depends_on:
      - config-server
      - discovery-service
    environment:
      - SPRING_PROFILES_ACTIVE=dev
    networks:
      - app-net

  hotel-service:
    build:
      context: .
      dockerfile: hotel-service/Dockerfile
    ports:
      - "8082:8082"
    depends_on:
      - config-server
      - discovery-service
    environment:
      - SPRING_PROFILES_ACTIVE=dev
    networks:
      - app-net

  search-service:
    build:
      context: .
      dockerfile: search-service/Dockerfile
    ports:
      - "8100:8100"
    depends_on:
      - config-server
      - discovery-service
    environment:
      - SPRING_PROFILES_ACTIVE=dev
    networks:
      - app-net

  notification-service:
    build:
      context: .
      dockerfile: notification-service/Dockerfile
    ports:
      - "8090:8090"
    depends_on:
      - config-server
      - discovery-service
    environment:
      - SPRING_PROFILES_ACTIVE=dev
    networks:
      - app-net

networks:
  app-net:
    driver: bridge
