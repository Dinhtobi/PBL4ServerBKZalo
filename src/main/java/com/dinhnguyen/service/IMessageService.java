package com.dinhnguyen.service;

import java.util.List;

import com.dinhnguyen.model.Message;

public interface IMessageService {
	List<Message> findAll();
	Message save(Message us);
	void Delete(Long id_tinnhan);
	List<Message> findAllbyid(Long id_nguoigui , Long id_nguoinhan , Long id_nhomchat);
}
