package com.dinhnguyen.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.dinhnguyen.Dao.IAdminDAO;
import com.dinhnguyen.Dao.IUserDAO;
import com.dinhnguyen.model.Admin;
import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.paging.Pageble;
import com.dinhnguyen.service.IAdminService;
import com.dinhnguyen.service.IUserService;

public class AdminService implements IAdminService{

	@Inject IAdminDAO adminDAO;
	@Override
	public Admin findByUsernameandPasswordandTrangthai(String username, String matkhau) {
		
		return adminDAO.findByUsernameandPasswordandTrangthai(username, matkhau);
	}
	
}
