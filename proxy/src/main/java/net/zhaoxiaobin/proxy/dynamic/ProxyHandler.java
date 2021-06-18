/**
 * Copyright (C), 2015-2019
 */
package net.zhaoxiaobin.proxy.dynamic;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhaoxb
 * @create 2019-11-13 20:43
 */
@Slf4j
public class ProxyHandler implements InvocationHandler {
    /**
     * 代理类维护1个目标对象和切面对象
     * 由于目标对象是Object类型，所以比静态代理来的更灵活，目标类可以实现不同接口
     */
    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("=====切面-日志记录开始=====");
        // 执行目标方法
        Object result = method.invoke(target, args);
        log.info("=====切面-日志记录结束=====");
        return result;
    }
}