# lms-spring-deployed

## Overview
The Loan Management System is a Spring application that provides endpoints for managing loans, payments, and checking balances. This system allows users to track loans, make payments, and get information on the total amount paid and the number of remaining EMIs.

## Docker Image
You can find the Docker image for this application on Docker Hub:
- [Docker Image](https://hub.docker.com/r/yash1969/loan-management-system)

## Documentation
The API documentation for this application is available at:
- [Swagger UI Documentation](https://loan-management-system.onrender.com/swagger-ui/index.html#/)

## API Endpoints


### LOAN
The LOAN command allows you to create a new loan.
**Endpoint:** /LOAN
**Method:** POST
**Request Body:**
json : 
{
  "bankName": "IDIDI",
  "borrowerName": "Dale",
  "principal": 10000,
  "years": "5",
  "roi": "4"
}


### PAYMENT
The PAYMENT command allows you to make a payment on an existing loan.
**Endpoint:** /payment
**Method:** POST
**Request Body:**
json :
{
  "bankName": "MBI",
  "borrowerName": "Dale",
  "amount": "1000",
  "emi": "5"
}


### BALANCE
The BALANCE command allows you to check the balance of a loan, including the total amount paid and the number of remaining EMIs.
**Endpoint:** /BALANCE
**Method:** GET

Query Parameters:
bankName (String): The bank's name.
borrowerName (String): The borrower's name.
emiNumber (Integer): The EMI number.

Response:
{
  "bankName": "MBI",
  "borrowerName": "Harry",
  "amountPaid": 1250,
  "numberOfEMIsLeft": 43
}

### Installation and Usage:

**Pull the Docker image from Docker Hub:**
docker pull yash1969/loan-management-system

**Run the Docker container:**
docker run -p 8081:8081 yash1969/loan-management-system
Access the API documentation in your web browser at http://localhost:8081/swagger-ui/index.html#/.
Use the provided API endpoints to manage loans and payments.
**username: testuser
password: granted**

**Development:**
If you want to run the application locally for development, follow these steps:

**Clone the repository:**

git clone <repository-url>
cd loan-management-system

**Build and run the application:**

gradlew.bat bootRun

Access the API documentation at http://localhost:8080/swagger-ui/index.html#/.
