package anet.channel.strategy;

/* compiled from: Taobao */
public class a {
    private static volatile IStrategyInstance a;

    private a() {
    }

    public static IStrategyInstance a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new StrategyInstance();
                }
            }
        }
        return a;
    }
}
