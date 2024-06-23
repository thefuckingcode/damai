package com.alibaba.pictures.ut;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import tb.oq2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0004"}, d2 = {"com/alibaba/pictures/ut/MovieShowUTHelper$setUTPageName$1", "Landroidx/lifecycle/LifecycleObserver;", "Ltb/ur2;", "onViewCreated", "ut_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class MovieShowUTHelper$setUTPageName$1 implements LifecycleObserver {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ MovieShowUTHelper this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    MovieShowUTHelper$setUTPageName$1(MovieShowUTHelper movieShowUTHelper) {
        this.this$0 = movieShowUTHelper;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onViewCreated() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2034872674")) {
            ipChange.ipc$dispatch("2034872674", new Object[]{this});
            return;
        }
        View view = ((Fragment) MovieShowUTHelper.b(this.this$0)).getView();
        if (view != null) {
            int b = oq2.b();
            String c = MovieShowUTHelper.c(this.this$0);
            if (c == null) {
                c = MovieShowUTHelper.a(this.this$0);
            }
            view.setTag(b, c);
        }
        ((Fragment) MovieShowUTHelper.b(this.this$0)).getLifecycle().removeObserver(this);
    }
}
