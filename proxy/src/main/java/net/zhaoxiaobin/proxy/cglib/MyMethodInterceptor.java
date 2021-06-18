package net.zhaoxiaobin.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhaoxb
 * @date 2021-06-18 1:42 下午
 */
@Slf4j
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("=====切面-日志记录开始=====");
        Object object = methodProxy.invokeSuper(o, objects);
        log.info("=====切面-日志记录结束=====");
        return object;
    }
}