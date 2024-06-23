package com.taobao.android.dinamicx.expression.event.bindingx;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import tb.lx;

/* compiled from: Taobao */
public class DXBindingXStateChangeEvent extends lx {
    public static final long DXVIEWWIDGETNODE_ONBINDINGXFINISH = -5192979070104500639L;
    public static final long DXVIEWWIDGETNODE_ONBINDINGXSTART = -1026451533627932147L;
    public static final long DXVIEWWIDGETNODE_ONBINDINGXSTOP = 6689515913358780580L;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    @interface DXBindingStateChangeEventId {
    }

    public DXBindingXStateChangeEvent(long j, String str) {
        super(j);
    }
}
