# Hospital Management System

A Java-based Hospital Management System with a graphical user interface built using Swing and MySQL database integration.

## Features

- **Patient Management**
  - Add new patients
  - View all patient information
  - Update patient details
  - Process patient discharge

- **Room Management**
  - View room availability
  - Assign rooms to patients
  - Track room occupancy

- **Employee Management**
  - View all employee information
  - Department-wise employee listing

- **Department Management**
  - View department details
  - Department-wise organization

- **Reception Dashboard**
  - Centralized access to all features
  - Quick navigation interface

## Technology Stack

- Java
- Swing (GUI)
- MySQL
- JDBC

## Prerequisites

- Java JDK 24 or higher
- MySQL Server
- MySQL Connector/J 9.2.0
- IDE (preferably IntelliJ IDEA)

## Database Setup

1. Install MySQL Server
2. Create a database named `sepm_management_system`
3. Configure the database connection in `conn.java` with your credentials

## Project Structure

```
Hospital Management System/
├── src/
│   ├── hospital/management/system/
│   │   ├── All_Patient_Info.java
│   │   ├── conn.java
│   │   ├── Department.java
│   │   ├── Employee_info.java
│   │   ├── Login.java
│   │   ├── New_Patient.java
│   │   ├── patient_discharge.java
│   │   ├── Reception.java
│   │   ├── Room.java
│   │   └── update_patients_details.java
│   └── icon/
│       ├── dr.png
│       ├── patient.jpg
│       ├── reception.jpg
│       ├── roomm.png
│       ├── SRM.png
│       └── updated.jpg
```

## Installation

1. Clone the repository
2. Open the project in your IDE
3. Install the required MySQL Connector/J library
4. Configure your database connection in `conn.java`
5. Compile and run the project

## Usage

1. Start the application by running `Login.java`
2. Log in with your credentials
3. Use the Reception dashboard to access various features:
   - Add new patients
   - Check room availability
   - View department information
   - Access employee details
   - Update patient information
   - Process patient discharge

## Contributing

Feel free to fork this project and submit pull requests with improvements.

## License

This project is available under the MIT License.

## Authors

- Aditya K
