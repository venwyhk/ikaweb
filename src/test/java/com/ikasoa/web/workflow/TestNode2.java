package com.ikasoa.web.workflow;

import com.ikasoa.web.workflow.nodes.AbstractNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestNode2 extends AbstractNode {

	@Override
	public String getName() {
		return "TestNode2";
	}

	@Override
	public Node getNextNode() {
		return new TestNode3();
	}

	@Override
	public Context processNode(Context context) {
		if (context.getPreviousNode() != null)
			log.info("......" + context.getPreviousNode().getName() + " -> " + getName());
		else
			log.info("......" + getName());
		return context;
	}
	
	@Override
	protected Context saveNode(Node node, Context context) {
		return context;
	}

}
