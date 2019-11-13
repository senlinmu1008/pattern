/**
 * Copyright (C), 2015-2019
 */
package com.zxb.proxy.data.target;

import com.zxb.proxy.data.DBService;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author zhaoxb
 * @create 2019-11-13 19:45
 */
@Slf4j
public class DBServiceImpl implements DBService {
    @Override
    public void add() {
        log.info("=====add()=====");
    }

    @Override
    public void delete() {
        log.info("=====delete()=====");
    }

    @Override
    public void update() {
        log.info("=====update()=====");
    }

    @Override
    public void query() {
        log.info("=====query()=====");
    }
}