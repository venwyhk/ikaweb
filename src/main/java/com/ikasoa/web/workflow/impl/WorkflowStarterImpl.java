package com.ikasoa.web.workflow.impl;

import com.ikasoa.web.workflow.Context;
import com.ikasoa.web.workflow.Node;
import com.ikasoa.web.workflow.NodeProcessException;
import com.ikasoa.web.workflow.WorkflowStarter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WorkflowStarterImpl implements WorkflowStarter {

	@Override
	public Context process(Node node, Context context) {
		try {
			log.info("[WFL]: Process Node '" + node.getName() + "'.");
			return node.process(context);
		} catch (NodeProcessException e) {
			log.warn("[WFL]: " + e.getMessage());
			return context;
		}
	}

}
