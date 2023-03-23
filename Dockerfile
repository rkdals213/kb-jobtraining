FROM openjdk:17

EXPOSE 8080

ADD nok-backend/build/libs/kb-jobtraining-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod", "/app.jar"]