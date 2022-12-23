package com.dinhnguyen.Dao;

import java.util.List;

import com.dinhnguyen.model.GroupChat;
import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.paging.Pageble;

public interface IGroupchatDAO extends GenericDAO<GroupChat>{
	Long save(GroupChat nhomChat);
	void Del(Long id_nhomchat);
	void Update(GroupChat nhomChat);
	GroupChat findone(Long id_nhomchat) ;
	List<GroupChat> findallNhomchatbyiduser(Long id_user);
	List<GroupChat> findAll(Pageble pageble);
	List<GroupChat> findAll();
	int GetTotalItem();
}
