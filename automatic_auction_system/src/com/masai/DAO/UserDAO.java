package com.masai.DAO;


import java.sql.SQLException;
import java.util.List;

import com.masai.DTO.TransactionDTO;
import com.masai.DTO.UserDTO;
import com.masai.Exception.DuplicateUsernameException;
import com.masai.Exception.InvalidDataEntryException;

public interface UserDAO {
    public static void addUser(UserDTO user) throws SQLException, DuplicateUsernameException {
		// TODO Auto-generated method stub
		
	}
    public void updateUser(UserDTO user) throws SQLException, InvalidDataEntryException;
    public void deleteUser(int userId) throws SQLException;
    public UserDTO getUserById(int userId) throws SQLException;
    public UserDTO getUserByUsername(String username) throws SQLException;
    public List<UserDTO> getAllUsers() throws SQLException;
	public UserDTO authenticate(String username, String password);
	public List<TransactionDTO> getAllTransactions();
	public int login(String username, String password);
	

}
