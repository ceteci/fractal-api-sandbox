# Fractal API Sandbox demo Spring Boot

Basic Spring Boot app to demonstrate the integration Fractal API Sandbox.
Included bindings to Banking API and Categorisation API.


# Dependencies

This project uses Fractal Sandbox. Sign-Up and create a Sandbox app from https://developer.askfractal.com/ 
and note AppID and APIKey and AppURL.
The project developed using Spring Boot, Feign, Maven, JUnit5, Lombok.
All dependencies are present in the pom file.

# SetUp-Run

The project uses JDK10 and Spring Boot 2.2.0.RELEASE.
Edit /src/main/java/application.properties with AppID and APIKey and AppURL.
mvn spring-boot:run command will start a Tomcat container.


# Coding Tree

This project has two main directories called main and test.
Main directory uses below source directories.
 
 - auth
 - client
 - controller
 - model

Tests has same structure and covers all functionality.
