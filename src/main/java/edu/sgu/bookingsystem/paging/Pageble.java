package edu.sgu.bookingsystem.paging;

import edu.sgu.bookingsystem.sort.Sorter;

public interface Pageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
