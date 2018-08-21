package thread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		// declare a blocking queue with size 10
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(producer1);
		service.execute(producer2);
		service.execute(producer3);
		service.execute(consumer);
		Thread.sleep(10 * 1000);
		producer1.stop();
		producer2.stop();
		producer3.stop();
		Thread.sleep(2000);
		service.shutdown();
	}

}

class Producer implements Runnable {
	private volatile boolean isRunning = true;
	private BlockingQueue queue;
	private static AtomicInteger count = new AtomicInteger();
	private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

	public Producer(BlockingQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		String data = null;
		Random r = new Random();
		System.out.println("Start Producer....");
		try {
			while (isRunning) {
				System.out.println("Producing data...");
				Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
				data = "data:" + count.incrementAndGet();
				System.out.println("will put data: " + data + " in Queue");
				if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
					System.out.println("data failed in Queue");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		} finally {
			System.out.println("producer quit");
		}
	}

	public void stop() {
		isRunning = false;
	}
}

class Consumer implements Runnable {
	private BlockingQueue<String> queue;
	private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println("Start consumer...");
		Random r = new Random();
		boolean isRunning = true;
		try {
			while (isRunning) {
				System.out.println("Will get data from Queue");
				String data = queue.poll(2, TimeUnit.SECONDS);
				if (null != data) {
					System.out.println("get data:" + data);
					Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
				} else {
					isRunning = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		} finally {
			System.out.println("Consumer quit");
		}
	}

}
