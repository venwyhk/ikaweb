package com.ikasoa.web.workflow;

import com.ikasoa.core.utils.ListUtil;
import com.ikasoa.web.workflow.impl.WorkflowStarterImpl;

public class Test {

	public static void main(String[] args) {
		WorkflowStarter workflowStarter = new WorkflowStarterImpl();
//		workflowStarter.process(new TestNode1(), null);
		workflowStarter.process(new TestNodeX(ListUtil.buildArrayList(new TestNode1(), new TestNode2())), null);
	}

}
