package com.ikasoa.web.workflow;

import java.util.List;

import com.ikasoa.web.workflow.nodes.AbstractDecisionNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestNodeX extends AbstractDecisionNode {

	public TestNodeX(List<Node> nextNodeList) {
		super(nextNodeList);
	}

	@Override
	public String getName() {
		return "TestNodeX";
	}

	@Override
	public Node getExceNode() {
		return null;
	}

	@Override
	public String decide(Context context) {
		if (context.getPreviousNode() != null)
			log.info("......" + context.getPreviousNode().getName() + " -> " + getName());
		else
			log.info("......" + getName());
		return "TestNode1";
	}
	
	@Override
	protected Context saveNode(Node node, Context context) {
		return context;
	}

}
