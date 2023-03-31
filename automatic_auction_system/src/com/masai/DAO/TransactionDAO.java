package com.masai.DAO;

import java.sql.SQLException;
import java.util.List;

import com.masai.DTO.TransactionDTO;
import com.masai.Exception.InvalidDataEntryException;

public interface TransactionDAO {
    public void addTransaction(TransactionDTO transaction) throws SQLException, InvalidDataEntryException;
    public void updateTransaction(TransactionDTO transaction) throws SQLException, InvalidDataEntryException;
    public void deleteTransaction(int transactionId) throws SQLException;
    public TransactionDTO getTransactionById(int transactionId) throws SQLException;
    public List<TransactionDTO> getTransactionsByBuyerId(int buyerId) throws SQLException;
    public List<TransactionDTO> getTransactionsBySellerId(int sellerId) throws SQLException;
}

