package com.masai.DAO;

import java.sql.SQLException;
import java.util.List;

import com.masai.DTO.DisputeDTO;
import com.masai.Exception.InvalidDataEntryException;

public interface DisputeDAO {
    void addDispute(DisputeDTO dispute) throws SQLException;
    void updateDispute(DisputeDTO dispute) throws SQLException, InvalidDataEntryException;
    void deleteDispute(int disputeId) throws SQLException;
    DisputeDTO getDisputeById(int disputeId) throws SQLException;
    List<DisputeDTO> getAllDisputes() throws SQLException;
	String nextLine();
}

