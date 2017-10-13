package chapter2;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by xin on 17/10/12.
 */
@Slf4j
public class Counter {
    long count = 0;
    public synchronized void add(long value){
        log.info("before count {}",count);
        this.count += value;
        log.info("after count {}",count);
    }

}
