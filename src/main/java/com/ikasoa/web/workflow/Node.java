package com.ikasoa.web.workflow;

// 普通节点
public interface Node {

	String getName();

	Context process(Context context) throws NodeProcessException;

	// 下一个节点
	Node getNextNode();

	// 异常节点
	Node getExceNode();

}
