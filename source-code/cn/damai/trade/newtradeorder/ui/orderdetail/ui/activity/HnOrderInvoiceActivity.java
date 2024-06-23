package cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.address.bean.AddressBean;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.util.SystemContactsUtil;
import cn.damai.pay.AliPayActivity;
import cn.damai.rank.RankSquareCMSActivity;
import cn.damai.trade.R$anim;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceApplyInfoResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceDeliveryInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceDeliverySupport;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceSubmitInfoResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceTitleType;
import cn.damai.trade.newtradeorder.ui.orderdetail.contract.HnOrderCreateInvoiceContract;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.HNOrderInvoiceSubmitRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import cn.damai.trade.newtradeorder.ui.orderdetail.presenter.HnOrderCreateInvoicePresenter;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.fragment.HnOrderInvoiceTitleTypeFragment;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.hn.HnOrderInvoiceDeliveryInfoHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.hn.HnOrderInvoiceTitleHolder;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import com.taobao.weex.common.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.an1;
import tb.f4;
import tb.hp1;
import tb.hv0;
import tb.iv0;
import tb.jv0;
import tb.ln2;

/* compiled from: Taobao */
public class HnOrderInvoiceActivity extends DamaiBaseActivity<HnOrderCreateInvoicePresenter, HnOrderCreateInvoiceContract.Model> implements HnOrderInvoiceTitleHolder.OnSwitchInvoiceTitleListener, HnOrderInvoiceTitleTypeFragment.OnConfirmInvoiceTitleListener, HnOrderCreateInvoiceContract.View, HnOrderInvoiceTitleHolder.OnSelectedContractsListener, HnOrderInvoiceDeliveryInfoHolder.OnSwitchExpressAddressListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ERROR_CODE_DIALOG_TIP = "BIZ_ERROR_ALERT";
    private static final int REQUEST_CODE_CONTACTS = 9000;
    private static final int REQUEST_CODE_NEW_ADDRESS = 9002;
    private static final int REQUEST_GOTO_ALIPAY = 9003;
    private Button mButtomButton;
    private FrameLayout mFragmentContainer;
    private HnInvoiceApplyInfoResult mInvoiceApplyInfo;
    private HnOrderInvoiceDeliveryInfoHolder mInvoiceDeliveryInfoHolder;
    private LinearLayout mInvoiceInfoContainer;
    private HnOrderInvoiceTitleHolder mInvoiceTitleHolder;
    private HnOrderInvoiceTitleTypeFragment mInvoiceTitleTypeFragment;
    private jv0 mInvoiceTypeHolder;
    private View mMainView;
    private String mOrderId;
    private hv0 mOrderInfoHolder;
    private String mProjectId;

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "474510083")) {
                ipChange.ipc$dispatch("474510083", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            HnOrderInvoiceActivity.this.setResult(-1);
            HnOrderInvoiceActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class b implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1431771982")) {
                ipChange.ipc$dispatch("-1431771982", new Object[]{this});
                return;
            }
            SystemContactsUtil.g(HnOrderInvoiceActivity.this, 9000);
        }
    }

    private Map<String, String> buildDeliveryAddressData(HnInvoiceDeliveryInfo.HnInvoiceDeliveryAddress hnInvoiceDeliveryAddress, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1344649225")) {
            return (Map) ipChange.ipc$dispatch("-1344649225", new Object[]{this, hnInvoiceDeliveryAddress, map});
        } else if (hnInvoiceDeliveryAddress == null || map == null) {
            return null;
        } else {
            map.put("consignee", hnInvoiceDeliveryAddress.consignee);
            map.put("mobile", hnInvoiceDeliveryAddress.mobile);
            map.put("provinceId", hnInvoiceDeliveryAddress.provinceId);
            map.put("provinceName", hnInvoiceDeliveryAddress.provinceName);
            map.put("cityId", hnInvoiceDeliveryAddress.cityId);
            map.put(RankSquareCMSActivity.PRESET_CITY_NAME, hnInvoiceDeliveryAddress.cityName);
            map.put("districtId", hnInvoiceDeliveryAddress.districtId);
            map.put("districtName", hnInvoiceDeliveryAddress.districtName);
            map.put("streetId", hnInvoiceDeliveryAddress.streetId);
            map.put("streetName", hnInvoiceDeliveryAddress.streetName);
            map.put(ILocatable.ADDRESS, hnInvoiceDeliveryAddress.address);
            map.put("telephone", hnInvoiceDeliveryAddress.telephone);
            map.put("zipCode", hnInvoiceDeliveryAddress.zipCode);
            map.put(Constants.Name.PREFIX, hnInvoiceDeliveryAddress.prefix);
            return map;
        }
    }

    private HnInvoiceDeliveryInfo.HnInvoiceDeliveryAddress convertAddressBeanToDeliveryAddress(AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1107152135")) {
            return (HnInvoiceDeliveryInfo.HnInvoiceDeliveryAddress) ipChange.ipc$dispatch("-1107152135", new Object[]{this, addressBean});
        } else if (addressBean == null) {
            return null;
        } else {
            HnInvoiceDeliveryInfo.HnInvoiceDeliveryAddress hnInvoiceDeliveryAddress = new HnInvoiceDeliveryInfo.HnInvoiceDeliveryAddress();
            hnInvoiceDeliveryAddress.consignee = addressBean.getConsigneeName();
            hnInvoiceDeliveryAddress.mobile = addressBean.getMobile();
            hnInvoiceDeliveryAddress.telephone = addressBean.getTelephone();
            hnInvoiceDeliveryAddress.address = addressBean.getAddressDetail();
            hnInvoiceDeliveryAddress.provinceId = addressBean.getProvinceCode();
            hnInvoiceDeliveryAddress.provinceName = addressBean.getProvince();
            hnInvoiceDeliveryAddress.cityId = addressBean.getCityCode();
            hnInvoiceDeliveryAddress.cityName = addressBean.getCity();
            hnInvoiceDeliveryAddress.districtId = addressBean.getCountyCode();
            hnInvoiceDeliveryAddress.districtName = addressBean.getCounty();
            hnInvoiceDeliveryAddress.streetId = addressBean.getStreetCode();
            hnInvoiceDeliveryAddress.streetName = addressBean.getStreet();
            hnInvoiceDeliveryAddress.zipCode = addressBean.getZipCode();
            hnInvoiceDeliveryAddress.email = addressBean.getEmail();
            return hnInvoiceDeliveryAddress;
        }
    }

    private void dismissInvoiceTitleTypeFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "304622685")) {
            ipChange.ipc$dispatch("304622685", new Object[]{this});
            return;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R$anim.slide_in_from_bottom;
        int i2 = R$anim.slide_out_to_bottom;
        beginTransaction.setCustomAnimations(i, i2, i, i2);
        beginTransaction.hide(this.mInvoiceTitleTypeFragment);
        beginTransaction.commitAllowingStateLoss();
        this.mFragmentContainer.setVisibility(8);
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "499883988")) {
            ipChange.ipc$dispatch("499883988", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        String string = extras.getString("orderId", "");
        this.mOrderId = string;
        if (TextUtils.isEmpty(string)) {
            finish();
        }
        this.mProjectId = extras.getString("projectId", "");
        LayoutInflater from = LayoutInflater.from(this);
        this.mOrderInfoHolder = new hv0(this, from);
        this.mInvoiceTypeHolder = new jv0(from);
        HnOrderInvoiceTitleHolder hnOrderInvoiceTitleHolder = new HnOrderInvoiceTitleHolder(from);
        this.mInvoiceTitleHolder = hnOrderInvoiceTitleHolder;
        hnOrderInvoiceTitleHolder.d(this);
        this.mInvoiceTitleHolder.e(this);
        HnOrderInvoiceDeliveryInfoHolder hnOrderInvoiceDeliveryInfoHolder = new HnOrderInvoiceDeliveryInfoHolder(from);
        this.mInvoiceDeliveryInfoHolder = hnOrderInvoiceDeliveryInfoHolder;
        hnOrderInvoiceDeliveryInfoHolder.d(this);
    }

    private void prepareView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1657716112")) {
            ipChange.ipc$dispatch("1657716112", new Object[]{this});
            return;
        }
        this.mMainView = findViewById(R$id.layout_main);
        this.mInvoiceInfoContainer = (LinearLayout) findViewById(R$id.layout_invoice_info);
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.layout_fragment_container);
        this.mFragmentContainer = frameLayout;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(this);
        }
        Button button = (Button) findViewById(R$id.btn_invoice_submit);
        this.mButtomButton = button;
        if (button != null) {
            button.setOnClickListener(this);
        }
    }

    private void reportUtInvoiceSubmitInfo() {
        List<HnInvoiceDeliverySupport> list;
        HnInvoiceDeliveryInfo b2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561481180")) {
            ipChange.ipc$dispatch("1561481180", new Object[]{this});
            return;
        }
        HnInvoiceApplyInfoResult hnInvoiceApplyInfoResult = this.mInvoiceApplyInfo;
        if (hnInvoiceApplyInfoResult != null && (list = hnInvoiceApplyInfoResult.deliveryWaySupports) != null && !list.isEmpty() && (b2 = this.mInvoiceDeliveryInfoHolder.b()) != null) {
            ln2 r = ln2.r();
            String str = this.mOrderId;
            c.e().x(r.G1(str, this.mInvoiceApplyInfo.deliveryWaySupports.get(0).invoiceTicketType + "", b2.deliveryWay));
        }
    }

    private void requestInvoiceData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1623109488")) {
            ipChange.ipc$dispatch("-1623109488", new Object[]{this, str});
            return;
        }
        showLoading("loading");
        ((HnOrderCreateInvoicePresenter) this.mPresenter).requestInvoiceInfo(str);
    }

    private void showErrorTipDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-478158848")) {
            ipChange.ipc$dispatch("-478158848", new Object[]{this, str});
            return;
        }
        new f4(this.mContext).c(false).e(str).h(getString(R$string.confirm), new a()).j();
    }

    private void showInvoiceTitleTypeFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "733023388")) {
            ipChange.ipc$dispatch("733023388", new Object[]{this});
            return;
        }
        HnInvoiceApplyInfoResult hnInvoiceApplyInfoResult = this.mInvoiceApplyInfo;
        if (hnInvoiceApplyInfoResult != null && hnInvoiceApplyInfoResult.invoiceType != null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            int i = R$anim.slide_in_from_bottom;
            int i2 = R$anim.slide_out_to_bottom;
            beginTransaction.setCustomAnimations(i, i2, i, i2);
            HnOrderInvoiceTitleTypeFragment hnOrderInvoiceTitleTypeFragment = this.mInvoiceTitleTypeFragment;
            if (hnOrderInvoiceTitleTypeFragment == null) {
                HnOrderInvoiceTitleTypeFragment hnOrderInvoiceTitleTypeFragment2 = new HnOrderInvoiceTitleTypeFragment();
                this.mInvoiceTitleTypeFragment = hnOrderInvoiceTitleTypeFragment2;
                hnOrderInvoiceTitleTypeFragment2.setOnConfirmInvoiceTitleListener(this);
                this.mInvoiceTitleTypeFragment.setInvoiceTitleTypeData(this.mInvoiceApplyInfo.invoiceType);
                beginTransaction.add(R$id.layout_fragment_container, this.mInvoiceTitleTypeFragment);
            } else {
                beginTransaction.show(hnOrderInvoiceTitleTypeFragment);
            }
            beginTransaction.commitAllowingStateLoss();
            this.mFragmentContainer.setVisibility(0);
        }
    }

    private void submitInvoiceInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "56415993")) {
            ipChange.ipc$dispatch("56415993", new Object[]{this});
        } else if (this.mInvoiceApplyInfo != null) {
            HnOrderInvoiceTitleHolder.a b2 = this.mInvoiceTitleHolder.b();
            if (b2 == null) {
                ToastUtil.a().e(this, "请选择抬头类型");
                return;
            }
            HnInvoiceDeliveryInfo b3 = this.mInvoiceDeliveryInfoHolder.b();
            if (b3 == null) {
                ToastUtil.a().e(this, "请选择发票配送信息");
                return;
            }
            if (!"1".equals(b2.a.invoiceTitleType)) {
                if (TextUtils.isEmpty(b2.b)) {
                    ToastUtil.a().e(this, "请填写发票抬头");
                    return;
                } else if (TextUtils.isEmpty(b2.c)) {
                    ToastUtil.a().e(this, "请填写税号");
                    return;
                }
            }
            if (!"1".equals(b3.deliveryWay)) {
                if ("1".equals(b2.a.invoiceTitleType)) {
                    if (TextUtils.isEmpty(b2.d)) {
                        ToastUtil.a().e(this, "请输入姓名");
                        return;
                    } else if (TextUtils.isEmpty(b2.e)) {
                        ToastUtil.a().e(this, "请输入手机号码");
                        return;
                    }
                }
                if ("3".equals(b3.deliveryWay)) {
                    HnInvoiceDeliveryInfo.HnInvoiceDeliveryAddress hnInvoiceDeliveryAddress = b3.deliveryAddress;
                    if (hnInvoiceDeliveryAddress == null || TextUtils.isEmpty(hnInvoiceDeliveryAddress.email)) {
                        ToastUtil.a().e(this, "请填写邮箱");
                        return;
                    }
                } else {
                    "2".equals(b3.deliveryWay);
                }
            } else if (b3.deliveryAddress == null) {
                ToastUtil.a().e(this, "请输入收货地址和联系方式");
                return;
            }
            HNOrderInvoiceSubmitRequest hNOrderInvoiceSubmitRequest = new HNOrderInvoiceSubmitRequest();
            hNOrderInvoiceSubmitRequest.orderId = this.mOrderId;
            hNOrderInvoiceSubmitRequest.userId = Login.getUserId();
            String str = b2.a.invoiceTitleType;
            hNOrderInvoiceSubmitRequest.invoiceType = str;
            if (!"1".equals(str)) {
                hNOrderInvoiceSubmitRequest.title = b2.b;
                hNOrderInvoiceSubmitRequest.dutyParagraph = b2.c;
            }
            hNOrderInvoiceSubmitRequest.deliveryWay = b3.deliveryWay;
            Map<String, String> hashMap = new HashMap<>();
            if ("1".equals(b3.deliveryWay)) {
                hashMap = buildDeliveryAddressData(b3.deliveryAddress, hashMap);
            } else {
                if ("1".equals(b2.a.invoiceTitleType)) {
                    hashMap.put("consignee", b2.d);
                    hashMap.put("mobile", b2.e);
                }
                if ("3".equals(b3.deliveryWay)) {
                    hashMap.put("eMail", b3.deliveryAddress.email);
                } else {
                    "2".equals(b3.deliveryWay);
                }
            }
            try {
                hNOrderInvoiceSubmitRequest.invoiceDeliveryInfo = JSON.toJSONString(hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mButtomButton.setEnabled(false);
            showLoading("loading");
            ((HnOrderCreateInvoicePresenter) this.mPresenter).submitInvoiceInfo(hNOrderInvoiceSubmitRequest);
            reportUtInvoiceSubmitInfo();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1778004970")) {
            ipChange.ipc$dispatch("-1778004970", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10003) {
            FrameLayout frameLayout = this.mFragmentContainer;
            if (frameLayout == null || !frameLayout.isShown()) {
                finish();
            } else {
                dismissInvoiceTitleTypeFragment();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1851322388")) {
            return R$layout.activity_hn_order_create_invoice;
        }
        return ((Integer) ipChange.ipc$dispatch("1851322388", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305579545")) {
            ipChange.ipc$dispatch("-305579545", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "487829796")) {
            ipChange.ipc$dispatch("487829796", new Object[]{this});
            return;
        }
        ((HnOrderCreateInvoicePresenter) this.mPresenter).setVM(this, (HnOrderCreateInvoiceContract.Model) this.mModel);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-489083143")) {
            ipChange.ipc$dispatch("-489083143", new Object[]{this});
            return;
        }
        setDamaiUTKeyBuilder(new a.b().i(ln2.HN_ORDER_CREATE_INVOICE_PAGE));
        prepareView();
        initData();
        requestInvoiceData(this.mOrderId);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        HnOrderInvoiceTitleHolder hnOrderInvoiceTitleHolder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1176581984")) {
            ipChange.ipc$dispatch("-1176581984", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i != 9000) {
            if (i != 9002) {
                if (i == 9003 && intent != null && intent.getBooleanExtra("payResult", false)) {
                    setResult(-1);
                    finish();
                }
            } else if (intent != null || i2 == -1) {
                this.mInvoiceDeliveryInfoHolder.e(convertAddressBeanToDeliveryAddress((AddressBean) intent.getParcelableExtra("added_address")));
            }
        } else if (intent != null) {
            String c = SystemContactsUtil.c(this, intent.getData());
            if (!TextUtils.isEmpty(c) && (hnOrderInvoiceTitleHolder = this.mInvoiceTitleHolder) != null) {
                hnOrderInvoiceTitleHolder.f(c);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "845369408")) {
            ipChange.ipc$dispatch("845369408", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.mFragmentContainer;
        if (frameLayout == null || !frameLayout.isShown()) {
            super.onBackPressed();
        } else {
            dismissInvoiceTitleTypeFragment();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "99478687")) {
            ipChange.ipc$dispatch("99478687", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == R$id.layout_fragment_container) {
            dismissInvoiceTitleTypeFragment();
        } else if (id == R$id.btn_invoice_submit) {
            submitInvoiceInfo();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.ui.fragment.HnOrderInvoiceTitleTypeFragment.OnConfirmInvoiceTitleListener
    public void onConfirmInvoiceTitle(HnInvoiceTitleType hnInvoiceTitleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "673368202")) {
            ipChange.ipc$dispatch("673368202", new Object[]{this, hnInvoiceTitleType});
            return;
        }
        dismissInvoiceTitleTypeFragment();
        this.mInvoiceTitleHolder.g(this.mInvoiceApplyInfo, hnInvoiceTitleType);
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.hn.HnOrderInvoiceTitleHolder.OnSelectedContractsListener
    public void onContractsClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2015912375")) {
            ipChange.ipc$dispatch("-2015912375", new Object[]{this});
            return;
        }
        hp1.a(this, false, "android.permission.READ_CONTACTS", "才能快速填写手机号～", new b());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "936971030")) {
            ipChange.ipc$dispatch("936971030", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "773703743")) {
            ipChange.ipc$dispatch("773703743", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601592802")) {
            ipChange.ipc$dispatch("1601592802", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "412993897")) {
            ipChange.ipc$dispatch("412993897", new Object[]{this});
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.hn.HnOrderInvoiceDeliveryInfoHolder.OnSwitchExpressAddressListener
    public void onSwitchExpressAddress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "46236823")) {
            ipChange.ipc$dispatch("46236823", new Object[]{this});
            return;
        }
        DMNav.from(this).forResult(9002).toUri(NavUri.b("purchase_address_list"));
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.hn.HnOrderInvoiceTitleHolder.OnSwitchInvoiceTitleListener
    public void onSwitchInvoiceTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1677248496")) {
            ipChange.ipc$dispatch("1677248496", new Object[]{this});
            return;
        }
        showInvoiceTitleTypeFragment();
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.HnOrderCreateInvoiceContract.View
    public void returnInvoiceInfo(HnInvoiceApplyInfoResult hnInvoiceApplyInfoResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1366420924")) {
            ipChange.ipc$dispatch("-1366420924", new Object[]{this, hnInvoiceApplyInfoResult});
            return;
        }
        stopLoading();
        this.mInvoiceApplyInfo = hnInvoiceApplyInfoResult;
        onResponseSuccess(this.mMainView);
        this.mInvoiceInfoContainer.addView(this.mOrderInfoHolder.c(hnInvoiceApplyInfoResult).a());
        this.mInvoiceInfoContainer.addView(this.mInvoiceTypeHolder.b(hnInvoiceApplyInfoResult).a());
        this.mInvoiceInfoContainer.addView(this.mInvoiceTitleHolder.a());
        List<HnInvoiceDeliverySupport> list = hnInvoiceApplyInfoResult.deliveryWaySupports;
        if (list != null && list.size() > 0 && hnInvoiceApplyInfoResult.deliveryWaySupports.get(0).deliveryWays != null && hnInvoiceApplyInfoResult.deliveryWaySupports.get(0).deliveryWays.size() > 0) {
            HnInvoiceDeliveryInfo hnInvoiceDeliveryInfo = hnInvoiceApplyInfoResult.deliveryWaySupports.get(0).deliveryWays.get(0);
            this.mInvoiceInfoContainer.addView(this.mInvoiceDeliveryInfoHolder.f(hnInvoiceApplyInfoResult, hnInvoiceApplyInfoResult.deliveryWaySupports.get(0).deliveryWays.get(0)).a());
            if (hnInvoiceDeliveryInfo == null || !"1".equals(hnInvoiceDeliveryInfo.deliveryWay)) {
                this.mButtomButton.setText("提交申请");
            } else {
                this.mInvoiceInfoContainer.addView(new iv0(LayoutInflater.from(this)).a());
                this.mButtomButton.setText("提交并支付");
            }
            this.mButtomButton.setVisibility(0);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.HnOrderCreateInvoiceContract.View
    public void returnInvoiceInfoError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2111702671")) {
            ipChange.ipc$dispatch("2111702671", new Object[]{this, str, str2, str3});
            return;
        }
        stopLoading();
        if (ERROR_CODE_DIALOG_TIP.equals(str) && !TextUtils.isEmpty(str2)) {
            showErrorTipDialog(str2);
        } else if (str2 == null || !str2.contains("抱歉，当前排队的人数太多啦，请稍后再试哦")) {
            onResponseError(str2, str, str3, this.mMainView, true);
        } else {
            onResponseError(2, str2, str, str3, this.mMainView, true);
        }
        an1.d(OrderDetailConstantsApi.API_HN_ORDER_APPLY_INVOICE_INFO, str, str2, "projectId:" + this.mProjectId + ",orderId:" + this.mOrderId + ",fromWhere:候鸟发票渲染接口失败");
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.HnOrderCreateInvoiceContract.View
    public void returnInvoiceSubmitInfo(HnInvoiceSubmitInfoResult hnInvoiceSubmitInfoResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416707832")) {
            ipChange.ipc$dispatch("-1416707832", new Object[]{this, hnInvoiceSubmitInfoResult});
            return;
        }
        stopLoading();
        this.mButtomButton.setEnabled(true);
        if (!TextUtils.isEmpty(hnInvoiceSubmitInfoResult.payUrl)) {
            Intent intent = new Intent(this.mContext, AliPayActivity.class);
            intent.putExtra("alipay_param", hnInvoiceSubmitInfoResult.payUrl);
            intent.putExtra("from", "OrderDetailPage");
            intent.putExtra("orderid", this.mOrderId);
            startActivityForResult(intent, 9003);
            return;
        }
        ToastUtil.a().e(this, "申请成功");
        setResult(-1);
        finish();
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.HnOrderCreateInvoiceContract.View
    public void returnInvoiceSubmitInfoError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1474439101")) {
            ipChange.ipc$dispatch("1474439101", new Object[]{this, str, str2});
            return;
        }
        stopLoading();
        this.mButtomButton.setEnabled(true);
        if (!TextUtils.isEmpty(str2)) {
            if (ERROR_CODE_DIALOG_TIP.equals(str)) {
                showErrorTipDialog(str2);
            } else {
                ToastUtil.a().e(this, str2);
            }
        }
        an1.d(OrderDetailConstantsApi.API_HN_ORDER_SUBMIT_INVOICE_INFO, str, str2, "projectId:" + this.mProjectId + ",orderId:" + this.mOrderId + ",fromWhere:发票提交信息接口失败");
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1573593992")) {
            return "申请发票";
        }
        return (String) ipChange.ipc$dispatch("1573593992", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-739293081")) {
            ipChange.ipc$dispatch("-739293081", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374653795")) {
            ipChange.ipc$dispatch("374653795", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896176135")) {
            ipChange.ipc$dispatch("1896176135", new Object[]{this, str});
            return;
        }
        startProgressDialog();
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1324015550")) {
            ipChange.ipc$dispatch("-1324015550", new Object[]{this});
            return;
        }
        stopProgressDialog();
    }
}
