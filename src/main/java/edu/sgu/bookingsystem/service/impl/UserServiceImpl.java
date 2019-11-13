package edu.sgu.bookingsystem.service.impl;

import java.util.ArrayList;

import edu.sgu.bookingsystem.dao.UserDao;
import edu.sgu.bookingsystem.dao.impl.UserDaoImpl;
import edu.sgu.bookingsystem.model.User;
import edu.sgu.bookingsystem.model.UserModel;
import edu.sgu.bookingsystem.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDAO = new UserDaoImpl();

	@Override
	public User checkUser(String username, String password) {
		// TODO Auto-generated method stub
		return userDAO.checkUser(username, password);
	}


	@Override
	public User findUser(String username, String password, long status) {
		// TODO Auto-generated method stub
		return userDAO.findUser(username, password, status);
	}
	
	
	//------------------------------------
	@Override
	public ArrayList<UserModel> getAllUser() {
		// TODO Auto-generated method stub
		ArrayList<UserModel> listUserModel = new ArrayList<UserModel>();
		listUserModel =userDAO.getAllUser();
		return listUserModel;
	}

	@Override
	public UserModel getID(long id) {
		// TODO Auto-generated method stub
		return userDAO.getID(id);
	}

	@Override
	public void insertUser(UserModel u) {
		// TODO Auto-generated method stub
		userDAO.insertUser(u);
	}

	@Override
	public void updateUser(UserModel u) {
		// TODO Auto-generated method stub
		userDAO.updateUser(u);
	}
	
}
