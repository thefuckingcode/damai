package tb;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.videoc.core.IDXVideoFinder;
import com.taobao.android.dinamicx.videoc.core.listener.IDXVideoListener;
import com.taobao.android.dinamicx.view.DXRootNativeFrameLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class m10 implements IDXVideoFinder<xv2, IDXVideoListener> {
    @NonNull
    private final Map<String, List<Class<? extends DXWidgetNode>>> a;

    public m10(@NonNull Map<String, List<Class<? extends DXWidgetNode>>> map) {
        this.a = map;
    }

    private View a(View view, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (cls.isInstance(view)) {
                return view;
            }
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View a2 = a(viewGroup.getChildAt(i), clsArr);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    private List<IDXVideoListener> b(@NonNull DXWidgetNode dXWidgetNode, @NonNull String str) {
        ArrayList arrayList = new ArrayList();
        if (e(dXWidgetNode, str)) {
            if (!at.J0(dXWidgetNode.getDXRuntimeContext().getBizType()) || !dXWidgetNode.isFlatten()) {
                arrayList.add((IDXVideoListener) dXWidgetNode);
            } else {
                DXWidgetNode referenceNode = dXWidgetNode.getReferenceNode();
                if (referenceNode != null) {
                    arrayList.add((IDXVideoListener) referenceNode);
                }
            }
        }
        List<DXWidgetNode> children = dXWidgetNode.getChildren();
        if (children == null) {
            return arrayList;
        }
        for (DXWidgetNode dXWidgetNode2 : children) {
            arrayList.addAll(b(dXWidgetNode2, str));
        }
        return arrayList;
    }

    private DXWidgetNode d(@NonNull View view) {
        if (view instanceof DXRootView) {
            return ((DXRootView) view).getFlattenWidgetNode();
        }
        Object tag = view.getTag(DXWidgetNode.TAG_WIDGET_NODE);
        if (tag instanceof DXWidgetNode) {
            return (DXWidgetNode) tag;
        }
        return null;
    }

    private boolean e(Object obj, @NonNull String str) {
        List<Class<? extends DXWidgetNode>> list = this.a.get(str);
        if (!(obj instanceof IDXVideoListener) || list == null) {
            return false;
        }
        for (Class<? extends DXWidgetNode> cls : list) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    /* renamed from: c */
    public List<IDXVideoListener> findVideos(@NonNull xv2 xv2, @NonNull String str) {
        View a2;
        DXWidgetNode d;
        View c = xv2.c();
        if (c == null || (a2 = a(c, new Class[]{DXRootView.class, DXRootNativeFrameLayout.class})) == null || (d = d(a2)) == null) {
            return null;
        }
        return b(d, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoFinder
    public Collection<String> scenes() {
        return this.a.keySet();
    }
}
