package tb;

import android.view.Choreographer;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: Taobao */
public final /* synthetic */ class xt0 implements Choreographer.FrameCallback {
    public final /* synthetic */ CancellableContinuation a;

    public /* synthetic */ xt0(CancellableContinuation cancellableContinuation) {
        this.a = cancellableContinuation;
    }

    public final void doFrame(long j) {
        yt0.e(this.a, j);
    }
}
