package com.ikasoa.web.workflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodeFactory {

	private static Map<String, Node> nodeCache = new HashMap<>();

	public static void setNodes(List<Node> nodeList) {
		nodeList.forEach(node -> {
			nodeCache.put(node.getName(), node);
		});
	}

	public static Node getNode(String name) {
		return nodeCache.get(name);
	}

}
