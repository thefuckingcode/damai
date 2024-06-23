package com.taobao.android.dinamicx;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.model.DXJSONObjectForVM;
import com.taobao.android.dinamicx.notification.DXNotificationCenter;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.f;
import java.util.ArrayList;
import tb.at;
import tb.c00;
import tb.qy;
import tb.ry;
import tb.w00;
import tb.wz;

/* compiled from: Taobao */
public class DXRemoteChildTemplateManager {
    public static final ThreadLocal<Boolean> needNotifyMap = new a();

    /* compiled from: Taobao */
    static class a extends ThreadLocal<Boolean> {
        a() {
        }

        /* access modifiers changed from: protected */
        @Nullable
        /* renamed from: a */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements IDXDownloadCallback {
        final /* synthetic */ DXTemplateManager a;
        final /* synthetic */ DXRuntimeContext b;
        final /* synthetic */ DXTemplateWidgetNode c;
        final /* synthetic */ int d;

        b(DXTemplateManager dXTemplateManager, DXRuntimeContext dXRuntimeContext, DXTemplateWidgetNode dXTemplateWidgetNode, int i) {
            this.a = dXTemplateManager;
            this.b = dXRuntimeContext;
            this.c = dXTemplateWidgetNode;
            this.d = i;
        }

        @Override // com.taobao.android.dinamicx.IDXDownloadCallback
        public void callback(DXTemplateItem dXTemplateItem) {
            DXTemplateItem h = this.a.h(dXTemplateItem);
            if (DinamicXEngine.x()) {
                ry.b("DXRemoteChildTemplateManager", "模版" + h.getIdentifier() + "下载完成，开始构建  thread " + Thread.currentThread().getName());
            }
            if (h.getIdentifier().equals(dXTemplateItem.getIdentifier())) {
                DXRemoteChildTemplateManager.needNotifyMap.set(Boolean.TRUE);
                DXRemoteChildTemplateManager.this.d(this.a, h, this.b, this.c, this.d);
            }
        }
    }

