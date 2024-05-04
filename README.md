# Bookstore Management System

This is a bookstore management system built in Java.

## Features

- Add, edit, delete books
- Search for books
- Import books from a CSV file

## Setup

1. Clone the repository
2. Open the project in your preferred Java IDE
3. Run the `TableBook.java` file to start the application
### Data base 
<!--  run docker -->
1. directory `docker`
```bash
cd resources/Docker
```
2. run docker-compose
```bash
docker compose -f mysql.yml -p mysql up -d
```

## Usage
1. directory `bookstore`
```bash
cd bookstore
```
2. run the application
```bash
./gradlew run  # for linux
gradlew.bat run # for windows

```
