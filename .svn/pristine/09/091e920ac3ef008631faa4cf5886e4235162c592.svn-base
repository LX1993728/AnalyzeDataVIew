package com.anrong.wulan.admin.po;

import java.util.List;

public class BootstrapPage<T> {

	 /**
     * 总记录数
     */
    private Integer total;
    /**
     * 当前页的数据
     */
    private List<T> rows;
    
    /**
     * 获取当前页起始行数
     */
    private Integer start;
    
    private Integer pageSize;
    
    private Integer pageNumber;
    
	
	public BootstrapPage(Integer total, Integer pageNumber, Integer pageSize) {
		super();
		this.total = total;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		start = (this.pageNumber - 1) * pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
    
    
}
