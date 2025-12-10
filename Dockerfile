FROM maven:3.9-eclipse-temurin-21

LABEL maintainer='ruyatiras' \
      project="E-Junkie_Team2" \
      purpose="Running Selenium + TestNG + Cucumber + Allure tests inside Docker"

USER root

RUN apt-get update && \
    \
    apt-get install -y wget gnupg unzip && \
    \
    wget -qO- https://dl.google.com/linux/linux_signing_key.pub \
      | gpg --dearmor -o /usr/share/keyrings/google-linux-signing-keyring.gpg && \
    \
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-linux-signing-keyring.gpg] http://dl.google.com/linux/chrome/deb/ stable main" \
      > /etc/apt/sources.list.d/google-chrome.list && \
    \
    apt-get update && \
    \
    apt-get install -y google-chrome-stable && \
    \
    rm -rf /var/lib/apt/lists/*

WORKDIR /usr/src/app

COPY pom.xml .

RUN mvn -B -q dependency:resolve dependency:resolve-plugins

COPY . .

ENV MAVEN_OPTS="-Dfile.encoding=UTF-8"

CMD ["mvn", "clean", "test"]

