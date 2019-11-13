/**
 * Copyright (C), 2015-2019
 */
package com.zxb.proxy.sta;

import com.zxb.proxy.aspect.LogAspect;
import com.zxb.proxy.data.DBService;

/**
 *
 * @author zhaoxb
 * @create 2019-11-13 19:49
 */
public class DBServiceImplProxy implements DBService {
    /*
    代理类维护1个目标对象和切面对象
     */
    private DBService target;
    private LogAspect logAspect;

    public DBServiceImplProxy(DBService target) {
        this.target = target;
        this.logAspect = new LogAspect();
    }

    public DBServiceImplProxy(DBService target, LogAspect logAspect) {
        this.target = target;
        this.logAspect = logAspect;
    }

    @Override
    public void add() {
        logAspect.doBefore();
        target.add();
        logAspect.doAfter();
    }

    @Override
    public void delete() {
        logAspect.doBefore();
        target.delete();
        logAspect.doAfter();
    }

    @Override
    public void update() {
        logAspect.doBefore();
        target.update();
        logAspect.doAfter();
    }

    @Override
    public void query() {
        logAspect.doBefore();
        target.query();
        logAspect.doAfter();
    }
}