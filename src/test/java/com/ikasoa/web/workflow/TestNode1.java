package com.ikasoa.web.workflow;

import com.ikasoa.web.workflow.nodes.AbstractNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestNode1 extends AbstractNode {

	@Override
	public String getName() {
		return "TestNode1";
	}

	@Override
	public Node getNextNode() {
		return new TestNode2();
	}

	@Override
	public Node getExceNode() {
		return null;
	}

	@Override
	public Context processNode(Context context) {
		if (context.getPreviousNode() != null)
			log.info("......" + context.getPreviousNode().getName() + " -> " + getName());
		else
			log.info("......" + getName());
		return context;
	}

}
