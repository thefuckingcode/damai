package tb;

import android.view.View;
import com.taobao.android.dinamicx.videoc.core.IDXVideoController;
import com.taobao.android.dinamicx.videoc.core.listener.IDXVideoListener;
import com.taobao.android.dinamicx.videoc.expose.core.listener.ExposureLifecycle;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: Taobao */
public final class l10 implements ExposureLifecycle<Integer, WeakReference<View>> {
    private final IDXVideoController<xv2, IDXVideoListener> a;
    private final float b;
    private final boolean c;

    public l10(IDXVideoController<xv2, IDXVideoListener> iDXVideoController, float f, boolean z) {
        this.a = iDXVideoController;
        this.b = Math.min(f, 1.0f);
        this.c = z;
    }

    /* renamed from: a */
    public void onAfterCancelDataExpose(Integer num, WeakReference<View> weakReference, String str) {
        this.a.deleteVideo(new xv2(num.intValue(), -1, weakReference), str);
    }

    /* renamed from: b */
    public boolean onBeforeExposeData(Integer num, WeakReference<View> weakReference, String str) {
        return false;
    }

    /* renamed from: c */
    public void onDataExpose(Integer num, WeakReference<View> weakReference, String str) {
        this.a.appendVideo(new xv2(num.intValue(), System.currentTimeMillis(), weakReference), str);
    }

    /* renamed from: d */
    public boolean onValidateExposeData(Integer num, WeakReference<View> weakReference, String str, Map<Integer, WeakReference<View>> map) {
        IDXVideoController<xv2, IDXVideoListener> iDXVideoController;
        View view = weakReference.get();
        if (view == null) {
            return false;
        }
        boolean a2 = mw2.a(view, this.b);
        if (this.c && !a2 && (iDXVideoController = this.a) != null) {
            iDXVideoController.deleteVideo(new xv2(num.intValue(), -1, weakReference), str);
        }
        return a2;
    }
}
