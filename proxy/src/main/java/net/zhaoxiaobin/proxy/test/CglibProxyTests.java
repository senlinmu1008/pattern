package net.zhaoxiaobin.proxy.test;

import net.zhaoxiaobin.proxy.cglib.MyMethodInterceptor;
import net.zhaoxiaobin.proxy.data.target.HelloService;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author zhaoxb
 * @date 2021-06-18 1:40 下午
 */
public class CglibProxyTests {
    @Test
    public void cglibProxy() {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/zhaoxiaobin/Desktop/");

        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();

        // 设置enhancer对象的父类
        enhancer.setSuperclass(HelloService.class);

        // 设置enhancer的回调对象
        enhancer.setCallback(new MyMethodInterceptor());

        // 创建代理对象，动态生成目标类的子类
        HelloService proxy = (HelloService) enhancer.create();

        // 通过代理对象调用目标方法
        proxy.sayHello();
        proxy.sayOthers();
    }
}