package com.uc.webview.export.business.setup;

import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;

/* compiled from: Taobao */
final class g extends HashMap<String, Object> {
    final /* synthetic */ a a;

    g(a aVar) {
        this.a = aVar;
        put(UCCore.OPTION_BUSINESS_INIT_TYPE, "int_android_webview");
        put(UCCore.OPTION_USE_SYSTEM_WEBVIEW, Boolean.TRUE);
    }
}
