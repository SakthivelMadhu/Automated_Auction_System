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
	public List<ItemDAO> getItemsBySoldStatus(int soldStatus);
	public List<ItemDAO> getItemsByKeyword(String keyword);
	public List<ItemDAO> getItemsByCategorySoldAndKeyword(String category, boolean sold, String keyword);
	public void setCid(int category);
	public void setSellingPrice(int nextInt);
	public void setItem_detail(String nextLine);
	public void setItem_quantity(int nextInt);
	public void setAuctionAddress(String nextLine);
	public void setDays(int nextInt);
}

