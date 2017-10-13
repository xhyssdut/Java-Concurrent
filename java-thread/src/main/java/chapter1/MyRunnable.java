package chapter1;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by xin on 17/10/11.
 */

@Slf4j
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("runnable naming {} running",Thread.currentThread().getName());
    }
}
