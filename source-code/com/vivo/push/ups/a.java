package com.vivo.push.ups;

import android.content.Context;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;

/* compiled from: Taobao */
final class a implements IPushActionListener {
    final /* synthetic */ UPSRegisterCallback a;
    final /* synthetic */ Context b;
    final /* synthetic */ VUpsManager c;

    a(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback, Context context) {
        this.c = vUpsManager;
        this.a = uPSRegisterCallback;
        this.b = context;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.a.onResult(new TokenResult(i, PushClient.getInstance(this.b).getRegId()));
    }
}
