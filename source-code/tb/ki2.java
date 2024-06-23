package tb;

import android.content.Intent;
import com.taobao.tao.log.utils.TLogMultiProcessReceiver;

/* compiled from: Taobao */
public final /* synthetic */ class ki2 implements Runnable {
    public final /* synthetic */ TLogMultiProcessReceiver a;
    public final /* synthetic */ Intent b;

    public /* synthetic */ ki2(TLogMultiProcessReceiver tLogMultiProcessReceiver, Intent intent) {
        this.a = tLogMultiProcessReceiver;
        this.b = intent;
    }

    public final void run() {
        TLogMultiProcessReceiver.a(this.a, this.b);
    }
}
