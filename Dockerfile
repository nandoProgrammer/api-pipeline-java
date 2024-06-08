FROM eclipse-temurin:18-jdk-slim
WORKDIR /app
COPY target/curso-1.0.0.jar deploy_curso-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","deploy_curso-1.0.0.jar"]