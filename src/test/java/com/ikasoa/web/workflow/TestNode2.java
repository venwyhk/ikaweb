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
	public Node getNextNode(Context context) {
		return new TestNode3();
	}

	@Override
	public Context processNode(Context context) {
//		isSingleStep = true;
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
	
	@Override
	public String[] nextNodeNames() {
		return null;
	}

}
