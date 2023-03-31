package com.masai.DAO;


import java.util.List;
import com.masai.DTO.ItemDTO;
import com.masai.Exception.AuctionException;
import java.sql.*;
import java.util.ArrayList;


//public interface ItemDAO {
//    
//    List<ItemDTO> getAllItems() throws AuctionException;
//    
//    ItemDTO getItemById(int id) throws AuctionException;
//    
//    ItemDTO addItem(ItemDTO item) throws AuctionException;
//    
//    void updateItem(ItemDTO item) throws AuctionException;
//    
//    void deleteItem(int id) throws AuctionException;
//    
//}


public class ItemDAO {
    
    private Connection connection;
    
    public ItemDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<ItemDTO> getAllItems() throws AuctionException {
        List<ItemDTO> itemList = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM items");
            while (rs.next()) {
                ItemDTO item = new ItemDTO();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setCategory(rs.getString("category"));
                item.setPrice(rs.getDouble("price"));
                item.setStatus(rs.getString("status"));
                item.setSeller(rs.getString("seller"));
                itemList.add(item);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new AuctionException("Failed to get all items: " + e.getMessage());
        }
        return itemList;
    }
    
    public ItemDTO getItemById(int itemId) throws AuctionException {
        ItemDTO item = null;
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM items WHERE id = ?");
            pstmt.setInt(1, itemId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                item = new ItemDTO(1, null, null, null, 1, null, null);
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setCategory(rs.getString("category"));
                item.setPrice(rs.getDouble("price"));
                item.setStatus(rs.getString("status"));
                item.setSeller(rs.getString("seller"));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            throw new AuctionException("Failed to get item by ID: " + e.getMessage());
        }
        return item;
    }
    
    public void addItem(ItemDTO item) throws AuctionException {
        try {
            PreparedStatement pstmt = connection.prepareStatement(
                    "INSERT INTO items(name, description, category, price, status, seller) VALUES (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getDescription());
            pstmt.setString(3, item.getCategory());
            pstmt.setDouble(4, item.getPrice());
            pstmt.setString(5, item.getStatus());
            pstmt.setString(6, item.getSeller());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new AuctionException("Failed to add item: " + e.getMessage());
        }
    }
    
    public void updateItem(ItemDTO item) throws AuctionException {
        try {
            PreparedStatement pstmt = connection.prepareStatement(
                    "UPDATE items SET name=?, description=?, category=?, price=?, status=?, seller=? WHERE id=?");
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getDescription());
            pstmt.setString(3, item.getCategory());
            pstmt.setDouble(4, item.getPrice());
            pstmt.setString(5, item.getStatus());
            pstmt.setString(6, item.getSeller());
            pstmt.setInt(7, item.getId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new AuctionException("Failed to update item: " + e.getMessage());
        }
    }
    
    public void deleteItem(int itemId) throws AuctionException {
        try {
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM items WHERE id=?");
            pstmt.setInt(1, itemId);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new AuctionException("Failed to delete item: " + e.getMessage());
        }
    }

	public List<ItemDTO> getItemsForSale() {
		// TODO Auto-generated method stub
		return null;
	}
}
