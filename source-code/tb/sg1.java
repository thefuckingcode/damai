package tb;

import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.taobao.weex.common.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class sg1 implements ThreadFactory {
    private final AtomicInteger a;
    private final String b;
    private final int c;

    @JvmOverloads
    public sg1(@NotNull String str, int i) {
        k21.i(str, Constants.Name.PREFIX);
        this.b = str;
        this.c = i;
        this.a = new AtomicInteger(0);
    }

    @NotNull
    public Thread newThread(@NotNull Runnable runnable) {
        k21.i(runnable, UploadQueueMgr.MSGTYPE_REALTIME);
        Thread thread = new Thread(runnable);
        thread.setPriority(this.c);
        thread.setName(this.b + '-' + this.a.incrementAndGet());
        return thread;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sg1(String str, int i, int i2, m40 m40) {
        this(str, (i2 & 2) != 0 ? 5 : i);
    }
}
