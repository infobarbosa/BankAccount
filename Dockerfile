# Pull base image.
FROM ubuntu:latest

RUN \
# Update
apt-get update -y && \
# Install Java
apt-get install default-jre -y

ADD ./target/bankaccount-1.0-SNAPSHOT.jar account.jar
EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "account.jar" ]