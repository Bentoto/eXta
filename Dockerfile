FROM gradle:6.0.1-jdk8

COPY . /usr/src/exta

WORKDIR /usr/src/exta

CMD ["gradle", "run"]