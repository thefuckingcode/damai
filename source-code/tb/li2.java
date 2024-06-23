package tb;

import com.taobao.tao.log.utils.TLogThreadPool;
import java.util.concurrent.ThreadFactory;

/* compiled from: Taobao */
public final /* synthetic */ class li2 implements ThreadFactory {
    public static final /* synthetic */ li2 a = new li2();

    private /* synthetic */ li2() {
    }

    public final Thread newThread(Runnable runnable) {
        return TLogThreadPool.lambda$new$2(runnable);
    }
}
