package chapter2;

/**
 * Created by xin on 17/10/12.
 */
public class CounterThread extends Thread{
    protected Counter counter = null;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            counter.add(i);
        }
    }
}
