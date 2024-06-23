package com.youku.gaiax.provider.module.js;

import android.content.DialogInterface;
import com.youku.gaiax.js.api.IGaiaXCallback;

/* compiled from: Taobao */
public final /* synthetic */ class a implements DialogInterface.OnClickListener {
    public final /* synthetic */ IGaiaXCallback a;

    public /* synthetic */ a(IGaiaXCallback iGaiaXCallback) {
        this.a = iGaiaXCallback;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        GaiaXBuildInProviderModule$showAlert$1.a(this.a, dialogInterface, i);
    }
}
