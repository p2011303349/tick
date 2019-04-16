package com.qianfeng.vo;

import java.util.List;

public class VMenuInfo {

	private Integer id;
	private String title;
	private String aurl;
	// 子菜单
	private List<VMenuInfo> menuList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAurl() {
		return aurl;
	}

	public void setAurl(String aurl) {
		this.aurl = aurl;
	}

	public List<VMenuInfo> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<VMenuInfo> menuList) {
		this.menuList = menuList;
	}
}
