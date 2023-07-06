FROM openjdk:17-jdk
WORKDIR /app
COPY target/prueba-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "prueba-0.0.1-SNAPSHOT.jar"]