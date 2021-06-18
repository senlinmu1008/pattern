/**
 * Copyright (C), 2015-2019
 */
package net.zhaoxiaobin.proxy.statics;

import lombok.extern.slf4j.Slf4j;
import net.zhaoxiaobin.proxy.data.MyService;

/**
 * @author zhaoxb
 * @create 2019-11-13 21:18
 */
@Slf4j
public class MyServiceImplProxy implements MyService {
    /**
     * 代理类维护1个目标对象和切面对象
     */
    private MyService target;

    public MyServiceImplProxy(MyService target) {
        this.target = target;
    }

    @Override
    public void get() {
        log.info("=====切面-日志记录开始=====");
        target.get();
        log.info("=====切面-日志记录结束=====");
    }

    @Override
    public void set() {
        log.info("=====切面-日志记录开始=====");
        target.set();
        log.info("=====切面-日志记录结束=====");
    }
}