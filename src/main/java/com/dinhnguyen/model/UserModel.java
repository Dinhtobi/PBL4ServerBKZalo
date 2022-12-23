package com.dinhnguyen.model;

import java.util.ArrayList;
import java.util.List;

public class UserModel extends AbtracModel<UserModel>  {
	private String ten ;
	private String url ;
	private String email ;
	private String password ;
	private List<UserModel> kq = new ArrayList<>();
	private Integer page ;
	private Integer maxPageItem;
	private Integer totalPage;
	private Integer totalItem;
	private String sortName;
	private String sortBy;
	private String type;
	private int trangthai;
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
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<UserModel> getKq() {
		return kq;
	}
	public void setKq(List<UserModel> kq) {
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}


	
}
