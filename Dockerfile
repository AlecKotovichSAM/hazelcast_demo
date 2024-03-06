FROM eclipse-temurin:21
WORKDIR /app
COPY build/libs/app.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]