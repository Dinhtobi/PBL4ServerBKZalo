package com.dinhnguyen.Dao;



import com.dinhnguyen.model.Admin;


public interface IAdminDAO extends GenericDAO<Admin>{
	Admin findByUsernameandPasswordandTrangthai(String username , String matkhau );
}
