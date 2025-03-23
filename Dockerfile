FROM openjdk:11-jre-slim
LABEL authors="ukhov"

VOLUME /tmp
COPY target/my-app.jar my-app.jar
ENTRYPOINT ["java", "-jar", "/my-app.jar"]
