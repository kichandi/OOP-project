
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL =
            "jdbc:sqlite:taskmanagementsystem.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initialize() {

        String tasksTable = """
            CREATE TABLE IF NOT EXISTS tasks (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT NOT NULL,
                type TEXT NOT NULL CHECK (
                    type IN ('Academic', 'Fitness', 'Personal', 'Project')
                ),
                priority TEXT NOT NULL CHECK (
                    priority IN ('Low', 'Medium', 'High')
                ),
                deadline TEXT,
                completed INTEGER NOT NULL DEFAULT 0
                    CHECK (completed IN (0, 1)),
                points INTEGER NOT NULL DEFAULT 0
            )
            """;

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {

            statement.execute(tasksTable);

            System.out.println(
                    "Task Management System database initialized!");

        } catch (SQLException e) {
            System.err.println("Database initialization failed!");
            e.printStackTrace();
        }
    }
}
