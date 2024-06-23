package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.a.a;
import com.vivo.push.b.c;
import com.vivo.push.b.w;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.e;
import com.vivo.push.l;
import com.vivo.push.model.b;
import com.vivo.push.o;
import com.vivo.push.util.p;
import com.vivo.push.util.s;
import com.vivo.push.util.t;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ah extends l {
    ah(o oVar) {
        super(oVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.l
    public final void a(o oVar) {
        Context context = this.a;
        if (context == null) {
            p.d("SendCommandTask", "SendCommandTask " + oVar + " ; mContext is Null");
        } else if (oVar == null) {
            p.d("SendCommandTask", "SendCommandTask pushCommand is Null");
        } else {
            b a = t.a(context);
            int b = oVar.b();
            if (b == 2009) {
                p.a(ClientConfigManagerImpl.getInstance(this.a).isDebug());
                if (p.a()) {
                    e.a().i();
                    com.vivo.push.util.b bVar = new com.vivo.push.util.b();
                    bVar.a(this.a, "com.vivo.push_preferences.hybridapptoken_v1");
                    bVar.a();
                    com.vivo.push.util.b bVar2 = new com.vivo.push.util.b();
                    bVar2.a(this.a, "com.vivo.push_preferences.appconfig_v1");
                    bVar2.a();
                    if (!e.a().e()) {
                        ClientConfigManagerImpl.getInstance(this.a).clearPush();
                    }
                }
            } else if (b != 2011) {
                switch (b) {
                    case 2002:
                    case 2003:
                    case 2004:
                    case 2005:
                        if (a == null || a.c()) {
                            e.a().a(((c) oVar).h(), 1005);
                            break;
                        } else {
                            c cVar = (c) oVar;
                            int a2 = s.a(cVar);
                            if (a2 != 0) {
                                e.a().a(cVar.h(), a2);
                                return;
                            }
                        }
                        break;
                }
            } else {
                p.a(ClientConfigManagerImpl.getInstance(this.a).isDebug(((w) oVar).d()));
            }
            if (a == null) {
                p.d("SendCommandTask", "SendCommandTask " + oVar + " ; pushPkgInfo is Null");
                return;
            }
            String a3 = a.a();
            if (a.c()) {
                try {
                    e.a().a(((c) oVar).h(), 1004);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                oVar = new com.vivo.push.b.e();
                p.d("SendCommandTask", "SendCommandTask " + oVar + " ; pkgName is InBlackList ");
            }
            a.a(this.a, a3, oVar);
        }
    }
}
