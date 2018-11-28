package com.net4iot.oss.infra.routingdb.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.net4iot.oss.infra.routingdb.routing.DbContextHolder;
import com.net4iot.oss.infra.routingdb.routing.DbType;

/**
 * 
 * <pre>
 * 作用:
 * 注意:
 * 其他:
 * </pre>
 *
 * @author yanglijuan
 * @version 1.0, 2017年11月22日
 * @see
 * @since
 */
@Aspect
@Component
public class ReadOnlyConnectionInterceptor implements Ordered {
	private static final Logger log = LoggerFactory
			.getLogger(ReadOnlyConnectionInterceptor.class);

	private int order;

	@Value("20")
	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public int getOrder() {
		return order;
	}

	/**
	 * �е�
	 */
	@Pointcut(value = "execution(public * *(..))")
	// ���⹫��������ִ��
	public void anyPublicMethod() {
	}

	/**
	 * ����֪ͨ�������Դ
	 * 
	 * @param pjp
	 * @param readOnlyConnection
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(readOnlyConnection)")
	public Object proceed(ProceedingJoinPoint pjp,
			ReadOnlyConnection readOnlyConnection) throws Throwable {

		try {
			DbContextHolder.setDbType(DbType.REPLICA1);// ִ��Ŀ�귽��ǰ�����Դ��Ϊrplica
			Object result = pjp.proceed();// ִ��Ŀ�귽���������ø�proceed()����Ŀ�귽������ִ��
			DbContextHolder.clearDbType();// ִ��Ŀ�귽����������Դ����
			return result;
		} finally {
			DbContextHolder.clearDbType();// ������Դ����
		}
	}
}
