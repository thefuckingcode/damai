package cn.damai.launcher.splash;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import cn.damai.category.discountticket.bean.biz.Column3WrapBean;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.homepage.R$anim;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.launcher.LauncherApplication;
import cn.damai.launcher.splash.GridAdapter;
import cn.damai.launcher.splash.TopBottomScrollView;
import cn.damai.launcher.splash.api.Coupon;
import cn.damai.launcher.splash.api.GetCouponResponse;
import cn.damai.launcher.splash.api.GetCouponsRequest;
import cn.damai.launcher.splash.api.GuideResponse;
import cn.damai.launcher.splash.api.ItemInfo;
import cn.damai.launcher.splash.api.SaveUserSelectRequest;
import cn.damai.launcher.ut.LauncherUTHelper;
import cn.damai.tetris.component.brand.bean.DrawReward;
import cn.damai.tetris.component.brand.bean.LotteryDrawResult;
import cn.damai.tetris.component.brand.bean.LotteryRequest;
import cn.damai.tetris.component.brand.bean.LotteryResponse;
import cn.damai.uikit.view.state.AnimationStateView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.AbstractEditComponent;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import com.youku.uplayer.AliMediaPlayer;
import java.lang.ref.WeakReference;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tb.d20;
import tb.g91;
import tb.gr;
import tb.jl1;
import tb.kt0;
import tb.lt0;
import tb.ne2;
import tb.v50;
import tb.yj1;

