package cn.damai.user.userprofile;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.comment.bean.CommentSyncCircleBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.scriptmurder.venuedetail.VenueDetailFragment;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.evaluate.ui.item.EvaluateItemDataBinder;
import cn.damai.homepage.R$dimen;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.LoginManager;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import cn.damai.uikit.magicindicator.GradientIndicator;
import cn.damai.uikit.magicindicator.PagerTitleView;
import cn.damai.uikit.magicindicator.PagerTitleViewWarpper;
import cn.damai.user.ModifyAvatarActivity;
import cn.damai.user.brand.BrandActivity;
import cn.damai.user.common.SingleLiveEvent;
import cn.damai.user.ipdrama.IpDramaActivity;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.repertoite.view.LinearPullToRefreshView;
import cn.damai.user.star.StarIndexActivity;
import cn.damai.user.userhome.activity.UserHomeActivity;
import cn.damai.user.userprofile.bean.UserData;
import cn.damai.user.userprofile.bean.UserResponse;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.youku.resource.widget.YKActionSheet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import tb.cw2;
import tb.d20;
import tb.gt2;
import tb.i42;
import tb.it2;
import tb.ne2;
import tb.ok;
import tb.p21;
import tb.sp2;
import tb.wz1;
import tb.xf2;
import tb.xu0;

