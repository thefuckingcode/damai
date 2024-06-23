package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.taobao.weex.ui.component.WXImage;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class d {
    private static final String o = "d";
    private Map<String, List<String>> a;
    private byte[] b;
    private int c = 0;
    private long d;
    private long e;
    private long f;
    private String g;
    private int h = 2;
    private int i = 9001;
    private String j = "";
    private long k = 0;
    private String l = "";
    private Exception m;
    private String n;

    public d(int i2, Map<String, List<String>> map, byte[] bArr, long j2) {
        this.c = i2;
        this.a = map;
        this.b = ByteBuffer.wrap(bArr).array();
        this.d = j2;
        s();
    }

    public d(Exception exc, long j2) {
        this.m = exc;
        this.d = j2;
    }

    private void a(Map<String, String> map) {
        String str;
        String str2;
        if (map.containsKey("ETag")) {
            String str3 = map.get("ETag");
            if (!TextUtils.isEmpty(str3)) {
                Logger.i(o, "success get Etag from server");
                a(str3);
                return;
            }
            str = o;
            str2 = "The Response Heads Etag is Empty";
        } else {
            str = o;
            str2 = "Response Heads has not Etag";
        }
        Logger.i(str, str2);
    }

    private void b(int i2) {
        this.i = i2;
    }

    private void b(Map<String, String> map) {
        long j2;
        NumberFormatException e2;
        if (map.containsKey("Cache-Control")) {
            String str = map.get("Cache-Control");
            if (!TextUtils.isEmpty(str) && str.contains("max-age=")) {
                try {
                    j2 = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                    try {
                        Logger.v(o, "Cache-Control value{%s}", Long.valueOf(j2));
                    } catch (NumberFormatException e3) {
                        e2 = e3;
                        Logger.w(o, "getExpireTime addHeadersToResult NumberFormatException", e2);
                        j2 = 86400;
                        long j3 = j2 * 1000;
                        Logger.i(o, "convert expireTime{%s}", Long.valueOf(j3));
                        c(String.valueOf(j3 + System.currentTimeMillis()));
                    }
                } catch (NumberFormatException e4) {
                    e2 = e4;
                    j2 = 0;
                    Logger.w(o, "getExpireTime addHeadersToResult NumberFormatException", e2);
                    j2 = 86400;
                    long j32 = j2 * 1000;
                    Logger.i(o, "convert expireTime{%s}", Long.valueOf(j32));
                    c(String.valueOf(j32 + System.currentTimeMillis()));
                }
                if (j2 <= 0 || j2 > 2592000) {
                    j2 = 86400;
                }
                long j322 = j2 * 1000;
                Logger.i(o, "convert expireTime{%s}", Long.valueOf(j322));
                c(String.valueOf(j322 + System.currentTimeMillis()));
            }
        } else if (map.containsKey("Expires")) {
            String str2 = map.get("Expires");
            Logger.v(o, "expires is{%s}", str2);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
            String str3 = null;
            if (map.containsKey(HttpHeaderConstant.DATE)) {
                str3 = map.get(HttpHeaderConstant.DATE);
            }
            try {
                j2 = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
            } catch (ParseException e5) {
                Logger.w(o, "getExpireTime ParseException.", e5);
            }
            j2 = 86400;
            long j3222 = j2 * 1000;
            Logger.i(o, "convert expireTime{%s}", Long.valueOf(j3222));
            c(String.valueOf(j3222 + System.currentTimeMillis()));
        } else {
            Logger.i(o, "response headers neither contains Cache-Control nor Expires.");
        }
        j2 = 0;
        j2 = 86400;
        long j32222 = j2 * 1000;
        Logger.i(o, "convert expireTime{%s}", Long.valueOf(j32222));
        c(String.valueOf(j32222 + System.currentTimeMillis()));
    }

    private void c(int i2) {
        this.h = i2;
    }

    private void c(long j2) {
        this.k = j2;
    }

    private void c(String str) {
        this.j = str;
    }

    private void c(Map<String, String> map) {
        long j2;
        if (map.containsKey("Retry-After")) {
            String str = map.get("Retry-After");
            if (!TextUtils.isEmpty(str)) {
                try {
                    j2 = Long.parseLong(str);
                } catch (NumberFormatException e2) {
                    Logger.w(o, "getRetryAfter addHeadersToResult NumberFormatException", e2);
                }
                long j3 = j2 * 1000;
                Logger.v(o, "convert retry-afterTime{%s}", Long.valueOf(j3));
                c(j3);
            }
        }
        j2 = 0;
        long j32 = j2 * 1000;
        Logger.v(o, "convert retry-afterTime{%s}", Long.valueOf(j32));
        c(j32);
    }

    private void d(String str) {
    }

    private void e(String str) {
    }

    private void f(String str) {
        this.g = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        if (r9.getInt("resultCode") == 0) goto L_0x0054;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ab  */
    private void p() {
        String str;
        if (m()) {
            Logger.i(o, "GRSSDK get httpcode{304} not any changed.");
            c(1);
        } else if (!o()) {
            Logger.i(o, "GRSSDK parse server body all failed.");
            c(2);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(StringUtils.byte2Str(this.b));
                int i2 = -1;
                if (jSONObject.has("isSuccess")) {
                    if (jSONObject.getInt("isSuccess") == 1) {
                    }
                    i2 = 2;
                    if (i2 != 1 && jSONObject.has("services")) {
                        i2 = 0;
                    }
                    c(i2);
                    str = "";
                    if (i2 != 1 || i2 == 0) {
                        f(jSONObject.has("services") ? jSONObject.getJSONObject("services").toString() : str);
                        if (jSONObject.has("errorList")) {
                            str = jSONObject.getJSONObject("errorList").toString();
                        }
                        e(str);
                    }
                    b(jSONObject.has("errorCode") ? jSONObject.getInt("errorCode") : 9001);
                    if (jSONObject.has(WXImage.ERRORDESC)) {
                        str = jSONObject.getString(WXImage.ERRORDESC);
                    }
                    d(str);
                    return;
                } else if (!jSONObject.has("resultCode")) {
                    Logger.e(o, "sth. wrong because server errorcode's key.");
                    i2 = 0;
                    c(i2);
                    str = "";
                    if (i2 != 1) {
                    }
                    f(jSONObject.has("services") ? jSONObject.getJSONObject("services").toString() : str);
                    if (jSONObject.has("errorList")) {
                    }
                    e(str);
                }
                i2 = 1;
                i2 = 0;
                c(i2);
                str = "";
                if (i2 != 1) {
                }
                f(jSONObject.has("services") ? jSONObject.getJSONObject("services").toString() : str);
                if (jSONObject.has("errorList")) {
                }
                e(str);
            } catch (JSONException e2) {
                Logger.w(o, "GrsResponse GrsResponse(String result) JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
                c(2);
            }
        }
    }

    private void q() {
        if (o() || n() || m()) {
            Map<String, String> r = r();
            if (r.size() <= 0) {
                Logger.w(o, "parseHeader {headers.size() <= 0}");
                return;
            }
            try {
                if (o() || m()) {
                    b(r);
                    a(r);
                }
                if (n()) {
                    c(r);
                }
            } catch (JSONException e2) {
                Logger.w(o, "parseHeader catch JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            }
        }
    }

    private Map<String, String> r() {
        HashMap hashMap = new HashMap(16);
        Map<String, List<String>> map = this.a;
        if (map == null || map.size() <= 0) {
            Logger.v(o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return hashMap;
        }
        for (Map.Entry<String, List<String>> entry : this.a.entrySet()) {
            String key = entry.getKey();
            for (String str : entry.getValue()) {
                hashMap.put(key, str);
            }
        }
        return hashMap;
    }

    private void s() {
        q();
        p();
    }

    public String a() {
        return this.j;
    }

    public void a(int i2) {
    }

    public void a(long j2) {
        this.f = j2;
    }

    public void a(String str) {
        this.l = str;
    }

    public int b() {
        return this.c;
    }

    public void b(long j2) {
        this.e = j2;
    }

    public void b(String str) {
        this.n = str;
    }

    public int c() {
        return this.i;
    }

    public Exception d() {
        return this.m;
    }

    public String e() {
        return this.l;
    }

    public int f() {
        return this.h;
    }

    public long g() {
        return this.f;
    }

    public long h() {
        return this.e;
    }

    public long i() {
        return this.d;
    }

    public String j() {
        return this.g;
    }

    public long k() {
        return this.k;
    }

    public String l() {
        return this.n;
    }

    public boolean m() {
        return this.c == 304;
    }

    public boolean n() {
        return this.c == 503;
    }

    public boolean o() {
        return this.c == 200;
    }
}
