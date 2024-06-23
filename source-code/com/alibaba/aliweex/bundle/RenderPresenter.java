package com.alibaba.aliweex.bundle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.alibaba.aliweex.AliWXSDKEngine;
import com.alibaba.aliweex.AliWXSDKInstance;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.bundle.WeexPageContract;
import com.alibaba.aliweex.bundle.f;
import com.alibaba.aliweex.utils.MemoryMonitor;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.RenderContainer;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.render.WXAbstractRenderContainer;
import com.taobao.weex.ui.component.NestedContainer;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tb.ct2;
import tb.ox2;
import tb.px2;
import tb.qx2;
import tb.tx2;
import tb.vx2;

/* compiled from: Taobao */
public class RenderPresenter implements WeexPageContract.IRenderPresenter {
    private static String r = "weex_sandbox";
    private Activity a;
    private WXSDKInstance b;
    private String c;
    private Map<String, Object> d;
    private String e;
    private String f;
    private String g;
    private String h;
    protected String i;
    protected f j;
    private WeexPageContract.IUTPresenter k;
    private WeexPageContract.IDynamicUrlPresenter l;
    private WeexPageContract.IProgressBar m;
    private IWXRenderListener n;
    private WeexPageContract.IUrlValidate o;
    protected ox2 p;
    private WXAbstractRenderContainer q = null;

    /* compiled from: Taobao */
    class a implements MemoryMonitor.MemoryListener {
        a() {
        }

        @Override // com.alibaba.aliweex.utils.MemoryMonitor.MemoryListener
        public void onChange(String str) {
            ArrayList<f.b> c;
            WXSDKInstance c2;
            HashMap hashMap = new HashMap(1);
            hashMap.put("evaluatedStatus", str);
            RenderPresenter renderPresenter = RenderPresenter.this;
            renderPresenter.e(renderPresenter.b, "memoryevaluated", hashMap);
            f fVar = RenderPresenter.this.j;
            if (fVar != null && (c = fVar.c()) != null && c.size() != 0) {
                Iterator<f.b> it = c.iterator();
                while (it.hasNext()) {
                    f.a aVar = it.next().b;
                    if (!(aVar == null || (c2 = aVar.c()) == null)) {
                        RenderPresenter.this.e(c2, "memoryevaluated", hashMap);
                    }
                }
            }
        }
    }

