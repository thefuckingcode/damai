package com.alibaba.aliweex.bundle;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.aliweex.bundle.WeexPageContract;
import com.alibaba.dynamic.DynamicSdk;
import com.taobao.weex.WXSDKInstance;

/* compiled from: Taobao */
public class c implements WeexPageContract.IDynamicUrlPresenter {
    private final b a = new b();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class b {
        String a;
        String b;
        String c;
        String d;
        String e;

        private b(c cVar) {
        }

        public void a() {
            this.c = null;
            this.c = null;
            this.b = null;
            this.d = null;
            this.e = null;
        }

        /* access modifiers changed from: package-private */
        public String b() {
            if (TextUtils.isEmpty(this.b)) {
                return this.a;
            }
            return this.b;
        }

        /* access modifiers changed from: package-private */
        public String c() {
            if (TextUtils.isEmpty(this.d)) {
                return this.c;
            }
            return this.d;
        }
    }

    private void a(String str, String str2) {
        this.a.a();
        b bVar = this.a;
        bVar.a = str;
        bVar.c = str2;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                if (DynamicSdk.getInstance().isSdkWork()) {
                    Uri parse = Uri.parse(str);
                    String queryParameter = parse.getQueryParameter("_wx_tpl");
                    String queryParameter2 = parse.getQueryParameter("wh_weex");
                    if (TextUtils.isEmpty(queryParameter)) {
                        return;
                    }
                    if ("true".equals(queryParameter2)) {
                        String uri = Uri.parse(str2).buildUpon().clearQuery().build().toString();
                        if (queryParameter.contains(uri)) {
                            b bVar2 = this.a;
                            bVar2.e = null;
                            bVar2.e = uri;
                            CharSequence redirectUrl = DynamicSdk.getInstance().redirectUrl(uri);
                            if (!uri.equals(redirectUrl)) {
                                this.a.b = str.replace(uri, redirectUrl);
                                this.a.d = str2.replace(uri, redirectUrl);
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IDynamicUrlPresenter
    public String getOriginalRenderUrl() {
        return this.a.c;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IDynamicUrlPresenter
    public String getOriginalUrl() {
        return this.a.a;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IDynamicUrlPresenter
    public String getRenderUrl() {
        return this.a.c();
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IDynamicUrlPresenter
    public String getUrl() {
        return this.a.b();
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IDynamicUrlPresenter
    public void onWXException(WXSDKInstance wXSDKInstance, String str, String str2) {
        if (this.a.d != null && wXSDKInstance != null && str2.contains("404")) {
            try {
                DynamicSdk.getInstance().redirectUrlFailed(this.a.e);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IDynamicUrlPresenter
    public void transformUrl(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            a(str, str2);
        }
    }
}
