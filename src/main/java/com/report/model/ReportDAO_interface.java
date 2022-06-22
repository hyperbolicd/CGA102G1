package com.report.model;

import java.util.List;


public interface ReportDAO_interface {
	public void insert(ReportVO reportVO);
	public void update(ReportVO reportVO);
	public void delete(Integer hlId);
	public ReportVO findByPrimaryKey(Integer hlId);
	public List<ReportVO> getAll();
}
