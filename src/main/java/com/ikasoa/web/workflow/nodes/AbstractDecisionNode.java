package com.ikasoa.web.workflow.nodes;

import java.util.Date;

import com.ikasoa.core.utils.ObjectUtil;
import com.ikasoa.core.utils.StringUtil;
import com.ikasoa.web.workflow.Context;
import com.ikasoa.web.workflow.DecisionNode;
import com.ikasoa.web.workflow.Node;
import com.ikasoa.web.workflow.NodeFactory;
import com.ikasoa.web.workflow.NodeProcessException;
import com.ikasoa.web.workflow.WorkflowRecord;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractDecisionNode extends AbstractNode implements DecisionNode {

	private String nextNodeName;

	private NodeFactory nodeFactory;

	protected abstract String decide(Context context);

	@Override
	public Node getNextNode(Context context) {
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
			if (nodeFactory == null)
				nodeFactory = context.getNodeFactory();
			context.setCurrentNode(this);
			if (!saveNode(context)) {
				log.error("[WFL]: Save node error!");
				return exce(context);
			}
			return !isSingleStep ? next(context) : context;
		} catch (NodeProcessException e) {
			log.warn("[WFL]: " + e.getMessage());
			return exce(context);
		}
	}

	@Override
	public Context next(Context context) throws NodeProcessException {
System.out.println("1nextNodeName:"+nextNodeName);
		Node nextNode = getNextNode(nextNodeName);
System.out.println("2nextNodeName:"+nextNode.getName());
		return nextNode != null ? nextNode.process(context) : new SuspendNode().process(context);
	}

	public Node getNextNode(String name) {
		if (StringUtil.isEmpty(name) || ObjectUtil.isNull(nodeFactory))
			return null;
		return nodeFactory.getNode(name);
	}

}
