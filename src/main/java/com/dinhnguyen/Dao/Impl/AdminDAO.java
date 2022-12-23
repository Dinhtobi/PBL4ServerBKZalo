package com.dinhnguyen.Dao.Impl;


import java.util.List;

import com.dinhnguyen.Dao.IAdminDAO;
import com.dinhnguyen.mapper.AdminMapper;
import com.dinhnguyen.model.Admin;

public class AdminDAO extends AbstractDAO<Admin> implements IAdminDAO {

	@Override
	public Admin findByUsernameandPasswordandTrangthai(String username, String matkhau) {
			String sql ="Select * from admin where username = ? and password = ? ";
			List<Admin> admins =query(sql.toString(),new AdminMapper() , username , matkhau );
			return admins.isEmpty() ? null : admins.get(0);
 		
	}


	
}
