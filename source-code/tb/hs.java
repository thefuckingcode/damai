package tb;

import android.view.View;
import android.view.ViewGroup;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public abstract class hs {
    public abstract void a(DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2);

    /* access modifiers changed from: protected */
    public void b(WeakReference<View> weakReference) {
        if (weakReference != null) {
            View view = weakReference.get();
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeAllViews();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c(WeakReference<View> weakReference) {
        View view;
        if (weakReference != null && (view = weakReference.get()) != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
