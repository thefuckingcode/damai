package com.alibaba.pictures.bricks.component.home.grabhotrecommend;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$anim;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$raw;
import com.alibaba.pictures.bricks.bean.HomeGrabHotRecoBean;
import com.alibaba.pictures.bricks.bean.TitleNode;
import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerContract;
import com.alibaba.pictures.bricks.util.UTUtil;
import com.alibaba.pictures.bricks.view.DMUpMarqueeView;
import com.alibaba.pictures.ut.ClickCat;
import com.alibaba.pictures.ut.DogCat;
import com.alient.onearch.adapter.component.banner.loop.LoopBannerView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.view.IContract;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.e92;
import tb.k21;
import tb.tv0;
import tb.u50;
import tb.uv0;
import tb.v;
import tb.vv0;
import tb.wm2;
import tb.wv0;
import tb.xv0;
import tb.yv0;
import tb.zs0;

/* compiled from: Taobao */
public final class HomeGrabHotRecommendContainerView extends LoopBannerView implements HomeGrabHotRecommendContainerContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ImageView bgLayout;
    @NotNull
    private final View itemView;
    private final LottieAnimationView lottie;
    @NotNull
    private final DMUpMarqueeView marqueeView;
    private String spmc;
    private String spmd;
    private final LinearLayout subTitleView;
    private final ImageView titleIcon;

    /* compiled from: Taobao */
    public static final class a implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HomeGrabHotRecommendContainerView a;
        final /* synthetic */ Animation b;

        a(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, Animation animation) {
            this.a = homeGrabHotRecommendContainerView;
            this.b = animation;
        }

        public void onAnimationEnd(@NotNull Animation animation) {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2125390653")) {
                ipChange.ipc$dispatch("-2125390653", new Object[]{this, animation});
                return;
            }
            k21.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
            View currentView = this.a.marqueeView.getCurrentView();
            View findViewById = currentView.findViewById(R$id.home_grab_content_text);
            k21.h(findViewById, "currentView.findViewById…d.home_grab_content_text)");
            ((TextView) findViewById).startAnimation(this.b);
            Object tag = currentView.getTag();
            k21.g(tag, "null cannot be cast to non-null type com.alibaba.pictures.bricks.bean.TitleNode");
            TitleNode titleNode = (TitleNode) tag;
            HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView = this.a;
            HashMap<String, String> hashMap = new HashMap<>();
            homeGrabHotRecommendContainerView.setTrackInfo(hashMap, titleNode.itemId, titleNode.comboDispatchId);
            UTUtil uTUtil = UTUtil.INSTANCE;
            StringBuilder sb = new StringBuilder();
            String str2 = homeGrabHotRecommendContainerView.spmd;
            if (str2 == null) {
                k21.A("spmd");
                str2 = null;
            }
            sb.append(str2);
            sb.append(titleNode.index);
            String sb2 = sb.toString();
            String str3 = homeGrabHotRecommendContainerView.spmc;
            if (str3 == null) {
                k21.A("spmc");
                str = null;
            } else {
                str = str3;
            }
            IContract.Presenter presenter = homeGrabHotRecommendContainerView.getPresenter();
            k21.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerPresent");
            String pageName = ((GenericItem) ((HomeGrabHotRecommendContainerPresent) presenter).getItem()).getPageContext().getPageName();
            if (pageName == null) {
                pageName = "home";
            }
            uTUtil.c(sb2, str, pageName, "1.0", 3000, hashMap, 2201);
        }

        public void onAnimationRepeat(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1617672239")) {
                ipChange.ipc$dispatch("-1617672239", new Object[]{this, animation});
                return;
            }
            k21.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
        }

        public void onAnimationStart(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "399215452")) {
                ipChange.ipc$dispatch("399215452", new Object[]{this, animation});
                return;
            }
            k21.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeGrabHotRecommendContainerView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        this.bgLayout = (ImageView) view.findViewById(R$id.bricks_hotrecommend_layout);
        this.titleIcon = (ImageView) view.findViewById(R$id.bricks_hotrecommend_title);
        View findViewById = view.findViewById(R$id.hotrecommend_subtitle_content);
        k21.h(findViewById, "itemView.findViewById(R.…commend_subtitle_content)");
        this.marqueeView = (DMUpMarqueeView) findViewById;
        this.subTitleView = (LinearLayout) view.findViewById(R$id.hotrecommend_subtitle);
        this.lottie = (LottieAnimationView) view.findViewById(R$id.bricks_hotrecommend_lottie_layout);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-4$lambda-0  reason: not valid java name */
    public static final void m125bindView$lambda4$lambda0(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2041810218")) {
            ipChange.ipc$dispatch("-2041810218", new Object[]{homeGrabHotRecommendContainerView, successEvent});
            return;
        }
        k21.i(homeGrabHotRecommendContainerView, "this$0");
        Drawable drawable = successEvent.drawable;
        if (drawable == null) {
            homeGrabHotRecommendContainerView.bgLayout.setBackgroundResource(R$drawable.bricks_hotrecommend_bg);
        } else {
            homeGrabHotRecommendContainerView.bgLayout.setBackground(drawable);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-4$lambda-1  reason: not valid java name */
    public static final void m126bindView$lambda4$lambda1(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1779024218")) {
            ipChange.ipc$dispatch("-1779024218", new Object[]{homeGrabHotRecommendContainerView, failEvent});
            return;
        }
        k21.i(homeGrabHotRecommendContainerView, "this$0");
        homeGrabHotRecommendContainerView.bgLayout.setBackgroundResource(R$drawable.bricks_hotrecommend_bg);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-4$lambda-2  reason: not valid java name */
    public static final void m127bindView$lambda4$lambda2(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, HomeGrabHotRecoBean homeGrabHotRecoBean, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "403681297")) {
            ipChange.ipc$dispatch("403681297", new Object[]{homeGrabHotRecommendContainerView, homeGrabHotRecoBean, successEvent});
            return;
        }
        k21.i(homeGrabHotRecommendContainerView, "this$0");
        k21.i(homeGrabHotRecoBean, "$this_data");
        Drawable drawable = successEvent.drawable;
        if (drawable == null) {
            homeGrabHotRecommendContainerView.titleDefaultIcon(homeGrabHotRecoBean.isHotRecommendType());
            return;
        }
        homeGrabHotRecommendContainerView.titleIcon.setImageDrawable(drawable);
        ViewGroup.LayoutParams layoutParams = homeGrabHotRecommendContainerView.titleIcon.getLayoutParams();
        if (layoutParams != null) {
            int width = successEvent.bitmap.getWidth();
            u50 u50 = u50.INSTANCE;
            Context context = homeGrabHotRecommendContainerView.itemView.getContext();
            k21.h(context, "itemView.context");
            layoutParams.width = (width * u50.b(context, 14)) / successEvent.bitmap.getHeight();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-4$lambda-3  reason: not valid java name */
    public static final void m128bindView$lambda4$lambda3(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, HomeGrabHotRecoBean homeGrabHotRecoBean, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1812785653")) {
            ipChange.ipc$dispatch("-1812785653", new Object[]{homeGrabHotRecommendContainerView, homeGrabHotRecoBean, failEvent});
            return;
        }
        k21.i(homeGrabHotRecommendContainerView, "this$0");
        k21.i(homeGrabHotRecoBean, "$this_data");
        homeGrabHotRecommendContainerView.titleDefaultIcon(homeGrabHotRecoBean.isHotRecommendType());
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-7  reason: not valid java name */
    public static final void m129bindView$lambda7(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1908298219")) {
            ipChange.ipc$dispatch("1908298219", new Object[]{homeGrabHotRecommendContainerView, view});
            return;
        }
        k21.i(homeGrabHotRecommendContainerView, "this$0");
        homeGrabHotRecommendContainerView.performItemClick();
    }

    private final View createView(TitleNode titleNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1209998336")) {
            return (View) ipChange.ipc$dispatch("-1209998336", new Object[]{this, titleNode});
        }
        View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.bricks_home_grab_flippercontent, (ViewGroup) null);
        k21.h(inflate, "from(itemView.context)\n …rab_flippercontent, null)");
        View findViewById = inflate.findViewById(R$id.home_grab_content_text);
        k21.h(findViewById, "view.findViewById(R.id.home_grab_content_text)");
        ((TextView) findViewById).setText(titleNode.title);
        inflate.setTag(titleNode);
        return inflate;
    }

    private final void initFlipper(List<? extends TitleNode> list) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-788526388")) {
            ipChange.ipc$dispatch("-788526388", new Object[]{this, list});
            return;
        }
        this.marqueeView.setOnItemClickListener(new uv0(this));
        this.marqueeView.setFlipInterval(4000);
        this.marqueeView.setAnimationDuration(500);
        ArrayList arrayList = new ArrayList();
        for (TitleNode titleNode : list) {
            if (!TextUtils.isEmpty(titleNode.title)) {
                arrayList.add(createView(titleNode));
                titleNode.index = i;
                i++;
            }
        }
        this.marqueeView.setItems(arrayList);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.itemView.getContext(), R$anim.bricks_scale_boom);
        k21.h(loadAnimation, "loadAnimation(itemView.c…R.anim.bricks_scale_boom)");
        Animation inAnimation = this.marqueeView.getInAnimation();
        if (inAnimation != null) {
            inAnimation.setAnimationListener(new a(this, loadAnimation));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initFlipper$lambda-11  reason: not valid java name */
    public static final void m130initFlipper$lambda11(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "630261701")) {
            ipChange.ipc$dispatch("630261701", new Object[]{homeGrabHotRecommendContainerView, Integer.valueOf(i), view});
            return;
        }
        k21.i(homeGrabHotRecommendContainerView, "this$0");
        homeGrabHotRecommendContainerView.performItemClick();
    }

    private final void performItemClick() {
        Object tag;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "951709723")) {
            ipChange.ipc$dispatch("951709723", new Object[]{this});
            return;
        }
        View currentView = this.marqueeView.getCurrentView();
        if (currentView != null && (tag = currentView.getTag()) != null) {
            TitleNode titleNode = (TitleNode) tag;
            HashMap<String, String> hashMap = new HashMap<>();
            setTrackInfo(hashMap, titleNode.itemId, titleNode.comboDispatchId);
            int i = titleNode.index;
            ClickCat d = DogCat.INSTANCE.d();
            IContract.Presenter presenter = getPresenter();
            k21.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerPresent");
            String pageName = ((GenericItem) ((HomeGrabHotRecommendContainerPresent) presenter).getItem()).getPageContext().getPageName();
            if (pageName == null) {
                pageName = "home";
            }
            ClickCat n = d.n(pageName);
            String str = this.spmc;
            String str2 = null;
            if (str == null) {
                k21.A("spmc");
                str = null;
            }
            StringBuilder sb = new StringBuilder();
            String str3 = this.spmd;
            if (str3 == null) {
                k21.A("spmd");
            } else {
                str2 = str3;
            }
            sb.append(str2);
            sb.append(i);
            n.r(str, sb.toString()).o(hashMap).j();
            Action action = new Action();
            action.setActionType(1);
            action.setActionUrl(titleNode.schema);
            NavProviderProxy.getProxy().toUri(this.itemView.getContext(), action);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setTrackInfo(HashMap<String, String> hashMap, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "675162767")) {
            ipChange.ipc$dispatch("675162767", new Object[]{this, hashMap, str, str2});
            return;
        }
        if (str != null) {
            hashMap.put("item_id", str);
        }
        if (str2 != null) {
            hashMap.put("dispatch_id", str2);
        }
    }

    private final void titleDefaultIcon(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-301995993")) {
            ipChange.ipc$dispatch("-301995993", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.titleIcon.setImageResource(R$drawable.bricks_hotrecommend_title);
        } else {
            this.titleIcon.setImageResource(R$drawable.bricks_grab_title);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerContract.View
    @RequiresApi(21)
    public void bindView(@Nullable JSONObject jSONObject, @Nullable String str) {
        List<TitleNode> list;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942612717")) {
            ipChange.ipc$dispatch("942612717", new Object[]{this, jSONObject, str});
            return;
        }
        getBanner().setRoundCorners(0.0f);
        getBanner().setAutoTurningTime(DanmakuFactory.MIN_DANMAKU_DURATION);
        getBanner().getViewPager2().setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        getBanner().getViewPager2().setUserInputEnabled(false);
        HomeGrabHotRecoBean homeGrabHotRecoBean = (HomeGrabHotRecoBean) wm2.INSTANCE.j(jSONObject, HomeGrabHotRecoBean.class);
        List<TitleNode> list2 = null;
        if (homeGrabHotRecoBean != null) {
            JSONObject jSONObject6 = homeGrabHotRecoBean.action;
            String string = (jSONObject6 == null || (jSONObject4 = jSONObject6.getJSONObject("item")) == null || (jSONObject5 = jSONObject4.getJSONObject("trackInfo")) == null) ? null : jSONObject5.getString("spmc");
            if (string == null) {
                string = zs0.GRAB_PAGE;
            } else {
                k21.h(string, "this.action?.getJSONObje…(\"spmc\")?:\"snatch_ticket\"");
            }
            this.spmc = string;
            JSONObject jSONObject7 = homeGrabHotRecoBean.action;
            String string2 = (jSONObject7 == null || (jSONObject2 = jSONObject7.getJSONObject("item")) == null || (jSONObject3 = jSONObject2.getJSONObject("trackInfo")) == null) ? null : jSONObject3.getString("spmd");
            if (string2 == null) {
                string2 = "more_item_";
            } else {
                k21.h(string2, "this.action?.getJSONObje…ing(\"spmd\")?:\"more_item_\"");
            }
            this.spmd = string2;
            ImageLoaderProviderProxy.getProxy().load(homeGrabHotRecoBean.bgPic, new xv0(this), new vv0(this));
            ImageLoaderProviderProxy.getProxy().load(homeGrabHotRecoBean.titlePic, new yv0(this, homeGrabHotRecoBean), new wv0(this, homeGrabHotRecoBean));
            if (!homeGrabHotRecoBean.isHotRecommendType()) {
                if (this.lottie.getVisibility() == 8) {
                    this.lottie.setVisibility(0);
                }
                this.lottie.setAnimation(R$raw.bricks_circle_allround);
                this.lottie.playAnimation();
                this.lottie.setRepeatMode(1);
                this.lottie.setRepeatCount(-1);
                if (homeGrabHotRecoBean.isProjectType()) {
                    ViewGroup.LayoutParams layoutParams = this.lottie.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                    if (marginLayoutParams != null) {
                        u50 u50 = u50.INSTANCE;
                        Context context = this.itemView.getContext();
                        k21.h(context, "itemView.context");
                        marginLayoutParams.leftMargin = u50.a(context, -37.5f);
                    }
                } else {
                    ViewGroup.LayoutParams layoutParams2 = this.lottie.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
                    if (marginLayoutParams2 != null) {
                        u50 u502 = u50.INSTANCE;
                        Context context2 = this.itemView.getContext();
                        k21.h(context2, "itemView.context");
                        marginLayoutParams2.leftMargin = u502.a(context2, -36.5f);
                    }
                }
            } else if (this.lottie.getVisibility() != 8) {
                this.lottie.setVisibility(8);
                this.lottie.cancelAnimation();
            }
        } else {
            this.bgLayout.setBackgroundResource(R$drawable.bricks_hotrecommend_bg);
            this.titleIcon.setImageResource(R$drawable.bricks_hotrecommend_title);
        }
        if (homeGrabHotRecoBean != null) {
            list2 = homeGrabHotRecoBean.noticeList;
        }
        if (!e92.d(list2)) {
            this.subTitleView.setVisibility(0);
            if (!(homeGrabHotRecoBean == null || (list = homeGrabHotRecoBean.noticeList) == null)) {
                initFlipper(list);
            }
            this.itemView.setOnClickListener(new tv0(this));
            return;
        }
        this.subTitleView.setVisibility(8);
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-436235089")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("-436235089", new Object[]{this});
    }
}
