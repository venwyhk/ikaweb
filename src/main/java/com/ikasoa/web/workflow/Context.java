package com.ikasoa.web.workflow;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import lombok.Data;

// 工作流上下文
@Data
public class Context {

	private final int MAX_SIZE = 100;

	// 参数
	private Map<String, Object> parameters;

	private Node currentNode;

	private NodeFactory nodeFactory;

	// 历史记录
	private Queue<WorkflowRecord> records = new LinkedList<WorkflowRecord>();

	public boolean addRecord(WorkflowRecord record) {
		if (records.size() > MAX_SIZE)
			return false;
		return records.offer(record);
	}

}
