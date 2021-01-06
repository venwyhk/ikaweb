package com.ikasoa.web.workflow;

import com.ikasoa.core.utils.ListUtil;
import com.ikasoa.web.workflow.impl.WorkflowStarterImpl;

public class Test {

	public static void main(String[] args) {
		WorkflowStarter workflowStarter = new WorkflowStarterImpl();
//		workflowStarter.process(new Workflow("xx", new TestNode1()), null);
		Workflow workflow = new Workflow("xx",
				new TestNodeX(ListUtil.buildArrayList(new TestNode1(), new TestNode2())));
		workflowStarter.process(workflow, null);
		System.out.println("xx:" + workflow.getCurrentNode().getName());
	}

}
