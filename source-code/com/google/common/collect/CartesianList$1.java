package com.google.common.collect;

import java.util.List;
import tb.ds1;

/* compiled from: Taobao */
class CartesianList$1 extends ImmutableList<Object> {
    final /* synthetic */ j this$0;
    final /* synthetic */ int val$index;

    CartesianList$1(j jVar, int i) {
        this.val$index = i;
    }

    @Override // java.util.List
    public Object get(int i) {
        ds1.n(i, size());
        return ((List) j.a(this.this$0).get(i)).get(j.b(this.this$0, this.val$index, i));
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return j.a(this.this$0).size();
    }
}
