package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPoolExecutorTest {
	public static void main(String[] args){
		BlockingQueue<Runnable> bq = new ArrayBlockingQueue<Runnable>(10);
	}

}
class TempThread implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" executed..");
		try{
			Thread.sleep(200);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}