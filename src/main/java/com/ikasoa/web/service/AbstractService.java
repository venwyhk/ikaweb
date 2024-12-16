package com.ikasoa.web.service;

import java.text.SimpleDateFormat;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.ikasoa.core.utils.StringUtil;

/**
 * 抽象服务
 * 
 * @author <a href="mailto:larry7696@gmail.com">Larry</a>
 * @version 0.0.1
 */
public abstract class AbstractService {

	protected Mapper mapper = new DozerBeanMapper();

	protected SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

	/**
	 * 默认起始页编码
	 */
	protected static final int DEFAULT_PAGE_NUM = 0;

	/**
	 * 默认每页最大条数
	 */
	protected static final int DEFAULT_PAGE_SIZE = 20;

	/**
	 * 事务回滚
	 */
	protected void rollback() {
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	}

	protected String theDateTo23_59_59(String date) {
		return StringUtil.isNotEmpty(date) ? StringUtil.merge(date.split(" ")[0], " 23:59:59") : date;
	}

}
