package proxy;

public class HelloServiceImpl implements HelloService{

	@Override
	public void sayHello(String msg) {
		System.out.println(msg);
		
	}

}
