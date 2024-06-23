package com.alibaba.pictures.bricks.component.scriptmurder;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.OrderItem;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.alient.onearch.adapter.component.banner.base.BaseBannerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.view.IContract;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.v00;

/* compiled from: Taobao */
public final class GenericBannerViewExt extends BaseBannerView {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private AlphaAnimation dismisAni = new AlphaAnimation(1.0f, 0.0f);
    private int index;
    private boolean playFinished;
    @NotNull
    private AlphaAnimation showAni = new AlphaAnimation(0.0f, 1.0f);
    public View titlell;
    @NotNull
    private final View view;

    /* compiled from: Taobao */
    public static final class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ GenericBannerViewExt a;

        a(GenericBannerViewExt genericBannerViewExt) {
            this.a = genericBannerViewExt;
        }

        public void onViewAttachedToWindow(@Nullable View view) {
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-768843699")) {
                ipChange.ipc$dispatch("-768843699", new Object[]{this, view});
                return;
            }
            IContract.Presenter presenter = this.a.getPresenter();
            k21.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerPresenterExt");
            ((GenericBannerPresenterExt) presenter).disPatch(GenericBannerPresenterExt.MSG_BANNER_ATTACHED);
            if (!this.a.getPlayFinished() && this.a.getIndex() != 0) {
                this.a.getTitlell().setVisibility(0);
                this.a.getShowAni().reset();
                GenericBannerViewExt genericBannerViewExt = this.a;
                if (genericBannerViewExt.getIndex() - 1 >= 0) {
                    i = this.a.getIndex();
                } else {
                    GenericBannerViewExt genericBannerViewExt2 = this.a;
                    int index = genericBannerViewExt2.getIndex();
                    genericBannerViewExt2.setIndex(index - 1);
                    i = index;
                }
                genericBannerViewExt.setIndex(i);
                View titlell = this.a.getTitlell();
                if (titlell != null) {
                    titlell.startAnimation(this.a.getShowAni());
                }
            }
        }

        public void onViewDetachedFromWindow(@Nullable View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-916086")) {
                ipChange.ipc$dispatch("-916086", new Object[]{this, view});
                return;
            }
            IContract.Presenter presenter = this.a.getPresenter();
            k21.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerPresenterExt");
            ((GenericBannerPresenterExt) presenter).disPatch(GenericBannerPresenterExt.MSG_BANNER_DETACHED);
            AlphaAnimation showAni = this.a.getShowAni();
            if (showAni != null) {
                showAni.cancel();
            }
            AlphaAnimation dismisAni = this.a.getDismisAni();
            if (dismisAni != null) {
                dismisAni.cancel();
            }
            this.a.getTitlell().setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public static final class b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ GenericBannerViewExt a;
        final /* synthetic */ Ref$ObjectRef<ArrayList<OrderItem>> b;

        b(GenericBannerViewExt genericBannerViewExt, Ref$ObjectRef<ArrayList<OrderItem>> ref$ObjectRef) {
            this.a = genericBannerViewExt;
            this.b = ref$ObjectRef;
        }

        public void onAnimationEnd(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "240022199")) {
                ipChange.ipc$dispatch("240022199", new Object[]{this, animation});
                return;
            }
            this.a.getTitlell().setVisibility(8);
            if (this.a.getIndex() >= this.b.element.size()) {
                this.a.setPlayFinished(true);
            } else {
                this.a.getTitlell().startAnimation(this.a.getShowAni());
            }
        }

        public void onAnimationRepeat(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1131823779")) {
                ipChange.ipc$dispatch("-1131823779", new Object[]{this, animation});
            }
        }

        public void onAnimationStart(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1523266640")) {
                ipChange.ipc$dispatch("1523266640", new Object[]{this, animation});
            }
        }
    }

    /* compiled from: Taobao */
    public static final class c implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ GenericBannerViewExt a;
        final /* synthetic */ Ref$ObjectRef<ArrayList<OrderItem>> b;

        c(GenericBannerViewExt genericBannerViewExt, Ref$ObjectRef<ArrayList<OrderItem>> ref$ObjectRef) {
            this.a = genericBannerViewExt;
            this.b = ref$ObjectRef;
        }

        public void onAnimationEnd(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "933414904")) {
                ipChange.ipc$dispatch("933414904", new Object[]{this, animation});
                return;
            }
            this.a.getTitlell().setVisibility(8);
            if (this.a.getIndex() <= this.b.element.size()) {
                this.a.getTitlell().startAnimation(this.a.getDismisAni());
            }
        }

        public void onAnimationRepeat(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1232524412")) {
                ipChange.ipc$dispatch("1232524412", new Object[]{this, animation});
            }
        }

        public void onAnimationStart(@Nullable Animation animation) {
            OrderItem orderItem;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2141242031")) {
                ipChange.ipc$dispatch("-2141242031", new Object[]{this, animation});
            } else if (this.a.getIndex() < this.b.element.size()) {
                this.a.getTitlell().setVisibility(0);
                View titlell = this.a.getTitlell();
                Ref$ObjectRef<ArrayList<OrderItem>> ref$ObjectRef = this.b;
                GenericBannerViewExt genericBannerViewExt = this.a;
                T t = ref$ObjectRef.element;
                T t2 = t;
                if (!((t2.isEmpty() ^ true) && t2.size() > genericBannerViewExt.getIndex())) {
                    t = null;
                }
                T t3 = t;
                if (!(t3 == null || (orderItem = (OrderItem) t3.get(genericBannerViewExt.getIndex())) == null)) {
                    titlell.setVisibility(0);
                    TextView textView = (TextView) titlell.findViewById(R$id.common_navbar_info_title);
                    if (textView != null) {
                        textView.setText(orderItem.getNickName() + ' ' + orderItem.getText());
                    }
                    TextView textView2 = (TextView) titlell.findViewById(R$id.common_navbar_info_desc);
                    if (textView2 != null) {
                        textView2.setText(orderItem.getTime());
                    }
                }
                GenericBannerViewExt genericBannerViewExt2 = this.a;
                genericBannerViewExt2.setIndex(genericBannerViewExt2.getIndex() + 1);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericBannerViewExt(@NotNull View view2) {
        super(view2);
        k21.i(view2, "view");
        this.view = view2;
    }

    @NotNull
    public final AlphaAnimation getDismisAni() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1278916118")) {
            return this.dismisAni;
        }
        return (AlphaAnimation) ipChange.ipc$dispatch("1278916118", new Object[]{this});
    }

    public final int getIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-806591180")) {
            return this.index;
        }
        return ((Integer) ipChange.ipc$dispatch("-806591180", new Object[]{this})).intValue();
    }

    public final boolean getPlayFinished() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2111148117")) {
            return this.playFinished;
        }
        return ((Boolean) ipChange.ipc$dispatch("2111148117", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    @NotNull
    public RecyclerView getRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1093361210")) {
            return (RecyclerView) ipChange.ipc$dispatch("1093361210", new Object[]{this});
        }
        View findViewById = this.view.findViewById(R$id.common_top_banner_container);
        k21.g(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        return (RecyclerView) findViewById;
    }

    @NotNull
    public final AlphaAnimation getShowAni() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1525857398")) {
            return this.showAni;
        }
        return (AlphaAnimation) ipChange.ipc$dispatch("-1525857398", new Object[]{this});
    }

    @NotNull
    public final View getTitlell() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-299557251")) {
            return (View) ipChange.ipc$dispatch("-299557251", new Object[]{this});
        }
        View view2 = this.titlell;
        if (view2 != null) {
            return view2;
        }
        k21.A("titlell");
        return null;
    }

    @NotNull
    public final View getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1159621332")) {
            return this.view;
        }
        return (View) ipChange.ipc$dispatch("1159621332", new Object[]{this});
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerView, com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    public void initRecyclerSettings(@Nullable RecyclerView.RecycledViewPool recycledViewPool, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1109084439")) {
            ipChange.ipc$dispatch("1109084439", new Object[]{this, recycledViewPool, map});
            return;
        }
        super.initRecyclerSettings(recycledViewPool, map);
        ((RelativeLayout) this.view.findViewById(R$id.common_top_banner_bottombg)).setBackground(new ColorDrawable(Color.parseColor("#825542")));
        View findViewById = this.view.findViewById(R$id.common_navbar_infoll);
        k21.h(findViewById, "view.findViewById<View>(R.id.common_navbar_infoll)");
        setTitlell(findViewById);
        this.view.addOnAttachStateChangeListener(new a(this));
    }

    public final void setBgColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "285548578")) {
            ipChange.ipc$dispatch("285548578", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ((RelativeLayout) this.view.findViewById(R$id.common_top_banner_bottombg)).setBackgroundColor(i);
    }

    public final void setDismisAni(@NotNull AlphaAnimation alphaAnimation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "631149274")) {
            ipChange.ipc$dispatch("631149274", new Object[]{this, alphaAnimation});
            return;
        }
        k21.i(alphaAnimation, "<set-?>");
        this.dismisAni = alphaAnimation;
    }

    public final void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1980467626")) {
            ipChange.ipc$dispatch("-1980467626", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.index = i;
    }

    public final void setPlayFinished(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-522600017")) {
            ipChange.ipc$dispatch("-522600017", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.playFinished = z;
    }

    public final void setShowAni(@NotNull AlphaAnimation alphaAnimation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738524954")) {
            ipChange.ipc$dispatch("-738524954", new Object[]{this, alphaAnimation});
            return;
        }
        k21.i(alphaAnimation, "<set-?>");
        this.showAni = alphaAnimation;
    }

    public final void setTitlell(@NotNull View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154746261")) {
            ipChange.ipc$dispatch("-1154746261", new Object[]{this, view2});
            return;
        }
        k21.i(view2, "<set-?>");
        this.titlell = view2;
    }

    public final void showOrderTitle(@NotNull ShopInfoBean shopInfoBean) {
        OrderItem orderItem;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-995601380")) {
            ipChange.ipc$dispatch("-995601380", new Object[]{this, shopInfoBean});
            return;
        }
        k21.i(shopInfoBean, "shopInfo");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        T t = (T) shopInfoBean.getOrders();
        ref$ObjectRef.element = t;
        this.index = 0;
        T t2 = null;
        if (t == null || t.size() == 0) {
            this.showAni.setAnimationListener(null);
            this.dismisAni.setAnimationListener(null);
            getTitlell().clearAnimation();
            getTitlell().setVisibility(8);
            this.index = 0;
            this.playFinished = false;
            return;
        }
        this.showAni.setDuration(1000);
        this.showAni.setStartOffset(1000);
        this.dismisAni.setDuration(1000);
        this.dismisAni.setStartOffset(1000);
        this.dismisAni.setFillAfter(true);
        this.dismisAni.setAnimationListener(new b(this, ref$ObjectRef));
        this.showAni.setAnimationListener(new c(this, ref$ObjectRef));
        View titlell2 = getTitlell();
        T t3 = ref$ObjectRef.element;
        T t4 = t3;
        if (!(!t4.isEmpty()) || t4.size() <= this.index) {
            z = false;
        }
        if (z) {
            t2 = t3;
        }
        T t5 = t2;
        if (t5 != null && (orderItem = (OrderItem) t5.get(this.index)) != null) {
            titlell2.setVisibility(0);
            TextView textView = (TextView) titlell2.findViewById(R$id.common_navbar_info_title);
            if (textView != null) {
                textView.setText(orderItem.getNickName() + ' ' + orderItem.getText());
            }
            TextView textView2 = (TextView) titlell2.findViewById(R$id.common_navbar_info_desc);
            if (textView2 != null) {
                textView2.setText(orderItem.getTime());
            }
            titlell2.startAnimation(this.showAni);
        }
    }

    public final void updateImgLength(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1345783583")) {
            ipChange.ipc$dispatch("-1345783583", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "size");
        k21.i(str2, "pos");
        try {
            if (Integer.parseInt(str) <= 1) {
                View findViewById = this.view.findViewById(R$id.common_img_count_info);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                    return;
                }
                return;
            }
            View findViewById2 = this.view.findViewById(R$id.common_img_count_info);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
            TextView textView = (TextView) this.view.findViewById(R$id.common_img_count_info_title);
            if (textView != null) {
                textView.setText(str2 + v00.DIR + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
