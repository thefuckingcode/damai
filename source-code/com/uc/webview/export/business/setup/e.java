package com.uc.webview.export.business.setup;

import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;

/* compiled from: Taobao */
final class e extends HashMap<String, Object> {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
        put(UCCore.OPTION_BUSINESS_INIT_TYPE, UCCore.BUSINESS_INIT_BY_OLD_CORE_DEX_DIR);
        put(UCCore.OPTION_UCM_ZIP_FILE, null);
        put(UCCore.OPTION_NOT_USE_7Z_CORE, Boolean.TRUE);
        put(UCCore.OPTION_DEX_FILE_PATH, aVar.mOptions.get(UCCore.OPTION_OLD_DEX_DIR_PATH));
    }
}
