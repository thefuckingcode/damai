package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.af;
import com.uc.webview.export.internal.utility.m;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class u implements ValueCallback<l> {
    final /* synthetic */ o a;

    u(o oVar) {
        this.a = oVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        ValueCallback<UCSetupException> valueCallback = SDKFactory.n;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(lVar2.getException());
        }
        if (lVar2.getException() != null) {
            this.a.j = lVar2.getException();
            this.a.k = lVar2;
        }
        if (m.b()) {
            m.d(this.a.getContext());
        }
        Integer num = (Integer) this.a.mOptions.get(UCCore.OPTION_DELETE_CORE_POLICY);
        if (num != null && num.intValue() != 0 && (lVar2 instanceof ax) && ((lVar2.getException().errCode() == 1008 && (num.intValue() & 1) != 0) || ((lVar2.getException().errCode() == 1011 && (num.intValue() & 8) != 0) || ((lVar2.getException().errCode() == 3007 && (num.intValue() & 2) != 0) || ((lVar2.getException().errCode() == 3005 && (num.intValue() & 16) != 0) || ((lVar2.getException().errCode() == 4005 && (num.intValue() & 4) != 0) || (num.intValue() & 32) != 0)))))) {
            if (this.a.n == null) {
                this.a.n = new ArrayList();
            }
            this.a.n.add((ax) lVar2);
        }
        Log.d("SdkSetupTask", "mExceptionCB mExceptionTasks: " + o.d);
        if (o.d.size() > 0) {
            if (((UCSetupTask) o.d.pop()) != null) {
                ((UCSetupTask) o.d.pop()).start();
            } else {
                Log.w("SdkSetupTask", "init exception, fallback to system webview", this.a.j);
                this.a.b((l) new ba()).start();
            }
        } else if (this.a.e != null) {
            ((l) ((l) ((l) this.a.e.setParent(this.a)).onEvent("success", this.a.p)).onEvent("exception", this.a.q)).start();
            this.a.e = null;
        } else {
            this.a.setException(lVar2.getException());
        }
        af.a(af.a.INIT_EXCEPTION, this.a.j);
    }
}
