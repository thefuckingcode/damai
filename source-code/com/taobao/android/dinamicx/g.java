package com.taobao.android.dinamicx;

import android.view.View;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.d;
import com.taobao.android.dinamicx.widget.f;
import java.util.Iterator;
import tb.d00;
import tb.vx;

/* compiled from: Taobao */
public class g {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0088 A[EDGE_INSN: B:88:0x0088->B:33:0x0088 ?: BREAK  , SYNTHETIC] */
    private void a(DXWidgetNode dXWidgetNode, int i, int i2, int i3, int i4, DXWidgetNode dXWidgetNode2, boolean z, boolean z2, boolean z3, int i5, float f) {
        boolean z4;
        int i6;
        int i7;
        int i8;
        int i9;
        DXWidgetNode dXWidgetNode3;
        float f2;
        int i10;
        int i11;
        DXWidgetNode dXWidgetNode4 = null;
        if (dXWidgetNode == null || dXWidgetNode.getVisibility() != 0) {
            dXWidgetNode.setReferenceNode(null);
            return;
        }
        boolean hasCornerRadius = dXWidgetNode.hasCornerRadius();
        int accessibility = dXWidgetNode.getAccessibility();
        boolean hasAccessibilityOn = dXWidgetNode.hasAccessibilityOn();
        int i12 = 0;
        boolean z5 = dXWidgetNode.getChildrenCount() > 0;
        if (z3 || !z5) {
            z4 = z3;
        } else {
            z4 = hasCornerRadius || ((f) dXWidgetNode).isDisableFlatten() || ((dXWidgetNode instanceof DXTemplateWidgetNode) && ((DXTemplateWidgetNode) dXWidgetNode).isSticky());
            if (!z4) {
                int measuredWidth = dXWidgetNode.getMeasuredWidth();
                int measuredHeight = dXWidgetNode.getMeasuredHeight();
                Iterator<DXWidgetNode> it = dXWidgetNode.getChildren().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        DXWidgetNode next = it.next();
                        if (next.getLeft() < 0 || next.getTop() < 0 || next.getLeft() + next.getMeasuredWidth() > measuredWidth || next.getTop() + next.getMeasuredHeight() > measuredHeight) {
                            z4 = true;
                        }
                        if (!it.hasNext()) {
                            break;
                        }
                    }
                }
                z4 = true;
            }
        }
        boolean z6 = !z5 || z4 || hasAccessibilityOn || dXWidgetNode.getBackGroundColor() != 0 || (dXWidgetNode.getBorderWidth() > 0 && dXWidgetNode.getBorderColor() != 0) || ((dXWidgetNode.getEventHandlersExprNode() != null && dXWidgetNode.getEventHandlersExprNode().size() > 0) || dXWidgetNode.getBackgroundGradient() != null);
        if (z6) {
            int left = i + dXWidgetNode.getLeft();
            int top = i2 + dXWidgetNode.getTop();
            int measuredWidth2 = dXWidgetNode.getMeasuredWidth() + left;
            int measuredHeight2 = dXWidgetNode.getMeasuredHeight() + top;
            DXWidgetNode dXWidgetNode5 = (DXWidgetNode) dXWidgetNode.shallowClone(dXWidgetNode.getDXRuntimeContext(), false);
            dXWidgetNode.setReferenceNode(dXWidgetNode5);
            dXWidgetNode5.setReferenceNode(dXWidgetNode);
            dXWidgetNode5.setLeft(left);
            dXWidgetNode5.setTop(top);
            dXWidgetNode5.setRight(measuredWidth2);
            dXWidgetNode5.setBottom(measuredHeight2);
            i7 = measuredWidth2;
            i6 = measuredHeight2;
            i8 = top;
            i9 = left;
            dXWidgetNode4 = dXWidgetNode5;
        } else {
            i9 = i + dXWidgetNode.getLeft();
            i8 = i2 + dXWidgetNode.getTop();
            dXWidgetNode.setReferenceNode(null);
            i7 = dXWidgetNode.getMeasuredWidth() + i9;
            i6 = dXWidgetNode.getMeasuredHeight() + i8;
        }
        int enabled = i5 & dXWidgetNode.getEnabled();
        float alpha = dXWidgetNode.getAlpha() * f;
        if (z6) {
            dXWidgetNode4.setFlatten(true);
            dXWidgetNode3 = dXWidgetNode2;
            dXWidgetNode3.addChild(dXWidgetNode4, false);
            dXWidgetNode4.setEnabled(enabled);
            dXWidgetNode4.setAlpha(alpha);
            if (z) {
                dXWidgetNode4.setAccessibility(2);
            } else if (z2 && accessibility == -1) {
                dXWidgetNode4.setAccessibility(3);
            }
        } else {
            dXWidgetNode3 = dXWidgetNode2;
        }
        boolean z7 = (accessibility == 2 || hasAccessibilityOn) ? true : z;
        boolean z8 = accessibility == 3 ? true : z2;
        if (z8) {
            dXWidgetNode2.queryRootWidgetNode().setAccessibility(3);
        }
        if (z4) {
            i11 = 0;
            i10 = 0;
            f2 = 1.0f;
        } else {
            dXWidgetNode4 = dXWidgetNode3;
            i11 = i9;
            i10 = i8;
            f2 = alpha;
        }
        if (z5) {
            boolean isDisableDarkMode = dXWidgetNode.isDisableDarkMode();
            while (i12 < dXWidgetNode.getChildrenCount()) {
                DXWidgetNode childAt = dXWidgetNode.getChildAt(i12);
                if (isDisableDarkMode) {
                    childAt.setDisableDarkMode(true);
                }
                a(childAt, i11, i10, i7, i6, dXWidgetNode4, z7, z8, z3, enabled, f2);
                i12++;
                enabled = enabled;
            }
        }
    }

    private boolean e(int i) {
        return View.MeasureSpec.getMode(i) == 0 && View.MeasureSpec.getSize(i) == 0;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    public d b(DXWidgetNode dXWidgetNode, DXRuntimeContext dXRuntimeContext, boolean z) {
        Exception e;
        d dVar = null;
        if (dXWidgetNode == null) {
            return null;
        }
        try {
            d dVar2 = new d();
            try {
                dVar2.setFlatten(true);
                dVar2.setReferenceNode(dVar2);
                dVar2.setDXRuntimeContext(dXRuntimeContext.cloneWithWidgetNode(dVar2));
                if (dXWidgetNode.getVisibility() != 0) {
                    dVar2.setMeasuredDimension(0, 0);
                    return dVar2;
                }
                dVar2.setLayoutWidth(dXWidgetNode.getLayoutWidth());
                dVar2.setLayoutHeight(dXWidgetNode.getLayoutHeight());
                dVar2.setMeasuredDimension(dXWidgetNode.getMeasuredWidthAndState(), dXWidgetNode.getMeasuredHeightAndState());
                dVar2.setStatFlag(256);
                a(dXWidgetNode, 0, 0, dXWidgetNode.getMeasuredWidth(), dXWidgetNode.getMeasuredHeight(), dVar2, false, false, z, 1, 1.0f);
                return dVar2;
            } catch (Exception e2) {
                e = e2;
                dVar = dVar2;
                if (DinamicXEngine.x()) {
                }
                e.a aVar = new e.a("Pipeline_Detail", "Pipeline_Detail_PerformFlatten", 80004);
                aVar.e = "DXLayoutManager#performFlatten " + vx.a(e);
                dXRuntimeContext.getDxError().c.add(aVar);
                return dVar;
            }
        } catch (Exception e3) {
            e = e3;
            if (DinamicXEngine.x()) {
                e.printStackTrace();
            }
            if (!(dXRuntimeContext == null || dXRuntimeContext.getDxError() == null || dXRuntimeContext.getDxError().c == null)) {
                e.a aVar2 = new e.a("Pipeline_Detail", "Pipeline_Detail_PerformFlatten", 80004);
                aVar2.e = "DXLayoutManager#performFlatten " + vx.a(e);
                dXRuntimeContext.getDxError().c.add(aVar2);
            }
            return dVar;
        }
    }

    /* access modifiers changed from: protected */
    public void c(DXWidgetNode dXWidgetNode, DXRuntimeContext dXRuntimeContext) {
        if (dXWidgetNode != null) {
            try {
                if (dXWidgetNode.getVisibility() == 0) {
                    dXWidgetNode.layout(0, 0, dXWidgetNode.getMeasuredWidth(), dXWidgetNode.getMeasuredHeight());
                }
            } catch (Exception e) {
                if (DinamicXEngine.x()) {
                    e.printStackTrace();
                }
                if (dXRuntimeContext != null && dXRuntimeContext.getDxError() != null && dXRuntimeContext.getDxError().c != null) {
                    e.a aVar = new e.a("Pipeline_Detail", "Pipeline_Detail_PerformLayout", 80003);
                    aVar.e = "DXLayoutManager#performLayout " + vx.a(e);
                    dXRuntimeContext.getDxError().c.add(aVar);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d(DXWidgetNode dXWidgetNode, int i, int i2, DXRuntimeContext dXRuntimeContext) {
        if (dXWidgetNode != null) {
            try {
                if (dXWidgetNode instanceof f) {
                    if (e(i)) {
                        i = d00.f();
                    }
                    if (e(i2)) {
                        i2 = d00.e();
                    }
                    int childMeasureSpec = f.getChildMeasureSpec(i, 0, dXWidgetNode.getLayoutWidth());
                    int childMeasureSpec2 = f.getChildMeasureSpec(i2, 0, dXWidgetNode.getLayoutHeight());
                    if (dXWidgetNode.getVisibility() == 0) {
                        dXWidgetNode.measure(childMeasureSpec, childMeasureSpec2);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                if (DinamicXEngine.x()) {
                    e.printStackTrace();
                }
                if (dXRuntimeContext != null && dXRuntimeContext.getDxError() != null && dXRuntimeContext.getDxError().c != null) {
                    e.a aVar = new e.a("Pipeline_Detail", "Pipeline_Detail_PerformMeasure", 80002);
                    aVar.e = "DXLayoutManager#performMeasure" + vx.a(e);
                    dXRuntimeContext.getDxError().c.add(aVar);
                    return;
                }
                return;
            }
        }
        e.a aVar2 = new e.a("Pipeline_Detail", "Pipeline_Detail_PerformMeasure", 80001);
        aVar2.e = "DXLayoutManager#performMeasure widgetNode == null || !(widgetNode instanceof DXLayout)";
        dXRuntimeContext.getDxError().c.add(aVar2);
    }
}
