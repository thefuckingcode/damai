package tb;

import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
public class ss {
    public static boolean a(DXWidgetNode dXWidgetNode) {
        DXWidgetNode b = b(dXWidgetNode);
        DXRootView rootView = (dXWidgetNode == null || dXWidgetNode.getDXRuntimeContext() == null) ? null : dXWidgetNode.getDXRuntimeContext().getRootView();
        return rootView == null || rootView.getExpandWidgetNode() != b;
    }

    public static DXWidgetNode b(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode.getParentWidget() == null) {
            return dXWidgetNode;
        }
        return b(dXWidgetNode.getParentWidget());
    }
}
