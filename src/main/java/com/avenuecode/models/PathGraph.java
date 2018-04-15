package com.avenuecode.models;

import java.util.List;

public class PathGraph {
	
	private List<String> path;
	private List<Data> data = null;

	public List<String> getPath() {
		return path;
	}
	public void setPath(List<String> path) {
		this.path = path;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	
	
}
