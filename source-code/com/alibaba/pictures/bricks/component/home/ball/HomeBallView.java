package com.alibaba.pictures.bricks.component.home.ball;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.HomeBallBean;
import com.alibaba.pictures.bricks.component.home.ball.HomeBallContract;
import com.alibaba.pictures.bricks.view.BrickRotateAnim;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.kv0;
import tb.lv0;
import tb.mv0;
import tb.u50;
import tb.v;

/* compiled from: Taobao */
public final class HomeBallView extends AbsView<GenericItem<ItemValue>, HomeBallModel, HomeBallPresent> implements HomeBallContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final long bgDuration = 600;
    @Nullable
    private Handler handler;
    private final ImageView icon;
    private boolean isChange;
    @NotNull
    private final View itemView;
    private final LinearLayout llLabel;
    private int num;
    private int pos;
    private final FrameLayout rlLabel;
    @Nullable
    private BrickRotateAnim rotateAnim;
    private final long textDuration = 300;
    private final TextView title;
    private final TextView tvLabel;

    /* compiled from: Taobao */
    public static final class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HomeBallView a;
        final /* synthetic */ HomeBallBean b;

        a(HomeBallView homeBallView, HomeBallBean homeBallBean) {
            this.a = homeBallView;
            this.b = homeBallBean;
        }

        public void onViewAttachedToWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-493995464")) {
                ipChange.ipc$dispatch("-493995464", new Object[]{this, view});
                return;
            }
            k21.i(view, "v");
            System.out.println((Object) "onAnimationEnd  onViewAttachedToWindow");
            if (this.a.llLabel != null && this.a.llLabel.getVisibility() == 0 && this.a.getNum() == 2 && k21.d(this.a.llLabel.getTag(), "clearAnim")) {
                if (this.a.rlLabel.getAnimation() == null || this.a.tvLabel.getAnimation() == null) {
                    System.out.println((Object) ("onAnimationEnd 动画展示屏幕了 " + this.b.icon1 + this.b.icon2));
                    this.a.rlBgAnim(this.b);
                    this.a.llLabel.setTag("nextclearAnim");
                }
            }
        }

        public void onViewDetachedFromWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2135232693")) {
                ipChange.ipc$dispatch("2135232693", new Object[]{this, view});
                return;
            }
            k21.i(view, "v");
            System.out.println((Object) "onAnimationEnd  onViewDetachedFromWindow");
            if (this.a.llLabel == null || this.a.llLabel.getVisibility() != 0 || this.a.getNum() != 2 || !k21.d(this.a.llLabel.getTag(), "nextclearAnim")) {
                System.out.println((Object) ("onAnimationEnd 动画离开屏幕->不清除动画  " + this.b.icon1 + this.b.icon2));
                this.a.llLabel.setTag("nextclearAnim");
                return;
            }
            System.out.println((Object) ("onAnimationEnd 动画离开屏幕->清除  " + this.b.icon1 + this.b.icon2));
            this.a.resetAnim();
            this.a.llLabel.setTag("clearAnim");
        }
    }

    /* compiled from: Taobao */
    public static final class b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HomeBallView a;
        final /* synthetic */ HomeBallBean b;

        b(HomeBallView homeBallView, HomeBallBean homeBallBean) {
            this.a = homeBallView;
            this.b = homeBallBean;
        }

        /* access modifiers changed from: private */
        public static final void b(HomeBallView homeBallView, HomeBallBean homeBallBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "771825765")) {
                ipChange.ipc$dispatch("771825765", new Object[]{homeBallView, homeBallBean});
                return;
            }
            k21.i(homeBallView, "this$0");
            k21.i(homeBallBean, "$bean");
            if (homeBallView.getNum() == 2 && homeBallView.llLabel.getVisibility() == 0) {
                System.out.println((Object) "onAnimationEnd 动画复用");
                homeBallView.rlBgAnim(homeBallBean);
            }
        }

        public void onAnimationEnd(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1179353020")) {
                ipChange.ipc$dispatch("1179353020", new Object[]{this, animation});
                return;
            }
            k21.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
            System.out.println((Object) "onAnimationEnd 动画复用记录ddddddddd");
            if (this.a.handler == null) {
                this.a.handler = new Handler();
            }
            Handler handler = this.a.handler;
            if (handler != null) {
                handler.postDelayed(new mv0(this.a, this.b), 2000);
            }
        }

        public void onAnimationRepeat(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "760731192")) {
                ipChange.ipc$dispatch("760731192", new Object[]{this, animation});
                return;
            }
            k21.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
        }

        public void onAnimationStart(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2017913835")) {
                ipChange.ipc$dispatch("-2017913835", new Object[]{this, animation});
                return;
            }
            k21.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
            this.a.setChange(true);
            HomeBallView homeBallView = this.a;
            homeBallView.setPos((homeBallView.getPos() + 1) % 2);
            System.out.println((Object) ("onAnimationEnd 开始文字缩小 text = " + ((Object) this.a.tvLabel.getText())));
            this.a.tvScaleAnim(1.0f, 0.2f, 1.0f, 0.2f, this.b);
        }
    }

    /* compiled from: Taobao */
    public static final class c implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HomeBallView a;
        final /* synthetic */ HomeBallBean b;

        c(HomeBallView homeBallView, HomeBallBean homeBallBean) {
            this.a = homeBallView;
            this.b = homeBallBean;
        }

        public void onAnimationEnd(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1050799910")) {
                ipChange.ipc$dispatch("-1050799910", new Object[]{this, animation});
                return;
            }
            k21.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
            String str = this.a.isChange() ? "需要执行动画" : "不需要执行动画";
            System.out.println((Object) ("onAnimationEnd 开始文字onAnimationEnd  " + str));
            if (this.a.isChange()) {
                this.a.setChange(false);
                this.a.tvLabelContent(this.b);
                System.out.println((Object) ("onAnimationEnd 开始文字放大 text = " + ((Object) this.a.tvLabel.getText())));
                this.a.tvScaleAnim(0.2f, 1.0f, 0.2f, 1.0f, this.b);
            }
        }

        public void onAnimationRepeat(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1123895386")) {
                ipChange.ipc$dispatch("1123895386", new Object[]{this, animation});
                return;
            }
            k21.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
        }

        public void onAnimationStart(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2006198861")) {
                ipChange.ipc$dispatch("-2006198861", new Object[]{this, animation});
                return;
            }
            k21.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeBallView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        this.title = (TextView) view.findViewById(R$id.bricks_ball_name);
        this.icon = (ImageView) view.findViewById(R$id.bricks_ball_icon);
        this.llLabel = (LinearLayout) view.findViewById(R$id.bricks_ball_label_layout);
        this.rlLabel = (FrameLayout) view.findViewById(R$id.bricks_ball_rl_label);
        this.tvLabel = (TextView) view.findViewById(R$id.bricks_ball_label);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-0  reason: not valid java name */
    public static final void m115bindView$lambda0(HomeBallView homeBallView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059541918")) {
            ipChange.ipc$dispatch("1059541918", new Object[]{homeBallView, successEvent});
            return;
        }
        k21.i(homeBallView, "this$0");
        Drawable drawable = successEvent.drawable;
        if (drawable == null) {
            homeBallView.icon.setImageResource(R$drawable.bricks_home_ball_icon);
        } else {
            homeBallView.icon.setImageDrawable(drawable);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-1  reason: not valid java name */
    public static final void m116bindView$lambda1(HomeBallView homeBallView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-642026304")) {
            ipChange.ipc$dispatch("-642026304", new Object[]{homeBallView, failEvent});
            return;
        }
        k21.i(homeBallView, "this$0");
        homeBallView.icon.setImageResource(R$drawable.bricks_home_ball_icon);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void resetAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-844211780")) {
            ipChange.ipc$dispatch("-844211780", new Object[]{this});
            return;
        }
        if (this.handler != null) {
            System.out.println((Object) "onAnimationEnd  初始化已经设置的");
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            this.handler = null;
        }
        this.rlLabel.clearAnimation();
        this.tvLabel.clearAnimation();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void rlBgAnim(HomeBallBean homeBallBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1716773990")) {
            ipChange.ipc$dispatch("-1716773990", new Object[]{this, homeBallBean});
            return;
        }
        BrickRotateAnim brickRotateAnim = this.rotateAnim;
        if (brickRotateAnim != null) {
            brickRotateAnim.setDuration(this.bgDuration);
            brickRotateAnim.setRepeatCount(0);
            brickRotateAnim.setAnimationListener(new b(this, homeBallBean));
            brickRotateAnim.setInterpolator(new LinearInterpolator());
            this.rlLabel.startAnimation(brickRotateAnim);
        }
    }

    private final void setLabelWidth(String str, String str2) {
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047169436")) {
            ipChange.ipc$dispatch("1047169436", new Object[]{this, str, str2});
            return;
        }
        if (str.length() > str2.length()) {
            f = this.tvLabel.getPaint().measureText(str);
        } else {
            f = this.tvLabel.getPaint().measureText(str2);
        }
        setParamWidth((int) f);
    }

    private final void setParamWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-441668094")) {
            ipChange.ipc$dispatch("-441668094", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        u50 u50 = u50.INSTANCE;
        Context context = this.itemView.getContext();
        k21.h(context, "itemView.context");
        int b2 = i + u50.b(context, 11);
        Context context2 = this.itemView.getContext();
        k21.h(context2, "itemView.context");
        int b3 = u50.b(context2, 52);
        ViewGroup.LayoutParams layoutParams = this.tvLabel.getLayoutParams();
        if (b2 >= b3) {
            b2 = b3;
        }
        layoutParams.width = b2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void tvLabelContent(HomeBallBean homeBallBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123977135")) {
            ipChange.ipc$dispatch("-123977135", new Object[]{this, homeBallBean});
        } else if (this.pos == 0) {
            this.tvLabel.setText(homeBallBean.icon1);
        } else {
            this.tvLabel.setText(homeBallBean.icon2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void tvScaleAnim(float f, float f2, float f3, float f4, HomeBallBean homeBallBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "921260725")) {
            ipChange.ipc$dispatch("921260725", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), homeBallBean});
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f3, f4, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatCount(0);
        scaleAnimation.setDuration(this.textDuration);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new c(this, homeBallBean));
        this.tvLabel.startAnimation(scaleAnimation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0134 A[Catch:{ Exception -> 0x015b }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    @Override // com.alibaba.pictures.bricks.component.home.ball.HomeBallContract.View
    public void bindView(@NotNull HomeBallBean homeBallBean) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1637906636")) {
            ipChange.ipc$dispatch("1637906636", new Object[]{this, homeBallBean});
            return;
        }
        k21.i(homeBallBean, "bean");
        this.title.setText(homeBallBean.title);
        String str = homeBallBean.pic;
        u50 u50 = u50.INSTANCE;
        Context context = this.itemView.getContext();
        k21.h(context, "itemView.context");
        int b2 = u50.b(context, 40);
        Context context2 = this.itemView.getContext();
        k21.h(context2, "itemView.context");
        String c2 = com.alibaba.pictures.bricks.util.a.c(str, b2, u50.b(context2, 40));
        k21.h(c2, "getImageUrl(\n           …px(itemView.context, 40))");
        ImageLoaderProviderProxy.getProxy().load(c2, new lv0(this), new kv0(this));
        resetAnim();
        String str2 = homeBallBean.icon1;
        if (str2 == null || (o.y(str2))) {
            String str3 = homeBallBean.icon2;
            if (str3 == null || (o.y(str3))) {
                this.llLabel.setVisibility(8);
                if (Build.VERSION.SDK_INT < 12) {
                    if (this.itemView.getTag() != null) {
                        View view = this.itemView;
                        Object tag = view.getTag();
                        k21.g(tag, "null cannot be cast to non-null type android.view.View.OnAttachStateChangeListener");
                        view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) tag);
                    }
                    a aVar = new a(this, homeBallBean);
                    this.itemView.addOnAttachStateChangeListener(aVar);
                    this.itemView.setTag(aVar);
                    return;
                }
                return;
            }
        }
        this.llLabel.setVisibility(0);
        String str4 = homeBallBean.icon1;
        if (!(str4 == null || (o.y(str4)))) {
            String str5 = homeBallBean.icon2;
            if (str5 == null || (o.y(str5))) {
                setParamWidth((int) this.tvLabel.getPaint().measureText(homeBallBean.icon1));
                this.tvLabel.setText(homeBallBean.icon1);
                if (Build.VERSION.SDK_INT < 12) {
                }
            }
        }
        String str6 = homeBallBean.icon1;
        if (str6 == null || (o.y(str6))) {
            String str7 = homeBallBean.icon2;
            if (str7 != null && !(o.y(str7))) {
                z = false;
            }
            if (!z) {
                setParamWidth((int) this.tvLabel.getPaint().measureText(homeBallBean.icon2));
                this.tvLabel.setText(homeBallBean.icon2);
                if (Build.VERSION.SDK_INT < 12) {
                }
            }
        }
        this.num = 2;
        BrickRotateAnim brickRotateAnim = new BrickRotateAnim();
        this.rotateAnim = brickRotateAnim;
        brickRotateAnim.setDegrees(3.0f);
        String str8 = homeBallBean.icon1;
        k21.h(str8, "bean.icon1");
        String str9 = homeBallBean.icon2;
        k21.h(str9, "bean.icon2");
        setLabelWidth(str8, str9);
        this.tvLabel.setText(homeBallBean.icon1);
        System.out.println((Object) "onAnimationEnd  初始化设置");
        rlBgAnim(homeBallBean);
        try {
            if (Build.VERSION.SDK_INT < 12) {
            }
        } catch (Exception unused) {
        }
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-941281232")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("-941281232", new Object[]{this});
    }

    public final int getNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1237825487")) {
            return this.num;
        }
        return ((Integer) ipChange.ipc$dispatch("-1237825487", new Object[]{this})).intValue();
    }

    public final int getPos() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1185929565")) {
            return this.pos;
        }
        return ((Integer) ipChange.ipc$dispatch("-1185929565", new Object[]{this})).intValue();
    }

    @Nullable
    public final BrickRotateAnim getRotateAnim() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-543548892")) {
            return this.rotateAnim;
        }
        return (BrickRotateAnim) ipChange.ipc$dispatch("-543548892", new Object[]{this});
    }

    public final boolean isChange() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1641761640")) {
            return this.isChange;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1641761640", new Object[]{this})).booleanValue();
    }

    public final void setChange(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-19251638")) {
            ipChange.ipc$dispatch("-19251638", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isChange = z;
    }

    public final void setNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076016647")) {
            ipChange.ipc$dispatch("-2076016647", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.num = i;
    }

    public final void setPos(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-467243065")) {
            ipChange.ipc$dispatch("-467243065", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.pos = i;
    }

    public final void setRotateAnim(@Nullable BrickRotateAnim brickRotateAnim) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-394829450")) {
            ipChange.ipc$dispatch("-394829450", new Object[]{this, brickRotateAnim});
            return;
        }
        this.rotateAnim = brickRotateAnim;
    }
}
