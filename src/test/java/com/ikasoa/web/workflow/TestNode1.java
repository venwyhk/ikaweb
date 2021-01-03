package com.ikasoa.web.workflow;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Context processNode(Context context) {
		log.info("......" + getName());
		return context;
	}

}
