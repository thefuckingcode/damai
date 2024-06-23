package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class c extends AsyncTask<Void, Void, a> {
    private String a;
    private String b;
    private OAuthListener c;
    private int d;

    /* compiled from: Taobao */
    static class a {
        public OAuthErrCode a;
        public String b;
        public int c;

        a() {
        }
    }

    public c(String str, OAuthListener oAuthListener) {
        this.a = str;
        this.c = oAuthListener;
        this.b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x016c A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    public a doInBackground(Void[] voidArr) {
        a aVar;
        OAuthErrCode oAuthErrCode;
        String str;
        OAuthErrCode oAuthErrCode2;
        OAuthErrCode oAuthErrCode3;
        String str2;
        OAuthErrCode oAuthErrCode4;
        Thread.currentThread().setName("OpenSdkNoopingTask");
        String str3 = this.a;
        if (str3 == null || str3.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            aVar = new a();
        } else {
            Log.i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
            while (!isCancelled()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.b);
                if (this.d == 0) {
                    str = "";
                } else {
                    str = "&last=" + this.d;
                }
                sb.append(str);
                String sb2 = sb.toString();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] a2 = com.tencent.mm.opensdk.channel.a.a.a(sb2, 60000);
                long currentTimeMillis2 = System.currentTimeMillis();
                aVar = new a();
                Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
                if (a2 == null || a2.length == 0) {
                    Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                    oAuthErrCode3 = OAuthErrCode.WechatAuth_Err_NetworkErr;
                } else {
                    try {
                        try {
                            JSONObject jSONObject = new JSONObject(new String(a2, "utf-8"));
                            int i = jSONObject.getInt("wx_errcode");
                            aVar.c = i;
                            Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i)));
                            int i2 = aVar.c;
                            if (i2 != 408) {
                                if (i2 != 500) {
                                    switch (i2) {
                                        case 402:
                                            oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_Timeout;
                                            aVar.a = oAuthErrCode4;
                                            break;
                                        case 403:
                                            oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_Cancel;
                                            aVar.a = oAuthErrCode4;
                                            break;
                                        case 405:
                                            aVar.a = OAuthErrCode.WechatAuth_Err_OK;
                                            aVar.b = jSONObject.getString("wx_code");
                                            break;
                                    }
                                    Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, aVar.a.toString(), Integer.valueOf(aVar.c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                                    oAuthErrCode2 = aVar.a;
                                    if (oAuthErrCode2 != OAuthErrCode.WechatAuth_Err_OK) {
                                        int i3 = aVar.c;
                                        this.d = i3;
                                        if (i3 == d.UUID_SCANED.a()) {
                                            this.c.onQrcodeScanned();
                                        } else if (aVar.c != d.UUID_KEEP_CONNECT.a() && aVar.c == d.UUID_CONFIRM.a()) {
                                            String str4 = aVar.b;
                                            if (str4 == null || str4.length() == 0) {
                                                Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                                            }
                                        }
                                    } else {
                                        Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode2.toString(), Integer.valueOf(aVar.c)));
                                    }
                                    return aVar;
                                }
                                oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                aVar.a = oAuthErrCode4;
                                Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, aVar.a.toString(), Integer.valueOf(aVar.c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                                oAuthErrCode2 = aVar.a;
                                if (oAuthErrCode2 != OAuthErrCode.WechatAuth_Err_OK) {
                                }
                                return aVar;
                            }
                            oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_OK;
                            aVar.a = oAuthErrCode4;
                        } catch (Exception e) {
                            str2 = String.format("parse json fail, ex = %s", e.getMessage());
                            Log.e("MicroMsg.SDK.NoopingResult", str2);
                            oAuthErrCode3 = OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.a = oAuthErrCode3;
                            Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, aVar.a.toString(), Integer.valueOf(aVar.c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                            oAuthErrCode2 = aVar.a;
                            if (oAuthErrCode2 != OAuthErrCode.WechatAuth_Err_OK) {
                            }
                            return aVar;
                        }
                    } catch (Exception e2) {
                        str2 = String.format("parse fail, build String fail, ex = %s", e2.getMessage());
                        Log.e("MicroMsg.SDK.NoopingResult", str2);
                        oAuthErrCode3 = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.a = oAuthErrCode3;
                        Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, aVar.a.toString(), Integer.valueOf(aVar.c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                        oAuthErrCode2 = aVar.a;
                        if (oAuthErrCode2 != OAuthErrCode.WechatAuth_Err_OK) {
                        }
                        return aVar;
                    }
                    Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, aVar.a.toString(), Integer.valueOf(aVar.c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                    oAuthErrCode2 = aVar.a;
                    if (oAuthErrCode2 != OAuthErrCode.WechatAuth_Err_OK) {
                    }
                    return aVar;
                }
                aVar.a = oAuthErrCode3;
                Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, aVar.a.toString(), Integer.valueOf(aVar.c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                oAuthErrCode2 = aVar.a;
                if (oAuthErrCode2 != OAuthErrCode.WechatAuth_Err_OK) {
                }
                return aVar;
            }
            Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
            aVar.a = oAuthErrCode;
            return aVar;
        }
        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        aVar.a = oAuthErrCode;
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.c.onAuthFinish(aVar2.a, aVar2.b);
    }
}
