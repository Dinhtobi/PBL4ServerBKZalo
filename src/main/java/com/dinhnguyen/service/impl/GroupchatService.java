package com.dinhnguyen.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.dinhnguyen.Dao.IGroupchatDAO;
import com.dinhnguyen.model.GroupChat;
import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.paging.Pageble;
import com.dinhnguyen.service.IGroupchatService;
import com.dinhnguyen.service.IUserService;

public class GroupchatService implements IGroupchatService{
	@Inject
	private IUserService userService;
	@Inject
	private IGroupchatDAO iGroupchatDAO; 
	@Override
	public GroupChat save(GroupChat nhomChat) {
		Long id_nhomchat = iGroupchatDAO.save(nhomChat);
		return iGroupchatDAO.findone(id_nhomchat);
	}

	@Override
	public void Del(Long id_nhomchat) {
		iGroupchatDAO.Del(id_nhomchat);
	}

	@Override
	public void Update(GroupChat nhomChat) {
		if(nhomChat.getType().equals("haveuser")) {
			nhomChat.setTrangthai(1);
		}else {
			//nhomChat.setTrangthai(0);
		}
		iGroupchatDAO.Update(nhomChat);
	}

	@Override
	public List<GroupChat> findAllnhomchatbyiduser(Long id_user) {
		return iGroupchatDAO.findallNhomchatbyiduser(id_user);
	}

	@Override
	public List<GroupChat> findAll(Pageble pageble) {
		List<UserModel> listuser = userService.findAll();
		List<GroupChat> listgroup = iGroupchatDAO.findAll(pageble);
		for(int i = 0 ; i<listgroup.size(); i++) {
			for(int j = 0 ; j < listuser.size(); j++) {
				if(listgroup.get(i).getId_nguoitao().equals(listuser.get(j).getId())) {
					listgroup.get(i).setTennguoitao(listuser.get(j).getTen());
					break;
				}
			}
			if(listgroup.get(i).getTrangthai() ==1 ) {
				listgroup.get(i).setTrangthaihoatdong("Đang hoạt động");
			}else {
				listgroup.get(i).setTrangthaihoatdong("Ngứng hoạt động");
			}
		}
		return listgroup;
	}

	@Override
	public int getTotalItem() {
		return iGroupchatDAO.GetTotalItem();
	}

	@Override
	public GroupChat findone(Long id_nhomchat) {
		return iGroupchatDAO.findone(id_nhomchat);
	}

}
