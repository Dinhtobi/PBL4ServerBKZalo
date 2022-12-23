package com.dinhnguyen.Dao.Impl;

import java.util.List;

import com.dinhnguyen.Dao.IBoxMessageDAO;
import com.dinhnguyen.mapper.BoxMessageMapper;
import com.dinhnguyen.model.HopChat;

public class BoxMessageDAO extends AbstractDAO<HopChat> implements IBoxMessageDAO{

	@Override
	public HopChat findone(Long id_sender, Long id_receider ,Long id_nhomchat) {
		
		StringBuilder sql = new StringBuilder("select * from hopchat") ;
		
		if(id_nhomchat == null) {
			
			sql.append(" where id_nguoigui = "+ id_sender +" and id_nguoinhan = "+id_receider);
			
		}
		if(id_receider == null && id_sender == null) {
			
			sql.append(" where id_nhomchat = " + id_nhomchat);
			
		}
		try {
			List<HopChat> list = query(sql.toString(), new BoxMessageMapper());
			return list.isEmpty()? null : list.get(0);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public Long save(HopChat hopChat) {
		if(hopChat.getId_nhomchat() == null) {
			hopChat.setId_nhomchat(0L);
		}
		if(hopChat.getId_nguoinhan() == null) {
			hopChat.setId_nguoinhan(0L);
		}
		String sql ="insert into hopchat(id_nguoigui , id_nguoinhan , tinnhancuoi , thoigiantao, id_nhomchat) values(?,?,?,?,?)";
		
		return insert(sql, hopChat.getId_nguoigui(), hopChat.getId_nguoinhan() , hopChat.getTinnhancuoi() , hopChat.getThoigiantao() , hopChat.getId_nhomchat());
	}

	@Override
	public void Update(HopChat hopChat) {
		StringBuilder sql = new StringBuilder("Update hopchat set tinnhancuoi = ? ,");
		sql.append(" thoigiantao = ? where id_hopchat = ?");
		update(sql.toString(),hopChat.getTinnhancuoi() , hopChat.getThoigiantao() , hopChat.getId_hopchat());
	
	}

	@Override
	public HopChat findone(Long id_hopchat) {
		StringBuilder sql = new StringBuilder("select * from hopchat") ;
		sql.append(" where id_hopchat = "+ id_hopchat);
		try {
			List<HopChat> list = query(sql.toString(), new BoxMessageMapper());
			return list.isEmpty()? null : list.get(0);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<HopChat> findall(Long id_sender , Long id_receider ,Long id_nhomchat) {

		StringBuilder sql = new StringBuilder("") ;
		sql.append("select * from hopchat ");
		if(id_nhomchat != null) {
				sql.append(" where id_nhomchat = " +id_nhomchat);
		}
		else {
			if(id_sender != null && id_receider == null)
			sql.append(" where id_nguoigui = "+id_sender+" and id_nhomchat = 0");
			else if(id_sender == null && id_receider != null) {
				sql.append(" where id_nguoinhan = "+id_receider +" and id_nhomchat = 0");
			}
		}
		try {
			List<HopChat> list = query(sql.toString(), new BoxMessageMapper());
			return list;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

}
