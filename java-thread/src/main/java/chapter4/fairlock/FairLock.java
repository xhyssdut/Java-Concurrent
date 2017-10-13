package chapter4.fairlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xin on 17/10/13.
 */
public class FairLock {
    private boolean isLocked = false;
    private Thread lockingThread = null;
    private List<QueueObject> waitingThreads = new ArrayList<>();

    public void lock() throws InterruptedException{
        QueueObject queueObject = new QueueObject();
        boolean isLockedForThisThread = true;
        synchronized (this){
            waitingThreads.add(queueObject);
        }
        while (isLockedForThisThread){
            synchronized (this){
                isLockedForThisThread = isLocked||waitingThreads.get(0)!=queueObject;
            }
            if(!isLockedForThisThread) {
                isLocked = true;
                waitingThreads.remove(queueObject);
                lockingThread = Thread.currentThread();
                return;
            }
            try {
                queueObject.wait();
            }catch (InterruptedException e){
                synchronized (this) {waitingThreads.remove(queueObject);}
                throw e;
            }
        }
    }

    public synchronized void unlock(){
        if(this.lockingThread!=Thread.currentThread()) {
            throw new IllegalMonitorStateException("calling thread has not locked this lock");
        }
        isLocked= false;
        lockingThread=null;
        if(waitingThreads.size()>0){
            waitingThreads.get(0).notify();
        }
    }
}