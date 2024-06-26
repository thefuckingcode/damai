package com.meizu.cloud.pushsdk.handler.a.b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a.c.g;
import com.meizu.cloud.pushsdk.notification.c;
import com.meizu.cloud.pushsdk.platform.a.b;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.d;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;

/* compiled from: Taobao */
public class a extends com.meizu.cloud.pushsdk.handler.a.a<g> {
    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 65536;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void b(g gVar) {
        d.b(d(), d().getPackageName(), gVar.d().b().d(), gVar.d().b().a(), gVar.d().b().e(), gVar.d().b().b());
    }

    /* access modifiers changed from: protected */
    public void a(g gVar, c cVar) {
        String str;
        String str2;
        String str3;
        DebugLogger.flush();
        String a = gVar.d().b().a();
        String d = gVar.d().b().d();
        if (Build.VERSION.SDK_INT >= 29) {
            str = MzSystemUtils.getDocumentsPath(d()) + "/pushSdktmp/" + a + JSMethod.NOT_SET + d + ".zip";
        } else {
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdktmp/" + a + JSMethod.NOT_SET + d + ".zip";
        }
        File file = null;
        try {
            new b(str).a(gVar.c());
            File file2 = new File(str);
            str2 = null;
            file = file2;
        } catch (Exception e) {
            str2 = e.getMessage();
            DebugLogger.e("AbstractMessageHandler", "zip error message " + str2);
        }
        if (file != null && file.length() / 1024 > ((long) gVar.a())) {
            str2 = "the upload file exceeds the max size";
        } else if (gVar.b() && !com.meizu.cloud.pushsdk.util.a.b(d())) {
            str2 = "current network not allowed upload log file";
        }
        com.meizu.cloud.pushsdk.c.a.c<String> a2 = b.a(d()).a(gVar.d().b().a(), gVar.d().b().d(), str2, file);
        if (a2 == null || !a2.b()) {
            if (a2 != null) {
                str3 = "upload error code " + a2.c() + a2.a();
            } else {
                str3 = "upload error";
            }
            DebugLogger.i("AbstractMessageHandler", str3);
            return;
        }
        if (file != null) {
            file.delete();
        }
        DebugLogger.e("AbstractMessageHandler", "upload success " + a2.a());
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        int i;
        DebugLogger.i("AbstractMessageHandler", "start LogUploadMessageHandler match");
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            com.meizu.cloud.pushsdk.handler.a.c.b a = com.meizu.cloud.pushsdk.handler.a.c.b.a(stringExtra);
            if (a.a() != null) {
                i = a.a().a();
                return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && "2".equals(String.valueOf(i));
            }
        }
        i = 0;
        if (PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction())) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public g c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
        return new g(intent.getStringExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE), stringExtra, intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), stringExtra2);
    }
}
