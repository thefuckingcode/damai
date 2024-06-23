package com.taobao.android.dinamicx.widget;

import com.taobao.android.dinamicx.DXRuntimeContext;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class g {
    public static void a(DXWidgetNode dXWidgetNode) {
        DXWidgetNode sourceWidget = dXWidgetNode.getSourceWidget();
        if (sourceWidget != null) {
            dXWidgetNode.setAutoId(d(sourceWidget));
            sourceWidget.setLastAutoId(sourceWidget.getLastAutoId() + 1);
            List<DXWidgetNode> children = dXWidgetNode.getChildren();
            if (children != null) {
                children.size();
            }
        }
    }

    public static DXWidgetNode b(DXWidgetNode dXWidgetNode, DXRuntimeContext dXRuntimeContext) {
        DXWidgetNode dXWidgetNode2 = (DXWidgetNode) dXWidgetNode.shallowClone(dXRuntimeContext, true);
        dXWidgetNode2.setSourceWidget(dXWidgetNode.getSourceWidget());
        a(dXWidgetNode2);
        if (dXWidgetNode.getChildren() != null) {
            dXWidgetNode2.children = new ArrayList();
            for (int i = 0; i < dXWidgetNode.getChildrenCount(); i++) {
                dXWidgetNode2.addChild(b(dXWidgetNode.getChildAt(i), dXRuntimeContext));
            }
        }
        return dXWidgetNode2;
    }

    public static DXWidgetNode c(DXWidgetNode dXWidgetNode, DXRuntimeContext dXRuntimeContext, boolean z) {
        DXWidgetNode dXWidgetNode2;
        DXWidgetNode dXWidgetNode3 = (DXWidgetNode) dXWidgetNode.shallowClone(dXRuntimeContext, true);
        dXWidgetNode3.setSourceWidget(dXWidgetNode.getSourceWidget());
        a(dXWidgetNode3);
        if (dXWidgetNode.getChildren() != null) {
            dXWidgetNode3.children = new ArrayList();
            for (int i = 0; i < dXWidgetNode.getChildrenCount(); i++) {
                DXWidgetNode childAt = dXWidgetNode.getChildAt(i);
                if (childAt instanceof DXTemplateWidgetNode) {
                    dXWidgetNode2 = ((DXTemplateWidgetNode) childAt).deepCopyChildNode(dXRuntimeContext);
                } else {
                    dXWidgetNode2 = c(childAt, dXRuntimeContext, z);
                }
                dXWidgetNode3.addChild(dXWidgetNode2, z);
            }
        }
        return dXWidgetNode3;
    }

    public static int d(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode == null) {
            return 0;
        }
        return (dXWidgetNode.getAutoId() << 16) + dXWidgetNode.getLastAutoId();
    }
}
