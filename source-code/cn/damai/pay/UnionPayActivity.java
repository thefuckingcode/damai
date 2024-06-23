package cn.damai.pay;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.com.argorse.plugin.unionpay.activity.LoadingActivity;
import cn.com.argorse.plugin.unionpay.decoder.PayOrderResultDecoder;
import cn.com.argorse.plugin.unionpay.entity.PayOrderResultEntity;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.orderlist.ui.activity.OrderListActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.an1;
import tb.bk2;

/* compiled from: Taobao */
public class UnionPayActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int REQUEST_CODE_PAYMENT = 100;
    boolean isFromMovie;
    private String mOrderId = "";
    private String param;

    private void getIntentData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "379132551")) {
            ipChange.ipc$dispatch("379132551", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.param = extras.getString("uninpay_param");
            this.isFromMovie = extras.getBoolean("fromMovie");
            if (extras.containsKey("orderid")) {
                this.mOrderId = extras.getString("orderid");
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "919276015")) {
            ipChange.ipc$dispatch("919276015", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10003 || i == 10001) {
            gotoOrderList();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1407668581")) {
            return R$layout.ali_pay_fragment;
        }
        return ((Integer) ipChange.ipc$dispatch("-1407668581", new Object[]{this})).intValue();
    }

    public void gotoOrderList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1565440806")) {
            ipChange.ipc$dispatch("-1565440806", new Object[]{this});
        } else if (this.isFromMovie) {
            setResult(1000);
            finish();
        } else {
            Intent intent = new Intent(this, OrderListActivity.class);
            if (!TextUtils.isEmpty(this.mOrderId)) {
                intent.putExtra("orderid", this.mOrderId);
            }
            startActivity(intent);
            setResult(1000);
            finish();
        }
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1744915520")) {
            ipChange.ipc$dispatch("1744915520", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-371332629")) {
            ipChange.ipc$dispatch("-371332629", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "102913490")) {
            ipChange.ipc$dispatch("102913490", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "622393657")) {
            ipChange.ipc$dispatch("622393657", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else if (intent == null) {
        } else {
            if (i != 100) {
                gotoOrderList();
                super.onActivityResult(i, i2, intent);
                return;
            }
            PayOrderResultEntity parserData = new PayOrderResultDecoder().getParserData(intent.getExtras().getString("xml"));
            if ("0000".equals(parserData.getRespCode())) {
                ToastUtil.i(getString(R$string.damai_alipay_payment_success_toast) + "！");
                gotoOrderList();
                return;
            }
            an1.g(parserData.getRespCode(), parserData.getRespDesc(), this.mOrderId);
            ToastUtil.i(getString(R$string.damai_alipay_payment_failed_toast) + "！");
            gotoOrderList();
        }
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-13793017")) {
            ipChange.ipc$dispatch("-13793017", new Object[]{this});
            return;
        }
        gotoOrderList();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1793565992")) {
            ipChange.ipc$dispatch("1793565992", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        getIntentData();
        if (!TextUtils.isEmpty(this.param)) {
            startUnionpay();
        } else {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "234625128")) {
            ipChange.ipc$dispatch("234625128", new Object[]{this});
            return;
        }
        super.onDestroy();
        ScreenShotDetector.k().z(false);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1307501201")) {
            ipChange.ipc$dispatch("-1307501201", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1809680070")) {
            ipChange.ipc$dispatch("1809680070", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "773740379")) {
            ipChange.ipc$dispatch("773740379", new Object[]{this});
            return;
        }
        super.onResume();
        ScreenShotDetector.k().z(true);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1557883343")) {
            return bk2.b(this, R$string.damai_alipay_unionPay_payment);
        }
        return (String) ipChange.ipc$dispatch("1557883343", new Object[]{this});
    }

    public void startUnionpay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-209744760")) {
            ipChange.ipc$dispatch("-209744760", new Object[]{this});
            return;
        }
        Intent intent = new Intent(this, LoadingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("ServerType", 1);
        bundle.putInt("PaymentType", 0);
        bundle.putInt("PaymentMode", 1);
        bundle.putString("xml", this.param);
        intent.putExtra("bundler", bundle);
        intent.setAction("android.intent.action.VIEW");
        startActivityForResult(intent, 100);
    }
}
