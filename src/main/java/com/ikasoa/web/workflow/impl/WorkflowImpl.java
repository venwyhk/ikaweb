package com.ikasoa.web.workflow.impl;

import java.util.Date;

import com.ikasoa.web.workflow.Context;
import com.ikasoa.web.workflow.Node;
import com.ikasoa.web.workflow.Workflow;
import com.ikasoa.web.workflow.WorkflowRecord;

public class WorkflowImpl implements Workflow {

	@Override
	public Context process(Node node, Context context) {
		context.addRecord(saveRecord(new WorkflowRecord(node.getName(), new Date(), node)));
		return node.process(context);
	}

	@Override
	public WorkflowRecord saveRecord(WorkflowRecord record) {
		return record;
	}

}
