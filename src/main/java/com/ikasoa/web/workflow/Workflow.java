package com.ikasoa.web.workflow;

import lombok.Data;

@Data
public class Workflow {

	private String name;

	// 开始节点
	private Node startNode;

	// 当前节点
	private Node currentNode;

	public Workflow(String name, Node startNode) {
		this.name = name;
		this.startNode = startNode;
	}

}
