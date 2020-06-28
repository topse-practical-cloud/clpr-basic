FROM debian:10
WORKDIR /app

RUN apt-get update -y
RUN apt-get install -y openjdk-11-jdk jetty9
COPY . .
RUN ./mvnw package 
RUN cp ./target/ad-microservice-0.0.1.war /usr/share/jetty9/webapps/

EXPOSE 8080
ENTRYPOINT /usr/share/jetty9/bin/jetty.sh run