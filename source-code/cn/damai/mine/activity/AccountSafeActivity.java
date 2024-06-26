package cn.damai.mine.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.model.CertificationInfoBean;
import cn.damai.commonbusiness.model.UserBaseInfoBean;
import cn.damai.commonbusiness.model.UserData;
import cn.damai.commonbusiness.model.UserMemberInfo;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.im.UserInfoUtil;
import cn.damai.im.request.PersonalInfoRequest;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.HavanaProxy;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.wxapi.WXEntryActivity;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.MemberCallback;
import com.ali.user.open.ucc.UccService;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.sns4android.SNSAuth;
import com.taobao.android.sns4android.bind.SNSBind;
import com.taobao.login4android.session.SessionManager;
import com.tencent.tauth.Tencent;
import tb.bk2;
import tb.d20;
import tb.gr;
import tb.h03;
import tb.ls0;
import tb.ne2;
import tb.vf1;
import tb.xd1;
import tb.yd1;

/* compiled from: Taobao */
public class AccountSafeActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private RelativeLayout accountSettingly;
    RelativeLayout accountUnRegister;
    private CertificationInfoBean certificationInfoBean;
    private ImageView icon_real;
    private RelativeLayout mMemberLayout;
    private View mMemberLine;
    private TextView mMemberStatus;
    private TextView mMemberTip;
    private TextView mMemberTitle;
    private TextView mTitleTV;
    private DMIconFontTextView mTvTitleBack;
    private UserData mUserData;
    RelativeLayout ray_bind_phone;
    RelativeLayout ray_login_pw;
    RelativeLayout ray_pay_pw;
    private RelativeLayout realNameLayout;
    private TextView tv_email;
    private TextView tv_phone;
    private TextView tv_real_name;

    /* compiled from: Taobao */
    public class a implements UserInfoUtil.OnUserInfoListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.im.UserInfoUtil.OnUserInfoListener
        public void onFailed(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1450171364")) {
                ipChange.ipc$dispatch("1450171364", new Object[]{this, str, str2});
            } else if (!TextUtils.isEmpty(str2)) {
                AccountSafeActivity.this.accountSettingly.setTag(null);
                ToastUtil.i(str2);
            }
        }

        @Override // cn.damai.im.UserInfoUtil.OnUserInfoListener
        public void onSuccess(UserData userData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-603518075")) {
                ipChange.ipc$dispatch("-603518075", new Object[]{this, userData});
                return;
            }
            AccountSafeActivity.this.fetchUserDataSuccess(userData);
        }
    }

    /* compiled from: Taobao */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "12256049")) {
                ipChange.ipc$dispatch("12256049", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            cn.damai.common.user.c.e().x(yd1.x().l());
            AccountSafeActivity.this.setTencentPermissionAndOpenAuth();
        }
    }

    /* compiled from: Taobao */
    public class c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c(AccountSafeActivity accountSafeActivity) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "981837072")) {
                ipChange.ipc$dispatch("981837072", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            cn.damai.common.user.c.e().x(yd1.x().k());
        }
    }

    /* compiled from: Taobao */
    public class d implements MemberCallback<String> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        /* renamed from: a */
        public void onSuccess(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1983051393")) {
                ipChange.ipc$dispatch("1983051393", new Object[]{this, str});
                return;
            }
            SessionManager instance = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
            if (instance == null || TextUtils.isEmpty(instance.getUserId())) {
                AccountSafeActivity.newManageUrl(str, this.a);
                return;
            }
            try {
                AccountSafeActivity.newManageUrl(str, this.a);
            } catch (Throwable th) {
                th.printStackTrace();
                AccountSafeActivity.newManageUrl(str, this.a);
            }
        }

        @Override // com.ali.user.open.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1485975939")) {
                ipChange.ipc$dispatch("-1485975939", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            SNSAuth.toastBusy(str);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fetchUserDataSuccess(UserData userData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782473494")) {
            ipChange.ipc$dispatch("782473494", new Object[]{this, userData});
            return;
        }
        CertificationInfoBean certificationBaseInfo = userData.getCertificationBaseInfo();
        UserBaseInfoBean userBaseInfo = userData.getUserBaseInfo();
        UserMemberInfo memberInfo = userData.getMemberInfo();
        if (memberInfo != null) {
            this.accountSettingly.setTag(memberInfo.getThirdConfigDialogTip());
            this.mMemberLayout.setVisibility(0);
            this.mMemberLine.setVisibility(0);
            this.mMemberTitle.setText(getMemberContent(memberInfo.getMemberTitle(), "淘麦VIP会员"));
            this.mMemberStatus.setText(getMemberContent(memberInfo.getMemberStatusDesc(), ""));
            this.mMemberTip.setText(getMemberContent(memberInfo.getMemberTip(), ""));
            findViewById(R$id.rv_max_vip).setOnClickListener(this);
            yd1.x().n0(this.mMemberTitle);
        }
        if (certificationBaseInfo != null && userBaseInfo != null) {
            this.certificationInfoBean = certificationBaseInfo;
            this.mUserData = userData;
            if (!TextUtils.isEmpty(userBaseInfo.getMaskMobile())) {
                this.tv_phone.setText(userBaseInfo.getMaskMobile());
            }
            if (!TextUtils.isEmpty(certificationBaseInfo.getAccountVerifyMsg())) {
                this.tv_real_name.setText(certificationBaseInfo.getAccountVerifyMsg());
            }
            if (!TextUtils.isEmpty(userBaseInfo.getMaskEmail())) {
                this.tv_email.setText(userBaseInfo.getMaskEmail());
            } else {
                this.tv_email.setText("设置邮箱");
            }
            int parseInt = Integer.parseInt(certificationBaseInfo.getAccountVerifyCode());
            if (parseInt == 1) {
                this.icon_real.setImageResource(R$drawable.realname_noauth);
                this.icon_real.setVisibility(0);
            } else if (parseInt == 2) {
                this.icon_real.setImageResource(R$drawable.realname_auth_success);
                this.icon_real.setVisibility(0);
            } else if (parseInt == 3) {
                this.icon_real.setImageResource(R$drawable.realname_gotoauthface);
                this.icon_real.setVisibility(0);
            } else if (parseInt == 4) {
                this.icon_real.setImageResource(R$drawable.realname_verifing);
                this.icon_real.setVisibility(0);
            } else if (parseInt == 5) {
                this.icon_real.setImageResource(R$drawable.realname_auth_failed);
                this.icon_real.setVisibility(0);
            }
        }
    }

    private void getAuthStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "460944507")) {
            ipChange.ipc$dispatch("460944507", new Object[]{this});
        } else if (LoginManager.k().q()) {
            PersonalInfoRequest personalInfoRequest = new PersonalInfoRequest();
            personalInfoRequest.needUserBaseInfo = "true";
            personalInfoRequest.needCertificationBaseInfo = "true";
            personalInfoRequest.canAcceptDelay = "false";
            UserInfoUtil.b(personalInfoRequest, new a());
        }
    }

    private String getMemberContent(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1827310646")) {
            return !TextUtils.isEmpty(str) ? str : str2;
        }
        return (String) ipChange.ipc$dispatch("1827310646", new Object[]{this, str, str2});
    }

    private void gotoAuth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "262195572")) {
            ipChange.ipc$dispatch("262195572", new Object[]{this});
            return;
        }
        CertificationInfoBean certificationInfoBean2 = this.certificationInfoBean;
        if (certificationInfoBean2 != null) {
            int parseInt = Integer.parseInt(certificationInfoBean2.getAccountVerifyCode());
            if (parseInt == 1) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(TokenType.LOGIN, false);
                DMNav.from(this).withExtras(bundle).toUri(NavUri.b("nameauth"));
            } else if (parseInt == 2 || parseInt == 3) {
                DMNav.from(this).toUri(NavUri.b("realname_auth_result"));
            } else if (parseInt == 4) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt(RealNameAuthErrorActivity.REALNAME_AUTH_ERROR_TAG, 3);
                DMNav.from(this).withExtras(bundle2).toUri(NavUri.b("realname_error"));
            } else if (parseInt == 5) {
                gotoRealNameFaceVerifyFailedPage();
            }
        }
    }

    private void gotoRealNameFaceVerifyFailedPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-176854511")) {
            ipChange.ipc$dispatch("-176854511", new Object[]{this});
            return;
        }
        Intent intent = new Intent(this, RealNameFaceVerifyFailedActivity.class);
        intent.putExtra("failedType", this.certificationInfoBean.getFaceVerifyFailedType());
        startActivity(intent);
    }

    private void initBindEmailLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869727022")) {
            ipChange.ipc$dispatch("-869727022", new Object[]{this});
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R$id.email_set);
        if (xd1.a().b()) {
            relativeLayout.setVisibility(0);
            relativeLayout.setOnClickListener(this);
            return;
        }
        relativeLayout.setVisibility(8);
    }

    private void initMemberLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4285205")) {
            ipChange.ipc$dispatch("-4285205", new Object[]{this});
            return;
        }
        this.mMemberLine = findViewById(R$id.rv_max_vip_line);
        this.mMemberLayout = (RelativeLayout) findViewById(R$id.rv_max_vip);
        this.mMemberTitle = (TextView) findViewById(R$id.tv_max_vip_title);
        this.mMemberStatus = (TextView) findViewById(R$id.tv_max_vip_state);
        this.mMemberTip = (TextView) findViewById(R$id.tv_max_vip_tip);
        this.mMemberLayout.setVisibility(8);
        this.mMemberLine.setVisibility(8);
    }

    private void initThirdAccoutLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1577075491")) {
            ipChange.ipc$dispatch("-1577075491", new Object[]{this});
            return;
        }
        this.accountSettingly = (RelativeLayout) findViewById(R$id.third_account_setting_layout);
        if (xd1.a().d()) {
            this.accountSettingly.setVisibility(0);
            this.accountSettingly.setTag(null);
            this.accountSettingly.setOnClickListener(this);
            HavanaProxy.v().y();
            WXEntryActivity.setWXType(1);
            return;
        }
        this.accountSettingly.setVisibility(8);
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "6613251")) {
            ipChange.ipc$dispatch("6613251", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mTvTitleBack = (DMIconFontTextView) findViewById(R$id.mine_title_left_icon_font_tv);
        TextView textView = (TextView) findViewById(R$id.mine_title_tv);
        this.mTitleTV = textView;
        textView.setText("账户安全");
        this.mTvTitleBack.setOnClickListener(this);
        setImmersionStyle();
    }

    protected static void newManageUrl(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1967507529")) {
            ipChange.ipc$dispatch("1967507529", new Object[]{str, str2});
            return;
        }
        String str3 = str2 + "&site=" + AliMemberSDK.getMasterSite() + "&request_token=" + str;
        UrlParam urlParam = new UrlParam();
        urlParam.url = str3;
        if (ServiceFactory.getService(NavigatorService.class) != null) {
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openWebViewPage(DataProviderFactory.getApplicationContext(), urlParam);
        }
    }

    public static void openAuthManagerPage() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142407679")) {
            ipChange.ipc$dispatch("-142407679", new Object[0]);
            return;
        }
        vf1.a();
        if (DataProviderFactory.getDataProvider().getEnvType() == 1) {
            str = "https://market.wapa.taobao.com/app/vip/ucc/pages/bind_manage?env=daily";
        } else {
            str = DataProviderFactory.getDataProvider().getEnvType() == 2 ? "https://market.wapa.taobao.com/app/vip/ucc/pages/bind_manage?env=pre" : "https://market.m.taobao.com/app/vip/ucc/pages/bind_manage?";
        }
        if (((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider() != null) {
            ((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider().getUserToken("", new d(str));
        } else {
            SNSAuth.toastBusy("data provider为空");
        }
    }

    private void registerListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1623555800")) {
            ipChange.ipc$dispatch("-1623555800", new Object[]{this});
            return;
        }
        this.ray_bind_phone.setOnClickListener(this);
        this.ray_login_pw.setOnClickListener(this);
        this.ray_pay_pw.setOnClickListener(this);
        this.realNameLayout.setOnClickListener(this);
        this.accountUnRegister.setOnClickListener(this);
    }

    private void setEmail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1767994469")) {
            ipChange.ipc$dispatch("1767994469", new Object[]{this});
            return;
        }
        UserData userData = this.mUserData;
        if (userData != null && userData.getUserBaseInfo() != null) {
            if (TextUtils.isEmpty(this.mUserData.getUserBaseInfo().getMaskEmail())) {
                LoginManager.k().d(this);
            } else {
                LoginManager.k().e(this);
            }
        }
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1245788835")) {
            ipChange.ipc$dispatch("1245788835", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = ne2.a(this);
                findViewById.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
            return;
        }
        ne2.f(this, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setTencentPermissionAndOpenAuth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-358742700")) {
            ipChange.ipc$dispatch("-358742700", new Object[]{this});
            return;
        }
        try {
            Tencent.setIsPermissionGranted(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SNSBind.openAuthManagerPage();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2098854695")) {
            ipChange.ipc$dispatch("2098854695", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "26597987")) {
            return R$layout.account_safe_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("26597987", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1037461128")) {
            ipChange.ipc$dispatch("-1037461128", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-725662797")) {
            ipChange.ipc$dispatch("-725662797", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "791805706")) {
            ipChange.ipc$dispatch("791805706", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.ray_bind_phone = (RelativeLayout) findViewById(R$id.ray_bind_phone);
        this.ray_login_pw = (RelativeLayout) findViewById(R$id.ray_login_pw);
        this.ray_pay_pw = (RelativeLayout) findViewById(R$id.ray_pay_pw);
        this.accountUnRegister = (RelativeLayout) findViewById(R$id.to_un_register_page);
        this.tv_phone = (TextView) findViewById(R$id.tv_phone);
        this.tv_real_name = (TextView) findViewById(R$id.tv_real_name);
        this.tv_email = (TextView) findViewById(R$id.tv_email);
        this.icon_real = (ImageView) findViewById(R$id.icon_real);
        this.realNameLayout = (RelativeLayout) findViewById(R$id.rl_real_name);
        initTitle();
        registerListener();
        xd1.a().f();
        xd1.a().e();
        initThirdAccoutLayout();
        initBindEmailLayout();
        initMemberLayout();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "67320432")) {
            ipChange.ipc$dispatch("67320432", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.ray_bind_phone) {
            String b2 = bk2.b(this, R$string.damai_usercenter_phone_number);
            cn.damai.common.user.c.e().x(yd1.x().g());
            if (xd1.a().c()) {
                LoginManager.k().f(this);
            } else {
                onClickSafetyCenter("https://msecurity.damai.cn/securityCenter-front-wap/automatic/mobile/start", b2, true);
            }
        } else if (id == R$id.ray_login_pw) {
            cn.damai.common.user.c.e().x(yd1.x().f());
            LoginManager.k().g(this);
        } else if (id == R$id.ray_pay_pw) {
            String b3 = bk2.b(this, R$string.damai_usercenter_pay_password);
            cn.damai.common.user.c.e().x(yd1.x().h());
            onClickSafetyCenter("https://msecurity.damai.cn/securityCenter-front-wap/automatic/paypassword/start", b3, true);
        } else if (id == R$id.rl_real_name) {
            cn.damai.common.user.c.e().x(yd1.x().i());
            gotoAuth();
        } else if (id == R$id.mine_title_left_icon_font_tv) {
            finish();
        } else if (id == R$id.third_account_setting_layout) {
            String str = null;
            if (view.getTag() != null) {
                str = (String) view.getTag();
            }
            if (!TextUtils.isEmpty(str)) {
                yd1.x().m0(this.accountSettingly);
                new DMDialog(this).v("温馨提示").q(str).h("取消", Color.parseColor("#000000"), new c(this)).m("继续", Color.parseColor("#ff2d79"), new b()).show();
                return;
            }
            setTencentPermissionAndOpenAuth();
        } else if (id == R$id.email_set) {
            setEmail();
        } else if (id == R$id.to_un_register_page) {
            String a2 = ls0.a("accountUnregisterConfig");
            if (TextUtils.isEmpty(a2)) {
                a2 = "https://survey.taobao.com/apps/zhiliao/HUacOCLEw";
            }
            DMNav.from(this).toUri(a2);
        } else if (id == R$id.rv_max_vip) {
            cn.damai.common.user.c.e().x(yd1.x().m());
            DMNav.from(this).toUri(h03.c());
        } else {
            super.onClick(view);
        }
    }

    public void onClickSafetyCenter(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "283620549")) {
            ipChange.ipc$dispatch("283620549", new Object[]{this, str, str2, Boolean.valueOf(z)});
        } else if (!TextUtils.isEmpty(d20.q())) {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("status", z);
            bundle.putString("title", str2);
            DMNav.from(this).withExtras(bundle).toUri(NavUri.b(gr.t));
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1285275408")) {
            ipChange.ipc$dispatch("-1285275408", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(yd1.x().j());
        cn.damai.common.user.c.e().K(this);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "115447344")) {
            ipChange.ipc$dispatch("115447344", new Object[]{this});
            return;
        }
        super.onDestroy();
        xd1.a().h();
        xd1.a().g();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "205089447")) {
            ipChange.ipc$dispatch("205089447", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1051020658")) {
            ipChange.ipc$dispatch("-1051020658", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462632595")) {
            ipChange.ipc$dispatch("1462632595", new Object[]{this});
            return;
        }
        super.onResume();
        getAuthStatus();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-505653353")) {
            return "账户安全";
        }
        return (String) ipChange.ipc$dispatch("-505653353", new Object[]{this});
    }
}
