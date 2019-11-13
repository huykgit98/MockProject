package edu.sgu.bookingsystem.service.impl;

import java.util.ArrayList;
import java.util.Calendar;

import edu.sgu.bookingsystem.dao.RoleDao;
import edu.sgu.bookingsystem.dao.impl.RoleDaoImpl;
import edu.sgu.bookingsystem.model.RoleModel;
import edu.sgu.bookingsystem.service.RoleService;

public class RoleServiceImpl  implements RoleService{
	RoleDao roleDao = new RoleDaoImpl();
	Calendar cal = Calendar.getInstance();
	@Override
	public ArrayList<RoleModel> getAllRole() {
		// TODO Auto-generated method stub
		ArrayList<RoleModel> listRole = new ArrayList<RoleModel>();
		listRole =roleDao.getAllRole();
		return listRole;
	}

	@Override
	public RoleModel getID(long id) {
		// TODO Auto-generated method stub
		return roleDao.getID(id);
	}

	@Override
	public void insertRole(RoleModel r) {
		// TODO Auto-generated method stub
		r.setRoleId(cal.getTimeInMillis());
		roleDao.insertRole(r);
	}

	@Override
	public void updateRole(RoleModel r) {
		// TODO Auto-generated method stub	
		roleDao.updateRole(r);
	}

}
