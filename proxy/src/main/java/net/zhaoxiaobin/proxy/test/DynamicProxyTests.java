/**
 * Copyright (C), 2015-2019
 */
package net.zhaoxiaobin.proxy.test;

import net.zhaoxiaobin.proxy.data.DBService;
import net.zhaoxiaobin.proxy.data.MyService;
import net.zhaoxiaobin.proxy.data.target.DBServiceImpl;
import net.zhaoxiaobin.proxy.data.target.MyServiceImpl;
import net.zhaoxiaobin.proxy.dynamic.ProxyHandler;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author zhaoxb
 * @date 2021-06-18 1:38 下午
 */
public class DynamicProxyTests {
    @Test
    public void dynamicProxy() {
        // 目标对象
        DBService target = new DBServiceImpl();
        // 目标对象的类对象
        Class<? extends DBService> clazz = target.getClass();
        // 通过虚拟机底层机制获取代理对象
        DBService proxy = (DBService) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                new ProxyHandler(target));
        proxy.delete();
    }

    @Test
    public void dynamicProxy2() {
        MyService target = new MyServiceImpl();
        Class<? extends MyService> clazz = target.getClass();
        MyService proxy = (MyService) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                new ProxyHandler(target)
        );
        proxy.set();
    }
}