package com.ikasoa.web.workflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodeFactory {

	Map<String, Node> nodeCache = new HashMap<>();

	public NodeFactory(List<Node> nodeList) {
		nodeList.forEach(node -> {
			nodeCache.put(node.getName(), node);
		});
	}

	public Node getNode(String name) {
		return nodeCache.get(name);
	}

}
