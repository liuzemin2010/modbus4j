package com.net4iot.oss.infra.eventbus;

import java.util.concurrent.Executors;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

/**
 * @author chenwentao
 * @version 0.1
 * @date 2014-10-17
 * @fucntion <pre>
 * 实现异步发送通知数据总线
 * </pre>
 * 
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
