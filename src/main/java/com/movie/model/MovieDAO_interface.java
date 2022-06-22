package com.movie.model;
import java.util.*;


public interface MovieDAO_interface {
	public void insert(MovieVO movieVo);
	public void update(MovieVO movieVo);
	public void delete(Integer mvId);
	public MovieVO findByPrimaryKey(Integer mvId);
	public List<MovieVO> getAll();
	public List<MovieVO> getShowingMV();
	public List<MovieVO> getComingMV();
	
}
