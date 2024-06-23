package com.uc.webview.export.business.setup;

import com.uc.webview.export.internal.interfaces.IWaStat;
import java.util.HashMap;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class b extends HashMap<String, String> {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
        put(IWaStat.BUSINESS_INIT_START, Long.toString(a.a(aVar).a));
        put(IWaStat.BUSINESS_CHECK_INPUT_CONDITIONS, Long.toString(a.b(aVar).a));
        put(IWaStat.BUSINESS_CHECK_NEW_CORE, Long.toString(a.c(aVar).a));
        put(IWaStat.BUSINESS_CHECK_OLD_CORE, Long.toString(a.d(aVar).a));
        put(IWaStat.BUSINESS_INIT_PROCESS, Long.toString(a.e(aVar).a));
    }
}
