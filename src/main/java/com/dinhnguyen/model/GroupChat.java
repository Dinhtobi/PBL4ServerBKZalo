package com.dinhnguyen.model;

import java.util.ArrayList;
import java.util.List;

public class GroupChat extends AbtracModel<GroupChat> {
	private Long id_nhomchat;
	private String tennhom;
	private Long id_nguoitao ;
	private String image;
	private int trangthai ; 
	private String type ;
	private List<GroupChat> kq = new ArrayList<>();
	private Integer page ;
	private Integer maxPageItem;
	private Integer totalPage;
	private Integer totalItem;
	private String sortName;
	private String sortBy;
	private String tennguoitao;
	private String trangthaihoatdong;
	public String getTennguoitao() {
		return tennguoitao;
	}
	public void setTennguoitao(String tennguoitao) {
		this.tennguoitao = tennguoitao;
	}
	public String getTrangthaihoatdong() {
		return trangthaihoatdong;
	}
	public void setTrangthaihoatdong(String trangthaihoatdong) {
		this.trangthaihoatdong = trangthaihoatdong;
	}
	public List<GroupChat> getKq() {
		return kq;
	}
	public void setKq(List<GroupChat> kq) {
		this.kq = kq;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getMaxPageItem() {
		return maxPageItem;
	}
	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public Long getId_nhomchat() {
		return id_nhomchat;
	}
	public void setId_nhomchat(Long id_nhomchat) {
		this.id_nhomchat = id_nhomchat;
	}
	public String getTennhom() {
		return tennhom;
	}
	public void setTennhom(String tennhom) {
		this.tennhom = tennhom;
	}
	public Long getId_nguoitao() {
		return id_nguoitao;
	}
	public void setId_nguoitao(Long id_nguoitao) {
		this.id_nguoitao = id_nguoitao;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
