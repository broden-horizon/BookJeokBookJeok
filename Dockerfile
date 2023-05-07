FROM adoptopenjdk/openjdk11:debian
ARG JAR_FILE=build/libs/bookJeokBookJeok-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
