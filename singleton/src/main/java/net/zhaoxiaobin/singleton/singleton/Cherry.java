package net.zhaoxiaobin.singleton.singleton;

/**
 * 静态内部类
 *
 * @author zhaoxb
 * @date 2021-05-25 22:39
 */
public class Cherry {
    private static class CherryHolder {
        private static Cherry instance = new Cherry();
    }

    private Cherry() {

    }

    /**
     * 当getInstance方法第一次被调用的时候，执行CherryHolder.instance，导致CherryHolder类得到初始化；
     * 而这个类在装载并被初始化的时候，会初始化它的静态域，从而创建Cherry的实例，
     * 由于是静态的域，因此只会在虚拟机装载类的时候初始化一次，并由虚拟机来保证它的线程安全性。
     */
    public static Cherry getInstance() {
        return CherryHolder.instance;
    }
}