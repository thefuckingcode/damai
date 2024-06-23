package com.uc.webview.export.business.setup;

import com.uc.webview.export.internal.interfaces.IWaStat;
import java.util.HashMap;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class h extends HashMap<String, String> {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    h(a aVar, String str) {
        this.b = aVar;
        this.a = str;
        put(IWaStat.BUSINESS_ELAPSE_INIT_TYPE, str);
        put(IWaStat.BUSINESS_ELAPSE_INIT_CHECK, aVar.h.b);
        put(IWaStat.BUSINESS_ELAPSE_INIT_CHECK_CPU, aVar.h.c);
        put(IWaStat.BUSINESS_ELAPSE_SETUP_CALLBACK, aVar.h.d);
        put(IWaStat.BUSINESS_ELAPSE_SETUP_CALLBACK_CPU, aVar.h.e);
        put(IWaStat.BUSINESS_ELAPSE_SUCCESS_CALLBACK, aVar.h.f);
        put(IWaStat.BUSINESS_ELAPSE_SUCCESS_CALLBACK_CPU, aVar.h.g);
    }
}
