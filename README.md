# Maven Web Student Portal

A basic JSP + Servlet web application for practising Maven WAR builds, Eclipse Dynamic Web Project integration, Jenkins and Docker/Tomcat.

## Requirements
- JDK 17
- Maven 3.9+
- Eclipse IDE for Enterprise Java and Web Developers (recommended)
- Docker Desktop
- Jenkins with Java/Maven and Docker access

## Import into Eclipse
1. File -> Import -> Maven -> Existing Maven Projects.
2. Select this project folder and finish.
3. To run locally from Eclipse, configure a Tomcat 10.1 server in the Servers view.
4. Add this project to the Tomcat server and start it.
5. Open `http://localhost:8080/student-portal/` (or the context path shown by Eclipse).

## Maven commands
```bash
mvn clean
mvn compile
mvn package
mvn clean package
```
The WAR is created at `target/student-portal.war`.

## Docker commands
```bash
docker build -t student-portal:1.0 .
docker images
docker run --name student-portal -d -p 8080:8080 student-portal:1.0
docker ps
```
Open `http://localhost:8080/` in your browser.

Stop/remove:
```bash
docker stop student-portal
docker rm student-portal
```

## Jenkins
Create a Pipeline job, connect this Git repository, select `Jenkinsfile` from SCM, and run Build Now.
The agent must have Maven, Java 17 and Docker CLI/daemon access. If your Jenkins agent uses Windows, convert `sh` to `bat`.

## Important compatibility note
This project uses `jakarta.servlet` 6.0 and therefore Tomcat 10.1. Do not deploy it to Tomcat 9, which uses the older `javax.servlet` namespace.

## Practise
- Change the home page heading.
- Add a new form field and display it in the servlet.
- Change the WAR final name in `pom.xml` and update the Dockerfile if you do.
- Intentionally introduce a compilation error and inspect the failed Jenkins build.
