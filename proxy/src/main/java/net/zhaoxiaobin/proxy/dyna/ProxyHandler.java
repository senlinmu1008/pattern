/**
 * Copyright (C), 2015-2019
 */
package net.zhaoxiaobin.proxy.dyna;

import net.zhaoxiaobin.proxy.aspect.LogAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhaoxb
 * @create 2019-11-13 20:43
 */
public class ProxyHandler implements InvocationHandler {
    /**
     * 代理类维护1个目标对象和切面对象
     * 由于目标对象是Object类型，所以比静态代理来的更灵活，目标类可以实现不同接口
     */
    private Object target;
    private LogAspect logAspect;

    public ProxyHandler(Object target) {
        this.target = target;
        this.logAspect = new LogAspect();
    }

    public ProxyHandler(Object target, LogAspect logAspect) {
        this.target = target;
        this.logAspect = logAspect;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logAspect.doBefore();
        // 执行目标方法
        Object result = method.invoke(target, args);
        logAspect.doAfter();
        return result;
    }
}