package com.youku.network;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.config.YoukuConfig;
import com.youku.httpcommunication.a;
import com.youku.httpcommunication.c;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: Taobao */
public class DisposableHttpTask extends Thread {
    private static final String AD_TAG = "HttpCommunication.advertisement";
    private String url;

    public DisposableHttpTask(String str) {
        super("DisposableHttpTask");
        this.url = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0085 A[SYNTHETIC, Splitter:B:24:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    public void run() {
        Throwable th;
        HttpURLConnection httpURLConnection;
        Exception e;
        super.run();
        if (c.d()) {
            c.b();
            HttpURLConnection httpURLConnection2 = null;
            try {
                URL url2 = new URL(this.url);
                a.b(AD_TAG, "advertisement exposure url：" + this.url);
                httpURLConnection = (HttpURLConnection) url2.openConnection();
                try {
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.setRequestProperty(IRequestConst.USER_AGENT, YoukuConfig.getUserAgent());
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    a.b(AD_TAG, "the response of advertisement exposure url：" + String.valueOf(responseCode));
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        a.a(AD_TAG, "DisposableHttpTask run Exception", e);
                        e.printStackTrace();
                        if (httpURLConnection == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection2 = httpURLConnection;
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                httpURLConnection = null;
                e = e5;
                a.a(AD_TAG, "DisposableHttpTask run Exception", e);
                e.printStackTrace();
                if (httpURLConnection == null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection2 != null) {
                }
                throw th;
            }
        }
    }
}
