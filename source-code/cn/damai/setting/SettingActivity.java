package cn.damai.setting;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.DamaiConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ACache;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.update.UpdateUtil;
import cn.damai.h5container.DamaiCookieManager;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.homepage.R$style;
import cn.damai.login.LoginManager;
import cn.damai.mine.activity.AccountSafeActivity;
import cn.damai.mine.view.LogoutDialog;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.wxapi.TencentUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.usercenter.passport.PassportManager;
import tb.bk2;
import tb.d20;
import tb.g91;
import tb.gr;
import tb.j92;
import tb.n3;
import tb.ne2;
import tb.wd1;

/* compiled from: Taobao */
public class SettingActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    Handler handler = new i();
    private RelativeLayout ll_push;
    private TextView logout_btn;
    private FrameLayout mFlBottomBtnContainer;
    private LinearLayout mLvFeedback;
    private RelativeLayout mPrivacyRl;
    private TextView mTitleTV;
    private DMIconFontTextView mTvTitleBack;
    SettingActivity mainActivity;
    private RelativeLayout rl_about;
    private RelativeLayout rl_account_safe;
    private RelativeLayout rl_clear;
    private RelativeLayout rl_help;
    private RelativeLayout rl_phone;
    private RelativeLayout rl_protocol;
    private RelativeLayout rl_update;
    private TextView tv_cache_size;
    private long usercode;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-3852948")) {
                ipChange.ipc$dispatch("-3852948", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(j92.g().q());
            String str = "https://" + "help.damai.cn/helpPageH5Catalog.htm";
            g91.b("SettingActivity", "helpCenterUrl = " + str);
            DMNav.from(SettingActivity.this.mainActivity).toUri(str);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2107437421")) {
                ipChange.ipc$dispatch("2107437421", new Object[]{this, view});
                return;
            }
            SettingActivity.this.mainActivity.startActivity(new Intent(SettingActivity.this.mainActivity, ProtocolActivity.class));
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-76239506")) {
                ipChange.ipc$dispatch("-76239506", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(j92.g().k());
            Intent intent = new Intent();
            intent.setClass(SettingActivity.this.mainActivity, AboutActivity.class);
            SettingActivity.this.startActivity(intent);
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2035050863")) {
                ipChange.ipc$dispatch("2035050863", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(j92.g().o());
            try {
                SettingActivity.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:10103721")));
            } catch (Exception e) {
                e.printStackTrace();
                ToastUtil.a().j(SettingActivity.this, "无法拨号，请手动拨打10103721");
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-148626064")) {
                ipChange.ipc$dispatch("-148626064", new Object[]{this, view});
                return;
            }
            SettingActivity.this.Logout();
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1962664305")) {
                ipChange.ipc$dispatch("1962664305", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(j92.g().p());
            SettingActivity.this.jumpToFaqActivity();
        }
    }

    /* compiled from: Taobao */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-221012622")) {
                ipChange.ipc$dispatch("-221012622", new Object[]{this, view});
                return;
            }
            DMNav.from(SettingActivity.this).toUri(NavUri.b(gr.PRIVACY_SETTING));
        }
    }

    /* compiled from: Taobao */
    public class h implements LogoutDialog.OnDialogClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // cn.damai.mine.view.LogoutDialog.OnDialogClickListener
        public void onDismiss() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2128021565")) {
                ipChange.ipc$dispatch("2128021565", new Object[]{this});
            }
        }

        @Override // cn.damai.mine.view.LogoutDialog.OnDialogClickListener
        public void onFirstSel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1870205529")) {
                ipChange.ipc$dispatch("1870205529", new Object[]{this});
            }
        }

        @Override // cn.damai.mine.view.LogoutDialog.OnDialogClickListener
        public void onSecondSel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-473671295")) {
                ipChange.ipc$dispatch("-473671295", new Object[]{this});
                return;
            }
            LoginManager.k().u();
            cn.damai.common.user.c.e().x(j92.g().r());
            SettingActivity.this.logoutDM();
            DamaiCookieManager.getInstance().resetAll();
        }
    }

    /* compiled from: Taobao */
    public class i extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "460516311")) {
                ipChange.ipc$dispatch("460516311", new Object[]{this, message});
                return;
            }
            int i = message.what;
            if (i == 0) {
                SettingActivity.this.setCacheSize();
                ToastUtil a2 = ToastUtil.a();
                SettingActivity settingActivity = SettingActivity.this;
                a2.j(settingActivity.mainActivity, bk2.b(settingActivity, R$string.damai_more_empty_success_toast));
            } else if (i == 1) {
                SettingActivity.this.setCacheSize();
                ToastUtil a3 = ToastUtil.a();
                SettingActivity settingActivity2 = SettingActivity.this;
                a3.j(settingActivity2.mainActivity, bk2.b(settingActivity2, R$string.damai_more_empty_failure_toast));
            }
        }
    }

    /* compiled from: Taobao */
    public class j implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        j() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1931207161")) {
                ipChange.ipc$dispatch("1931207161", new Object[]{this, view});
                return;
            }
            DMNav.from(SettingActivity.this).toUri("https://market.m.taobao.com/app/msd/m-privacy-center/index.html#/policy/220");
        }
    }

    /* compiled from: Taobao */
    public class k implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        k() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-252469766")) {
                ipChange.ipc$dispatch("-252469766", new Object[]{this, view});
                return;
            }
            DMNav.from(SettingActivity.this).toUri("https://m.taopiaopiao.com/tickets/dianying/pages/alfheim/content.html?id=2114311&displayType=plain&hsb=yes&hideAuthorInfo=yes&interact=no&loading=false");
        }
    }

    /* compiled from: Taobao */
    public class l implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        l() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1858820603")) {
                ipChange.ipc$dispatch("1858820603", new Object[]{this, view});
                return;
            }
            SettingActivity.this.jumpToInformationCollectH5();
        }
    }

    /* compiled from: Taobao */
    public class m implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        m() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-324856324")) {
                ipChange.ipc$dispatch("-324856324", new Object[]{this, view});
                return;
            }
            SettingActivity.this.startActivity(new Intent(SettingActivity.this, PermissionEntranceActivity.class));
        }
    }

    /* compiled from: Taobao */
    public class n implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        n() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1786434045")) {
                ipChange.ipc$dispatch("1786434045", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(j92.g().l());
            SettingActivity.this.turnAccountSafe();
        }
    }

    /* compiled from: Taobao */
    public class o implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        o(SettingActivity settingActivity) {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1714047487")) {
                ipChange.ipc$dispatch("1714047487", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(j92.g().m());
            UpdateUtil.d();
        }
    }

    /* compiled from: Taobao */
    public class p implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        p() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-469629440")) {
                ipChange.ipc$dispatch("-469629440", new Object[]{this, view});
                return;
            }
            SettingActivity.this.jumpMessagePushPage();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Logout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "160650832")) {
            ipChange.ipc$dispatch("160650832", new Object[]{this});
            return;
        }
        LogoutDialog logoutDialog = new LogoutDialog(this, R$style.custom_dialog_style);
        logoutDialog.e(new h());
        logoutDialog.show();
    }

    private void display() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1722730674")) {
            ipChange.ipc$dispatch("-1722730674", new Object[]{this});
            return;
        }
        setCacheSize();
    }

    private void gotoHomeMainActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-421294768")) {
            ipChange.ipc$dispatch("-421294768", new Object[]{this});
            return;
        }
        DMNav.from(this).toUri(NavUri.b(gr.n));
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1147792488")) {
            ipChange.ipc$dispatch("1147792488", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mTvTitleBack = (DMIconFontTextView) findViewById(R$id.mine_title_left_icon_font_tv);
        TextView textView = (TextView) findViewById(R$id.mine_title_tv);
        this.mTitleTV = textView;
        textView.setText("设置");
        this.mTvTitleBack.setOnClickListener(this);
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-547871327")) {
            ipChange.ipc$dispatch("-547871327", new Object[]{this});
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

    private void initViewContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1770372372")) {
            ipChange.ipc$dispatch("-1770372372", new Object[]{this});
            return;
        }
        this.mainActivity = this;
        this.rl_clear = (RelativeLayout) findViewById(R$id.rl_clear);
        this.rl_update = (RelativeLayout) findViewById(R$id.rl_update);
        this.ll_push = (RelativeLayout) findViewById(R$id.ll_push);
        this.mPrivacyRl = (RelativeLayout) findViewById(R$id.rl_privacy);
        this.rl_help = (RelativeLayout) findViewById(R$id.rl_help);
        this.rl_protocol = (RelativeLayout) findViewById(R$id.rl_protocol);
        this.rl_about = (RelativeLayout) findViewById(R$id.rl_about);
        this.rl_phone = (RelativeLayout) findViewById(R$id.rl_phone);
        this.rl_account_safe = (RelativeLayout) findViewById(R$id.rl_account_safe);
        this.mLvFeedback = (LinearLayout) findViewById(R$id.mine_setting_feedback_lv);
        this.tv_cache_size = (TextView) findViewById(R$id.tv_cache_size);
        this.mFlBottomBtnContainer = (FrameLayout) findViewById(R$id.setting_bottom_btn_container_fl);
        this.logout_btn = (TextView) findViewById(R$id.logout_btn);
        findViewById(R$id.mine_setting_privacy_summary).setOnClickListener(new j());
        findViewById(R$id.rl_person_information_share_list).setOnClickListener(new k());
        findViewById(R$id.rl_person_information_collect_list).setOnClickListener(new l());
        findViewById(R$id.rl_system_permission).setOnClickListener(new m());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void jumpMessagePushPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080071086")) {
            ipChange.ipc$dispatch("1080071086", new Object[]{this});
        } else if (LoginManager.k().q()) {
            cn.damai.common.user.c.e().x(j92.g().s());
            DMNav.from(this).toUri(NavUri.b(gr.MESSAGE_PUSH_SETTING));
        } else {
            LoginManager.k().x(this.mainActivity, new Intent(), 1611);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void jumpToFaqActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "280116948")) {
            ipChange.ipc$dispatch("280116948", new Object[]{this});
        } else if (LoginManager.k().q()) {
            DMNav.from(this).toUri(NavUri.b("feedback_list"));
        } else {
            LoginManager.k().x(this, new Intent(), 1800);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void jumpToInformationCollectH5() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2106657414")) {
            ipChange.ipc$dispatch("2106657414", new Object[]{this});
        } else if (LoginManager.k().q()) {
            Bundle bundle = new Bundle();
            bundle.putString("loading", "false");
            bundle.putString("url", "https://t.damai.cn/yep/page/m/gwrab7nnw9");
            DMNav.from(this).withExtras(bundle).toUri(NavUri.b(gr.t));
        } else {
            LoginManager.k().x(this, new Intent(), 1801);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void logoutDM() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1874353529")) {
            ipChange.ipc$dispatch("-1874353529", new Object[]{this});
            return;
        }
        d20.W("");
        ACache.b(this).a();
        d20.r0("");
        d20.x0("");
        d20.k0("");
        d20.i0(true);
        d20.Y("");
        d20.Z("");
        d20.a();
        d20.j0("");
        PassportManager.getInstance().logout();
        try {
            new TencentUtil(this.mainActivity).qqLogout();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        d20.b0(false);
        this.mFlBottomBtnContainer.setVisibility(8);
        this.mainActivity.sendBroadcast(new Intent(wd1.REFRESH_USER_BROADCAST));
        this.mainActivity.sendBroadcast(new Intent(DamaiConstants.LOGOUT));
        try {
            Intent intent = new Intent();
            intent.setAction(DamaiConstants.TICKLET_EXTERNAL_CALL_BRODCAST_ACTION);
            intent.setPackage("cn.damai");
            intent.putExtra("type", 4);
            sendBroadcast(intent);
        } catch (Exception e3) {
            n3.a("damai_member", "member_service_start", "exit", e3.getMessage());
        }
        gotoHomeMainActivity();
        setResult(-1);
        finish();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCacheSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2121057159")) {
            ipChange.ipc$dispatch("-2121057159", new Object[]{this});
            return;
        }
        this.tv_cache_size.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void turnAccountSafe() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-201986925")) {
            ipChange.ipc$dispatch("-201986925", new Object[]{this});
        } else if (LoginManager.k().q()) {
            Intent intent = new Intent(this, AccountSafeActivity.class);
            intent.putExtra("usercode", d20.E());
            startActivity(intent);
        } else {
            LoginManager.k().x(this.mainActivity, new Intent(), 1610);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "953306146")) {
            ipChange.ipc$dispatch("953306146", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 == 10003) {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1483184264")) {
            return R$layout.fragment_setting;
        }
        return ((Integer) ipChange.ipc$dispatch("1483184264", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1167040499")) {
            ipChange.ipc$dispatch("1167040499", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1105589096")) {
            ipChange.ipc$dispatch("-1105589096", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1803781371")) {
            ipChange.ipc$dispatch("-1803781371", new Object[]{this});
            return;
        }
        this.usercode = getIntent().getLongExtra("userCode", 0);
        initTitle();
        initTitleStatusBar();
        initViewContent();
        registerListener();
        display();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1842876844")) {
            ipChange.ipc$dispatch("1842876844", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if (i2 == 1610) {
            turnAccountSafe();
        } else if (i2 == 1800) {
            jumpToFaqActivity();
        } else if (i2 == 1801) {
            jumpToInformationCollectH5();
        } else if (i2 == 1611) {
            jumpMessagePushPage();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304951893")) {
            ipChange.ipc$dispatch("-304951893", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() == R$id.mine_title_left_icon_font_tv) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "59184405")) {
            ipChange.ipc$dispatch("59184405", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(j92.g().t());
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2086397717")) {
            return ((Boolean) ipChange.ipc$dispatch("-2086397717", new Object[]{this, Integer.valueOf(i2), keyEvent})).booleanValue();
        } else if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        } else {
            setResult(-1);
            finish();
            return true;
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1885376222")) {
            ipChange.ipc$dispatch("-1885376222", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "405565619")) {
            ipChange.ipc$dispatch("405565619", new Object[]{this});
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1132954482")) {
            ipChange.ipc$dispatch("-1132954482", new Object[]{this});
            return;
        }
        if (LoginManager.k().q()) {
            this.mFlBottomBtnContainer.setVisibility(0);
        } else {
            this.mFlBottomBtnContainer.setVisibility(8);
        }
        this.mPrivacyRl.setVisibility(0);
        super.onResume();
    }

    public void registerListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1525862947")) {
            ipChange.ipc$dispatch("1525862947", new Object[]{this});
            return;
        }
        this.rl_account_safe.setOnClickListener(new n());
        this.rl_clear.setOnClickListener(new View.OnClickListener() {
            /* class cn.damai.setting.SettingActivity.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-397242882")) {
                    ipChange.ipc$dispatch("-397242882", new Object[]{this, view});
                    return;
                }
                new Thread() {
                    /* class cn.damai.setting.SettingActivity.AnonymousClass7.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1495041669")) {
                            ipChange.ipc$dispatch("1495041669", new Object[]{this});
                            return;
                        }
                        cn.damai.common.user.c.e().x(j92.g().n());
                        cn.damai.common.image.a.b().a();
                        SettingActivity.this.handler.sendEmptyMessage(0);
                    }
                }.start();
            }
        });
        this.rl_update.setOnClickListener(new o(this));
        this.ll_push.setOnClickListener(new p());
        this.rl_help.setOnClickListener(new a());
        this.rl_protocol.setOnClickListener(new b());
        this.rl_about.setOnClickListener(new c());
        this.rl_phone.setOnClickListener(new d());
        this.logout_btn.setOnClickListener(new e());
        this.mLvFeedback.setOnClickListener(new f());
        this.mPrivacyRl.setOnClickListener(new g());
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1283453180")) {
            return "设置";
        }
        return (String) ipChange.ipc$dispatch("1283453180", new Object[]{this});
    }
}
