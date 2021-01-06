package com.ikasoa.web.workflow.impl;

import com.ikasoa.web.workflow.Context;
import com.ikasoa.web.workflow.Node;
import com.ikasoa.web.workflow.NodeProcessException;
import com.ikasoa.web.workflow.Workflow;
import com.ikasoa.web.workflow.WorkflowStarter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WorkflowStarterImpl implements WorkflowStarter {

	@Override
	public Context process(Workflow workflow, Context context) {
		Node node = workflow.getStartNode();
		if (node == null) {
			log.error("[WFL]: 'StartNode' is null");
			return context;
		}
		return process(workflow, node, context);
	}

	@Override
	public Context continueProcess(Workflow workflow, Context context) {
		Node node = workflow.getCurrentNode();
		if (node == null) {
			log.error("[WFL]: 'CurrentNode' is null");
			return context;
		}
		Node nextNode = node.getNextNode();
		if (nextNode == null) {
			log.error("[WFL]: 'NextNode' is null");
			return context;
		}
		return process(workflow, nextNode, context);
	}

	@Override
	public Context process(Node node, Context context) {
		if (node == null) {
			log.error("[WFL]: Node is null");
			return context;
		}
		return process(null, node, context);
	}

	private Context process(Workflow workflow, Node node, Context context) {
		log.info("[WFL]: Process Node '" + node.getName() + "'.");
		try {
			context = node.process(context);
			if (workflow != null)
				workflow.setCurrentNode(context.getCurrentNode());
			return context;
		} catch (NodeProcessException e) {
			log.error("[WFL]: " + e.getMessage());
			return context;
		}
	}

}
