FROM openjdk:8-jdk-alpine

COPY ./target/aarogyavat-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch aarogyavat-0.0.1-SNAPSHOT.jar'
ENTRYPOINT [ "java","-jar","aarogyavat-0.0.1-SNAPSHOT.jar" ]