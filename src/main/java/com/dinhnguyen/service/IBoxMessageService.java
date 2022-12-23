package com.dinhnguyen.service;

import java.util.List;

import com.dinhnguyen.model.HopChat;

public interface IBoxMessageService {
	HopChat findone(Long id_sender , Long id_receider,Long id_nhomchat);
	void save(HopChat hopChat);
	void Update(HopChat hopChat);
	List<HopChat> findall(Long id_sender , Long id_receider ,Long id_nhomchat);
}
