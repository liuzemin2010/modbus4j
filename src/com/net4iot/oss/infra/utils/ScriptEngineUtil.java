package com.net4iot.oss.infra.utils;

import java.util.Map;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServlet;

/**
 * <pre>
 * 作用:
 * javascript脚本引擎
 * 注意:
 * 其他:
 * </pre>
 * 
 * @author chenwentao
 * @version 1.0, 2015-10-9
 * @see
 * @since
 */
public class ScriptEngineUtil extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final ScriptEngineManager MANAGER = new ScriptEngineManager();

	private static final ScriptEngine ENGINE = MANAGER
			.getEngineByName("javascript");

	private static final ThreadLocal<ScriptEngine> threadLocal = new ThreadLocal<ScriptEngine>() {
		@Override
		protected ScriptEngine initialValue() {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("javascript");

			return engine;
		}

	};

	/**
	 * 同步方法执行脚本
	 * 
	 * @param values
	 * @param expression
	 * @return
	 * @throws ScriptException
	 */
	@SuppressWarnings("unchecked")
	public static synchronized <T> T eval(Map<String, String> values,
			String expression) throws ScriptException {
		for (Map.Entry<String, String> entry : values.entrySet()) {
			ENGINE.put(entry.getKey(), entry.getValue());
		}

		return (T) ENGINE.eval(expression);
	}

	/**
	 * 解析javascript
	 * 
	 * @param script
	 * @param data
	 * @param fport
	 * @param method
	 * @return
	 * @throws Exception
	 */
	public static String InvokeScriptMethod(String script, String data,
			String fport, String method) throws Exception {
		String result = null;
		threadLocal.get().eval(script);
		Invocable inv = (Invocable) threadLocal.get();
		result = (String) inv.invokeFunction(method, data, fport);
		return result;
	}

	/**
	 * 用真实数据替换表达式
	 * 
	 * @param values
	 * 
	 * @param expression
	 * 
	 * @return
	 */
	public static String replace(Map<String, String> values, String expression) {
		for (Map.Entry<String, String> val : values.entrySet()) {
			expression = expression.replace(val.getKey(), val.getValue());
		}

		return expression;
	}

	public static void main(String[] args) throws Exception {

		// String expression = " (x>10) && (y>10)";
		// Map<String, String> maps = new HashMap<String, String>();
		// maps.put("x", "100");
		// maps.put("y", "200");
		// System.out.println(ScriptEngineUtil.eval(maps, expression));

		// ScriptEngineManager factory = new ScriptEngineManager();
		// ScriptEngine engine = factory.getEngineByName("JavaScript");
		// new Thread(new TestThread(1, engine)).start();
		// new Thread(new TestThread(2, engine)).start();

		long startTime = 0;
		// 前置通知 记录开始时间
		startTime = System.currentTimeMillis();
		for (int i = 0; i <= 10000; i++) {
			// String script =
			// "function hello(name) { return 'result,' + name;}";
			String script = "function callback(name) { var a = name.substring(0,2); var b = name.substring(2,4); return 'a=' + a + ',b=' + b;}";
			InvokeScriptMethod(script, "1001", "2", "callback");
		}

		// 后置通知
		long endTime = System.currentTimeMillis();// 记录结束时间
		float excTime = (float) (endTime - startTime) / 1000;
		System.out.println("执行时间:" + excTime + "s");

		/*
		 * String expression = "x>10 && y<10"; String value = null; Map<String,
		 * String> maps = new HashMap<String, String>(); maps.put("x", "100");
		 * maps.put("y", "200"); for (Map.Entry<String, String> val :
		 * maps.entrySet()) { expression = expression.replace(val.getKey(),
		 * val.getValue()); } System.out.println(expression);
		 */

		/*
		 * Map<String,Object> values=new HashMap<String,Object>();
		 * values.put("x", "1");
		 * System.out.println((Boolean)ScriptEngineUtil.eval
		 * (values,"var str='水位';if(x==0){return '不达标'}else{return '达标'}"));
		 */
		// long begin = System.currentTimeMillis();
		//
		// Thread thread = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// try {
		// ScriptEngineUtil.eval("4");
		// } catch (ScriptException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// }
		// });
		// thread.start();
		//
		// Boolean boolea11n = eval("2");
		//
		// for (int i = 0; i < 10000; i++) {
		// eval("2");
		// }
		// System.out.println((System.currentTimeMillis() - begin) / 1000);
	}
}
