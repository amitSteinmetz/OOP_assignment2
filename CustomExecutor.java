//בס"ד
package m;

import java.util.Vector;
import java.util.concurrent.*;
public class CustomExecutor extends ThreadPoolExecutor {
    private Vector<Integer> AllTask;
    public CustomExecutor() {
        super(Runtime.getRuntime().availableProcessors() / 2, Runtime.getRuntime().availableProcessors() - 1, 300, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<>());
        this.AllTask = new Vector<Integer>(10);
        for (int i = 0; i < 10; i++) {
            this.AllTask.add(0);
        }
    }


    public <T> theFuthreObject<T> submit(Callable<T> Callable, TaskType TaskType) {
        Task<T> n = new Task(Task.createTask(Callable , TaskType));
        theFuthreObject<T> nFuture = new theFuthreObject<>(n);
        AllTask.set(n.getPri()-1, AllTask.get(n.getPri()-1) + 1);
        execute(nFuture);
        return nFuture;
    }

    public <T> theFuthreObject<T> submit(Callable<T> Callable) {
        Task n = new Task(Task.createTask(Callable));
        theFuthreObject<T> nFuture = new theFuthreObject<>(n);
        AllTask.set(n.getPri() - 1, AllTask.get(n.getPri() - 1) + 1);
        execute(nFuture);
        return nFuture;

    }
    @Override
    protected void beforeExecute(Thread t, Runnable Runnable) {
        theFuthreObject t1 = (theFuthreObject) Runnable;
        AllTask.set(t1.Pri() - 1, AllTask.get(t1.Pri() - 1) - 1);
    }

    public int getCurrentMax() {
        int max = 0;
        for (int a = 0; a < AllTask.size(); a++) {
            if (AllTask.get(a) > 0) {
                max = a + 1;
                return max;
            }
        }
        return 10;
    }
    public void dwon() {
        shutdown();
    }
}
