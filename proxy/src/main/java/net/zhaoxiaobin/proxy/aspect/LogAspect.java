/**
 * Copyright (C), 2015-2019
 */
package net.zhaoxiaobin.proxy.aspect;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author zhaoxb
 * @create 2019-11-13 19:47
 */
@Slf4j
public class LogAspect {
    public void doBefore() {
        log.info("=====切面-日志记录开始=====");
    }

    public void doAfter() {
        log.info("=====切面-日志记录结束=====");
    }
}