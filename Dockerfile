FROM openjdk:8-alpine
ADD ./pushNotification-0.0.1-SNAPSHOT.jar app-send-noti.jar
ENTRYPOINT ["java","-jar","app-send-noti.jar"]
EXPOSE 8080