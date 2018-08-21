package thread;

public class SynchronizedDemo implements Runnable{
	
	private static int counter = 0;
	
	private synchronized void increase(){
		synchronized(this){
			counter ++;
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		increase();
	}
	public static void main(String[] args) throws InterruptedException{
		for(int i=0;i<1000000;i++){
			Thread t = new Thread(new SynchronizedDemo());
			t.start();
		}
		Thread.sleep(300);
		System.out.println(counter);
	}

}
