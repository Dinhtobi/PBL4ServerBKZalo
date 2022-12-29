package com.dinhnguyen.service;

import java.util.List;

import com.dinhnguyen.model.DetailGroupChat;
import com.dinhnguyen.model.GroupChat;
import com.dinhnguyen.paging.Pageble;

public interface IGroupchatService {
	GroupChat save(GroupChat nhomChat);
	void Del(long[] ids);
	void Update(GroupChat nhomChat);
	List<GroupChat> findAllnhomchatbyiduser(Long id_user);
	List<GroupChat> findAll(Pageble pageble);
	int getTotalItem();
	GroupChat findone(Long id_nhomchat);
}
