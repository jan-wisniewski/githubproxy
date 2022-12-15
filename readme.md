
# Project Title

GitubProxy App allows user to connect to GitHub via API and read information about all repositories, branches and some other data about repositories.

## Run Locally

Clone the project

```bash
  git clone https://github.com/jan-wisniewski/githubproxy
```

Go to the project directory and build docker container via .Dockerfile

```bash
  cd my-project
```
## EndPoints

To read information about user repositories open swagger

```bash
/swagger-ui/index.html
```
In github-controller section click "Try it out", and type username in required parameter. Click execute

## Response Type

Code 404 - username cannot be found via Gitub API
Code 200 - JSON Object with necessary information
