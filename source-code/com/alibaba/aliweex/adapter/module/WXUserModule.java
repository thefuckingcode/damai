package com.alibaba.aliweex.adapter.module;

import com.alibaba.aliweex.a;
import com.alibaba.aliweex.adapter.IUserModuleAdapter;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/* compiled from: Taobao */
public class WXUserModule extends WXModule {
    @JSMethod
    public void getUserInfo(JSCallback jSCallback) {
        IUserModuleAdapter q = a.l().q();
        if (q != null) {
            q.getUserInfo(this.mWXSDKInstance.getContext(), jSCallback);
        }
    }

    @JSMethod
    public void login(JSCallback jSCallback) {
        IUserModuleAdapter q = a.l().q();
        if (q != null) {
            q.login(this.mWXSDKInstance.getContext(), jSCallback);
        }
    }

    @JSMethod
    public void logout(JSCallback jSCallback) {
        IUserModuleAdapter q = a.l().q();
        if (q != null) {
            q.logout(this.mWXSDKInstance.getContext(), jSCallback);
        }
    }
}
