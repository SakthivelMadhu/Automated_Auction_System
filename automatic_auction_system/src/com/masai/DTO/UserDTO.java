package com.masai.DTO;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.masai.DAO.TransactionDAO;
import com.masai.DAO.UserDAO;
import com.masai.Exception.InvalidDataEntryException;

public class UserDTO implements UserDAO {
    private int userId;
    private String username;
    private String password;
    private String email;

    public UserDTO(int userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserDTO(String fullName, String username2, String password2, String email2, String phoneNumber,
			int codePointCount) {
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Object getRole() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFullName(String fullName) {
		// TODO Auto-generated method stub
		
	}

	public String getFullName() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateUser(UserDTO user) throws SQLException, InvalidDataEntryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int userId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDTO getUserById(String email) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUserByUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionDAO> getAllTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int login(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TransactionDAO> getTransactionsInRange(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setbFirstName(String nextLine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getbFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getbLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String resetUsernameByuser(String firstname, String username, Date dob, String mobileNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String resetPasswordByuser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setbLastName(String nextLine) {
		// TODO Auto-generated method stub
		
	}

	public void setBemail(String nextLine) {
		// TODO Auto-generated method stub
		
	}

	public void setBpassword(String nextLine) {
		// TODO Auto-generated method stub
		
	}

	public void setBmobile(String nextLine) {
		// TODO Auto-generated method stub
		
	}

	public void setBdod(Date valueOf) {
		// TODO Auto-generated method stub
		
	}

	public String registerBuyer(UserDTO userReg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUserById(UserDAO user2) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public String toString() {
//		return "UserDTO [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
//				+ "]";
//	}
	
	
}

