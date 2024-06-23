package com.uc.webview.export.business.setup;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import java.util.HashMap;

/* compiled from: Taobao */
final class n extends HashMap<String, Pair<ValueCallback<BaseSetupTask>, ValueCallback<BaseSetupTask>>> {
    final /* synthetic */ a a;

    n(a aVar) {
        this.a = aVar;
        put("exception", new Pair(null, aVar.j));
        put("die_delegate", new Pair(null, aVar.k));
        put(UCCore.EVENT_INIT_CORE_SUCCESS, new Pair(null, aVar.i));
        put(UCCore.LEGACY_EVENT_SETUP, new Pair(null, aVar.l));
        put(UCCore.EVENT_DELETE_FILE_FINISH, new Pair(null, aVar.m));
    }
}
