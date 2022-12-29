package com.dinhnguyen.mapper;

import java.sql.ResultSet;

import com.dinhnguyen.model.Message;

public class MessageMapper implements RowMapper<Message>{

	@Override
	public Message mapRow(ResultSet rs) {
		try {
			Message mes = new Message();
			mes.setId_tinnhan(rs.getLong("id_tinnhan"));
			mes.setId_nguoigui(rs.getLong("id_nguoigui"));
			mes.setId_nguoinhan(rs.getLong("id_nguoinhan"));
			mes.setNoidung(rs.getString("noidung"));
			mes.setThoigiantao(rs.getString("thoigiantao"));
			mes.setId_nhomchat(rs.getLong("id_nhomchat"));
			mes.setFileformat(rs.getInt("fileformat"));
			return mes; 
		} catch (Exception e) {
			return null;
		}
	}

}
