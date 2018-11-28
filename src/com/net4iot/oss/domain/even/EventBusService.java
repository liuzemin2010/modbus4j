package com.net4iot.oss.domain.even;

import java.util.concurrent.Executors;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

/**
 * 
 *<pre>
 * 作用:实现异步发送通知数据总线
 * 注意:
 * 其他:
 *</pre>
 *
 * @author  yanglijuan
 * @version 1.0, 2017年11月30日
 * @see     
 * @since
 */
public class EventBusService {

	private static EventBusService instance = new EventBusService();

	public static EventBusService getInstance() {
		return instance;
	}

	private EventBus eventBus = null;

	private EventBusService() {
		eventBus = new AsyncEventBus(Executors.newCachedThreadPool());
	}

	public void registerSubscriber(Object subscriber) {
		eventBus.register(subscriber);
	}

	public void unRegisterSubscriber(Object subscriber) {
		eventBus.unregister(subscriber);
	}

	public void postEvent(Object e) {
		eventBus.post(e);
	}
}
