package com.amap.api.col.s;

import android.content.Context;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public abstract class b<T, V> extends a<T, V> {
    public b(Context context, T t) {
        super(context, t);
    }

    protected static String b(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            i.a(e, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return "";
        } catch (Exception e2) {
            i.a(e2, "ProtocalHandler", "strEncoderException");
            return "";
        }
    }

    private static String c(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(e(str2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private static String e(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            i.a(e, "ProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            i.a(e2, "ProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a
    public abstract V a(String str) throws AMapException;

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a
    public abstract String a_();

    @Override // com.amap.api.col.s.a, com.amap.api.col.s.df
    public Map<String, String> e() {
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.HashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.df
    public Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", IRequestConst.CONTENT_TYPE_POST);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put(IRequestConst.USER_AGENT, "AMAP SDK Android Search 9.2.0");
        hashMap.put("X-INFO", bn.a(((a) this).e));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "9.2.0", "sea"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.s.df
    public byte[] g() {
        try {
            String a_ = a_();
            StringBuffer stringBuffer = new StringBuffer();
            if (a_ != null) {
                stringBuffer.append(a_);
                stringBuffer.append("&");
            }
            stringBuffer.append("language=");
            stringBuffer.append(ServiceSettings.getInstance().getLanguage());
            String stringBuffer2 = stringBuffer.toString();
            String c = c(stringBuffer2);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(stringBuffer2);
            String a = bn.a();
            stringBuffer3.append("&ts=".concat(String.valueOf(a)));
            stringBuffer3.append("&scode=" + bn.a(((a) this).e, a, c));
            return stringBuffer3.toString().getBytes("utf-8");
        } catch (Throwable th) {
            i.a(th, "ProtocalHandler", "getEntity");
            return null;
        }
    }
}
