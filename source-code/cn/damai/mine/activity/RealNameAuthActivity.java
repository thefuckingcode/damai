package cn.damai.mine.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.comment.util.SoftInputUtils;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$style;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.contacts.ui.view.WheelView;
import cn.damai.commonbusiness.contacts.view.RealNameTipView;
import cn.damai.commonbusiness.faceverify.bean.BaseFaceVerifyBean;
import cn.damai.commonbusiness.faceverify.bean.CertificateTypeBean;
import cn.damai.commonbusiness.faceverify.request.FaceVerifyNextStepRequest;
import cn.damai.homepage.R$anim;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$string;
import cn.damai.im.AliMeUtil;
import cn.damai.login.LoginManager;
import cn.damai.mine.bean.RealNameAuthBean;
import cn.damai.mine.bean.RealNameCustomerBean;
import cn.damai.mine.bean.RealNameCustomerListBean;
import cn.damai.mine.bean.RealNameVerifyBean;
import cn.damai.mine.contract.RealNameAuthContract;
import cn.damai.mine.fragment.RealNameChooseAutherFragment;
import cn.damai.mine.presenter.RealNameAuthPresenter;
import com.ali.user.mobile.model.TokenType;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.RPVerify;
import com.alibaba.security.rp.RPSDK;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.br;
import tb.d20;
import tb.f4;
import tb.gr;
import tb.n42;
import tb.ne2;
import tb.pw1;
import tb.v50;
import tb.xf2;
import tb.xs0;
import tb.yd1;

