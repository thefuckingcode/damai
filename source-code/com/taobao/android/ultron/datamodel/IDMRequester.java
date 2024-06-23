package com.taobao.android.ultron.datamodel;

import tb.f1;

/* compiled from: Taobao */
public interface IDMRequester {
    @Deprecated
    boolean execute(IRequestCallback iRequestCallback);

    boolean execute(Object obj, f1 f1Var);

    boolean execute(f1 f1Var);
}
