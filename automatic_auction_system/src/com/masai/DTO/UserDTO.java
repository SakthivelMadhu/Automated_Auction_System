package com.masai.DTO;

public class UserDTO {
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
}

