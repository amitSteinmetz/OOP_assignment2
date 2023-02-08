//בס"ד
package m;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class Task<T> implements Callable<T>{
    private Callable<T> theTask;
    public int Pri;
    public TaskType type;
    
    public Callable<T> getTheTask() {
		return theTask;
	}
	public void setTheTask(Callable<T> theTask) {
		this.theTask = theTask;
	}
	public int getPri() {
		return this.Pri;
	}
	public void setPr(int Pri) {
		this.Pri = Pri;
	}
	public TaskType getType() {
		return type;
	}
	public void setType(TaskType type) {
		this.type = type;
	}
	public Task(Callable<T> theTask,TaskType type)
    {
        this.theTask = theTask;
        this.Pri = type.getPriorityValue();
        this.type = type;
        
    }

	public Task(Callable<T> theTask)
    {
        this.theTask = theTask;

        this.Pri = 3;
    }
    @Override
    public T call() throws Exception {
        try {
            return theTask.call();
        } catch (InterruptedException | ExecutionException RET) {
            throw new RuntimeException(RET);
      }
    }
    public static Task createTask(Callable Taskrn ,TaskType t)
    {
        return new Task(Taskrn,t);
    }
    public static Task createTask(Callable Taskrn)
    {
        return new Task(Taskrn);
    }

    



}
