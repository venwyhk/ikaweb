package com.ikasoa.web.workflow;

// 工作流接口
public interface WorkflowStarter {

	Context process(Workflow workflow, Context context);

}
