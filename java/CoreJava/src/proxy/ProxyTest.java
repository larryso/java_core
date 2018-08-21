package proxy;

public class ProxyTest {
	public static void main(String[] args) {
		HelloServiceProxy proxy = new HelloServiceProxy();
		HelloService service = new HelloServiceImpl();
		//绑定代理对象。 
		service = (HelloService) proxy.bind(service, new Class[] {HelloService.class});
		service.sayHello("Hello Larry!");
	}

}
