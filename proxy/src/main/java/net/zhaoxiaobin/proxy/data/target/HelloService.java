package net.zhaoxiaobin.proxy.data.target;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxb
 * @date 2021-06-18 1:35 下午
 */
@Slf4j
public class HelloService {
    /**
     * 该方法不能被子类覆盖,Cglib是无法代理final修饰的方法的
     */
    public final void sayOthers() {
        log.info("sayOthers()");
    }

    public void sayHello() {
        log.info("sayHello()");
    }
}