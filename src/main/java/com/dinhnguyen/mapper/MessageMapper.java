package com.dinhnguyen.mapper;

import java.sql.ResultSet;

import com.dinhnguyen.model.TinNhan;

public class MessageMapper implements RowMapper<TinNhan>{

	@Override
	public TinNhan mapRow(ResultSet rs) {
		try {
			TinNhan mes = new TinNhan();
			mes.setId_tinnhan(rs.getLong("id_tinnhan"));
			mes.setId_nguoigui(rs.getLong("id_nguoigui"));
			mes.setId_nguoinhan(rs.getLong("id_nguoinhan"));
			mes.setNoidung(rs.getString("noidung"));
			mes.setThoigiantao(rs.getString("thoigiantao"));
			mes.setId_nhomchat(rs.getLong("id_nhomchat"));
			return mes; 
		} catch (Exception e) {
			return null;
		}
	}

}
