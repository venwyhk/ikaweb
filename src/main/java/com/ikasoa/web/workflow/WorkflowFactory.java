package com.ikasoa.web.workflow;

public interface WorkflowFactory {

	Workflow newWorkflow();

	Workflow getWorkflow(String name);

}
