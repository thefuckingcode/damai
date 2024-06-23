package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.a;
import com.vivo.push.model.UnvarnishedMessage;

/* compiled from: Taobao */
public final class o extends v {
    protected UnvarnishedMessage a;

    public o() {
        super(3);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s, com.vivo.push.b.v
    public final void c(a aVar) {
        super.c(aVar);
        aVar.a("msg_v1", this.a.unpackToJson());
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s, com.vivo.push.b.v
    public final void d(a aVar) {
        super.d(aVar);
        String a2 = aVar.a("msg_v1");
        if (!TextUtils.isEmpty(a2)) {
            UnvarnishedMessage unvarnishedMessage = new UnvarnishedMessage(a2);
            this.a = unvarnishedMessage;
            unvarnishedMessage.setMsgId(f());
        }
    }

    public final UnvarnishedMessage e() {
        return this.a;
    }

    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final String toString() {
        return "OnMessageCommand";
    }

    public final String d() {
        UnvarnishedMessage unvarnishedMessage = this.a;
        if (unvarnishedMessage == null) {
            return null;
        }
        return unvarnishedMessage.unpackToJson();
    }
}
