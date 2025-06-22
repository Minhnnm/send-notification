#FROM openjdk:8-alpine
#ADD ./pushNotification-0.0.1-SNAPSHOT.jar app-send-noti.jar
#ENTRYPOINT ["java","-jar","app-send-noti.jar"]
#EXPOSE 8080
FROM maven:3.8.7-openjdk-8 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:8-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]