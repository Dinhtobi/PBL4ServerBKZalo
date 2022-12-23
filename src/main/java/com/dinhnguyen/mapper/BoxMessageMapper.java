package com.dinhnguyen.mapper;

import java.sql.ResultSet;

import com.dinhnguyen.model.HopChat;

public class BoxMessageMapper implements RowMapper<HopChat> {

	@Override
	public HopChat mapRow(ResultSet rs) {
		try {
			HopChat box = new HopChat();
			box.setId_hopchat(rs.getLong("id_hopchat"));
			box.setId_nguoigui(rs.getLong("id_nguoigui"));
			box.setId_nguoinhan(rs.getLong("id_nguoinhan"));
			box.setTinnhancuoi(rs.getString("tinnhancuoi"));
			box.setThoigiantao(rs.getString("thoigiantao"));
			box.setId_nhomchat(rs.getLong("id_nhomchat"));
			return box;
		} catch (Exception e) {
			return null;
		}
	}
	
}
