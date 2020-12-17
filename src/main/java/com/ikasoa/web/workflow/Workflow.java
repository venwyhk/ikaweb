package com.ikasoa.web.workflow;

// 工作流接口
public interface Workflow {

	Context process(Node node, Context context);

	WorkflowRecord saveRecord(WorkflowRecord record);

}
