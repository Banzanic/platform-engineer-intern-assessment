FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/platform-engineer-intern-assessment-1.0.jar /app/platform-engineer-intern-assessment-1.0.jar

COPY input.txt /app/input.txt

CMD ["java", "-jar", "/app/platform-engineer-intern-assessment-1.0.jar"]