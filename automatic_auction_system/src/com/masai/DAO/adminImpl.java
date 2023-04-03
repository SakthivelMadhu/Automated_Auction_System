package com.masai.DAO;
import java.lang.String;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import com.masai.DAO.DisputeDAO;
import com.masai.DAO.GSTDAO;
import com.masai.DAO.ItemDAO;
import com.masai.DAO.TransactionDAO;
import com.masai.DAO.UserDAO;
import com.masai.DTO.ItemDTO;
import com.masai.DTO.UserDTO;
import com.masai.Exception.DuplicateUsernameException;
import com.masai.Exception.InvalidDataEntryException;


public abstract class adminImpl implements AdminDAO {

    private static final String Role = null;
	private ItemDAO itemDAO;
    private TransactionDAO transactionDAO;
	public adminImpl(String string, ItemDAO itemDAO, TransactionDAO transactionDAO, DisputeDAO disputeDAO, GSTDAO gstDAO) {
        this.itemDAO = itemDAO;
        this.transactionDAO = transactionDAO;
    }

    @Override
    public boolean login(String email, String password) throws SQLException {
    	
//    	AdminDAO admin = new AdminImpl();

    	UserDAO userDAO = null;
		@SuppressWarnings("null")
		UserDTO user = userDAO.getUserById(email);

        if (user != null && user.getPassword().equals(password) && user.getRole() == Role) {
            return true;
        }
        return false;
    }



    @Override
    public void register(String email, String password, String firstName, String lastName) throws SQLException, DuplicateUsernameException {
        UserDAO user = new UserDTO(email, password, firstName, lastName, null, 0);
        UserDAO.addUser(user);
    }

    @Override
    public List<ItemDAO> searchItems(String category, boolean sold, String keyword) {
        return itemDAO.getItemsByCategorySoldAndKeyword(category, sold, keyword);
    }

    @Override
    public List<TransactionDAO> viewTransactions() {
        return transactionDAO.getAllTransactions();
    }

    @Override
    public List<TransactionDAO> viewTransactionsByDateRange(Date startDate, Date endDate) {
        return transactionDAO.getTransactionsByDateRange(startDate, endDate);
    }

    @Override
    public TransactionDAO viewTransactionById(int transactionId) {
        try {
			return (TransactionDAO) transactionDAO.getTransactionById(transactionId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactionDAO;
    }

    @Override
    public void logout() {
    }

	@Override
	public boolean createAdmin(AdminDAO admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AdminDAO getAdminById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminDAO getAdminByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminDAO> getAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAdmin(AdminDAO admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAdmin(AdminDAO admin) {
		// TODO Auto-generated method stub
		return false;
	}

}

