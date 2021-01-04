package com.ikasoa.web.workflow;

import com.ikasoa.web.workflow.AbstractDecisionNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestNodeX extends AbstractDecisionNode {

	@Override
	public String getName() {
		return "TestNodeX";
	}

	@Override
	public Node getExceNode() {
		return null;
	}

	@Override
	public Node getTrueNode() {
		return new TestNode2();
	}

	@Override
	public Node getFalseNode() {
		return new TestNode3();
	}

	@Override
	public Boolean decide(Context context) {
		log.info("......" + getName());
		return true;
	}

}
