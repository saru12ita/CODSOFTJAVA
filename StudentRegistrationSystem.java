//Task5
//programming in java for creation of student registration
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentRegistrationSystem {
    private static Connection connection;

    public static void main(String[] args) {
        try {
            // Connect to the SQLite database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/getty","root","");

            // Create tables if they don't exist
            createTables();

            while (true) {
                displayMenu();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables() throws SQLException {
        String createCourseTable = "CREATE TABLE IF NOT EXISTS courses (id INTEGER PRIMARY KEY, " +
                "code TEXT, title TEXT, description TEXT, capacity INTEGER, schedule TEXT)";
        String createStudentTable = "CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, " +
                "name TEXT, student_id TEXT, course_id INTEGER)";

        try (PreparedStatement stmt = connection.prepareStatement(createCourseTable)) {
            stmt.executeUpdate();
        }

        try (PreparedStatement stmt = connection.prepareStatement(createStudentTable)) {
            stmt.executeUpdate();
        }
    }

    private static void displayMenu() {
        System.out.println("Student Registration System Menu:");
        System.out.println("1. List Courses");
        System.out.println("2. Register for a Course");
        System.out.println("3. Remove Course Registration");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                listCourses();
                break;
            case 2:
                registerCourse();
                break;
            case 3:
                removeRegistration();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void listCourses() {
        // Implement the course listing code here
    }

    private static void registerCourse() {
        // Implement the course registration code here
    }

    private static void removeRegistration() {
        // Implement the course removal code here
    }
}
