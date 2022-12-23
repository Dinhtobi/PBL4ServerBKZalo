package com.dinhnguyen.paging;

import com.dinhnguyen.sort.Sorter;

public class PageRequest implements Pageble {

	private Integer page;
	private Integer maxPageItem;
	private Sorter sort;
	public PageRequest(Integer page , Integer maxPageItem ,Sorter sort) {
		this.page = page;
		this.maxPageItem= maxPageItem;
		this.setSort(sort);
	}
	@Override
	public Integer getPage() {
		
		return this.page;
	}

	@Override
	public Integer GetOffset() {
		if(this.page != null && this.maxPageItem != null) {
		Integer offset = (this.page -1) * this.maxPageItem;
		
		return offset ;
		}else{
			return null;
					}
		}

	@Override
	public Integer Getlimit() {
		
		return this.maxPageItem;
	}
	public Sorter getSort() {
		return sort;
	}
	public void setSort(Sorter sort) {
		this.sort = sort;
	}
	@Override
	public Sorter GetSorter() {
		if(sort != null) {
			return sort;
		}
		else return null;
	}

}
