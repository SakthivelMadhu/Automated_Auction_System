package com.masai.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.DTO.GSTDTO;
import com.masai.Exception.InvalidDataEntryException;

public abstract class GSTDAOImpl implements GSTDAO {

    private Connection connection;

    public GSTDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public GSTDTO getGSTByCategory(String category) throws SQLException {
        String query = "SELECT * FROM gst WHERE category=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, category);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            GSTDTO gst = new GSTDTO(rs.getString("category"), rs.getFloat("rate"));
            return gst;
        }
        return null;
    }

    @Override
    public void addGST(GSTDTO gst) throws SQLException {
        String query = "INSERT INTO gst(category, rate) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, gst.getCategory());
        statement.setInt(2, (int) gst.getRate());
        statement.executeUpdate();
    }

    public void updateGST(GSTDTO gst) throws SQLException, InvalidDataEntryException {
        String query = "UPDATE gst SET rate=? WHERE category=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, (int) gst.getRate());
        statement.setString(2, gst.getCategory());
        int count = statement.executeUpdate();
        if (count == 0) {
            throw new InvalidDataEntryException("No GST record found for category " + gst.getCategory());
        }
    }

    @Override
    public void deleteGST(String category) throws SQLException {
        String query = "DELETE FROM gst WHERE category=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, category);
        statement.executeUpdate();
    }

    @Override
    public List<GSTDTO> getAllGST() throws SQLException {
        String query = "SELECT * FROM gst";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        List<GSTDTO> gstList = new ArrayList<>();
        while (rs.next()) {
            GSTDTO gst = new GSTDTO(rs.getString("category"), rs.getFloat("rate"));
            gstList.add(gst);
        }
        return gstList;
    }
}


