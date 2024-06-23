package com.uploader.implement.b.a;

import com.uploader.implement.b.e;
import com.uploader.implement.c;
import tb.g13;

/* compiled from: Taobao */
public class f extends g13 {
    public final boolean f;

    public f(String str, int i, boolean z, boolean z2) {
        super(str, i, null, 0, z);
        this.f = z2;
    }

    @Override // tb.g13
    public e a(c cVar) {
        if (this.e) {
            return new d(cVar, this);
        }
        return new d(cVar, this);
    }

    @Override // tb.g13
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof f) && super.equals(obj) && this.f == ((f) obj).f) {
            return true;
        }
        return false;
    }
}
