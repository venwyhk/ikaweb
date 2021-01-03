package com.ikasoa.web.workflow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractDecisionNode implements DecisionNode {

	abstract Boolean decide(Context context);

	@Override
	public Context process(Context context) throws NodeProcessException {
		try {
			Node node = decide(context) ? getTrueNode() : getFalseNode();
			if (node != null)
				return node.process(context);
			else {
				log.warn("[WFL]: Next Node is null!");
				return null;
			}
		} catch (NodeProcessException e) {
			try {
				return getExceNode().process(context);
			} catch (NodeProcessException ex) {
				log.warn("[WFL]: " + ex.getMessage());
				return context;
			}
		}
	}

}
