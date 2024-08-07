package cn.damai.homepage.ui.view;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.damai.comment.util.CommentItemMoreUtil;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.coupondialog.net.CouponListResponse;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.homepage.R$style;
import cn.damai.homepage.util.window.UTHelperCallback;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.DMRatingBar;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.pictures.bricks.view.DMRatingBar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.ax0;
import tb.d20;
import tb.g91;
import tb.jk;
import tb.v50;

/* compiled from: Taobao */
public class HomepageEvaluateDialog extends Dialog implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ConstraintLayout a;
    private LinearLayout b;
    private DMPosterView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private DMRatingBar g;
    private LottieAnimationView h;
    private DMIconFontTextView i;
    private Context j;
    private CouponListResponse.ContentList k;
    private int l;
    private int m;
    private long n;
    private OnUserRejectListener o;
    private UTHelperCallback p;
    DialogInterface.OnDismissListener q;
    private DMRatingBar.OnStarChangeListener r = new b();

    /* compiled from: Taobao */
    public interface OnUserRejectListener {
        void onUserReject(CouponListResponse.ContentList contentList);
    }

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "577670093")) {
                ipChange.ipc$dispatch("577670093", new Object[]{this, dialogInterface});
                return;
            }
            g91.b("HomepageEvaluateDialog", "onDismiss");
            HomepageEvaluateDialog homepageEvaluateDialog = HomepageEvaluateDialog.this;
            homepageEvaluateDialog.l(homepageEvaluateDialog.n);
            DialogInterface.OnDismissListener onDismissListener = HomepageEvaluateDialog.this.q;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DMRatingBar.OnStarChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements Animator.AnimatorListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onAnimationCancel(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1686254220")) {
                    ipChange.ipc$dispatch("-1686254220", new Object[]{this, animator});
                }
            }

            public void onAnimationEnd(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1309114939")) {
                    ipChange.ipc$dispatch("1309114939", new Object[]{this, animator});
                    return;
                }
                HomepageEvaluateDialog.this.m();
            }

            public void onAnimationRepeat(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "627321395")) {
                    ipChange.ipc$dispatch("627321395", new Object[]{this, animator});
                }
            }

            public void onAnimationStart(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1810363180")) {
                    ipChange.ipc$dispatch("-1810363180", new Object[]{this, animator});
                }
            }
        }

        b() {
        }

        @Override // com.alibaba.pictures.bricks.view.DMRatingBar.OnStarChangeListener
        public void onEventActionUp() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-613863273")) {
                ipChange.ipc$dispatch("-613863273", new Object[]{this});
                return;
            }
            g91.b("HomepageEvaluateDialog", "mGrades=" + HomepageEvaluateDialog.this.l);
            if (HomepageEvaluateDialog.this.l == 10) {
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) HomepageEvaluateDialog.this.h.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams).height = v50.a(HomepageEvaluateDialog.this.getContext(), 80.0f);
                ((ViewGroup.MarginLayoutParams) layoutParams).width = v50.a(HomepageEvaluateDialog.this.getContext(), 310.0f);
                HomepageEvaluateDialog homepageEvaluateDialog = HomepageEvaluateDialog.this;
                homepageEvaluateDialog.r(homepageEvaluateDialog.g);
                HomepageEvaluateDialog homepageEvaluateDialog2 = HomepageEvaluateDialog.this;
                homepageEvaluateDialog2.u(homepageEvaluateDialog2.h);
                HomepageEvaluateDialog.this.h.playAnimation();
                if (Build.VERSION.SDK_INT >= 11) {
                    HomepageEvaluateDialog.this.h.addAnimatorListener(new a());
                }
            } else if (HomepageEvaluateDialog.this.l > 0) {
                HomepageEvaluateDialog.this.m();
            }
        }

        @Override // com.alibaba.pictures.bricks.view.DMRatingBar.OnStarChangeListener
        public void onStarChange(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-294225158")) {
                ipChange.ipc$dispatch("-294225158", new Object[]{this, Float.valueOf(f)});
                return;
            }
            HomepageEvaluateDialog homepageEvaluateDialog = HomepageEvaluateDialog.this;
            homepageEvaluateDialog.u(homepageEvaluateDialog.g);
            HomepageEvaluateDialog homepageEvaluateDialog2 = HomepageEvaluateDialog.this;
            homepageEvaluateDialog2.p(homepageEvaluateDialog2.h);
            HomepageEvaluateDialog.this.l = (int) (f * 2.0f);
            HomepageEvaluateDialog.this.q();
        }
    }

    public HomepageEvaluateDialog(Context context, CouponListResponse.ContentList contentList, int i2, DialogInterface.OnDismissListener onDismissListener) {
        super(context, R$style.dialog_fullscreen);
        this.j = context;
        this.k = contentList;
        this.m = i2;
        this.q = onDismissListener;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "100917891")) {
            ipChange.ipc$dispatch("100917891", new Object[]{this, Long.valueOf(j2)});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j2;
        UTHelperCallback uTHelperCallback = this.p;
        if (uTHelperCallback != null) {
            uTHelperCallback.exposureUt(currentTimeMillis);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("item_id", this.k.itemId);
        hashMap.put("target_id", this.k.targetId);
        c.e().C("evalute", "evaluate_alert", "home", "1.0", currentTimeMillis, hashMap, 2201);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1446735749")) {
            ipChange.ipc$dispatch("-1446735749", new Object[]{this});
            return;
        }
        CouponListResponse.ContentList contentList = this.k;
        String n2 = CommentItemMoreUtil.n(contentList.cityName, contentList.projectDatetime, contentList.venuesName);
        Context context = this.j;
        CouponListResponse.ContentList contentList2 = this.k;
        CommentItemMoreUtil.f(context, contentList2.targetId, contentList2.itemId, contentList2.itemName, contentList2.projectPic, contentList2.performTime, this.l, n2, "homepage", this.m);
        dismiss();
        UTHelperCallback uTHelperCallback = this.p;
        if (uTHelperCallback != null) {
            uTHelperCallback.confirmUt(String.valueOf(this.l));
            return;
        }
        c e2 = c.e();
        ax0 I = ax0.I();
        CouponListResponse.ContentList contentList3 = this.k;
        e2.x(I.H(contentList3.itemId, contentList3.targetId, String.valueOf(this.l)));
    }

    private void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1294553596")) {
            ipChange.ipc$dispatch("-1294553596", new Object[]{this});
        } else if (this.k != null) {
            this.a = (ConstraintLayout) findViewById(R$id.homepage_eva_layout);
            this.b = (LinearLayout) findViewById(R$id.homepage_evaluate_layout);
            this.c = (DMPosterView) findViewById(R$id.homepage_eva_project_image);
            this.d = (TextView) findViewById(R$id.homepage_eva_project_name);
            this.e = (TextView) findViewById(R$id.homepage_eva_desc);
            this.f = (TextView) findViewById(R$id.homepage_eva_grade_desc);
            this.g = (cn.damai.uikit.view.DMRatingBar) findViewById(R$id.homepage_eva_grade_view);
            this.h = (LottieAnimationView) findViewById(R$id.homepage_eva_full_star_lottie);
            this.i = (DMIconFontTextView) findViewById(R$id.homepage_eva_cancel);
            this.a.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.b.setOnClickListener(null);
            this.c.setOnClickListener(null);
            this.g.setOnStarChangeListener(this.r);
            setOnDismissListener(new a());
            v();
        }
    }

    private void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-571852100")) {
            ipChange.ipc$dispatch("-571852100", new Object[]{this});
            return;
        }
        OnUserRejectListener onUserRejectListener = this.o;
        if (onUserRejectListener != null) {
            onUserRejectListener.onUserReject(this.k);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void p(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "528923170")) {
            ipChange.ipc$dispatch("528923170", new Object[]{this, view});
        } else if (view.getVisibility() == 0) {
            view.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2122526485")) {
            ipChange.ipc$dispatch("-2122526485", new Object[]{this});
            return;
        }
        Context context = this.j;
        String string = context != null ? context.getString(R$string.homepage_eva_grade_tip) : "";
        int i2 = 12;
        int parseColor = Color.parseColor("#9C9CA5");
        int i3 = this.l;
        if (i3 > 0) {
            string = jk.a((float) i3);
            i2 = 18;
            parseColor = Color.parseColor("#FF993A");
        }
        this.f.setTextColor(parseColor);
        this.f.setTextSize(1, (float) i2);
        this.f.setText(string);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void r(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1754249060")) {
            ipChange.ipc$dispatch("1754249060", new Object[]{this, view});
        } else if (view.getVisibility() == 0 || view.getVisibility() == 8) {
            view.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void u(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2041144087")) {
            ipChange.ipc$dispatch("-2041144087", new Object[]{this, view});
        } else if (view.getVisibility() == 8 || view.getVisibility() == 4) {
            view.setVisibility(0);
        }
    }

    private void v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494206470")) {
            ipChange.ipc$dispatch("1494206470", new Object[]{this});
            return;
        }
        if (!TextUtils.isEmpty(this.k.itemName)) {
            this.d.setText(this.k.itemName);
        }
        this.c.setPlaceholder(R$drawable.uikit_default_image_bg_gradient);
        this.c.setImageUrl(this.k.projectPic);
        if (!TextUtils.isEmpty(this.k.desText)) {
            this.e.setText(this.k.desText);
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "226221802")) {
            ipChange.ipc$dispatch("226221802", new Object[]{this, view});
        } else if (view.getId() == R$id.homepage_eva_cancel || view.getId() == R$id.homepage_eva_layout) {
            this.h.cancelAnimation();
            dismiss();
            o();
            UTHelperCallback uTHelperCallback = this.p;
            if (uTHelperCallback != null) {
                uTHelperCallback.closeUt();
                return;
            }
            c e2 = c.e();
            ax0 I = ax0.I();
            CouponListResponse.ContentList contentList = this.k;
            e2.x(I.G(contentList.itemId, contentList.targetId));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-654300234")) {
            ipChange.ipc$dispatch("-654300234", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawableResource(17170445);
        setContentView(R$layout.homepage_to_evaluate_layout);
        n();
        this.n = System.currentTimeMillis();
    }

    public void s(OnUserRejectListener onUserRejectListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337280717")) {
            ipChange.ipc$dispatch("-1337280717", new Object[]{this, onUserRejectListener});
            return;
        }
        this.o = onUserRejectListener;
    }

    public void t(UTHelperCallback uTHelperCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "178634483")) {
            ipChange.ipc$dispatch("178634483", new Object[]{this, uTHelperCallback});
            return;
        }
        this.p = uTHelperCallback;
    }
}
