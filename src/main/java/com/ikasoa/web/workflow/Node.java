package com.ikasoa.web.workflow;

public interface Node {

	String getName();

	Context process(Context context);

}
