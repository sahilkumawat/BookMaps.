## Install Docker

```bash
brew install docker
brew install docker-compose
```

## Build code

Use Java 17

```bash
mvn clean install
mvn install -DskipTests
```

## IntelliJ Idea
Open the Project file in IJ


## Start Postgres and ElasticSearch
```bash
docker-compose -f src/main/docker/start_pg_es.yml up -d
```

## Start service
```bash
mvn spring-boot:run
```

## Access Postgres Database in browser
[Postgres Adminer](http://localhost:9090/)

## Use ElasticVue for ElasticSearch Client
[Elasticvue](https://elasticvue.com)

## Accessing Kibana in browser
[ElasticSearch Kibana](http://localhost:5601/)


