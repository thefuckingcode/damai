package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.a;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
final class m implements ValueCallback<BaseSetupTask> {
    final /* synthetic */ a a;

    m(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(BaseSetupTask baseSetupTask) {
        BaseSetupTask baseSetupTask2 = baseSetupTask;
        String str = a.a;
        Log.d(str, "mDeleteFileFinish " + baseSetupTask2.toString());
        a.a(this.a, UCCore.EVENT_DELETE_FILE_FINISH, baseSetupTask2);
        a.e(this.a).a(a.d.k);
        if (UCCore.BUSINESS_INIT_BY_NEW_CORE_ZIP_FILE.equals(baseSetupTask2.getInitType())) {
            p.a((String) this.a.getOption(UCCore.OPTION_BUSINESS_DECOMPRESS_ROOT_PATH), (String) this.a.getOption(UCCore.OPTION_NEW_UCM_ZIP_FILE));
        } else if (UCCore.BUSINESS_INIT_BY_OLD_CORE_DEX_DIR.equals(baseSetupTask2.getInitType())) {
            a.i(this.a);
        }
    }
}
