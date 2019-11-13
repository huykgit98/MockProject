package edu.sgu.bookingsystem.service;

import java.util.ArrayList;

import edu.sgu.bookingsystem.model.RoleModel;

public interface RoleService {
	ArrayList<RoleModel> getAllRole();
	RoleModel getID(long id);
	void insertRole(RoleModel r);
	void updateRole(RoleModel r);
}
