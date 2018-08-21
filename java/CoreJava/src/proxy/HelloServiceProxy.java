package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloServiceProxy implements InvocationHandler {
	private Object target;

	/**
	 * ���У�bind�����е�newProxyInstanc��������������һ��������󣬵�һ�����������������
	 * �ڶ�����������ʵί�ж�����ʵ�ֵĵĽӿڣ������������Ǹ��ӿ��£���
	 * ����������this����ǰHelloServiceProxy�࣬���仰˵��ʹ��HelloServiceProxy��Ϊ����Ĵ���
	 */
	public Object bind(Object target, Class[] interfaces) {
		this.target = target;
		// ȡ�ô������
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	/**
	 * * ͬ�����������÷������Ƚ����������. * @param proxy --������� *
	 * 
	 * @param method
	 *            -- ����,�����÷���. *
	 * @param args
	 *            -- �����Ĳ���
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.err.println("############����JDK��̬����################");
		Object result = null;
		// ���䷽��ǰ����
		System.err.println("��׼��˵hello��");
		// ����ִ�з��� �൱�ڵ���target.sayHelllo();
		result = method.invoke(target, args);
		// ���䷽�������.
		System.err.println("��˵��hello��");
		return result;
	}

}