/* compiled from: Taobao */
public class UserIndexActivity extends SimpleBaseActivity implements EvaluateItemDataBinder.EvaluateItemUTReportListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ANIM_HIDE_PUBLISH = 14;
    public static final int ANIM_SHOW_PUBLISH = 13;
    public static final int CLICK_AVATAR = 6;
    public static final int CLICK_BACK = 1;
    public static final int CLICK_BG = 8;
    public static final int CLICK_EDIT = 5;
    public static final int CLICK_FANS_LIST = 11;
    public static final int CLICK_FOLLOW_LIST = 10;
    public static final int CLICK_PUBLISH = 2;
    public static final int CLICK_PUBLISH_CIRCLE = 9;
    public static final int CLICK_PUBLISH_COMMENT = 3;
    public static final int CLICK_SEARCH_LIST = 12;
    public static final int CLICK_SHARE = 4;
    public static final int CLICK_TOMAP = 15;
    public static int EDIT_USER_PROFILE = 20011;
    public static int FLAG_LOGIN = 1001;
    public static int MODIFY_AVATAR = 1;
    public static final int REQ_CDOE_PUGLISH = 10001;
    Observer<UserResponse> headerObserver = new Observer<UserResponse>() {
        /* class cn.damai.user.userprofile.UserIndexActivity.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void onChanged(@Nullable UserResponse userResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2061717183")) {
                ipChange.ipc$dispatch("-2061717183", new Object[]{this, userResponse});
                return;
            }
            if (UserIndexActivity.this.mRefreshView != null) {
                UserIndexActivity.this.mRefreshView.onRefreshComplete();
            }
            if (userResponse != null) {
                if (!xf2.j(userResponse.errorMsg)) {
                    ToastUtil.i(userResponse.errorMsg);
                } else if (userResponse.data != null) {
                    UserIndexActivity.this.initTab();
                    UserIndexActivity userIndexActivity = UserIndexActivity.this;
                    xu0 xu0 = userIndexActivity.presenter;
                    if (xu0 == null) {
                        UserIndexActivity userIndexActivity2 = UserIndexActivity.this;
                        userIndexActivity.presenter = new xu0(userResponse, userIndexActivity2, userIndexActivity2.lastTabIndex);
                        UserIndexActivity userIndexActivity3 = UserIndexActivity.this;
                        userIndexActivity3.presenter.f(userIndexActivity3.statusBarH);
                        UserIndexActivity.this.presenter.g();
                        UserIndexActivity userIndexActivity4 = UserIndexActivity.this;
                        userIndexActivity4.presenter.d(userIndexActivity4.statusBarH);
                        UserIndexActivity.this.presenter.i();
                        UserIndexActivity.this.presenter.b();
                    } else {
                        xu0.j(userResponse);
                        UserIndexActivity userIndexActivity5 = UserIndexActivity.this;
                        userIndexActivity5.presenter.d(userIndexActivity5.statusBarH);
                    }
                    if (UserIndexActivity.this.viewModel.getUserInfoValue() != null) {
                        UserIndexActivity userIndexActivity6 = UserIndexActivity.this;
                        userIndexActivity6.trackUtil.d(userIndexActivity6.viewModel.getUserInfoValue().type, UserIndexActivity.this);
                        UserIndexActivity userIndexActivity7 = UserIndexActivity.this;
                        userIndexActivity7.trackUtil.a(userIndexActivity7.viewModel.getUserInfoValue());
                        UserIndexActivity userIndexActivity8 = UserIndexActivity.this;
                        userIndexActivity8.viewModel.pageName = userIndexActivity8.trackUtil.a;
                    }
                }
            }
        }
    };
    private boolean isAnimateIng = false;
    int lastTabIndex = -1;
    int lastVerticalOffset = 0;
    private LinearPullToRefreshView mRefreshView;
    xu0 presenter;
    View publish;
    int statusBarH = 0;
    it2 trackUtil;
    UserIndexViewModel viewModel;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "294946221")) {
                ipChange.ipc$dispatch("294946221", new Object[]{this, view});
                return;
            }
            DMNav.from(UserIndexActivity.this).toUri(this.a);
        }
    }

    /* compiled from: Taobao */
    public class b implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ View b;
        final /* synthetic */ View c;
        final /* synthetic */ TextView d;
        final /* synthetic */ View e;

        b(View view, View view2, View view3, TextView textView, View view4) {
            this.a = view;
            this.b = view2;
            this.c = view3;
            this.d = textView;
            this.e = view4;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2119817659")) {
                ipChange.ipc$dispatch("2119817659", new Object[]{this, appBarLayout, Integer.valueOf(i)});
                return;
            }
            Log.d("onOffsetChanged", "onOffsetChanged: " + i + "， lastVerticalOffset ：" + UserIndexActivity.this.lastVerticalOffset);
            float abs = ((float) ((Math.abs(i) * 100) / sp2.a(UserIndexActivity.this, 166.0d))) * 0.01f;
            float f2 = 1.0f - abs;
            this.a.setAlpha(f2);
            this.b.setAlpha(f2);
            this.c.setAlpha(f2);
            if (UserIndexActivity.this.viewModel.getUserInfoValue() != null && !UserIndexActivity.this.viewModel.getUserInfoValue().mySelf) {
                if (UserIndexActivity.this.viewModel.getUserInfoValue() != null && !TextUtils.isEmpty(UserIndexActivity.this.viewModel.getUserInfoValue().nickname)) {
                    this.d.setText(UserIndexActivity.this.viewModel.getUserInfoValue().nickname);
                    this.d.setAlpha(abs);
                }
                if (UserIndexActivity.this.viewModel.getUserInfoValue() != null && UserIndexActivity.this.viewModel.getUserInfoValue().type == 1 && this.e.getVisibility() == 0) {
                    this.e.setAlpha(abs);
                }
                if (Math.abs(UserIndexActivity.this.lastVerticalOffset - i) <= 10) {
                    UserIndexActivity.this.lastVerticalOffset = i;
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2007006618")) {
                ipChange.ipc$dispatch("2007006618", new Object[]{this, view});
                return;
            }
            UserIndexActivity.this.viewModel.getClickEvent().setValue(1);
        }
    }

    /* compiled from: Taobao */
    public class d extends ok {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ List b;
        final /* synthetic */ ViewPager c;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1455532568")) {
                    ipChange.ipc$dispatch("-1455532568", new Object[]{this, view});
                    return;
                }
                d.this.c.setCurrentItem(this.a);
            }
        }

        d(List list, ViewPager viewPager) {
            this.b = list;
            this.c = viewPager;
        }

        @Override // tb.ok
        public int a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1140442908")) {
                return ((Integer) ipChange.ipc$dispatch("-1140442908", new Object[]{this})).intValue();
            }
            List list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // tb.ok
        public IPagerIndicator b(Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "89156159")) {
                return (IPagerIndicator) ipChange.ipc$dispatch("89156159", new Object[]{this, context});
            }
            GradientIndicator gradientIndicator = new GradientIndicator(context);
            gradientIndicator.setMode(2);
            gradientIndicator.setLineHeight((float) sp2.a(context, 9.0d));
            gradientIndicator.setYOffset((float) sp2.a(context, 10.0d));
            gradientIndicator.setLineWidth((float) sp2.a(context, 30.0d));
            gradientIndicator.setStartInterpolator(new AccelerateInterpolator());
            gradientIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            gradientIndicator.setPadding(0, sp2.a(context, 6.0d), 0, 0);
            return gradientIndicator;
        }

        @Override // tb.ok
        public IPagerTitleView c(Context context, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "461348760")) {
                return (IPagerTitleView) ipChange.ipc$dispatch("461348760", new Object[]{this, context, Integer.valueOf(i)});
            }
            PagerTitleView pagerTitleView = new PagerTitleView(context);
            pagerTitleView.setText((CharSequence) this.b.get(i));
            pagerTitleView.setNormalColor(Color.parseColor("#999999"));
            pagerTitleView.setSelectedColor(Color.parseColor("#111111"));
            pagerTitleView.setTextSize(13.0f);
            PagerTitleViewWarpper pagerTitleViewWarpper = new PagerTitleViewWarpper(UserIndexActivity.this);
            pagerTitleViewWarpper.setTitleView(pagerTitleView);
            pagerTitleViewWarpper.setOnClickListener(new a(i));
            return pagerTitleViewWarpper;
        }
    }

    /* compiled from: Taobao */
    public class e implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2021348041")) {
                ipChange.ipc$dispatch("-2021348041", new Object[]{this, appBarLayout, Integer.valueOf(i)});
            } else if (i < 0) {
                UserIndexActivity.this.mRefreshView.setPullToRefreshEnabled(false);
            } else {
                UserIndexActivity.this.mRefreshView.setPullToRefreshEnabled(true);
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements LinearPullToRefreshView.OnRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // cn.damai.user.repertoite.view.LinearPullToRefreshView.OnRefreshListener
        public void onRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-847659327")) {
                ipChange.ipc$dispatch("-847659327", new Object[]{this});
                return;
            }
            UserIndexActivity.this.refresh();
        }
    }

    /* compiled from: Taobao */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-321443425")) {
                ipChange.ipc$dispatch("-321443425", new Object[]{this, view});
                return;
            }
            UserIndexActivity.this.viewModel.getClickEvent().setValue(3);
        }
    }

    /* compiled from: Taobao */
    public class h implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        boolean a;

        public h(boolean z) {
            this.a = z;
        }

        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1938477316")) {
                ipChange.ipc$dispatch("1938477316", new Object[]{this, animation});
                return;
            }
            UserIndexActivity.this.isAnimateIng = false;
            UserIndexActivity.this.publish.clearAnimation();
            UserIndexActivity.this.publish.invalidate();
            if (this.a) {
                UserIndexActivity.this.publish.setVisibility(8);
                UserIndexActivity.this.viewModel.hidingState = true;
                return;
            }
            UserIndexActivity.this.publish.setVisibility(0);
            UserIndexActivity.this.viewModel.hidingState = false;
        }

        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1465147408")) {
                ipChange.ipc$dispatch("-1465147408", new Object[]{this, animation});
                return;
            }
            UserIndexActivity.this.isAnimateIng = true;
        }

        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1651061597")) {
                ipChange.ipc$dispatch("1651061597", new Object[]{this, animation});
                return;
            }
            UserIndexActivity.this.isAnimateIng = true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void comment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36476818")) {
            ipChange.ipc$dispatch("36476818", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_EVALUATE);
        bundle.putString("targetId", this.viewModel.getUserId() + "");
        bundle.putString("targetType", "0");
        bundle.putString(p21.ISSUE_PARAM_COMMENT_TYPE, "32");
        bundle.putString(p21.ISSUE_PARAM_IPID, this.viewModel.getUserId() + "");
        bundle.putString("projectName", this.viewModel.getUserInfoValue().nickname);
        bundle.putString(p21.ISSUE_PARAM_PROJECT_POSTER, this.viewModel.getUserInfoValue().headImg);
        DMNav.from(this).withExtras(bundle).needLogin().toUri(NavUri.b("issue"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void edit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1522715599")) {
            ipChange.ipc$dispatch("1522715599", new Object[]{this});
        } else if (this.viewModel.getUserInfoValue() != null) {
            UserData userInfoValue = this.viewModel.getUserInfoValue();
            Bundle bundle = new Bundle();
            bundle.putString("nickName", userInfoValue.nickname);
            bundle.putString("userIntro", userInfoValue.summary);
            bundle.putString("birthday", userInfoValue.birthday);
            bundle.putInt("sex", userInfoValue.sex);
            DMNav.from(this).withExtras(bundle).forResult(EDIT_USER_PROFILE).toUri(NavUri.b("editaccount"));
            it2 it2 = this.trackUtil;
            it2.g(it2.a, "account_info", "edit_portrait", true);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gotoAvatar(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278113563")) {
            ipChange.ipc$dispatch("1278113563", new Object[]{this, str, str2, str3});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("mtopapi", "mtop.damai.wireless.user.uploadHeadImg");
        bundle.putString("title", str2);
        bundle.putString(ModifyAvatarActivity.MODIFY_AVATAR, str);
        bundle.putString(ModifyAvatarActivity.FROM_WHERE, str3);
        DMNav.from(this).withExtras(bundle).needLogin().forResult(MODIFY_AVATAR).toUri(NavUri.b("modifyavatar"));
        it2 it2 = this.trackUtil;
        it2.g(it2.a, "account_info", "edit_portrait", true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "28340631")) {
            ipChange.ipc$dispatch("28340631", new Object[]{this});
        } else if (!this.isAnimateIng && this.viewModel.showPublish && this.publish.getVisibility() == 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 2.0f);
            translateAnimation.setDuration(600);
            translateAnimation.setAnimationListener(new h(true));
            translateAnimation.setFillAfter(true);
            this.publish.startAnimation(translateAnimation);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initCommentState(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1210975167")) {
            ipChange.ipc$dispatch("-1210975167", new Object[]{this, str});
        } else if (!xf2.j(str)) {
            this.viewModel.showPublish = true;
            findViewById(R$id.user_publish).setVisibility(0);
            findViewById(R$id.user_publish_icon).setVisibility(8);
            ((TextView) findViewById(R$id.user_publish_tv)).setText("查看我的评价");
            findViewById(R$id.user_publish_click).setOnClickListener(new a(str));
        } else if (d20.G() != 0) {
            this.viewModel.showPublish = true;
            findViewById(R$id.user_publish).setVisibility(0);
            findViewById(R$id.user_publish_icon).setVisibility(0);
            ((TextView) findViewById(R$id.user_publish_tv)).setText("发评价");
            findViewById(R$id.user_publish_click).setOnClickListener(new g());
        } else {
            this.viewModel.showPublish = false;
            findViewById(R$id.user_publish).setVisibility(8);
        }
    }

    private void initNavBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-306059783")) {
            ipChange.ipc$dispatch("-306059783", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.rl_header_c);
        View findViewById2 = findViewById(R$id.rl_header_b);
        View findViewById3 = findViewById(R$id.rl_header_b_other);
        View findViewById4 = findViewById(R$id.tv_attention);
        ((AppBarLayout) findViewById(R$id.appbar_layout)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b(findViewById, findViewById2, findViewById3, (TextView) findViewById(R$id.bname_titile), findViewById4));
        findViewById(R$id.tv_goback).setOnClickListener(new c());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initTab() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-593102900")) {
            ipChange.ipc$dispatch("-593102900", new Object[]{this});
            return;
        }
        MagicIndicator magicIndicator = (MagicIndicator) findViewById(R$id.magic_indicator);
        ((View) magicIndicator.getParent().getParent()).setVisibility(8);
        magicIndicator.setBackgroundColor(Color.parseColor("#ffffff"));
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        final List<String> tabs = this.viewModel.getTabs();
        if (tabs.size() > 1) {
            ((View) magicIndicator.getParent().getParent()).setVisibility(0);
        }
        ViewPager viewPager = (ViewPager) findViewById(R$id.view_pager);
        commonNavigator.setAdapter(new d(tabs, viewPager));
        magicIndicator.setNavigator(commonNavigator);
        cw2.a(magicIndicator, viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.user.userprofile.UserIndexActivity.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: cn.damai.user.userprofile.UserIndexActivity$6$a */
            /* compiled from: Taobao */
            public class a implements View.OnClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1913728598")) {
                        ipChange.ipc$dispatch("-1913728598", new Object[]{this, view});
                        return;
                    }
                    UserIndexActivity.this.viewModel.getClickEvent().setValue(9);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1971343926")) {
                    ipChange.ipc$dispatch("1971343926", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-839945003")) {
                    ipChange.ipc$dispatch("-839945003", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1111579905")) {
                    ipChange.ipc$dispatch("1111579905", new Object[]{this, Integer.valueOf(i)});
                } else if (i >= 0 && i < tabs.size()) {
                    if ("评价".equals(tabs.get(i))) {
                        UserIndexActivity userIndexActivity = UserIndexActivity.this;
                        userIndexActivity.viewModel.showPublish = false;
                        userIndexActivity.findViewById(R$id.user_publish).setVisibility(8);
                        UserIndexActivity userIndexActivity2 = UserIndexActivity.this;
                        SingleLiveEvent<String> singleLiveEvent = userIndexActivity2.viewModel.myCommentUrl;
                        if (singleLiveEvent != null) {
                            userIndexActivity2.initCommentState(singleLiveEvent.getValue());
                        } else if (LoginManager.k().q()) {
                            UserIndexActivity.this.viewModel.getMyCommentUrl().observe(UserIndexActivity.this, new Observer<String>() {
                                /* class cn.damai.user.userprofile.UserIndexActivity.AnonymousClass6.AnonymousClass1 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                public void onChanged(@Nullable String str) {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "-1933167257")) {
                                        ipChange.ipc$dispatch("-1933167257", new Object[]{this, str});
                                        return;
                                    }
                                    UserIndexActivity.this.initCommentState(str);
                                }
                            });
                        }
                    } else if ("圈子".equals(tabs.get(i))) {
                        UserIndexActivity userIndexActivity3 = UserIndexActivity.this;
                        UserIndexViewModel userIndexViewModel = userIndexActivity3.viewModel;
                        userIndexViewModel.showPublish = false;
                        if (!userIndexViewModel.hidingState) {
                            userIndexActivity3.findViewById(R$id.user_publish).setVisibility(8);
                        }
                        UserIndexActivity.this.findViewById(R$id.user_publish_icon).setVisibility(8);
                        ((TextView) UserIndexActivity.this.findViewById(R$id.user_publish_tv)).setText("发圈子");
                        UserIndexActivity.this.findViewById(R$id.user_publish_click).setOnClickListener(new a());
                    } else {
                        UserIndexActivity userIndexActivity4 = UserIndexActivity.this;
                        userIndexActivity4.viewModel.showPublish = false;
                        userIndexActivity4.findViewById(R$id.user_publish).setVisibility(8);
                    }
                    UserIndexActivity.this.viewModel.setShowCircle(false);
                    UserIndexActivity.this.viewModel.setShowComment(false);
                    UserIndexActivity.this.lastTabIndex = i;
                    String str = null;
                    if (ErrControlViewInfo.TYPE_PROJECT.equals(tabs.get(i))) {
                        str = "perform_clk";
                    } else if ("视频".equals(tabs.get(i))) {
                        str = "video_clk";
                    } else if ("圈子".equals(tabs.get(i))) {
                        str = "circle_clk";
                    }
                    if (str != null) {
                        Map<String, String> utArgs = UserIndexActivity.this.viewModel.getUtArgs();
                        if (UserIndexActivity.this.viewModel.getUserInfoValue() != null) {
                            utArgs.put(wz1.VIEW_TYPE, UserIndexActivity.this.viewModel.getUserInfoValue().mySelf ? "1" : "0");
                        }
                        cn.damai.common.user.c.e().x(new cn.damai.common.user.b().e("business_homepage", "center", str, utArgs, Boolean.FALSE));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void navToFansList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "955855413")) {
            ipChange.ipc$dispatch("955855413", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.viewModel.getUserInfoValue().havanaIdStr)) {
            bundle.putString("userId", String.valueOf(this.viewModel.getUserInfoValue().havanaIdStr));
        } else {
            bundle.putString("userId", String.valueOf(this.viewModel.getUserInfoValue().userId));
        }
        bundle.putString("relationType", "2");
        bundle.putString("targetType", this.viewModel.getUserInfoValue().type + "");
        String str = this.viewModel.getUserInfoValue().bid + "";
        if (!xf2.j(str) && !"0".equals(str)) {
            bundle.putString("targetId", str);
        } else if (!TextUtils.isEmpty(this.viewModel.getUserInfoValue().havanaIdStr)) {
            bundle.putString("targetId", String.valueOf(this.viewModel.getUserInfoValue().havanaIdStr));
        } else {
            bundle.putString("targetId", String.valueOf(this.viewModel.getUserInfoValue().userId));
        }
        DMNav.from(this).withExtras(bundle).toUri(NavUri.b("relation"));
        it2 it2 = this.trackUtil;
        it2.g(it2.a, "account_info", "follower", true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void navToFollowList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1232512420")) {
            ipChange.ipc$dispatch("1232512420", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.viewModel.getUserInfoValue().havanaIdStr)) {
            bundle.putString("userId", String.valueOf(this.viewModel.getUserInfoValue().havanaIdStr));
        } else {
            bundle.putString("userId", String.valueOf(this.viewModel.getUserInfoValue().userId));
        }
        bundle.putString("relationType", "1");
        bundle.putBoolean("self", this.viewModel.getUserInfoValue().mySelf);
        DMNav.from(this).withExtras(bundle).toUri(NavUri.b("relation"));
        it2 it2 = this.trackUtil;
        it2.g(it2.a, "account_info", StarFragment.KEY_FOLLOW, true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void navToProList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2088391404")) {
            ipChange.ipc$dispatch("2088391404", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(YKActionSheet.ACTION_STYLE_DESCRIBE, this.viewModel.getUserInfoValue().nickname);
        bundle.putString("autowords", this.viewModel.getUserInfoValue().nickname);
        bundle.putString(OneArchConstants.LayoutKey.KEY_WORDS, this.viewModel.getUserInfoValue().nickname);
        DMNav.from(this).withExtras(bundle).toUri(NavUri.b("home_search"));
    }

    private void observeClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1430269747")) {
            ipChange.ipc$dispatch("-1430269747", new Object[]{this});
            return;
        }
        this.viewModel.getClickEvent().observe(this, new Observer<Integer>() {
            /* class cn.damai.user.userprofile.UserIndexActivity.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onChanged(@Nullable Integer num) {
                String str;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-723930455")) {
                    ipChange.ipc$dispatch("-723930455", new Object[]{this, num});
                } else if (num.intValue() == 1) {
                    UserIndexActivity.this.finish();
                } else if (UserIndexActivity.this.viewModel.getUserInfoValue() != null) {
                    switch (num.intValue()) {
                        case 2:
                            UserIndexActivity.this.publish();
                            return;
                        case 3:
                            UserIndexActivity.this.comment();
                            return;
                        case 4:
                            UserIndexActivity.this.share();
                            return;
                        case 5:
                            UserIndexActivity.this.edit();
                            return;
                        case 6:
                            if (UserIndexActivity.this.viewModel.getUserInfoValue() != null) {
                                cn.damai.common.user.c e = cn.damai.common.user.c.e();
                                wz1 h = wz1.h();
                                UserIndexViewModel userIndexViewModel = UserIndexActivity.this.viewModel;
                                e.x(h.g(userIndexViewModel.userid, userIndexViewModel.usertype, userIndexViewModel.getUserInfoValue().mySelf));
                            }
                            String str2 = UserIndexActivity.this.viewModel.getUserInfoValue().headImg;
                            if (str2 == null || !str2.contains("?")) {
                                str = str2 + "?ran=" + new Random().nextInt();
                            } else {
                                str = str2 + "&ran=" + new Random().nextInt();
                            }
                            if (UserIndexActivity.this.viewModel.getUserInfoValue().mySelf) {
                                UserIndexActivity.this.gotoAvatar(str, null, ModifyAvatarActivity.FROM_MODIFY_USERR_HEAD);
                                return;
                            } else {
                                UserIndexActivity.this.showBigAvatar(str);
                                return;
                            }
                        case 7:
                        default:
                            return;
                        case 8:
                            if (UserIndexActivity.this.viewModel.getUserInfoValue() != null && UserIndexActivity.this.viewModel.getUserInfoValue().mySelf) {
                                UserIndexActivity.this.saveBg(UserIndexActivity.this.viewModel.getUserInfoValue().headBgImg, "设置背景", ModifyAvatarActivity.FROM_MODIFY_BIG_IMG);
                                return;
                            }
                            return;
                        case 9:
                            UserIndexActivity.this.puglishCircle();
                            return;
                        case 10:
                            UserIndexActivity.this.navToFollowList();
                            return;
                        case 11:
                            UserIndexActivity.this.navToFansList();
                            return;
                        case 12:
                            UserIndexActivity.this.navToProList();
                            return;
                        case 13:
                            UserIndexActivity.this.show();
                            return;
                        case 14:
                            UserIndexActivity.this.hide();
                            return;
                        case 15:
                            UserIndexActivity.this.tomap();
                            return;
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void publish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1057172194")) {
            ipChange.ipc$dispatch("1057172194", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("isPersonal", true);
        bundle.putString("text", this.viewModel.getPreDescribe());
        bundle.putString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_DYNAMIC);
        bundle.putString(p21.ISSUE_PARAM_COMMENT_TYPE, "23");
        DMNav.from(this).withExtras(bundle).forResult(10001).toUri(NavUri.b("issue"));
        it2 it2 = this.trackUtil;
        it2.g(it2.a, "center", "release_pages", true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void puglishCircle() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1496152499")) {
            ipChange.ipc$dispatch("-1496152499", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("circleId", this.viewModel.circleId);
        bundle.putString("circleName", this.viewModel.circleName);
        bundle.putBoolean("isPersonal", this.viewModel.getUserInfoValue().mySelf);
        bundle.putString("text", this.viewModel.getPreDescribe());
        bundle.putString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_DYNAMIC);
        bundle.putString(p21.ISSUE_PARAM_COMMENT_TYPE, "23");
        DMNav.from(this).withExtras(bundle).forResult(10001).toUri(NavUri.b("issue"));
        HashMap hashMap = new HashMap();
        UserIndexViewModel userIndexViewModel = this.viewModel;
        if (!(userIndexViewModel == null || (str = userIndexViewModel.circleId) == null)) {
            hashMap.put("circle_id", str);
        }
        it2 it2 = this.trackUtil;
        it2.h(it2.a, "center", "release_pages", true, hashMap);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void saveBg(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-994267691")) {
            ipChange.ipc$dispatch("-994267691", new Object[]{this, str, str2, str3});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("mtopapi", "mtop.damai.wireless.user.saveUserProfile");
        bundle.putString("title", str2);
        bundle.putString(ModifyAvatarActivity.MODIFY_AVATAR, str);
        bundle.putString(ModifyAvatarActivity.FROM_WHERE, str3);
        DMNav.from(this).withExtras(bundle).needLogin().forResult(MODIFY_AVATAR).toUri(NavUri.b("modifyavatar"));
        it2 it2 = this.trackUtil;
        it2.g(it2.a, "account_info", "edit_cover", true);
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1336931017")) {
            ipChange.ipc$dispatch("1336931017", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar_gap);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = ne2.a(this);
                this.statusBarH = findViewById.getLayoutParams().height;
                findViewById.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            findViewById(R$id.toolbar).setMinimumHeight(getResources().getDimensionPixelOffset(R$dimen.NAVBAR_H) + this.statusBarH);
            ((CollapsingToolbarLayout.LayoutParams) findViewById(R$id.nav_bar).getLayoutParams()).setMargins(0, this.statusBarH, 0, 0);
            return;
        }
        findViewById.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void share() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1910033682")) {
            ipChange.ipc$dispatch("1910033682", new Object[]{this});
        } else if (this.viewModel.getUserInfoValue() != null) {
            Bundle bundle = new Bundle();
            UserData userInfoValue = this.viewModel.getUserInfoValue();
            bundle.putString("title", userInfoValue.nickname);
            bundle.putString("message", "关注TA,第一时间获取动态");
            bundle.putString("imageurl", userInfoValue.headImg);
            StringBuilder sb = new StringBuilder();
            sb.append("https://m.damai.cn/damai/activity/passport/index.html?userId=");
            long j = userInfoValue.bid;
            sb.append(j > 0 ? Long.valueOf(j) : userInfoValue.userId);
            sb.append("&userType=");
            sb.append(userInfoValue.type);
            bundle.putString("producturl", sb.toString());
            bundle.putString("fromWhere", GenerateImageUtil.TYPE_FROMWHERE_USERPROFILE);
            bundle.putString("sinaSharePath", this.viewModel.sinapath);
            bundle.putBoolean("showGenerateImage", true);
            bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_ARTIST_IMAGE);
            bundle.putString("projectName", userInfoValue.nickname);
            if (!xf2.j(userInfoValue.headImg)) {
                bundle.putString("projectImage", userInfoValue.headImg);
            } else {
                bundle.putString("projectImage", i42.r(R$drawable.c_default_bg));
            }
            ShareManager.E().T(this, bundle, findViewById(R$id.nav_bar));
            ShareManager.E().L();
            ShareManager.E().q0();
            ShareManager.E().l0();
            it2 it2 = this.trackUtil;
            it2.g(it2.a, "top", "share", false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1183012348")) {
            ipChange.ipc$dispatch("1183012348", new Object[]{this});
        } else if (!this.isAnimateIng && this.viewModel.showPublish && this.publish.getVisibility() != 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(600);
            translateAnimation.setAnimationListener(new h(false));
            translateAnimation.setFillAfter(true);
            this.publish.startAnimation(translateAnimation);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showBigAvatar(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-165268897")) {
            ipChange.ipc$dispatch("-165268897", new Object[]{this, str});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(ModifyAvatarActivity.MODIFY_AVATAR, str);
        bundle.putBoolean("imggallery", true);
        DMNav.from(this).withExtras(bundle).toUri(NavUri.b("modifyavatar"));
        it2 it2 = this.trackUtil;
        it2.g(it2.a, "account_info", "portrait", false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void tomap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1603612848")) {
            ipChange.ipc$dispatch("1603612848", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("lat", this.viewModel.getUserInfoValue().lat);
        bundle.putDouble("lng", this.viewModel.getUserInfoValue().lng);
        bundle.putString(ILocatable.ADDRESS, this.viewModel.getUserInfoValue().summary);
        bundle.putString("name", this.viewModel.getUserInfoValue().nickname);
        DMNav.from(this).withExtras(bundle).toUri(NavUri.b("venuemap"));
        HashMap hashMap = new HashMap();
        hashMap.put("city", this.viewModel.getUserInfoValue().city);
        hashMap.put("titlelabel", this.viewModel.getUserInfoValue().nickname);
        it2 it2 = this.trackUtil;
        it2.h(it2.a, "venueinfo", "venuemapbtn", true, hashMap);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1914493175")) {
            return R$layout.activity_userindex;
        }
        return ((Integer) ipChange.ipc$dispatch("-1914493175", new Object[]{this})).intValue();
    }

    public void initRefreshHeader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-757578183")) {
            ipChange.ipc$dispatch("-757578183", new Object[]{this});
            return;
        }
        LinearPullToRefreshView linearPullToRefreshView = (LinearPullToRefreshView) findViewById(R$id.lin_refresh_layout);
        this.mRefreshView = linearPullToRefreshView;
        PullToRefreshHeaderView headerLayout = linearPullToRefreshView.getHeaderLayout();
        if (headerLayout != null) {
            headerLayout.setBackgroundResource(cn.damai.homepage.R$color.white);
        }
        ((AppBarLayout) findViewById(R$id.appbar_layout)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new e());
        this.mRefreshView.setOnRefreshListener(new f());
    }

    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1397034229")) {
            ipChange.ipc$dispatch("-1397034229", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
        if (i == MODIFY_AVATAR && i2 == -1) {
            refresh();
        } else if (i == EDIT_USER_PROFILE && i2 == -1) {
            refresh();
        } else {
            if (i == FLAG_LOGIN && i2 == -1) {
                refresh();
            }
            if (i == 10001) {
                if (intent != null) {
                    this.viewModel.setPreDescribe(intent.getStringExtra("text"));
                }
                refresh();
            } else if (i2 == -1) {
                refresh();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1044414058")) {
            ipChange.ipc$dispatch("-1044414058", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        hideBaseLayout();
        setContentView(R$layout.activity_userindex);
        this.trackUtil = new it2();
        UserIndexViewModel userIndexViewModel = (UserIndexViewModel) ViewModelProviders.of(this).get(UserIndexViewModel.class);
        this.viewModel = userIndexViewModel;
        if (!userIndexViewModel.initParams(getIntent())) {
            ToastUtil.i("请求数据出错.");
        } else if ("2".equals(this.viewModel.usertype)) {
            Intent intent = new Intent(this, StarIndexActivity.class);
            intent.putExtras(getIntent().getExtras());
            intent.putExtra("userId", this.viewModel.userid);
            intent.putExtra(RepertoireDetailFragment.USERTYPE, "2");
            startActivity(intent);
            finish();
        } else if ("4".equals(this.viewModel.usertype)) {
            Intent intent2 = new Intent(this, BrandActivity.class);
            intent2.putExtras(getIntent().getExtras());
            intent2.putExtra("userId", this.viewModel.userid);
            intent2.putExtra(RepertoireDetailFragment.USERTYPE, "4");
            startActivity(intent2);
            finish();
        } else if ("5".equals(this.viewModel.usertype)) {
            Intent intent3 = new Intent(this, IpDramaActivity.class);
            intent3.putExtras(getIntent().getExtras());
            intent3.putExtra("id", this.viewModel.userid);
            startActivity(intent3);
            finish();
        } else if (1 == this.viewModel.getUserType()) {
            Intent intent4 = new Intent(this, UserHomeActivity.class);
            intent4.putExtras(getIntent().getExtras());
            intent4.putExtra("userId", this.viewModel.userid);
            startActivity(intent4);
            finish();
        } else if (3 == this.viewModel.getUserType()) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(VenueDetailFragment.VENUE_ID, this.viewModel.userid);
            DMNav.from(this).withExtras(bundle2).toHost("venue_detail");
            finish();
        } else {
            setImmersionStyle();
            this.publish = findViewById(R$id.user_publish);
            initNavBar();
            initRefreshHeader();
            refresh();
            observeClick();
            setDamaiUTKeyBuilder(new a.b().i(gt2.USER_HOME_PAGE));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportImageInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i, int i2) {
        UserIndexViewModel userIndexViewModel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889473041")) {
            ipChange.ipc$dispatch("-1889473041", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (commentsItemBean != null && commentsItemBean.getUserDO() != null && (userIndexViewModel = this.viewModel) != null && userIndexViewModel.getUserInfoValue() != null) {
            cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
            wz1 h2 = wz1.h();
            UserIndexViewModel userIndexViewModel2 = this.viewModel;
            e2.x(h2.k(z, userIndexViewModel2.userid, userIndexViewModel2.usertype, userIndexViewModel2.getUserInfoValue().mySelf, commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), commentsItemBean.getTargetId(), commentsItemBean.getCommentType(), i));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportItemClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        UserIndexViewModel userIndexViewModel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561574572")) {
            ipChange.ipc$dispatch("1561574572", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else if (commentsItemBean != null && commentsItemBean.getUserDO() != null && (userIndexViewModel = this.viewModel) != null && userIndexViewModel.getUserInfoValue() != null) {
            cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
            wz1 h2 = wz1.h();
            UserIndexViewModel userIndexViewModel2 = this.viewModel;
            e2.x(h2.i(z, userIndexViewModel2.userid, userIndexViewModel2.usertype, userIndexViewModel2.getUserInfoValue().mySelf, commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), commentsItemBean.getTargetId(), commentsItemBean.getCommentType(), i));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportMoreInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        UserIndexViewModel userIndexViewModel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2058548124")) {
            ipChange.ipc$dispatch("2058548124", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else if (commentsItemBean != null && commentsItemBean.getUserDO() != null && (userIndexViewModel = this.viewModel) != null && userIndexViewModel.getUserInfoValue() != null) {
            cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
            wz1 h2 = wz1.h();
            UserIndexViewModel userIndexViewModel2 = this.viewModel;
            e2.x(h2.j(userIndexViewModel2.userid, userIndexViewModel2.usertype, userIndexViewModel2.getUserInfoValue().mySelf, commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), commentsItemBean.getTargetId(), commentsItemBean.getCommentType()));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportPraiseViewClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        UserIndexViewModel userIndexViewModel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "633746686")) {
            ipChange.ipc$dispatch("633746686", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else if (commentsItemBean != null && commentsItemBean.getUserDO() != null && (userIndexViewModel = this.viewModel) != null && userIndexViewModel.getUserInfoValue() != null && commentsItemBean.getPraiseInfo() != null && commentsItemBean.getPraiseInfo().isHasPraised()) {
            cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
            wz1 h2 = wz1.h();
            UserIndexViewModel userIndexViewModel2 = this.viewModel;
            e2.x(h2.l(z, userIndexViewModel2.userid, userIndexViewModel2.usertype, userIndexViewModel2.getUserInfoValue().mySelf, commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), commentsItemBean.getTargetId(), commentsItemBean.getCommentType(), i));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportReplyClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        UserIndexViewModel userIndexViewModel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-924689485")) {
            ipChange.ipc$dispatch("-924689485", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else if (commentsItemBean != null && commentsItemBean.getUserDO() != null && (userIndexViewModel = this.viewModel) != null && userIndexViewModel.getUserInfoValue() != null) {
            cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
            wz1 h2 = wz1.h();
            UserIndexViewModel userIndexViewModel2 = this.viewModel;
            e2.x(h2.n(z, userIndexViewModel2.userid, userIndexViewModel2.usertype, userIndexViewModel2.getUserInfoValue().mySelf, commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), commentsItemBean.getTargetId(), commentsItemBean.getCommentType(), i));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportSyncCircleClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        UserIndexViewModel userIndexViewModel;
        List<CommentSyncCircleBean> syncCircle;
        CommentSyncCircleBean commentSyncCircleBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34483380")) {
            ipChange.ipc$dispatch("34483380", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else if (commentsItemBean != null && commentsItemBean.getUserDO() != null && (userIndexViewModel = this.viewModel) != null && userIndexViewModel.getUserInfoValue() != null && (syncCircle = commentsItemBean.getSyncCircle()) != null && !syncCircle.isEmpty() && (commentSyncCircleBean = syncCircle.get(0)) != null) {
            cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
            wz1 h2 = wz1.h();
            UserIndexViewModel userIndexViewModel2 = this.viewModel;
            e2.x(h2.f(z, userIndexViewModel2.userid, userIndexViewModel2.usertype, userIndexViewModel2.getUserInfoValue().mySelf, commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), commentsItemBean.getTargetId(), commentsItemBean.getCommentType(), commentSyncCircleBean.getCircleId(), i));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportTransferClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-383308716")) {
            ipChange.ipc$dispatch("-383308716", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportUserInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        UserIndexViewModel userIndexViewModel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1046544742")) {
            ipChange.ipc$dispatch("1046544742", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else if (commentsItemBean != null && commentsItemBean.getUserDO() != null && (userIndexViewModel = this.viewModel) != null && userIndexViewModel.getUserInfoValue() != null) {
            cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
            wz1 h2 = wz1.h();
            UserIndexViewModel userIndexViewModel2 = this.viewModel;
            e2.x(h2.p(z, userIndexViewModel2.userid, userIndexViewModel2.usertype, userIndexViewModel2.getUserInfoValue().mySelf, commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), commentsItemBean.getTargetId(), commentsItemBean.getCommentType(), i));
        }
    }

    public void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1184509546")) {
            ipChange.ipc$dispatch("-1184509546", new Object[]{this});
            return;
        }
        xu0 xu0 = this.presenter;
        if (xu0 != null) {
            xu0.c();
            this.presenter = null;
        }
        this.mRefreshView.setRefreshing();
        this.viewModel.reset();
        this.viewModel.requestUserInfo().observe(this, this.headerObserver);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-885290563")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-885290563", new Object[]{this});
    }
}
