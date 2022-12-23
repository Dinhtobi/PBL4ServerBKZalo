package com.dinhnguyen.mapper;

import java.sql.ResultSet;

import com.dinhnguyen.model.DetailGroupChat;

public class DetailGroupchatMapper implements RowMapper<DetailGroupChat> {

	@Override
	public DetailGroupChat mapRow(ResultSet rs) {
		try {
			DetailGroupChat ct = new DetailGroupChat();
			ct.setId_nguoidung(rs.getLong("id_nguoidung"));
			ct.setId_nhomchat(rs.getLong("id_nhomchat"));
			ct.setThoigianroikhoi(rs.getString("thoigianroikhoi"));
			ct.setThoigianthamgia(rs.getString("thoigianthamgia"));
			ct.setTrangthai(rs.getInt("trangthai"));
			return ct; 
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null; 
		}
	}

}
