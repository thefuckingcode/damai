package com.uc.webview.export;

import android.view.View;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.utility.i;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class b implements View.OnLongClickListener {
    final /* synthetic */ View.OnLongClickListener a;
    final /* synthetic */ WebView b;
    private View.OnLongClickListener c;

    b(WebView webView, View.OnLongClickListener onLongClickListener) {
        this.b = webView;
        this.a = onLongClickListener;
        this.c = onLongClickListener;
    }

    public final boolean onLongClick(View view) {
        if (this.c == null) {
            return false;
        }
        if (i.a().b(UCCore.ENABLE_WEBVIEW_LISTENER_STANDARDIZATION_OPTION)) {
            return this.c.onLongClick(this.b);
        }
        return this.c.onLongClick(view);
    }
}
