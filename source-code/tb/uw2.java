package tb;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.discover.bean.VoteBean;
import cn.damai.tetris.component.drama.viewholder.OnItemClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class uw2 implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProgressBar a;
    private TextView b;
    private TextView c;
    private OnItemClickListener<VoteBean> d;
    private VoteBean e;
    private int f;
    private boolean g;
    private Drawable h;
    private Drawable i;
    private int j;
    private int k;

    /* compiled from: Taobao */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-187094296")) {
                ipChange.ipc$dispatch("-187094296", new Object[]{this, valueAnimator});
                return;
            }
            uw2.this.a.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public uw2(ViewGroup viewGroup, OnItemClickListener<VoteBean> onItemClickListener) {
        this.a = (ProgressBar) viewGroup.findViewById(R$id.item_single_vote_progress);
        this.b = (TextView) viewGroup.findViewById(R$id.item_single_vote_text);
        this.c = (TextView) viewGroup.findViewById(R$id.item_single_vote_count);
        this.d = onItemClickListener;
        viewGroup.setOnClickListener(this);
    }

    private void c(int i2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "183242857")) {
            ipChange.ipc$dispatch("183242857", new Object[]{this, Integer.valueOf(i2), Boolean.valueOf(z)});
            return;
        }
        if (i2 <= 0) {
            i2 = 0;
        }
        if (i2 > 100) {
            i2 = 100;
        }
        Object tag = this.a.getTag();
        if (tag instanceof ValueAnimator) {
            ((ValueAnimator) tag).cancel();
            this.a.setTag(null);
        }
        if (i2 <= 0 || !z) {
            this.a.setProgress(i2);
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, i2);
        ofInt.addUpdateListener(new a());
        ofInt.setDuration(300L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.start();
        this.a.setTag(ofInt);
    }

    public void b(VoteBean voteBean, boolean z, int i2, boolean z2) {
        Drawable drawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "581923345")) {
            ipChange.ipc$dispatch("581923345", new Object[]{this, voteBean, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)});
        } else if (voteBean != null) {
            this.e = voteBean;
            this.f = i2;
            this.b.setText(voteBean.name);
            if (this.g) {
                this.a.getLayoutParams().height = s50.a(xs0.a().getApplicationContext(), 40.0f);
                ((LinearLayout.LayoutParams) this.b.getLayoutParams()).leftMargin = s50.a(xs0.a().getApplicationContext(), 6.0f);
                this.b.setTextSize(14.0f);
                ((LinearLayout.LayoutParams) this.c.getLayoutParams()).rightMargin = s50.a(xs0.a().getApplicationContext(), 6.0f);
                this.c.setTextSize(14.0f);
            }
            if (z) {
                this.c.setText(voteBean.totalDesc);
                this.c.setVisibility(0);
                if (voteBean.hasVote) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawable = xs0.a().getDrawable(R$drawable.icon_vote_dui_gou_fuhao);
                    } else {
                        drawable = xs0.a().getResources().getDrawable(R$drawable.icon_vote_dui_gou_fuhao);
                    }
                    int a2 = n42.a(xs0.a(), 16.0f);
                    drawable.setBounds(0, 0, a2, a2);
                    if (this.g) {
                        drawable.mutate();
                        DrawableCompat.setTint(drawable, this.k);
                        this.a.setProgressDrawable(this.h);
                        this.b.setTextColor(this.k);
                        this.c.setTextColor(this.k);
                    }
                    this.b.setCompoundDrawables(null, null, drawable, null);
                    this.b.setCompoundDrawablePadding(n42.a(xs0.a(), 3.0f));
                } else {
                    if (this.g) {
                        this.a.setProgressDrawable(this.i);
                        this.b.setTextColor(this.j);
                        this.c.setTextColor(this.j);
                    }
                    this.b.setCompoundDrawables(null, null, null, null);
                }
            } else {
                this.b.setCompoundDrawables(null, null, null, null);
                if (this.g) {
                    this.a.setProgressDrawable(this.i);
                    this.b.setTextColor(this.j);
                }
                this.c.setVisibility(8);
            }
            if (z) {
                c(voteBean.progressInt, z2);
            } else {
                c(0, false);
            }
        }
    }

    public void d(Drawable drawable, Drawable drawable2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "599840573")) {
            ipChange.ipc$dispatch("599840573", new Object[]{this, drawable, drawable2, str, str2});
            return;
        }
        this.g = true;
        this.h = drawable;
        this.i = drawable2;
        this.j = Color.parseColor(str2);
        this.k = Color.parseColor(str);
    }

    public void onClick(View view) {
        VoteBean voteBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2125846868")) {
            ipChange.ipc$dispatch("2125846868", new Object[]{this, view});
            return;
        }
        OnItemClickListener<VoteBean> onItemClickListener = this.d;
        if (onItemClickListener != null && (voteBean = this.e) != null) {
            onItemClickListener.onItemClick(voteBean, this.f);
        }
    }
}
