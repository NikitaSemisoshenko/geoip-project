# geo_ip_service

This application provides functionality that takes ip as an income parameter and returns different information
about this ip. For example if you send ip "8.8.8.8" as request you will get that response:

{<br>
"canonicalIPv4Representation": "8.8.8.8",<br>
"cityName": "Mountain View",<br>
"countryCode": "US",<br>
"countryName": "United States",<br>
"IPv4": "134744072",<br>
"latitude": "37.405992",<br>
"longitude": "-122.078515",<br>
"regionName": "California"<br>
}

# Project structure

Project based on a Spring Boot. Application consists of 3 layers:

* repository for working with db
* service with business logic
* controller for handling requests and responses

# Developed with

* Spring Boot
* Maven
* Java 17
* MySQL
* Lombok

# How to run this project locally

* clone this project
* go to the resources/application.properties and insert your database url, username and password
* download the file https://cutt.ly/CCrOZ3n
* in resources/init/start.sql insert absolut path to this file instead of ''ABSOLUTE_PATH_TO_FILE_ip2location.csv''.
<br>Example: LOAD DATA LOCAL INFILE 'C:/Users/user/ip2location.csv'
* now run sql scripts in folder resources/init/start.sql
* start the application

# How to test it out

Go to the browser and type http://locahost:8080/geoip/<your-ip>. Instead of <your ip insert ip address. 
For example: http://locahost:8080/geoip/8.8.8.8



