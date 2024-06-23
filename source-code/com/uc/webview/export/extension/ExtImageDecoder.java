package com.uc.webview.export.extension;

import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.InvokeObject;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;

@Api
/* compiled from: Taobao */
public class ExtImageDecoder {

    @Api
    /* compiled from: Taobao */
    public static class ExtImageDecoderParam {
        public String decoderPath = "";
        public String[] dependedPath = null;
        public String filenameExtension = "";
        public String format = "";
        public int headerLength = 0;
        public boolean progressiveDecode = true;
        public String version = "";
    }

    @Api
    /* compiled from: Taobao */
    public interface ImageDecoderListener extends InvokeObject {
        void onDecode(String str, String str2, int i);

        void onInit(int i);
    }

    public static void requestExtImageDecoderResult() {
        UCMobileWebKit uCMobileWebKit;
        if (WebView.getCoreType() == 3 && (uCMobileWebKit = SDKFactory.d) != null) {
            try {
                uCMobileWebKit.invoke(106, null);
            } catch (AbstractMethodError unused) {
            }
        }
    }

    public static void setExtImageDecoder(ExtImageDecoderParam extImageDecoderParam, ImageDecoderListener imageDecoderListener) {
        if (imageDecoderListener != null) {
            if (WebView.getCoreType() != 3 || SDKFactory.d == null) {
                imageDecoderListener.onInit(3);
                return;
            }
            try {
                SDKFactory.d.invoke(105, new Object[]{extImageDecoderParam, new a(imageDecoderListener), new b(imageDecoderListener)});
            } catch (AbstractMethodError unused) {
            }
        }
    }
}
