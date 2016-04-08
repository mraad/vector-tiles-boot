FROM alpine:3.3
MAINTAINER Mansour Raad <mraad@esri.com>
RUN apk --update add openjdk8-jre
COPY vector-tiles-boot-0.0.1-SNAPSHOT.jar /
EXPOSE 8080
ENTRYPOINT ["/usr/bin/java","-jar","/vector-tiles-boot-0.0.1-SNAPSHOT.jar"]
