
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Database.initialize();

        // Temporary test user.
        // Replace this with proper registration later.
        String sql = """
                INSERT OR IGNORE INTO users (username, password_hash)
                VALUES (?, ?)
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, "testuser");
            statement.setString(2, "TEMPORARY_HASH_PLACEHOLDER");

            statement.executeUpdate();

            System.out.println("Test user is ready!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