    private void c(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode != null) {
            dXWidgetNode.setSourceWidget(dXWidgetNode);
        }
        if ((dXWidgetNode instanceof f) && dXWidgetNode.getChildrenCount() > 0) {
            if (!at.p0() || dXWidgetNode.getDataParsersExprNode() == null || dXWidgetNode.getDataParsersExprNode().indexOfKey(qy.DX_PARSER_LISTDATA) <= -1) {
                for (DXWidgetNode dXWidgetNode2 : ((f) dXWidgetNode).getChildren()) {
                    c(dXWidgetNode2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized boolean d(DXTemplateManager dXTemplateManager, DXTemplateItem dXTemplateItem, DXRuntimeContext dXRuntimeContext, DXTemplateWidgetNode dXTemplateWidgetNode, int i) {
        DXWidgetNode e = e(dXTemplateItem, dXRuntimeContext, dXTemplateManager, i);
        if (e == null || dXTemplateWidgetNode == null) {
            wz.b("createAndBindTree 失败");
            return false;
        }
        dXTemplateWidgetNode.addChild(e, false);
        dXTemplateWidgetNode.setData(e.getDXRuntimeContext().getData());
        new m().f(e);
        return true;
    }

    private boolean k() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(DXRuntimeContext dXRuntimeContext) {
        DXNotificationCenter dXNotificationCenter = dXRuntimeContext.getEngineContext().e().l;
        if (dXNotificationCenter != null) {
            w00 w00 = new w00();
            w00.a = dXRuntimeContext.dxTemplateItem;
            w00.d = dXRuntimeContext.getDxUserContext();
            w00.b = dXRuntimeContext.getData();
            w00.c = 1004;
            dXNotificationCenter.f(w00);
        }
    }

    public DXWidgetNode e(DXTemplateItem dXTemplateItem, DXRuntimeContext dXRuntimeContext, DXTemplateManager dXTemplateManager, int i) {
        if (dXTemplateManager == null || dXTemplateItem == null || dXRuntimeContext == null) {
            return null;
        }
        DXRuntimeContext cloneWithWidgetNode = dXRuntimeContext.cloneWithWidgetNode(null);
        if (dXRuntimeContext.getSubData() instanceof JSONObject) {
            wz.e("替换掉remote子template的数据");
            cloneWithWidgetNode.setData((JSONObject) dXRuntimeContext.getSubData());
        } else if (dXRuntimeContext.supportDataProxy() && (dXRuntimeContext.getSubData() instanceof Object)) {
            DXJSONObjectForVM dXJSONObjectForVM = new DXJSONObjectForVM();
            dXJSONObjectForVM.setData(dXRuntimeContext.getSubData());
            cloneWithWidgetNode.setData(dXJSONObjectForVM);
        }
        cloneWithWidgetNode.setDxTemplateItem(dXTemplateItem);
        DXWidgetNode j = dXTemplateManager.j(cloneWithWidgetNode);
        if (j == null) {
            wz.b("DXRemoteChildTemplateManager createExpandWtSync manager.getTemplateWT(cloneRtx) == null");
            return null;
        }
        if (j.getDXRuntimeContext() != null && j.getDXRuntimeContext().hasError()) {
            cloneWithWidgetNode.dxError.c.addAll(j.getDXRuntimeContext().dxError.c);
        }
        DXWidgetNode deepClone = j.deepClone(cloneWithWidgetNode);
        if (i == 1) {
            c(deepClone);
        }
        return deepClone;
    }

    public boolean f(DXTemplateItem dXTemplateItem, DXRuntimeContext dXRuntimeContext, DXTemplateWidgetNode dXTemplateWidgetNode, DXTemplateManager dXTemplateManager) {
        if (!(dXTemplateManager == null || dXTemplateItem == null)) {
            if (DinamicXEngine.x()) {
                ry.a("DXRemoteChildTemplateManager 开始下载模版 " + dXTemplateItem.getIdentifier());
            }
            ArrayList arrayList = new ArrayList();
            dXTemplateItem.setTemplateType(1);
            arrayList.add(dXTemplateItem);
            dXTemplateManager.f(arrayList);
        }
        return false;
    }

    public DXTemplateItem g(DXTemplateManager dXTemplateManager, DXTemplateItem dXTemplateItem) {
        if (dXTemplateItem == null) {
            return null;
        }
        return dXTemplateManager.h(dXTemplateItem);
    }

    public DXTemplateManager h(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null || dXRuntimeContext.getEngineContext() == null || dXRuntimeContext.getEngineContext().e() == null) {
            return null;
        }
        return dXRuntimeContext.getEngineContext().e().j;
    }

    public boolean i(DXTemplateItem dXTemplateItem, DXTemplateItem dXTemplateItem2) {
        return dXTemplateItem != null && dXTemplateItem2 != null && dXTemplateItem.version == dXTemplateItem2.version && dXTemplateItem.name.equals(dXTemplateItem2.name);
    }

    public boolean j(final DXTemplateItem dXTemplateItem, final DXRuntimeContext dXRuntimeContext, final DXTemplateWidgetNode dXTemplateWidgetNode, final DXTemplateManager dXTemplateManager, final int i) {
        boolean k = k();
        if (dXTemplateItem == null) {
            return false;
        }
        if (k) {
            c00.p(new Runnable() {
                /* class com.taobao.android.dinamicx.DXRemoteChildTemplateManager.AnonymousClass2 */

                public void run() {
                    if (DinamicXEngine.x()) {
                        ry.b("DXRemoteChildLoadTask", "开始在子线程处理的remote模版" + dXTemplateItem.getIdentifier() + " threadId " + Thread.currentThread().getName());
                    }
                    DXRemoteChildTemplateManager.this.m(dXTemplateManager, dXTemplateItem, dXRuntimeContext, dXTemplateWidgetNode, i);
                    ry.b("DXRemoteChildLoadTask", "处理完所有的remote模版，准备回调");
                    ThreadLocal<Boolean> threadLocal = DXRemoteChildTemplateManager.needNotifyMap;
                    if (threadLocal.get().booleanValue()) {
                        ry.a("通知外层进行刷新");
                        threadLocal.set(Boolean.FALSE);
                        DXRemoteChildTemplateManager.this.l(dXRuntimeContext);
                        return;
                    }
                    ry.a("不需要通知外层进行刷新");
                }
            });
        } else {
            if (DinamicXEngine.x()) {
                ry.b("DXRemoteChildLoadTask", "开始在当前线程处理的remote模版" + dXTemplateItem.getIdentifier());
            }
            m(dXTemplateManager, dXTemplateItem, dXRuntimeContext, dXTemplateWidgetNode, i);
        }
        return true;
    }

    public DXWidgetNode m(DXTemplateManager dXTemplateManager, DXTemplateItem dXTemplateItem, DXRuntimeContext dXRuntimeContext, DXTemplateWidgetNode dXTemplateWidgetNode, int i) {
        DXTemplateItem h = dXTemplateManager.h(dXTemplateItem);
        if (h == null || !h.getIdentifier().equals(dXTemplateItem.getIdentifier())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(dXTemplateItem);
            if (DinamicXEngine.x()) {
                ry.b("DXRemoteChildTemplateManager", "模版" + dXTemplateItem.getIdentifier() + "不存在，开始下载");
            }
            dXTemplateManager.g(arrayList, new b(dXTemplateManager, dXRuntimeContext, dXTemplateWidgetNode, i), false);
            return null;
        }
        d(dXTemplateManager, h, dXRuntimeContext, dXTemplateWidgetNode, i);
        if (DinamicXEngine.x()) {
            ry.b("DXRemoteChildTemplateManager", "模版" + h.getIdentifier() + "已经存在，直接构建构建完成");
        }
        return null;
    }
}
