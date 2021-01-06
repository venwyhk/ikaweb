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
		Node startNode = workflow.getStartNode();
		if (startNode == null) {
			log.error("[WFL]: 'StartNode' is null");
			return context;
		}
		log.info("[WFL]: Process Node '" + startNode.getName() + "'.");
		try {
			return startNode.process(context);
		} catch (NodeProcessException e) {
			log.warn("[WFL]: " + e.getMessage());
			return context;
		}
	}

}
