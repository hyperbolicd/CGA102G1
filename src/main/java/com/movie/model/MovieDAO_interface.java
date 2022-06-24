package com.movie.model;
import java.util.List;
import java.util.Map;


public interface MovieDAO_interface {
	public void insert(MovieVO movieVO);
	public void update(MovieVO movieVO);
	public void delete(Integer mvId);
	public MovieVO findByPrimaryKey(Integer mvId);
	public List<MovieVO> getAll();
	public List<MovieVO> getShowingMV();
	public List<MovieVO> getComingMV();
	
	// 複合查詢方法
	public List<MovieVO> getAll(Map<String, String[]> map);
}
