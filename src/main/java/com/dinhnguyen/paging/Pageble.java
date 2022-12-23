package com.dinhnguyen.paging;

import com.dinhnguyen.sort.Sorter;

public interface Pageble {
	Integer getPage();
	Integer GetOffset();
	Integer Getlimit();
	Sorter GetSorter();
}
