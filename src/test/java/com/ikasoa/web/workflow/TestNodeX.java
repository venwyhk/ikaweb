package com.ikasoa.web.workflow;

import com.ikasoa.web.workflow.nodes.AbstractDecisionNode;

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
		if (context.getPreviousNode() != null)
			log.info("......" + context.getPreviousNode().getName() + " -> " + getName());
		else
			log.info("......" + getName());
		return true;
	}

}
