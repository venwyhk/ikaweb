package com.ikasoa.web.workflow;

// 菱形选择
public interface DecisionNode extends Node {
	
	Node getNextNode(String name);

}
