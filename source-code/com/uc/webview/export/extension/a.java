package com.uc.webview.export.extension;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.ExtImageDecoder;

/* compiled from: Taobao */
final class a implements ValueCallback<Integer> {
    final /* synthetic */ ExtImageDecoder.ImageDecoderListener a;

    a(ExtImageDecoder.ImageDecoderListener imageDecoderListener) {
        this.a = imageDecoderListener;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(Integer num) {
        this.a.onInit(num.intValue());
    }
}
