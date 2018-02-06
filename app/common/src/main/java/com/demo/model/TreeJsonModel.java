package com.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * menu菜单左边的菜单
 *
 * @author haodp
 *
 */
@Setter
@Getter
@ToString
public class TreeJsonModel implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	//id
	private Integer id;
	// 內容
	private String text;
	private String icon = "glyphicon glyphicon-stop";
	private String selectedIcon = "glyphicon glyphicon-stop";
	private String href;
	private String color = "#000000";
	private String backColor = "#FFFFFF";
	private boolean state = true;
	private List<TreeJsonModel> nodes = new ArrayList<TreeJsonModel>();

}
