package com.ikasoa.web.workflow;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

// 工作流记录
@AllArgsConstructor
@Data
@ToString
public class WorkflowRecord {

	private String nodeName;

	private Date createDate;

	private Node node;

}
