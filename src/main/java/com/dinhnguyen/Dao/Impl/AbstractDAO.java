package com.dinhnguyen.Dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.dinhnguyen.Dao.GenericDAO;
import com.dinhnguyen.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	
	public Connection getConnection() {
		try {
			/*
			 * Class.forName("com.mysql.jdbc.Driver"); String url =
			 * "jdbc:mysql://localhost:3306/pbl4perfect"; String User = "root"; String pass
			 * = "";
			 */
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String User =resourceBundle.getString("User");
			String pass = "";
			return DriverManager.getConnection(url, User, pass);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}

	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection =null;
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(sql);
			setParameter(stmt , parameters);
			resultset = stmt.executeQuery(); 
			while (resultset.next()) {
				results.add(rowMapper.mapRow(resultset));
				}
			return results;
		} catch (SQLException e) {
			return null;
		}
		finally {
			try {
				if(stmt!=null) {
					connection.close();
				}
				if(resultset!=null) {
					connection.close();
				}if(connection!=null) {
					connection.close();
				}}catch (SQLException e) {
					return null;
				}
		}
	}

	private void setParameter(PreparedStatement stmt, Object... parameters) {
		try {
			for(int i =0 ; i < parameters.length ; i++) {
				Object parameter = parameters[i] ;
				int index = i+1;
				if(parameter instanceof Long) {
					stmt.setLong(index, (Long)parameter);
				}else if( parameter instanceof Timestamp) {
					stmt.setTimestamp(index, (Timestamp) parameter);
				}else  if(parameter instanceof String) {
					stmt.setString(index, (String) parameter);
				}else if(parameter instanceof Integer ) {
					stmt.setInt(index,(Integer)parameter);
				}else if(parameter == null) {
					stmt.setNull(index, Types.NULL);
				}else if(parameter instanceof Timestamp) {
					stmt.setTimestamp(index, (Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(String sql, Object... parameters) {
		
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			 connection = getConnection();
			 connection.setAutoCommit(false);
			 stmt = connection.prepareStatement(sql);
			 setParameter(stmt, parameters);
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if(connection!=null) {
				try {
					connection.rollback();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
		finally {
			try {
				if(stmt!=null) {
					connection.close();
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			Long id = null;
			 connection = getConnection();
			 connection.setAutoCommit(false);
			 stmt = connection.prepareStatement(sql ,Statement.RETURN_GENERATED_KEYS);
			 setParameter(stmt, parameters);
			 stmt.executeUpdate();
			resultSet = stmt.getGeneratedKeys();
			if(resultSet.next()) {
				id = resultSet.getLong(1);	
			}
			connection.commit();
			return id ;
		} catch (SQLException e) {
			if(connection!=null) {
				try {
					connection.rollback();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
		finally {
			try {
				if(stmt!=null) {
					connection.close();
				}
				if(resultSet!=null) {
					
					connection.close();
				}}catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	
	}

	@Override
	public int count(String sql, Object... parameters) {
		
		Connection connection =null;
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		try {
			int count = 0;
			connection = getConnection();
			stmt = connection.prepareStatement(sql);
			setParameter(stmt , parameters);
			resultset = stmt.executeQuery(); 
			while (resultset.next()) {
					count =resultset.getInt(1);
				}
			return count;
		} catch (SQLException e) {
			return 0;
		}
		finally {
			try {
				if(stmt!=null) {
					connection.close();
				}
				if(resultset!=null) {
					connection.close();
				}if(connection!=null) {
					connection.close();
				}}catch (SQLException e) {
					return 0;
				}
		}
	}
}
