package thread;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args){
		TestIn t = new TestIn();
	}

}
class TestIn{
	{
		String classPath = this.getClass().getClassLoader().getResource("").getFile();
		System.out.println(classPath);
	}
}
