package com.alipay.sdk.app;

/* compiled from: Taobao */
public class H5AuthActivity extends H5PayActivity {
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0009 */
    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
        Object obj = AuthTask.c;
        synchronized (obj) {
            obj.notify();
        }
    }
}
