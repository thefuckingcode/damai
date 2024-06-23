package com.amap.api.mapcore.util;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

/* compiled from: Taobao */
abstract class fn extends Dialog {
    public fn(Context context) {
        super(context);
        b();
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public void b() {
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            a();
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 80;
            }
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(17170445);
        }
    }
}
