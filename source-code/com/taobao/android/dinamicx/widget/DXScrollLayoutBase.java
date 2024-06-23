package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.view.View;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.k;
import com.taobao.android.dinamicx.m;
import com.taobao.android.dinamicx.view.DXNativeRecyclerView;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import tb.be;
import tb.lx;
import tb.t10;

/* compiled from: Taobao */
public class DXScrollLayoutBase extends DXLinearLayoutWidgetNode {
    public static final long DX_SCROLL_LAYOUT_BASE = -116275953006946184L;
    public static final long DX_SCROLL_LAYOUT_BASE_INDICATOR_ID = 7196296497982840181L;
    public static final long DX_SCROLL_LAYOUT_BASE_ON_PAGE_APPEAR = -8975334121118753601L;
    public static final long DX_SCROLL_LAYOUT_BASE_ON_PAGE_DISAPPEAR = -5201408949358043646L;
    public static final long DX_SCROLL_LAYOUT_BASE_ON_SCROLL = 5288751146867425108L;
    public static final long DX_SCROLL_LAYOUT_BASE_ON_SCROLL_BEGIN = 9144262755562405950L;
    public static final long DX_SCROLL_LAYOUT_BASE_ON_SCROLL_END = 2691126191158604142L;
    public static final long DX_SCROLL_LAYOUT_BASE_SCROLL_ENABLED = -8352681166307095225L;
    public static final long DX_SCROLL_LAYOUT_BASE_SHOW_INDICATOR = -3765027987112450965L;
    private List<DXWidgetNode> appearWidgets;
    protected int contentHorizontalLength;
    protected int contentVerticalLength;
    protected String indicatorId;
    protected DXWidgetNode indicatorWidgetNode;
    protected ArrayList<DXWidgetNode> itemWidgetNodes;
    protected k pipeline;
    protected boolean scrollEnabled = true;
    protected boolean showIndicator = true;

    public DXScrollLayoutBase() {
        this.markContainer = true;
    }

    private void forceUniformHeight(List<DXWidgetNode> list, int i) {
        int c = DXWidgetNode.DXMeasureSpec.c(getMeasuredHeight(), 1073741824);
        for (DXWidgetNode dXWidgetNode : list) {
            if (!(dXWidgetNode == null || dXWidgetNode.getVisibility() == 2 || dXWidgetNode.layoutHeight != -1)) {
                int i2 = dXWidgetNode.layoutWidth;
                dXWidgetNode.layoutWidth = dXWidgetNode.getMeasuredWidth();
                measureChildWithMargins(dXWidgetNode, i, 0, c, 0);
                dXWidgetNode.layoutWidth = i2;
            }
        }
    }

    private void forceUniformWidth(List<DXWidgetNode> list, int i) {
        int c = DXWidgetNode.DXMeasureSpec.c(getMeasuredWidth(), 1073741824);
        for (DXWidgetNode dXWidgetNode : list) {
            if (!(dXWidgetNode == null || dXWidgetNode.getVisibility() == 2 || dXWidgetNode.layoutWidth != -1)) {
                int i2 = dXWidgetNode.layoutHeight;
                dXWidgetNode.layoutHeight = dXWidgetNode.getMeasuredHeight();
                measureChildWithMargins(dXWidgetNode, c, 0, i, 0);
                dXWidgetNode.layoutHeight = i2;
            }
        }
    }

    private DXWidgetNode queryIndicatorNodeByUserId(String str) {
        DXWidgetNode parentWidget;
        if (str == null || (parentWidget = getParentWidget()) == null) {
            return null;
        }
        int i = 0;
        DXWidgetNode dXWidgetNode = null;
        int i2 = -1;
        int i3 = -1;
        for (DXWidgetNode dXWidgetNode2 : parentWidget.getChildren()) {
            if (dXWidgetNode2 == this) {
                i2 = i;
            } else if (str.equals(dXWidgetNode2.getUserId())) {
                i3 = i;
                dXWidgetNode = dXWidgetNode2;
            }
            if (!(i2 == -1 || i3 == -1)) {
                return dXWidgetNode;
            }
            i++;
        }
        return null;
    }

