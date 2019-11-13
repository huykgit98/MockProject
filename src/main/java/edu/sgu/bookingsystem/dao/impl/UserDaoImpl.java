package edu.sgu.bookingsystem.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.sgu.bookingsystem.connect.JDBCConnection;
import edu.sgu.bookingsystem.connect.UtilsConnect;
import edu.sgu.bookingsystem.dao.RoleDao;
import edu.sgu.bookingsystem.dao.UserDao;
import edu.sgu.bookingsystem.filter.SecurityConfig;
import edu.sgu.bookingsystem.model.User;
import edu.sgu.bookingsystem.model.UserModel;

public class UserDaoImpl extends AbstractDAO<User> implements UserDao {
	private static final Map<String, User> mapUsers = new HashMap<String, User>();
	private static final Map<String, User> mapAdmin = new HashMap<String, User>();

	
	public static void main(String[] args) {
		/* --findUser
		UserDao userDAO = new UserDaoImpl();
		long status = 1;
		User user =userDAO.findUser("admin", "123456", status);
		System.out.println(user.getUserName()); */
		
		UserDao userDAO = new UserDaoImpl();
		List<User> user =userDAO.getAllUserByStatus();
		System.out.println("tong so dong:"+ user.size());
		for(User i: user) {
			System.out.println("-------------");
			System.out.println(i.getUserName());	
			System.out.println(i.getPassword());
		}
		System.out.println("Mapuser" + mapUsers);
		System.out.println("mapAdmin" + mapAdmin);
		
		//User u = userDAO.checkUser("admin", "123456");
		//if (u != null) System.out.println("OK");
		User us = userDAO.checkUser("ticketseller", "123456");
		if (us != null) System.out.println("OK");
	}
	
	static {
		initUsers();
	}

	//B1: tao ra 2 mapUser & mapAdmin
	//B2: check User, neu la ticketseller thi lay username tu mapUsers, neu la admin thi lay username tu mapAdmin
	//B2.1: initUser. neu la ticketseller thi tao ra user co user va put no vao mapUsers
	//B2.2: checkUser()
	private static void initUsers() {
		UserDao userDAO = new UserDaoImpl();
		List<User> listUser = new ArrayList<User>();
		listUser = userDAO.getAllUserByStatus();
		for(User u: listUser) {
			System.out.println("getUserName:"+u.getUserName());	
			if (u.getRole().getName().equals("ticketseller"))
			{
				User emp = new User(u.getUserName(), u.getPassword(), SecurityConfig.ROLE_EMPLOYEE );
				mapUsers.put(emp.getUserName(), emp);
				System.out.println("mapUsers"+ mapUsers);
				System.out.println("empL:" + emp);
			}
			else if (u.getRole().getName().equals("admin"))
			{
				User mng = new User(u.getUserName(), u.getPassword(), SecurityConfig.ROLE_MANAGER, SecurityConfig.ROLE_EMPLOYEE);
				mapAdmin.put(mng.getUserName(), mng);
				System.out.println("admin"+ mapAdmin);
				System.out.println("mang:" + mng);
			}
		}
		
		
		
//		User emp = new User("employee1", "123",SecurityConfig.ROLE_EMPLOYEE); // role: employee
//		User mng = new User("manager1", "123",SecurityConfig.ROLE_MANAGER, SecurityConfig.ROLE_EMPLOYEE);//role: EMPLOYEE và MANAGER
//		//get user
//		mapUsers.put(emp.getUserName(), emp);
//		mapUsers.put(mng.getUserName(), mng);
	}
	
	
	 @Override
	public  User findUser(String username, String password, long status) {
		//find user by username and password
		//StringBuilder sql = new StringBuilder("select *  from users u  JOIN employee emp ON emp.EmpID = u.EmpID JOIN employee_role empro ON emp.EmpID = empro.EmpID join roles r On r.RoleID = empro.RoleID WHERE u.UserName = ? AND u.Password = ? AND u.status = ? ;");
		StringBuilder sql = new StringBuilder(" SELECT *  FROM users u  JOIN employee emp ON emp.EmpID = u.EmpID JOIN ");
		sql.append(" employee_role empro ON emp.EmpID = empro.EmpID join roles r On r.RoleID = empro.RoleID ");
		sql.append(" WHERE u.UserName = ? AND u.Password = ? AND u.status = ? ");
		List<User> listOfUser = new ArrayList<User>();
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs= null;
		try {
			pst = conn.prepareStatement(sql.toString());
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setLong(3, status);
			System.out.println("1");
			rs =pst.executeQuery();
			while (rs.next())
			{
				User u = new User();
				u.setUserName(rs.getString("UserName"));
				u.setPassword(rs.getString("Password"));
				u.setStatus(rs.getLong("status"));
				listOfUser.add(u);
			}
			return listOfUser.isEmpty() ? null : listOfUser.get(0);
		} catch (Exception e) {
			System.out.println("fail");
			return null;
		}finally {
			try {
				if (conn!=null) {
					conn.close(); }
				if (pst!=null) {
					pst.close();  }
				if (rs !=null) {
					rs.close();   }
			} catch (SQLException e2) {
				return null;
			}
		 }
	}


