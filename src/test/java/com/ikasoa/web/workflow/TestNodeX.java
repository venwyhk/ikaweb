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
	public Node getExceNode(Context context) {
		return null;
	}

	@Override
	public String decide(Context context) {
		if (context.getCurrentNode() != null)
			log.info("......" + context.getCurrentNode().getName() + " -> " + getName());
		else
			log.info("......" + getName());
		return "TestNode1";
	}
	
	@Override
	protected boolean saveNode(Context context) {
		return true;
	}

	@Override
	public String[] nextNodeNames() {
		return null;
	}

}
