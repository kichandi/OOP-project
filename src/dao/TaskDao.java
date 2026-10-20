
package dao;

import database.Database;
import model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskDao {

    public int insertTask(Task task, int userId)
            throws SQLException {

        String sql = """
                INSERT INTO tasks
                (user_id, title, type, priority, deadline, completed)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(
                             sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, userId);
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getType());
            statement.setString(4, task.getPriority());
            statement.setString(5, task.getDeadline());
            statement.setInt(6, task.getStatus() ? 1 : 0);

            statement.executeUpdate();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    int taskId = keys.getInt(1);
                    task.setId(taskId);
                    return taskId;
                }
            }

            throw new SQLException("Could not retrieve task ID.");
        }
    }
}

