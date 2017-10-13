package chapter3;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by xin on 17/10/12.
 */
@Slf4j
public class ThreadLocalExample {
    public static class MyRunnable implements Runnable{
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set((int)(Math.random()*100));
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                log.error("sleep error ",e);
            }
            log.info(threadLocal.get().toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();
    }
}
