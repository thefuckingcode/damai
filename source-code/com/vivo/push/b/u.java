package com.vivo.push.b;

import com.vivo.push.a;

/* compiled from: Taobao */
public final class u extends v {
    private long a = -1;
    private int b;

    public u() {
        super(20);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s, com.vivo.push.b.v
    public final void c(a aVar) {
        super.c(aVar);
        aVar.a("undo_msg_v1", this.a);
        aVar.a("undo_msg_type_v1", this.b);
    }

    public final long d() {
        return this.a;
    }

    public final String e() {
        long j = this.a;
        if (j != -1) {
            return String.valueOf(j);
        }
        return null;
    }

    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final String toString() {
        return "OnUndoMsgCommand";
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s, com.vivo.push.b.v
    public final void d(a aVar) {
        super.d(aVar);
        this.a = aVar.b("undo_msg_v1", this.a);
        this.b = aVar.b("undo_msg_type_v1", 0);
    }
}
