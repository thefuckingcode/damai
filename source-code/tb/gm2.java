package tb;

import android.animation.Animator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import cn.damai.uikit.calendar.CalendarDay;
import cn.damai.uikit.calendar.format.TitleFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class gm2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DEFAULT_ANIMATION_DELAY = 400;
    public static final int DEFAULT_Y_TRANSLATION_DP = 20;
    private final TextView a;
    private TitleFormatter b;
    private final int c;
    private final int d;
    private final int e;
    private final Interpolator f = new DecelerateInterpolator(2.0f);
    private int g = 0;
    private long h = 0;
    private CalendarDay i = null;

    /* compiled from: Taobao */
    public class a extends v5 {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CharSequence a;
        final /* synthetic */ int b;

        a(CharSequence charSequence, int i) {
            this.a = charSequence;
            this.b = i;
        }

        @Override // tb.v5
        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "612232179")) {
                ipChange.ipc$dispatch("612232179", new Object[]{this, animator});
                return;
            }
            gm2 gm2 = gm2.this;
            gm2.h(gm2.a, 0);
            gm2.this.a.setAlpha(1.0f);
        }

        @Override // tb.v5
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1553271836")) {
                ipChange.ipc$dispatch("1553271836", new Object[]{this, animator});
                return;
            }
            gm2.this.a.setText(this.a);
            gm2 gm2 = gm2.this;
            gm2.h(gm2.a, this.b);
            ViewPropertyAnimator animate = gm2.this.a.animate();
            if (gm2.this.g == 1) {
                animate.translationX(0.0f);
            } else {
                animate.translationY(0.0f);
            }
            animate.alpha(1.0f).setDuration((long) gm2.this.d).setInterpolator(gm2.this.f).setListener(new v5()).start();
        }
    }

    public gm2(TextView textView) {
        this.a = textView;
        Resources resources = textView.getResources();
        this.c = 400;
        this.d = resources.getInteger(17694720) / 2;
        this.e = (int) TypedValue.applyDimension(1, 20.0f, resources.getDisplayMetrics());
    }

    private void g(long j, CalendarDay calendarDay, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-69818881")) {
            ipChange.ipc$dispatch("-69818881", new Object[]{this, Long.valueOf(j), calendarDay, Boolean.valueOf(z)});
            return;
        }
        this.a.animate().cancel();
        h(this.a, 0);
        this.a.setAlpha(1.0f);
        this.h = j;
        CharSequence format = this.b.format(calendarDay);
        if (!z) {
            this.a.setText(format);
        } else {
            int i2 = this.e * (this.i.isBefore(calendarDay) ? 1 : -1);
            ViewPropertyAnimator animate = this.a.animate();
            if (this.g == 1) {
                animate.translationX((float) (i2 * -1));
            } else {
                animate.translationY((float) (i2 * -1));
            }
            animate.alpha(0.0f).setDuration((long) this.d).setInterpolator(this.f).setListener(new a(format, i2)).start();
        }
        this.i = calendarDay;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h(TextView textView, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1124646469")) {
            ipChange.ipc$dispatch("-1124646469", new Object[]{this, textView, Integer.valueOf(i2)});
        } else if (this.g == 1) {
            textView.setTranslationX((float) i2);
        } else {
            textView.setTranslationY((float) i2);
        }
    }

    public void f(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304945516")) {
            ipChange.ipc$dispatch("-304945516", new Object[]{this, calendarDay});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (calendarDay != null) {
            if (TextUtils.isEmpty(this.a.getText()) || currentTimeMillis - this.h < ((long) this.c)) {
                g(currentTimeMillis, calendarDay, false);
            }
            if (calendarDay.equals(this.i)) {
                return;
            }
            if (calendarDay.getMonth() != this.i.getMonth() || calendarDay.getYear() != this.i.getYear()) {
                g(currentTimeMillis, calendarDay, true);
            }
        }
    }

    public int i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1004660927")) {
            return this.g;
        }
        return ((Integer) ipChange.ipc$dispatch("-1004660927", new Object[]{this})).intValue();
    }

    public void j(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-159654167")) {
            ipChange.ipc$dispatch("-159654167", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.g = i2;
    }

    public void k(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4474837")) {
            ipChange.ipc$dispatch("-4474837", new Object[]{this, calendarDay});
            return;
        }
        this.i = calendarDay;
    }

    public void l(TitleFormatter titleFormatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1462180078")) {
            ipChange.ipc$dispatch("-1462180078", new Object[]{this, titleFormatter});
            return;
        }
        this.b = titleFormatter;
    }
}
