//בס"ד
package m;
import java.util.concurrent.FutureTask;

public class theFuthreObject<T> extends FutureTask<T> implements Comparable<theFuthreObject<T>> {
    private Task<T> T;
    private int Pri;
    public theFuthreObject(Task<T> Task) {
        super(Task);
        this.T = Task;
        this.Pri = Task.Pri;
    }

    public int Pri()
    {
        return this.Pri;
    }
    @Override
    public int compareTo(theFuthreObject<T> other){
        return  Integer.valueOf(other.Pri).compareTo(Integer.valueOf(this.Pri));

    }
    public Task<T> getTask(){
        return this.T;
    }
}