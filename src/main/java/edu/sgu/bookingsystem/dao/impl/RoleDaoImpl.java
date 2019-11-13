package edu.sgu.bookingsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.sgu.bookingsystem.connect.JDBCConnection;
import edu.sgu.bookingsystem.connect.UtilsConnect;
import edu.sgu.bookingsystem.dao.RoleDao;
import edu.sgu.bookingsystem.model.RoleModel;

public class RoleDaoImpl implements RoleDao {

	@Override
	public ArrayList<RoleModel> getAllRole() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<RoleModel> roleList = new ArrayList<RoleModel>();
		try {
			conn =JDBCConnection.getConnection();
			String sql = "select * from roles";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				RoleModel roles = new RoleModel();
				roles.setRoleId(rs.getLong("RoleID"));
				roles.setRoleName(rs.getString("Name"));
				roles.setRoleDescription(rs.getString("Description"));
				roleList.add(roles);
			}
			return roleList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RoleModel getID(long id) {
		// TODO Auto-generated method stub
		String sql = "select *  from roles where RoleID='" + id + "'";
		RoleModel md = null;
		try {
			Connection cn = JDBCConnection.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long id_role = rs.getLong("RoleID");
				String name_role = rs.getString("Name");
				String desc_role = rs.getString("Description");
				md = new RoleModel(id_role, name_role, desc_role);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			e.getMessage();
		}
		return md;
	}
	@Override
	public boolean insertRole(RoleModel r) {
		// TODO Auto-generated method stub
		Calendar car = Calendar.getInstance();
		try {
			Connection conn = JDBCConnection.getConnection();
			String sql = "insert into roles(RoleID,Name,Description) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, car.getTimeInMillis());
			ps.setString(2, r.getRoleName());
			ps.setString(3, r.getRoleDescription());
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return false;
		}
	}

	@Override
	public boolean updateRole(RoleModel r) {
		// TODO Auto-generated method stub
		boolean rowupdate = false;
		String sql = "UPDATE roles SET Name= ?,Description= ? WHERE RoleID=? ";
		try {
			Connection con = JDBCConnection.getConnection();
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, r.getRoleName());
			st.setString(2, r.getRoleDescription());
			st.setLong(3, r.getRoleId());
			rowupdate = st.executeUpdate() > 0;
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowupdate;
	}

}