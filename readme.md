
# GitubProxy App

GitubProxy App allows user to connect to GitHub via API and read information about all repositories, branches and some other data about repositories.

## Run Locally

Clone the project

```bash
  git clone https://github.com/jan-wisniewski/githubproxy
```

Go to the project directory and run app by command

```bash
mvn spring-boot:run
```

After that you be able to using app at localhost:8080

## EndPoints

To read information about user repositories open postman, and type in url section

http://localhost:8080/api/repositories/<username>

Also you have to add proper header: 

```bash
Accept: application/json
```

## Response Type

Code 404 - username cannot be found via Gitub API<br>

Code 200 - JSON Object with necessary information

## Stack

Java: 17<br>
SpringBoot: 2.7.6<br>
Dependencies: Spring Fox, Lombok, Spring Boot Devtools