    public void addAppearWidget(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode != null) {
            if (this.appearWidgets == null) {
                this.appearWidgets = new ArrayList();
            }
            this.appearWidgets.add(dXWidgetNode);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void bindRuntimeContext(DXRuntimeContext dXRuntimeContext, boolean z) {
        ArrayList<DXWidgetNode> arrayList;
        super.bindRuntimeContext(dXRuntimeContext, z);
        if (dXRuntimeContext != null && (arrayList = this.itemWidgetNodes) != null) {
            Iterator<DXWidgetNode> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().bindRuntimeContext(dXRuntimeContext, z);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == -8352681166307095225L || j == -3765027987112450965L) {
            return 1;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    /* access modifiers changed from: protected */
    public boolean isPipelineDefaultCreateRootView() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode
    public void measureHorizontal(int i, int i2) {
        boolean z;
        int i3;
        ArrayList<DXWidgetNode> arrayList;
        boolean z2;
        DXWidgetNode dXWidgetNode;
        int i4 = 0;
        this.mTotalLength = 0;
        int a = DXWidgetNode.DXMeasureSpec.a(i2);
        ArrayList<DXWidgetNode> arrayList2 = this.itemWidgetNodes;
        boolean z3 = true;
        if (arrayList2 != null) {
            Iterator<DXWidgetNode> it = arrayList2.iterator();
            i3 = 0;
            int i5 = 0;
            boolean z4 = true;
            z = false;
            while (it.hasNext()) {
                DXWidgetNode next = it.next();
                if (!(next == null || next.visibility == 2)) {
                    measureChildWithMargins(next, measureSpecForChild(next.layoutWidth, i), 0, i2, 0);
                    if (a == 1073741824 || next.getLayoutHeight() != -1) {
                        dXWidgetNode = next;
                        z2 = false;
                    } else {
                        dXWidgetNode = next;
                        z2 = true;
                        z = true;
                    }
                    int i6 = dXWidgetNode.marginTop + dXWidgetNode.marginBottom;
                    int measuredHeight = dXWidgetNode.getMeasuredHeight() + i6;
                    i3 = Math.max(i3, measuredHeight);
                    z4 = z4 && dXWidgetNode.layoutHeight == -1;
                    if (!z2) {
                        i6 = measuredHeight;
                    }
                    i5 = Math.max(i5, i6);
                    this.contentHorizontalLength += dXWidgetNode.getMeasuredWidth() + dXWidgetNode.marginLeft + dXWidgetNode.marginRight;
                }
            }
            i4 = i5;
            z3 = z4;
        } else {
            i3 = 0;
            z = false;
        }
        int resolveSize = DXWidgetNode.resolveSize(Math.max(getLayoutWidth(), getMinWidth()), i);
        if (z3 || a == 1073741824) {
            i4 = i3;
        }
        setMeasuredDimension(resolveSize, DXWidgetNode.resolveSize(Math.max(i4 + getPaddingTop() + getPaddingBottom(), getMinHeight()), i2));
        if (z && (arrayList = this.itemWidgetNodes) != null) {
            forceUniformHeight(arrayList, i);
        }
    }

    public int measureSpecForChild(int i, int i2) {
        return i == -2 ? DXWidgetNode.DXMeasureSpec.c(8388607, 0) : i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode
    public void measureVertical(int i, int i2) {
        boolean z;
        int i3;
        ArrayList<DXWidgetNode> arrayList;
        boolean z2;
        DXWidgetNode dXWidgetNode;
        int i4 = 0;
        this.mTotalLength = 0;
        int a = DXWidgetNode.DXMeasureSpec.a(i);
        ArrayList<DXWidgetNode> arrayList2 = this.itemWidgetNodes;
        boolean z3 = true;
        if (arrayList2 != null) {
            Iterator<DXWidgetNode> it = arrayList2.iterator();
            i3 = 0;
            int i5 = 0;
            boolean z4 = true;
            z = false;
            while (it.hasNext()) {
                DXWidgetNode next = it.next();
                if (!(next == null || next.visibility == 2)) {
                    measureChildWithMargins(next, i, 0, measureSpecForChild(next.layoutHeight, i2), 0);
                    if (a == 1073741824 || next.getLayoutWidth() != -1) {
                        dXWidgetNode = next;
                        z2 = false;
                    } else {
                        dXWidgetNode = next;
                        z2 = true;
                        z = true;
                    }
                    int i6 = dXWidgetNode.marginLeft + dXWidgetNode.marginRight;
                    int measuredWidth = dXWidgetNode.getMeasuredWidth() + i6;
                    i3 = Math.max(i3, measuredWidth);
                    z4 = z4 && dXWidgetNode.layoutWidth == -1;
                    if (!z2) {
                        i6 = measuredWidth;
                    }
                    i5 = Math.max(i5, i6);
                    this.contentVerticalLength += dXWidgetNode.getMeasuredHeight() + dXWidgetNode.marginTop + dXWidgetNode.marginBottom;
                }
            }
            i4 = i5;
            z3 = z4;
        } else {
            i3 = 0;
            z = false;
        }
        int resolveSize = DXWidgetNode.resolveSize(Math.max(getLayoutHeight(), getMinHeight()), i2);
        if (z3 || a == 1073741824) {
            i4 = i3;
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(Math.max(i4 + getPaddingLeft() + getPaddingRight(), getMinWidth()), i), resolveSize);
        if (z && (arrayList = this.itemWidgetNodes) != null) {
            forceUniformWidth(arrayList, i2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        super.onBeforeBindChildData();
        DXWidgetNode queryIndicatorNodeByUserId = queryIndicatorNodeByUserId(this.indicatorId);
        if (queryIndicatorNodeByUserId != null) {
            m.a(queryIndicatorNodeByUserId);
            if (this.showIndicator) {
                queryIndicatorNodeByUserId.setVisibility(0);
                this.indicatorWidgetNode = queryIndicatorNodeByUserId;
            } else {
                queryIndicatorNodeByUserId.setVisibility(2);
            }
        }
        ArrayList<DXWidgetNode> arrayList = new ArrayList<>();
        for (DXWidgetNode dXWidgetNode : getChildren()) {
            arrayList.add(dXWidgetNode);
        }
        this.itemWidgetNodes = arrayList;
        setDisableFlatten(true);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXScrollLayoutBase) {
            DXScrollLayoutBase dXScrollLayoutBase = (DXScrollLayoutBase) dXWidgetNode;
            this.indicatorId = dXScrollLayoutBase.indicatorId;
            this.scrollEnabled = dXScrollLayoutBase.scrollEnabled;
            this.showIndicator = dXScrollLayoutBase.showIndicator;
            this.itemWidgetNodes = dXScrollLayoutBase.itemWidgetNodes;
            this.indicatorWidgetNode = dXScrollLayoutBase.indicatorWidgetNode;
            this.pipeline = dXScrollLayoutBase.pipeline;
            this.contentHorizontalLength = dXScrollLayoutBase.contentHorizontalLength;
            this.contentVerticalLength = dXScrollLayoutBase.contentVerticalLength;
            this.appearWidgets = dXScrollLayoutBase.appearWidgets;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        if (this.pipeline == null) {
            this.pipeline = new k(getDXRuntimeContext().getEngineContext(), 3, UUID.randomUUID().toString(), isPipelineDefaultCreateRootView());
        }
        ArrayList arrayList = new ArrayList();
        if (this.listData == null) {
            arrayList.addAll(this.children);
        }
        removeAllChild();
        super.onMeasure(i, i2);
        if (this.listData == null) {
            this.children.addAll(arrayList);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        DXWidgetNode widgetNode;
        super.onRenderView(context, view);
        if (getChildrenCount() > 0 && (widgetNode = getDXRuntimeContext().getWidgetNode()) != null) {
            widgetNode.removeAllChild();
            removeAllChild();
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        boolean z = true;
        if (j == -3765027987112450965L) {
            if (i == 0) {
                z = false;
            }
            this.showIndicator = z;
        } else if (j == -8352681166307095225L) {
            if (i == 0) {
                z = false;
            }
            this.scrollEnabled = z;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == DX_SCROLL_LAYOUT_BASE_INDICATOR_ID) {
            this.indicatorId = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode queryWTByAutoId(int i) {
        DXWidgetNode queryWTByAutoId = super.queryWTByAutoId(i);
        if (queryWTByAutoId == null) {
            ArrayList<DXWidgetNode> arrayList = this.itemWidgetNodes;
            if (arrayList == null) {
                return null;
            }
            Iterator<DXWidgetNode> it = arrayList.iterator();
            while (it.hasNext() && (queryWTByAutoId = it.next().queryWTByAutoId(i)) == null) {
                while (it.hasNext()) {
                    while (it.hasNext()) {
                    }
                }
            }
        }
        return queryWTByAutoId;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode queryWTByUserId(String str) {
        DXWidgetNode queryWTByUserId = super.queryWTByUserId(str);
        if (queryWTByUserId == null) {
            ArrayList<DXWidgetNode> arrayList = this.itemWidgetNodes;
            if (arrayList == null) {
                return null;
            }
            Iterator<DXWidgetNode> it = arrayList.iterator();
            while (it.hasNext() && (queryWTByUserId = it.next().queryWTByUserId(str)) == null) {
                while (it.hasNext()) {
                    while (it.hasNext()) {
                    }
                }
            }
        }
        return queryWTByUserId;
    }

    public boolean removeAppearWidget(DXWidgetNode dXWidgetNode) {
        List<DXWidgetNode> list;
        if (dXWidgetNode == null || (list = this.appearWidgets) == null) {
            return false;
        }
        return list.remove(dXWidgetNode);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void sendBroadcastEvent(lx lxVar) {
        if (lxVar != null) {
            if (5288671110273408574L == lxVar.b()) {
                postEvent(lxVar);
                List<DXWidgetNode> list = this.appearWidgets;
                if (!(list == null || list.size() == 0)) {
                    for (DXWidgetNode dXWidgetNode : this.appearWidgets) {
                        t10 t10 = new t10(DX_SCROLL_LAYOUT_BASE_ON_PAGE_APPEAR);
                        t10.f(dXWidgetNode.getDXRuntimeContext().getSubdataIndex());
                        dXWidgetNode.sendBroadcastEvent(t10);
                    }
                }
            } else if (5388973340095122049L == lxVar.b()) {
                postEvent(lxVar);
                List<DXWidgetNode> list2 = this.appearWidgets;
                if (!(list2 == null || list2.size() == 0)) {
                    for (DXWidgetNode dXWidgetNode2 : this.appearWidgets) {
                        t10 t102 = new t10(DX_SCROLL_LAYOUT_BASE_ON_PAGE_DISAPPEAR);
                        t102.f(dXWidgetNode2.getDXRuntimeContext().getSubdataIndex());
                        dXWidgetNode2.sendBroadcastEvent(t102);
                    }
                }
            } else {
                postEvent(lxVar);
                List<DXWidgetNode> list3 = this.appearWidgets;
                if (list3 != null && list3.size() > 0) {
                    for (DXWidgetNode dXWidgetNode3 : this.appearWidgets) {
                        dXWidgetNode3.sendBroadcastEvent(lxVar);
                    }
                }
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setBackground(View view) {
        be cLipRadiusHandler;
        if (hasCornerRadius()) {
            DXNativeRecyclerView dXNativeRecyclerView = (DXNativeRecyclerView) view;
            be beVar = new be();
            int i = this.cornerRadius;
            if (i > 0) {
                beVar.j(view, (float) i);
            } else {
                beVar.k(view, (float) this.cornerRadiusLeftTop, (float) this.cornerRadiusRightTop, (float) this.cornerRadiusLeftBottom, (float) this.cornerRadiusRightBottom);
            }
            dXNativeRecyclerView.setClipRadiusHandler(beVar);
        } else if ((view instanceof DXNativeRecyclerView) && (cLipRadiusHandler = ((DXNativeRecyclerView) view).getCLipRadiusHandler()) != null) {
            cLipRadiusHandler.j(view, 0.0f);
        }
        super.setBackground(view);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void updateRefreshType(int i) {
        DXRuntimeContext dXRuntimeContext = this.dXRuntimeContext;
        if (dXRuntimeContext != null) {
            dXRuntimeContext.setRefreshType(i);
        }
        ArrayList<DXWidgetNode> arrayList = this.itemWidgetNodes;
        if (arrayList != null) {
            Iterator<DXWidgetNode> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().updateRefreshType(i);
            }
        }
    }
}
