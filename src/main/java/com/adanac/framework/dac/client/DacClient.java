package com.adanac.framework.dac.client;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;

/**
 * 客户端接口
 * @author adanac
 * @version 1.0
 */
public interface DacClient {
	/**
	 * 单表添加操作 返回Number类型的主键
	 */
	Number persist(Object entity);

	/**
	 * 根据传入主键类型requiredType，返回主键值<br>
	 * 非自增长主键，如果传入类型与主键类型不符，会抛出ClassCastException<br>
	 * 自增长主键，必须传入类型为Number类型
	 */
	<T> T persist(Object entity, Class<T> requiredType);

	/** 单表修改操作 根据主键修改记录 **/
	int merge(Object entity);

	/** 动态更新 */
	int dynamicMerge(Object entity);

	/** 单表删除操作 根据主键删除记录 **/
	int remove(Object entity);

	/** 单表查询操作 根据主键查询记录 **/
	<T> T find(Class<T> entityClass, Object entity);

	/** 根据sqlId查询单个对象，返回requiredType类型对象，不需要强转，查不到返回null, 查询多个返回第一个 */
	<T> T queryForObject(String sqlId, Map<String, Object> paramMap, Class<T> requiredType);

	/** 根据sqlId查询单个对象，返回requiredType类型对象，不需要强转，查不到返回null, 查询多个返回第一个 */
	<T> T queryForObject(String sqlId, Object param, Class<T> requiredType);

	/** 根据sqlId查询单个对象，返回rowMapper类型对象, 查不到返回null, 查询多个返回第一个 */
	<T> T queryForObject(String sqlId, Map<String, Object> paramMap, RowMapper<T> rowMapper);

	/** 根据sqlId查询单个对象，返回rowMapper类型对象, 查不到返回null, 查询多个返回第一个 */
	<T> T queryForObject(String sqlId, Object param, RowMapper<T> rowMapper);

	/** 根据sqlId查询单个对象，返回Map集合，key是数据库字段 ，查不到返回null,查询多个返回第一个 */
	Map<String, Object> queryForMap(String sqlId, Map<String, Object> paramMap);

	/** 根据sqlId查询单个对象，返回Map集合，key是数据库字段 ，查不到返回null,查询多个返回第一个 */
	Map<String, Object> queryForMap(String sqlId, Object param);

	/**
	 * 根据sqlId查询多个对象，返回requiredType类型对象List集合，不需要强转
	 * <p>
	 * 注意：适用于元素较少的集合，如果集合元素较多，会出现反射造成的性能问题
	 */
	<T> List<T> queryForList(String sqlId, Map<String, Object> paramMap, Class<T> requiredType);

	/**
	 * 根据sqlId查询多个对象，返回requiredType类型对象List集合，不需要强转
	 * <p>
	 * 注意：适用于元素较少的集合，如果集合元素较多，会出现反射造成的性能问题
	 */
	<T> List<T> queryForList(String sqlId, Object param, Class<T> requiredType);

	/** 根据sqlId查询，返回Map集合List，key是数据库字段 */
	List<Map<String, Object>> queryForList(String sqlId, Map<String, Object> paramMap);

	/** 根据sqlId查询，返回Map集合List，key是数据库字段 */
	List<Map<String, Object>> queryForList(String sqlId, Object param);

	/**
	 * 根据sqlId查询多个对象，返回rowMapper类型对象List集合
	 * <p>
	 */
	<T> List<T> queryForList(String sqlId, Map<String, Object> paramMap, RowMapper<T> rowMapper);

	/**
	 * 根据sqlId查询多个对象，返回rowMapper类型对象List集合
	 * <p>
	 */
	<T> List<T> queryForList(String sqlId, Object param, RowMapper<T> rowMapper);

	/** 根据sqlId执行，返回执行成功的记录条数 */
	int execute(String sqlId, Map<String, Object> paramMap);

	/** 根据sqlId执行，返回主键值 */
	Number execute4PrimaryKey(String sqlId, Map<String, Object> paramMap);

	/** 根据sqlId执行，返回执行成功的记录条数 */
	int execute(String sqlId, Object param);

	/** 根据sqlId执行，批量执行 */
	int[] batchUpdate(String sqlId, Map<String, Object>[] batchValues);

	/** 存储过程调用 存储过程调用时，需要加上schema */
	Map<String, Object> call(String sqlId, Map<String, Object> paramMap, List<SqlParameter> sqlParameters);
}
