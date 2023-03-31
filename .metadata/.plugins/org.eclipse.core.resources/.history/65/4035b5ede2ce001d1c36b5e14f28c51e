package com.masai.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import exception.UserException;
import model.User;
import util.DBUtil;

public class UserDaoImpl implements UserDao {
    
    private Connection connection;

    public UserDaoImpl() throws UserException {
        connection = DBUtil.getConnection();
    }

    @Override
    public void addUser(User user) throws UserException {
        try {
            String query = "INSERT INTO users (username, first_name, last_name, address, mobile_no, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getMobileNo());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new UserException("Error adding user: " + e.getMessage());
        }
    }

    @Override
    public void updateUser(User user) throws UserException {
        try {
            String query = "UPDATE users SET first_name=?, last_name=?, address=?, mobile_no=? WHERE user_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getMobileNo());
            preparedStatement.setInt(5, user.getUserId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new UserException("Error updating user: " + e.getMessage());
        }
    }

    @Override
    public User getUserById(int userId) throws UserException {
        try {
            String query = "SELECT * FROM users WHERE user_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setAddress(rs.getString("address"));
                user.setMobileNo(rs.getString("mobile_no"));
                user.setPassword(rs.getString("password"));
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new UserException("Error getting user by ID: " + e.getMessage());
        }
    }

    @Override
    public User getUserByUsername(String username) throws UserException {
        try {
            String query = "SELECT * FROM users WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setAddress(rs.getString("address"));
                user.setMobileNo(rs.getString("mobile_no"));
                user.setPassword(rs.getString("password"));
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new UserException("Error getting user by username: " + e.getMessage());
        }
    }

    public List<User> getAllUsers() throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM user WHERE is_deleted = 0");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String address = rs.getString("address");
                String mobileNo = rs.getString("mobile_no");
                String password = rs.getString("password");
                boolean isAdmin = rs.getBoolean("is_admin");
                User user = new User(id, username, firstName, lastName, address, mobileNo, password, isAdmin);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new Exception("Error getting all users: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(conn, stmt, rs);
        }

        return userList;
    }

    public void deleteUser(int userId) throws Exception {
        

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement("UPDATE user SET is_deleted = 1 WHERE id = ?");
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error deleting user: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
        }
    }

    public void changePassword(int userId, String newPassword) throws Exception {
        

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement("UPDATE user SET password = ? WHERE id = ?");
            stmt.setString(1, newPassword);
            stmt.setInt(2, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error changing password: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
        }
    }
}

