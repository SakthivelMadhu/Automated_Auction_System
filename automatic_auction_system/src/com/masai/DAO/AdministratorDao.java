package com.masai.DAO;



import java.util.List;

import com.masai.Exception.AdministratorException;
import com.masai.Exception.BuyerException;
import com.masai.Exception.DisputeException;
import com.masai.Exception.ItemException;
import com.masai.Exception.SellerException;
import com.masai.DTO.Administrator;
import com.masai.DTO.Buyer;
import com.masai.DTO.DisputeBuyerToSeller;
import com.masai.DTO.DisputeBuyerToSellerWithTeamAndCategoryNameDTO;
import com.masai.DTO.DisputeSellerToApp;
import com.masai.DTO.DisputeSellerToAppWithTeamNameDto;
import com.masai.DTO.Seller;
import com.masai.DTO.Selling_Item;
import com.masai.DTO.Sold;

public interface AdministratorDao {
	
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
