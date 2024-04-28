## Prerequisites:
* Java 17
* Maven 3.8.3

## How to run it locally in Docker:
* Build application using command: `mvn clean install`
* Build docker image: `docker build -t platform-engineer-intern-assessment-1.0 .`
* To run application in docker: `docker run -it platform-engineer-intern-assessment-1.0`
* If you want to save output.txt locally use: `docker run -v ${PWD}/output.txt:/app/output.txt platform-engineer-intern-assessment-1.0`
