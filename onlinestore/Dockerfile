FROM debian:10
WORKDIR /app

RUN apt-get update -y && apt-get install -y openjdk-11-jdk jetty9 && apt-get clean
COPY ./pom.xml ./pom.xml
COPY ./mvnw ./mvnw
COPY ./.mvn ./.mvn
RUN ./mvnw dependency:go-offline -B
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v0.4.0/opentelemetry-auto-all.jar .
COPY ./src ./src
RUN ./mvnw package 
RUN cp ./target/onlinestore-0.0.1.war /usr/share/jetty9/webapps/

EXPOSE 8080
ENTRYPOINT /usr/share/jetty9/bin/jetty.sh run