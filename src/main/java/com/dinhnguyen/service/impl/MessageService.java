package com.dinhnguyen.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.dinhnguyen.Dao.IMessageDAO;
import com.dinhnguyen.model.Message;
import com.dinhnguyen.service.IMessageService;

public class MessageService implements IMessageService{
	@Inject
	private IMessageDAO messageDAO;
	@Override
	public List<Message> findAll() {
		return messageDAO.findAll();
	}

	@Override
	public Message save(Message message) {
		Long id_mes = messageDAO.save(message);
		return messageDAO.findone(id_mes);
	}

	@Override
	public void Delete(Long id_tinnhan) {
		messageDAO.Delete(id_tinnhan);
	}

	@Override
	public List<Message> findAllbyid(Long id_nguoigui, Long id_nguoinhan, Long id_nhomchat) {
		
		return messageDAO.findAllbyid(id_nguoigui, id_nguoinhan, id_nhomchat);
	}

	


}
