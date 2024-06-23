package com.vivo.push;

import android.content.Intent;
import com.vivo.push.b.i;
import com.vivo.push.b.j;
import com.vivo.push.b.k;
import com.vivo.push.b.l;
import com.vivo.push.b.m;
import com.vivo.push.b.n;
import com.vivo.push.b.o;
import com.vivo.push.b.p;
import com.vivo.push.b.q;
import com.vivo.push.b.r;
import com.vivo.push.b.t;
import com.vivo.push.b.u;
import com.vivo.push.d.ag;
import com.vivo.push.d.z;

/* compiled from: Taobao */
public final class d implements IPushClientFactory {
    private ag a = new ag();

    @Override // com.vivo.push.IPushClientFactory
    public final z createReceiveTask(o oVar) {
        return ag.b(oVar);
    }

    @Override // com.vivo.push.IPushClientFactory
    public final o createReceiverCommand(Intent intent) {
        o oVar;
        o oVar2;
        int intExtra = intent.getIntExtra("command", -1);
        if (intExtra < 0) {
            intExtra = intent.getIntExtra("method", -1);
        }
        if (intExtra == 20) {
            oVar = new u();
        } else if (intExtra != 2016) {
            switch (intExtra) {
                case 1:
                case 2:
                    oVar2 = new t(intExtra);
                    oVar = oVar2;
                    break;
                case 3:
                    oVar = new o();
                    break;
                case 4:
                    oVar = new q();
                    break;
                case 5:
                    oVar = new p();
                    break;
                case 6:
                    oVar = new r();
                    break;
                case 7:
                    oVar = new n();
                    break;
                case 8:
                    oVar = new m();
                    break;
                case 9:
                    oVar = new k();
                    break;
                case 10:
                case 11:
                    oVar2 = new i(intExtra);
                    oVar = oVar2;
                    break;
                case 12:
                    oVar = new j();
                    break;
                default:
                    oVar = null;
                    break;
            }
        } else {
            oVar = new l();
        }
        if (oVar != null) {
            a a2 = a.a(intent);
            if (a2 == null) {
                com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            } else {
                oVar.b(a2);
            }
        }
        return oVar;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final l createTask(o oVar) {
        return ag.a(oVar);
    }
}
