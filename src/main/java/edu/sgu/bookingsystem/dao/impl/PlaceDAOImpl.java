package edu.sgu.bookingsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.sgu.bookingsystem.connect.JDBCConnection;
import edu.sgu.bookingsystem.dao.PlaceDAO;
import edu.sgu.bookingsystem.model.Place;

public class PlaceDAOImpl implements PlaceDAO {
	private PreparedStatement stmt = null;
	public PlaceDAOImpl() {
		
	}
	@Override
	public List<Place> getPlaces() {
		List<Place> placeList = new ArrayList<>();

		try {
			Connection dbConnection = null;
			dbConnection = JDBCConnection.getConnection();
			String sql= "SELECT p.PlaceID, p.PlaceName FROM place p";
			stmt = dbConnection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Place place = new Place(rs.getInt("PlaceID"), rs.getString("PlaceName"));
				placeList.add(place);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finallyFunction();
		}

		return placeList;
	}
	private void finallyFunction() {

		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		PlaceDAO placedao = new PlaceDAOImpl();
		
		List<Place> items=placedao.getPlaces();;
		//System.out.println(items.size());
		for(Place i:items){
		System.out.println(i.getId());
		//System.out.println(i.getPlaceName());
		}
		
	}
}
