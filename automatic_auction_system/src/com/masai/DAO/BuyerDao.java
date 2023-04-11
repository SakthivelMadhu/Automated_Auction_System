package com.masai.DAO;


import java.sql.Date;
import java.util.Map;

import javax.xml.catalog.CatalogException;

import com.masai.Exception.BuyerException;
import com.masai.Exception.ItemException;
import com.masai.DTO.Buyer;
import com.masai.DTO.Buyer_Item;
import com.masai.DTO.Selling_Item;

public interface BuyerDao {
	
	public String registerBuyer(Buyer buyer) throws BuyerException;
	
	public Buyer loginBuyer(String username, String password) throws BuyerException;
	
	public String changePasswordByBuyer(String username, String updatePassword) throws BuyerException;
	
	public String resetPasswordByBuyer(String username, String password) throws BuyerException;
	
	public String resetUsernameByBuyer(String firstName, String username, Date dob, String mobile) throws BuyerException;
	
	public Map<Integer, Selling_Item> SearchItemByName (String itemName) throws ItemException;
	
	public Map<Integer, Selling_Item> SearchItemByCategory (String categoryName) throws ItemException;
	
	public Map<Integer, Selling_Item> viewAllItem() throws ItemException;
	
	public Map<Integer, Buyer_Item> listOfBuyerAndItemCategoryWise() throws BuyerException, ItemException;
	
	public Selling_Item selectItemWithBuyerList(Map<Integer, Buyer_Item> listBuyerAndItem, int index) throws ItemException;
	
	public String selectItemToBuy(Selling_Item item) throws ItemException;
	
}
