package chapter4.fairlock;

/**
 * Created by xin on 17/10/13.
 */
public class QueueObject {
    private boolean isNotified = false;
    public synchronized  void doWait() throws InterruptedException{
        while (!isNotified){
            this.wait();
        }
        this.isNotified = false;
    }
    public synchronized  void doNotify(){
        this.isNotified=true;
        this.notify();
    }
    public boolean equals(Object o){
        return this == o;
    }
}
