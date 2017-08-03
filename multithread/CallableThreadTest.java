package multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadTest implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int i = 0;
		for (; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		return i;
	}

	public static void main(String[] args) {
		CallableThreadTest callableThreadTest = new CallableThreadTest();
		FutureTask<Integer> futureTask = new FutureTask<>(callableThreadTest);
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
			if (i == 20) {
				new Thread(futureTask, "有返回值的线程").start();
			}
		}
		try {
			System.out.println("子线程的返回值：" + futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

}
