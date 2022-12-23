package com.dinhnguyen.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dinhnguyen.model.Admin;
import com.dinhnguyen.model.UserModel;

public class AdminMapper implements RowMapper<Admin>{

	@Override
	public Admin mapRow(ResultSet rs) {
		try {
			Admin us =new Admin();
			us.setId(rs.getLong("id_admin"));
			us.setUsername(rs.getString("username"));
			us.setMatkhau(rs.getString("password"));
			us.setTieusu(rs.getString("tieusu"));
			us.setRoll(rs.getInt("roll"));
			return us ;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

}
