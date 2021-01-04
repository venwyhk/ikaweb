package com.ikasoa.web.workflow;

import com.ikasoa.web.workflow.impl.WorkflowImpl;

public class Test {

	public static void main(String[] args) {
		Workflow workflow = new WorkflowImpl();
//		workflow.process(new TestNode1(), null);
		workflow.process(new TestNodeX(), null);
	}

}
