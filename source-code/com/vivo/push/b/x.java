package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.a;
import com.vivo.push.o;
import com.vivo.push.util.p;
import java.util.HashMap;
import tb.jl1;

/* compiled from: Taobao */
public final class x extends o {
    private HashMap<String, String> a;
    private long b;

    public x() {
        super(2012);
    }

    public final void a(HashMap<String, String> hashMap) {
        this.a = hashMap;
    }

    @Override // com.vivo.push.o
    public final void c(a aVar) {
        aVar.a("ReporterCommand.EXTRA_PARAMS", this.a);
        aVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.o
    public final void d(a aVar) {
        this.a = (HashMap) aVar.d("ReporterCommand.EXTRA_PARAMS");
        this.b = aVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "ReporterCommand（" + this.b + jl1.BRACKET_END_STR;
    }

    public x(long j) {
        this();
        this.b = j;
    }

    public final void d() {
        if (this.a == null) {
            p.d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder sb = new StringBuilder("report message reportType:");
        sb.append(this.b);
        sb.append(",msgId:");
        String str = this.a.get("messageID");
        if (TextUtils.isEmpty(str)) {
            str = this.a.get("message_id");
        }
        sb.append(str);
        p.d("ReporterCommand", sb.toString());
    }
}
