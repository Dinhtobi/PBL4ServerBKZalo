package com.dinhnguyen.Dao;

import java.util.List;

import com.dinhnguyen.model.TinNhan;

public interface IMessageDAO extends GenericDAO<TinNhan> {
	List<TinNhan> findAll();
	TinNhan findone(Long Id_tinnhan);
	Long save(TinNhan us);
	void Delete(Long id_tinnhan);
	List<TinNhan> findAllbyid(Long id_nguoigui , Long id_nguoinhan, Long id_nhomchat);
}
