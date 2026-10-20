package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL = "jdbc:sqlite:taskmanagementsystem.db";

    public static Connection connect() {
        try {
            Connection connection = DriverManager.getConnection(URL);

            try (Statement statement = connection.createStatement()) {
                statement.execute("PRAGMA foreign_keys = ON");
            }

            return connection;

        } catch (SQLException e) {
            System.err.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }

    public static void initialize() {
        String usersTable = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT NOT NULL COLLATE NOCASE UNIQUE,
                password_hash TEXT NOT NULL
            )
            """;

        String tasksTable = """
            CREATE TABLE IF NOT EXISTS tasks (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                user_id INTEGER NOT NULL,
                title TEXT NOT NULL,
                type TEXT NOT NULL CHECK (
                    type IN ('Academic', 'Fitness', 'Personal','Project')
                ),
                priority TEXT NOT NULL CHECK (
                    priority IN ('Low', 'Medium', 'High')
                ),
                deadline TEXT,
                completed INTEGER NOT NULL DEFAULT 0
                    CHECK (completed IN (0, 1)),
                FOREIGN KEY (user_id)
                    REFERENCES users(id)
                    ON DELETE CASCADE
            )
            """;
        String academicTable = """
    CREATE TABLE IF NOT EXISTS Academics (
        task_id INTEGER PRIMARY KEY,
        subject TEXT NOT NULL,
        study_hours REAL,

        FOREIGN KEY (task_id)
            REFERENCES tasks(id)
            ON DELETE CASCADE
    )
    """;
        String fitnessTable = """
    CREATE TABLE IF NOT EXISTS Fitness (
        task_id INTEGER PRIMARY KEY,
        activity_type TEXT NOT NULL,
        target_duration TEXT NOT NULL,
        actual_duration TEXT NOT NULL,

        FOREIGN KEY (task_id)
            REFERENCES tasks(id)
            ON DELETE CASCADE
    )
    """;
        String personaltable = """
                CREATE TABLE IF NOT EXISTS Personal (
                    task_id INTEGER PRIMARY KEY,
                    points REAL,
                    FOREIGN KEY (task_id)
                    REFERENCES tasks(id)
                    ON DELETE CASCADE
                )
                """;
        String Projecttable = """
                CREATE TABLE IF NOT EXISTS Projects (
                task_id INTEGER PRIMARY KEY,
                points REAL,
                FOREIGN KEY (task_id)
                REFERENCES tasks(id)
                ON DELETE CASCADE
                )
                """;



        try (Connection connection = connect()) {

            if (connection == null) {
                return;
            }

            try (Statement statement = connection.createStatement()) {
                statement.execute(usersTable);
                statement.execute(tasksTable);
                statement.execute(academicTable);
                statement.execute(fitnessTable);
                statement.execute(personaltable);
                statement.execute(Projecttable);
            }

            System.out.println("TaskmanagementSystem database initialized!");

        } catch (SQLException e) {
            System.err.println("Database initialization failed!");

        }
    }
}
