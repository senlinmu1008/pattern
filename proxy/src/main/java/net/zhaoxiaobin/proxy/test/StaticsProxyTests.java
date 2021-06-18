package net.zhaoxiaobin.proxy.test;

import net.zhaoxiaobin.proxy.data.DBService;
import net.zhaoxiaobin.proxy.data.MyService;
import net.zhaoxiaobin.proxy.data.target.DBServiceImpl;
import net.zhaoxiaobin.proxy.data.target.MyServiceImpl;
import net.zhaoxiaobin.proxy.statics.DBServiceImplProxy;
import net.zhaoxiaobin.proxy.statics.MyServiceImplProxy;
import org.junit.Test;

/**
 * @author zhaoxb
 * @date 2021-06-18 1:38 下午
 */
public class StaticsProxyTests {
    @Test
    public void staticProxy() {
        // 目标对象
        DBService target = new DBServiceImpl();
        // 通过目标对象获取代理对象
        DBServiceImplProxy proxy = new DBServiceImplProxy(target);
        // 通过代理对象执行目标方法
        proxy.add();
    }

    @Test
    public void staticProxy2() {
        MyService target = new MyServiceImpl();
        MyServiceImplProxy proxy = new MyServiceImplProxy(target);
        proxy.get();
    }
}