package net.zhaoxiaobin.singleton.singleton;

/**
 * 饿汉式
 *
 * @author zhaoxb
 * @date 2021-05-10 11:05 下午
 */
public class Apple {
    private static Apple apple = new Apple();

    private static boolean isCreate = false;

    private Apple() {
        // 防止反射对单例的破坏
        if(isCreate) {
            throw new RuntimeException("已然被实例化一次，不能再实例化");
        }
        isCreate = true;
    }

    public static Apple getInstance() {
        return apple;
    }

    /**
     * 防止克隆对单例的破坏
     *
     * @return
     */
    @Override
    protected Object clone() {
        return apple;
    }

    /**
     * 防止序列化后对单例的破坏
     *
     * @return
     */
    private Object readResolve() {
        return apple;
    }
}