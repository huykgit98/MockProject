package edu.sgu.bookingsystem.paging;

import edu.sgu.bookingsystem.sort.Sorter;

public class PageRequest implements Pageble{

	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter; //vi trong page chu gia tru sortBy vs sortName
	
	 public PageRequest (Integer page, Integer maxPageItem, Sorter sorter) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sorter = sorter;
	}
	
	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if (this.page != null && this.maxPageItem != null) //de phong truong hop ko co maxpageitem (khong co phan trang)
		{
			return (this.page -1)*this.maxPageItem;	
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		return this.maxPageItem;
	}

	@Override
	public Sorter getSorter() {
		if (this.sorter !=  null)
		{
			return this.sorter;
		}
		return null;
	}


}
