# Pull base image.
FROM ubuntu:latest

RUN \
# Update
apt-get update -y && \
# Install Java
apt-get install default-jre -y

ADD ./target/account-1.0-SNAPSHOT.jar account.jar

CMD java -jar account.jar
