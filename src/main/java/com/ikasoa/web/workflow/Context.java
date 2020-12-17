package com.ikasoa.web.workflow;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import lombok.Data;

// 工作流上下文
@Data
public class Context {

	private Map<String, Object> parameters;

	private Queue<WorkflowRecord> records = new LinkedList<WorkflowRecord>();

	public boolean addRecord(WorkflowRecord record) {
		return records.offer(record);
	}

}
