FROM openjdk:11
WORKDIR /app
ADD build/libs/*.jar config-server.jar
EXPOSE 9900
ENTRYPOINT ["java", "-jar", "config-server.jar"]