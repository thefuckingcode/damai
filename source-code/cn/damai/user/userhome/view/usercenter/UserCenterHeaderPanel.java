package cn.damai.user.userhome.view.usercenter;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.login.LoginManager;
import cn.damai.uikit.util.DialogUtil;
import cn.damai.uikit.view.avatar.AvatarConfig;
import cn.damai.uikit.view.avatar.AvatarView;
import cn.damai.user.userhome.bean.UserHomeDataBean;
import cn.damai.user.userhome.bean.UserInfoBean;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import tb.d20;
import tb.ft2;
import tb.lk1;
import tb.n42;
import tb.s72;
import tb.ti1;
import tb.tu0;
import tb.xf2;
import tb.xs0;

/* compiled from: Taobao */
public class UserCenterHeaderPanel implements View.OnClickListener, HeaderUiController, Runnable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DEFAULT_BG_URL = "DEFAULT_BG_URL";
    private final boolean isMineTab;
    private View mAchieveLayout;
    private TextView mAchieveTv;
    private Activity mActivity;
    private AttentionView mAttentionView;
    private View mAuthLayout;
    private RealNameAuthStatusBean mAuthStatusBean;
    private AvatarView mAvatar;
    private LottieAnimationView mAvatarLottieView;
    private ViewGroup mDescLayout;
    private View mDnaArrow;
    private View mDnaUi;
    private TextView mDnaValueTv;
    private View mEditBtn;
    private TextView mFansCountTv;
    private TextView mFocusCountTv;
    private View mGoLoginTip;
    private View mHeadBgImgClickArea;
    private ImageView mHeaderBgImg;
    private View mHeaderInfoLayout;
    private UserHomeDataBean mHomeDataBean;
    private TextView mIpInfoTv;
    private View mIpLayout;
    private TextView mNameAuthTv;
    private View mOldMemberTag;
    private ValueAnimator mShowDnaAnimator;
    private String mShowingBackGUrl;
    private TextView mUserDescTv;
    private TextView mUserNameTv;
    private ImageView mUserTypeTagImg;
    private ti1 mUtListener;
    private TextView mVerifyTv;
    private TextView mZanCountTv;

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        a(UserCenterHeaderPanel userCenterHeaderPanel, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1761403312")) {
                ipChange.ipc$dispatch("1761403312", new Object[]{this, eVar});
            } else if (eVar != null && (drawable = eVar.a) != null) {
                int i = -2;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > 0) {
                    i = (int) (((float) (intrinsicWidth * n42.a(xs0.a(), 16.0f))) / ((float) intrinsicHeight));
                }
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                if (!(layoutParams == null || layoutParams.width == i)) {
                    layoutParams.width = i;
                    this.a.requestLayout();
                }
                this.a.setImageDrawable(drawable);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1591026013")) {
                ipChange.ipc$dispatch("1591026013", new Object[]{this, dVar});
                return;
            }
            UserCenterHeaderPanel.this.mHeaderBgImg.setImageResource(R$drawable.user_center_header_default);
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "545249586")) {
                ipChange.ipc$dispatch("545249586", new Object[]{this, eVar});
            } else if (eVar == null || eVar.a == null) {
                UserCenterHeaderPanel.this.mHeaderBgImg.setImageResource(R$drawable.user_center_header_default);
            } else {
                UserCenterHeaderPanel.this.mShowingBackGUrl = this.a;
                UserCenterHeaderPanel.this.mHeaderBgImg.setImageDrawable(eVar.a);
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d(UserCenterHeaderPanel userCenterHeaderPanel) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1169455105")) {
                ipChange.ipc$dispatch("1169455105", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1856362442")) {
                ipChange.ipc$dispatch("-1856362442", new Object[]{this, valueAnimator});
                return;
            }
            UserCenterHeaderPanel.this.mDnaUi.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public UserCenterHeaderPanel(Activity activity, View view, boolean z, HeadUserTrackListener headUserTrackListener) {
        ti1 ti1 = new ti1();
        this.mUtListener = ti1;
        this.isMineTab = z;
        this.mActivity = activity;
        ti1.a(headUserTrackListener);
        View findViewById = view.findViewById(R$id.user_center_header_id);
        this.mHeaderBgImg = (ImageView) findViewById.findViewById(R$id.user_center_header_bg_img);
        this.mHeadBgImgClickArea = findViewById.findViewById(R$id.user_center_header_bg_click_area);
        this.mHeaderInfoLayout = findViewById.findViewById(R$id.user_center_header_info_layout);
        this.mUserNameTv = (TextView) findViewById.findViewById(R$id.user_center_header_user_name);
        this.mUserTypeTagImg = (ImageView) findViewById.findViewById(R$id.user_center_user_type_tag);
        this.mOldMemberTag = findViewById.findViewById(R$id.user_center_damai_old_member_tag);
        this.mDescLayout = (ViewGroup) findViewById.findViewById(R$id.user_center_header_user_desc_layout);
        this.mUserDescTv = (TextView) findViewById.findViewById(R$id.user_center_header_user_desc);
        this.mAuthLayout = findViewById.findViewById(R$id.user_center_header_real_name_auth_layout);
        this.mNameAuthTv = (TextView) findViewById.findViewById(R$id.user_center_header_real_name_auth_status);
        this.mVerifyTv = (TextView) findViewById.findViewById(R$id.user_center_header_verify_status);
        View findViewById2 = findViewById.findViewById(R$id.user_center_header_focus_count_ui);
        this.mFocusCountTv = (TextView) findViewById.findViewById(R$id.user_center_header_focus_count);
        View findViewById3 = findViewById.findViewById(R$id.user_center_header_fans_count_ui);
        this.mFansCountTv = (TextView) findViewById.findViewById(R$id.user_center_header_fans_count);
        View findViewById4 = findViewById.findViewById(R$id.user_center_header_zan_count_ui);
        this.mZanCountTv = (TextView) findViewById.findViewById(R$id.user_center_header_zan_count);
        this.mAchieveLayout = findViewById.findViewById(R$id.user_center_header_achievement_layout);
        this.mAchieveTv = (TextView) findViewById.findViewById(R$id.user_center_header_achievement_tv);
        this.mAvatarLottieView = (LottieAnimationView) findViewById.findViewById(R$id.user_center_header_lottie);
        this.mAvatar = (AvatarView) findViewById.findViewById(R$id.user_center_header_avatar_view);
        this.mAttentionView = (AttentionView) findViewById.findViewById(R$id.user_center_header_follow_btn);
        this.mEditBtn = findViewById.findViewById(R$id.user_center_header_edit);
        this.mDnaUi = findViewById.findViewById(R$id.user_center_dna_ui);
        this.mDnaValueTv = (TextView) findViewById.findViewById(R$id.user_center_dna_value);
        this.mDnaArrow = findViewById.findViewById(R$id.user_center_dna_arrow);
        this.mGoLoginTip = findViewById.findViewById(R$id.user_center_go_login_tip);
        View findViewById5 = findViewById.findViewById(R$id.user_info_back_g);
        this.mIpLayout = findViewById.findViewById(R$id.user_center_header_ip_layout);
        this.mIpInfoTv = (TextView) findViewById.findViewById(R$id.user_center_header_ip_info);
        this.mAttentionView.setBackGroundState(R$drawable.uikit_attention_btn_followed, R$drawable.uikit_attention_btn_un_follow);
        this.mAttentionView.setTextColorState(R$color.color_9C9CA5, R$color.white);
        this.mAvatar.setOnClickListener(this);
        this.mDnaUi.setOnClickListener(this);
        this.mEditBtn.setOnClickListener(this);
        this.mHeadBgImgClickArea.setOnClickListener(this);
        this.mAuthLayout.setOnClickListener(this);
        this.mGoLoginTip.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById3.setOnClickListener(this);
        findViewById4.setOnClickListener(this);
        findViewById5.setOnClickListener(this);
        this.mIpLayout.setOnClickListener(this);
        showEmptyHeadView(ModeEmpty.EMPTY_DEFAULT);
    }

    private void loadImgViewAndResize(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "242400326")) {
            ipChange.ipc$dispatch("242400326", new Object[]{this, str, imageView});
            return;
        }
        cn.damai.common.image.a.b().c(str).n(new a(this, imageView)).f();
    }

    private void setHeaderInfoLayoutMarginTop(boolean z) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1305434839")) {
            ipChange.ipc$dispatch("-1305434839", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        int a2 = n42.a(xs0.a(), 22.0f);
        if (!z) {
            i = n42.a(xs0.a(), 97.0f);
        } else {
            i = n42.a(xs0.a(), 138.0f);
        }
        ViewGroup.LayoutParams layoutParams = this.mHeaderInfoLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                this.mHeaderInfoLayout.requestLayout();
            }
        }
        ViewGroup.LayoutParams layoutParams2 = this.mHeadBgImgClickArea.getLayoutParams();
        int i2 = a2 + i;
        if (layoutParams2 != null && layoutParams2.height != i2) {
            layoutParams2.height = i2;
            this.mHeadBgImgClickArea.requestLayout();
        }
    }

    private void setUpAvatarBgLottieView(UserHomeDataBean userHomeDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529862264")) {
            ipChange.ipc$dispatch("-529862264", new Object[]{this, userHomeDataBean});
        } else if (this.mAvatarLottieView.getTag() == null) {
            if (TextUtils.isEmpty(userHomeDataBean.getMyHeadAreaBgImg()) && LoginManager.k().q()) {
                this.mAvatarLottieView.setTag(1);
                this.mAvatarLottieView.setRepeatCount(1);
                this.mAvatarLottieView.setVisibility(0);
                this.mAvatarLottieView.postDelayed(new Runnable() {
                    /* class cn.damai.user.userhome.view.usercenter.UserCenterHeaderPanel.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1235190567")) {
                            ipChange.ipc$dispatch("1235190567", new Object[]{this});
                            return;
                        }
                        UserCenterHeaderPanel.this.mAvatarLottieView.setVisibility(8);
                    }
                }, 1500);
            }
        }
    }

    private void setUpAvatarView(UserInfoBean userInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1928844999")) {
            ipChange.ipc$dispatch("1928844999", new Object[]{this, userInfoBean});
            return;
        }
        AvatarConfig createConfig = UserInfoBean.createConfig(userInfoBean);
        createConfig.clearDrawableWhenDiffUrlSet = false;
        this.mAvatar.update(createConfig, userInfoBean.getImgUrl());
    }

    private void setUpDnaLayoutIfAllow(UserHomeDataBean userHomeDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-670483681")) {
            ipChange.ipc$dispatch("-670483681", new Object[]{this, userHomeDataBean});
            return;
        }
        String dnaSimilar = userHomeDataBean.getDnaSimilar();
        String goDnaUrl = userHomeDataBean.getGoDnaUrl();
        int i = (int) lk1.i(dnaSimilar, 0.0f);
        int i2 = 4;
        if (this.isMineTab || userHomeDataBean.isMySelf() || i <= 0) {
            this.mDnaUi.setVisibility(4);
            return;
        }
        this.mUtListener.onExposeDnaLayout(this.mDnaUi);
        View view = this.mDnaArrow;
        if (!TextUtils.isEmpty(goDnaUrl)) {
            i2 = 0;
        }
        view.setVisibility(i2);
        this.mDnaValueTv.setText(i + "%");
        if (this.mDnaUi.getTag() == null) {
            this.mDnaUi.setTag(1);
            this.mDnaUi.postDelayed(this, 500);
            return;
        }
        ValueAnimator valueAnimator = this.mShowDnaAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mDnaUi.removeCallbacks(this);
        this.mDnaUi.scrollTo(0, 0);
        this.mDnaUi.setVisibility(0);
    }

    private void setUpUserDescLayout(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-721108550")) {
            ipChange.ipc$dispatch("-721108550", new Object[]{this, str, str2, str3});
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            this.mDescLayout.setVisibility(0);
            if (TextUtils.isEmpty(str)) {
                this.mAuthLayout.setVisibility(8);
            } else {
                this.mAuthLayout.setVisibility(0);
                this.mNameAuthTv.setText(str);
            }
            if (TextUtils.isEmpty(str2)) {
                this.mVerifyTv.setVisibility(8);
            } else {
                this.mVerifyTv.setVisibility(0);
                this.mVerifyTv.setText(str2);
            }
            if (TextUtils.isEmpty(str3)) {
                this.mUserDescTv.setVisibility(8);
                return;
            }
            this.mUserDescTv.setVisibility(0);
            this.mUserDescTv.setText(str3);
        } else {
            this.mDescLayout.setVisibility(8);
        }
    }

    private void setUserHeadBackgroundView(String str, String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "472436723")) {
            ipChange.ipc$dispatch("472436723", new Object[]{this, str, str2});
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            z = false;
        }
        setHeaderInfoLayoutMarginTop(z);
        if (TextUtils.isEmpty(str)) {
            str = !TextUtils.isEmpty(str2) ? str2 : DEFAULT_BG_URL;
        }
        if (!TextUtils.equals(this.mShowingBackGUrl, str)) {
            if (TextUtils.equals(DEFAULT_BG_URL, str)) {
                this.mShowingBackGUrl = str;
                this.mHeaderBgImg.setImageResource(R$drawable.user_center_header_default);
                return;
            }
            cn.damai.common.image.a.b().c(str).n(new c(str)).e(new b()).f();
        }
    }

    private void setUserTypeTagView(UserInfoBean userInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2005865590")) {
            ipChange.ipc$dispatch("2005865590", new Object[]{this, userInfoBean});
        } else if (userInfoBean.userTypeCode == 2) {
            this.mUserTypeTagImg.setVisibility(8);
        } else {
            String str = userInfoBean.userTypeIcon;
            if (TextUtils.isEmpty(str)) {
                this.mUserTypeTagImg.setVisibility(8);
                return;
            }
            this.mUserTypeTagImg.setVisibility(0);
            loadImgViewAndResize(str, this.mUserTypeTagImg);
        }
    }

    private void showIPExplainDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "68010628")) {
            ipChange.ipc$dispatch("68010628", new Object[]{this});
        } else if (!this.mActivity.isFinishing()) {
            new DMDialog(this.mActivity).v("IP属地说明").q("为维护网络安全、保障良好生态和社区的真实性，根据网络运营商数据，展示用户IP属地信息。").n("我知道了", new d(this)).show();
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.GetAttentionView
    public AttentionView getAttentionView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2004122021")) {
            return this.mAttentionView;
        }
        return (AttentionView) ipChange.ipc$dispatch("2004122021", new Object[]{this});
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void hideRealNameAuthView() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1014342643")) {
            ipChange.ipc$dispatch("1014342643", new Object[]{this});
            return;
        }
        this.mAuthLayout.setVisibility(8);
        int childCount = this.mDescLayout.getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                z = false;
                break;
            } else if (this.mDescLayout.getChildAt(i2).getVisibility() == 0) {
                break;
            } else {
                i2++;
            }
        }
        ViewGroup viewGroup = this.mDescLayout;
        if (!z) {
            i = 8;
        }
        viewGroup.setVisibility(i);
    }

    public void onClick(View view) {
        Activity activity;
        RealNameAuthStatusBean realNameAuthStatusBean;
        String str;
        String str2;
        String str3;
        IpChange ipChange = $ipChange;
        boolean z = false;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-2124076388")) {
            ipChange.ipc$dispatch("-2124076388", new Object[]{this, view});
        } else if (!s72.c() && (activity = this.mActivity) != null && !activity.isFinishing()) {
            if (this.isMineTab && !LoginManager.k().q()) {
                this.mUtListener.onUtOpenLoginPageClick();
                LoginManager.k().v(this.mActivity);
            } else if (this.mHomeDataBean != null) {
                int id = view.getId();
                if (id == R$id.user_center_header_avatar_view) {
                    this.mUtListener.onUtHeadAvatarClick();
                    if (this.isMineTab) {
                        tu0.f(this.mActivity, tu0.b(this.mHomeDataBean));
                    } else {
                        tu0.g(this.mActivity, tu0.b(this.mHomeDataBean));
                    }
                } else if (id == R$id.user_center_header_bg_click_area) {
                    if (this.isMineTab) {
                        this.mUtListener.onUtHeadBackImgClick();
                        tu0.j(this.mActivity, tu0.c(this.mHomeDataBean));
                    }
                } else if (id == R$id.user_center_dna_ui) {
                    if (this.mDnaUi.getVisibility() == 0) {
                        String goDnaUrl = this.mHomeDataBean.getGoDnaUrl();
                        if (TextUtils.isEmpty(goDnaUrl)) {
                            this.mUtListener.onUtDNAViewClick(false);
                            final Dialog b2 = DialogUtil.b(this.mActivity);
                            b2.show();
                            this.mDnaUi.postDelayed(new Runnable() {
                                /* class cn.damai.user.userhome.view.usercenter.UserCenterHeaderPanel.AnonymousClass5 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                public void run() {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "449136547")) {
                                        ipChange.ipc$dispatch("449136547", new Object[]{this});
                                    } else if (b2.isShowing()) {
                                        b2.dismiss();
                                    }
                                }
                            }, DanmakuFactory.MIN_DANMAKU_DURATION);
                            return;
                        }
                        this.mUtListener.onUtDNAViewClick(true);
                        DMNav.from(this.mActivity).toUri(goDnaUrl);
                    }
                } else if (id != R$id.user_center_header_edit) {
                    String str4 = null;
                    if (id == R$id.user_center_header_focus_count_ui) {
                        if (this.isMineTab || this.mHomeDataBean.isMySelf()) {
                            z = true;
                        }
                        if (this.isMineTab) {
                            str3 = d20.i();
                        } else {
                            UserInfoBean userInfo = this.mHomeDataBean.getUserInfo();
                            if (userInfo != null) {
                                str4 = userInfo.havanaIdStr;
                            }
                            str3 = str4;
                        }
                        this.mUtListener.onUtOpenRelateInfoClick("follow_btn");
                        tu0.i(this.mActivity, str3, z);
                    } else if (id == R$id.user_center_header_fans_count_ui) {
                        if (this.isMineTab) {
                            str2 = d20.i();
                        } else {
                            UserInfoBean userInfo2 = this.mHomeDataBean.getUserInfo();
                            if (userInfo2 != null) {
                                str4 = userInfo2.havanaIdStr;
                            }
                            str2 = str4;
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            this.mUtListener.onUtOpenRelateInfoClick("fans");
                            if (this.isMineTab || this.mHomeDataBean.isMySelf()) {
                                z = true;
                            }
                            tu0.h(this.mActivity, str2, z);
                        }
                    } else if (id == R$id.user_center_header_zan_count_ui) {
                        if (this.isMineTab) {
                            str = d20.i();
                        } else {
                            UserInfoBean userInfo3 = this.mHomeDataBean.getUserInfo();
                            if (userInfo3 != null) {
                                str4 = userInfo3.havanaIdStr;
                            }
                            z2 = this.mHomeDataBean.isMySelf();
                            str = str4;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            this.mUtListener.onUtOpenRelateInfoClick("thumb");
                            tu0.l(this.mActivity, str, z2);
                        }
                    } else if (id == R$id.user_center_header_real_name_auth_layout) {
                        if (this.isMineTab && (realNameAuthStatusBean = this.mAuthStatusBean) != null) {
                            this.mUtListener.onUtOpenRealNameAuthClick(realNameAuthStatusBean);
                            tu0.e(this.mActivity, this.mAuthStatusBean);
                        }
                    } else if (id == R$id.user_center_header_ip_layout) {
                        showIPExplainDialog();
                    }
                } else if (this.isMineTab) {
                    this.mUtListener.onUtOpenUserInfoEditClick();
                    tu0.k(this.mActivity, this.mHomeDataBean.getUserInfo());
                }
            }
        }
    }

    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45115244")) {
            ipChange.ipc$dispatch("-45115244", new Object[]{this});
            return;
        }
        int measuredWidth = this.mDnaUi.getMeasuredWidth();
        this.mDnaUi.scrollTo(measuredWidth, 0);
        this.mDnaUi.setVisibility(0);
        ValueAnimator ofInt = ValueAnimator.ofInt(measuredWidth, 0);
        this.mShowDnaAnimator = ofInt;
        ofInt.setDuration(300L);
        this.mShowDnaAnimator.setInterpolator(new LinearInterpolator());
        this.mShowDnaAnimator.addUpdateListener(new e());
        this.mShowDnaAnimator.start();
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void setBGAtmosphereUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1588816751")) {
            ipChange.ipc$dispatch("1588816751", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            setUserHeadBackgroundView(str, null);
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void setUserAvatarUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042811980")) {
            ipChange.ipc$dispatch("1042811980", new Object[]{this, str});
            return;
        }
        this.mAvatar.setAvatarUrl(str);
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void setUserNickView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494293524")) {
            ipChange.ipc$dispatch("1494293524", new Object[]{this, str});
        } else if (!xf2.j(str)) {
            if (str.length() > 12) {
                str = str.substring(0, 12) + (char) 8230;
            }
            this.mUserNameTv.setText(str);
        } else {
            this.mUserNameTv.setText("");
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void showEmptyHeadView(ModeEmpty modeEmpty) {
        AvatarConfig avatarConfig;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-552911632")) {
            ipChange.ipc$dispatch("-552911632", new Object[]{this, modeEmpty});
            return;
        }
        if (modeEmpty == ModeEmpty.NONE_LOGIN) {
            avatarConfig = AvatarConfig.mineTabNoneLoginConfig();
            this.mGoLoginTip.setVisibility(0);
            str = "HI~欢迎来到大麦";
        } else {
            avatarConfig = AvatarConfig.defaultConfig();
            this.mGoLoginTip.setVisibility(8);
            str = "";
        }
        this.mAvatar.update(avatarConfig, null);
        this.mUserNameTv.setText(str);
        this.mFocusCountTv.setText("0");
        this.mZanCountTv.setText("0");
        this.mFansCountTv.setText("0");
        this.mAttentionView.setVisibility(8);
        this.mEditBtn.setVisibility(8);
        this.mDnaUi.setVisibility(4);
        this.mDescLayout.setVisibility(8);
        this.mUserTypeTagImg.setVisibility(8);
        this.mOldMemberTag.setVisibility(8);
        this.mAchieveLayout.setVisibility(8);
        this.mIpLayout.setVisibility(8);
        setUserHeadBackgroundView(null, null);
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void update(UserHomeDataBean userHomeDataBean, RealNameAuthStatusBean realNameAuthStatusBean) {
        String str;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1685206153")) {
            ipChange.ipc$dispatch("-1685206153", new Object[]{this, userHomeDataBean, realNameAuthStatusBean});
            return;
        }
        this.mHomeDataBean = userHomeDataBean;
        this.mAuthStatusBean = realNameAuthStatusBean;
        if (userHomeDataBean == null || userHomeDataBean.getUserInfo() == null) {
            showEmptyHeadView(ModeEmpty.EMPTY_DEFAULT);
            return;
        }
        this.mGoLoginTip.setVisibility(8);
        this.mFocusCountTv.setText(ft2.a(userHomeDataBean.getMyFollowCount()));
        this.mFansCountTv.setText(ft2.a(userHomeDataBean.getFansCount()));
        this.mZanCountTv.setText(ft2.a(userHomeDataBean.getPraiseWantCount()));
        this.mAchieveLayout.setVisibility(8);
        UserInfoBean userInfo = userHomeDataBean.getUserInfo();
        setUserNickView(userInfo.userNick);
        setUserHeadBackgroundView(userHomeDataBean.getMyHeadAreaBgImg(), userInfo.headBgImg);
        String str2 = TextUtils.isEmpty(userInfo.userIntro) ? "在大麦，记录我的精彩" : userInfo.userIntro;
        String str3 = null;
        if (this.isMineTab) {
            str = userInfo.getUserNickStatus();
            if (realNameAuthStatusBean != null) {
                int accountVerifyCode = realNameAuthStatusBean.getAccountVerifyCode();
                if (accountVerifyCode == 1) {
                    str3 = "完善实名认证";
                } else if (accountVerifyCode == 5) {
                    str3 = "实名认证失败";
                }
            }
        } else {
            str = null;
        }
        setUpUserDescLayout(str3, str, str2);
        setUpAvatarView(userInfo);
        setUserTypeTagView(userInfo);
        setUpDnaLayoutIfAllow(userHomeDataBean);
        setUpAvatarBgLottieView(userHomeDataBean);
        this.mEditBtn.setVisibility(this.isMineTab ? 0 : 8);
        if (this.isMineTab || userHomeDataBean.isMySelf()) {
            z = false;
        }
        this.mAttentionView.setVisibility(z ? 0 : 8);
        this.mOldMemberTag.setVisibility(userHomeDataBean.isVip() ? 0 : 8);
        if (TextUtils.isEmpty(userInfo.region)) {
            this.mIpLayout.setVisibility(8);
            return;
        }
        this.mIpLayout.setVisibility(0);
        this.mIpInfoTv.setText("IP归属地：" + userInfo.region);
    }
}
