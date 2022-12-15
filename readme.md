
# GitubProxy App

GitubProxy App allows user to connect to GitHub via API and read information about all repositories, branches and some other data about repositories.

## Run Locally

Clone the project

```bash
  git clone https://github.com/jan-wisniewski/githubproxy
```

Go to the project directory and build executable jar in target folder

```bash
mvn clean install
```

After that go to main folder in app and create docker image via .Dockerfile file

```bash
docker build -f Dockerfile -t githubproxy
```

And run container

```bash
docker run -p 8080:8080 -t githubproxy
```

After that you be able to using app at localhost:8080

## EndPoints

To read information about user repositories open swagger

```bash
/swagger-ui/index.html
```
In github-controller section click "Try it out", and type username in required parameter. Click execute

## Response Type

Code 404 - username cannot be found via Gitub API
Code 200 - JSON Object with necessary information

## Stack

Java: 17<br>
SpringBoot: 2.7.6<br>
Dependencies: Spring Fox, Lombok, Spring Boot Devtools
