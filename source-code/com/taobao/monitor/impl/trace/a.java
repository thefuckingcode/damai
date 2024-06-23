package com.taobao.monitor.impl.trace;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.taobao.monitor.impl.trace.AbsDispatcher;

/* compiled from: Taobao */
public class a extends AbsDispatcher<FragmentFunctionListener> implements FragmentFunctionListener {

    /* renamed from: com.taobao.monitor.impl.trace.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    class C0221a implements AbsDispatcher.ListenerCaller<FragmentFunctionListener> {
        final /* synthetic */ Activity a;
        final /* synthetic */ Fragment b;
        final /* synthetic */ String c;
        final /* synthetic */ long d;

        C0221a(a aVar, Activity activity, Fragment fragment, String str, long j) {
            this.a = activity;
            this.b = fragment;
            this.c = str;
            this.d = j;
        }

        /* renamed from: a */
        public void callListener(FragmentFunctionListener fragmentFunctionListener) {
            fragmentFunctionListener.onFunction(this.a, this.b, this.c, this.d);
        }
    }

    @Override // com.taobao.monitor.impl.trace.FragmentFunctionListener
    public void onFunction(Activity activity, Fragment fragment, String str, long j) {
        c(new C0221a(this, activity, fragment, str, j));
    }
}
