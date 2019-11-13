/**
 * Copyright (C), 2015-2019
 */
package com.zxb.proxy.data.target;

import com.zxb.proxy.data.MyService;
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