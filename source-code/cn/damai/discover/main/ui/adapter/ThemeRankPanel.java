package cn.damai.discover.main.ui.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.discover.main.ui.bean.RankUserBean;
import cn.damai.discover.main.ui.bean.ThemeRankBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.lk1;
import tb.n42;
import tb.xs0;
import tb.zy2;

/* compiled from: Taobao */
public class ThemeRankPanel implements WeakRefCountDownTimer.OnTickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private ViewStub b;
    private View c;
    private View d;
    private View e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private ThemeRankAdapter k;
    private OnItemBindListener<RankUserBean> l;
    private zy2 m;
    private int n;
    private int o;
    private long[] p = new long[4];
    private String[] q = new String[4];

    public ThemeRankPanel(Context context, ViewStub viewStub, OnItemBindListener<RankUserBean> onItemBindListener) {
        this.a = context;
        this.b = viewStub;
        this.l = onItemBindListener;
        this.n = n42.a(xs0.a(), 11.0f);
        this.o = n42.a(xs0.a(), 6.0f);
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281070343")) {
            ipChange.ipc$dispatch("1281070343", new Object[]{this});
        } else if (this.c == null) {
            View inflate = this.b.inflate();
            this.c = inflate;
            this.d = inflate.findViewById(R$id.theme_rank_end);
            this.e = this.c.findViewById(R$id.theme_rank_count_down_ui);
            this.f = (TextView) this.c.findViewById(R$id.theme_rank_day_num);
            this.g = (TextView) this.c.findViewById(R$id.theme_rank_day_text);
            this.h = (TextView) this.c.findViewById(R$id.theme_rank_hour_num);
            this.i = (TextView) this.c.findViewById(R$id.theme_rank_minute_num);
            this.j = (TextView) this.c.findViewById(R$id.theme_rank_second_num);
            RecyclerView recyclerView = (RecyclerView) this.c.findViewById(R$id.theme_rank_lv);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
            ThemeRankAdapter themeRankAdapter = new ThemeRankAdapter(this.a, this.l);
            this.k = themeRankAdapter;
            recyclerView.setAdapter(themeRankAdapter);
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
                /* class cn.damai.discover.main.ui.adapter.ThemeRankPanel.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    IpChange ipChange = $ipChange;
                    boolean z = true;
                    if (AndroidInstantRuntime.support(ipChange, "2074566294")) {
                        ipChange.ipc$dispatch("2074566294", new Object[]{this, rect, view, recyclerView, state});
                        return;
                    }
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                    boolean z2 = childAdapterPosition == 0;
                    if (childAdapterPosition != ThemeRankPanel.this.k.getItemCount() - 1) {
                        z = false;
                    }
                    if (z2) {
                        rect.left = ThemeRankPanel.this.n;
                    } else {
                        rect.left = ThemeRankPanel.this.o;
                    }
                    if (z) {
                        rect.right = ThemeRankPanel.this.n;
                    } else {
                        rect.right = 0;
                    }
                }
            });
        }
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-61643372")) {
            ipChange.ipc$dispatch("-61643372", new Object[]{this});
            return;
        }
        View view = this.c;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private boolean g(String str) {
        int length;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1538011899")) {
            return ((Boolean) ipChange.ipc$dispatch("-1538011899", new Object[]{this, str})).booleanValue();
        }
        if (TextUtils.isEmpty(str) || (length = str.length()) <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != '0') {
                return false;
            }
        }
        return true;
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-336097688")) {
            ipChange.ipc$dispatch("-336097688", new Object[]{this});
            return;
        }
        this.d.setVisibility(0);
        this.e.setVisibility(8);
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1475839921")) {
            ipChange.ipc$dispatch("-1475839921", new Object[]{this});
            return;
        }
        View view = this.c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public int e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "137895457")) {
            return ((Integer) ipChange.ipc$dispatch("137895457", new Object[]{this})).intValue();
        }
        View view = this.c;
        if (view != null) {
            return view.getVisibility();
        }
        return 8;
    }

    public void j(@Nullable ThemeRankBean themeRankBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1092946688")) {
            ipChange.ipc$dispatch("1092946688", new Object[]{this, themeRankBean});
        } else if (themeRankBean == null) {
            f();
        } else {
            d();
            i();
            zy2 zy2 = this.m;
            if (zy2 != null) {
                zy2.cancel();
            }
            long j2 = themeRankBean.countDown;
            if (j2 > 0) {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
                zy2 zy22 = new zy2(j2, 1000, this);
                this.m = zy22;
                zy22.start();
            } else {
                h();
            }
            this.k.d(themeRankBean.getRankList());
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2126229630")) {
            ipChange.ipc$dispatch("-2126229630", new Object[]{this});
            return;
        }
        h();
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onTick(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1847846796")) {
            ipChange.ipc$dispatch("1847846796", new Object[]{this, Long.valueOf(j2)});
            return;
        }
        this.e.setVisibility(0);
        lk1.b(this.p, j2);
        lk1.d(this.q, this.p);
        String[] strArr = this.q;
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        String str4 = strArr[3];
        if (TextUtils.isEmpty(str) || g(str)) {
            this.f.setVisibility(8);
            this.g.setVisibility(8);
        } else {
            this.f.setVisibility(0);
            this.g.setVisibility(0);
            this.f.setText(str);
        }
        this.h.setText(str2);
        this.i.setText(str3);
        this.j.setText(str4);
    }
}
