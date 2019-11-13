/**
 * Copyright (C), 2015-2019
 */
package com.zxb.proxy.web;

import com.zxb.proxy.data.DBService;
import com.zxb.proxy.data.MyService;
import com.zxb.proxy.data.target.DBServiceImpl;
import com.zxb.proxy.data.target.MyServiceImpl;
import com.zxb.proxy.dyna.ProxyHandler;
import com.zxb.proxy.sta.DBServiceImplProxy;
import com.zxb.proxy.sta.MyServiceImplProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

/**
 *
 * @author zhaoxb
 * @create 2019-11-13 19:58
 */
@RestController
@RequestMapping("/proxy")
public class ProxyController {

    @PostMapping("/static")
    public void staticProxy() {
        // 目标对象
        DBService target = new DBServiceImpl();
        // 通过目标对象获取代理对象
        DBServiceImplProxy proxy = new DBServiceImplProxy(target);
        // 通过代理对象执行目标方法
        proxy.add();
    }

    @PostMapping("/static2")
    public void staticProxy2() {
        MyService target = new MyServiceImpl();
        MyServiceImplProxy proxy = new MyServiceImplProxy(target);
        proxy.get();
    }


    @PostMapping("/dynamic")
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

    @PostMapping("/dynamic2")
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