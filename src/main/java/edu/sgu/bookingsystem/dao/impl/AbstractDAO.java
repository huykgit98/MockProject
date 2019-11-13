package edu.sgu.bookingsystem.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import edu.sgu.bookingsystem.connect.JDBCConnection;
import edu.sgu.bookingsystem.dao.GenericDAO;
import edu.sgu.bookingsystem.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {

	@Override
	public int count(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			int count = 0; 
			conn = JDBCConnection.getConnection();
			pst = conn.prepareStatement(sql);
			setParameter(pst, parameters);
			rs = pst.executeQuery();
			while(rs.next())
			{
				count =rs.getInt(1);
				//count =rs.getInt("count(*)");
			}
			return count;
		} catch (Exception e) {
			return 0;
		}finally {
			
				try {
					if (conn != null) conn.close();
					if (pst != null) pst.close();
					if (rs != null) rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return 0;
				}
		}
	}


	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results= new ArrayList<>();
		Connection conn =  null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = JDBCConnection.getConnection();
			pst = conn.prepareStatement(sql);
			setParameter(pst, parameters);
			rs = pst.executeQuery();
			while(rs.next())
			{
				results.add(rowMapper.mapRow(rs));
			}
			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if (conn != null)  conn.close(); 
				if (pst != null)   pst.close();
				if (rs != null)    rs.close();
			} catch (Exception e2) {
				e2.printStackTrace(); return null;
			}
		}
	}

	
	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				}else if(parameter instanceof Date) {
					statement.setDate(index, (Date) parameter);
				}else if(parameter instanceof Double) {
					statement.setDouble(index, (Double) parameter);
				}else if(parameter instanceof Boolean) {
					statement.setBoolean(index, (Boolean) parameter);
				}else if(parameter == null) {
					statement.setNull(index, Types.NULL);
				}else {
					statement.setInt(index, (int) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void update(String sql, Object... parameters) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = JDBCConnection.getConnection();
			conn.setAutoCommit(false);
			pst = conn.prepareStatement(sql);
			setParameter(pst, parameters);
			pst.executeUpdate();
			conn.commit(); 
			System.out.println("OK update");
		} catch (Exception e) {
			if (conn!=null)
			{
				try {
					System.out.println("rollback");
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("printStackTrace fail");
				}
			}
		}finally {
			try {
				if (conn != null)  conn.close(); 
				if (pst != null) pst.close();
				if (rs != null)    rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}


	@Override
	public Long insert(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		Long id =null;
		try {
			conn = JDBCConnection.getConnection();
			conn.setAutoCommit(false);
			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(pst, parameters);
			System.out.println("start");
			pst.executeUpdate();
			System.out.println("OK ");
			rs = pst.getGeneratedKeys();
			if (rs.next())
			{
				id = rs.getLong(1);
			}
			conn.commit();
			System.out.println("OK insert");
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.rollback();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}finally {
			try {
				if (conn != null)  conn.close(); 
				if (pst != null) pst.close();
				if (rs != null)    rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return id;
	}
	
}