    public RenderPresenter(Activity activity, String str, IWXRenderListener iWXRenderListener, WeexPageContract.IUTPresenter iUTPresenter, WeexPageContract.IDynamicUrlPresenter iDynamicUrlPresenter, WeexPageContract.IProgressBar iProgressBar, ox2 ox2, WeexPageContract.IUrlValidate iUrlValidate) {
        this.a = activity;
        this.i = str;
        this.n = iWXRenderListener;
        this.k = iUTPresenter;
        this.l = iDynamicUrlPresenter;
        this.m = iProgressBar;
        this.o = iUrlValidate;
        this.j = new f(activity, iUrlValidate.getHandler());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d(WXSDKInstance wXSDKInstance, String str, Map<String, Object> map) {
        if (wXSDKInstance != null && wXSDKInstance.getRootComponent() != null) {
            wXSDKInstance.fireEvent(wXSDKInstance.getRootComponent().getRef(), str, map);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e(final WXSDKInstance wXSDKInstance, final String str, final Map<String, Object> map) {
        if (wXSDKInstance != null) {
            wXSDKInstance.runOnUiThread(new Runnable() {
                /* class com.alibaba.aliweex.bundle.RenderPresenter.AnonymousClass1 */

                public void run() {
                    RenderPresenter.this.d(wXSDKInstance, str, map);
                }
            });
        }
    }

    private int f(ViewGroup viewGroup) {
        int f2;
        if (viewGroup == null) {
            return -1;
        }
        if (viewGroup.getChildCount() == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt != null && (childAt instanceof ViewGroup) && (f2 = f((ViewGroup) childAt)) > i2) {
                i2 = f2;
            }
        }
        return i2 + 1;
    }

    @NonNull
    private WXRenderStrategy g(Map<String, Object> map) {
        WXRenderStrategy wXRenderStrategy = WXRenderStrategy.APPEND_ASYNC;
        if (map == null) {
            return wXRenderStrategy;
        }
        try {
            if (map.containsKey(WeexPageFragment.WX_RENDER_STRATEGY)) {
                return WXRenderStrategy.valueOf(map.get(WeexPageFragment.WX_RENDER_STRATEGY).toString());
            }
            return wXRenderStrategy;
        } catch (Exception e2) {
            WXLogUtils.e("RenderPresenter", WXLogUtils.getStackTrace(e2));
            return wXRenderStrategy;
        }
    }

    private void h(Context context) {
        if (this.b == null) {
            AliWXSDKEngine.n();
            WXSDKInstance createWXSDKInstance = createWXSDKInstance(context);
            this.b = createWXSDKInstance;
            AliWXSDKEngine.m(createWXSDKInstance.getInstanceId());
            if (com.alibaba.aliweex.a.l().c() != null) {
                if ("false".equals(com.alibaba.aliweex.a.l().c().getConfig(r, "enableSanbox", "true"))) {
                    this.b.setUseSandBox(false);
                } else {
                    this.b.setUseSandBox(true);
                }
            }
            WeexPageContract.IUTPresenter iUTPresenter = this.k;
            if (iUTPresenter != null) {
                iUTPresenter.viewAutoExposure(this.b);
            }
            this.b.registerRenderListener(this.n);
            f fVar = this.j;
            if (fVar != null) {
                this.b.setNestedInstanceInterceptor(fVar);
            }
            this.b.onInstanceReady();
        }
    }

    private synchronized boolean i() {
        IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
        if (c2 == null) {
            return false;
        }
        return Boolean.parseBoolean(c2.getConfig("wx_namespace_ext_config", "get_deep_view_layer", Boolean.toString(true)));
    }

    private void j(Map<String, Object> map, String str, WXRenderStrategy wXRenderStrategy) {
        String renderUrl = getRenderUrl();
        String str2 = (ct2.d(renderUrl) || WXEnvironment.isApkDebugable()) ? renderUrl : vx2.ERROR_RENDER_URL;
        if (!this.b.isPreDownLoad()) {
            this.b.renderByUrl(str2, str2, map, str, wXRenderStrategy);
            try {
                tx2.d(this.b, renderUrl);
            } catch (Throwable unused) {
            }
        }
    }

    private void k(String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = false;
            if (!TextUtils.equals(this.c, str)) {
                if (TextUtils.isEmpty(this.c)) {
                    this.c = str;
                }
                if (this.a != null && z) {
                    this.c = Uri.parse(str).buildUpon().appendQueryParameter("activity", this.a.getClass().getName()).build().toString();
                }
                AliWXSDKEngine.l(this.c);
            }
            z = true;
            this.c = Uri.parse(str).buildUpon().appendQueryParameter("activity", this.a.getClass().getName()).build().toString();
            AliWXSDKEngine.l(this.c);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0028  */
    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public WXSDKInstance createWXSDKInstance(Context context) {
        AliWXSDKInstance aliWXSDKInstance;
        String renderUrl = getRenderUrl();
        if (!TextUtils.isEmpty(renderUrl)) {
            WXSDKInstance b2 = px2.a().b(renderUrl, context);
            if (b2 instanceof AliWXSDKInstance) {
                aliWXSDKInstance = (AliWXSDKInstance) b2;
                aliWXSDKInstance.c(this.i);
                Log.e("RenderPresenter", "preinit -> use preinitInstance ");
                if (aliWXSDKInstance == null) {
                    Log.e("RenderPresenter", "preinit -> failed ,and  new AliWXSDKInstance ");
                    aliWXSDKInstance = new AliWXSDKInstance(context, this.i);
                }
                aliWXSDKInstance.d(this.p);
                return aliWXSDKInstance;
            }
        }
        aliWXSDKInstance = null;
        if (aliWXSDKInstance == null) {
        }
        aliWXSDKInstance.d(this.p);
        return aliWXSDKInstance;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void destroySDKInstance() {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            MemoryMonitor.e(wXSDKInstance.getInstanceId());
            this.b.destroy();
            this.b = null;
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void fireEvent(String str, Map<String, Object> map) {
        d(this.b, str, map);
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public NestedContainer getNestedContainer(WXSDKInstance wXSDKInstance) {
        f fVar = this.j;
        if (fVar == null || wXSDKInstance == null) {
            return null;
        }
        return fVar.b(wXSDKInstance);
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public String getOriginalRenderUrl() {
        WeexPageContract.IDynamicUrlPresenter iDynamicUrlPresenter = this.l;
        return iDynamicUrlPresenter != null ? iDynamicUrlPresenter.getOriginalRenderUrl() : this.h;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public String getOriginalUrl() {
        WeexPageContract.IDynamicUrlPresenter iDynamicUrlPresenter = this.l;
        return iDynamicUrlPresenter != null ? iDynamicUrlPresenter.getOriginalUrl() : this.g;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public String getRenderUrl() {
        WeexPageContract.IDynamicUrlPresenter iDynamicUrlPresenter = this.l;
        return iDynamicUrlPresenter != null ? iDynamicUrlPresenter.getRenderUrl() : this.h;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public String getUrl() {
        WeexPageContract.IDynamicUrlPresenter iDynamicUrlPresenter = this.l;
        return iDynamicUrlPresenter != null ? iDynamicUrlPresenter.getUrl() : this.g;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public WXSDKInstance getWXSDKInstance() {
        if (this.b == null) {
            h(this.a);
        }
        return this.b;
    }

    /* access modifiers changed from: protected */
    public void l(WXAbstractRenderContainer wXAbstractRenderContainer, boolean z) {
        this.q = wXAbstractRenderContainer;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onActivityCreate(ViewGroup viewGroup, Map<String, Object> map, String str, String str2, String str3, String str4, String str5) {
        if (this.q == null) {
            this.q = new RenderContainer(this.a);
        }
        viewGroup.addView(this.q);
        h(this.a);
        this.q.createInstanceRenderView(this.b.getInstanceId());
        this.b.setWXAbstractRenderContainer(this.q);
        if (!TextUtils.isEmpty(str2)) {
            startRenderByTemplate(str2, str3, map, str);
        } else if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            startRenderByUrl(map, str, str3, str4);
        } else if (!TextUtils.isEmpty(str5)) {
            startRenderByUrl(map, str, str5, str5);
        }
        this.b.onActivityCreate();
        MemoryMonitor.a(this.b.getInstanceId(), new a());
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onActivityDestroy() {
        if (this.b != null) {
            WXSDKInstance wXSDKInstance = getWXSDKInstance();
            if (wXSDKInstance != null) {
                MemoryMonitor.e(wXSDKInstance.getInstanceId());
            }
            this.b.onActivityDestroy();
        }
        f fVar = this.j;
        if (fVar != null) {
            fVar.a();
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onActivityPause() {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            if (wXSDKInstance.getContainerView() != null && i()) {
                this.b.setMaxDeepLayer(f((ViewGroup) this.b.getContainerView()));
            }
            this.b.onActivityPause();
        }
        AliWXSDKEngine.l("");
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onActivityResult(int i2, int i3, Intent intent) {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onActivityResume() {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityResume();
        }
        k(getUrl());
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onActivityStart() {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityStart();
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onActivityStop() {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityStop();
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public boolean onBackPressed() {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            return wXSDKInstance.onBackPressed();
        }
        return false;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onCreateOptionsMenu(Menu menu) {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            wXSDKInstance.onCreateOptionsMenu(menu);
        }
        ArrayList<f.b> c2 = this.j.c();
        if (c2 != null) {
            Iterator<f.b> it = c2.iterator();
            while (it.hasNext()) {
                f.b next = it.next();
                if (next.b.c() != null) {
                    next.b.c().onCreateOptionsMenu(menu);
                }
            }
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public boolean onSupportNavigateUp() {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            return wXSDKInstance.onSupportNavigateUp();
        }
        return false;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void reload() {
        WeexPageContract.IUTPresenter iUTPresenter = this.k;
        if (iUTPresenter != null) {
            iUTPresenter.refreshUT(getUrl());
        }
        if (!TextUtils.isEmpty(getOriginalUrl()) && !TextUtils.isEmpty(getOriginalRenderUrl())) {
            destroySDKInstance();
            startRenderByUrl(this.d, this.e, getOriginalUrl(), getOriginalRenderUrl());
        } else if (!TextUtils.isEmpty(this.f)) {
            destroySDKInstance();
            startRenderByTemplate(this.f, this.g, this.d, this.e);
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void replace(String str, String str2) {
        destroySDKInstance();
        transformUrl(str, str2);
        WeexPageContract.IUTPresenter iUTPresenter = this.k;
        if (iUTPresenter != null) {
            iUTPresenter.refreshUT(getUrl());
        }
        startRenderByUrl(this.d, this.e, str, str2);
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void startRenderByTemplate(String str, String str2, Map<String, Object> map, String str3) {
        if (!TextUtils.isEmpty(str)) {
            this.m.showProgressBar(true);
            h(this.a);
            this.d = map;
            this.e = str3;
            this.f = str;
            this.g = str2;
            WXSDKInstance wXSDKInstance = this.b;
            if (TextUtils.isEmpty(str2)) {
                str2 = "AliWeex";
            }
            wXSDKInstance.render(str2, str, map, str3, g(this.d));
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void startRenderByUrl(Map<String, Object> map, String str, String str2, String str3) {
        Log.w("test ->", "startRenderByUrl in renderListener");
        if (!TextUtils.isEmpty(str3)) {
            WeexPageContract.IUrlValidate iUrlValidate = this.o;
            if (iUrlValidate != null) {
                iUrlValidate.checkUrlValidate(str3);
            }
            this.m.showProgressBar(!Uri.parse(str3).getBooleanQueryParameter("wx_mute_loading_indicator", false));
            h(this.a);
            transformUrl(str2, str3);
            k(getUrl());
            if (!this.b.isPreInitMode() && !this.b.isPreDownLoad()) {
                str2 = qx2.o(this.b, getOriginalUrl());
            }
            this.d = map;
            this.e = str;
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                str3 = str2;
            }
            hashMap.put("bundleUrl", str3);
            if (map != null) {
                for (String str4 : map.keySet()) {
                    hashMap.put(str4, map.get(str4));
                }
            }
            WeexPageContract.IUTPresenter iUTPresenter = this.k;
            if (iUTPresenter != null) {
                iUTPresenter.updatePageName(getUrl());
            }
            j(hashMap, str, g(this.d));
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void transformUrl(String str, String str2) {
        WeexPageContract.IDynamicUrlPresenter iDynamicUrlPresenter = this.l;
        if (iDynamicUrlPresenter != null) {
            iDynamicUrlPresenter.transformUrl(str, str2);
            return;
        }
        this.g = str;
        this.h = str2;
    }
}
