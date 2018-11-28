package com.net4iot.oss.domain.service.id;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * <pre>
 * 作用:
 * 注意:
 * 其他:
 * </pre>
 *
 * @author chenwentao
 * @version 1.0, 2016-5-24
 * @see
 * @since
 */
public class IdTest {

	private static final String PATH = "/test-locks";

	// 排他锁
	private static final InterProcessMutex lock;

	private static CuratorFramework client = CuratorFrameworkFactory
			.builder()
			.connectString(
					"120.26.221.249:2181,120.26.106.213:2181,121.40.33.28:2181")
			.sessionTimeoutMs(3000).connectionTimeoutMs(30000)
			.canBeReadOnly(false)
			.retryPolicy(new ExponentialBackoffRetry(1000, Integer.MAX_VALUE))
			.namespace("lpan").defaultData(null).build();

	static {
		client.start();
		lock = new InterProcessMutex(client, PATH);
		// lock = new InterProcessReadWriteLock(client, PATH);
		// readLock = lock.readLock();
		// writeLock = lock.writeLock();
	}

	public static void main(String[] args) throws Exception {

		// 锁等待时间
		String name = "123";
		int wait_time = 10;

		try {
			if (!lock.acquire(wait_time, TimeUnit.SECONDS)) {
				System.err.println(name + "等待" + wait_time
						+ "秒，仍未能获取到lock,准备放弃。");
			}
			// 模拟job执行时间0-2000毫秒
			int exeTime = new Random().nextInt(2000);
			System.out.println(name + "开始执行,预计执行时间= " + exeTime
					+ "毫秒----------");
			Thread.sleep(exeTime);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.release();
		}

		try {
			if (!lock.acquire(wait_time, TimeUnit.SECONDS)) {
				System.err.println(name + "等待" + wait_time
						+ "秒，仍未能获取到lock,准备放弃。");
			}
			// 模拟job执行时间0-2000毫秒
			int exeTime = new Random().nextInt(2000);
			System.out.println(name + "开始执行,预计执行时间= " + exeTime
					+ "毫秒----------");
			Thread.sleep(exeTime);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.release();
		}
	}
}
