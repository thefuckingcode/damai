package tb;

import android.webkit.ValueCallback;
import cn.damai.h5container.DMH5Fragment;

/* compiled from: Taobao */
public final /* synthetic */ class uq implements ValueCallback {
    public static final /* synthetic */ uq a = new uq();

    private /* synthetic */ uq() {
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        DMH5Fragment.m29showDetectView$lambda7((String) obj);
    }
}
