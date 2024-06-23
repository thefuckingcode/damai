package com.taobao.weex.adapter;

import android.content.Context;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
public class ClassLoaderAdapter {
    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent> */
    public Class<? extends WXComponent> getComponentClass(String str, String str2, WXSDKInstance wXSDKInstance) {
        try {
            return wXSDKInstance.getContext().getClassLoader().loadClass(str2);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends com.taobao.weex.common.WXModule> */
    public Class<? extends WXModule> getModuleClass(String str, String str2, Context context) {
        try {
            return context.getClassLoader().loadClass(str2);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
