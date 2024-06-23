package cn.damai.login.authlogin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.h5container.DamaiCookieManager;
import cn.damai.login.authlogin.req.ThirdPartyAuthRequest;
import cn.damai.login.authlogin.resp.AuthInfoBean;
import cn.damai.login.authlogin.resp.ThirdSessionModel;
import cn.damai.login.authlogin.ui.DMUrlSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import mtopsdk.mtop.util.ErrorConstant;
import org.apache.commons.lang3.StringUtils;
import tb.gr;
import tb.n8;
import tb.s71;
import tb.xf2;

/* compiled from: Taobao */
public class AuthLoginActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_INFO_NEED_AUTH = "key_info_need_auth";
    public static final String KEY_THIRD_URL = "key_third_url";
    private View.OnClickListener mAgreementClickListener = new a();
    private TextView mAuthAgreementView;
    private TextView mAuthButton;
    private TextView mAuthDetailView;
    private AuthInfoBean mAuthInfo;
    private TextView mAuthTitleView;
    private n8 mAuthUtHelper;
    private ImageView mAuthorizedIcon;
    private ThirdSessionModel mAuthorizedModel;
    private ImageView mAuthorizerIcon;
    private String mBizType;
    private ThirdSessionModel mModel;
    private String mThirdUrl;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2031520084")) {
                ipChange.ipc$dispatch("2031520084", new Object[]{this, view});
                return;
            }
            c.e().x(AuthLoginActivity.this.mAuthUtHelper.f(AuthLoginActivity.this.mBizType));
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-152156843")) {
                ipChange.ipc$dispatch("-152156843", new Object[]{this, view});
                return;
            }
            AuthLoginActivity.this.requestAuthThirdPage();
            c.e().x(AuthLoginActivity.this.mAuthUtHelper.g(AuthLoginActivity.this.mBizType));
        }
    }

    private void parseParam(Intent intent) {
        ThirdSessionModel.Extra extra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076180985")) {
            ipChange.ipc$dispatch("1076180985", new Object[]{this, intent});
        } else if (intent != null) {
            this.mThirdUrl = intent.getStringExtra(KEY_THIRD_URL);
            ThirdSessionModel thirdSessionModel = (ThirdSessionModel) intent.getSerializableExtra(KEY_INFO_NEED_AUTH);
            this.mModel = thirdSessionModel;
            if (!(thirdSessionModel == null || (extra = thirdSessionModel.extra) == null)) {
                this.mAuthInfo = extra.authorizePageInfo;
            }
            if (thirdSessionModel != null) {
                this.mBizType = thirdSessionModel.bizType;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestAuthThirdPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-521535241")) {
            ipChange.ipc$dispatch("-521535241", new Object[]{this});
            return;
        }
        ThirdPartyAuthRequest thirdPartyAuthRequest = new ThirdPartyAuthRequest();
        thirdPartyAuthRequest.setOperator(ThirdPartyAuthRequest.OPTR_DO_AUTH);
        thirdPartyAuthRequest.setTarget(this.mThirdUrl);
        thirdPartyAuthRequest.request(new DMMtopRequestListener<ThirdSessionModel>(ThirdSessionModel.class) {
            /* class cn.damai.login.authlogin.AuthLoginActivity.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-415328836")) {
                    ipChange.ipc$dispatch("-415328836", new Object[]{this, str, str2});
                } else if (!TextUtils.equals(ErrorConstant.ERRCODE_ANDROID_SYS_LOGIN_CANCEL, str)) {
                    ToastUtil.f(str2);
                }
            }

            public void onSuccess(ThirdSessionModel thirdSessionModel) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1635848490")) {
                    ipChange.ipc$dispatch("-1635848490", new Object[]{this, thirdSessionModel});
                } else if (thirdSessionModel == null || !thirdSessionModel.hasAllow || s71.a(thirdSessionModel.cookies)) {
                    ToastUtil.f("授权失败，请稍后重试");
                } else {
                    AuthLoginActivity.this.mAuthorizedModel = thirdSessionModel;
                    DamaiCookieManager.getInstance().setCookie(AuthLoginActivity.this.mThirdUrl, AuthLoginActivity.this.mAuthorizedModel.cookies);
                    ToastUtil.c(AuthLoginActivity.this, 0, R$string.toast_opening_third_h5);
                    Bundle bundle = new Bundle();
                    bundle.putString("url", AuthLoginActivity.this.mThirdUrl);
                    DMNav.from(AuthLoginActivity.this).withExtras(bundle).toUri(NavUri.b(gr.t));
                    AuthLoginActivity.this.finish();
                }
            }
        });
    }

    private void updateData(AuthInfoBean authInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "753713020")) {
            ipChange.ipc$dispatch("753713020", new Object[]{this, authInfoBean});
        } else if (authInfoBean != null) {
            cn.damai.common.image.a.b().loadinto(authInfoBean.fromIconUrl, this.mAuthorizerIcon);
            cn.damai.common.image.a.b().loadinto(authInfoBean.toIconUrl, this.mAuthorizedIcon);
            this.mAuthTitleView.setText(authInfoBean.infoTitle);
            if (!s71.a(authInfoBean.infoList)) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = authInfoBean.infoList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!xf2.j(next)) {
                        if (sb.length() > 0) {
                            sb.append(StringUtils.LF);
                        }
                        sb.append(next);
                    }
                }
                this.mAuthDetailView.setText(sb);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!xf2.j(authInfoBean.protocolTitle)) {
                spannableStringBuilder.append((CharSequence) authInfoBean.protocolTitle);
            }
            if (!s71.a(authInfoBean.protocolList)) {
                Iterator<AuthInfoBean.ProtocolInfo> it2 = authInfoBean.protocolList.iterator();
                while (it2.hasNext()) {
                    AuthInfoBean.ProtocolInfo next2 = it2.next();
                    if (next2.isValid()) {
                        int length = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) next2.protocolName);
                        DMUrlSpan dMUrlSpan = new DMUrlSpan(this, next2.protocolUrl);
                        dMUrlSpan.setOnClickListener(this.mAgreementClickListener);
                        spannableStringBuilder.setSpan(dMUrlSpan, length, next2.protocolName.length() + length, 17);
                    }
                }
            }
            this.mAuthAgreementView.setClickable(true);
            this.mAuthAgreementView.setMovementMethod(LinkMovementMethod.getInstance());
            this.mAuthAgreementView.setLinkTextColor(Color.parseColor("#10AAFF"));
            this.mAuthAgreementView.setText(spannableStringBuilder);
            this.mAuthButton.setOnClickListener(new b());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1652958850")) {
            ipChange.ipc$dispatch("-1652958850", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10001 || i == 10003) {
            onBackPressed();
            c.e().z(this.mAuthUtHelper.h(this.mBizType));
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1717821012")) {
            return R$layout.activity_third_auth;
        }
        return ((Integer) ipChange.ipc$dispatch("-1717821012", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "720124751")) {
            ipChange.ipc$dispatch("720124751", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2075075396")) {
            ipChange.ipc$dispatch("-2075075396", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-884661151")) {
            ipChange.ipc$dispatch("-884661151", new Object[]{this});
            return;
        }
        this.mAuthorizerIcon = (ImageView) findViewById(R$id.iv_auth_third_authorizer);
        this.mAuthorizedIcon = (ImageView) findViewById(R$id.iv_auth_third_authorized);
        this.mAuthTitleView = (TextView) findViewById(R$id.tv_auth_third_title);
        this.mAuthDetailView = (TextView) findViewById(R$id.tv_auth_third_detail);
        this.mAuthAgreementView = (TextView) findViewById(R$id.tv_auth_third_agreement);
        this.mAuthButton = (TextView) findViewById(R$id.tv_auth_third_btn);
        parseParam(getIntent());
        updateData(this.mAuthInfo);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1670588871")) {
            ipChange.ipc$dispatch("-1670588871", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        n8 n8Var = new n8();
        this.mAuthUtHelper = n8Var;
        setDamaiUTKeyBuilder(n8Var.i(this.mBizType));
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1902881568")) {
            return "大麦账户授权";
        }
        return (String) ipChange.ipc$dispatch("1902881568", new Object[]{this});
    }
}
