package com.vivo.push.d;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.b.q;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.util.e;
import com.vivo.push.util.k;
import com.vivo.push.util.p;
import com.vivo.push.util.r;
import com.vivo.push.util.z;
import java.util.HashMap;

/* compiled from: Taobao */
final class s implements Runnable {
    final /* synthetic */ InsideNotificationItem a;
    final /* synthetic */ q b;
    final /* synthetic */ r c;

    s(r rVar, InsideNotificationItem insideNotificationItem, q qVar) {
        this.c = rVar;
        this.a = insideNotificationItem;
        this.b = qVar;
    }

    public final void run() {
        char c2;
        r rVar = this.c;
        if (((z) rVar).b.onNotificationMessageArrived(r.a(rVar), com.vivo.push.util.q.a(this.a))) {
            p.b("OnNotificationArrivedTask", "pkg name : " + r.b(this.c).getPackageName() + " 应用主动拦截通知");
            p.b(r.c(this.c), "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
            HashMap hashMap = new HashMap();
            hashMap.put("messageID", String.valueOf(this.b.f()));
            String b2 = z.b(r.d(this.c), r.e(this.c).getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            e.a(2120, hashMap);
            return;
        }
        int b3 = this.c.b();
        if (b3 > 0) {
            p.b("OnNotificationArrivedTask", "pkg name : " + r.f(this.c).getPackageName() + " notify channel switch is " + b3);
            p.b(r.g(this.c), "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(b3)));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("messageID", String.valueOf(this.b.f()));
            String b4 = z.b(r.h(this.c), r.i(this.c).getPackageName());
            if (!TextUtils.isEmpty(b4)) {
                hashMap2.put("remoteAppId", b4);
            }
            e.a((long) b3, hashMap2);
            return;
        }
        Context j = r.j(this.c);
        InsideNotificationItem insideNotificationItem = this.a;
        long f = this.b.f();
        r rVar2 = this.c;
        k kVar = new k(j, insideNotificationItem, f, ((z) rVar2).b.isAllowNet(r.k(rVar2)), new t(this));
        boolean isShowBigPicOnMobileNet = this.a.isShowBigPicOnMobileNet();
        String purePicUrl = this.a.getPurePicUrl();
        if (TextUtils.isEmpty(purePicUrl)) {
            purePicUrl = this.a.getCoverUrl();
        }
        if (!TextUtils.isEmpty(purePicUrl)) {
            p.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(isShowBigPicOnMobileNet)));
            if (!isShowBigPicOnMobileNet) {
                p.a(r.p(this.c), "mobile net unshow");
                NetworkInfo a2 = r.a(r.q(this.c));
                if (a2 != null && a2.getState() == NetworkInfo.State.CONNECTED) {
                    int type = a2.getType();
                    c2 = type == 1 ? 2 : type == 0 ? (char) 1 : 3;
                } else {
                    c2 = 0;
                }
                if (c2 == 1) {
                    purePicUrl = null;
                    this.a.clearCoverUrl();
                    this.a.clearPurePicUrl();
                }
            } else {
                p.a(r.r(this.c), "mobile net show");
            }
        }
        kVar.execute(this.a.getIconUrl(), purePicUrl);
    }
}
