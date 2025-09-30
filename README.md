
# Easy School App

A comprehensive school management application designed to streamline administrative tasks, enhance communication, and improve overall efficiency within educational institutions.

## Features

- **User Authentication**: Secure login and registration for students, teachers, and administrators.
- **Dashboard**: Personalized dashboards displaying relevant information and quick access to key features.
- **Student Management**: Add, update, and manage student records, including personal details and academic performance.
- **Teacher Management**: Manage teacher profiles, assignments, and schedules.
- **Class Scheduling**: Create and manage class timetables, including subject allocation and room assignments.
- **Attendance Tracking**: Monitor and record student attendance with automated reports.
- **Gradebook**: Input and track student grades, generate report cards, and analyze academic performance.
- **Communication Tools**: In-app messaging system for communication between students, teachers, and administrators.
- **Notifications**: Push notifications for important announcements, assignments, and events.
- **Event Calendar**: Schedule and manage school events, holidays, and parent-teacher meetings.

## Technologies Used

### Frontend
- JavaScript
- HTML
- CSS
- Thymeleaf (for dynamic web pages)

### Backend
- Java 24
- Spring Boot 3.5.5
- Spring Security (for authentication)
- Spring Data JPA (for database interaction)

### Database
- MySQL (via `mysql-connector-j`)

### Testing
- JUnit
- Spring Boot Test (via `spring-boot-starter-test`)

### Additional Tools
- Spring Boot DevTools (for runtime development tools)
- Lombok (for reducing boilerplate code)
- Spring Boot Actuator (for monitoring application health)

## Installation

### Prerequisites
- Java 24 or higher
- Maven
- MySQL Database

### Steps

1. **Clone the repository:**
   ```bash
   git clone https://github.com/abdulawr/Easy-School-App.git
   ```

2. **Navigate to the project directory:**
   ```bash
   cd Easy-School-App
   ```

3. **Configure the database connection** in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/school_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```

4. **Build and run the application:**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the application** at `http://localhost:8080`

## Dependencies

The application is built using the following dependencies:

### Spring Boot
- `spring-boot-starter-web` for web support
- `spring-boot-starter-thymeleaf` for templating
- `spring-boot-starter-test` for testing
- `spring-boot-starter-validation` for input validation
- `spring-boot-starter-security` for security features
- `spring-boot-starter-data-jpa` for JPA repository support
- `spring-boot-starter-aop` for aspect-oriented programming

### Database
- `mysql-connector-j` for MySQL connectivity

### Development Tools
- `spring-boot-devtools` for automatic restarts and live reload

### Miscellaneous
- `thymeleaf-extras-springsecurity6` to work with Spring Security and Thymeleaf

## Usage

- **Admin Login**: Use the default admin credentials to access the admin dashboard.
- **Student Login**: Students can log in using their unique student ID and password.
- **Teacher Login**: Teachers can access their profiles and manage their classes.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License.

## Repository

GitHub: [https://github.com/abdulawr/Easy-School-App.git](https://github.com/abdulawr/Easy-School-App.git)
