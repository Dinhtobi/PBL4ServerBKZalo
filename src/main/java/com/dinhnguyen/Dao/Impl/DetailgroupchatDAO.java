package com.dinhnguyen.Dao.Impl;

import java.util.List;

import com.dinhnguyen.Dao.IDetailgroupchatDAO;
import com.dinhnguyen.mapper.DetailGroupchatMapper;
import com.dinhnguyen.mapper.GroupchatMapper;
import com.dinhnguyen.model.DetailGroupChat;
import com.dinhnguyen.model.GroupChat;
import com.dinhnguyen.paging.Pageble;


public class DetailgroupchatDAO extends AbstractDAO<DetailGroupChat> implements IDetailgroupchatDAO {

	@Override
	public Long save(DetailGroupChat ctNhomChat) {
		String sql = "Insert into ctnhomchat(id_nhomchat , id_nguoidung , thoigianthamgia,trangthai) values (?,?,?,1)";
		return insert(sql, ctNhomChat.getId_nhomchat() , ctNhomChat.getId_nguoidung() , ctNhomChat.getThoigianthamgia());
	}

	@Override
	public void Del(DetailGroupChat ctNhomChat) {
		String sql = "delete from ctnhomnhat where id_nguoidung = ? and id_nhomchat = ?";
		update(sql, ctNhomChat.getId_nguoidung(), ctNhomChat.getId_nhomchat());
	}

	@Override
	public DetailGroupChat findone( Long id_nhomchat,Long id_nguoidung) {
		String sql = "select * from ctnhomchat where id_nguoidung = ? and id_nhomchat = ?" ;
		try {
			List<DetailGroupChat> list = query(sql, new DetailGroupchatMapper() , id_nguoidung , id_nhomchat);
			return list.isEmpty()? null : list.get(0);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public List<DetailGroupChat> findAll(Long id_nhomchat) {
		try {
			String sql = "select * from ctnhomchat where id_nhomchat = ? ";
			return query(sql,new DetailGroupchatMapper(), id_nhomchat);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void Update(DetailGroupChat ctNhomChat) {
	try {
		if(ctNhomChat.getTrangthai() == 1) {
			String sql = "update ctnhomchat set trangthai = ?, thoigianthamgia = ?  where id_nguoidung = ? and id_nhomchat = ?";
			update(sql, ctNhomChat.getTrangthai(), ctNhomChat.getThoigianthamgia(),ctNhomChat.getId_nguoidung(), ctNhomChat.getId_nhomchat());
		
		}else {
			String sql = "update ctnhomchat set trangthai = ?, thoigianroikhoi = ?  where id_nguoidung = ? and id_nhomchat = ?";
			update(sql, ctNhomChat.getTrangthai(), ctNhomChat.getThoigianroikhoi(),ctNhomChat.getId_nguoidung(), ctNhomChat.getId_nhomchat());
		
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

	@Override
	public List<DetailGroupChat> findAll(Pageble pageble,Long id_nhomchat) {
		try {

			StringBuilder sql = new StringBuilder("SELECT * FROM ctnhomchat where id_nhomchat = " + id_nhomchat);
			if(pageble.GetSorter() != null ) {
				sql.append(" Order by " + pageble.GetSorter().getSortName() +" " + pageble.GetSorter().getSortBy() +" ");
			}
			if(pageble.GetOffset() != null && pageble.Getlimit() != null) {
				sql.append("limit "+pageble.GetOffset() +", "+pageble.Getlimit()+"");
			}	
				return query(sql.toString(),new DetailGroupchatMapper());
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public int GetTotalItem(Long id_nhomchat) {
		String sql = "Select count(*) from nhomchat where id_nhomchat = " + id_nhomchat;
		return count(sql);
	}

}
