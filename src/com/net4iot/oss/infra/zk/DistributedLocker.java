package com.net4iot.oss.infra.zk;

import java.util.concurrent.TimeUnit;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * <pre>
 * 作用:分布式锁
 * 注意:
 * 其他:
 * </pre>
 * 
 * @author chenwetao
 * @version 1.0, 2016-5-24
 * @see
 * @since
 */
public class DistributedLocker {

	private static DistributedLocker single = null;

	/**
	 * 使用之前必须调用init方法
	 * 
	 * @param cs
	 * @param ns
	 * @param path
	 */
	public static synchronized void init(String cs, String ns, String path) {
		if (single == null) {
			single = new DistributedLocker(cs, ns, path);
		}
	}

	public static synchronized DistributedLocker getInstance() {
		if (single == null) {
			throw new NullPointerException();
		}

		return single;
	}

	private InterProcessMutex lock;

	private CuratorFramework client;

	private DistributedLocker(String cs, String ns, String path) {
		client = CuratorFrameworkFactory
				.builder()
				.connectString(cs)
				// TODO 后期优化这两个时间
				.sessionTimeoutMs(10000)
				.connectionTimeoutMs(30000)
				.canBeReadOnly(false)
				.retryPolicy(
						new ExponentialBackoffRetry(1000, Integer.MAX_VALUE))
				.namespace(ns).defaultData(null).build();
		client.start();
		lock = new InterProcessMutex(client, path);
	}

	public boolean acquire(int waitTime, TimeUnit timeUnit) throws Exception {
		return lock.acquire(waitTime, timeUnit);
	}

	public void release() throws Exception {
		lock.release();
	}
}
