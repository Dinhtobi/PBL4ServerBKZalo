package com.dinhnguyen.Dao;

import java.util.List;

import com.dinhnguyen.model.DetailGroupChat;
import com.dinhnguyen.model.GroupChat;
import com.dinhnguyen.paging.Pageble;


public interface IDetailgroupchatDAO extends GenericDAO<DetailGroupChat> {
	Long save(DetailGroupChat ctNhomChat);
	void Del(Long id_NhomChat);
	DetailGroupChat findone(Long id_nhomchat,Long id_nguoidung);
	List<DetailGroupChat> findAll(Long id_nhomchat);
	void Update(DetailGroupChat ctNhomChat);
	List<DetailGroupChat> findAll(Pageble pageble, Long id_nhomchat);
	int GetTotalItem(Long id_nhomchat);
}
