package net.zhaoxiaobin.singleton.singleton;

/**
 * @author zhaoxb
 * @date 2021-05-25 22:23
 */
public class Banana {
    private static volatile Banana banana;

    private Banana() {

    }

    public static Banana getInstance() {
        if (banana == null) {
            synchronized (Banana.class) {
                if (banana == null) {
                    banana = new Banana();
                }
            }
        }
        return banana;
    }
}