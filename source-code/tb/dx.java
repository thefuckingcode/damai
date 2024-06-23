package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoContainerSpan;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.m;
import com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.DXDataSourceLruManager;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class dx implements IDXDataSourceManager {
    protected m a;
    private List<Object> b;
    private List<DXWidgetNode> c;
    protected DXDataSourceLruManager d;

    public dx(DXDataSourceLruManager dXDataSourceLruManager) {
        this.d = dXDataSourceLruManager;
    }

    private void g(DXTemplateWidgetNode dXTemplateWidgetNode) {
        if (this.a == null) {
            this.a = new m();
        }
        this.a.h(dXTemplateWidgetNode, true);
        if (!TextUtils.isEmpty(dXTemplateWidgetNode.getSlotId())) {
            dXTemplateWidgetNode.processContainsSlotIdTemplate();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0120  */
    public DXTemplateWidgetNode a(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, DXWidgetNode dXWidgetNode, Object obj, List<Object> list, int i, FalcoSpan falcoSpan, boolean z) {
        FalcoContainerSpan falcoContainerSpan;
        Throwable th;
        DXWidgetNode queryRootWidgetNode;
        if (dXWidgetNode instanceof DXTemplateWidgetNode) {
            Map<String, String> j = dz.j(falcoSpan);
            if (j == null && (queryRootWidgetNode = dXWidgetNode.queryRootWidgetNode()) != null && (queryRootWidgetNode.getParentWidget() instanceof DXTemplateWidgetNode)) {
                j = dz.j(((DXTemplateWidgetNode) queryRootWidgetNode.getParentWidget()).getSpan());
            }
            DXRuntimeContext cloneWithWidgetNode = dXWidgetNode.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode);
            if (j != null) {
                try {
                    falcoContainerSpan = dz.e(j, "DX", DinamicXEngine.RENDER_TEMPLATE);
                    try {
                        dz.q(falcoContainerSpan, "deepCopyChildForTemplate", ((DXTemplateWidgetNode) dXWidgetNode).getName() + JSMethod.NOT_SET + ((DXTemplateWidgetNode) dXWidgetNode).getVersion() + "_index_" + i);
                        cloneWithWidgetNode.setOpenTracerSpan(falcoContainerSpan);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    falcoContainerSpan = null;
                    th.getStackTrace();
                    cloneWithWidgetNode.setSubData(obj);
                    cloneWithWidgetNode.setSubdataIndex(i);
                    HashMap hashMap = new HashMap();
                    cloneWithWidgetNode.setEnv(hashMap);
                    hashMap.put("i", ey.J((long) i));
                    if (!(list instanceof JSONArray)) {
                    }
                    DXWidgetNode deepCopyChildNode = ((DXTemplateWidgetNode) dXWidgetNode).deepCopyChildNode(cloneWithWidgetNode);
                    ((DXTemplateWidgetNode) deepCopyChildNode).setSpan(falcoContainerSpan);
                    deepCopyChildNode.setParentWidget(dXAbsContainerBaseLayout);
                    if (!at.u0()) {
                    }
                    return (DXTemplateWidgetNode) deepCopyChildNode;
                }
            } else {
                falcoContainerSpan = null;
            }
            cloneWithWidgetNode.setSubData(obj);
            cloneWithWidgetNode.setSubdataIndex(i);
            HashMap hashMap2 = new HashMap();
            cloneWithWidgetNode.setEnv(hashMap2);
            hashMap2.put("i", ey.J((long) i));
            if (!(list instanceof JSONArray)) {
                hashMap2.put("dataSource", ey.E((JSONArray) list));
            } else {
                cloneWithWidgetNode.getDataProxy();
            }
            if (z || uz.a(dXWidgetNode, cloneWithWidgetNode)) {
                DXWidgetNode deepCopyChildNode2 = ((DXTemplateWidgetNode) dXWidgetNode).deepCopyChildNode(cloneWithWidgetNode);
                ((DXTemplateWidgetNode) deepCopyChildNode2).setSpan(falcoContainerSpan);
                deepCopyChildNode2.setParentWidget(dXAbsContainerBaseLayout);
                if (!at.u0()) {
                    if (!(deepCopyChildNode2.getDataParsersExprNode() == null || !(deepCopyChildNode2.getParentWidget() instanceof DXRecyclerLayout) || deepCopyChildNode2.getDataParsersExprNode().get(10297924263834610L) == null)) {
                        try {
                            Object b2 = deepCopyChildNode2.getDataParsersExprNode().get(10297924263834610L).b(null, deepCopyChildNode2.getDXRuntimeContext());
                            if (b2 instanceof String) {
                                deepCopyChildNode2.setStringAttribute(10297924263834610L, String.valueOf(b2));
                            }
                            if (!TextUtils.isEmpty(deepCopyChildNode2.getUserId())) {
                                ((DXRecyclerLayout) deepCopyChildNode2.getParentWidget()).getCellUserId2PositionMap().put(deepCopyChildNode2.getUserId(), Integer.valueOf(i));
                            }
                        } catch (Exception unused) {
                        }
                    }
                    DXTemplateWidgetNode dXTemplateWidgetNode = (DXTemplateWidgetNode) deepCopyChildNode2;
                    dXTemplateWidgetNode.setDataIndex(i);
                    g(dXTemplateWidgetNode);
                } else {
                    uz.c((DXTemplateWidgetNode) deepCopyChildNode2);
                }
                return (DXTemplateWidgetNode) deepCopyChildNode2;
            }
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void addAllItem(int i, Collection<DXWidgetNode> collection) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            dXDataSourceLruManager.addAllItem(i, collection);
            return;
        }
        List<DXWidgetNode> list = this.c;
        if (list != null) {
            list.addAll(i, collection);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void addItem(DXWidgetNode dXWidgetNode) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            dXDataSourceLruManager.addItem(dXWidgetNode);
            return;
        }
        List<DXWidgetNode> list = this.c;
        if (list != null) {
            list.add(dXWidgetNode);
        }
    }

    public DXWidgetNode b(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, @NonNull Object obj, List<Object> list, List<DXWidgetNode> list2, int i, FalcoSpan falcoSpan) {
        return null;
    }

    public List<DXWidgetNode> c(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, @NonNull JSONObject jSONObject, List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        return null;
    }

    public ArrayList<DXWidgetNode> d(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        throw null;
    }

    public List<Object> e() {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.a();
        }
        return this.b;
    }

    public List<DXWidgetNode> f() {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.b();
        }
        return this.c;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public DXWidgetNode getItem(int i) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.getItem(i);
        }
        List<DXWidgetNode> list = this.c;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public int getItemSize() {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.getItemSize();
        }
        List<DXWidgetNode> list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public int getRealCount() {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.getRealCount();
        }
        List<Object> list = this.b;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.b.size();
    }

    public void h(List<Object> list) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            dXDataSourceLruManager.d(list);
        } else {
            this.b = list;
        }
    }

    public void i(List<DXWidgetNode> list) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            dXDataSourceLruManager.e(list);
        } else {
            this.c = list;
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public int indexOfItem(DXWidgetNode dXWidgetNode) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.indexOfItem(dXWidgetNode);
        }
        List<DXWidgetNode> list = this.c;
        if (list == null) {
            return -1;
        }
        return list.indexOf(dXWidgetNode);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public boolean isItemsEmpty() {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.isItemsEmpty();
        }
        List<DXWidgetNode> list = this.c;
        if (list == null) {
            return true;
        }
        return list.isEmpty();
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public boolean isItemsNull() {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.isItemsNull();
        }
        return this.c == null;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public DXWidgetNode removeItem(int i) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.removeItem(i);
        }
        List<DXWidgetNode> list = this.c;
        if (list == null) {
            return null;
        }
        return list.remove(i);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void setItem(int i, DXWidgetNode dXWidgetNode) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            dXDataSourceLruManager.setItem(i, dXWidgetNode);
            return;
        }
        List<DXWidgetNode> list = this.c;
        if (list != null) {
            list.set(i, dXWidgetNode);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void addItem(int i, DXWidgetNode dXWidgetNode) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            dXDataSourceLruManager.addItem(i, dXWidgetNode);
            return;
        }
        List<DXWidgetNode> list = this.c;
        if (list != null) {
            list.add(i, dXWidgetNode);
        }
    }
}
