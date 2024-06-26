package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.loc.o;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tb.o23;
import tb.r13;
import tb.s13;

/* compiled from: Taobao */
public final class c {
    private static final String b = v1.v("SRFZHZUVZT3BOa0ZiemZRQQ");
    private static final String c = v1.v("FbGJzX3Nkaw");
    private static final String d = v1.v("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
    private static final String e = v1.v("FQU5EU0RLMTA");
    private static final String f = v1.v("FMTAw");
    private static boolean g = false;
    private String a = "";

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements o.a {
        private c a = new c();

        a() {
        }

        @Override // com.loc.o.a
        public final bl a(byte[] bArr, Map<String, String> map) {
            return new x(bArr, map);
        }

        @Override // com.loc.o.a
        public final String a() {
            return c.e();
        }

        @Override // com.loc.o.a
        public final String a(Context context, String str) {
            return c.b(context, str);
        }

        @Override // com.loc.o.a
        public final String a(String str, String str2, String str3, String str4) {
            return this.a.c(str, str2, str3, str4);
        }

        @Override // com.loc.o.a
        public final Map<String, String> b() {
            return this.a.d();
        }
    }

    public static o.a a() {
        return new a();
    }

    public static String b(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(v1.v("UY29kZQ")) != 1) {
                return "";
            }
            String optString = new JSONObject(jSONObject.optString(v1.v("FZGF0YQ"))).optString(v1.v("FYWRpdQ"));
            if (TextUtils.isEmpty(optString)) {
                return "";
            }
            r13.b(optString);
            w1.a(context).c(optString);
            return optString;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String e() {
        return r13.a();
    }

    private String f() {
        if (!TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        String a2 = p1.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < a2.length(); i++) {
            stringBuffer.append((char) (a2.charAt(i) - (i % 48)));
        }
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i2 = 0; i2 < stringBuffer2.length() / 2; i2++) {
            stringBuffer3.append((char) ((stringBuffer2.charAt(i2) + stringBuffer2.charAt((stringBuffer2.length() - 1) - i2)) / 2));
        }
        String stringBuffer4 = stringBuffer3.toString();
        this.a = stringBuffer4;
        return stringBuffer4;
    }

    public final String c(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(v1.v("LdGlk"), str);
            jSONObject.put(v1.v("FZGl1"), str2);
            jSONObject.put(v1.v("AZGl1Mg"), str3);
            jSONObject.put(v1.v("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        String b2 = s13.b();
        if (!TextUtils.isEmpty(b2)) {
            String a2 = b.a(o23.a((jSONObject2 + "\u0000").getBytes(), b2.getBytes()));
            if (!TextUtils.isEmpty(a2)) {
                try {
                    String a3 = b.a(f.b(b2.getBytes("utf-8"), f.a(f())));
                    return v1.v("Fa2V5PQ") + URLEncoder.encode(a3) + v1.v("SJmRhdGE9") + URLEncoder.encode(a2);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public final synchronized Map<String, String> d() {
        if (g) {
            return null;
        }
        g = true;
        HashMap hashMap = new HashMap();
        hashMap.put(v1.v("FZW50"), v1.v("FMg"));
        StringBuilder sb = new StringBuilder();
        sb.append(v1.v("SY2hhbm5lbD0"));
        String str = c;
        sb.append(str);
        sb.append(v1.v("SJmRpdj0"));
        String str2 = e;
        sb.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(v1.v("FQA"));
        stringBuffer.append(d);
        String d2 = s13.d(stringBuffer.toString());
        sb.append(v1.v("FJnNpZ249"));
        sb.append(d2.toUpperCase(Locale.US));
        sb.append(v1.v("SJm91dHB1dD1qc29u") + "\u0000");
        hashMap.put(v1.v("FaW4"), b.a(o23.a(sb.toString().getBytes(), b.getBytes())));
        hashMap.put(v1.v("Sa2V5dA"), f);
        return hashMap;
    }
}
