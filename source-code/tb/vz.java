package tb;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.videoc.core.IDXVideoController;
import com.taobao.android.dinamicx.videoc.core.listener.IDXVideoListener;
import com.taobao.android.dinamicx.videoc.expose.core.IExposure;
import com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class vz implements RecyclerViewZone.OnRecyclerViewExposeCallback<Integer, WeakReference<View>> {
    private final IDXVideoController<xv2, IDXVideoListener> a;
    private final boolean b;
    private final boolean c;
    private final boolean d;

    public vz(@Nullable IDXVideoController<xv2, IDXVideoListener> iDXVideoController) {
        this(iDXVideoController, false, false, false);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone.OnRecyclerViewExposeCallback
    public void onChildAttachExpose(IExposure<Integer, WeakReference<View>> iExposure, String str, RecyclerView recyclerView, View view) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        WeakReference<View> weakReference = new WeakReference<>(view);
        iExposure.storeExposeData(Integer.valueOf(childAdapterPosition), weakReference);
        if (!this.c) {
            iExposure.expose(Integer.valueOf(childAdapterPosition), weakReference, str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone.OnRecyclerViewExposeCallback
    public void onChildDetachExpose(IExposure<Integer, WeakReference<View>> iExposure, String str, RecyclerView recyclerView, View view) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != -1) {
            iExposure.removeExposeData(Integer.valueOf(childAdapterPosition), str);
            if (this.c) {
                iExposure.cancelExpose(Integer.valueOf(childAdapterPosition), str, false);
                IDXVideoController<xv2, IDXVideoListener> iDXVideoController = this.a;
                if (iDXVideoController != null) {
                    iDXVideoController.deleteVideo(new xv2(childAdapterPosition, -1, new WeakReference(view)), str, false);
                    return;
                }
                return;
            }
            iExposure.cancelExpose(Integer.valueOf(childAdapterPosition), str);
        } else if (this.a != null) {
            for (Integer num : iExposure.removeAllExposeData().keySet()) {
                View findViewByPosition = recyclerView.getLayoutManager().findViewByPosition(num.intValue());
                if (findViewByPosition == null || recyclerView.getChildAdapterPosition(findViewByPosition) != num.intValue()) {
                    iExposure.cancelExpose(num, str, false);
                } else {
                    iExposure.storeExposeData(num, new WeakReference<>(findViewByPosition));
                }
            }
            this.a.clearVideos(str);
            iExposure.triggerExpose(str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone.OnRecyclerViewExposeCallback
    public void onScrollExpose(IExposure<Integer, WeakReference<View>> iExposure, String str, RecyclerView recyclerView, int i, int i2) {
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone.OnRecyclerViewExposeCallback
    public void onScrollStateChangeExpose(IExposure<Integer, WeakReference<View>> iExposure, String str, RecyclerView recyclerView, int i) {
        if (this.b || i != 0) {
            return;
        }
        if (this.d) {
            iExposure.triggerExposeAtOnce(str);
        } else {
            iExposure.exposeCache();
        }
    }

    public vz(@Nullable IDXVideoController<xv2, IDXVideoListener> iDXVideoController, boolean z, boolean z2, boolean z3) {
        this.a = iDXVideoController;
        this.b = z;
        this.c = z2;
        this.d = z3;
    }
}
