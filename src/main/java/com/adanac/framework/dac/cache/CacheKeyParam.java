package com.adanac.framework.dac.cache;

/**
 * 描述：缓存key参数<br>
 * 用以计算缓存key
 * 
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CacheKeyParam {

	/**
	 * 执行的dalClient数据操作方法名称
	 */
	private String methodName;

	/**
	 * 经处理的方法参数数组
	 */
	private Object[] methodParams;

	public CacheKeyParam(String methodName, Object[] methodParams) {
		this.methodName = methodName;
		this.methodParams = methodParams;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Object[] getMethodParams() {
		return methodParams;
	}

	public void setMethodParams(Object[] methodParams) {
		this.methodParams = methodParams;
	}

}