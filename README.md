beCyclist
=========

Web-based application for professional and amateur bike racers as well as organizers of such events. It aims to provide easy way of creating races and subscribing for them.

## Prerequisites

This application requires *Java* in version 8 in order to run. To compile it, [*Java Development Kit*](https://www.oracle.com/java/technologies/javase-jdk8-downloads.htm) version 1.8 or above is necessary.
User interface was created using [*Angular*](https://angular.io/) in version 9 and require Angular CLI if you want to compile its source code. This tool can be downloaded via [*npm*](https://npmjs.org) package manager:
    
    > npm install --global @angular/cli

## Development server

To run Spring Boot application in the development mode, you can simply compile it directly from you IDE using default settings for Spring Boot (just make sure that JDK 1.8 is selected as SDK) or using [*Maven*](https://maven.apache.org/) command:
    
    > mvn spring-boot:run
    
If everything goes right, server will be working and listening on `localhost:8080`.

User interface requires another server to run on. Angular application can be build using tools provided by your IDE or Angular CLI command:

    > ng serve --open

This command will build, run and automatically open your site under `localhost:4200`.

# API

RESTful API was build using Swagger tool. Currently, following endpoints are implemented:

   - `GET /events` - retrieves all event present in the database; filtering can be achieved using query parameters
   - `POST /events` - add to the database event provided in the request body
  
Broad API documentation created with Swagger is accessible on `/swagger-ui.html` on the development server.

## Built with:
   - Spring Boot `2.2.6`
   - Angular `9.1.0`
   - Swagger CodeGen `3.0.19`
   - SQLite