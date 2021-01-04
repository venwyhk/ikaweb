package com.ikasoa.web.workflow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractNode implements Node {

	abstract Context processNode(Context context);

	@Override
	public Context process(Context context) throws NodeProcessException {
		try {
			Context _context = processNode(context);
			Node nextNode = getNextNode();
			if (nextNode != null)
				return nextNode.process(_context);
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
