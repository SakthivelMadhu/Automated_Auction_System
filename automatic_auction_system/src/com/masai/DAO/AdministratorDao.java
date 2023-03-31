package com.masai.DAO;

import java.util.List;

import com.masai.Exception.AdministratorException;
import com.masai.Exception.BuyerException;
import com.masai.Exception.DisputeException;
import com.masai.Exception.ItemException;
import com.masai.Exception.SellerException;
import com.masai.UI.Administrator;
import com.masai.UI.Buyer;
import com.masai.UI.DisputeBuyerToSeller;
import com.masai.UI.DisputeBuyerToSellerWithTeamAndCategoryNameDTO;
import com.masai.UI.DisputeSellerToApp;
import com.masai.UI.DisputeSellerToAppWithTeamNameDto;
import com.masai.UI.Seller;
import com.masai.UI.Selling_Item;
import com.masai.UI.Sold;


public class AdministratorDao {
	
	public Administrator loginAdministrator(String username, String password) throws AdministratorException;
	
	public String changePasswordAdmin(String username, String password) throws AdministratorException;
	
	public List<Buyer> listOfBuyers() throws BuyerException;
	
	public List<Seller> listOfSeller() throws SellerException;
	
	public List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> disputeListBuyerToSeller() throws DisputeException;
	
	public List<DisputeSellerToAppWithTeamNameDto> disputeListSellerToApp() throws DisputeException;
	
	public List<Sold> SoldItemListDatewise() throws ItemException;
	
	public List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> solvedDisputeListBuyerToSeller() throws DisputeException;
	
	public List<DisputeSellerToAppWithTeamNameDto> solvedDisputeListSellerToApp() throws DisputeException;
	
}
