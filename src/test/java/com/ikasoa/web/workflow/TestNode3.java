package com.ikasoa.web.workflow;

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
	public Node getExceNode() {
		return null;
	}

	@Override
	public Context processNode(Context context) {
		log.info("......" + getName());
		return context;
	}

}
