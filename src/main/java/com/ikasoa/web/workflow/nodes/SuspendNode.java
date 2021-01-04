package com.ikasoa.web.workflow;

public class SuspendNode implements Node {

	@Override
	public String getName() {
		return "SuspendNode";
	}

	@Override
	public Context process(Context context) throws NodeProcessException {
		return context;
	}

	@Override
	public Node getNextNode() {
		return null;
	}

	@Override
	public Node getExceNode() {
		return null;
	}

}
