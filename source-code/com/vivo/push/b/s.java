package com.vivo.push.b;

import com.vivo.push.a;
import com.vivo.push.o;

/* compiled from: Taobao */
public class s extends o {
    private String a = null;
    private int b = 0;

    public s(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public void c(a aVar) {
        aVar.a("req_id", this.a);
        aVar.a("status_msg_code", this.b);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public void d(a aVar) {
        this.a = aVar.a("req_id");
        this.b = aVar.b("status_msg_code", this.b);
    }

    public final String g() {
        return this.a;
    }

    public final int h() {
        return this.b;
    }

    @Override // com.vivo.push.o
    public String toString() {
        return "OnReceiveCommand";
    }
}
