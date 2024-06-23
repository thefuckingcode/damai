package cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.pay.AliPayActivity;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderAddressModifyResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderAddressSubmitResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderAddressModifyPresenter;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.AddressModifyViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.apache.commons.lang3.StringUtils;
import tb.an1;
import tb.d20;
import tb.ln2;

/* compiled from: Taobao */
public class OrderModifyAddressActivity extends DamaiBaseActivity<OrderAddressModifyPresenter, OrderAddressModifyContract.Model> implements OrderAddressModifyContract.View, AddressModifyViewHolder.OnDeliveryAddressClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int REQUEST_GOTO_ALIPAY = 1101;
    private static final int REQUEST_NEW_ADDRESS = 1102;
    private String mAddressId;
    private LinearLayout mAddressLayout;
    private Button mAddressModifySubmit;
    private View.OnClickListener mClickListener = new a();
    private TextView mFreightTv;
    private LayoutInflater mInflater;
    private View mMainView;
    private AddressModifyViewHolder mNewAddressViewHolder;
    private String mOldAddressId;
    private OrderAddressModifyResult mOrderAddressModifyInfo;
    private String mOrderId;
    private AddressModifyViewHolder mOriginalAddressViewHolder;
    private Button mPayBtn;
    private View mPayFreightLayout;
    private String mProjectId;
    private TextView mTipTv;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1451740237")) {
                ipChange.ipc$dispatch("-1451740237", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id == R$id.btn_address_submit || id == R$id.btn_pay) {
                OrderModifyAddressActivity.this.reportSubmitNewAddressClick();
                if (OrderModifyAddressActivity.this.mOrderAddressModifyInfo == null || !OrderModifyAddressActivity.this.mOrderAddressModifyInfo.sameAddress) {
                    OrderModifyAddressActivity.this.mAddressModifySubmit.setEnabled(false);
                    OrderModifyAddressActivity.this.mPayFreightLayout.setEnabled(false);
                    OrderModifyAddressActivity orderModifyAddressActivity = OrderModifyAddressActivity.this;
                    orderModifyAddressActivity.requestNewAddressSubmit(orderModifyAddressActivity.mOrderId, OrderModifyAddressActivity.this.mAddressId);
                    return;
                }
                OrderModifyAddressActivity.this.showSameAddressTip();
            }
        }
    }

    private String getFormatTipData(String[] strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122155230")) {
            return (String) ipChange.ipc$dispatch("122155230", new Object[]{this, strArr});
        } else if (strArr == null) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strArr.length; i++) {
                if (i == 0) {
                    sb.append(strArr[i]);
                } else {
                    sb.append(StringUtils.LF);
                    sb.append(strArr[i]);
                }
            }
            return sb.toString();
        }
    }

    private void getIntentData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1020473127")) {
            ipChange.ipc$dispatch("-1020473127", new Object[]{this});
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
        this.mAddressId = extras.getString("addressId", "");
        if (extras.containsKey("projectId")) {
            this.mProjectId = extras.getString("projectId", "");
        }
    }

    private void hideView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "860536782")) {
            ipChange.ipc$dispatch("860536782", new Object[]{this});
            return;
        }
        findViewById(R$id.layout_address_main).setVisibility(4);
        findViewById(R$id.layout_bottom).setVisibility(4);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reportSubmitNewAddressClick() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1079314957")) {
            ipChange.ipc$dispatch("1079314957", new Object[]{this});
        } else if (this.mOrderAddressModifyInfo != null) {
            String E = d20.E();
            int i2 = this.mOrderAddressModifyInfo.supplementType;
            if (i2 == 1) {
                i = 1;
            } else if (i2 == 2) {
                i = 2;
            }
            ln2 r = ln2.r();
            String str = this.mOrderId;
            c.e().x(r.v2(E, str, i + ""));
        }
    }

    private void setAddressData(OrderAddressModifyResult orderAddressModifyResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1606988468")) {
            ipChange.ipc$dispatch("-1606988468", new Object[]{this, orderAddressModifyResult});
            return;
        }
        this.mAddressLayout.removeAllViews();
        AddressModifyViewHolder addressModifyViewHolder = new AddressModifyViewHolder(this, this.mAddressLayout, this.mInflater);
        this.mOriginalAddressViewHolder = addressModifyViewHolder;
        addressModifyViewHolder.b(orderAddressModifyResult.originalDeliveryInfo);
        if (orderAddressModifyResult.originalDeliveryInfo != null) {
            this.mOldAddressId = orderAddressModifyResult.originalDeliveryInfo.addressId + "";
        }
        AddressModifyViewHolder addressModifyViewHolder2 = new AddressModifyViewHolder(this, this.mAddressLayout, this.mInflater);
        this.mNewAddressViewHolder = addressModifyViewHolder2;
        addressModifyViewHolder2.a(orderAddressModifyResult.newDeliveryInfo);
        this.mNewAddressViewHolder.d(this);
    }

    private void setTipData(String[] strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1541449389")) {
            ipChange.ipc$dispatch("1541449389", new Object[]{this, strArr});
            return;
        }
        this.mTipTv.setText(getFormatTipData(strArr));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showSameAddressTip() {
        String[] strArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1245968011")) {
            ipChange.ipc$dispatch("1245968011", new Object[]{this});
            return;
        }
        OrderAddressModifyResult.AddressModifyExt addressModifyExt = this.mOrderAddressModifyInfo.ext;
        if (addressModifyExt == null || (strArr = addressModifyExt.tips) == null || strArr.length == 0) {
            ToastUtil.a().e(this, "新地址与原地址相同,无需修改");
        } else {
            ToastUtil.a().e(this, getFormatTipData(strArr));
        }
    }

    private void showView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369106867")) {
            ipChange.ipc$dispatch("1369106867", new Object[]{this});
            return;
        }
        findViewById(R$id.layout_address_main).setVisibility(0);
        findViewById(R$id.layout_bottom).setVisibility(0);
    }

    private void updateBottomBtnStatus(OrderAddressModifyResult orderAddressModifyResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "592925130")) {
            ipChange.ipc$dispatch("592925130", new Object[]{this, orderAddressModifyResult});
        } else if (orderAddressModifyResult.supplementType == 1) {
            this.mPayFreightLayout.setVisibility(0);
            this.mAddressModifySubmit.setVisibility(8);
            SpannableString spannableString = new SpannableString(orderAddressModifyResult.supplementFee);
            int indexOf = orderAddressModifyResult.supplementFee.indexOf(".");
            if (indexOf >= 0) {
                spannableString.setSpan(new RelativeSizeSpan(0.8f), indexOf, orderAddressModifyResult.supplementFee.length(), 17);
                this.mFreightTv.setText(spannableString);
                return;
            }
            this.mFreightTv.setText(orderAddressModifyResult.supplementFee);
        } else {
            this.mPayFreightLayout.setVisibility(8);
            this.mAddressModifySubmit.setVisibility(0);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "809032285")) {
            ipChange.ipc$dispatch("809032285", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10003) {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "678023533")) {
            return R$layout.activity_order_address_modfity;
        }
        return ((Integer) ipChange.ipc$dispatch("678023533", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1976861614")) {
            ipChange.ipc$dispatch("1976861614", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        requestModifyAddressInfo(this.mOrderId, this.mAddressId);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1770938307")) {
            ipChange.ipc$dispatch("-1770938307", new Object[]{this});
            return;
        }
        ((OrderAddressModifyPresenter) this.mPresenter).setVM(this, (OrderAddressModifyContract.Model) this.mModel);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1993968576")) {
            ipChange.ipc$dispatch("-1993968576", new Object[]{this});
            return;
        }
        this.mInflater = LayoutInflater.from(this);
        this.mMainView = findViewById(R$id.fl_main_content);
        this.mAddressLayout = (LinearLayout) findViewById(R$id.ll_order_address);
        this.mTipTv = (TextView) findViewById(R$id.tv_tip);
        this.mPayFreightLayout = findViewById(R$id.layout_pay_freight);
        this.mAddressModifySubmit = (Button) findViewById(R$id.btn_address_submit);
        Button button = (Button) findViewById(R$id.btn_pay);
        this.mPayBtn = button;
        if (button != null) {
            button.setOnClickListener(this.mClickListener);
        }
        Button button2 = this.mAddressModifySubmit;
        if (button2 != null) {
            button2.setOnClickListener(this.mClickListener);
        }
        this.mFreightTv = (TextView) findViewById(R$id.tv_freight);
        hideView();
        getIntentData();
        setDamaiUTKeyBuilder(new a.b().h(this.mOrderId).i(ln2.ORDER_MODIFY_ADDRESS_PAGE));
        requestModifyAddressInfo(this.mOrderId, this.mAddressId);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2125986855")) {
            ipChange.ipc$dispatch("2125986855", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 1101) {
            if (intent == null || !intent.getBooleanExtra("payResult", false)) {
                StringBuilder sb = new StringBuilder();
                sb.append("projectId:" + this.mProjectId);
                sb.append(",orderId:" + this.mOrderId);
                sb.append(",oldAddressId:" + this.mOldAddressId);
                sb.append(",addressId:" + this.mAddressId);
                sb.append(",fromWhere:补差价支付失败");
                an1.f(OrderDetailConstantsApi.API_ORDER_DETAIL_MODIFY_ADDRESS, null, "alipay failed", sb.toString());
                this.mAddressModifySubmit.setEnabled(true);
                return;
            }
            setResult(-1);
            finish();
        } else if (i == 1102 && intent != null && i2 == -1) {
            String stringExtra = intent.getStringExtra("addressId");
            this.mAddressId = stringExtra;
            if (!TextUtils.isEmpty(stringExtra)) {
                hideView();
                requestModifyAddressInfo(this.mOrderId, this.mAddressId);
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.AddressModifyViewHolder.OnDeliveryAddressClickListener
    public void onDeliveryAddressClick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1696678760")) {
            ipChange.ipc$dispatch("-1696678760", new Object[]{this, str});
            return;
        }
        c.e().x(ln2.r().i1(d20.E(), this.mOrderId));
        Bundle bundle = new Bundle();
        bundle.putString("dm_bundle_address_id", str);
        DMNav.from(this).withExtras(bundle).forResult(1102).toUri(NavUri.b("purchase_address_list"));
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract.View
    public void onGetModifyAddressInfoError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2105123740")) {
            ipChange.ipc$dispatch("2105123740", new Object[]{this, str, str2, str3});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("projectId:" + this.mProjectId);
        sb.append(",orderId:" + this.mOrderId);
        sb.append(",addressId:" + this.mAddressId);
        sb.append(",fromWhere:修改配送地址渲染接口失败");
        an1.f(str3, str, str2, sb.toString());
        if (str2 == null || !str2.contains("抱歉，当前排队的人数太多啦，请稍后再试哦")) {
            onResponseError(str2, str, str3, this.mMainView, true);
        } else {
            onResponseError(2, str2, str, str3, this.mMainView, true);
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1075555107")) {
            ipChange.ipc$dispatch("-1075555107", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-399595112")) {
            ipChange.ipc$dispatch("-399595112", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "222241321")) {
            ipChange.ipc$dispatch("222241321", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599532240")) {
            ipChange.ipc$dispatch("-1599532240", new Object[]{this});
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract.View
    public void onNewAddressSubmitError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1501313716")) {
            ipChange.ipc$dispatch("-1501313716", new Object[]{this, str, str2});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("project:" + this.mProjectId);
        sb.append(",orderId:" + this.mOrderId);
        sb.append(",oldAddressId:" + this.mOldAddressId);
        sb.append(",addressId:" + this.mAddressId);
        sb.append(",fromWhere:修改配送地址提交新地址接口失败");
        an1.f(OrderDetailConstantsApi.API_ORDER_DETAIL_SUBMIT_NEW_ADDRESS, str, str2, sb.toString());
        this.mAddressModifySubmit.setEnabled(true);
        this.mPayFreightLayout.setEnabled(true);
        ToastUtil.a().e(this, str2);
    }

    public void requestModifyAddressInfo(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1465325104")) {
            ipChange.ipc$dispatch("-1465325104", new Object[]{this, str, str2});
            return;
        }
        showLoading("");
        ((OrderAddressModifyPresenter) this.mPresenter).requestModifyAddressInfo(str, str2);
    }

    public void requestNewAddressSubmit(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1707322162")) {
            ipChange.ipc$dispatch("-1707322162", new Object[]{this, str, str2});
            return;
        }
        showLoading("");
        ((OrderAddressModifyPresenter) this.mPresenter).requestNewAddressSubmit(str, str2);
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract.View
    public void returnModifyAddressInfo(OrderAddressModifyResult orderAddressModifyResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-34992088")) {
            ipChange.ipc$dispatch("-34992088", new Object[]{this, orderAddressModifyResult});
            return;
        }
        onResponseSuccess(this.mMainView);
        showView();
        this.mOrderAddressModifyInfo = orderAddressModifyResult;
        setAddressData(orderAddressModifyResult);
        OrderAddressModifyResult.AddressModifyExt addressModifyExt = orderAddressModifyResult.ext;
        setTipData(addressModifyExt != null ? addressModifyExt.tips : null);
        updateBottomBtnStatus(orderAddressModifyResult);
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract.View
    public void returnNewAddressSubmit(OrderAddressSubmitResult orderAddressSubmitResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1152119698")) {
            ipChange.ipc$dispatch("-1152119698", new Object[]{this, orderAddressSubmitResult});
            return;
        }
        onResponseSuccess(this.mMainView);
        OrderAddressModifyResult orderAddressModifyResult = this.mOrderAddressModifyInfo;
        if (orderAddressModifyResult == null || orderAddressModifyResult.supplementType != 1) {
            setResult(-1);
            finish();
        } else if (!TextUtils.isEmpty(orderAddressSubmitResult.payurl)) {
            Intent intent = new Intent(this.mContext, AliPayActivity.class);
            intent.putExtra("alipay_param", orderAddressSubmitResult.payurl);
            intent.putExtra("from", "OrderDetailPage");
            intent.putExtra("orderid", this.mOrderId);
            startActivityForResult(intent, 1101);
        } else {
            this.mAddressModifySubmit.setEnabled(true);
            ToastUtil.a().e(this, "支付订单异常");
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1367749921")) {
            return "修改配送地址";
        }
        return (String) ipChange.ipc$dispatch("1367749921", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1296906112")) {
            ipChange.ipc$dispatch("1296906112", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-111641028")) {
            ipChange.ipc$dispatch("-111641028", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "121370400")) {
            ipChange.ipc$dispatch("121370400", new Object[]{this, str});
            return;
        }
        startProgressDialog();
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1797652891")) {
            ipChange.ipc$dispatch("1797652891", new Object[]{this});
            return;
        }
        stopProgressDialog();
    }
}
