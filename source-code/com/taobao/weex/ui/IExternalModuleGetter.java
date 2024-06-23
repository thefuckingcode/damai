package com.taobao.weex.ui;

import android.content.Context;
import com.taobao.weex.common.WXModule;

/* compiled from: Taobao */
public interface IExternalModuleGetter {
    Class<? extends WXModule> getExternalModuleClass(String str, Context context);
}
