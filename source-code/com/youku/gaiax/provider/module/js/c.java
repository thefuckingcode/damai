package com.youku.gaiax.provider.module.js;

import android.content.DialogInterface;
import com.youku.gaiax.js.api.IGaiaXCallback;

/* compiled from: Taobao */
public final /* synthetic */ class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ IGaiaXCallback a;

    public /* synthetic */ c(IGaiaXCallback iGaiaXCallback) {
        this.a = iGaiaXCallback;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        GaiaXBuildInProviderModule$showDialog$1.a(this.a, dialogInterface, i);
    }
}
