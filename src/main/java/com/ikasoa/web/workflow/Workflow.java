package com.ikasoa.web.workflow;

import lombok.Data;

@Data
public class Workflow {

	private String name;

	// 开始节点
	private Node startNode;

	// 当前节点
	private Node currentNode;

	private NodeFactory nodeFactory;

	public Workflow(String name, Node startNode, NodeFactory nodeFactory) {
		this.name = name;
		this.startNode = startNode;
		this.nodeFactory = nodeFactory;
	}

}
