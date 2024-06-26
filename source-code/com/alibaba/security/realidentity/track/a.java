package com.alibaba.security.realidentity.track;

import android.content.Context;
import android.os.Looper;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.bean.ClientInfo;
import com.alibaba.security.realidentity.http.RpcInvoker;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public final class a implements com.alibaba.security.common.track.b.a {
    private static final String b = "TrackUpload";
    private static final boolean c = false;
    final String a = "mtop.verifycenter.rp.log";
    private final Context d;
    private final ThreadPoolExecutor e;

    public a(Context context) {
        this.d = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            /* class com.alibaba.security.realidentity.track.a.AnonymousClass1 */

            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "tbrpsdk-trackUpload");
            }
        });
        this.e = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    /* access modifiers changed from: package-private */
    public final void b(List<TrackLog> list) {
        RPTrackHttpModel rPTrackHttpModel = new RPTrackHttpModel();
        String str = g.a.a.d;
        rPTrackHttpModel.setClientInfo(a(str));
        rPTrackHttpModel.setVerifyToken(str);
        rPTrackHttpModel.setWirelessLogs(list);
        HashMap hashMap = new HashMap();
        hashMap.put("request", h.a(rPTrackHttpModel));
        Context context = this.d;
        if (context != null) {
            RpcInvoker.callMtopSync(context, "mtop.verifycenter.rp.log", "1.0", true, h.a((Object) hashMap));
        }
    }

    private ClientInfo a(String str) {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setVersionTag(com.alibaba.security.common.d.a.a(ALBiometricsJni.genVersionTag(this.d, str)));
        return clientInfo;
    }

    @Override // com.alibaba.security.common.track.b.a
    public final void a(final List<TrackLog> list) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.e.execute(new Runnable() {
                /* class com.alibaba.security.realidentity.track.a.AnonymousClass2 */

                public final void run() {
                    a.this.b(list);
                }
            });
        } else {
            b(list);
        }
    }
}
