package com.dinhnguyen.service;

import java.util.List;

import com.dinhnguyen.model.TinNhan;

public interface IMessageService {
	List<TinNhan> findAll();
	TinNhan save(TinNhan us);
	void Delete(Long id_tinnhan);
	List<TinNhan> findAllbyid(Long id_nguoigui , Long id_nguoinhan , Long id_nhomchat);
}
