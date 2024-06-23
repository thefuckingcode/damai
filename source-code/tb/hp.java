package tb;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.crouton.LifecycleCallback;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.dg2;

/* compiled from: Taobao */
public final class hp {
    private static transient /* synthetic */ IpChange $ipChange;
    private final CharSequence a;
    private final dg2 b;
    private zl c = null;
    private final View d;
    private View.OnClickListener e;
    private Activity f;
    private ViewGroup g;
    private FrameLayout h;
    private Animation i;
    private Animation j;
    private LifecycleCallback k = null;

    private hp(Activity activity, View view) {
        if (activity == null || view == null) {
            throw new IllegalArgumentException("Null parameters are not accepted");
        }
        this.f = activity;
        this.g = null;
        this.d = view;
        this.b = new dg2.b().z();
        this.a = null;
    }

    private RelativeLayout m(Resources resources) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1143473610")) {
            return (RelativeLayout) ipChange.ipc$dispatch("-1143473610", new Object[]{this, resources});
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        dg2 dg2 = this.b;
        int i2 = dg2.v;
        int i3 = dg2.w;
        if (i3 > 0) {
            i2 = resources.getDimensionPixelSize(i3);
        }
        relativeLayout.setPadding(i2, i2, i2, i2);
        ImageView imageView = null;
        dg2 dg22 = this.b;
        if (!(dg22.m == null && dg22.n == 0)) {
            imageView = p();
            relativeLayout.addView(imageView, imageView.getLayoutParams());
        }
        TextView q = q(resources);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (imageView != null) {
            layoutParams.addRule(1, imageView.getId());
        }
        int i4 = this.b.l;
        if ((i4 & 17) != 0) {
            layoutParams.addRule(13);
        } else if ((i4 & 16) != 0) {
            layoutParams.addRule(15);
        } else if ((i4 & 1) != 0) {
            layoutParams.addRule(14);
        }
        relativeLayout.addView(q, layoutParams);
        return relativeLayout;
    }

    private void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2139714410")) {
            ipChange.ipc$dispatch("-2139714410", new Object[]{this});
            return;
        }
        Resources resources = this.f.getResources();
        this.h = o(resources);
        this.h.addView(m(resources));
    }

    private FrameLayout o(Resources resources) {
        int i2;
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "522767053")) {
            return (FrameLayout) ipChange.ipc$dispatch("522767053", new Object[]{this, resources});
        }
        FrameLayout frameLayout = new FrameLayout(this.f);
        View.OnClickListener onClickListener = this.e;
        if (onClickListener != null) {
            frameLayout.setOnClickListener(onClickListener);
        }
        dg2 dg2 = this.b;
        int i4 = dg2.i;
        if (i4 > 0) {
            i2 = resources.getDimensionPixelSize(i4);
        } else {
            i2 = dg2.h;
        }
        dg2 dg22 = this.b;
        int i5 = dg22.k;
        if (i5 > 0) {
            i3 = resources.getDimensionPixelSize(i5);
        } else {
            i3 = dg22.j;
        }
        if (i3 == 0) {
            i3 = -1;
        }
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i3, i2));
        dg2 dg23 = this.b;
        int i6 = dg23.d;
        if (i6 != -1) {
            frameLayout.setBackgroundColor(i6);
        } else {
            frameLayout.setBackgroundColor(resources.getColor(dg23.b));
        }
        int i7 = this.b.c;
        if (i7 != 0) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeResource(resources, i7));
            if (this.b.e) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                bitmapDrawable.setTileModeXY(tileMode, tileMode);
            }
            frameLayout.setBackgroundDrawable(bitmapDrawable);
        }
        return frameLayout;
    }

    private ImageView p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "360378743")) {
            return (ImageView) ipChange.ipc$dispatch("360378743", new Object[]{this});
        }
        ImageView imageView = new ImageView(this.f);
        imageView.setId(256);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(this.b.o);
        Drawable drawable = this.b.m;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        int i2 = this.b.n;
        if (i2 != 0) {
            imageView.setImageResource(i2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private TextView q(Resources resources) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1635738390")) {
            return (TextView) ipChange.ipc$dispatch("1635738390", new Object[]{this, resources});
        }
        TextView textView = new TextView(this.f);
        textView.setId(257);
        dg2 dg2 = this.b;
        String str = dg2.x;
        if (str != null) {
            x(textView, str);
        } else {
            int i2 = dg2.y;
            if (i2 != 0) {
                x(textView, resources.getString(i2));
            } else {
                textView.setText(this.a);
            }
        }
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(this.b.l);
        dg2 dg22 = this.b;
        int i3 = dg22.g;
        if (i3 != -1) {
            textView.setTextColor(i3);
        } else {
            int i4 = dg22.f;
            if (i4 != 0) {
                textView.setTextColor(resources.getColor(i4));
            }
        }
        int i5 = this.b.p;
        if (i5 != 0) {
            textView.setTextSize(2, (float) i5);
        }
        if (this.b.q != 0) {
            r(resources, textView);
        }
        int i6 = this.b.u;
        if (i6 != 0) {
            textView.setTextAppearance(this.f, i6);
        }
        return textView;
    }

    private void r(Resources resources, TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1250256094")) {
            ipChange.ipc$dispatch("-1250256094", new Object[]{this, resources, textView});
            return;
        }
        int color = resources.getColor(this.b.q);
        dg2 dg2 = this.b;
        textView.setShadowLayer(dg2.r, dg2.t, dg2.s, color);
    }

    private boolean s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1231060796")) {
            return ((Boolean) ipChange.ipc$dispatch("-1231060796", new Object[]{this})).booleanValue();
        }
        FrameLayout frameLayout = this.h;
        return (frameLayout == null || frameLayout.getParent() == null) ? false : true;
    }

    private boolean t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "943223955")) {
            return ((Boolean) ipChange.ipc$dispatch("943223955", new Object[]{this})).booleanValue();
        }
        View view = this.d;
        return (view == null || view.getParent() == null) ? false : true;
    }

    public static hp v(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1975565958")) {
            return new hp(activity, view);
        }
        return (hp) ipChange.ipc$dispatch("-1975565958", new Object[]{activity, view});
    }

    private void w() {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2045588732")) {
            ipChange.ipc$dispatch("2045588732", new Object[]{this});
            return;
        }
        View k2 = k();
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            i2 = View.MeasureSpec.makeMeasureSpec(viewGroup.getMeasuredWidth(), Integer.MIN_VALUE);
        } else {
            i2 = View.MeasureSpec.makeMeasureSpec(this.f.getWindow().getDecorView().getMeasuredWidth(), Integer.MIN_VALUE);
        }
        k2.measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    private void x(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "682709978")) {
            ipChange.ipc$dispatch("682709978", new Object[]{this, textView, str});
        } else if (this.a != null) {
            SpannableString spannableString = new SpannableString(this.a);
            spannableString.setSpan(new hp2(textView.getContext(), str), 0, spannableString.length(), 33);
            textView.setText(spannableString);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1522359359")) {
            ipChange.ipc$dispatch("1522359359", new Object[]{this});
            return;
        }
        this.f = null;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "844128557")) {
            ipChange.ipc$dispatch("844128557", new Object[]{this});
            return;
        }
        this.k = null;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1469165758")) {
            ipChange.ipc$dispatch("-1469165758", new Object[]{this});
            return;
        }
        this.g = null;
    }

    /* access modifiers changed from: package-private */
    public Activity d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2020778844")) {
            return this.f;
        }
        return (Activity) ipChange.ipc$dispatch("-2020778844", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public zl e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1357797462")) {
            return (zl) ipChange.ipc$dispatch("1357797462", new Object[]{this});
        }
        if (this.c == null) {
            this.c = i().a;
        }
        return this.c;
    }

    public Animation f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1587690466")) {
            return (Animation) ipChange.ipc$dispatch("-1587690466", new Object[]{this});
        }
        if (this.i == null && this.f != null) {
            if (e().b > 0) {
                this.i = AnimationUtils.loadAnimation(d(), e().b);
            } else {
                w();
                this.i = g40.d(k());
            }
        }
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public LifecycleCallback g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1578736412")) {
            return this.k;
        }
        return (LifecycleCallback) ipChange.ipc$dispatch("-1578736412", new Object[]{this});
    }

    public Animation h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1173122727")) {
            return (Animation) ipChange.ipc$dispatch("-1173122727", new Object[]{this});
        }
        if (this.j == null && this.f != null) {
            if (e().c > 0) {
                this.j = AnimationUtils.loadAnimation(d(), e().c);
            } else {
                this.j = g40.e(k());
            }
        }
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public dg2 i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-388291424")) {
            return this.b;
        }
        return (dg2) ipChange.ipc$dispatch("-388291424", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public CharSequence j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1807357012")) {
            return this.a;
        }
        return (CharSequence) ipChange.ipc$dispatch("1807357012", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public View k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-176662288")) {
            return (View) ipChange.ipc$dispatch("-176662288", new Object[]{this});
        }
        View view = this.d;
        if (view != null) {
            return view;
        }
        if (this.h == null) {
            n();
        }
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public ViewGroup l() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-920527400")) {
            return this.g;
        }
        return (ViewGroup) ipChange.ipc$dispatch("-920527400", new Object[]{this});
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1395440917")) {
            return (String) ipChange.ipc$dispatch("-1395440917", new Object[]{this});
        }
        return "Crouton{text=" + ((Object) this.a) + ", style=" + this.b + ", configuration=" + this.c + ", customView=" + this.d + ", onClickListener=" + this.e + ", activity=" + this.f + ", viewGroup=" + this.g + ", croutonView=" + this.h + ", inAnimation=" + this.i + ", outAnimation=" + this.j + ", lifecycleCallback=" + this.k + '}';
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1383892206")) {
            return ((Boolean) ipChange.ipc$dispatch("-1383892206", new Object[]{this})).booleanValue();
        } else if (this.f != null) {
            return s() || t();
        } else {
            return false;
        }
    }

    public void y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1076679132")) {
            ipChange.ipc$dispatch("-1076679132", new Object[]{this});
            return;
        }
        db1.g().b(this);
    }
}
