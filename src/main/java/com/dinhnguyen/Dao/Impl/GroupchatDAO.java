package com.dinhnguyen.Dao.Impl;

import java.util.List;

import com.dinhnguyen.Dao.IGroupchatDAO;
import com.dinhnguyen.mapper.GroupchatMapper;
import com.dinhnguyen.mapper.UserMapper;
import com.dinhnguyen.model.GroupChat;
import com.dinhnguyen.paging.Pageble;

public class GroupchatDAO extends AbstractDAO<GroupChat> implements IGroupchatDAO {

	@Override
	public Long save(GroupChat nhomChat) {
		String sql = "insert into nhomchat(tennhom, id_nguoitao ,image,trangthai) values (?,?,?,1)";
		return insert(sql, nhomChat.getTennhom(), nhomChat.getId_nguoitao(),nhomChat.getImage());
	}

	@Override
	public void Del(Long id_nhomchat) {
		String sql1 = "Delete from ctnhomchat where id_nhomchat = ? ";
		String sql2 = "Delete from nhomchat where id_nhomchat = ?" ;
		update(sql1, id_nhomchat);
		update(sql2, id_nhomchat);
	}

	@Override
	public void Update(GroupChat nhomChat) {
		if(nhomChat.getType().equals("admin")) {
			StringBuilder sql = new StringBuilder( "Update nhomchat set tennhom = ? , trangthai = ? ");
			sql.append(" where id_nhomchat = ? ") ;
			update(sql.toString(), nhomChat.getTennhom() ,nhomChat.getTrangthai(),nhomChat.getId_nhomchat());
		
		}else {
			if(nhomChat.getId_nguoitao() == null) {
				StringBuilder sql = new StringBuilder( "Update nhomchat set tennhom = ? , image = ? , trangthai = ? ");
				sql.append(" where id_nhomchat = ? ") ;
				update(sql.toString(), nhomChat.getTennhom() , nhomChat.getImage(),nhomChat.getTrangthai(),nhomChat.getId_nhomchat());
			
			}else {
				StringBuilder sql = new StringBuilder( "Update nhomchat set id_nguoitao = ? ");
				sql.append(" where id_nhomchat = ? ") ;
				update(sql.toString(), nhomChat.getId_nguoitao() ,nhomChat.getId_nhomchat());
			}
		}
	}

	@Override
	public GroupChat findone(Long id_nhomchat) {
		String sql = "Select * from nhomchat where id_nhomchat = ?" ;
		try {
			List<GroupChat> list= query(sql, new GroupchatMapper(), id_nhomchat);
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public List<GroupChat> findallNhomchatbyiduser(Long id_user) {
		StringBuilder sql = new StringBuilder("select nc.id_nhomchat , nc.tennhom, nc.id_nguoitao , nc.image , nc.trangthai from nhomchat as nc , ctnhomchat as ct ");
		sql.append(" where nc.id_nhomchat = ct.id_nhomchat and nc.trangthai = 1 and ct.trangthai = 1 and ct.id_nguoidung = " + id_user) ;
		try {
			return query(sql.toString() , new GroupchatMapper());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<GroupChat> findAll(Pageble pageble) {
		
		StringBuilder sql = new StringBuilder("SELECT * FROM nhomchat ");
		if(pageble.GetSorter() != null ) {
			sql.append(" Order by " + pageble.GetSorter().getSortName() +" " + pageble.GetSorter().getSortBy() +" ");
		}
		if(pageble.GetOffset() != null && pageble.Getlimit() != null) {
			sql.append("limit "+pageble.GetOffset() +", "+pageble.Getlimit()+"");
		}	
			return query(sql.toString(),new GroupchatMapper());
	}

	@Override
	public int GetTotalItem() {
		String sql = "Select count(*) from nhomchat";
		return count(sql);
	}

	@Override
	public List<GroupChat> findAll() {

		StringBuilder sql = new StringBuilder("SELECT * FROM nhomchat ");
			return query(sql.toString(),new GroupchatMapper());
	}

}
