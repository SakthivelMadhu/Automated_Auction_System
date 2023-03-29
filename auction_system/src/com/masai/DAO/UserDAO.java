package com.masai.DAO;

import java.util.List;
import com.masai.DTO.UserDTO;
import com.masai.Exception.AuctionException;

//public interface UserDAO {
//    
//    List<UserDTO> getAllUsers() throws AuctionException;
//    
//    UserDTO getUserById(int id) throws AuctionException;
//    
//    UserDTO addUser(UserDTO user) throws AuctionException;
//    
//    void updateUser(UserDTO user) throws AuctionException;
//    
//    void deleteUser(int id) throws AuctionException;
//    
//}

import java.util.ArrayList;

public class UserDAO {
    
    private List<UserDTO> users;
    
    public UserDAO() {
        this.users = new ArrayList<UserDTO>();
    }
    
    public List<UserDTO> getAllUsers() throws AuctionException {
        if (users.isEmpty()) {
            throw new AuctionException("No users found");
        }
        return users;
    }
    
    public UserDTO getUserById(int id) throws AuctionException {
        for (UserDTO user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new AuctionException("User with id " + id + " not found");
    }
    
    public void addUser(UserDTO user) throws AuctionException {
        for (UserDTO existingUser : users) {
            if (existingUser.getId() == user.getId()) {
                throw new AuctionException("User with id " + user.getId() + " already exists");
            }
        }
        users.add(user);
    }
    
    public void updateUser(UserDTO user) throws AuctionException {
        boolean found = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new AuctionException("User with id " + user.getId() + " not found");
        }
    }
    
    public void deleteUser(int id) throws AuctionException {
        boolean removed = users.removeIf(user -> user.getId() == id);
        if (!removed) {
            throw new AuctionException("User with id " + id + " not found");
        }
    }

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