/* compiled from: Taobao */
public class RealNameAuthActivity extends DamaiBaseActivity<RealNameAuthPresenter, RealNameAuthContract.Model> implements RealNameAuthContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private WheelView.b OnWheelViewListener = new b();
    private RealNameChooseAutherFragment autherFragment;
    private String certTypeCode = "";
    private TextView certTypeNameTv;
    private ArrayList<RealNameCustomerBean> customerBeans;
    private EditText idCardEdit;
    private boolean isFromLogin = false;
    private boolean isRetryAuth;
    private TextView mChooseAutherBtn;
    private ClickableSpan mClickableSpan;
    private FrameLayout mContainer;
    private int mCurrentTypePosition;
    private f4 mCustomDialog;
    private l mHandler;
    private List<String> mIdTypeNames;
    private List<CertificateTypeBean.ResultBean> mIdTypes;
    private final int mProtocolEnd = 15;
    private final int mProtocolStart = 9;
    private final String mProtocolStr = "请您认真阅读并同意《实名须知》的全部条款，接受后可开始使用我们的服务";
    private LinearLayout mRealNameAuthKefuLayout;
    private TextView mRealNameRightText;
    private RealNameCustomerBean mSelectedCustomer;
    private TextView mSubmitBtn;
    private EditText realNameEdit;
    private RealNameTipView tipView;

    /* compiled from: Taobao */
    public class a extends RPEventListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alibaba.security.realidentity.RPEventListener
        public void onFinish(RPResult rPResult, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-350863862")) {
                ipChange.ipc$dispatch("-350863862", new Object[]{this, rPResult, str, str2});
            } else if (rPResult != RPResult.AUDIT_NOT) {
                RealNameAuthActivity.this.notifyServer(rPResult);
            }
        }
    }

    /* compiled from: Taobao */
    public class b extends WheelView.b {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.contacts.ui.view.WheelView.b
        public void a(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-181928372")) {
                ipChange.ipc$dispatch("-181928372", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            super.a(i, str);
            int i2 = i - 1;
            RealNameAuthActivity.this.mCurrentTypePosition = i2;
            RealNameAuthActivity.this.certTypeNameTv.setTag(RealNameAuthActivity.this.mIdTypes.get(i2));
        }
    }

    /* compiled from: Taobao */
    public class c implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "246461533")) {
                ipChange.ipc$dispatch("246461533", new Object[]{this, editable});
                return;
            }
            RealNameAuthActivity.this.changeSubmitBtnBackground();
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1126709766")) {
                ipChange.ipc$dispatch("1126709766", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "85713318")) {
                ipChange.ipc$dispatch("85713318", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-936885764")) {
                ipChange.ipc$dispatch("-936885764", new Object[]{this, editable});
                return;
            }
            RealNameAuthActivity.this.changeSubmitBtnBackground();
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2035066937")) {
                ipChange.ipc$dispatch("-2035066937", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2056652775")) {
                ipChange.ipc$dispatch("2056652775", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnFocusChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onFocusChange(View view, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "642155192")) {
                ipChange.ipc$dispatch("642155192", new Object[]{this, view, Boolean.valueOf(z)});
                return;
            }
            RealNameAuthActivity.this.idCardEdit.setText(RealNameAuthActivity.this.idCardEdit.getText().toString().toUpperCase());
        }
    }

    /* compiled from: Taobao */
    public class f extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        public void onClick(@NonNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "119685053")) {
                ipChange.ipc$dispatch("119685053", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", "https://m.damai.cn/damai/mine/audience-notice/index.html");
            DMNav.from(RealNameAuthActivity.this).withExtras(bundle).toUri(NavUri.b(gr.t));
        }

        public void updateDrawState(@NonNull TextPaint textPaint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2096506138")) {
                ipChange.ipc$dispatch("2096506138", new Object[]{this, textPaint});
                return;
            }
            super.updateDrawState(textPaint);
            textPaint.setColor(Color.parseColor("#ff1268"));
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: Taobao */
    public class g implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        g(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "730820849")) {
                ipChange.ipc$dispatch("730820849", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            RealNameAuthActivity.this.tipView.updateCheckState(true);
            cn.damai.common.user.c.e().x(yd1.x().T());
            RealNameAuthActivity.this.mSubmitBtn.setClickable(false);
            RealNameAuthActivity realNameAuthActivity = RealNameAuthActivity.this;
            ((RealNameAuthPresenter) realNameAuthActivity.mPresenter).submitAuth(this.a, this.b, realNameAuthActivity.certTypeCode);
        }
    }

    /* compiled from: Taobao */
    public class h implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h(RealNameAuthActivity realNameAuthActivity) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1700401872")) {
                ipChange.ipc$dispatch("1700401872", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            }
        }
    }

    /* compiled from: Taobao */
    public class i implements AliMeUtil.UserCodeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements AliMeUtil.AliMeTokenListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onFailed() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1553815520")) {
                    ipChange.ipc$dispatch("-1553815520", new Object[]{this});
                    return;
                }
                AliMeUtil.o();
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1383804628")) {
                    ipChange.ipc$dispatch("1383804628", new Object[]{this, str});
                    return;
                }
                AliMeUtil.b(RealNameAuthActivity.this, AliMeUtil.c(AliMeUtil.FROM_REALNAME_AUTH, str));
            }
        }

        i() {
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2003703853")) {
                ipChange.ipc$dispatch("-2003703853", new Object[]{this});
                return;
            }
            AliMeUtil.o();
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onSuccess(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1313141613")) {
                ipChange.ipc$dispatch("1313141613", new Object[]{this, Long.valueOf(j)});
                return;
            }
            AliMeUtil.e(j, AliMeUtil.FROM_REALNAME_AUTH, new a());
        }
    }

    /* compiled from: Taobao */
    public class j implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        j() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-655403378")) {
                ipChange.ipc$dispatch("-655403378", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            cn.damai.common.user.c.e().x(yd1.x().O());
            Bundle bundle = new Bundle();
            bundle.putInt(RealNameAuthErrorActivity.REALNAME_AUTH_ERROR_TAG, 1);
            bundle.putString(RealNameAuthErrorActivity.REALNAME_AUTH_ERROR_MSG, RealNameAuthActivity.this.getString(R$string.realname_auth_error_conflict));
            DMNav.from(RealNameAuthActivity.this).withExtras(bundle).toUri(NavUri.b("realname_error"));
            RealNameAuthActivity.this.mCustomDialog = null;
        }
    }

    /* compiled from: Taobao */
    public class k implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        k() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "314177645")) {
                ipChange.ipc$dispatch("314177645", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            cn.damai.common.user.c.e().x(yd1.x().P());
            RealNameAuthActivity.this.getFaceVerifyToken(true);
            RealNameAuthActivity.this.mCustomDialog = null;
        }
    }

    /* compiled from: Taobao */
    public class l extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        l() {
        }

        public void dispatchMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "248692973")) {
                ipChange.ipc$dispatch("248692973", new Object[]{this, message});
                return;
            }
            super.dispatchMessage(message);
            int i = message.what;
            CertificateTypeBean.ResultBean resultBean = null;
            if (i == 0) {
                CertificateTypeBean.ResultBean resultBean2 = (CertificateTypeBean.ResultBean) RealNameAuthActivity.this.certTypeNameTv.getTag();
                if (resultBean2 == null) {
                    if (xf2.e(RealNameAuthActivity.this.mIdTypes) > 0) {
                        resultBean = (CertificateTypeBean.ResultBean) RealNameAuthActivity.this.mIdTypes.get(0);
                    }
                    RealNameAuthActivity.this.certTypeNameTv.setTag(resultBean);
                    resultBean2 = resultBean;
                }
                if (resultBean2 != null) {
                    RealNameAuthActivity.this.updateTypeName(resultBean2.getIdentufyName(), resultBean2.getIdentifyCode());
                    RealNameAuthActivity.this.changeSubmitBtnBackground();
                }
            } else if (i == 200 && RealNameAuthActivity.this.mContainer != null && RealNameAuthActivity.this.mContainer.getVisibility() == 0) {
                RealNameAuthActivity.this.mContainer.setVisibility(8);
                RealNameAuthActivity.this.autherFragment = null;
            }
        }
    }

    /* compiled from: Taobao */
    public class m implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private Dialog a;

        public m(Dialog dialog) {
            this.a = dialog;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-677520724")) {
                ipChange.ipc$dispatch("-677520724", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id == R$id.add_contacts_cancel_btn) {
                Dialog dialog = this.a;
                if (dialog != null) {
                    dialog.dismiss();
                }
            } else if (id == R$id.add_contacts_confirm_btn) {
                RealNameAuthActivity.this.mHandler.sendEmptyMessage(0);
                Dialog dialog2 = this.a;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void changeSubmitBtnBackground() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1758442708")) {
            ipChange.ipc$dispatch("-1758442708", new Object[]{this});
            return;
        }
        String trim = this.idCardEdit.getText().toString().trim();
        String trim2 = this.realNameEdit.getText().toString().trim();
        String trim3 = this.certTypeNameTv.getText().toString().trim();
        if (TextUtils.isEmpty(trim) || TextUtils.isEmpty(trim2) || TextUtils.isEmpty(trim3)) {
            this.mSubmitBtn.setBackgroundResource(R$drawable.bg_submit_button_90ffffff_mask);
            this.mSubmitBtn.setClickable(false);
        } else {
            this.mSubmitBtn.setBackgroundResource(R$drawable.bg_submit_button_roud);
            this.mSubmitBtn.setClickable(true);
        }
        if (!TextUtils.isEmpty(trim)) {
            int i2 = cn.damai.homepage.R$id.idcard_clear_btn;
            findViewById(i2).setVisibility(0);
            findViewById(i2).setOnClickListener(this);
        } else {
            findViewById(cn.damai.homepage.R$id.idcard_clear_btn).setVisibility(8);
        }
        if (!TextUtils.isEmpty(trim2)) {
            int i3 = cn.damai.homepage.R$id.realname_clear_btn;
            findViewById(i3).setVisibility(0);
            findViewById(i3).setOnClickListener(this);
            return;
        }
        findViewById(cn.damai.homepage.R$id.realname_clear_btn).setVisibility(8);
    }

    private void chooseAuther() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2057439600")) {
            ipChange.ipc$dispatch("2057439600", new Object[]{this});
            return;
        }
        if (this.mHandler == null) {
            this.mHandler = new l();
        }
        SoftInputUtils.a(this);
        this.autherFragment = new RealNameChooseAutherFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data", this.customerBeans);
        bundle.putParcelable("selectedCustomer", this.mSelectedCustomer);
        this.autherFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getFragmentTransaction();
        fragmentTransaction.replace(cn.damai.homepage.R$id.popup_layer_container_flv, this.autherFragment);
        fragmentTransaction.commitAllowingStateLoss();
        this.mContainer.setVisibility(0);
    }

    private void chooseCertType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2110376537")) {
            ipChange.ipc$dispatch("-2110376537", new Object[]{this});
            return;
        }
        if (this.mHandler == null) {
            this.mHandler = new l();
        }
        View inflate = LayoutInflater.from(this).inflate(R$layout.add_contacts_select_id_type_layout, (ViewGroup) null);
        WheelView wheelView = (WheelView) inflate.findViewById(R$id.add_contacts_idtype_list);
        wheelView.setOffset(1);
        wheelView.setItems(this.mIdTypeNames);
        wheelView.setSeletion(this.mCurrentTypePosition);
        wheelView.setOnWheelViewListener(this.OnWheelViewListener);
        Dialog dialog = new Dialog(this, R$style.ActionSheetDialogStyle);
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(80);
        attributes.width = DisplayMetrics.getwidthPixels(v50.b(this));
        attributes.height = v50.a(this, 245.0f);
        window.setAttributes(attributes);
        dialog.setCanceledOnTouchOutside(true);
        ((TextView) inflate.findViewById(R$id.add_contacts_cancel_btn)).setOnClickListener(new m(dialog));
        ((TextView) inflate.findViewById(R$id.add_contacts_confirm_btn)).setOnClickListener(new m(dialog));
        dialog.show();
    }

    private void faceAuthDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "15036943")) {
            ipChange.ipc$dispatch("15036943", new Object[]{this});
        } else if (this.mCustomDialog == null) {
            f4 d2 = new f4(this).h("换绑并扫脸", new k()).f("取消", new j()).e("您提供的信息已被其他账号绑定，扫脸认证通过后可换绑到当前账号").d(false);
            this.mCustomDialog = d2;
            d2.j();
        }
    }

    private void fetchCertificateType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1182900357")) {
            ipChange.ipc$dispatch("1182900357", new Object[]{this});
            return;
        }
        this.mIdTypeNames = new ArrayList();
        this.mIdTypes = new ArrayList();
        this.mIdTypeNames.clear();
        this.mIdTypes.clear();
        ((RealNameAuthPresenter) this.mPresenter).fetchCertificateType("accountVerify");
    }

    private void fetchCustomers() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1333270497")) {
            ipChange.ipc$dispatch("1333270497", new Object[]{this});
            return;
        }
        ((RealNameAuthPresenter) this.mPresenter).fetchCustomers();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void getFaceVerifyToken(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431899909")) {
            ipChange.ipc$dispatch("1431899909", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ((RealNameAuthPresenter) this.mPresenter).getFaceVerifyToken(z);
    }

    private FragmentTransaction getFragmentTransaction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437070798")) {
            return (FragmentTransaction) ipChange.ipc$dispatch("437070798", new Object[]{this});
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i2 = R$anim.realname_slide_in_from_bottom;
        int i3 = R$anim.realname_slide_out_from_bottom;
        beginTransaction.setCustomAnimations(i2, i3, i2, i3);
        return beginTransaction;
    }

    private int getHeight(int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1300261851")) {
            return ((DisplayMetrics.getwidthPixels(n42.c(this)) - i4) * i3) / i2;
        }
        return ((Integer) ipChange.ipc$dispatch("-1300261851", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})).intValue();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1835767252")) {
            ipChange.ipc$dispatch("-1835767252", new Object[]{this});
            return;
        }
        this.mSubmitBtn = (TextView) findViewById(cn.damai.homepage.R$id.realname_auth_btn);
        this.realNameEdit = (EditText) findViewById(cn.damai.homepage.R$id.realname_edit);
        this.mContainer = (FrameLayout) findViewById(cn.damai.homepage.R$id.popup_layer_container_flv);
        this.idCardEdit = (EditText) findViewById(cn.damai.homepage.R$id.realname_cernum_text);
        this.mChooseAutherBtn = (TextView) findViewById(cn.damai.homepage.R$id.realname_choose_auther);
        this.mRealNameAuthKefuLayout = (LinearLayout) findViewById(cn.damai.homepage.R$id.realname_auth_layout);
        this.mRealNameRightText = (TextView) findViewById(cn.damai.homepage.R$id.realname_right_text);
        this.certTypeNameTv = (TextView) findViewById(cn.damai.homepage.R$id.certificate_typename);
        RealNameTipView realNameTipView = (RealNameTipView) findViewById(cn.damai.homepage.R$id.realname_auth_tips);
        this.tipView = realNameTipView;
        realNameTipView.setText("我已阅读并同意《实名须知》", "《实名须知》");
        this.tipView.updateIconVis(true);
        this.tipView.updateCheckState(false);
        changeSubmitBtnBackground();
    }

    private void initTitle() {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1682401766")) {
            ipChange.ipc$dispatch("1682401766", new Object[]{this});
            return;
        }
        if (!(getIntent() == null || (extras = getIntent().getExtras()) == null)) {
            this.isFromLogin = extras.getBoolean(TokenType.LOGIN, false);
            this.isRetryAuth = extras.getBoolean("retryAuth", false);
        }
        if (this.isFromLogin) {
            d20.v0(true);
            this.mRealNameAuthKefuLayout.setVisibility(8);
            this.mRealNameRightText.setVisibility(0);
            this.mRealNameRightText.setText("跳过");
        } else {
            this.mRealNameAuthKefuLayout.setVisibility(0);
            this.mRealNameRightText.setVisibility(8);
        }
        if (this.isRetryAuth) {
            this.realNameEdit.setText("");
            this.idCardEdit.setText("");
            this.mSelectedCustomer = null;
        }
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1618802147")) {
            ipChange.ipc$dispatch("1618802147", new Object[]{this});
            return;
        }
        View findViewById = findViewById(cn.damai.homepage.R$id.title_bar_space);
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
    private void notifyServer(final RPResult rPResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1353867999")) {
            ipChange.ipc$dispatch("1353867999", new Object[]{this, rPResult});
            return;
        }
        FaceVerifyNextStepRequest faceVerifyNextStepRequest = new FaceVerifyNextStepRequest();
        faceVerifyNextStepRequest.loginKey = d20.q();
        faceVerifyNextStepRequest.scene = "accountVerify";
        faceVerifyNextStepRequest.request(new DMMtopRequestListener<BaseFaceVerifyBean>(BaseFaceVerifyBean.class) {
            /* class cn.damai.mine.activity.RealNameAuthActivity.AnonymousClass11 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-675967407")) {
                    ipChange.ipc$dispatch("-675967407", new Object[]{this, str, str2});
                    return;
                }
                ToastUtil.i(str2);
            }

            public void onSuccess(BaseFaceVerifyBean baseFaceVerifyBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1364137643")) {
                    ipChange.ipc$dispatch("-1364137643", new Object[]{this, baseFaceVerifyBean});
                    return;
                }
                RPResult rPResult = rPResult;
                if (rPResult == RPResult.AUDIT_PASS) {
                    ToastUtil.i("认证通过");
                    br.c("auth_success", "");
                    RealNameAuthActivity.this.finish();
                } else if (rPResult == RPResult.AUDIT_IN_AUDIT) {
                    ToastUtil.i("审核中");
                    br.c("auth_verifing", "");
                    Bundle bundle = new Bundle();
                    bundle.putInt(RealNameAuthErrorActivity.REALNAME_AUTH_ERROR_TAG, 3);
                    DMNav.from(RealNameAuthActivity.this).withExtras(bundle).toUri(NavUri.b("realname_error"));
                    RealNameAuthActivity.this.finish();
                } else if (rPResult == RPResult.AUDIT_FAIL) {
                    ToastUtil.i("认证失败");
                }
            }
        });
    }

    private void setListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1716000984")) {
            ipChange.ipc$dispatch("1716000984", new Object[]{this});
            return;
        }
        findViewById(cn.damai.homepage.R$id.realname_auth_btn).setOnClickListener(this);
        findViewById(cn.damai.homepage.R$id.realname_auth_back).setOnClickListener(this);
        findViewById(cn.damai.homepage.R$id.realname_center_certype_layout).setOnClickListener(this);
        this.mRealNameRightText.setOnClickListener(this);
        this.mRealNameAuthKefuLayout.setOnClickListener(this);
        this.realNameEdit.addTextChangedListener(new c());
        this.idCardEdit.addTextChangedListener(new d());
        this.idCardEdit.setOnFocusChangeListener(new e());
        this.mContainer.setOnClickListener(this);
        this.mChooseAutherBtn.setOnClickListener(this);
        this.mClickableSpan = new f();
    }

    private void submitRealNameAuth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-893640301")) {
            ipChange.ipc$dispatch("-893640301", new Object[]{this});
        } else if (LoginManager.k().q()) {
            String trim = this.realNameEdit.getText().toString().trim();
            String trim2 = this.idCardEdit.getText().toString().toUpperCase().trim();
            String trim3 = this.certTypeNameTv.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                ToastUtil.i("请输入姓名");
            } else if (TextUtils.isEmpty(trim2)) {
                ToastUtil.i("请输入证件号码");
            } else if (TextUtils.isEmpty(trim3)) {
                ToastUtil.i("请选择证件类型");
            } else if (!this.tipView.getCheckState()) {
                new DMDialog(this).s("请您认真阅读并同意《实名须知》的全部条款，接受后可开始使用我们的服务", 9, 15, this.mClickableSpan).i("不同意", new h(this)).n("同意", new g(trim2, trim)).show();
            } else {
                cn.damai.common.user.c.e().x(yd1.x().T());
                this.mSubmitBtn.setClickable(false);
                ((RealNameAuthPresenter) this.mPresenter).submitAuth(trim2, trim, this.certTypeCode);
            }
        } else {
            LoginManager.k().v(this);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateTypeName(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "830292738")) {
            ipChange.ipc$dispatch("830292738", new Object[]{this, str, str2});
        } else if (str != null) {
            this.certTypeNameTv.setText(str);
            this.certTypeCode = str2;
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthContract.View
    public void authFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592047253")) {
            ipChange.ipc$dispatch("-592047253", new Object[]{this, str, str2});
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            if (str.equals("FAIL_BIZ_UC_5130")) {
                faceAuthDialog();
            } else if (str.equals("FAIL_BIZ_UC_5034")) {
                bundle.putInt(RealNameAuthErrorActivity.REALNAME_AUTH_ERROR_TAG, 1);
                bundle.putString(RealNameAuthErrorActivity.REALNAME_AUTH_ERROR_MSG, getString(R$string.realname_auth_error_conflict));
                DMNav.from(this).withExtras(bundle).toUri(NavUri.b("realname_error"));
            } else if (!str.equals("FAIL_BIZ_UC_400") && !str.equals("FAIL_BIZ_UC_5036")) {
                bundle.putInt(RealNameAuthErrorActivity.REALNAME_AUTH_ERROR_TAG, 2);
                bundle.putString(RealNameAuthErrorActivity.REALNAME_AUTH_ERROR_MSG, str2);
                DMNav.from(this).withExtras(bundle).toUri(NavUri.b("realname_error"));
            } else if (!TextUtils.isEmpty(str2)) {
                ToastUtil.i(str2);
            }
        }
        this.mSubmitBtn.setClickable(true);
    }

    @Override // cn.damai.mine.contract.RealNameAuthContract.View
    public void authSuccess(RealNameAuthBean realNameAuthBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1468972655")) {
            ipChange.ipc$dispatch("1468972655", new Object[]{this, realNameAuthBean});
            return;
        }
        ToastUtil.i("认证成功");
        this.mSubmitBtn.setClickable(true);
        br.c("auth_success", "");
        finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "168969444")) {
            ipChange.ipc$dispatch("168969444", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    public void dismissChooseAuthFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1465521525")) {
            ipChange.ipc$dispatch("1465521525", new Object[]{this});
            return;
        }
        RealNameChooseAutherFragment realNameChooseAutherFragment = this.autherFragment;
        if (realNameChooseAutherFragment != null && realNameChooseAutherFragment.getActivity() != null) {
            RealNameChooseAutherFragment realNameChooseAutherFragment2 = this.autherFragment;
            if (realNameChooseAutherFragment2 != null && !realNameChooseAutherFragment2.getActivity().isFinishing()) {
                FragmentTransaction fragmentTransaction = getFragmentTransaction();
                fragmentTransaction.remove(this.autherFragment);
                fragmentTransaction.commitAllowingStateLoss();
            }
            this.mHandler.sendEmptyMessageDelayed(200, 300);
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthContract.View
    public void fetchCertificateTypeFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-425939940")) {
            ipChange.ipc$dispatch("-425939940", new Object[]{this, str, str2});
        } else if (!TextUtils.isEmpty(str2)) {
            ToastUtil.i(str2);
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthContract.View
    public void fetchCertificateTypeSuccess(CertificateTypeBean certificateTypeBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1850077555")) {
            ipChange.ipc$dispatch("-1850077555", new Object[]{this, certificateTypeBean});
        } else if (certificateTypeBean != null) {
            List<CertificateTypeBean.ResultBean> result = certificateTypeBean.getResult();
            this.mIdTypes = result;
            if (xf2.e(result) > 0) {
                updateTypeName(result.get(0).getIdentufyName(), result.get(0).getIdentifyCode());
                changeSubmitBtnBackground();
                for (CertificateTypeBean.ResultBean resultBean : result) {
                    this.mIdTypeNames.add(resultBean.getIdentufyName());
                }
            }
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthContract.View
    public void fetchCustomersFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "705835128")) {
            ipChange.ipc$dispatch("705835128", new Object[]{this, str, str2});
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = getString(R$string.net_error);
        }
        ToastUtil.i(str2);
        this.certTypeNameTv.setText("身份证");
        this.certTypeCode = "1";
    }

    @Override // cn.damai.mine.contract.RealNameAuthContract.View
    public void fetchCustomersSuccess(RealNameCustomerListBean realNameCustomerListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2034064840")) {
            ipChange.ipc$dispatch("2034064840", new Object[]{this, realNameCustomerListBean});
        } else if (realNameCustomerListBean == null || realNameCustomerListBean.getResult() == null || realNameCustomerListBean.getResult().size() == 0) {
            this.mChooseAutherBtn.setVisibility(8);
        } else {
            ArrayList<RealNameCustomerBean> result = realNameCustomerListBean.getResult();
            this.customerBeans = result;
            if (result.size() == 1) {
                this.mChooseAutherBtn.setVisibility(8);
                refreshUI(this.customerBeans.get(0), false);
                return;
            }
            this.mChooseAutherBtn.setVisibility(0);
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthContract.View
    public void getFaceVerifyTokenFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1472016186")) {
            ipChange.ipc$dispatch("-1472016186", new Object[]{this, str, str2});
        } else if (!TextUtils.isEmpty(str2)) {
            ToastUtil.i(str2);
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthContract.View
    public void getFaceVerifyTokenSuccess(RealNameVerifyBean realNameVerifyBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1558740327")) {
            ipChange.ipc$dispatch("-1558740327", new Object[]{this, realNameVerifyBean});
        } else if (realNameVerifyBean != null && !TextUtils.isEmpty(realNameVerifyBean.getVerifyToken())) {
            try {
                if (xs0.a() == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("contentlabel", "application 为null");
                    cn.damai.common.user.c.e().A(hashMap, "RPSDK_Application", yd1.REALNAME_AUTH_PAGE);
                    return;
                }
                pw1.a(xs0.a());
                if (RPSDK.getContext() == null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("contentlabel", "RPSDK Context 为null");
                    cn.damai.common.user.c.e().A(hashMap2, "RPSDK_Context", yd1.REALNAME_AUTH_PAGE);
                    return;
                }
                RPVerify.start(this, realNameVerifyBean.getVerifyToken(), new a());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-153375098")) {
            return cn.damai.homepage.R$layout.activity_realname_auth_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("-153375098", new Object[]{this})).intValue();
    }

    public void gotoAliMe() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1478277371")) {
            ipChange.ipc$dispatch("1478277371", new Object[]{this});
            return;
        }
        AliMeUtil.j(new i());
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1973307829")) {
            ipChange.ipc$dispatch("1973307829", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1881105642")) {
            ipChange.ipc$dispatch("-1881105642", new Object[]{this});
            return;
        }
        ((RealNameAuthPresenter) this.mPresenter).setVM(this, (RealNameAuthContract.Model) this.mModel);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-262515257")) {
            ipChange.ipc$dispatch("-262515257", new Object[]{this});
            return;
        }
        hideBaseLayout();
        init();
        initTitle();
        initTitleStatusBar();
        setListener();
        fetchCustomers();
        fetchCertificateType();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-557040659")) {
            ipChange.ipc$dispatch("-557040659", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == cn.damai.homepage.R$id.realname_auth_btn) {
            this.idCardEdit.clearFocus();
            submitRealNameAuth();
        } else if (id == cn.damai.homepage.R$id.realname_auth_back) {
            finish();
        } else if (id == cn.damai.homepage.R$id.realname_choose_auther) {
            cn.damai.common.user.c.e().x(yd1.x().W());
            chooseAuther();
        } else if (id == cn.damai.homepage.R$id.popup_layer_container_flv) {
            dismissChooseAuthFragment();
        } else if (id == cn.damai.homepage.R$id.realname_right_text) {
            cn.damai.common.user.c.e().x(yd1.x().S());
            finish();
        } else if (id == cn.damai.homepage.R$id.realname_auth_layout) {
            gotoAliMe();
        } else if (id == cn.damai.homepage.R$id.realname_clear_btn) {
            EditText editText = this.realNameEdit;
            if (editText != null) {
                editText.setText("");
            }
        } else if (id == cn.damai.homepage.R$id.idcard_clear_btn) {
            EditText editText2 = this.idCardEdit;
            if (editText2 != null) {
                editText2.setText("");
            }
        } else if (id == cn.damai.homepage.R$id.realname_center_certype_layout && xf2.e(this.mIdTypeNames) > 0) {
            chooseCertType();
        }
    }

    public void onCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-99123523")) {
            ipChange.ipc$dispatch("-99123523", new Object[]{this, bundle, persistableBundle});
            return;
        }
        super.onCreate(bundle, persistableBundle);
        setDamaiUTKeyBuilder(yd1.x().R());
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042252695")) {
            return ((Boolean) ipChange.ipc$dispatch("-1042252695", new Object[]{this, Integer.valueOf(i2), keyEvent})).booleanValue();
        } else if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        } else {
            if (getSupportFragmentManager() == null || this.autherFragment == null) {
                return super.onKeyDown(i2, keyEvent);
            }
            dismissChooseAuthFragment();
            return true;
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1079108892")) {
            ipChange.ipc$dispatch("-1079108892", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1230993743")) {
            ipChange.ipc$dispatch("-1230993743", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1616518702")) {
            ipChange.ipc$dispatch("1616518702", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        initTitle();
    }

    public void refreshUI(RealNameCustomerBean realNameCustomerBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1062781113")) {
            ipChange.ipc$dispatch("-1062781113", new Object[]{this, realNameCustomerBean, Boolean.valueOf(z)});
            return;
        }
        this.mSelectedCustomer = realNameCustomerBean;
        if (realNameCustomerBean != null) {
            if (!TextUtils.isEmpty(realNameCustomerBean.getName())) {
                this.realNameEdit.setText(realNameCustomerBean.getName());
                this.realNameEdit.setSelection(realNameCustomerBean.getName().length());
            }
            if (!TextUtils.isEmpty(realNameCustomerBean.getIdentityNo())) {
                this.idCardEdit.setText(realNameCustomerBean.getIdentityNo().toUpperCase());
                this.idCardEdit.setSelection(realNameCustomerBean.getIdentityNo().length());
            }
            String identityTypeName = realNameCustomerBean.getIdentityTypeName();
            if (z && !TextUtils.isEmpty(identityTypeName) && this.mIdTypeNames.contains(identityTypeName)) {
                updateTypeName(identityTypeName, realNameCustomerBean.getIdentityType());
            }
        }
        changeSubmitBtnBackground();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1218530694")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-1218530694", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1186738777")) {
            ipChange.ipc$dispatch("1186738777", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1814680789")) {
            ipChange.ipc$dispatch("1814680789", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1485561863")) {
            ipChange.ipc$dispatch("-1485561863", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "966254260")) {
            ipChange.ipc$dispatch("966254260", new Object[]{this});
        }
    }
}
