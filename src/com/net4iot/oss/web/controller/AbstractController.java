package com.net4iot.oss.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.net4iot.oss.infra.orm.HibernateRepository;
import com.net4iot.oss.infra.orm.Page;
import com.net4iot.oss.infra.orm.PropertyFilter;

/**
 * <pre>
 * Service�ĳ����� ר�������̳и�����ʹ��,���ٳ���Ա���ظ��Ĵ�����
 * @author chenwentao
 * 
 * @version 0.9
 * 
 * �޸İ汾: 0.9
 * �޸�����: Nov 16, 2010
 * �޸��� :  chenwentao
 * �޸�˵��: �������
 * ������ ��
 * </pre>
 */
@Service("abstractService")
@Transactional
public abstract class AbstractController {

	@Inject
	protected HibernateRepository hibernateRepository;

	/**
	 * Spring���Բ���Ҫ�������,д����Ŀ����Ҫ�Ǹ�Mock����ע��
	 * 
	 * @param hibernateRepository
	 */
	public void setHibernateRepository(HibernateRepository hibernateRepository) {
		this.hibernateRepository = hibernateRepository;
	}

	public SessionFactory getSessionFactory() {
		return this.hibernateRepository.getSessionFactory();
	}

	public Session getSession() {
		return this.hibernateRepository.getSession();
	}

	// --------------------------CRUD----------------------------------------------
	public void merge(Object entity) {
		hibernateRepository.merge(entity);
	}

	public void saveOrUpdate(Object entity) {
		hibernateRepository.saveOrUpdate(entity);
	}

	public Serializable save(Object entity) {
		return hibernateRepository.save(entity);
	}

	public void update(Object entity) {
		hibernateRepository.update(entity);
	}

	@SuppressWarnings("unchecked")
	public void delete(Class entityClass, Serializable id) {
		hibernateRepository.delete(entityClass, id);
	}

	public void delete(Object entity) {
		hibernateRepository.delete(entity);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<?> entityClass, Serializable id) {
		return (T) hibernateRepository.get(entityClass, id);
	}

	public <T> List<T> find(String hql, Object... values) {
		return hibernateRepository.find(hql, values);
	}

	public <T> T findUnique(String hql, Object... values) {
		List<T> results = hibernateRepository.find(hql, values);
		if (CollectionUtils.isEmpty(results)) {
			return null;
		}

		return results.get(0);
	}

	@SuppressWarnings("unchecked")
	public <T> T findUniqueBy(Class<T> clazz, String propertyName, Object value) {
		return (T) hibernateRepository.findUniqueBy(clazz, propertyName, value);
	}

	/**
	 * <pre>
	 * ����page����hql��ѯ��䣬values����Ĳ�������page����
	 * </pre>
	 * 
	 * @param <T>
	 * @param page
	 * @param hql
	 * @param values
	 * @return
	 */
	public <T> Page<T> findPage(final Page<T> page, final String hql,
			final Object... values) {
		return hibernateRepository.findPage(page, hql, values);
	}
	
	public <T> Page<T> getPageSql(final Page<T> page,final Class classEntity,final String hql,
			final List<PropertyFilter> filters) {
		StringBuilder sb=new StringBuilder(hql);
		sb.append(" where 1=1 ");
		Object[] values=new Object[filters.size()];
		
		for (int i = 0; i < filters.size(); i++) {
			PropertyFilter pf=filters.get(i);
			sb.append(" and ").append(pf.getPropertyName()).append(" ").append(pf.getMatchType().getSql());
			values[i]=pf.getMatchValue();
		}
		
		if (page.isOrderBySetted()) {
			String[] orderByArray = StringUtils.split(page.getOrderBy(), ',');
			String[] orderArray = StringUtils.split(page.getOrder(), ',');
			sb.append(" order by ");
			for(int i=0;i<orderByArray.length;i++){
				sb.append(" ").append(orderByArray[i]).append(" ").append(" ").append(orderArray[i]);
				if((orderByArray.length-1)!=i){
					sb.append(",");
				}
			}
		}
		
		return hibernateRepository.findPageSql(page,classEntity ,sb.toString(),values);
	}
	
	
	public <T> Page<T> findPageSql(final Page<T> page,final String hql,
			final List<PropertyFilter> filters) {
		StringBuilder sb=new StringBuilder(hql);
		sb.append(" where 1=1 ");
		Object[] values=new Object[filters.size()];
		
		for (int i = 0; i < filters.size(); i++) {
			PropertyFilter pf=filters.get(i);
			sb.append(" and ").append(pf.getPropertyName()).append(" ").append(pf.getMatchType().getSql());
			values[i]=pf.getMatchValue();
		}
		
		if (page.isOrderBySetted()) {
			String[] orderByArray = StringUtils.split(page.getOrderBy(), ',');
			String[] orderArray = StringUtils.split(page.getOrder(), ',');
			sb.append(" order by ");
			for(int i=0;i<orderByArray.length;i++){
				sb.append(" ").append(orderByArray[i]).append(" ").append(" ").append(orderArray[i]);
				if((orderByArray.length-1)!=i){
					sb.append(",");
				}
			}
		}
		
		return hibernateRepository.findPage(page, sb.toString(), values);
	}
	
	
	public <T> Page<T> findPageHql(final Page<T> page,final String hql,
			final List<PropertyFilter> filters) {
		StringBuilder sb=new StringBuilder(hql);
		sb.append(" where 1=1 ");
		Object[] values=new Object[filters.size()];
		
		for (int i = 0; i < filters.size(); i++) {
			PropertyFilter pf=filters.get(i);
			sb.append(" and ").append(pf.getPropertyName()).append(" ").append(pf.getMatchType().getSql());
			values[i]=pf.getMatchValue();
		}
		
		if (page.isOrderBySetted()) {
			String[] orderByArray = StringUtils.split(page.getOrderBy(), ',');
			String[] orderArray = StringUtils.split(page.getOrder(), ',');
			sb.append(" order by ");
			for(int i=0;i<orderByArray.length;i++){
				sb.append(" ").append(orderByArray[i]).append(" ").append(" ").append(orderArray[i]);
				if((orderByArray.length-1)!=i){
					sb.append(",");
				}
			}
		}
		
		return hibernateRepository.findPage(page, sb.toString(), values);
	}
 


	public <T> Page<T> findPage(final Class entityClass, final Page<T> page,
			final List<PropertyFilter> filters) {

		return hibernateRepository.findPage(entityClass, page, filters);
	}
	


	/**
	 * ͳ������
	 */
	public Long count(final String hql, Object... values) {
		return (Long) createQuery(hql, values).uniqueResult();
	}

	public int executeHql(String hql, Object... values) {
		return hibernateRepository.executeHql(hql, values);
	}

	/**
	 * �Զ����ѯ���˴���Ҫ����ͳ����
	 * 
	 * @return
	 */
	public Query createQuery(String queryString, Object... values) {
		return hibernateRepository.createQuery(queryString, values);
	}
	
	public <T> List<T> findBySQLSimple(final Class entityClass,
			final String sql, final Object... values) {
		SQLQuery queryObject = getSession().createSQLQuery(sql);

		if (entityClass != null) {
			queryObject.addEntity(entityClass);
		}

		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				queryObject.setParameter(i, values[i]);
			}
		}

		return queryObject.list();
	}

	public void init(Object object) {
		hibernateRepository.init(object);
	}

	/**
	 * ˢ�»�������
	 */
	public void flush() {
		hibernateRepository.flush();
	}
}
