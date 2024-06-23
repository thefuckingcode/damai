package com.alibaba.aliweex.bundle;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.aliweex.bundle.WeexPageContract;
import com.taobao.weex.ComponentObserver;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.component.WXComponent;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTPageHitHelper;
import com.ut.mini.internal.ExposureViewHandle;
import com.ut.mini.internal.UTTeamWork;
import java.util.HashMap;

/* compiled from: Taobao */
public class d implements WeexPageContract.IUTPresenter {
    private boolean a;
    private Activity b;

    /* compiled from: Taobao */
    class a implements ComponentObserver {
        a() {
        }

        @Override // com.taobao.weex.ComponentObserver
        public void onCreate(WXComponent wXComponent) {
        }

        @Override // com.taobao.weex.ComponentObserver
        public void onPreDestory(WXComponent wXComponent) {
        }

        @Override // com.taobao.weex.ComponentObserver
        public void onViewCreated(WXComponent wXComponent, View view) {
            ExposureViewHandle exposureViewHandler;
            if (d.this.enable() && (exposureViewHandler = UTTeamWork.getInstance().getExposureViewHandler(d.this.b())) != null && exposureViewHandler.isExposureView(UTPageHitHelper.getInstance().getPageUrl(d.this.b()), view)) {
                UTTeamWork.getInstance().setExposureTagForWeex(view);
            }
        }
    }

    public d(Activity activity) {
        this.a = true;
        this.a = true;
        this.b = activity;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Activity b() {
        return this.b;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IUTPresenter
    public void destroy() {
        this.a = true;
        this.b = null;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IUTPresenter
    public boolean enable() {
        return this.a;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IUTPresenter
    public void pageAppear(String str) {
        if (b() != null && enable()) {
            UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(b());
            UTAnalytics.getInstance().getDefaultTracker().pageAppearDonotSkip(b());
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(str);
                UTAnalytics.getInstance().getDefaultTracker().updatePageUrl(b(), parse);
                if (parse.isHierarchical() && parse.getQueryParameter("scm") != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("scm", parse.getQueryParameter("scm"));
                    UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(b(), hashMap);
                }
            }
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IUTPresenter
    public void pageDisappear() {
        if (b() != null && enable()) {
            UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(b());
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IUTPresenter
    public void refreshUT(String str) {
        if (b() != null && enable()) {
            pageDisappear();
            UTAnalytics.getInstance().getDefaultTracker().skipPage(b());
            pageAppear(str);
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IUTPresenter
    public void skipPage() {
        if (enable()) {
            UTAnalytics.getInstance().getDefaultTracker().skipPage(b());
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IUTPresenter
    public void tryToUpdatePageSpmCnt(WXSDKInstance wXSDKInstance) {
        WXComponent rootComponent;
        if (enable() && (rootComponent = wXSDKInstance.getRootComponent()) != null) {
            String str = (String) rootComponent.getAttrs().get("spmId");
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("spm-cnt", str + ".0.0");
                UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(b(), hashMap);
            }
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IUTPresenter
    public void updatePageName(String str) {
        if (enable() && b() != null && !TextUtils.isEmpty(str)) {
            UTAnalytics.getInstance().getDefaultTracker().updatePageName(b(), Uri.parse(str).buildUpon().clearQuery().build().toString());
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IUTPresenter
    public void viewAutoExposure(WXSDKInstance wXSDKInstance) {
        wXSDKInstance.setComponentObserver(new a());
    }
}
