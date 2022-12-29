package com.dinhnguyen.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.dinhnguyen.Dao.IDetailgroupchatDAO;
import com.dinhnguyen.Dao.IGroupchatDAO;
import com.dinhnguyen.Dao.IUserDAO;
import com.dinhnguyen.model.DetailGroupChat;
import com.dinhnguyen.model.GroupChat;
import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.paging.Pageble;
import com.dinhnguyen.service.IGroupchatService;
import com.dinhnguyen.service.IUserService;

public class GroupchatService implements IGroupchatService{
	@Inject
	private IUserDAO userDAO;
	@Inject
	private IGroupchatDAO iGroupchatDAO; 
	@Inject
	private IDetailgroupchatDAO detailgroupchatDAO ;
	@Override
	public GroupChat save(GroupChat nhomChat) {
		Long id_nhomchat = iGroupchatDAO.save(nhomChat);
		return iGroupchatDAO.findone(id_nhomchat);
	}

	@Override
	public void Del(long[] ids) {
		for(long i : ids) {
			detailgroupchatDAO.Del(i);
			iGroupchatDAO.Del(i);
		}
	}

	@Override
	public void Update(GroupChat nhomChat) {
		if(nhomChat.getType().equals("haveuser")) {
			nhomChat.setTrangthai(1);
		}else {
			if(nhomChat.getTrangthai()== 1) {
				DetailGroupChat detailgroup = new DetailGroupChat();
				detailgroup.setTrangthai(nhomChat.getTrangthai());
				detailgroup.setId_nguoidung(nhomChat.getId_nguoitao());
				detailgroup.setId_nhomchat(nhomChat.getId_nhomchat());
				Date dnow = new Date();
				SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
				detailgroup.setThoigianthamgia(ft.format(dnow).toString());
				detailgroupchatDAO.Update(detailgroup);
			}else {
				List<DetailGroupChat> list = detailgroupchatDAO.findAll(nhomChat.getId_nhomchat());
				for(DetailGroupChat i : list) {
					if(i.getTrangthai()== 1 ) {
						Date dnow = new Date();
						SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
						i.setThoigianroikhoi(ft.format(dnow));
						i.setTrangthai(0);
						detailgroupchatDAO.Update(i);
					}
				}
			}
		}
		iGroupchatDAO.Update(nhomChat);
	}

	@Override
	public List<GroupChat> findAllnhomchatbyiduser(Long id_user) {
		return iGroupchatDAO.findallNhomchatbyiduser(id_user);
	}

	@Override
	public List<GroupChat> findAll(Pageble pageble) {
		List<UserModel> listuser = userDAO.findAll();
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
