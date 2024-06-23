package com.baseproject.utils.speedtest;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.baseproject.utils.speedtest.j;
import com.taobao.orange.OConstant;
import com.taobao.orange.OrangeConfig;
import com.youku.b.a.a;
import com.youku.ups.data.RequestParams;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import org.android.spdy.TnetStatusCode;
import tb.k63;
import tb.n23;

/* compiled from: Taobao */
public class b {
    private static final String c = "b";
    private int a = 1000;
    private int b = 2000;

    private String b(String str, n23 n23) {
        StringBuilder sb = new StringBuilder(str);
        c(sb, RequestParams.client_ip, n23.c);
        c(sb, RequestParams.client_ts, n23.d);
        c(sb, "utdid", n23.e);
        c(sb, "ccode", n23.f);
        c(sb, IRequestConst.STOKEN, n23.g);
        c(sb, "pid", n23.h);
        c(sb, "network", n23.i);
        c(sb, "app_ver", n23.j);
        c(sb, "version", n23.k);
        c(sb, "brand", n23.o);
        c(sb, IRequestConst.ISP, n23.l);
        c(sb, "mac", n23.m);
        c(sb, OConstant.CANDIDATE_OSVER, n23.n);
        return sb.toString();
    }

    private void c(StringBuilder sb, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append("=");
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
            }
            sb.append("&");
        }
    }

    public int a(String str, j.a aVar) {
        n23 n23;
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            if (aVar.a.b == 1) {
                a.a(c, "use pre-host cmd url");
                str = "https://106.11.46.130/speed/get?";
            } else {
                a.a(c, "use official cmd url");
                str = "https://connectivity.youku.com/speed/get?";
            }
        }
        try {
            this.a = Integer.parseInt(OrangeConfig.getInstance().getConfig("speed_test", "cmd_connect_timeout", "10")) * 1000;
            this.b = Integer.parseInt(OrangeConfig.getInstance().getConfig("speed_test", "cmd_read_timeout", "10")) * 1000;
        } catch (NumberFormatException unused) {
            a.b(c, "orange_timeout_wrong_format");
        }
        String str4 = c;
        a.a(str4, "requestCmdInfo time limit:" + this.a + "," + this.b);
        if (aVar == null || (n23 = aVar.a) == null) {
            a.a(str4, "cmd url or reqinfo is empty");
            return -2001;
        }
        InputStream inputStream = null;
        try {
            String b2 = b(str, n23);
            URL url = new URL(b2);
            a.a(str4, "com.baseproject.utils.speedtest cmd request:" + b2);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(this.a);
            httpURLConnection.setReadTimeout(this.b);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestMethod("GET");
            if (aVar.a.b == 1) {
                httpURLConnection.setRequestProperty(BizTime.HOST, "pre-connectivity.youku.com");
            }
            if (url.getProtocol().equals("https")) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new k63());
            }
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                return TnetStatusCode.EASY_REASON_SESSION_TIMEOUT;
            }
            try {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                a aVar2 = (a) JSON.parseObject(stringBuffer.toString(), a.class);
                aVar.b = aVar2;
                if (aVar2.f < 0) {
                    if (aVar2.e != null) {
                        str2 = c;
                        str3 = "cmd ups error:" + aVar.b.e;
                    } else {
                        str2 = c;
                        str3 = "cmd ups error with empty msg";
                    }
                    a.a(str2, str3);
                    int i = aVar.b.f;
                    try {
                        inputStream2.close();
                        httpURLConnection.disconnect();
                    } catch (Exception unused2) {
                    }
                    return i;
                }
                try {
                    inputStream2.close();
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
                return 0;
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    inputStream.close();
                    httpURLConnection.disconnect();
                } catch (Exception unused4) {
                }
                return TnetStatusCode.EASY_REASON_DISCONNECT;
            } catch (JSONException e2) {
                e2.printStackTrace();
                try {
                    inputStream.close();
                    httpURLConnection.disconnect();
                } catch (Exception unused5) {
                }
                return TnetStatusCode.EASY_REASON_CONN_TIMEOUT;
            } catch (Throwable th) {
                try {
                    inputStream.close();
                    httpURLConnection.disconnect();
                } catch (Exception unused6) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return TnetStatusCode.EASY_REASON_SESSION_TIMEOUT;
        }
    }
}
