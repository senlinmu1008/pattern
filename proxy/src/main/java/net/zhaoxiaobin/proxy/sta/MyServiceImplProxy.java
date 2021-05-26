/**
 * Copyright (C), 2015-2019
 */
package net.zhaoxiaobin.proxy.sta;

import net.zhaoxiaobin.proxy.aspect.LogAspect;
import net.zhaoxiaobin.proxy.data.MyService;

/**
 * @author zhaoxb
 * @create 2019-11-13 21:18
 */
public class MyServiceImplProxy implements MyService {
    /**
     * 代理类维护1个目标对象和切面对象
     */
    private MyService target;
    private LogAspect logAspect;

    public MyServiceImplProxy(MyService target) {
        this.target = target;
        this.logAspect = new LogAspect();
    }

    public MyServiceImplProxy(MyService target, LogAspect logAspect) {
        this.target = target;
        this.logAspect = logAspect;
    }

    @Override
    public void get() {
        logAspect.doBefore();
        target.get();
        logAspect.doAfter();
    }

    @Override
    public void set() {
        logAspect.doBefore();
        target.set();
        logAspect.doAfter();
    }
}