	@Override
	public User checkUser(String username, String password) {
			UserDao userDAO = new UserDaoImpl();
			List<User> listUser = new ArrayList<User>(); //lay tat ca User len voi tat ca thuoc tinh, neu thuoc tinh Name = "ticketseller" thi vao mapUser lay user
			listUser = userDAO.getAllUserByStatus();
			for(User u: listUser) {
				System.out.println("CHECKUSER");
				System.out.println(u.getUserName());	
				if (u.getRole().getName().trim().equals("ticketseller"))
				{
					u = mapUsers.get(username);
					System.out.println("user"+ mapUsers);
				}else if (u.getRole().getName().equals("admin"))
				{
					u = mapAdmin.get(username);
					System.out.println("admin"+ mapAdmin);
				}
				if (u != null)
					if (u.getPassword().equals(password))
						{
							System.out.println(u);
							return u;
						}
			}
			return null;
			
//		User u = mapUsers.get(username);
//		if (u != null & u.getPassword().equals(password))
//		{
//			return u;
//		}
//		System.out.println("fail");
//			return null;
	}
	
	 @Override
	public  List<User> getAllUserByStatus () {
		//find user by username and password
		//StringBuilder sql = new StringBuilder("select *  from users u  JOIN employee emp ON emp.EmpID = u.EmpID JOIN employee_role empro ON emp.EmpID = empro.EmpID join roles r On r.RoleID = empro.RoleID WHERE u.UserName = ? AND u.Password = ? AND u.status = ? ;");
		StringBuilder sql = new StringBuilder(" SELECT u.UserName, u.Password,r.Name FROM users u  JOIN employee emp ON emp.EmpID = u.EmpID JOIN ");
		sql.append(" employee_role empro ON emp.EmpID = empro.EmpID join roles r On r.RoleID = empro.RoleID ");
		sql.append(" WHERE u.status = 1 ");
		List<User> listOfUser = new ArrayList<User>();
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs= null;
		try {
			pst = conn.prepareStatement(sql.toString());
			//System.out.println("1");
			rs =pst.executeQuery();
			while (rs.next())
			{
				User u = new User();
				u.setUserName(rs.getString("UserName"));
				u.setPassword(rs.getString("Password"));
				u.getRole().setName(rs.getString("Name"));
				//System.out.println("2");
				listOfUser.add(u);
			}
			return listOfUser;
		} catch (Exception e) {
			System.out.println("fail");
			return null;
		}finally {
			try {
				if (conn!=null) {
					conn.close(); }
				if (pst!=null) {
					pst.close();  }
				if (rs !=null) {
					rs.close();   }
			} catch (SQLException e2) {
				return null;
			}
		 }
	}
	 
	 
	 
