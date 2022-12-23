package com.dinhnguyen.model;

import java.util.ArrayList;
import java.util.List;

public class AbtracModel<T> {
	private Long id ;
	private long[] ids ;
	private List<T> Results = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<T> getResults() {
		return Results;
	}
	public void setResults(List<T> results) {
		Results = results;
	}
	public long[] getIds() {
		return ids;
	}
	public void setIds(long[] ids) {
		this.ids = ids;
	} 
	
}
