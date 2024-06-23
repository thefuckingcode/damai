package com.alibaba.aliweex.adapter.module;

import com.alibaba.aliweex.a;
import com.alibaba.aliweex.adapter.IFestivalModuleAdapter;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import java.util.Map;

/* compiled from: Taobao */
public class WXFestivalModule extends WXModule {
    @JSMethod(uiThread = false)
    public Map<String, String> queryFestivalStyle() {
        IFestivalModuleAdapter g = a.l().g();
        if (g != null) {
            return g.queryFestivalStyle();
        }
        return null;
    }

    @JSMethod
    public void setFestivalStyle(String str, JSCallback jSCallback, JSCallback jSCallback2) {
        IFestivalModuleAdapter g = a.l().g();
        if (g != null) {
            g.setFestivalStyle(this.mWXSDKInstance.getContext(), str, jSCallback, jSCallback2);
        }
    }
}
