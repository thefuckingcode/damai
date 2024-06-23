package com.taobao.monitor.impl.trace;

import com.taobao.monitor.impl.trace.AbsDispatcher;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import tb.on1;

/* compiled from: Taobao */
public class PageLeaveDispatcher extends AbsDispatcher<PageLeaveListener> {
    public static final int TYPE_BACK = -4;
    public static final int TYPE_F2B = -3;
    public static final int TYPE_JUMP_NEXT_PAGE = -5;

    /* compiled from: Taobao */
    public interface PageLeaveListener {
        void onLeave(on1 on1, int i);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface PageLeaveType {
    }

    /* compiled from: Taobao */
    class a implements AbsDispatcher.ListenerCaller<PageLeaveListener> {
        final /* synthetic */ on1 a;
        final /* synthetic */ int b;

        a(PageLeaveDispatcher pageLeaveDispatcher, on1 on1, int i) {
            this.a = on1;
            this.b = i;
        }

        /* renamed from: a */
        public void callListener(PageLeaveListener pageLeaveListener) {
            pageLeaveListener.onLeave(this.a, this.b);
        }
    }

    public void f(on1 on1, int i) {
        c(new a(this, on1, i));
    }
}
