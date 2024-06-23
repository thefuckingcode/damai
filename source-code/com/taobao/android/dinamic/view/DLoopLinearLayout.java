package com.taobao.android.dinamic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamic.DViewGenerator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tb.c80;
import tb.ew2;
import tb.h80;
import tb.u70;
import tb.x70;
import tb.z70;

/* compiled from: Taobao */
public class DLoopLinearLayout extends DLinearLayout {
    private static final String TAG = "DLoopLinearLayout";
    final a recycledPool = new a();
    private Map<Integer, b> templateViews = new LinkedHashMap();
    private int viewTypeFlag = 0;

    /* compiled from: Taobao */
    public static class a {
        private SparseArray<ArrayList<View>> a = new SparseArray<>();
        private SparseIntArray b = new SparseIntArray();

        private ArrayList<View> b(int i) {
            ArrayList<View> arrayList = this.a.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.a.put(i, arrayList);
                if (this.b.indexOfKey(i) < 0) {
                    this.b.put(i, 10);
                }
            }
            return arrayList;
        }

        public View a(int i) {
            ArrayList<View> arrayList = this.a.get(i);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            int size = arrayList.size() - 1;
            View view = arrayList.get(size);
            arrayList.remove(size);
            return view;
        }

        public void c(int i, View view) {
            ArrayList<View> b2 = b(i);
            if (this.b.get(i) > b2.size()) {
                b2.add(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b {
        int a;
        View b;
        String c;
        String d;

        b(DLoopLinearLayout dLoopLinearLayout) {
        }
    }

    public DLoopLinearLayout(Context context) {
        super(context);
    }

    private void addViewInfo(View view) {
        for (Map.Entry<Integer, b> entry : this.templateViews.entrySet()) {
            if (view == entry.getValue().b) {
                return;
            }
        }
        z70 c = h80.c(view);
        b bVar = new b(this);
        bVar.b = view;
        bVar.a = this.viewTypeFlag;
        bVar.d = c.a;
        if (c.b.containsKey("dFilter")) {
            bVar.c = String.valueOf(c.b.get("dFilter"));
        } else {
            bVar.c = c.c.get("dFilter");
        }
        this.templateViews.put(Integer.valueOf(bVar.a), bVar);
        view.setTag(c80.VIEW_TYPE_KEY, Integer.valueOf(bVar.a));
        this.viewTypeFlag++;
    }

    private Object getBindData(Object obj) {
        if (!(obj instanceof String)) {
            return obj;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("value", obj);
        return jSONObject;
    }

    private View getCacheView(int i) {
        return this.recycledPool.a(i);
    }

    private boolean isViewGroup(View view) {
        if (view instanceof DLoopLinearLayout) {
            return false;
        }
        if ((view instanceof DLinearLayout) || (view instanceof DFrameLayout)) {
            return true;
        }
        return false;
    }

    private void recursiveViewTree(View view, ArrayList<View> arrayList) {
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            z70 z70 = (z70) childAt.getTag(c80.PROPERTY_KEY);
            if (z70 != null && (!z70.c.isEmpty() || !z70.d.isEmpty())) {
                arrayList.remove(childAt);
            }
            if (isViewGroup(childAt)) {
                recursiveViewTree(childAt, arrayList);
            }
        }
    }

    private void recyleView(int i) {
        if (i < super.getChildCount()) {
            View childAt = super.getChildAt(i);
            super.removeViewAt(i);
            Integer num = (Integer) childAt.getTag(c80.VIEW_TYPE_KEY);
            if (num != null) {
                this.recycledPool.c(num.intValue(), childAt);
            }
        }
    }

    private void removeBindList(View view) {
        ArrayList<View> arrayList = (ArrayList) getTag(c80.TAG_DINAMIC_BIND_DATA_LIST);
        z70 z70 = (z70) view.getTag(c80.PROPERTY_KEY);
        if (!z70.c.isEmpty() || !z70.d.isEmpty()) {
            arrayList.remove(view);
        }
        if (isViewGroup(view)) {
            recursiveViewTree(view, arrayList);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        addViewInfo(view);
        removeBindList(view);
    }

    public void bindChildView(x70 x70, List list) {
        if (this.templateViews.size() == 0 || list == null || list.size() == 0) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                recyleView(childCount);
            }
            return;
        }
        if (getChildCount() > list.size()) {
            int childCount2 = getChildCount();
            while (true) {
                childCount2--;
                if (childCount2 < list.size()) {
                    break;
                }
                recyleView(childCount2);
            }
        }
        DViewGenerator o = DViewGenerator.o(x70.c());
        Object a2 = x70.a();
        for (int i = 0; i < list.size(); i++) {
            x70.f(getBindData(list.get(i)));
            int itemViewType = getItemViewType(x70);
            if (itemViewType == -1) {
                super.addView(new CompatibleView(getContext(), "no view match data"), i);
            } else {
                View view = null;
                if (i < getChildCount()) {
                    View childAt = getChildAt(i);
                    Integer num = (Integer) childAt.getTag(c80.VIEW_TYPE_KEY);
                    if (num == null || itemViewType != num.intValue()) {
                        recyleView(i);
                    } else {
                        view = childAt;
                    }
                }
                if (view == null) {
                    view = getCacheView(itemViewType);
                    if (view == null) {
                        ew2 i2 = o.i(this.templateViews.get(Integer.valueOf(itemViewType)).b, getContext(), x70);
                        View d = i2.d();
                        d.setTag(c80.TAG_ROOT_VIEW_RESULT, i2);
                        d.setTag(c80.VIEW_TYPE_KEY, Integer.valueOf(itemViewType));
                        view = d;
                    }
                    super.addView(view, i, view.getLayoutParams());
                }
                ew2 ew2 = (ew2) view.getTag(c80.TAG_ROOT_VIEW_RESULT);
                if (ew2 != null) {
                    o.f(ew2.a(), x70);
                }
            }
        }
        x70.f(a2);
    }

    public void bindListData(x70 x70, List list) {
        bindChildView(x70, list);
    }

    public Map<Integer, b> cloneTemplateViews() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.templateViews);
        return linkedHashMap;
    }

    public int getItemViewType(x70 x70) {
        for (Map.Entry<Integer, b> entry : this.templateViews.entrySet()) {
            b value = entry.getValue();
            String str = value.c;
            if (str == null) {
                if (this.templateViews.size() == 1) {
                    return value.a;
                }
            } else if ("true".equals(str)) {
                return value.a;
            } else {
                Object a2 = u70.a(value.c, value.d, x70);
                if (a2 != null && (((a2 instanceof Boolean) && ((Boolean) a2).booleanValue()) || ((a2 instanceof String) && "true".equals(a2.toString())))) {
                    return value.a;
                }
            }
        }
        return -1;
    }

    public void setTemplateViews(Map<Integer, b> map) {
        this.templateViews = map;
    }

    public DLoopLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DLoopLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
