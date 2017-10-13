package chapter1;

import lombok.extern.slf4j.Slf4j;


/**
 * Created by xin on 17/10/11.
 */

@Slf4j
public class Application {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        log.info("doing something");
        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();
        log.info("doing something again");
    }
}
