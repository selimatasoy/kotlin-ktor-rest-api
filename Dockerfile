FROM gradle:7-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle shadowJar --no-daemon

FROM amazoncorretto:11
EXPOSE 8081:8081
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/kotlin-ktor-rest-api.jar
ENTRYPOINT ["java","-jar","/app/kotlin-ktor-rest-api.jar"]