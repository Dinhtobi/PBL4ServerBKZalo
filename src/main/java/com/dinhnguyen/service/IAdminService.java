package com.dinhnguyen.service;

import java.util.List;

import com.dinhnguyen.model.Admin;
import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.paging.Pageble;

public interface IAdminService {
	Admin findByUsernameandPasswordandTrangthai(String username, String matkhau);
}
