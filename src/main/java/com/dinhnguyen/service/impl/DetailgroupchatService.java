package com.dinhnguyen.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.dinhnguyen.Dao.IDetailgroupchatDAO;
import com.dinhnguyen.Dao.IGroupchatDAO;
import com.dinhnguyen.Dao.IUserDAO;
import com.dinhnguyen.model.DetailGroupChat;
import com.dinhnguyen.model.GroupChat;
import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.paging.Pageble;
import com.dinhnguyen.service.IDetailgroupchatService;
import com.dinhnguyen.service.IGroupchatService;
import com.dinhnguyen.service.IUserService;

public class DetailgroupchatService implements IDetailgroupchatService {
	@Inject
	private IUserDAO userDAO;
	@Inject
	private IDetailgroupchatDAO iDetailgroupchatDAO;
	@Inject
	private IGroupchatDAO groupchatDAO; 
	@Override
	public DetailGroupChat save(DetailGroupChat ctNhomChat) {
		iDetailgroupchatDAO.save(ctNhomChat);
		return iDetailgroupchatDAO.findone(ctNhomChat.getId_nhomchat(), ctNhomChat.getId_nguoidung());
	}

	@Override
	public void Del(Long id_NhomChat) {
		iDetailgroupchatDAO.Del(id_NhomChat);

	}

	@Override
	public List<DetailGroupChat> findall(Long id_nhomchat) {
		return iDetailgroupchatDAO.findAll(id_nhomchat);
	}

	@Override
	public void Update(DetailGroupChat ctNhomChat) {
		List<DetailGroupChat> list = iDetailgroupchatDAO.findAll(ctNhomChat.getId_nhomchat());
		int inGroup = 0 ;
		for(DetailGroupChat i : list) {
			if(i.getTrangthai() == 1) {
				inGroup++ ;
			}
		}
		if(inGroup<=1) {
			GroupChat groupChat = new GroupChat();
			groupChat.setId_nhomchat(ctNhomChat.getId_nhomchat());
			groupChat.setTrangthai(0);
			groupChat.setType("admin");
			groupchatDAO.Update(groupChat);
		}
		iDetailgroupchatDAO.Update(ctNhomChat);
	}

	@Override
	public void SaveorUpdate(DetailGroupChat ctNhomChat) {
		try {
			boolean add = true;
			List<DetailGroupChat> list = iDetailgroupchatDAO.findAll(ctNhomChat.getId_nhomchat());
			if (list == null) {
			} else {
				for (DetailGroupChat i : list) {
					if (i.getId_nguoidung() == ctNhomChat.getId_nguoidung()) {
						add = false;
						break;
					}
				}
				if (add) {
					iDetailgroupchatDAO.save(ctNhomChat);
				} else {
					iDetailgroupchatDAO.Update(ctNhomChat);
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	@Override
	public List<DetailGroupChat> findAll(Pageble pageble, Long id_nhomchat) {
		List<UserModel> listuser = userDAO.findAll();
		List<DetailGroupChat> listmember = iDetailgroupchatDAO.findAll(pageble, id_nhomchat);
		for (int i = 0; i < listmember.size(); i++) {
			for (int j = 0; j < listuser.size(); j++) {
				if (listmember.get(i).getId_nguoidung().equals(listuser.get(j).getId())) {
					listmember.get(i).setTennguoidung(listuser.get(j).getTen());
					break;
				}
			}
			
			if (listmember.get(i).getTrangthai() == 1) {
				listmember.get(i).setTrangthaihoatdong("Trong nhóm");
			} else {
				listmember.get(i).setTrangthaihoatdong("Đã rời khỏi nhóm");
			}
			if(listmember.get(i).getThoigianroikhoi()== null) {
				listmember.get(i).setThoigianroikhoi("Chưa từng rời khỏi");
			}
		}
		return listmember;
	}

	@Override
	public int getTotalItem(Long id_nhomchat) {
		return iDetailgroupchatDAO.GetTotalItem(id_nhomchat);
	}

}
