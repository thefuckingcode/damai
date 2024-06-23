package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import java.util.Date;
import tb.jl1;

/* compiled from: Taobao */
class fv implements fz {
    final /* synthetic */ fu a;

    fv(fu fuVar) {
        this.a = fuVar;
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar) {
        b.c("[Slim] " + fu.a(this.a).format(new Date()) + " Connection started (" + fu.a(this.a).hashCode() + jl1.BRACKET_END_STR);
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, int i, Exception exc) {
        b.c("[Slim] " + fu.a(this.a).format(new Date()) + " Connection closed (" + fu.a(this.a).hashCode() + jl1.BRACKET_END_STR);
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, Exception exc) {
        b.c("[Slim] " + fu.a(this.a).format(new Date()) + " Reconnection failed due to an exception (" + fu.a(this.a).hashCode() + jl1.BRACKET_END_STR);
        exc.printStackTrace();
    }

    @Override // com.xiaomi.push.fz
    public void b(fw fwVar) {
        b.c("[Slim] " + fu.a(this.a).format(new Date()) + " Connection reconnected (" + fu.a(this.a).hashCode() + jl1.BRACKET_END_STR);
    }
}
