package com.uc.webview.export.internal.android;

import android.content.Intent;
import android.os.Build;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.internal.utility.p;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class l extends WebChromeClient.FileChooserParams {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ i c;

    l(i iVar, String str, String str2) {
        this.c = iVar;
        this.a = str;
        this.b = str2;
    }

    @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
    public final Intent createIntent() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (Build.VERSION.SDK_INT >= 16) {
            intent.setTypeAndNormalize(getAcceptTypes()[0]);
        } else {
            intent.setType(getAcceptTypes()[0]);
        }
        return intent;
    }

    @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
    public final String[] getAcceptTypes() {
        String[] strArr = new String[1];
        strArr[0] = p.a(this.a) ? "*/*" : this.a;
        return strArr;
    }

    @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
    public final String getFilenameHint() {
        return "";
    }

    @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
    public final int getMode() {
        return 0;
    }

    @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
    public final CharSequence getTitle() {
        return "";
    }

    @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
    public final boolean isCaptureEnabled() {
        return !p.a(this.b);
    }
}
