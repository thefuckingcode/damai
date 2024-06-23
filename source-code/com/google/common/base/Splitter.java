package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class Splitter {

    /* compiled from: Taobao */
    private interface Strategy {
        Iterator<String> iterator(Splitter splitter, CharSequence charSequence);
    }
}
