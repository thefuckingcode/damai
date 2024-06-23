package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.weex.common.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.at;
import tb.ey;
import tb.py;
import tb.qy;

/* compiled from: Taobao */
public class f extends DXWidgetNode implements IDXNodePropProvider {
    public static final long DXLAYOUT_MARKCONTAINER = 8182691489212564827L;
    boolean disableFlatten;
    Map<String, WeakReference<DXWidgetNode>> dxUserIdMap;
    JSONArray listData;
    boolean markContainer = false;
    List<DXWidgetNode> originItems;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (r7 == -2) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r7 == -2) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r7 == -2) goto L_0x0036;
     */
    public static int getChildMeasureSpec(int i, int i2, int i3) {
        int a = DXWidgetNode.DXMeasureSpec.a(i);
        int b = DXWidgetNode.DXMeasureSpec.b(i) - i2;
        int i4 = 0;
        int max = Math.max(0, b);
        if (a != Integer.MIN_VALUE) {
            if (a != 0) {
                if (a == 1073741824) {
                    if (i3 < 0) {
                        if (i3 == -1) {
                            i4 = 1073741824;
                            i3 = max;
                            return DXWidgetNode.DXMeasureSpec.c(i3, i4);
                        }
                    }
                }
                i3 = 0;
                return DXWidgetNode.DXMeasureSpec.c(i3, i4);
            } else if (i3 < 0) {
                if (i3 != -1) {
                }
                i3 = max;
                return DXWidgetNode.DXMeasureSpec.c(i3, i4);
            }
        } else if (i3 < 0) {
            if (i3 != -1) {
            }
            i4 = Integer.MIN_VALUE;
            i3 = max;
            return DXWidgetNode.DXMeasureSpec.c(i3, i4);
        }
        i4 = 1073741824;
        return DXWidgetNode.DXMeasureSpec.c(i3, i4);
    }

    /* access modifiers changed from: protected */
    public void bindContext(DXWidgetNode dXWidgetNode, Object obj, int i) {
        dXWidgetNode.getDXRuntimeContext().setSubData(obj);
        dXWidgetNode.getDXRuntimeContext().setSubdataIndex(i);
        HashMap hashMap = new HashMap();
        dXWidgetNode.getDXRuntimeContext().setEnv(hashMap);
        hashMap.put("i", ey.J((long) i));
        hashMap.put(Constants.Name.Recycler.LIST_DATA, ey.E(getListData()));
        if (at.o0()) {
            dXWidgetNode.setSourceWidget(dXWidgetNode);
        } else if (dXWidgetNode.getSourceWidget() == null) {
            dXWidgetNode.setSourceWidget(dXWidgetNode);
        }
        List<DXWidgetNode> children = dXWidgetNode.getChildren();
        if (!(children == null || children.size() == 0)) {
            for (DXWidgetNode dXWidgetNode2 : children) {
                bindContext(dXWidgetNode2, obj, i);
            }
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(@NonNull py pyVar) {
        return new ViewGroup.LayoutParams(pyVar.a, pyVar.b);
    }

    /* access modifiers changed from: protected */
    public ArrayList<DXWidgetNode> generateWidgetNodeByData(int i, JSONArray jSONArray, List<DXWidgetNode> list) {
        ArrayList<DXWidgetNode> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < jSONArray.size(); i2++) {
            Object obj = jSONArray.get(i2);
            int i3 = i2 + i;
            if (i3 == 0) {
                for (DXWidgetNode dXWidgetNode : list) {
                    bindContext(dXWidgetNode, obj, i3);
                }
            } else {
                for (DXWidgetNode dXWidgetNode2 : list) {
                    DXRuntimeContext cloneWithWidgetNode = dXWidgetNode2.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode2);
                    cloneWithWidgetNode.setSubData(obj);
                    cloneWithWidgetNode.setSubdataIndex(i3);
                    HashMap hashMap = new HashMap();
                    cloneWithWidgetNode.setEnv(hashMap);
                    hashMap.put("i", ey.J((long) i3));
                    hashMap.put(Constants.Name.Recycler.LIST_DATA, ey.E(jSONArray));
                    DXWidgetNode b = g.b(dXWidgetNode2, cloneWithWidgetNode);
                    b.setParentWidget(this);
                    arrayList.add(b);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public Map<String, WeakReference<DXWidgetNode>> getDxUserIdMap() {
        if (this.dxUserIdMap == null) {
            this.dxUserIdMap = new HashMap();
        }
        return this.dxUserIdMap;
    }

    public JSONArray getListData() {
        return this.listData;
    }

    @Override // com.taobao.android.dinamicx.widget.IDXNodePropProvider
    public Object getNodePropByKey(String str) {
        if (Constants.Name.Recycler.LIST_DATA.equals(str)) {
            return this.listData;
        }
        return null;
    }

    public List<DXWidgetNode> getOriginItems() {
        return this.originItems;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public boolean isClipChildren() {
        return this.clipChildren;
    }

    public boolean isDisableFlatten() {
        return this.disableFlatten;
    }

    public boolean isHandleListData() {
        return (this.propertyInitFlag & 2) != 0;
    }

    public boolean isLayoutRtl() {
        return getDirection() == 1;
    }

    public boolean isMarkContainer() {
        return this.markContainer;
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(DXWidgetNode dXWidgetNode, int i, int i2, int i3, int i4) {
        dXWidgetNode.measure(getChildMeasureSpec(i, this.paddingLeft + this.paddingRight + dXWidgetNode.marginLeft + dXWidgetNode.marginRight + i2, dXWidgetNode.layoutWidth), getChildMeasureSpec(i3, this.paddingTop + this.paddingBottom + dXWidgetNode.marginTop + dXWidgetNode.marginBottom + i4, dXWidgetNode.layoutHeight));
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        if (!at.w0() && getChildren() != null && this.originItems == null) {
            ArrayList arrayList = new ArrayList();
            this.originItems = arrayList;
            arrayList.addAll(getChildren());
        }
        if ((this.propertyInitFlag & 2) != 0) {
            if (at.w0() && getChildren() != null && this.originItems == null) {
                this.originItems = new ArrayList();
                for (DXWidgetNode dXWidgetNode : getChildren()) {
                    this.originItems.add(dXWidgetNode.deepClone(getDXRuntimeContext()));
                }
            }
            JSONArray jSONArray = this.listData;
            if (jSONArray == null || jSONArray.isEmpty() || getChildren() == null) {
                removeAllChild();
                return;
            }
            new ArrayList();
            if (at.w0() && getDXRuntimeContext().isRefreshPart()) {
                removeAllChild();
                for (DXWidgetNode dXWidgetNode2 : this.originItems) {
                    addChild(dXWidgetNode2.deepClone(getDXRuntimeContext()));
                }
            }
            ArrayList<DXWidgetNode> generateWidgetNodeByData = generateWidgetNodeByData(0, getListData(), getChildren());
            for (int i = 0; i < generateWidgetNodeByData.size(); i++) {
                addChild(generateWidgetNodeByData.get(i), false);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof f) {
            f fVar = (f) dXWidgetNode;
            this.disableFlatten = fVar.disableFlatten;
            this.listData = fVar.listData;
            this.originItems = fVar.originItems;
            this.markContainer = fVar.markContainer;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view != null) {
            if (view instanceof ViewGroup) {
                if (Build.VERSION.SDK_INT >= 18) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    boolean clipChildren = viewGroup.getClipChildren();
                    boolean z = this.clipChildren;
                    if (clipChildren != z) {
                        viewGroup.setClipChildren(z);
                    }
                } else {
                    ((ViewGroup) view).setClipChildren(this.clipChildren);
                }
            }
            super.onRenderView(context, view);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        boolean z = false;
        if (j == -7485666501444237648L) {
            if (i == 1) {
                z = true;
            }
            this.disableFlatten = z;
        } else if (j == DXLAYOUT_MARKCONTAINER) {
            if (i != 0) {
                z = true;
            }
            this.markContainer = z;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        if (qy.DX_PARSER_LISTDATA == j) {
            this.listData = jSONArray;
            this.propertyInitFlag |= 2;
            return;
        }
        super.onSetListAttribute(j, jSONArray);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetUserDefinedListAttribute(long j, List<Object> list) {
        if (qy.DX_PARSER_LISTDATA == j) {
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (Object obj : list) {
                    jSONArray.add(obj);
                }
                onSetListAttribute(j, jSONArray);
            }
            this.propertyInitFlag |= 2;
            return;
        }
        super.onSetUserDefinedListAttribute(j, list);
    }

    /* access modifiers changed from: package-private */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setAccessibility(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            int i = this.accessibility;
            if (i != -1) {
                if (i == 3) {
                    view.setImportantForAccessibility(1);
                    view.setContentDescription(null);
                    return;
                }
                String str = this.accessibilityText;
                if (str != null) {
                    view.setContentDescription(str);
                }
                int i2 = this.accessibility;
                if (i2 == 1) {
                    view.setImportantForAccessibility(1);
                    view.setFocusable(true);
                } else if (i2 == 2) {
                    view.setImportantForAccessibility(4);
                } else {
                    view.setImportantForAccessibility(2);
                }
            }
        } else {
            view.setContentDescription("");
        }
    }

    public void setClipChildren(boolean z) {
        this.clipChildren = z;
    }

    public void setDisableFlatten(boolean z) {
        this.disableFlatten = z;
    }

    public void setListData(JSONArray jSONArray) {
        this.listData = jSONArray;
        this.propertyInitFlag |= 2;
    }

    public void setMarkContainer(boolean z) {
        this.markContainer = z;
    }

    public ViewGroup.LayoutParams generateLayoutParams(@NonNull py pyVar, @NonNull ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = pyVar.a;
        layoutParams.height = pyVar.b;
        return layoutParams;
    }
}
