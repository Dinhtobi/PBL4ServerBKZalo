package com.dinhnguyen.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dinhnguyen.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel us =new UserModel();
			us.setId(rs.getLong("id_users"));
			us.setTen(rs.getString("ten"));
			us.setUrl(rs.getString("avatar"));
			us.setEmail(rs.getString("email"));
			us.setPassword(rs.getString("password"));
			us.setTrangthai(rs.getInt("trangthai"));
			return us ;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

}
