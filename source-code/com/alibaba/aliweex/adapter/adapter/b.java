package com.alibaba.aliweex.adapter.adapter;

import com.taobao.soloader.SoLoader;
import com.taobao.weex.adapter.IWXSoLoaderAdapter;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
public class b implements IWXSoLoaderAdapter {
    private boolean a;

    /* compiled from: Taobao */
    class a implements SoLoader.LoadSoCallBack {
        a(b bVar, String str) {
        }
    }

    /* renamed from: com.alibaba.aliweex.adapter.adapter.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    class C0072b implements SoLoader.LoadSoCallBack {
        C0072b(b bVar) {
        }
    }

    public b() {
        try {
            Class.forName(SoLoader.class.getName());
            this.a = true;
        } catch (Throwable unused) {
            this.a = false;
        }
    }

    @Override // com.taobao.weex.adapter.IWXSoLoaderAdapter
    public void doLoad(String str) {
        if (!this.a) {
            try {
                System.load(str);
            } catch (Throwable th) {
                WXLogUtils.e(WXLogUtils.getStackTrace(th));
            }
        } else {
            SoLoader.load(str, new C0072b(this));
        }
    }

    @Override // com.taobao.weex.adapter.IWXSoLoaderAdapter
    public void doLoadLibrary(String str) {
        if (!this.a) {
            try {
                System.loadLibrary(str);
            } catch (Throwable th) {
                WXLogUtils.e(WXLogUtils.getStackTrace(th));
            }
        } else {
            SoLoader.loadLibrary(str, new a(this, str));
        }
    }
}
