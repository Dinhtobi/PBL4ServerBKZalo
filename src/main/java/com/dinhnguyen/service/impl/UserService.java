package com.dinhnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.dinhnguyen.Dao.IDetailgroupchatDAO;
import com.dinhnguyen.Dao.IUserDAO;
import com.dinhnguyen.model.DetailGroupChat;
import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.paging.Pageble;
import com.dinhnguyen.service.IUserService;

public class UserService implements IUserService{
	@Inject
	private IUserDAO usDAO;
	@Inject
	private IDetailgroupchatDAO detailgroupchatDAO;
	@Override
	public List<UserModel> findAll(Pageble pageble) {
		return usDAO.findAll( pageble);
	}

	@Override
	public UserModel save(UserModel us) {
		Long newID = usDAO.save(us);
		System.out.print(newID);
		return usDAO.FindOne(newID);
	}

	@Override
	public UserModel Update(UserModel updateUS) {
		//UserModel oldUserModel = usDAO.FindOne(updateUS.getId_users());
		usDAO.Update(updateUS);
		return usDAO.FindOne(updateUS.getId());
	}

	@Override
	public void Delete(long[] ids) {
		for(long id :ids) {
			usDAO.Delete(id);
		}
	}

	@Override
	public int getTotalItem() {
		return usDAO.GetTotalItem();
	}

	@Override
	public UserModel findone(Long id) {
		
		return usDAO.FindOne(id);
	}

	@Override
	public UserModel FindonebyEmailandPassWord(String Email, String Password) {
		return usDAO.FindonebyEmailandPassWord(Email, Password);
	}

	@Override
	public void SetStatusOnl(Long id) {
		usDAO.SetStatusOnl(id);
	}

	@Override
	public void SetStatusOff(Long id) {
		usDAO.SetStatusOff(id);
	}

	@Override
	public List<UserModel> findAll() {
		return usDAO.findAll();
	}

	@Override
	public List<UserModel> findAllbyid_nhomchat(Long id_nhomchat , String type) {
		try {
			List<DetailGroupChat> ct = detailgroupchatDAO.findAll(id_nhomchat);
			List<UserModel> us = usDAO.findAll();
			List<UserModel> UsinGroup = new ArrayList<>();
			if(type.equals("admin")) {
				for(int i = 0 ; i<us.size(); i++) {
					for(int j = 0 ; j <ct.size(); j++) {
						if(us.get(i).getId().equals(ct.get(j).getId_nguoidung())){
							UsinGroup.add(us.get(i));
							break;
						}
					}
				}
			}else {
				for(int i = 0 ; i<us.size(); i++) {
					for(int j = 0 ; j <ct.size(); j++) {
						if(us.get(i).getId().equals(ct.get(j).getId_nguoidung()) && ct.get(j).getTrangthai() == 1){
							UsinGroup.add(us.get(i));
							break;
						}
					}
				}
			}
			return UsinGroup;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}


}
