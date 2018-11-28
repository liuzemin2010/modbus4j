package com.net4iot.oss.infra.thred;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.net4iot.oss.infra.utils.ReflectionUtils;


/**
 * 
 *<pre>
 * 作用:
 * 注意:
 * 其他:
 *</pre>
 *
 * @author  yanglijuan
 * @version 1.0, 2017年11月30日
 * @see     
 * @since
 */
public class CustomizableThreadFactory implements ThreadFactory {

	protected static final Logger logger = Logger
			.getLogger("CustomizableThreadFactory");

	private static final AtomicInteger poolNumber = new AtomicInteger(1);

	private final ThreadFactory factory;

	private final AtomicInteger threadNumber = new AtomicInteger(1);

	private final String namePrefix;

	/**
	 * 如果用户只传入默认的名称,那么它内部的ThreadFactory将采用 Executors.defaultThreadFactory()
	 * 
	 * @param poolName
	 */
	public CustomizableThreadFactory(String poolName) {
		namePrefix = poolName + "(" + poolNumber.getAndIncrement() + ")";
		factory = Executors.defaultThreadFactory();
	}

	/**
	 * @param factory
	 * @param poolName
	 */
	public CustomizableThreadFactory(ThreadFactory factory, String poolName) {
		this.factory = factory;
		this.namePrefix = poolName + "-[" + poolNumber.getAndIncrement() + "]";
	}

	/**
	 * {@inheritDoc}
	 */
	public Thread newThread(Runnable r) {
		String taskName = getTaskThreadName(r);
		Thread t = factory.newThread(r);
		t.setName(namePrefix + ":" + taskName + "-thread-"
				+ threadNumber.getAndIncrement());
		return t;
	}

	/**
	 * 如果传入的是Worker对象，那么就读取它的private Runnable firstTask属性的名称
	 * 
	 * @param ThreadPoolExecutor
	 *            .Worker对象
	 * @param 属性的名称
	 * @return 线程的名称
	 */
	protected String getTaskThreadName(Object obj) {
		Object fieldObj = ReflectionUtils.getFieldValue(obj, "firstTask");
		if (fieldObj == null) {
			return "";
		}
		try {
			Thread thread = (Thread) fieldObj;
			return thread.getName();

		} catch (Exception exception) {
			logger.info("读取taskThreadName报错");
			return "";
		}

	}

}