/* compiled from: Taobao */
public class GuideActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "GuideActivity";
    private TextView btnGetCoupon;
    private a.b builder;
    private boolean couponRequestFinished = false;
    private GetCouponResponse couponResponse;
    private ViewGroup getCouponList;
    private GridView gridView;
    private List<CouponViewHolder> holders = new ArrayList();
    private ArrayList<ItemInfo> itemInfos;
    private ImageView ivLogo;
    private ImageView ivLogoShadow;
    private AnimationStateView mHeadBgImage;
    private TextView nextPageBtn;
    private HashSet<String> selectIds = new HashSet<>();
    private long startTime;
    private TimeHandler timerHandler = new TimeHandler(this);
    private TextView tvSubTitleShadow;
    private TextView tvSubTtle;
    private TextView tvTitle;
    private TextView tvTitleShadow;

    /* compiled from: Taobao */
    public static class DelayHandler extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private final WeakReference<GuideActivity> a;

        DelayHandler(GuideActivity guideActivity) {
            this.a = new WeakReference<>(guideActivity);
        }

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-414775187")) {
                ipChange.ipc$dispatch("-414775187", new Object[]{this, message});
                return;
            }
            int i = message.what;
            if (i != 0) {
                if (i == 1 && this.a.get() != null && !this.a.get().isActivityFinsihed()) {
                    GuideActivity guideActivity = this.a.get();
                    guideActivity.showPage3();
                    guideActivity.refreshCountDown(((LotteryResponse) message.obj).returnValue.rewards);
                }
            } else if (this.a.get() != null) {
                this.a.get().gotoHomePage();
            }
        }
    }

    /* compiled from: Taobao */
    public static class TimeHandler extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        WeakReference<GuideActivity> a;

        public TimeHandler(GuideActivity guideActivity) {
            this.a = new WeakReference<>(guideActivity);
        }

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-701029671")) {
                ipChange.ipc$dispatch("-701029671", new Object[]{this, message});
                return;
            }
            GuideActivity guideActivity = this.a.get();
            if (guideActivity != null && !guideActivity.isActivityFinsihed()) {
                guideActivity.showCoupons();
            }
        }
    }

    private void bindCouponAndInit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "999074938")) {
            ipChange.ipc$dispatch("999074938", new Object[]{this});
        } else if (invalidCoupons()) {
            gotoHomePage();
        } else {
            bindCouponData();
            TextView textView = (TextView) findViewById(R$id.guide_btn_getcoupon);
            this.btnGetCoupon = textView;
            textView.setOnClickListener(this);
            if (TextUtils.isEmpty(this.couponResponse.projectSchema)) {
                findViewById(R$id.guide_btn_seemore).setVisibility(8);
            } else {
                int i = R$id.guide_btn_seemore;
                findViewById(i).setVisibility(0);
                findViewById(i).setOnClickListener(new lt0(this));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("coupon_id", this.couponResponse.coupons.get(0).prizePoolSpreadId);
            GuidePageUTHelper.getInstance().g(this.btnGetCoupon, "step_two", "get_coupon", hashMap);
        }
    }

    private void bindCouponData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1141171937")) {
            ipChange.ipc$dispatch("-1141171937", new Object[]{this});
            return;
        }
        int[] iArr = {R$id.layout_guide_coupon_1, R$id.layout_guide_coupon_2, R$id.layout_guide_coupon_3};
        int i = 0;
        for (Coupon coupon : this.couponResponse.coupons) {
            if (i >= 3) {
                break;
            }
            CouponViewHolder couponViewHolder = new CouponViewHolder((LinearLayout) findViewById(iArr[i]), this);
            couponViewHolder.d(100, AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH);
            couponViewHolder.setCouponTextLine(1);
            couponViewHolder.b(coupon);
            couponViewHolder.a.setVisibility(0);
            i++;
        }
        ImageView imageView = (ImageView) findViewById(R$id.layout_guide_couponlist_bg);
        if (this.couponResponse.coupons.size() == 2) {
            findViewById(R$id.layout_guide_coupon_3).setVisibility(8);
            imageView.setImageDrawable(getResources().getDrawable(R$drawable.launcher_guide_coupon_bg2));
        } else if (this.couponResponse.coupons.size() == 1) {
            findViewById(R$id.layout_guide_coupon_2).setVisibility(8);
            findViewById(R$id.layout_guide_coupon_3).setVisibility(8);
            imageView.setImageDrawable(getResources().getDrawable(R$drawable.launcher_guide_coupon_bg1));
        }
        this.getCouponList.invalidate();
    }

    private void bindGetCouponData() {
        LinearLayout linearLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-519234059")) {
            ipChange.ipc$dispatch("-519234059", new Object[]{this});
        } else if (!invalidCoupons() && (linearLayout = (LinearLayout) findViewById(R$id.layout_guide_showcoupons_hsll)) != null) {
            int i = 0;
            while (i < 3 && i < this.couponResponse.coupons.size()) {
                Coupon coupon = this.couponResponse.coupons.get(i);
                View inflate = LayoutInflater.from(this).inflate(R$layout.layout_guide_coupon_card, (ViewGroup) linearLayout, false);
                linearLayout.addView(inflate);
                CouponViewHolder couponViewHolder = new CouponViewHolder((LinearLayout) inflate, this);
                int i2 = 8;
                if (this.couponResponse.coupons.size() > 1) {
                    couponViewHolder.d(70, 140);
                    couponViewHolder.setCouponTextLine(1);
                } else {
                    couponViewHolder.d(90, AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH);
                    couponViewHolder.setCouponTextLine(1);
                    findViewById(R$id.layout_guide_showcoupons_hs_mask).setVisibility(8);
                }
                couponViewHolder.b(coupon);
                if (i == 0) {
                    i2 = 0;
                }
                couponViewHolder.c(i2, 0);
                this.holders.add(couponViewHolder);
                i++;
            }
            linearLayout.invalidate();
            this.btnGetCoupon.setBackground(getResources().getDrawable(R$drawable.launcher_guide_gotcoupon));
        }
    }

    private void changeTitleLogoAnim(View view, View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-729920070")) {
            ipChange.ipc$dispatch("-729920070", new Object[]{this, view, view2});
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "translationY", (float) (view2.getHeight() * 3), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, (float) ((-view.getHeight()) * 3));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        view2.setVisibility(0);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.start();
    }

    private void couponAnim(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2115225757")) {
            ipChange.ipc$dispatch("2115225757", new Object[]{this, view});
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat2.setDuration(500L);
        ofFloat3.setDuration(500L);
        animatorSet.play(ofFloat2).with(ofFloat).with(ofFloat3);
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gotoHomePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091302619")) {
            ipChange.ipc$dispatch("2091302619", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(SplashMainActivity.HOMEPAGE_OUTER_URL, getIntent().getStringExtra(SplashMainActivity.HOMEPAGE_OUTER_URL));
        DMNav.from(this).withExtras(bundle).setTransition(0, 0).toUri(NavUri.b(gr.n));
        finish();
    }

    private void hideGrid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1627905564")) {
            ipChange.ipc$dispatch("-1627905564", new Object[]{this});
            return;
        }
        this.gridView.setVisibility(8);
        if (((ViewGroup) this.gridView.getParent()) != null) {
            ((ViewGroup) this.gridView.getParent()).removeView(this.gridView);
            this.nextPageBtn.setVisibility(8);
        }
    }

    private void initGridView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "257137905")) {
            ipChange.ipc$dispatch("257137905", new Object[]{this});
            return;
        }
        GridView gridView2 = (GridView) findViewById(R$id.guide_gridview);
        this.gridView = gridView2;
        gridView2.setVisibility(0);
        this.gridView.setAdapter((ListAdapter) new GridAdapter(this, new kt0(this), this.itemInfos));
        AnimationStateView animationStateView = (AnimationStateView) findViewById(R$id.guide_nav_header_bg);
        this.mHeadBgImage = animationStateView;
        animationStateView.setImageAssetsFolder("user/images/");
        this.mHeadBgImage.setAnimation("user/lottie_user_home.json");
        this.mHeadBgImage.setAlpha(0.3f);
    }

    private void initTranslucentStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "594083060")) {
            ipChange.ipc$dispatch("594083060", new Object[]{this});
            return;
        }
        Window window = getWindow();
        window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(1024);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(0);
        }
        getWindow().getDecorView().setSystemUiVisibility(9216);
    }

    private boolean invalidCoupons() {
        List<Coupon> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1194933638")) {
            return ((Boolean) ipChange.ipc$dispatch("-1194933638", new Object[]{this})).booleanValue();
        }
        GetCouponResponse getCouponResponse = this.couponResponse;
        if (getCouponResponse == null || (list = getCouponResponse.coupons) == null || list.size() == 0 || this.couponResponse.coupons.get(0) == null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private /* synthetic */ void lambda$bindCouponAndInit$0(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1320177479")) {
            ipChange.ipc$dispatch("-1320177479", new Object[]{this, view});
        } else if (!TextUtils.isEmpty(this.couponResponse.projectSchema)) {
            Bundle bundle = new Bundle();
            bundle.putString(yj1.KEY_DMNAV_PUSH_FLAT, "true");
            DMNav.from(this).stack(Uri.parse("damai://home")).withExtras(bundle).withFlags(268435456).toUri(this.couponResponse.projectSchema);
            finish();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private /* synthetic */ void lambda$initGridView$1(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-762534631")) {
            ipChange.ipc$dispatch("-762534631", new Object[]{this, view});
            return;
        }
        GridAdapter.CardHolder cardHolder = (GridAdapter.CardHolder) view.getTag();
        if (cardHolder.isChecked()) {
            cardHolder.mask.setVisibility(8);
            cardHolder.check.setVisibility(8);
            this.selectIds.remove(cardHolder.id);
        } else {
            cardHolder.mask.setVisibility(0);
            cardHolder.check.setVisibility(0);
            this.selectIds.add(cardHolder.id);
        }
        if (this.selectIds.size() > 0) {
            this.nextPageBtn.setAlpha(1.0f);
            this.nextPageBtn.setClickable(true);
            return;
        }
        this.nextPageBtn.setAlpha(0.5f);
        this.nextPageBtn.setClickable(false);
    }

    private void page1init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-221297044")) {
            ipChange.ipc$dispatch("-221297044", new Object[]{this});
            return;
        }
        TextView textView = (TextView) findViewById(R$id.guide_btn_next);
        this.nextPageBtn = textView;
        textView.setAlpha(0.5f);
        this.nextPageBtn.setOnClickListener(this);
        this.nextPageBtn.setClickable(false);
        this.nextPageBtn.setVisibility(0);
        findViewById(R$id.guide_page_skip).setOnClickListener(this);
        try {
            GuideResponse guideData = ((LauncherApplication) getApplication()).getGuideData();
            if (guideData != null) {
                this.itemInfos = (ArrayList) guideData.categoryList;
                GuidePageUTHelper.getInstance().g(this.nextPageBtn, "step_one", AbstractEditComponent.ReturnTypes.NEXT, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ivLogo = (ImageView) findViewById(R$id.guide_nav_barimage);
        this.ivLogoShadow = (ImageView) findViewById(R$id.guide_nav_barimage2);
        this.tvTitle = (TextView) findViewById(R$id.guide_p1_title1);
        this.tvSubTtle = (TextView) findViewById(R$id.guide_p1_title2);
        this.tvTitleShadow = (TextView) findViewById(R$id.guide_p1_title1shadow);
        this.tvSubTitleShadow = (TextView) findViewById(R$id.guide_p1_title2shadow);
        showTitleAnim1(this.ivLogo);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void refreshCountDown(List<DrawReward> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "918284039")) {
            ipChange.ipc$dispatch("918284039", new Object[]{this, list});
            return;
        }
        for (CouponViewHolder couponViewHolder : this.holders) {
            int checkExsitInfo = checkExsitInfo(couponViewHolder.getCoupon().couponActivityId, list);
            if (checkExsitInfo >= 0) {
                couponViewHolder.a.setVisibility(0);
                DrawReward drawReward = list.get(checkExsitInfo);
                try {
                    couponViewHolder.setTimer(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(drawReward.gmtExpire, new ParsePosition(0)).getTime());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                couponViewHolder.a.setVisibility(8);
            }
        }
    }

    private void requestCoupons() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1706040050")) {
            ipChange.ipc$dispatch("-1706040050", new Object[]{this});
            return;
        }
        GetCouponsRequest getCouponsRequest = new GetCouponsRequest();
        getCouponsRequest.cityId = d20.c();
        getCouponsRequest.request(new DMMtopRequestListener<GetCouponResponse>(GetCouponResponse.class) {
            /* class cn.damai.launcher.splash.GuideActivity.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "739994353")) {
                    ipChange.ipc$dispatch("739994353", new Object[]{this, str, str2});
                    return;
                }
                GuideActivity.this.couponRequestFinished = true;
            }

            public void onSuccess(GetCouponResponse getCouponResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1642459623")) {
                    ipChange.ipc$dispatch("1642459623", new Object[]{this, getCouponResponse});
                    return;
                }
                GuideActivity.this.couponRequestFinished = true;
                GuideActivity.this.couponResponse = getCouponResponse;
            }
        });
    }

    private void requestGetCoupon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "10866463")) {
            ipChange.ipc$dispatch("10866463", new Object[]{this});
        } else if (invalidCoupons()) {
            ToastUtil.a().e(this, "抱歉来晚了～券已经发完了");
            new DelayHandler(this).sendEmptyMessageDelayed(0, 500);
        } else {
            LotteryRequest lotteryRequest = new LotteryRequest();
            lotteryRequest.cityCode = d20.c();
            lotteryRequest.lotteryMixId = this.couponResponse.coupons.get(0).prizePoolSpreadId;
            lotteryRequest.request(new DMMtopRequestListener<LotteryResponse>(LotteryResponse.class) {
                /* class cn.damai.launcher.splash.GuideActivity.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                private void showErrorToast(String str) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "494736969")) {
                        ipChange.ipc$dispatch("494736969", new Object[]{this, str});
                    } else if (GuideActivity.this != null) {
                        ToastUtil.a().e(GuideActivity.this, str);
                        new DelayHandler(GuideActivity.this).sendEmptyMessageDelayed(0, 500);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "732234994")) {
                        ipChange.ipc$dispatch("732234994", new Object[]{this, str, str2});
                        return;
                    }
                    showErrorToast("抱歉来晚了～券已经发完了");
                }

                public void onSuccess(LotteryResponse lotteryResponse) {
                    List<DrawReward> list;
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "752321370")) {
                        ipChange.ipc$dispatch("752321370", new Object[]{this, lotteryResponse});
                    } else if (lotteryResponse == null || TextUtils.isEmpty(lotteryResponse.returnCode)) {
                        showErrorToast("抱歉来晚了～券已经发完了");
                    } else if ("0".equals(lotteryResponse.returnCode)) {
                        LotteryDrawResult lotteryDrawResult = lotteryResponse.returnValue;
                        if (lotteryDrawResult == null || (list = lotteryDrawResult.rewards) == null || list.size() == 0) {
                            showErrorToast("抱歉来晚了～券已经发完了");
                            return;
                        }
                        GuideActivity.this.btnGetCoupon.setBackground(GuideActivity.this.getResources().getDrawable(R$drawable.launcher_guide_gotcoupon));
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        obtain.obj = lotteryResponse;
                        new DelayHandler(GuideActivity.this).sendMessageDelayed(obtain, 200);
                    } else if ("200016".equals(lotteryResponse.returnCode) || "200015".equals(lotteryResponse.returnCode)) {
                        showErrorToast("你已经领取过该券了，快去'我的-优惠券'中使用吧");
                    } else {
                        showErrorToast("抱歉来晚了～券已经发完了");
                    }
                }
            });
            HashMap hashMap = new HashMap();
            hashMap.put("coupon_id", lotteryRequest.lotteryMixId);
            GuidePageUTHelper.getInstance().f("step_two", "get_coupon", hashMap);
        }
    }

    private void saveUserSelect(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1542016146")) {
            ipChange.ipc$dispatch("1542016146", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            SaveUserSelectRequest saveUserSelectRequest = new SaveUserSelectRequest();
            saveUserSelectRequest.categories = str;
            saveUserSelectRequest.request(new DMMtopRequestListener<Object>(Object.class) {
                /* class cn.damai.launcher.splash.GuideActivity.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "747753712")) {
                        ipChange.ipc$dispatch("747753712", new Object[]{this, str, str2});
                        return;
                    }
                    Log.e(GuideActivity.TAG, "SaveUserSelectRequest error:" + str + ",msg:" + str2);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(Object obj) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1247191753")) {
                        ipChange.ipc$dispatch("1247191753", new Object[]{this, obj});
                        return;
                    }
                    Log.e(GuideActivity.TAG, "SaveUserSelectRequest Success ");
                }
            });
        }
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1197051466")) {
            ipChange.ipc$dispatch("-1197051466", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar_gap);
        if (findViewById != null) {
            findViewById.getLayoutParams().height = ne2.a(this);
            findViewById.setVisibility(0);
        }
        initTranslucentStatusBar();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showCoupons() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1217607598")) {
            ipChange.ipc$dispatch("1217607598", new Object[]{this});
            return;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.layout_guide_couponlist);
        this.getCouponList = viewGroup;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            couponAnim(this.getCouponList);
            boolean z = this.couponRequestFinished;
            if (z && this.couponResponse != null) {
                bindCouponAndInit();
            } else if (!z) {
                long currentTimeMillis = System.currentTimeMillis() - this.startTime;
                if (currentTimeMillis < 2000) {
                    this.timerHandler.sendEmptyMessageDelayed(0, currentTimeMillis);
                    this.couponRequestFinished = true;
                }
            } else {
                gotoHomePage();
            }
        }
    }

    private void showPage2() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "202029816")) {
            ipChange.ipc$dispatch("202029816", new Object[]{this});
            return;
        }
        hideGrid();
        showCoupons();
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.mContext).edit();
        edit.putBoolean("KEY_SAVED_USERPREFER" + d20.i(), true).commit();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showPage3() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "202059607")) {
            ipChange.ipc$dispatch("202059607", new Object[]{this});
            return;
        }
        bindGetCouponData();
        this.getCouponList.setVisibility(8);
        findViewById(R$id.layout_guide_projectlist).setVisibility(0);
        showProjects();
        showTitleAnimFlipper(this.ivLogoShadow, R$drawable.launcher_guide_icon_page3, this.tvTitleShadow, R$string.launcher_guide_navtitle_page3, this.tvSubTitleShadow, R$string.launcher_guide_navsubtitle_page3, this.ivLogo, this.tvTitle, this.tvSubTtle);
    }

    private void showProjects() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "702022933")) {
            ipChange.ipc$dispatch("702022933", new Object[]{this});
            return;
        }
        findViewById(R$id.guide_btn_seeyou).setOnClickListener(this);
        GetCouponResponse getCouponResponse = this.couponResponse;
        if (getCouponResponse != null || getCouponResponse.projectDOList == null) {
            if (getCouponResponse.projectDOList.size() > 6) {
                GetCouponResponse getCouponResponse2 = this.couponResponse;
                getCouponResponse2.projectDOList = getCouponResponse2.projectDOList.subList(0, 6);
            }
            LinearLayout linearLayout = (LinearLayout) findViewById(R$id.layout_guide_projectlist_ll);
            int i = 0;
            while (true) {
                if (i < (this.couponResponse.projectDOList.size() <= 3 ? 1 : 2)) {
                    View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.item_discount_near_3_row, (ViewGroup) linearLayout, false);
                    int i2 = i + 1;
                    linearLayout.addView(inflate, i2);
                    AnonymousClass4 r6 = new Column3ProjectViewHolderImpl(inflate) {
                        /* class cn.damai.launcher.splash.GuideActivity.AnonymousClass4 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.category.discountticket.adapter.Column3ProjectViewHolder
                        public void e(View view, ProjectItemBean projectItemBean, int i) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1178427262")) {
                                ipChange.ipc$dispatch("-1178427262", new Object[]{this, view, projectItemBean, Integer.valueOf(i)});
                                return;
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("item_id", projectItemBean.id);
                            GuidePageUTHelper instance = GuidePageUTHelper.getInstance();
                            instance.g(view, "step_three", "item_" + projectItemBean.pos, hashMap);
                        }

                        @Override // cn.damai.category.discountticket.adapter.Column3ProjectViewHolder
                        public void f(ProjectItemBean projectItemBean) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-482219579")) {
                                ipChange.ipc$dispatch("-482219579", new Object[]{this, projectItemBean});
                            } else if (projectItemBean.schema != null) {
                                Bundle bundle = new Bundle();
                                bundle.putString(yj1.KEY_DMNAV_PUSH_FLAT, "true");
                                DMNav.from(GuideActivity.this.mContext).stack(Uri.parse("damai://home")).withExtras(bundle).withFlags(268435456).toUri(projectItemBean.schema);
                                HashMap hashMap = new HashMap();
                                hashMap.put("item_id", projectItemBean.id);
                                GuidePageUTHelper instance = GuidePageUTHelper.getInstance();
                                instance.f("step_three", "item_" + projectItemBean.pos, hashMap);
                                GuideActivity.this.finish();
                            }
                        }
                    };
                    Column3WrapBean column3WrapBean = new Column3WrapBean();
                    ArrayList arrayList = new ArrayList();
                    int i3 = i * 3;
                    if (i3 < this.couponResponse.projectDOList.size()) {
                        this.couponResponse.projectDOList.get(i3).pos = i3;
                        arrayList.add(this.couponResponse.projectDOList.get(i3));
                    }
                    int i4 = i3 + 1;
                    if (i4 < this.couponResponse.projectDOList.size()) {
                        this.couponResponse.projectDOList.get(i4).pos = i4;
                        arrayList.add(this.couponResponse.projectDOList.get(i4));
                    }
                    int i5 = i3 + 2;
                    if (i5 < this.couponResponse.projectDOList.size()) {
                        this.couponResponse.projectDOList.get(i5).pos = i5;
                        arrayList.add(this.couponResponse.projectDOList.get(i5));
                    }
                    column3WrapBean.supply(arrayList);
                    r6.a(column3WrapBean);
                    r6.g(v50.a(inflate.getContext(), 8.0f));
                    i = i2;
                } else {
                    ((TopBottomScrollView) findViewById(R$id.guide_project_scrollview)).setChangedListener(new TopBottomScrollView.IChangedListener() {
                        /* class cn.damai.launcher.splash.GuideActivity.AnonymousClass5 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.launcher.splash.TopBottomScrollView.IChangedListener
                        public void onScrolled() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "789956498")) {
                                ipChange.ipc$dispatch("789956498", new Object[]{this});
                                return;
                            }
                            GuideActivity.this.findViewById(R$id.guide_project_cover_top).setVisibility(0);
                            GuideActivity.this.findViewById(R$id.guide_project_cover_bottom).setVisibility(0);
                            GuideActivity.this.mHeadBgImage.setVisibility(8);
                        }

                        @Override // cn.damai.launcher.splash.TopBottomScrollView.IChangedListener
                        public void onScrolledToBottom() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1465458644")) {
                                ipChange.ipc$dispatch("-1465458644", new Object[]{this});
                                return;
                            }
                            GuideActivity.this.findViewById(R$id.guide_project_cover_top).setVisibility(0);
                            GuideActivity.this.findViewById(R$id.guide_project_cover_bottom).setVisibility(8);
                        }

                        @Override // cn.damai.launcher.splash.TopBottomScrollView.IChangedListener
                        public void onScrolledToTop() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-668986754")) {
                                ipChange.ipc$dispatch("-668986754", new Object[]{this});
                                return;
                            }
                            GuideActivity.this.findViewById(R$id.guide_project_cover_top).setVisibility(8);
                            GuideActivity.this.findViewById(R$id.guide_project_cover_bottom).setVisibility(0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void showTitleAnim1(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1277437419")) {
            ipChange.ipc$dispatch("1277437419", new Object[]{this, view});
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", (float) view.getHeight(), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "rotation", 7.0f, -7.0f);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(5);
        ofFloat2.setDuration(200L);
        animatorSet.play(ofFloat2).after(ofFloat);
        animatorSet.setStartDelay(200);
        animatorSet.start();
        this.tvTitleShadow.setVisibility(0);
        this.tvSubTitleShadow.setVisibility(0);
    }

    private void showTitleAnimFlipper(ImageView imageView, int i, TextView textView, int i2, TextView textView2, int i3, ImageView imageView2, TextView textView3, TextView textView4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2141702055")) {
            ipChange.ipc$dispatch("-2141702055", new Object[]{this, imageView, Integer.valueOf(i), textView, Integer.valueOf(i2), textView2, Integer.valueOf(i3), imageView2, textView3, textView4});
            return;
        }
        imageView.setImageDrawable(getResources().getDrawable(i));
        textView.setText(getResources().getString(i2));
        textView2.setText(getResources().getString(i3));
        changeTitleLogoAnim(imageView2, imageView);
        changeTitleLogoAnim(textView3, textView);
        changeTitleLogoAnim(textView4, textView2);
    }

    public int checkExsitInfo(String str, List<DrawReward> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-372021975")) {
            return ((Integer) ipChange.ipc$dispatch("-372021975", new Object[]{this, str, list})).intValue();
        }
        for (int i = 0; i < list.size(); i++) {
            String str2 = list.get(i).rewardId;
            if (str2 != null && str2.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1818472153")) {
            ipChange.ipc$dispatch("1818472153", new Object[]{this});
            return;
        }
        overridePendingTransition(0, R$anim.activity_launcher_bottom_out);
        super.finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "363502518")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("363502518", new Object[]{this})).intValue();
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1274583906")) {
            ipChange.ipc$dispatch("1274583906", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-536917827")) {
            ipChange.ipc$dispatch("-536917827", new Object[]{this, view});
        } else if (view.getId() == R$id.guide_btn_next) {
            String replace = this.selectIds.toString().replace(jl1.ARRAY_START_STR, "").replace(jl1.ARRAY_END_STR, "").replace(" ", "");
            saveUserSelect(replace);
            HashMap hashMap = new HashMap();
            hashMap.put("item", replace);
            GuidePageUTHelper.getInstance().f("step_one", AbstractEditComponent.ReturnTypes.NEXT, hashMap);
            showPage2();
            showTitleAnimFlipper(this.ivLogoShadow, R$drawable.launcher_guide_icon_page2, this.tvTitleShadow, R$string.launcher_guide_navtitle_page2, this.tvSubTitleShadow, R$string.launcher_guide_navsubtitle_page2, this.ivLogo, this.tvTitle, this.tvSubTtle);
        } else if (view.getId() == R$id.guide_page_skip) {
            if (this.gridView.getVisibility() == 0) {
                showPage2();
                showTitleAnimFlipper(this.ivLogoShadow, R$drawable.launcher_guide_icon_page2_skip, this.tvTitleShadow, R$string.launcher_guide_navtitle_page2_skip, this.tvSubTitleShadow, R$string.launcher_guide_navsubtitle_page2_skip, this.ivLogo, this.tvTitle, this.tvSubTtle);
                GuidePageUTHelper.getInstance().f("step_one", "pass", null);
                return;
            }
            gotoHomePage();
            if (this.getCouponList.getVisibility() == 0) {
                GuidePageUTHelper.getInstance().f("step_two", "pass", null);
            } else {
                GuidePageUTHelper.getInstance().f("step_three", "pass", null);
            }
        } else if (view.getId() == R$id.guide_btn_getcoupon) {
            requestGetCoupon();
        } else if (view.getId() == R$id.guide_btn_seeyou) {
            gotoHomePage();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1458175043")) {
            ipChange.ipc$dispatch("1458175043", new Object[]{this, bundle});
            return;
        }
        overridePendingTransition(R$anim.activity_launcher_bottom_in, 0);
        super.onCreate(bundle);
        a.b g = LauncherUTHelper.getInstance().g(GuidePageUTHelper.GUIDE_PAGE);
        this.builder = g;
        setDamaiUTKeyBuilder(g);
        c.e().K(this);
        setContentView(R$layout.damai_launcher_activity_guide);
        g91.b("GuideTActivityTAG", "GuideTActivityTAG onCreate!");
        hideBaseLayout();
        setImmersionStyle();
        requestCoupons();
        this.startTime = System.currentTimeMillis();
        page1init();
        ArrayList<ItemInfo> arrayList = this.itemInfos;
        if (arrayList == null || arrayList.size() <= 0) {
            gotoHomePage();
        } else {
            initGridView();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "701272131")) {
            ipChange.ipc$dispatch("701272131", new Object[]{this});
            return;
        }
        ((LauncherApplication) getApplication()).setGuideData(null);
        super.onDestroy();
        TimeHandler timeHandler = this.timerHandler;
        if (timeHandler != null) {
            timeHandler.removeMessages(0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-802239574")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-802239574", new Object[]{this});
    }
}
