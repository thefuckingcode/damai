package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.biometrics.image.RPWebViewMediaCacheManager;
import com.alibaba.security.realidentity.upload.UploadFileModel;
import com.alibaba.security.realidentity.upload.a.a;
import com.alibaba.security.realidentity.upload.b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import tb.o70;

@f(a = "uploadPhoto")
/* compiled from: Taobao */
public class o extends a {
    private a as;

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final String a() {
        return "uploadPhoto";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, final h hVar) {
        if (com.alibaba.security.common.c.a.a()) {
            com.alibaba.security.common.c.a.a("AbsJavaScriptExecuter", "UploadApi execute params:".concat(String.valueOf(str)));
        }
        try {
            JSONObject parseObject = JSON.parseObject(str);
            final String str2 = null;
            final String string = (parseObject == null || !parseObject.containsKey(a.r)) ? null : parseObject.getString(a.r);
            if (parseObject != null && parseObject.containsKey(a.N)) {
                str2 = parseObject.getString(a.N);
            }
            String str3 = RPWebViewMediaCacheManager.getInstance().get(string);
            if (str3 == null) {
                WVResult wVResult = new WVResult();
                wVResult.addData(a.N, str2);
                wVResult.addData(a.r, string);
                wVResult.addData("errorMsg", "");
                hVar.a(wVResult);
                a(wVResult, false);
                return false;
            }
            if (this.as == null) {
                b unused = b.a.a;
                this.as = b.a(this.ao);
            }
            final String md5 = RPWebViewMediaCacheManager.getInstance().getMd5(string);
            UploadFileModel uploadFileModel = new UploadFileModel();
            uploadFileModel.setLocalFilePath(str3);
            uploadFileModel.setFileType("jpeg");
            Object a = this.as.a(uploadFileModel, new com.alibaba.security.realidentity.upload.b.b() {
                /* class com.alibaba.security.realidentity.jsbridge.o.AnonymousClass1 */

                @Override // com.alibaba.security.realidentity.upload.b.b
                public final void a(String str) {
                    m.a().b(string);
                    if (md5 != null) {
                        String str2 = "sign=" + md5;
                        try {
                            str2 = URLEncoder.encode(str2, "UTF-8");
                        } catch (UnsupportedEncodingException unused) {
                        }
                        str = str + o70.DINAMIC_PREFIX_AT + str2;
                    }
                    hVar.b("{\"photoType\":\"" + str2 + "\",\"sourceUrl\":\"" + str + "\"}");
                    o.this.a(new WVResult("success"), true);
                }

                @Override // com.alibaba.security.realidentity.upload.b.b
                public final void b(String str) {
                    if (com.alibaba.security.common.c.a.a()) {
                        com.alibaba.security.common.c.a.d("AbsJavaScriptExecuter", "arup upload fail: ".concat(String.valueOf(str)));
                    }
                    m.a().b(string);
                    WVResult wVResult = new WVResult();
                    wVResult.addData(a.N, str2);
                    wVResult.addData(a.r, string);
                    wVResult.addData("errorMsg", str);
                    hVar.a(wVResult);
                    com.alibaba.security.realidentity.a.b.a().a("RPException", "RPUpload", "upload fail.", str, null, null);
                    o.this.a(wVResult, false);
                }

                @Override // com.alibaba.security.realidentity.upload.b.b
                public final void a(long j, long j2) {
                    WVResult wVResult = new WVResult();
                    wVResult.addData(a.aa, String.valueOf(j));
                    wVResult.addData(a.ab, String.valueOf(j2));
                    wVResult.setSuccess();
                    o.this.an.a("rpUploadProgress", wVResult.toJsonString());
                }

                @Override // com.alibaba.security.realidentity.upload.b.b
                public final void a() {
                    m.a().b(string);
                }
            });
            m a2 = m.a();
            synchronized (a2.a) {
                if (string != null) {
                    a2.a.put(string, a);
                }
            }
            return true;
        } catch (Exception e) {
            if (com.alibaba.security.common.c.a.a()) {
                com.alibaba.security.common.c.a.b();
            }
            a.a("UploadApi parse error", e);
            a.a(hVar);
            return false;
        }
    }
}
