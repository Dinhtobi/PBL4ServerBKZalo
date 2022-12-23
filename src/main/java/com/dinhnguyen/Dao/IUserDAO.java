package com.dinhnguyen.Dao;

import java.util.List;

import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.paging.Pageble;

public interface IUserDAO extends GenericDAO<UserModel>{
	UserModel FindOne(Long id) ;
	List<UserModel> findAll(Pageble pageble);
	List<UserModel> findAll();
	Long save(UserModel us);
	void Update(UserModel us);
	void Delete(Long id);
	int GetTotalItem();
	UserModel FindonebyEmailandPassWord(String Email , String Password);
	void SetStatusOnl(Long id);
	void SetStatusOff(Long id); 
	
}
