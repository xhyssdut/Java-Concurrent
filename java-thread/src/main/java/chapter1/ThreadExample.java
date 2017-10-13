package chapter1;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by xin on 17/10/11.
 */

@Slf4j
public class ThreadExample {
    public static void main(String[] args) {
        log.info("this thread name:{}",Thread.currentThread().getName());
        for(int i =0;i<10;i++){
            new Thread(""+i){
                @Override
                public void run() {
                    log.info("Thread {} running",getName());
                }
            }.start();
        }
    }
}
