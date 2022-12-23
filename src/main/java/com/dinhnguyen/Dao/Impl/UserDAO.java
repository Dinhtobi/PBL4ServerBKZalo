package com.dinhnguyen.Dao.Impl;


import java.util.List;

import com.dinhnguyen.Dao.IUserDAO;
import com.dinhnguyen.mapper.UserMapper;
import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.paging.Pageble;




public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {


	@Override
	public List<UserModel> findAll(Pageble pageble) {
		
		StringBuilder sql = new StringBuilder("SELECT * FROM nguoidung ");
		if(pageble.GetSorter() != null ) {
			sql.append(" Order by " + pageble.GetSorter().getSortName() +" " + pageble.GetSorter().getSortBy() +" ");
		}
		if(pageble.GetOffset() != null && pageble.Getlimit() != null) {
			sql.append("limit "+pageble.GetOffset() +", "+pageble.Getlimit()+"");
		}	
			return query(sql.toString(),new UserMapper());
		
		
	}

	@Override
	public Long save(UserModel users) {
		String sql ="insert into nguoidung ( ten , avatar , email , password) "
				+ "values (?  ,? ,? ,?)";
		return insert(sql,users.getTen(), users.getUrl(), users.getEmail() , users.getPassword());
	}

	@Override
	public UserModel FindOne(Long id) {
		String sql = "SELECT * FROM nguoidung WHERE id_users = ?";
		try {
			List<UserModel> users =  query(sql,new UserMapper() , id);
			return users.isEmpty() ? null : users.get(0);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null ;
		}
	}

	@Override
	public void Update(UserModel us) {
		StringBuilder sql = new StringBuilder("Update nguoidung set");
		if(us.getUrl() == null) {
			sql.append(" ten = ?, email = ? , password = ? where id_users = ?");
			update(sql.toString(),us.getTen(), us.getEmail() , us.getPassword(), us.getId());
			
		}else {
			sql.append(" ten = ? , avatar = ? , email = ? , password = ? where id_users = ?");
			update(sql.toString(),us.getTen(), us.getUrl(), us.getEmail() , us.getPassword(), us.getId());
		}
	}

	@Override
	public void Delete(Long id) {
		String sql = "Delete from nguoidung where id_users = ?";
		update(sql, id);
		
	}

	@Override
	public int GetTotalItem() {
		String sql = "Select count(*) from nguoidung";
		return count(sql);
	}

	@Override
	public UserModel FindonebyEmailandPassWord(String Email, String Password) {
		StringBuilder sql = new StringBuilder("SELECT * FROM nguoidung WHERE email = ? ");
		sql.append("and password = ?");
		try {
			List<UserModel> users =  query(sql.toString(),new UserMapper() , Email, Password);
			return users.isEmpty() ? null : users.get(0);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null ;
		}
		
	
	}

	@Override
	public void SetStatusOnl(Long id) {
		String sql = "Update nguoidung set trangthai = 1 where id_users = ?";
		update(sql, id);
	}

	@Override
	public void SetStatusOff(Long id) {
		String sql = "Update nguoidung set trangthai = 0 where id_users = ?";
		update(sql, id);
	}

	@Override
	public List<UserModel> findAll() {

		StringBuilder sql = new StringBuilder("SELECT * FROM nguoidung ");
			return query(sql.toString(),new UserMapper());
	}

}
