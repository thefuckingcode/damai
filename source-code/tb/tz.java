package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* compiled from: Taobao */
public class tz extends sz {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean A(DXRecyclerLayout dXRecyclerLayout, JSONArray jSONArray, int i, boolean z, FalcoSpan falcoSpan) {
        char c;
        char c2;
        if (i < 0 || i >= e(dXRecyclerLayout).size()) {
            m(dXRecyclerLayout, e.DX_ERROR_CODE_RECYCLER_LAYOUT_230004, "index: " + i + " dataSource.size() " + e(dXRecyclerLayout).size());
            return false;
        }
        IDXDataSourceManager f = f(dXRecyclerLayout);
        if (f == null || f.isItemsNull() || f.isItemsEmpty()) {
            return false;
        }
        Object obj = e(dXRecyclerLayout).get(i);
        dXRecyclerLayout.getDXRuntimeContext().getDataProxy();
        Iterator<Object> it = jSONArray.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (!(next instanceof JSONObject)) {
                return false;
            }
            JSONObject jSONObject = (JSONObject) next;
            String string = jSONObject.getString("operator");
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            String string2 = jSONObject.getString("key");
            if (TextUtils.isEmpty(string2)) {
                return false;
            }
            Object obj2 = jSONObject.get("value");
            ArrayDeque arrayDeque = new ArrayDeque();
            x(string2, arrayDeque);
            Object obj3 = obj;
            while (true) {
                if (!arrayDeque.isEmpty()) {
                    String poll = arrayDeque.poll();
                    if (arrayDeque.isEmpty()) {
                        if (obj3 instanceof JSONObject) {
                            string.hashCode();
                            switch (string.hashCode()) {
                                case -1068795718:
                                    if (string.equals("modify")) {
                                        c2 = 0;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -934610812:
                                    if (string.equals("remove")) {
                                        c2 = 1;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 103785528:
                                    if (string.equals("merge")) {
                                        c2 = 2;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                            switch (c2) {
                                case 0:
                                    ((JSONObject) obj3).put(poll, obj2);
                                    if (z) {
                                        break;
                                    } else {
                                        p(dXRecyclerLayout, (JSONObject) obj, i, falcoSpan);
                                        break;
                                    }
                                case 1:
                                    ((JSONObject) obj3).remove(poll);
                                    if (z) {
                                        break;
                                    } else {
                                        p(dXRecyclerLayout, (JSONObject) obj, i, falcoSpan);
                                        break;
                                    }
                                case 2:
                                    Object obj4 = ((JSONObject) obj3).get(poll);
                                    if ((obj4 instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                                        ((JSONObject) obj4).putAll((JSONObject) obj2);
                                        if (z) {
                                            break;
                                        } else {
                                            p(dXRecyclerLayout, (JSONObject) obj, i, falcoSpan);
                                            break;
                                        }
                                    } else {
                                        return false;
                                    }
                                default:
                                    return false;
                            }
                        } else if (obj3 instanceof JSONArray) {
                            try {
                                int parseInt = Integer.parseInt(poll);
                                string.hashCode();
                                switch (string.hashCode()) {
                                    case -1068795718:
                                        if (string.equals("modify")) {
                                            c = 0;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -934610812:
                                        if (string.equals("remove")) {
                                            c = 1;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 103785528:
                                        if (string.equals("merge")) {
                                            c = 2;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    default:
                                        c = 65535;
                                        break;
                                }
                                switch (c) {
                                    case 0:
                                        ((JSONArray) obj3).set(parseInt, obj2);
                                        if (!(obj instanceof JSONObject)) {
                                            break;
                                        } else {
                                            p(dXRecyclerLayout, (JSONObject) obj, i, falcoSpan);
                                            break;
                                        }
                                    case 1:
                                        ((JSONArray) obj3).remove(parseInt);
                                        if (!(obj instanceof JSONObject)) {
                                            break;
                                        } else {
                                            p(dXRecyclerLayout, (JSONObject) obj, i, falcoSpan);
                                            break;
                                        }
                                    case 2:
                                        Object obj5 = ((JSONArray) obj3).get(parseInt);
                                        if ((obj5 instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                                            ((JSONObject) obj5).putAll((JSONObject) obj2);
                                            if (!(obj instanceof JSONObject)) {
                                                break;
                                            } else {
                                                p(dXRecyclerLayout, (JSONObject) obj, i, falcoSpan);
                                                break;
                                            }
                                        } else {
                                            return false;
                                        }
                                    default:
                                        return false;
                                }
                            } catch (Exception unused) {
                                return false;
                            }
                        }
                    } else if (!(obj3 instanceof JSONObject)) {
                        return false;
                    } else {
                        obj3 = ((JSONObject) obj3).get(poll);
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009f A[SYNTHETIC] */
    private boolean s(DXRecyclerLayout dXRecyclerLayout, List<Object> list, Object obj, String str) {
        boolean z;
        int i;
        IDXDataSourceManager f;
        int i2;
        Exception e;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Object obj2 = list.get(i3);
            if (obj2 instanceof JSONObject) {
                try {
                    z = ((JSONObject) obj2).getBoolean("isRelative").booleanValue();
                    try {
                        i = ((JSONObject) obj2).getIntValue("offset");
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    z = false;
                    e.printStackTrace();
                    i = -1;
                    f = f(dXRecyclerLayout);
                    if (z) {
                    }
                    i2 = i;
                    f.removeItem(i2);
                    e(dXRecyclerLayout).remove(i2);
                    if (!"part".equals(str)) {
                    }
                }
                f = f(dXRecyclerLayout);
                if (!(i == -1 || f == null || f.isItemsNull())) {
                    if (z || !(obj instanceof DXWidgetNode)) {
                        i2 = i;
                    } else {
                        DXTemplateWidgetNode h = h((DXWidgetNode) obj);
                        if (h == null) {
                            m(dXRecyclerLayout, e.DX_ERROR_CODE_RECYCLER_LAYOUT_230003, "");
                            return false;
                        }
                        i2 = f.indexOfItem(h) + i;
                    }
                    if (i2 >= 0 && i2 < f.getRealCount()) {
                        f.removeItem(i2);
                    }
                    if (i2 >= 0 && i2 < e(dXRecyclerLayout).size()) {
                        e(dXRecyclerLayout).remove(i2);
                    }
                    if (!"part".equals(str)) {
                        l(dXRecyclerLayout, "part", i2, 1, DXRecyclerLayout.MSG_METHOD_DELETE_ITEMS, true);
                    }
                }
            }
        }
        if (!(TextUtils.isEmpty(str) || "all".equals(str))) {
            return true;
        }
        k(dXRecyclerLayout);
        return true;
    }

    private List<Object> t(DXRuntimeContext dXRuntimeContext, JSONObject jSONObject) {
        try {
            return jSONObject.getJSONArray("data");
        } catch (Exception e) {
            e.printStackTrace();
            if (dXRuntimeContext == null) {
                return null;
            }
            try {
                if (dXRuntimeContext.supportDataProxy()) {
                    return (List) jSONObject.get("data");
                }
                return null;
            } catch (Exception e2) {
                vx.b(e2);
                return null;
            }
        }
    }

    private int u(DXRecyclerLayout dXRecyclerLayout, boolean z, int i, int i2, Object obj) {
        IDXDataSourceManager f;
        if (!z) {
            return i2;
        }
        if (i > 0) {
            return i2 + i;
        }
        if (!(obj instanceof DXWidgetNode) || (f = f(dXRecyclerLayout)) == null) {
            return -1;
        }
        return f.indexOfItem(h((DXWidgetNode) obj)) + i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0044 A[SYNTHETIC] */
    private boolean v(DXRecyclerLayout dXRecyclerLayout, List<Object> list, Object obj, FalcoSpan falcoSpan, String str) {
        int i;
        boolean z;
        Exception e;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Object obj2 = list.get(i2);
            if (obj2 instanceof JSONObject) {
                JSONObject jSONObject = null;
                try {
                    z = ((JSONObject) obj2).getBoolean("isRelative").booleanValue();
                    try {
                        i = ((JSONObject) obj2).getIntValue("offset");
                        try {
                            jSONObject = ((JSONObject) obj2).getJSONObject("data");
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        i = -1;
                        e.printStackTrace();
                        if (jSONObject == null) {
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    z = false;
                    i = -1;
                    e.printStackTrace();
                    if (jSONObject == null) {
                    }
                }
                if (jSONObject == null) {
                    return false;
                }
                IDXDataSourceManager f = f(dXRecyclerLayout);
                if (!(i == -1 || f == null || f.isItemsNull())) {
                    if (z && (obj instanceof DXWidgetNode)) {
                        DXTemplateWidgetNode h = h((DXWidgetNode) obj);
                        if (h == null) {
                            return false;
                        }
                        i = f.indexOfItem(h) + i;
                    }
                    if (e(dXRecyclerLayout) != null && i >= 0 && i <= e(dXRecyclerLayout).size()) {
                        e(dXRecyclerLayout).add(i, jSONObject);
                    }
                    DXWidgetNode c = c(dXRecyclerLayout, jSONObject, g(dXRecyclerLayout), i, falcoSpan);
                    if (i >= 0 && i <= f.getRealCount()) {
                        f.addItem(i, c);
                    }
                    if ("part".equals(str)) {
                        if (at.u0()) {
                            l(dXRecyclerLayout, str, i, 1, DXRecyclerLayout.MSG_METHOD_INSERT_ITEMS, false);
                        } else {
                            l(dXRecyclerLayout, str, i, 1, DXRecyclerLayout.MSG_METHOD_INSERT_ITEMS, true);
                        }
                    }
                }
            }
        }
        if (!"all".equals(str)) {
            return true;
        }
        k(dXRecyclerLayout);
        return true;
    }

    private boolean w(DXRecyclerLayout dXRecyclerLayout, List<Object> list, DXWidgetNode dXWidgetNode, int i, boolean z, FalcoSpan falcoSpan) {
        if (list == null || dXWidgetNode == null) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            Object obj = list.get(i2);
            if (obj != null) {
                int i3 = i + i2;
                IDXDataSourceManager f = f(dXRecyclerLayout);
                if (f == null) {
                    return false;
                }
                if (z) {
                    DXTemplateWidgetNode h = h(dXWidgetNode);
                    if (h == null) {
                        return false;
                    }
                    i3 = f.indexOfItem(h) + i;
                }
                if (e(dXRecyclerLayout) != null && i3 >= 0 && i3 < e(dXRecyclerLayout).size()) {
                    e(dXRecyclerLayout).add(i3, obj);
                }
                DXWidgetNode c = c(dXRecyclerLayout, obj, g(dXRecyclerLayout), i3, falcoSpan);
                if (i3 >= 0 && i3 < f.getRealCount()) {
                    f.addItem(i3, c);
                }
            }
        }
        k(dXRecyclerLayout);
        return true;
    }

    private void x(String str, Queue<String> queue) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, " .[]", false);
        while (stringTokenizer.hasMoreTokens()) {
            queue.offer(stringTokenizer.nextToken());
        }
    }

    private boolean z(DXRecyclerLayout dXRecyclerLayout, JSONArray jSONArray, int i, FalcoSpan falcoSpan) {
        return A(dXRecyclerLayout, jSONArray, i, false, falcoSpan);
    }

    @Override // tb.sz
    public boolean a(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        List<Object> t = t(dXRecyclerLayout.getDXRuntimeContext(), jSONObject);
        if (t == null || t.isEmpty()) {
            return false;
        }
        r(dXRecyclerLayout, t, g(dXRecyclerLayout), falcoSpan, jSONObject.getString("refreshType"));
        return true;
    }

    @Override // tb.sz
    public boolean b(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject) {
        IDXDataSourceManager f;
        List<Object> t = t(dXRecyclerLayout.getDXRuntimeContext(), jSONObject);
        if (t == null || t.isEmpty() || (f = f(dXRecyclerLayout)) == null || f.isItemsNull() || f.isItemsEmpty()) {
            return false;
        }
        return s(dXRecyclerLayout, t, jSONObject.get("current"), jSONObject.getString("refreshType"));
    }

    @Override // tb.sz
    public boolean i(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        IDXDataSourceManager f;
        List<Object> t = t(dXRecyclerLayout.getDXRuntimeContext(), jSONObject);
        if (t == null || t.isEmpty() || (f = f(dXRecyclerLayout)) == null || f.isItemsNull()) {
            return false;
        }
        return v(dXRecyclerLayout, t, jSONObject.get("current"), falcoSpan, (String) g31.b("refreshType", jSONObject, "all"));
    }

    @Override // tb.sz
    public boolean j(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        List<Object> t;
        IDXDataSourceManager f = f(dXRecyclerLayout);
        if (f == null || f.isItemsNull() || f.isItemsEmpty() || (t = t(dXRecyclerLayout.getDXRuntimeContext(), jSONObject)) == null || t.isEmpty()) {
            return false;
        }
        return w(dXRecyclerLayout, t, (DXWidgetNode) g31.b("current", jSONObject, null), g31.d("offset", jSONObject, -1), g31.c("isRelative", jSONObject, Boolean.FALSE).booleanValue(), falcoSpan);
    }

    @Override // tb.sz
    public boolean n(DXRecyclerLayout dXRecyclerLayout, JSONObject jSONObject, FalcoSpan falcoSpan) {
        JSONArray jSONArray;
        IDXDataSourceManager f;
        try {
            jSONArray = jSONObject.getJSONArray("actions");
        } catch (Exception e) {
            e.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray != null && !jSONArray.isEmpty() && (f = f(dXRecyclerLayout)) != null && !f.isItemsNull() && !f.isItemsEmpty()) {
            boolean z = false;
            for (int i = 0; i < e(dXRecyclerLayout).size(); i++) {
                if (z(dXRecyclerLayout, jSONArray, i, falcoSpan)) {
                    z = true;
                }
            }
            if (z) {
                k(dXRecyclerLayout);
                return true;
            }
        }
        return false;
    }

    @Override // tb.sz
    public boolean o(DXRecyclerLayout dXRecyclerLayout, JSONObject jSONObject, boolean z, FalcoSpan falcoSpan) {
        JSONArray jSONArray;
        Object obj = jSONObject.get("current");
        boolean z2 = false;
        if (obj == null) {
            return false;
        }
        try {
            jSONArray = jSONObject.getJSONArray("actions");
        } catch (Exception e) {
            e.printStackTrace();
            jSONArray = null;
        }
        dXRecyclerLayout.getDXRuntimeContext().getDataProxy();
        JSONObject jSONObject2 = jSONObject.getJSONObject("item_data");
        if (jSONArray == null || jSONArray.isEmpty()) {
            if (jSONObject2 != null && (obj instanceof DXWidgetNode)) {
                return y(dXRecyclerLayout, (DXWidgetNode) obj, jSONObject2, false);
            }
        } else if (obj instanceof DXWidgetNode) {
            DXTemplateWidgetNode h = h((DXWidgetNode) obj);
            IDXDataSourceManager f = f(dXRecyclerLayout);
            if (h == null || f == null) {
                return false;
            }
            int indexOfItem = f.indexOfItem(h);
            boolean A = A(dXRecyclerLayout, jSONArray, indexOfItem, z, falcoSpan);
            if (z) {
                return A;
            }
            if (A) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("params");
                if (jSONObject3 != null) {
                    z2 = jSONObject3.getBooleanValue("refreshPart");
                }
                if (!z2) {
                    k(dXRecyclerLayout);
                    return true;
                } else if (at.u0()) {
                    l(dXRecyclerLayout, "part", indexOfItem, 1, DXRecyclerLayout.MSG_METHOD_UPDATE_CURRENT, false);
                    return true;
                } else {
                    l(dXRecyclerLayout, "part", indexOfItem, 1, DXRecyclerLayout.MSG_METHOD_UPDATE_CURRENT, true);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0094 A[ADDED_TO_REGION] */
    @Override // tb.sz
    public boolean q(DXRecyclerLayout dXRecyclerLayout, JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        boolean z;
        Integer num;
        JSONObject jSONObject2;
        JSONArray jSONArray3;
        Exception e;
        Object obj = jSONObject.get("current");
        try {
            jSONArray = jSONObject.getJSONArray("data");
        } catch (Exception e2) {
            e2.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray != null && !jSONArray.isEmpty()) {
            boolean z2 = false;
            for (int i = 0; i < jSONArray.size(); i++) {
                Object obj2 = jSONArray.get(i);
                if (obj2 instanceof JSONObject) {
                    try {
                        num = ((JSONObject) obj2).getInteger("offset");
                        try {
                            jSONArray3 = ((JSONObject) obj2).getJSONArray("actions");
                            try {
                                z = ((JSONObject) obj2).getBoolean("isRelative").booleanValue();
                                try {
                                    jSONObject2 = ((JSONObject) obj2).getJSONObject("item_data");
                                    jSONArray2 = jSONArray3;
                                } catch (Exception e3) {
                                    e = e3;
                                    e.printStackTrace();
                                    jSONArray2 = jSONArray3;
                                    jSONObject2 = null;
                                    if (jSONObject2 == null) {
                                    }
                                    z2 = true;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                z = false;
                                e.printStackTrace();
                                jSONArray2 = jSONArray3;
                                jSONObject2 = null;
                                if (jSONObject2 == null) {
                                }
                                z2 = true;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            jSONArray3 = null;
                            z = false;
                            e.printStackTrace();
                            jSONArray2 = jSONArray3;
                            jSONObject2 = null;
                            if (jSONObject2 == null) {
                            }
                            z2 = true;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        num = null;
                        jSONArray3 = null;
                        z = false;
                        e.printStackTrace();
                        jSONArray2 = jSONArray3;
                        jSONObject2 = null;
                        if (jSONObject2 == null) {
                        }
                        z2 = true;
                    }
                    if (jSONObject2 == null) {
                        if (num != null) {
                            if (jSONArray2 != null) {
                                if (!jSONArray2.isEmpty()) {
                                    if (!z(dXRecyclerLayout, jSONArray2, u(dXRecyclerLayout, z, -1, num.intValue(), obj), null)) {
                                    }
                                }
                            }
                        }
                    } else if (num != null && !jSONObject2.isEmpty()) {
                        int u = u(dXRecyclerLayout, z, -1, num.intValue(), obj);
                        p(dXRecyclerLayout, jSONObject2, u, null);
                        if (u < 0) {
                        }
                    }
                    z2 = true;
                }
            }
            if (z2) {
                k(dXRecyclerLayout);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void r(DXRecyclerLayout dXRecyclerLayout, List<Object> list, List<DXWidgetNode> list2, FalcoSpan falcoSpan, String str) {
        int i = -1;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Object obj = list.get(i3);
            if (obj instanceof JSONObject) {
                IDXDataSourceManager f = f(dXRecyclerLayout);
                if (f != null && !f.isItemsNull()) {
                    if (e(dXRecyclerLayout) != null) {
                        if (i < 0) {
                            i = e(dXRecyclerLayout).size();
                        }
                        e(dXRecyclerLayout).add(obj);
                        i2++;
                    }
                    int i4 = i + i3;
                    f.addItem(i4, c(dXRecyclerLayout, obj, list2, i4, falcoSpan));
                }
            } else {
                ry.g("DXRecyclerOperatorCommon", "no setData for append!!!");
            }
        }
        if (i >= 0 && i2 > 0) {
            if (at.u0()) {
                l(dXRecyclerLayout, "part", i, i2, DXRecyclerLayout.MSG_METHOD_APPEND_ITEMS, false);
            } else {
                l(dXRecyclerLayout, "part", i, i2, DXRecyclerLayout.MSG_METHOD_APPEND_ITEMS, true);
            }
        }
    }

    public boolean y(DXRecyclerLayout dXRecyclerLayout, DXWidgetNode dXWidgetNode, Object obj, boolean z) {
        DXTemplateWidgetNode h = h(dXWidgetNode);
        IDXDataSourceManager f = f(dXRecyclerLayout);
        if (h == null || f == null) {
            return false;
        }
        int indexOfItem = f.indexOfItem(h);
        if (indexOfItem < 0) {
            m(dXRecyclerLayout, e.DX_ERROR_CODE_RECYCLER_LAYOUT_230005, "index: " + indexOfItem);
            return false;
        }
        wz.e(" updateCurrent 获取到的index 为" + indexOfItem);
        p(dXRecyclerLayout, obj, indexOfItem, null);
        if (z) {
            return true;
        }
        if (at.u0()) {
            l(dXRecyclerLayout, "part", indexOfItem, 1, DXRecyclerLayout.MSG_METHOD_UPDATE_CURRENT, false);
            return true;
        }
        l(dXRecyclerLayout, "part", indexOfItem, 1, DXRecyclerLayout.MSG_METHOD_UPDATE_CURRENT, true);
        return true;
    }
}
