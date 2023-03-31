package com.masai.DAO;


import java.sql.SQLException;
import java.util.List;

import com.masai.DTO.ItemDTO;
import com.masai.Exception.InvalidDataEntryException;

public interface ItemDAO {
    public boolean addItem(ItemDTO itemDTO) throws InvalidDataEntryException;
    public boolean updateItem(ItemDTO itemDTO) throws InvalidDataEntryException;
    public boolean deleteItem(int itemId);
    public List<ItemDTO> getItemsByCategory(String category) throws SQLException;
    public List<ItemDTO> getAvailableItems() throws SQLException;
    public ItemDTO getItemById(int itemId) throws SQLException;
    public List<ItemDTO> getItemsBySellerId(int sellerId) throws SQLException;
    public List<ItemDTO> getItemsByBuyerId(int buyerId) throws SQLException;
	public List<ItemDTO> getAllItems();
}

