# Intelligent Grievance Scrutiny and Decision Support System

This project is developed as part of the TY B.Sc. Computer Science curriculum 2025-26.

## Members info

1. JayG003
2. SomaG86
3. Shreyaaaah!

## Project Overview

The Intelligent Grievance Scrutiny and Decision Support System aims to improve traditional grievance management by introducing automated scrutiny, prioritization, and decision support mechanisms. Unlike basic grievance systems that only record complaints, this system analyzes grievances to assist authorities in handling them more efficiently.

## Technologies Used

- Core Java
- Java Swing/AWT
- PostgreSQL
- JDBC

## User Roles

- User
- Grievance Manager
- Admin

## Key Features

- Category-based grievance submission
- Automated grievance scrutiny
- Duplicate grievance detection
- Priority assignment
- Decision support for grievance officers
- Grievance status tracking

## Project Status

In development<br>
Login page addes succesfully<br>
Registration page addes succesfully<br>
Reset Password page addes succesfully<br>
Dashboard page addes succesfully<br>
New grivance submission page addes succesfully<br>
Grievance form page addes succesfully<br>
My grievances page addes succesfully<br>
Notification page addes succesfully<br>

## Running the project (only for no IDE run)

- clone the repo in local device
- use the schema in databse folder to create databse in your local device
- use terminal and get inside the filer "Intelligent-Grievance-Scrutiny-System"
- use "javac -d bin src\*.java src\database\*.java src\frontend\*.java"  this command
- after successful compilation use
- "java -cp "bin;add postgres JDBC driver path here" src.Main"

## Creating database

- use schema in the database folder
- open postgresql
- create database named "grievance_db"
- create tables named users and grievances
- insert values in thod tables
Thats it.