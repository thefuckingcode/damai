package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* compiled from: Taobao */
public abstract class j {
    private static final j a = new a();

    /* compiled from: Taobao */
    static class a extends j {
        a() {
        }

        @Override // com.google.common.base.j
        public long a() {
            return f.f();
        }
    }

    protected j() {
    }

    public static j b() {
        return a;
    }

    public abstract long a();
}
