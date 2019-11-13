package edu.sgu.bookingsystem.dao;

import java.util.ArrayList;

import edu.sgu.bookingsystem.model.RoleModel;

public interface RoleDao {
	ArrayList<RoleModel> getAllRole();
	// TODO Auto-generated method stub	
	RoleModel getID(long id);
	///String  getNameRole(long id);
	boolean insertRole(RoleModel r);
	boolean updateRole(RoleModel r);
}
