package com.ali.ha.fulltrace;

import android.app.Application;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.ali.ha.fulltrace.upload.UploadManager;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.weex.devtools.debug.WXDebugConstants;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.HashMap;
import tb.lg0;
import tb.p91;

/* compiled from: Taobao */
final class FulltraceLauncher$1 implements Runnable {
    final /* synthetic */ Application val$application;

    FulltraceLauncher$1(Application application) {
        this.val$application = application;
    }

    public void run() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("appVersion", lg0.e);
        hashMap.put(Constants.KEY_APP_BUILD, lg0.d);
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, lg0.b);
        hashMap.put("appKey", lg0.c);
        hashMap.put("channel", lg0.f);
        hashMap.put("utdid", lg0.g);
        hashMap.put("userId", lg0.l);
        hashMap.put("userNick", lg0.m);
        hashMap.put("ttid", lg0.q);
        hashMap.put("apmVersion", lg0.a);
        hashMap.put(Preloader.KEY_SESSION, lg0.o);
        hashMap.put(com.taobao.aranger.constant.Constants.PARAM_PROCESS_NAME, lg0.p);
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("brand", lg0.h);
        hashMap2.put(WXDebugConstants.ENV_DEVICE_MODEL, lg0.i);
        hashMap2.put(TbAuthConstants.CLIENT_IP, lg0.n);
        hashMap2.put("os", lg0.j);
        hashMap2.put("osVersion", lg0.k);
        p91.e(false);
        DumpManager.c().f(this.val$application, hashMap, hashMap2);
        UploadManager.f().i(this.val$application);
    }
}
