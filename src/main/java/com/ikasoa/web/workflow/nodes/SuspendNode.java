package com.ikasoa.web.workflow.nodes;

import com.ikasoa.web.workflow.Context;
import com.ikasoa.web.workflow.Node;
import com.ikasoa.web.workflow.NodeProcessException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SuspendNode implements Node {

	@Override
	public String getName() {
		return "SuspendNode";
	}

	@Override
	public Context process(Context context) throws NodeProcessException {
		log.info("[WFL]: End of process.");
		return context;
	}

	@Override
	public Node getNextNode(Context context) {
		return null;
	}

	@Override
	public Node getExceNode(Context context) {
		return null;
	}

	@Override
	public Context next(Context context) throws NodeProcessException {
		return context;
	}

}
