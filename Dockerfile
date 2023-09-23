FROM amazoncorretto:11-alpine
ARG JAR_FILE=target/T1-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]