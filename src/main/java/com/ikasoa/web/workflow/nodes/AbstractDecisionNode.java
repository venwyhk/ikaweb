package com.ikasoa.web.workflow.nodes;

import java.util.Date;

import com.ikasoa.web.workflow.Context;
import com.ikasoa.web.workflow.DecisionNode;
import com.ikasoa.web.workflow.Node;
import com.ikasoa.web.workflow.NodeProcessException;
import com.ikasoa.web.workflow.WorkflowRecord;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractDecisionNode extends AbstractNode implements DecisionNode {

	protected abstract Boolean decide(Context context);

	@Override
	public Node getNextNode() {
		return null;
	}

	@Override
	protected Context processNode(Context context) {
		return null;
	}

	@Override
	public Context process(Context context) throws NodeProcessException {
		try {
			if (context == null)
				context = new Context();
			if (!context.addRecord(saveRecord(new WorkflowRecord(getName(), new Date(), this)))) {
				log.error("[WFL]: Exceeds the maximum.");
				return context;
			}
			Boolean r = decide(context);
			if (r == null)
				return exce(context);
			context.setPreviousNode(this);
			Node node = r ? getTrueNode() : getFalseNode();
			return node != null ? node.process(context) : new SuspendNode().process(context);
		} catch (NodeProcessException e) {
			log.warn("[WFL]: " + e.getMessage());
			return exce(context);
		}
	}

}
