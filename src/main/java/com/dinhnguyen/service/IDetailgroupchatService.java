package com.dinhnguyen.service;

import java.util.List;

import com.dinhnguyen.model.DetailGroupChat;
import com.dinhnguyen.model.GroupChat;
import com.dinhnguyen.paging.Pageble;

public interface IDetailgroupchatService {
	DetailGroupChat save(DetailGroupChat ctNhomChat);
	void Del(DetailGroupChat ctNhomChat);
	List<DetailGroupChat> findall(Long id_nhomchat);
	void Update(DetailGroupChat ctNhomChat);
	void SaveorUpdate(DetailGroupChat ctNhomChat);
	List<DetailGroupChat> findAll(Pageble pageble ,Long id_nhomchat);
	int getTotalItem(Long id_nhomchat);
}
