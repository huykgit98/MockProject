package edu.sgu.bookingsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sgu.bookingsystem.dao.PlaceDAO;
import edu.sgu.bookingsystem.dao.impl.PlaceDAOImpl;
import edu.sgu.bookingsystem.model.Place;
import edu.sgu.bookingsystem.service.PlaceService;

public class PlaceServiceImpl implements PlaceService {
	PlaceDAO placedao = new PlaceDAOImpl();
	@Override
	public List<Place> getPlaces() {
		List<Place> list = new ArrayList<Place>();
		list=placedao.getPlaces();
		return list;
	}

}
