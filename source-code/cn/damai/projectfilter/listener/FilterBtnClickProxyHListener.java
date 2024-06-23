package cn.damai.projectfilter.listener;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import cn.damai.projectfilter.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FilterBtnClickProxyHListener implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Type a;
    private FilterBtnClickListener b;
    private FilterBtnAction c;
    private Handler d = new Handler(Looper.getMainLooper());

    public FilterBtnClickProxyHListener(Type type, FilterBtnClickListener filterBtnClickListener, FilterBtnAction filterBtnAction) {
        this.a = type;
        this.b = filterBtnClickListener;
        this.c = filterBtnAction;
    }

    public void onClick(final View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-697275878")) {
            ipChange.ipc$dispatch("-697275878", new Object[]{this, view});
            return;
        }
        FilterBtnAction filterBtnAction = this.c;
        if (filterBtnAction != null) {
            filterBtnAction.doBeforeFilterBtnClick(this.a);
        }
        if (this.b != null) {
            this.d.post(new Runnable() {
                /* class cn.damai.projectfilter.listener.FilterBtnClickProxyHListener.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    int i = 0;
                    if (AndroidInstantRuntime.support(ipChange, "1741541609")) {
                        ipChange.ipc$dispatch("1741541609", new Object[]{this});
                        return;
                    }
                    if (FilterBtnClickProxyHListener.this.c != null) {
                        i = FilterBtnClickProxyHListener.this.c.computeFloatTopPadding();
                    }
                    FilterBtnClickProxyHListener.this.b.onFilterBtnClick(view, i);
                }
            });
        }
    }
}
