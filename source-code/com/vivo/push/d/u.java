package com.vivo.push.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.vivo.push.b.p;
import com.vivo.push.b.x;
import com.vivo.push.e;
import com.vivo.push.m;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.o;
import com.vivo.push.util.NotifyAdapterUtil;
import com.vivo.push.util.q;
import com.vivo.push.util.z;
import java.util.HashMap;
import java.util.Map;
import tb.jl1;

public final class u extends z {
    u(o oVar) {
        super(oVar);
    }

    public static Intent b(Intent intent, Map<String, String> map) {
        if (!(map == null || map.entrySet() == null)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!(entry == null || entry.getKey() == null)) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    @Override // com.vivo.push.l
    public final void a(o oVar) {
        p pVar = (p) oVar;
        InsideNotificationItem f = pVar.f();
        if (f == null) {
            com.vivo.push.util.p.d("OnNotificationClickTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage a = q.a(f);
        boolean equals = this.a.getPackageName().equals(pVar.d());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.a);
        }
        if (equals) {
            x xVar = new x(1030);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "2");
            hashMap.put("messageID", String.valueOf(pVar.e()));
            hashMap.put("platform", this.a.getPackageName());
            Context context = this.a;
            String b = z.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            xVar.a(hashMap);
            e.a().a(xVar);
            com.vivo.push.util.p.d("OnNotificationClickTask", "notification is clicked by skip type[" + a.getSkipType() + jl1.ARRAY_END_STR);
            int skipType = a.getSkipType();
            boolean z = true;
            if (skipType == 1) {
                new Thread(new v(this, this.a, a.getParams())).start();
                a(a);
            } else if (skipType == 2) {
                String skipContent = a.getSkipContent();
                if (!skipContent.startsWith("http://") && !skipContent.startsWith("https://")) {
                    z = false;
                }
                if (z) {
                    Uri parse = Uri.parse(skipContent);
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.setFlags(268435456);
                    b(intent, a.getParams());
                    try {
                        this.a.startActivity(intent);
                    } catch (Exception unused) {
                        com.vivo.push.util.p.a("OnNotificationClickTask", "startActivity error : ".concat(String.valueOf(parse)));
                    }
                } else {
                    com.vivo.push.util.p.a("OnNotificationClickTask", "url not legal");
                }
                a(a);
            } else if (skipType == 3) {
                a(a);
            } else if (skipType != 4) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "illegitmacy skip type error : " + a.getSkipType());
            } else {
                String skipContent2 = a.getSkipContent();
                try {
                    Intent parseUri = Intent.parseUri(skipContent2, 1);
                    String str = parseUri.getPackage();
                    if (TextUtils.isEmpty(str) || this.a.getPackageName().equals(str)) {
                        String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
                        if (TextUtils.isEmpty(packageName) || this.a.getPackageName().equals(packageName)) {
                            parseUri.setSelector(null);
                            parseUri.setPackage(this.a.getPackageName());
                            parseUri.addFlags(335544320);
                            b(parseUri, a.getParams());
                            ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.a.getPackageManager(), 65536);
                            if (resolveActivityInfo == null || resolveActivityInfo.exported) {
                                this.a.startActivity(parseUri);
                                a(a);
                                return;
                            }
                            com.vivo.push.util.p.a("OnNotificationClickTask", "activity is not exported : " + resolveActivityInfo.toString());
                            return;
                        }
                        com.vivo.push.util.p.a("OnNotificationClickTask", "open activity component error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                        return;
                    }
                    com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                } catch (Exception e) {
                    com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : ".concat(String.valueOf(skipContent2)), e);
                }
            }
        } else {
            com.vivo.push.util.p.a("OnNotificationClickTask", "notify is " + a + " ; isMatch is " + equals);
        }
    }

    private void a(UPSNotificationMessage uPSNotificationMessage) {
        m.c(new w(this, uPSNotificationMessage));
    }
}
