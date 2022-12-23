package com.dinhnguyen.service;

import java.util.List;

import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.paging.Pageble;

public interface IUserService {
	List<UserModel> findAll(Pageble pageble);
	List<UserModel> findAll();
	UserModel save(UserModel us);
	UserModel Update(UserModel updateUS);
	void Delete(long[] ids);
	int getTotalItem();
	UserModel findone(Long id);
	UserModel FindonebyEmailandPassWord(String Email , String Password);
	void SetStatusOnl(Long id);
	void SetStatusOff(Long id);
	List<UserModel> findAllbyid_nhomchat(Long id_nhomchat, String type );
}
