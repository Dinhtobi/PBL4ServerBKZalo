package com.dinhnguyen.Dao;

import java.util.List;

import com.dinhnguyen.model.HopChat;

public interface IBoxMessageDAO extends GenericDAO<HopChat> {
	HopChat findone(Long id_hopchat);
	HopChat findone(Long id_sender , Long id_receider , Long id_nhomchat);
	Long save(HopChat hopChat);
	void Update(HopChat hopChat);
	List<HopChat> findall(Long id_sender , Long id_receider , Long id_nhomchat);
}
