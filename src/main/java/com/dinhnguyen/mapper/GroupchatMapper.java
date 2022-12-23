package com.dinhnguyen.mapper;

import java.sql.ResultSet;

import com.dinhnguyen.model.GroupChat;

public class GroupchatMapper implements RowMapper<GroupChat> {

	@Override
	public GroupChat mapRow(ResultSet rs) {
		try {
			GroupChat groChat = new GroupChat();
			groChat.setId_nguoitao(rs.getLong("id_nguoitao"));
			groChat.setId_nhomchat(rs.getLong("id_nhomchat"));
			groChat.setTennhom(rs.getString("tennhom"));
			groChat.setImage(rs.getString("image"));
			groChat.setTrangthai(rs.getInt("trangthai"));
			return groChat ;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null ;
		}
	}

}
