FROM openjdk:8-jdk-alpine
MAINTAINER mdrsolutions.com
RUN addgroup -S mygroup && adduser -S myuser -G mygroup
USER myuser:mygroup
ARG JAR_FILE=build/libs/SpringBootProdApplication-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]