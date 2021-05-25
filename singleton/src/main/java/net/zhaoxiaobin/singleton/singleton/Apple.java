package net.zhaoxiaobin.singleton.singleton;

/**
 * 饿汉式
 *
 * @author zhaoxb
 * @date 2021-05-10 11:05 下午
 */
public class Apple {
    private static volatile Apple apple = new Apple();

    private Apple() {

    }

    public static Apple getInstance() {
        return apple;
    }
}