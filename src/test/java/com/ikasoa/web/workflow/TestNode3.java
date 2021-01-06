package com.ikasoa.web.workflow;

import com.ikasoa.web.workflow.nodes.AbstractNode;
import com.ikasoa.web.workflow.nodes.SuspendNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestNode3 extends AbstractNode {

	@Override
	public String getName() {
		return "TestNode3";
	}

	@Override
	public Node getNextNode() {
		return new SuspendNode();
	}

	@Override
	public Context processNode(Context context) {
		if (context.getCurrentNode() != null)
			log.info("......" + context.getCurrentNode().getName() + " -> " + getName());
		else
			log.info("......" + getName());
		return context;
	}
	
	@Override
	protected boolean saveNode(Context context) {
		return true;
	}

}
