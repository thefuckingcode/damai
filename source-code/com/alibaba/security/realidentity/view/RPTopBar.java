package com.alibaba.security.realidentity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.common.d.q;

/* compiled from: Taobao */
public class RPTopBar extends RelativeLayout {
    private static final int n = 20;
    private View a;
    private View b;
    private ViewGroup c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private ViewGroup g;
    private TextView h;
    private ViewGroup i;
    private ImageView j;
    private View k;
    private Context l;
    private int m;
    private View o;
    private int p;

    public RPTopBar(Context context) {
        this(context, null);
    }

    private void a() {
        this.a = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.rp_alrealidentity_top_bar, (ViewGroup) null);
        addView(this.a, new LinearLayout.LayoutParams(-1, -1));
        this.b = this.a.findViewById(R.id.status_bar);
        this.c = (ViewGroup) this.a.findViewById(R.id.iv_left_parent);
        this.d = (ImageView) this.a.findViewById(R.id.iv_left);
        this.e = (TextView) this.a.findViewById(R.id.tv_left_back);
        this.f = (TextView) this.a.findViewById(R.id.tv_title);
        this.g = (ViewGroup) this.a.findViewById(R.id.tv_right_search_parent);
        this.i = (ViewGroup) this.a.findViewById(R.id.iv_right_parent);
        this.k = this.a.findViewById(R.id.topbar_line);
        setClickable(true);
    }

    private void b() {
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        layoutParams.height = q.b(getContext());
        this.b.setLayoutParams(layoutParams);
        this.b.setVisibility(0);
        this.b.requestLayout();
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = q.b(getContext()) + q.a(getContext());
        setLayoutParams(layoutParams2);
        requestLayout();
    }

    private void c() {
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        layoutParams.height = 0;
        this.b.setLayoutParams(layoutParams);
        this.b.setVisibility(8);
        this.b.requestLayout();
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = q.a(getContext());
        setLayoutParams(layoutParams2);
        requestLayout();
    }

    private void d() {
        this.o.setVisibility(0);
    }

    private void e() {
        this.o.setVisibility(8);
    }

    private void f() {
        int max = Math.max(((LinearLayout) findViewById(R.id.left)).getMeasuredWidth(), ((LinearLayout) findViewById(R.id.right)).getMeasuredWidth());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams.leftMargin = max;
        int c2 = (int) (q.c(this.l) - ((float) (max * 2)));
        layoutParams.width = c2 > 0 ? c2 : 0;
        if (this.p != c2) {
            this.p = c2;
            this.f.requestLayout();
        }
    }

    public ImageView getIvLeft() {
        return this.d;
    }

    public ViewGroup getIvLeftParent() {
        return this.c;
    }

    public ImageView getIvRight() {
        return this.j;
    }

    public ViewGroup getIvRightParent() {
        return this.i;
    }

    public boolean[] getTopBarItemVisible() {
        boolean[] zArr = new boolean[2];
        boolean z = false;
        zArr[0] = this.c.getVisibility() == 0;
        if (this.i.getVisibility() == 0) {
            z = true;
        }
        zArr[1] = z;
        return zArr;
    }

    public TextView getTvLeftBack() {
        return this.e;
    }

    public TextView getTvRightSearch() {
        return this.h;
    }

    public ViewGroup getTvRightSearchParent() {
        return this.g;
    }

    public TextView getTvTitle() {
        return this.f;
    }

    public View getmRootView() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        f();
    }

    public void setBackgroundColor(int i2) {
        this.a.setBackgroundColor(i2);
    }

    public void setItemVisible(boolean z) {
        int i2 = z ? 0 : 4;
        ViewGroup[] viewGroupArr = {this.c, this.i};
        for (int i3 = 0; i3 < 2; i3++) {
            ViewGroup viewGroup = viewGroupArr[i3];
            if (viewGroup.getVisibility() != 8) {
                viewGroup.setVisibility(i2);
            }
        }
    }

    public void setTitle(String str) {
        this.f.setText(str);
        f();
    }

    public void setTopbarLineVisibility(int i2) {
        this.k.setVisibility(i2);
    }

    public void setTvRightSearch(TextView textView) {
        this.h = textView;
    }

    public void setTvRightSearchParent(ViewGroup viewGroup) {
        this.g = viewGroup;
    }

    public RPTopBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RPTopBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = 0;
        this.l = context;
        this.a = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.rp_alrealidentity_top_bar, (ViewGroup) null);
        addView(this.a, new LinearLayout.LayoutParams(-1, -1));
        this.b = this.a.findViewById(R.id.status_bar);
        this.c = (ViewGroup) this.a.findViewById(R.id.iv_left_parent);
        this.d = (ImageView) this.a.findViewById(R.id.iv_left);
        this.e = (TextView) this.a.findViewById(R.id.tv_left_back);
        this.f = (TextView) this.a.findViewById(R.id.tv_title);
        this.g = (ViewGroup) this.a.findViewById(R.id.tv_right_search_parent);
        this.i = (ViewGroup) this.a.findViewById(R.id.iv_right_parent);
        this.k = this.a.findViewById(R.id.topbar_line);
        setClickable(true);
    }

    private void a(boolean z, boolean z2) {
        if (z) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
        if (z2) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    private void a(boolean z) {
        if (this.e.getVisibility() != 0 || !z) {
            this.e.setVisibility(z ? 0 : 8);
        }
    }
}
