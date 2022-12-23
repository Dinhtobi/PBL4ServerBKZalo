package com.dinhnguyen.model;

import java.util.ArrayList;
import java.util.List;

public class DetailGroupChat {
	private Long id_nhomchat ;
	private Long  id_nguoidung ;
	private String  thoigianthamgia;
	private String thoigianroikhoi;
	private int trangthai;
	private String type; 
	private List<DetailGroupChat> kq = new ArrayList<>();
	private Integer page ;
	private Integer maxPageItem;
	private Integer totalPage;
	private Integer totalItem;
	private String sortName;
	private String sortBy;
	private String tennguoidung;
	private String tennhomchat;
	private String trangthaihoatdong;
	public List<DetailGroupChat> getKq() {
		return kq;
	}
	public void setKq(List<DetailGroupChat> kq) {
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
	
	public String getTrangthaihoatdong() {
		return trangthaihoatdong;
	}
	public void setTrangthaihoatdong(String trangthaihoatdong) {
		this.trangthaihoatdong = trangthaihoatdong;
	}
	
	public Long getId_nhomchat() {
		return id_nhomchat;
	}
	public void setId_nhomchat(Long id_nhomchat) {
		this.id_nhomchat = id_nhomchat;
	}
	public Long getId_nguoidung() {
		return id_nguoidung;
	}
	public void setId_nguoidung(Long id_nguoidung) {
		this.id_nguoidung = id_nguoidung;
	}
	public String getThoigianthamgia() {
		return thoigianthamgia;
	}
	public void setThoigianthamgia(String thoigianthamgia) {
		this.thoigianthamgia = thoigianthamgia;
	}
	public String getThoigianroikhoi() {
		return thoigianroikhoi;
	}
	public void setThoigianroikhoi(String thoigianroikhoi) {
		this.thoigianroikhoi = thoigianroikhoi;
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
	public String getTennguoidung() {
		return tennguoidung;
	}
	public void setTennguoidung(String tennguoidung) {
		this.tennguoidung = tennguoidung;
	}
	public String getTennhomchat() {
		return tennhomchat;
	}
	public void setTennhomchat(String tennhomchat) {
		this.tennhomchat = tennhomchat;
	}
	
}
