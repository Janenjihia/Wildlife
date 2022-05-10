README

# Wildlife Tracker

#### By **jane njihia**

## Description
A spark application that allows Rangers to track wildlife sightings in an area aimed at environmental impact study.

## Setup/Installation Requirements

* PostgreSQL
* Java 
* Gradle 
* Git
* knowledge of Java 
* knowledge of Spark framework 
* 
Installation
Postgress
* Run sudo apt-get install postgresql postgresql-contrib libpq-dev in the terminal to install PostgreSQL in your device.
  Enter y when prompted Do you want to continue? [Y/n] and wait for the installation to complete.
  Create your own credentials with superuser capabilities with the same name as our login name by running sudo -u postgres createuser --superuser $USER
  Next, we’ll have to create a database with the same name as our login name by running sudo -u postgres createdb $USER
  Finally run psql in the terminal to connect to the server
DATABASE
* After running the psql command to connect to the server, proceed to create the database wildlife-tracker by executing the following command: create database wildlife_tracker;
  Follow it up with this following command to connect to the newly created database\c wildlife_tracker;
  Once connected, create 3 tables for each object stated above. Below are the commands to be executed:
  CREATE TABLE rangers(id serial PRIMARY KEY, name varchar);
  CREATE TABLE animals(id serial PRIMARY KEY, name varchar, health varchar, age varchar, type varchar);
  CREATE TABLE sightings(id serial PRIMARY KEY, animalname varchar, location varchar, timestamp timestamp, rangerid int);
  CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
  The last command creates the test database that shall be used to run your tests on. insert \q to exit psql server.
JAVA
* Git clone the project Open the project using the IDE you have installed
  Build and Run the project.

## Known Bugs
Project open to further development

## Technologies Used
<ul>
<li>HTML + Handlebars</li>
<li>Css</li>
<li>Java</li>
<li>Maven</li>
<li>Spark</li>
<li>Junit for testing</li>
<li>PostgreSQL for data storage</li>
</ul>

## Support and contact details
Incase of further inquiries you can reach out

Mobile Number: 0712345678

Email: jane.njihia@student.moringaschool.com

### License
MIT license Copyright (c) 2022 janenjihia


