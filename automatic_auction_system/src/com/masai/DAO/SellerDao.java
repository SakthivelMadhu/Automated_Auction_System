package com.masai.DAO;



import java.sql.Date;
import java.util.List;

import com.masai.Exception.SellerException;
import com.masai.Exception.ItemException;
import com.masai.DTO.Seller;
import com.masai.DTO.Selling_Item;
import com.masai.DTO.Sold;

public interface SellerDao {
	
	public String registerSeller(Seller seller)throws SellerException;
	
	public Seller loginBySeller(String username, String password) throws SellerException;
	
	public String resetPasswordBySeller (String username, String password) throws SellerException;
	
	public String ChangePasswordBySeller (String username, String password) throws SellerException;
	
	public String resetUsernameBySeller (String sFirstName, String username, Date dob, String mobile) throws SellerException;
	
	public String addListOfItems(List<Selling_Item> list) throws ItemException;
	
	public String updateItemPrice(int sid, String itemName, int updatePrice) throws ItemException;
	
	public String updateItemQuantity(int sid, String itemName, int itemQuantity) throws ItemException;
	
	public String updateItemPriceAndQuantity(int sid, String itemName, int updatePrice, int itemQuantity) throws ItemException;
	
	public String addItemInTheList(Selling_Item item) throws ItemException;
	
	public String removeItemFromTheList(int sid, String itemName) throws ItemException;
	
	public List<Sold> soldItemList(int sid) throws ItemException;
	
	public List<Selling_Item> sellingItemList(int sid) throws ItemException;
	
}
