package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* compiled from: Taobao */
public abstract class t {
    protected t() {
    }

    /* access modifiers changed from: protected */
    public abstract Object delegate();

    public String toString() {
        return delegate().toString();
    }
}
