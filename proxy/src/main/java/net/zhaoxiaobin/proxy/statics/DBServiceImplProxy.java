/**
 * Copyright (C), 2015-2019
 */
package net.zhaoxiaobin.proxy.statics;

import lombok.extern.slf4j.Slf4j;
import net.zhaoxiaobin.proxy.data.DBService;

/**
 * @author zhaoxb
 * @create 2019-11-13 19:49
 */
@Slf4j
public class DBServiceImplProxy implements DBService {
    /**
     * 代理类维护1个目标对象和切面对象
     */
    private DBService target;

    public DBServiceImplProxy(DBService target) {
        this.target = target;
    }

    @Override
    public void add() {
        log.info("=====切面-日志记录开始=====");
        target.add();
        log.info("=====切面-日志记录结束=====");
    }

    @Override
    public void delete() {
        log.info("=====切面-日志记录开始=====");
        target.delete();
        log.info("=====切面-日志记录结束=====");
    }

    @Override
    public void update() {
        log.info("=====切面-日志记录开始=====");
        target.update();
        log.info("=====切面-日志记录结束=====");
    }

    @Override
    public void query() {
        log.info("=====切面-日志记录开始=====");
        target.query();
        log.info("=====切面-日志记录结束=====");
    }
}