package com.uploader.implement.b.a;

import com.uploader.implement.b.e;
import com.uploader.implement.c;
import tb.g13;

/* compiled from: Taobao */
public class g extends g13 {
    public final String f;
    public final String g;

    public g(String str, int i, String str2, String str3) {
        super(str, i, null, 0, false);
        this.f = str2;
        this.g = str3;
    }

    @Override // tb.g13
    public e a(c cVar) {
        return new e(cVar, this);
    }

    @Override // tb.g13
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g) || !super.equals(obj)) {
            return false;
        }
        g gVar = (g) obj;
        String str = this.f;
        if (str == null ? gVar.f != null : !str.equals(gVar.f)) {
            return false;
        }
        String str2 = this.g;
        String str3 = gVar.g;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }
}
