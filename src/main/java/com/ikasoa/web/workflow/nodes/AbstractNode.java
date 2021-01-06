package com.ikasoa.web.workflow.nodes;

import java.util.Date;

import com.ikasoa.web.workflow.Context;
import com.ikasoa.web.workflow.Node;
import com.ikasoa.web.workflow.NodeProcessException;
import com.ikasoa.web.workflow.WorkflowRecord;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractNode implements Node {

	public boolean isSingleStep = false;

	protected abstract Context processNode(Context context);

	protected abstract Context saveNode(Node node, Context context);

	protected WorkflowRecord saveRecord(WorkflowRecord record) {
		log.info("[WFL]: Record=" + record);
		return record;
	}

	protected Context exce(Context context) {
		try {
			Node node = getExceNode();
			return node != null ? node.process(context) : context;
		} catch (NodeProcessException e) {
			log.warn("[WFL]: " + e.getMessage());
			return context;
		}
	}

	@Override
	public Node getExceNode() {
		return new SuspendNode();
	}

	@Override
	public Context process(Context context) throws NodeProcessException {
		try {
			if (context == null)
				context = new Context();
			if (!context.addRecord(saveRecord(new WorkflowRecord(getName(), new Date(), this)))) {
				log.error("[WFL]: Exceeds the maximum!");
				return context;
			}
			context = processNode(context);
			context.setCurrentNode(this);
			saveNode(this, context);
			return !isSingleStep ? next(context) : context;
		} catch (NodeProcessException e) {
			log.warn("[WFL]: " + e.getMessage());
			return exce(context);
		}
	}

	@Override
	public Context next(Context context) throws NodeProcessException {
		Node nextNode = getNextNode();
		return nextNode != null ? nextNode.process(context) : new SuspendNode().process(context);
	}

}
