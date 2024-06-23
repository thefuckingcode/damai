package tb;

import com.taobao.tao.log.utils.TLogThreadPool;
import java.util.concurrent.ThreadFactory;

/* compiled from: Taobao */
public final /* synthetic */ class mi2 implements ThreadFactory {
    public static final /* synthetic */ mi2 a = new mi2();

    private /* synthetic */ mi2() {
    }

    public final Thread newThread(Runnable runnable) {
        return TLogThreadPool.lambda$new$1(runnable);
    }
}
