package com.youku.gaiax.provider.module.js;

import android.content.DialogInterface;
import com.youku.gaiax.js.api.IGaiaXCallback;

/* compiled from: Taobao */
public final /* synthetic */ class b implements DialogInterface.OnClickListener {
    public final /* synthetic */ IGaiaXCallback a;

    public /* synthetic */ b(IGaiaXCallback iGaiaXCallback) {
        this.a = iGaiaXCallback;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        GaiaXBuildInProviderModule$showAlert$1.m908invoke$lambda4$lambda1(this.a, dialogInterface, i);
    }
}
