package com.dinhnguyen.Dao;

import java.util.List;

import com.dinhnguyen.model.Message;

public interface IMessageDAO extends GenericDAO<Message> {
	List<Message> findAll();
	Message findone(Long Id_tinnhan);
	Long save(Message us);
	void Delete(Long id_tinnhan);
	List<Message> findAllbyid(Long id_nguoigui , Long id_nguoinhan, Long id_nhomchat);
}
