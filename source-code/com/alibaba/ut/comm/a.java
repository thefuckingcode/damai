package com.alibaba.ut.comm;

import android.app.Activity;
import com.alibaba.ut.IWebView;
import com.alibaba.ut.comm.ActivityLifecycleCB;
import java.util.HashMap;
import tb.hw2;
import tb.q91;

/* compiled from: Taobao */
public class a implements ActivityLifecycleCB.ActivityResumedCallBack {
    public static a b = new a();
    private HashMap<String, Boolean> a = new HashMap<>();

    public static a a() {
        return b;
    }

    public void b() {
        ActivityLifecycleCB.d().c(this);
    }

    @Override // com.alibaba.ut.comm.ActivityLifecycleCB.ActivityResumedCallBack
    public void onActivityResumed(Activity activity) {
        IWebView a2 = hw2.a(activity);
        if (!this.a.containsKey(Integer.valueOf(activity.hashCode()))) {
            if (a2 != null) {
                a2.addJavascriptInterface(new JsBridge(a2), "UT4Aplus");
                q91.h("hook success:", a2);
            } else {
                q91.e("TAG", "cannot found webview");
            }
        }
        HashMap<String, Boolean> hashMap = this.a;
        hashMap.put(activity.hashCode() + "", Boolean.TRUE);
    }
}
