package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.vivo.push.b.u;
import com.vivo.push.b.x;
import com.vivo.push.e;
import com.vivo.push.o;
import com.vivo.push.util.NotifyAdapterUtil;
import com.vivo.push.util.p;
import com.vivo.push.util.z;
import java.util.HashMap;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class af extends z {
    af(o oVar) {
        super(oVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.l
    public final void a(o oVar) {
        u uVar = (u) oVar;
        if (!e.a().g() || a(z.c(this.a), uVar.e(), uVar.i())) {
            boolean repealNotifyById = NotifyAdapterUtil.repealNotifyById(this.a, uVar.d());
            p.d("OnUndoMsgTask", "undo message " + uVar.d() + AVFSCacheConstants.COMMA_SEP + repealNotifyById);
            if (repealNotifyById) {
                Context context = this.a;
                p.b(context, "回收client通知成功, 上报埋点 1031, messageId = " + uVar.d());
                com.vivo.push.util.e.a(this.a, uVar.d(), 1031);
                return;
            }
            p.d("OnUndoMsgTask", "undo message fail，messageId = " + uVar.d());
            Context context2 = this.a;
            p.c(context2, "回收client通知失败，messageId = " + uVar.d());
            return;
        }
        p.d("OnUndoMsgTask", " vertify msg is error ");
        x xVar = new x(1021);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("messageID", String.valueOf(uVar.f()));
        Context context3 = this.a;
        String b = z.b(context3, context3.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        xVar.a(hashMap);
        e.a().a(xVar);
    }
}
