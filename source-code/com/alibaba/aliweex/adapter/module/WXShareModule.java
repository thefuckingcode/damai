package com.alibaba.aliweex.adapter.module;

import com.alibaba.aliweex.a;
import com.alibaba.aliweex.adapter.IShareModuleAdapter;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/* compiled from: Taobao */
public class WXShareModule extends WXModule {
    @JSMethod
    public void doShare(String str, JSCallback jSCallback) {
        IShareModuleAdapter p = a.l().p();
        if (p != null) {
            p.doShare(this.mWXSDKInstance.getContext(), str, jSCallback);
        }
    }
}
