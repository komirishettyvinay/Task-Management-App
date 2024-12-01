package services;

import dao.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaskService {
    public boolean createTask(String title, String description, int assignedTo) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO tasks (title, description, assigned_to) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setInt(3, assignedTo);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet viewAssignedTasks(int teamLeaderId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM tasks WHERE assigned_to IN (SELECT id FROM users WHERE role = 'Team Member')";
            PreparedStatement stmt = conn.prepareStatement(query);
            return stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateProfile(int userId, String newUsername, String newPassword) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE users SET username = ?, password = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, newUsername);
            stmt.setString(2, newPassword);
            stmt.setInt(3, userId);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

public boolean updateTaskStatus(int taskId, String newStatus) {
    try (Connection conn = DatabaseConnection.getConnection()) {
        String query = "UPDATE tasks SET status = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, newStatus);
        stmt.setInt(2, taskId);
        return stmt.executeUpdate() > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

public boolean deleteTask(int taskId) {
    try (Connection conn = DatabaseConnection.getConnection()) {
        String query = "DELETE FROM tasks WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, taskId);
        return stmt.executeUpdate() > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
}