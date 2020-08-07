FROM adoptopenjdk/openjdk11:latest
RUN mkdir /opt/app
COPY /build/libs/dolap-app-0.0.1-SNAPSHOT.jar /opt/app/dolap-app-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/opt/app/dolap-app-0.0.1-SNAPSHOT.jar"]
