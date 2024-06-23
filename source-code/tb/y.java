package tb;

import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class y extends q {
    private WeakReference<View> d;

    public View f() {
        WeakReference<View> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.d.get();
    }

    public void g(View view) {
        this.d = new WeakReference<>(view);
    }
}
