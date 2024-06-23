package cn.damai.user.repertoite;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ne2;
import tb.ut2;

/* compiled from: Taobao */
public class RecyclerScrollListener extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    Boolean a;
    LinearLayoutManager b;
    View c;
    View d;
    Activity e;

    public void a(Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-157095947")) {
            ipChange.ipc$dispatch("-157095947", new Object[]{this, bool});
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1962044555")) {
            ipChange.ipc$dispatch("1962044555", new Object[]{this, recyclerView, Integer.valueOf(i)});
            return;
        }
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            z = false;
        }
        this.a = Boolean.valueOf(z);
        if (i == 0) {
            a(Boolean.TRUE);
        } else {
            a(Boolean.FALSE);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "151991092")) {
            ipChange.ipc$dispatch("151991092", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onScrolled(recyclerView, i, i2);
        if (this.a.booleanValue() || this.b == null || this.c == null || this.d == null || this.e == null) {
            int findFirstVisibleItemPosition = this.b.findFirstVisibleItemPosition();
            View findViewByPosition = this.b.findViewByPosition(findFirstVisibleItemPosition);
            int height = this.d.getHeight();
            if (findFirstVisibleItemPosition <= 1) {
                int abs = Math.abs(findViewByPosition.getTop());
                if (abs <= 0) {
                    this.c.setBackgroundColor(ut2.a(0.0f, this.e.getResources().getColor(R$color.white)));
                    if (Build.VERSION.SDK_INT >= 23) {
                        ne2.e(this.e);
                    }
                } else if (abs <= 0 || abs > height) {
                    this.c.setBackgroundColor(ut2.a(255.0f, this.e.getResources().getColor(R$color.white)));
                } else {
                    float f = ((float) abs) / ((float) height);
                    this.c.setBackgroundColor(ut2.a(255.0f * f, this.e.getResources().getColor(R$color.white)));
                    if (Build.VERSION.SDK_INT >= 23 && ((double) f) >= 0.5d) {
                        ne2.f(this.e, true, R$color.black);
                        ne2.d(true, this.e);
                    }
                }
            } else {
                this.c.setBackgroundColor(ut2.a(255.0f, this.e.getResources().getColor(R$color.white)));
            }
        }
    }
}
