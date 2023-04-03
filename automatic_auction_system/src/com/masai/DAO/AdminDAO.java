package com.masai.DAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.masai.Exception.DuplicateUsernameException;

public interface AdminDAO {

    // Create
    boolean createAdmin(AdminDAO admin);

    // Read
    AdminDAO getAdminById(int id);
    AdminDAO getAdminByEmail(String email);
    List<AdminDAO> getAllAdmins();

    // Update
    boolean updateAdmin(AdminDAO admin);

    // Delete
    boolean deleteAdmin(AdminDAO admin);

	boolean login(String email, String password) throws SQLException;

	void register(String email, String password, String firstName, String lastName) throws SQLException, DuplicateUsernameException;

	List<TransactionDAO> viewTransactionsByDateRange(Date startDate, Date endDate);

	List<ItemDAO> searchItems(String category, boolean sold, String keyword);

	void logout();

	TransactionDAO viewTransactionById(int transactionId);

	List<TransactionDAO> viewTransactions();

	AdminDAO loginAdministrator(String username, String password);

	String getaFirstName();

	Object getaLastName();

	List<UserDAO> listOfBuyers();

	List<DisputeDAO> disputeListSellerToApp();

	List<DisputeDAO> disputeListBuyerToSeller();

	Object getAemail();

	String changePasswordAdmin(Object aemail, String password);

	List<DisputeDAO> solvedDisputeListSellerToApp();

	List<DisputeDAO> solvedDisputeListBuyerToSeller();

	List<DisputeDAO> SoldItemListDatewise();
	
	AdminDAO obj = new adminImpl(null, null, null, null, null) {
		
		@Override
		public List<DisputeDAO> solvedDisputeListSellerToApp() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<DisputeDAO> solvedDisputeListBuyerToSeller() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public AdminDAO loginAdministrator(String username, String password) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<UserDAO> listOfBuyers() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object getaLastName() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String getaFirstName() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object getAemail() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<DisputeDAO> disputeListSellerToApp() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<DisputeDAO> disputeListBuyerToSeller() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String changePasswordAdmin(Object aemail, String password) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<DisputeDAO> SoldItemListDatewise() {
			// TODO Auto-generated method stub
			return null;
		}
	};


}