	 //-------------------------------
	 RoleDao rm = new RoleDaoImpl();
		@Override
		public ArrayList<UserModel> getAllUser() {
			// TODO Auto-generated method stub
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<UserModel> userList = new ArrayList<UserModel>();
			try {
				conn = UtilsConnect.getConnection();
				String sql = "SELECT employee.EmpID,users.UserName,users.Password,employee.FullName,employee.Address,employee.Phone,users.status,roles.RoleID "
						+ "FROM employee,employee_role,roles ,users WHERE employee_role.EmpID=employee.EmpID AND roles.RoleID=employee_role.RoleID AND employee.EmpID=users.EmpID";

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					UserModel um = new UserModel();
					um.setIdUser(rs.getLong("EmpID"));
					um.setUserName(rs.getString("UserName"));
					um.setPassWord(rs.getString("Password"));
					um.setFullNameUser(rs.getString("FullName"));
					um.setAddressUser(rs.getString("Address"));
					um.setPhoneUser(rs.getString("Phone"));
					um.setStatusUser(rs.getBoolean("Status"));
					um.setRoleModel(rm.getID(rs.getLong("RoleID")));
					userList.add(um);
				}
				return userList;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
		}

		@Override
		public UserModel getID(long id) {
			// TODO Auto-generated method stub
			String sql = "SELECT employee.EmpID,users.UserName,users.Password,employee.FullName,employee.Address,employee.Phone,users.status,roles.RoleID,roles.Name "
					+ "FROM employee,employee_role,roles,users "
					+ " WHERE employee_role.EmpID=employee.EmpID AND roles.RoleID=employee_role.RoleID AND employee.EmpID=users.EmpID  AND employee.EmpID='"
					+ id + "';";
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			UserModel um = new UserModel();
			RoleDao rm =new RoleDaoImpl();
			try {
				conn = UtilsConnect.getConnection();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					um.setIdUser(rs.getLong("EmpID"));
					um.setUserName(rs.getString("UserName"));
					um.setPassWord(rs.getString("Password"));
					um.setFullNameUser(rs.getString("FullName"));
					um.setAddressUser(rs.getString("Address"));
					um.setPhoneUser(rs.getString("Phone"));
					um.setStatusUser(rs.getBoolean("Status"));
					um.setRoleModel(rm.getID(rs.getLong("RoleID")));	
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				e1.getMessage();
			}
			return um;

		}
		@Override
		public boolean insertUser(UserModel u) {
			// TODO Auto-generated method stub
			try {
				Connection conn = UtilsConnect.getConnection();
				CallableStatement ps = conn.prepareCall("{CALL demo_insert_user_multiple_tables(?,?,?,?,?)}");
				ps.setString(1, u.getUserName());
				ps.setString(2, u.getFullNameUser());
				ps.setString(3, u.getAddressUser());
				ps.setString(4, u.getPhoneUser());
				ps.setLong(5,u.getRoleModel().getRoleId());
				ps.execute();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				e.getMessage();
				return false;
			}
		}

		@Override
		public boolean updateUser(UserModel u) {
			// TODO Auto-generated method stub
			boolean rowupdate =false;
			Connection con;
			try {
				con = UtilsConnect.getConnection();
				CallableStatement ps = con.prepareCall("{CALL demo_update_user_multiple_tables(?,?,?,?,?,?)}");
				ps.setLong(1, u.getIdUser());
				ps.setString(2, u.getUserName());
				ps.setString(3, u.getFullNameUser());
				ps.setString(4,u.getAddressUser());
				ps.setString(5, u.getPhoneUser());
				ps.setLong(6, u.getRoleModel().getRoleId());
				ps.execute();
				rowupdate=true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				e.getMessage();
				rowupdate=false;
			}
			return rowupdate;
		}
}
