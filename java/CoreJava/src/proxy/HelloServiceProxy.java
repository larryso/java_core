package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloServiceProxy implements InvocationHandler {
	private Object target;

	/**
	 * 其中，bind方法中的newProxyInstanc方法，就是生成一个代理对象，第一个参数是类加载器，
	 * 第二个参数是真实委托对象所实现的的接口（代理对象挂在那个接口下），
	 * 第三个参数this代表当前HelloServiceProxy类，换句话说是使用HelloServiceProxy作为对象的代理。
	 */
	public Object bind(Object target, Class[] interfaces) {
		this.target = target;
		// 取得代理对象
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	/**
	 * * 同过代理对象调用方法首先进入这个方法. * @param proxy --代理对象 *
	 * 
	 * @param method
	 *            -- 方法,被调用方法. *
	 * @param args
	 *            -- 方法的参数
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.err.println("############我是JDK动态代理################");
		Object result = null;
		// 反射方法前调用
		System.err.println("我准备说hello。");
		// 反射执行方法 相当于调用target.sayHelllo();
		result = method.invoke(target, args);
		// 反射方法后调用.
		System.err.println("我说过hello了");
		return result;
	}

}
