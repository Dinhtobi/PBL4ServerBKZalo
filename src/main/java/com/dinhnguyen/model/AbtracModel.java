package com.dinhnguyen.model;

import java.util.ArrayList;
import java.util.List;

public class AbtracModel<T> {
	private Long id ;
	private long[] ids ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long[] getIds() {
		return ids;
	}
	public void setIds(long[] ids) {
		this.ids = ids;
	} 
	
}
