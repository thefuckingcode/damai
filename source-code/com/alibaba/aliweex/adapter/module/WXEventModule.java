package com.alibaba.aliweex.adapter.module;

import com.alibaba.aliweex.a;
import com.alibaba.aliweex.adapter.IEventModuleAdapter;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;

/* compiled from: Taobao */
public class WXEventModule extends WXModule {
    @JSMethod
    public void openURL(String str) {
        IEventModuleAdapter f = a.l().f();
        if (f != null) {
            f.openURL(this.mWXSDKInstance.getContext(), str);
        }
    }
}
