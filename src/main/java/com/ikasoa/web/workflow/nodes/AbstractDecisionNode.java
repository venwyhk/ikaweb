package com.ikasoa.web.workflow.nodes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ikasoa.core.utils.StringUtil;
import com.ikasoa.web.workflow.Context;
import com.ikasoa.web.workflow.DecisionNode;
import com.ikasoa.web.workflow.Node;
import com.ikasoa.web.workflow.NodeProcessException;
import com.ikasoa.web.workflow.WorkflowRecord;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractDecisionNode extends AbstractNode implements DecisionNode {

	private List<Node> nextNodeList = new ArrayList<>();

	private String nextNodeName;
	
	public AbstractDecisionNode(List<Node> nextNodeList) {
		this.nextNodeList = nextNodeList;
	}

	protected abstract String decide(Context context);

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
			nextNodeName = decide(context);
			if (nextNodeName == null)
				return exce(context);
			context.setPreviousNode(this);
			saveNode(this, context);
			return !isSingleStep ? next(context) : context;
		} catch (NodeProcessException e) {
			log.warn("[WFL]: " + e.getMessage());
			return exce(context);
		}
	}

	@Override
	public Context next(Context context) throws NodeProcessException {
		Node nextNode = getNextNode(nextNodeName);
		return nextNode != null ? nextNode.process(context) : new SuspendNode().process(context);
	}

	public Node getNextNode(String name) {
		if (StringUtil.isEmpty(name))
			return null;
		for (Node node : nextNodeList)
			if (name.equals(node.getName()))
				return node;
		log.warn("[WFL]: Node not found. (" + name + ")");
		return null;
	}

}
