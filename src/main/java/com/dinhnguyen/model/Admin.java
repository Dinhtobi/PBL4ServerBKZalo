package com.dinhnguyen.model;

public class Admin extends AbtracModel<Admin> {
	private Long id_admin; 
	private String username ;
	private String matkhau;
	private int roll ;
	private String tieusu;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	
	public Long getId_admin() {
		return id_admin;
	}
	public void setId_admin(Long id_admin) {
		this.id_admin = id_admin;
	}
	public String getTieusu() {
		return tieusu;
	}
	public void setTieusu(String tieusu) {
		this.tieusu = tieusu;
	}
}
