//בס"ד
package m;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class TaskTester {

	public static org.junit.platform.commons.logging.Logger logger = LoggerFactory.getLogger(TaskTester.class);

	@Test
	public void partialTest(){

		CustomExecutor customExecutor = new CustomExecutor();
		Task task = Task.createTask(()->{
			int sum = 0;
			for (int i = 1; i <= 12; i++) {
				sum += i;
			}
			return sum;
		}, TaskType.COMPUTATIONAL);

		Future<?> sumTask = customExecutor.submit(task);
		final int sum;
		try {
			sum = (int) sumTask.get(1, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		logger.info(()-> "Sum of 1 through 12 = " + sum);
		Callable<Double> callable1 = ()-> {
			return 1000 * Math.pow(2, 2);
		};
		Callable<String> callable2 = ()-> {
			StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
			return sb.reverse().toString();
		};

		Future<Double> priceTask = customExecutor.submit(()-> {
			return 1000 * Math.pow(2, 5);
		}, TaskType.COMPUTATIONAL);
		Task task1 = Task.createTask(()->{
			int sum2 = 1;
			for (int i = 1; i <= 7; i++) {
				sum2 *= i;
			}
			return sum2;
		}, TaskType.COMPUTATIONAL);

		Future<Integer> sumTask2 = customExecutor.submit(task1 ,TaskType.IO);
		Future<String> reverseTask = customExecutor.submit(callable2, TaskType.IO);
		final String r2;
		final String r3;
		final String r4;
		final Double cheak;
		final Double cheak2;
		final String r;
		final int pow;
		final String a;

		Callable<String> serachChar = ()-> {
			StringBuilder sb = new StringBuilder("Ex2");

			return sb.insert(0 , 'a').toString();

		};

		Callable<String> c3 = ()-> {
			StringBuilder sb = new StringBuilder("usb");
			return sb.reverse().toString();

		};

		Future<Double> priceTask2 = customExecutor.submit(()-> {
			return 1000 * Math.pow(1.02, 5);
		}, TaskType.COMPUTATIONAL);
		Callable<String> c4 = ()-> {
			StringBuilder sb = new StringBuilder("Task Type");
			return sb.reverse().toString();

		};

		Future<String> reverseTask3 = customExecutor.submit(c4, TaskType.IO);
		Future<String> reverseTask2 = customExecutor.submit(c3, TaskType.IO);
		Future<String> reverseTask5 = customExecutor.submit(serachChar, TaskType.IO);
		int Ci = +customExecutor.getCurrentMax();


		Callable<String> callable5 = ()-> {
			StringBuilder sb = new StringBuilder("this is Task");
			return sb.reverse().toString();

		};
		Future<String> reverseTask4 = customExecutor.submit(callable5, TaskType.IO);
		try {
			cheak = priceTask.get();
			r = reverseTask.get();
			r2 = reverseTask2.get();
			r3 = reverseTask3.get();
			cheak2 = priceTask2.get();
			r4 = reverseTask4.get();
			pow = sumTask2.get();
			a = reverseTask5.get();

		} catch (Exception e) {
			throw new RuntimeException();
		}
		logger.info(()-> "currentMax= " +customExecutor.getCurrentMax());
		logger.info(()->String.valueOf("sum:" + cheak));
		logger.info(()-> "total of= " +cheak2);
		logger.info(()-> "reverse is = " + r);
		logger.info(()-> "reverse is = " + r2);
		logger.info(()-> "reverse is = " + r3);
		logger.info(()-> "reverse is = " + r4);
		logger.info(()-> "pow of = " + pow);
		logger.info(()-> "revers and insert is = " + a);
		customExecutor.dwon();
	}

}