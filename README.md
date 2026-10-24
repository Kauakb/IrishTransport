# Irish Transport Stops - Spring Boot Web Application

A full-stack enterprise web application built with **Spring Boot** and **MongoDB Atlas**, allowing users to browse, search, and manage Irish public transport stops using real data from the **National Public Transport Access Nodes (NaPTAN)** dataset sourced from [data.gov.ie](https://data.gov.ie).


## Screenshots

| Login Page | Transport Stops List |
|------------|----------------------|
| Custom styled login with Spring Security | Paginated list with search and CRUD |


## Features

-  **User Authentication**: Register and login with Spring Security + BCrypt password encryption
-  **Full CRUD**: Create, Read, Update, Delete transport stops
-  **Search**: Search stops by name in real time
-  **Pagination**: 20 records per page across 17,621 stops
-  **Backend Validation**: Server-side form validation using Jakarta Bean Validation
-  **Custom CSS Styling**: Fully responsive UI with hero image and navbar
-  **MongoDB Atlas**: Cloud-hosted NoSQL database


## Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Java 17, Spring Boot 3.5 |
| Database | MongoDB Atlas (NoSQL) |
| Frontend | Thymeleaf, HTML5, CSS3 |
| Security | Spring Security, BCryptPasswordEncoder |
| Validation | Jakarta Bean Validation |
| Build Tool | Maven |
| Data Import | Python 3, pymongo |


## Project Structure

```
com.ca.transport
├── controller
│   ├── TransportController.java   # CRUD endpoints
│   └── AuthController.java        # Login/Register endpoints
├── model
│   ├── Transport.java             # Transport stop entity
│   └── User.java                  # User entity
├── repository
│   ├── TransportRepository.java   # MongoDB repository
│   └── UserRepository.java        # User repository
├── service
│   ├── TransportService.java      # Business logic
│   └── UserService.java           # User + Spring Security logic
└── security
    └── SecurityConfig.java        # Spring Security configuration
```


##  Dataset

- **Source:** [Transport for Ireland](https://www.transportforireland.ie/transitData/Data/NaPTAN_Stop_Points.csv)
- **Also available on:** [data.gov.ie](https://data.gov.ie)
- **Records:** 17,621 public transport stops across Ireland
- **Key fields:** ATCO Code, Stop Name, Street, Locality, Stop Type, Status, Latitude, Longitude


## Setup & Installation

### Prerequisites
- Java 17+
- Maven
- MongoDB Atlas account (free tier)
- Python 3 + pymongo (for data import)

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/transport.git
cd transport
```

### 2. Configure MongoDB Atlas

Set your connection string as the `MONGODB_URI` environment variable (never commit it to the repo):

```powershell
# PowerShell
$env:MONGODB_URI = "mongodb+srv://USERNAME:PASSWORD@cluster0.xxxxx.mongodb.net/transortdb?retryWrites=true&w=majority"
```

```bash
# bash
export MONGODB_URI="mongodb+srv://USERNAME:PASSWORD@cluster0.xxxxx.mongodb.net/transortdb?retryWrites=true&w=majority"
```

If `MONGODB_URI` is not set, the app falls back to a local MongoDB at `mongodb://localhost:27017/transortdb`. The port defaults to `8080` (override with `PORT`).

### 3. Import the Dataset

```bash
pip install pymongo
python import_data.py
```

### 4. Run the Application

```bash
./mvnw spring-boot:run
```

Run it locally on your machine


## Default Credentials

Register a new account at `/register` or use your own credentials.

> **Database connection:** username: `root`, password: `root` (as per CA spec)


## Pages & Routes

| Route | Description | Access |
|-------|-------------|--------|
| `/login` | Login page | Public |
| `/register` | Registration page | Public |
| `/transports` | List all stops (paginated) | Authenticated |
| `/transports/new` | Add new stop | Authenticated |
| `/transports/edit/{id}` | Edit stop | Authenticated |
| `/transports/delete/{id}` | Delete stop | Authenticated |


## Validation Rules

| Field | Rule |
|-------|------|
| ATCO Code | Required |
| Stop Name | Required |
| Stop Type | Required |
| Username | Required, unique |
| Password | Required, min 6 characters |


## Data Import Script

The dataset was imported using a Python ETL script (`import_data.py`) that:
1. Reads the NaPTAN CSV file
2. Maps columns to MongoDB document fields
3. Bulk inserts 17,621 documents into MongoDB Atlas

```bash
python import_data.py
# Output: Imported 17621 documents!
```


## Author

- **Student:** Kaua Barbosa - 2023257
- **Module:** Commercial Solutions Design
- **Institution:** CCT College Dublin
- **Year:** 2026


## References

- Spring Boot Documentation: https://spring.io/projects/spring-boot
- MongoDB Atlas: https://www.mongodb.com/atlas
- NaPTAN Dataset: https://data.gov.ie
- Transport for Ireland: https://www.transportforireland.ie
- Spring Security: https://spring.io/projects/spring-security
