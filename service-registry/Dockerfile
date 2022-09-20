# todo: If we want to do everything in one place
#FROM gradle:7.1.0-jdk11
##WORKDIR /app
#COPY . .
#EXPOSE 8761
#RUN gradle clean build
#ENTRYPOINT ["java", "-jar", "service-registry-0.0.1-SNAPSHOT.jar"]

#if we want to run by manually copying
FROM openjdk:11
ADD build/libs/*.jar service-registry.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "service-registry.jar"]