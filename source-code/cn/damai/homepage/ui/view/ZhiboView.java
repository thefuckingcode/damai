package cn.damai.homepage.ui.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.homepage.MainActivity;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$raw;
import cn.damai.homepage.bean.HomeZhibotiaoBean;
import cn.damai.homepage.ui.fragment.HomeFragmentAgent;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ax0;
import tb.n42;
import tb.v50;

/* compiled from: Taobao */
public class ZhiboView {
    private static transient /* synthetic */ IpChange $ipChange;
    private MainActivity a;
    private View b;
    private View c;
    private TextView d;
    private LottieAnimationView e;
    private LottieAnimationView f;
    private ImageView g;
    private HomeZhibotiaoBean h;
    private HomeFragmentAgent i;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2100479635")) {
                ipChange.ipc$dispatch("2100479635", new Object[]{this, view});
                return;
            }
            ZhiboView.this.b.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-83197292")) {
                ipChange.ipc$dispatch("-83197292", new Object[]{this, view});
            } else if (ZhiboView.this.h != null && !TextUtils.isEmpty(ZhiboView.this.h.schema)) {
                cn.damai.common.user.c.e().x(ax0.I().S(ZhiboView.this.h.itemId));
                DMNav.from(ZhiboView.this.a).toUri(ZhiboView.this.h.schema);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-8180963")) {
                ipChange.ipc$dispatch("-8180963", new Object[]{this, valueAnimator});
                return;
            }
            ZhiboView.this.b.setTranslationX((float) ((n42.a(ZhiboView.this.a, 254.0f) * ((Integer) valueAnimator.getAnimatedValue()).intValue()) / 100));
        }
    }

    public ZhiboView(MainActivity mainActivity, View view) {
        this.a = mainActivity;
        this.b = view;
        view.setVisibility(8);
        View findViewById = view.findViewById(R$id.layout_close);
        this.c = findViewById;
        findViewById.setOnClickListener(new a());
        this.g = (ImageView) view.findViewById(R$id.image_head);
        this.e = (LottieAnimationView) view.findViewById(R$id.view_bolang);
        this.f = (LottieAnimationView) view.findViewById(R$id.view_liwu);
        try {
            this.e.setAnimation(R$raw.lottie_live_sound_wave);
        } catch (Exception unused) {
        }
        this.d = (TextView) view.findViewById(R$id.tv_zhibo);
        this.b.setOnClickListener(new b());
    }

    public boolean e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "684122936")) {
            return this.h != null;
        }
        return ((Boolean) ipChange.ipc$dispatch("684122936", new Object[]{this})).booleanValue();
    }

    public void f(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "966299710")) {
            ipChange.ipc$dispatch("966299710", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.b.setVisibility(i2);
    }

    @SuppressLint({"NewApi"})
    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1551590014")) {
            ipChange.ipc$dispatch("1551590014", new Object[]{this});
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
        ofInt.setDuration(400L);
        ofInt.addUpdateListener(new c());
        ofInt.start();
    }

    @SuppressLint({"NewApi"})
    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "866360471")) {
            ipChange.ipc$dispatch("866360471", new Object[]{this});
            return;
        }
        final TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) n42.a(this.a, 69.0f), 0.0f);
        translateAnimation.setDuration(400);
        translateAnimation.setFillAfter(false);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class cn.damai.homepage.ui.view.ZhiboView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onAnimationEnd(Animation animation) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1847054446")) {
                    ipChange.ipc$dispatch("1847054446", new Object[]{this, animation});
                } else if (ZhiboView.this.a != null && !ZhiboView.this.a.isFinishing()) {
                    ZhiboView.this.b.postDelayed(new Runnable() {
                        /* class cn.damai.homepage.ui.view.ZhiboView.AnonymousClass3.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1422771598")) {
                                ipChange.ipc$dispatch("1422771598", new Object[]{this});
                            } else if (ZhiboView.this.a != null && !ZhiboView.this.a.isFinishing()) {
                                ZhiboView.this.g();
                            }
                        }
                    }, 10000);
                }
            }

            public void onAnimationRepeat(Animation animation) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2034601914")) {
                    ipChange.ipc$dispatch("-2034601914", new Object[]{this, animation});
                }
            }

            public void onAnimationStart(Animation animation) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-306970553")) {
                    ipChange.ipc$dispatch("-306970553", new Object[]{this, animation});
                } else if (ZhiboView.this.i == null || ZhiboView.this.i.getCurIndex() != 0) {
                    translateAnimation.cancel();
                } else {
                    ZhiboView.this.b.setVisibility(0);
                }
            }
        });
        this.b.setAnimation(translateAnimation);
        translateAnimation.start();
    }

    @SuppressLint({"NewApi"})
    public void i(HomeZhibotiaoBean homeZhibotiaoBean, HomeFragmentAgent homeFragmentAgent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "170528002")) {
            ipChange.ipc$dispatch("170528002", new Object[]{this, homeZhibotiaoBean, homeFragmentAgent});
            return;
        }
        this.i = homeFragmentAgent;
        MainActivity mainActivity = this.a;
        if (mainActivity != null && !mainActivity.isFinishing()) {
            this.h = homeZhibotiaoBean;
            if (homeZhibotiaoBean == null) {
                this.b.setVisibility(8);
                return;
            }
            try {
                this.f.setAnimation(R$raw.lottie_liwu);
            } catch (Exception unused) {
            }
            ax0.I().b0(this.b, this.h.itemId);
            if (!TextUtils.isEmpty(homeZhibotiaoBean.artistHeadPic)) {
                cn.damai.common.image.a.b().f(homeZhibotiaoBean.artistHeadPic, v50.a(this.a, 28.0f), v50.a(this.a, 28.0f)).c(R$drawable.homepage_zhibo_head_bg_default).g(this.g);
            }
            if (!TextUtils.isEmpty(homeZhibotiaoBean.itemName)) {
                this.d.setText(homeZhibotiaoBean.itemName);
            }
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(8);
                this.b.setTranslationX(0.0f);
                this.e.playAnimation();
                this.f.playAnimation();
                HomeFragmentAgent homeFragmentAgent2 = this.i;
                if (homeFragmentAgent2 != null && homeFragmentAgent2.getCurIndex() == 0) {
                    h();
                }
            }
        }
    }
}
