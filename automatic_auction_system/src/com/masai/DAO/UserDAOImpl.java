package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.DTO.UserDTO;
import com.masai.Exception.DuplicateUsernameException;
import com.masai.Exception.InvalidDataEntryException;

public abstract class UserDAOImpl implements UserDAO {
    private Connection conn;

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    
    
    public void addUser(UserDTO user) throws SQLException, DuplicateUsernameException {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)");
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
//            pstmt.setString(4, user.getRole().toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) { // Unique constraint violation
                throw new DuplicateUsernameException("Username '" + user.getUsername() + "' already exists.");
            } else {
                throw e;
            }
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }

    @Override
    public void updateUser(UserDTO user) throws SQLException, InvalidDataEntryException {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("UPDATE users SET username = ?, password = ?, email = ? WHERE id = ?");
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
//            pstmt.setString(4, user.getRole().toString());
            pstmt.setInt(5, user.getUserId());
            int updatedRows = pstmt.executeUpdate();
            if (updatedRows == 0) {
                throw new InvalidDataEntryException("User with id " + user.getUserId() + " does not exist.");
            }
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("DELETE FROM users WHERE id = ?");
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }

    public UserDTO getUserById(int userId) throws SQLException {
        String query = "SELECT * FROM users WHERE user_id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return createUserDTO(rs);
        }
        return null;
    }

    @Override
    public UserDTO getUserByUsername(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return createUserDTO(rs);
        }
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() throws SQLException {
        String query = "SELECT * FROM users WHERE is_deleted = 0";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<UserDTO> users = new ArrayList<>();
        while (rs.next()) {
            users.add(createUserDTO(rs));
        }
        return users;
    }

    private UserDTO createUserDTO(ResultSet rs) throws SQLException {
        int userId = rs.getInt("user_id");
        String username = rs.getString("username");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        rs.getString("address");
        rs.getString("mobile_no");
        rs.getString("password");
        return new UserDTO(userId, username, firstName, lastName);
    }
}
