# Use the official Eclipse Temurin JRE 21 base image
FROM eclipse-temurin:17-alpine-3.21 AS builder

WORKDIR /app

ADD ./build/libs/app.jar /app.jar
ADD opentelemetry-javaagent.jar /opentelemetry-javaagent.jar

EXPOSE 8080
ENTRYPOINT java -javaagent:opentelemetry-javaagent.jar -Dotel.traces.exporter=logging -Dotel.metrics.exporter=logging -Dotel.logs.exporter=logging -jar /app.jar

#ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]