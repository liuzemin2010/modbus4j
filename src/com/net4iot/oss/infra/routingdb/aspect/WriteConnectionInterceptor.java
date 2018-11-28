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
public class WriteConnectionInterceptor implements Ordered {
	private static final Logger log = LoggerFactory
			.getLogger(WriteConnectionInterceptor.class);

	private int order;

	/**
	 * ����aopִ��˳��
	 * 
	 * @param order
	 *            ִ��˳�򣬱���С��spring �����orderֵ����֤��spring����ִ��ǰִ��
	 */
	@Value("20")
	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public int getOrder() {
		return order;
	}

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
	@Around("@annotation(writeConnection)")
	public Object proceed(ProceedingJoinPoint pjp,
			WriteConnection writeConnection) throws Throwable {

		try {
			DbContextHolder.setDbType(DbType.MASTER);// ִ��Ŀ�귽��ǰ�����Դ��Ϊmaster
			Object result = pjp.proceed();// ִ��Ŀ�귽���������ø÷���Ŀ�귽������ִ��
			DbContextHolder.clearDbType();// ִ��Ŀ�귽����������Դ����
			return result;
		} finally {
			DbContextHolder.clearDbType();
		}
	}
}
