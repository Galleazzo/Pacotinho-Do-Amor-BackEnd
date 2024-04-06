FROM eclipse-temurin:11-jdk-alpine
WORKDIR /app
COPY target/Pacotinho-do-amor-BackEnd-1.0.0.jar Pacotinho-do-amor-BackEnd-1.0.0.jar
EXPOSE 8080
CMD ["java", "-jar", "Pacotinho-do-amor-BackEnd-1.0.0.jar"]