/**
 * Copyright (C), 2015-2019
 */
package net.zhaoxiaobin.proxy.data.target;

import net.zhaoxiaobin.proxy.data.MyService;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author zhaoxb
 * @create 2019-11-13 21:14
 */
@Slf4j
public class MyServiceImpl implements MyService {
    @Override
    public void get() {
        log.info("=====get()=====");
    }

    @Override
    public void set() {
        log.info("=====set()=====");
    }
}