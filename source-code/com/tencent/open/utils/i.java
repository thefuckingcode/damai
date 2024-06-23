package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import com.tencent.open.a.g;
import com.tencent.open.log.SLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class i {
    private static Map<String, i> a = Collections.synchronizedMap(new HashMap());
    private static String b = null;
    private Context c = null;
    private String d = null;
    private JSONObject e = null;
    private long f = 0;
    private int g = 0;
    private boolean h = true;

    private i(Context context, String str) {
        this.c = context.getApplicationContext();
        this.d = str;
        a();
        b();
    }

    private void b() {
        if (this.g != 0) {
            d("update thread is running, return");
            return;
        }
        this.g = 1;
        final HashMap hashMap = new HashMap();
        hashMap.put("appid", this.d);
        hashMap.put("status_os", Build.VERSION.getRELEASE());
        hashMap.put("status_machine", f.a().c(g.a()));
        hashMap.put("status_version", Build.VERSION.SDK);
        hashMap.put("sdkv", Constants.SDK_VERSION);
        hashMap.put("sdkp", "a");
        l.a(new Runnable() {
            /* class com.tencent.open.utils.i.AnonymousClass1 */

            public void run() {
                try {
                    g a2 = f.a().a("https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", hashMap);
                    String a3 = a2.a();
                    SLog.i("openSDK_LOG.OpenConfig", "update: get config statusCode " + a2.d());
                    i.this.a((i) m.d(a3));
                } catch (Exception e) {
                    SLog.e("openSDK_LOG.OpenConfig", "get config error ", e);
                }
                i.this.g = 0;
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0077, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0078, code lost:
        r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r5 = r4.c.getAssets().open(r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0025 */
    private String c(String str) {
        String str2;
        String str3 = "";
        if (this.d != null) {
            str2 = str + "." + this.d;
        } else {
            str2 = str;
        }
        InputStream inputStream = this.c.openFileInput(str2);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            } catch (IOException e2) {
                e2.printStackTrace();
                inputStream.close();
                bufferedReader.close();
            } catch (Throwable th) {
                try {
                    inputStream.close();
                    bufferedReader.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        }
        str3 = stringBuffer.toString();
        try {
            inputStream.close();
            bufferedReader.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return str3;
    }

    private void d(String str) {
        if (this.h) {
            SLog.v("openSDK_LOG.OpenConfig", str + "; appid: " + this.d);
        }
    }

    public static i a(Context context, String str) {
        i iVar;
        synchronized (a) {
            SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                b = str;
            }
            if (str == null) {
                str = b;
                if (str == null) {
                    str = "0";
                }
            }
            iVar = a.get(str);
            if (iVar == null) {
                iVar = new i(context, str);
                a.put(str, iVar);
            }
            SLog.v("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return iVar;
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object opt = this.e.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        }
        return false;
    }

    private void a() {
        try {
            this.e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.e = new JSONObject();
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.d != null) {
                str = str + "." + this.d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        int optInt = this.e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f >= ((long) (optInt * 3600000))) {
            b();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f = SystemClock.elapsedRealtime();
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.e.optInt(str);
    }
}
