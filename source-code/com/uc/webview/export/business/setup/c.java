package com.uc.webview.export.business.setup;

import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;

/* compiled from: Taobao */
final class c extends HashMap<String, Object> {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
        put(UCCore.OPTION_BUSINESS_INIT_TYPE, UCCore.BUSINESS_INIT_BY_NEW_CORE_ZIP_FILE);
        put(UCCore.OPTION_ZIP_FILE_TYPE, a.d(aVar, UCCore.OPTION_NEW_UCM_ZIP_TYPE));
        put(UCCore.OPTION_DEX_FILE_PATH, null);
        put(UCCore.OPTION_UCM_ZIP_FILE, a.o(aVar).get(UCCore.OPTION_NEW_UCM_ZIP_FILE));
    }
}
