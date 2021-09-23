FROM openjdk:8-jdk-slim
COPY "./build/libs/app-Desafio-BCP-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]

