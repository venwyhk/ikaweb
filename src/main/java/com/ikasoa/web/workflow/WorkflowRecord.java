package com.ikasoa.web.workflow;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WorkflowRecord {

	private String nodeName;

	private Date createDate;

	private Node node;

}
