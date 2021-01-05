package com.ikasoa.web.workflow;

import java.util.List;

import lombok.Data;

@Data
public class Workflow {

	private String name;

	// 开始节点
	private Node startNode;

	// 当前节点
	private Node currentNode;

	// 执行记录
	private List<WorkflowRecord> workflowRecordList;

}
