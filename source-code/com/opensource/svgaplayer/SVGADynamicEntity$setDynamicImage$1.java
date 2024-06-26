package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import tb.v22;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* compiled from: Taobao */
public final class SVGADynamicEntity$setDynamicImage$1 implements Runnable {
    final /* synthetic */ String $forKey;
    final /* synthetic */ Handler $handler;
    final /* synthetic */ String $url;
    final /* synthetic */ v22 this$0;

    SVGADynamicEntity$setDynamicImage$1(v22 v22, String str, Handler handler, String str2) {
        this.this$0 = v22;
        this.$url = str;
        this.$handler = handler;
        this.$forKey = str2;
    }

    public final void run() {
        try {
            URLConnection openConnection = new URL(this.$url).openConnection();
            if (!(openConnection instanceof HttpURLConnection)) {
                openConnection = null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            if (httpURLConnection != null) {
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                if (decodeStream != null) {
                    this.$handler.post(new SVGADynamicEntity$setDynamicImage$1$$special$$inlined$let$lambda$2(decodeStream, this));
                }
                httpURLConnection.getInputStream().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
