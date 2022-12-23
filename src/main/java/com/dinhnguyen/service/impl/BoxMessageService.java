package com.dinhnguyen.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.dinhnguyen.Dao.IBoxMessageDAO;
import com.dinhnguyen.Dao.IGroupchatDAO;
import com.dinhnguyen.Dao.IUserDAO;
import com.dinhnguyen.model.HopChat;
import com.dinhnguyen.model.GroupChat;
import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.service.IBoxMessageService;

public class BoxMessageService implements IBoxMessageService {

	@Inject
	private IBoxMessageDAO iBoxMessageDAO;
	@Inject
	private IUserDAO iUserDAO;
	@Inject
	private IGroupchatDAO iGroupchatDAO;
	@Override
	public HopChat findone(Long id_sender, Long id_receider, Long id_nhomchat) {
		try {
			HopChat a = iBoxMessageDAO.findone(id_sender, id_receider, id_nhomchat);
			if (id_nhomchat == null) {
				UserModel send = iUserDAO.FindOne(a.getId_nguoigui());
				a.setTensender(send.getTen());
				a.setUrlsender(send.getUrl());
				UserModel receive = iUserDAO.FindOne(a.getId_nguoinhan());
				a.setTenreceider(receive.getTen());
				a.setUrlreceider(receive.getUrl());
			}
			if (id_receider == null && id_sender == null) {
				GroupChat group = iGroupchatDAO.findone(id_nhomchat);
				a.setTennhom(group.getTennhom());
				a.setImage(group.getImage());
			}
			return a;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void Update(HopChat hopChat) {
		iBoxMessageDAO.Update(hopChat);

	}

	@Override
	public void save(HopChat hopChat) {
		iBoxMessageDAO.save(hopChat);
	}

	@Override
	public List<HopChat> findall(Long id_sender, Long id_receider, Long id_nhomchat) {
		try {
			List<HopChat> list = iBoxMessageDAO.findall(id_sender, id_receider, id_nhomchat);
			if (id_nhomchat != null) {
				for(HopChat i : list) {
					GroupChat group = iGroupchatDAO.findone(i.getId_nhomchat());
					i.setTennhom(group.getTennhom());
					i.setImage(group.getImage());
				}
			} else {
					if (id_sender != null && id_receider == null) {
						for(HopChat i : list) {
							UserModel send = iUserDAO.FindOne(i.getId_nguoigui());
							i.setTensender(send.getTen());
							i.setUrlsender(send.getUrl());
							UserModel receive = iUserDAO.FindOne(i.getId_nguoinhan());
							i.setTenreceider(receive.getTen());
							i.setUrlreceider(receive.getUrl());
						}
					} else if (id_sender == null && id_receider != null) {
						for(HopChat i : list) {
							UserModel send = iUserDAO.FindOne(i.getId_nguoigui());
							i.setTensender(send.getTen());
							i.setUrlsender(send.getUrl());
							UserModel receive = iUserDAO.FindOne(i.getId_nguoinhan());
							i.setTenreceider(receive.getTen());
							i.setUrlreceider(receive.getUrl());
						}
					}
			}
			return list;
		} catch (Exception e) {
			return null;
		}
	}
}
