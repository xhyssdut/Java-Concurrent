package chapter4.lock;

/**
 * Created by xin on 17/10/13.
 */
public class Synchronizer {
    Lock lock = new Lock();
    public void doSynchronizer()throws InterruptedException{
        lock.lock();
        lock.unlock();
    }

}
