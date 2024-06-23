package cn.damai.pay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.pay.alipay.PayResult;
import com.alipay.sdk.app.PayTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.ups.request.UpsConstant;
import java.util.Map;
import tb.d20;
import tb.gr;
import tb.s41;
import tb.yz2;

/* compiled from: Taobao */
public class AliPayActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String FROM_HN_CRETE_ORDER_PAGE = "HNCreateOrderPage";
    private static final String FROM_SM_CRETE_ORDER_PAGE = "SMCreateOrderPage";
    private static final int SDK_CHECK_FLAG = 2;
    private static final int SDK_PAY_FLAG = 1;
    private final String FROM_ORDER_MANAGER_PAGE = "OrderDetailPage";
    public boolean isFromMovie;
    public String mFromPage = "";
    private final Handler mHandler = new Handler() {
        /* class cn.damai.pay.AliPayActivity.AnonymousClass2 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1123483032")) {
                ipChange.ipc$dispatch("1123483032", new Object[]{this, message});
                return;
            }
            int i = message.what;
            if (i == 1) {
                PayResult payResult = new PayResult((Map) message.obj);
                String resultStatus = payResult.getResultStatus();
                if (TextUtils.equals(resultStatus, "9000")) {
                    if (DamaiPayConstants.PAY_SUCCESS_PUSH_OPEN_STAYUS_SHOW.equals(d20.B(DamaiPayConstants.PAY_SUCCESS_PUSH_OPEN_STAYUS)) || PermissionsHelper.a(AliPayActivity.this.getApplicationContext())) {
                        AliPayActivity aliPayActivity = AliPayActivity.this;
                        aliPayActivity.toast(aliPayActivity.getResources().getString(R$string.damai_alipay_payment_success_toast));
                    }
                    AliPayActivity.this.mPayResult = true;
                } else if (!TextUtils.isEmpty(resultStatus)) {
                    if (!resultStatus.equals("6001")) {
                        AliPayActivity aliPayActivity2 = AliPayActivity.this;
                        aliPayActivity2.toast(aliPayActivity2.getResources().getString(R$string.damai_alipay_payment_failed_toast));
                    }
                    if (resultStatus.equals(UpsConstant.UPS_NETWORK_4G) || resultStatus.equals("6002")) {
                        AliPayActivity.this.aliPayFailXFlush(resultStatus, payResult.getResult(), message.obj);
                    }
                } else {
                    AliPayActivity aliPayActivity3 = AliPayActivity.this;
                    aliPayActivity3.toast(aliPayActivity3.getResources().getString(R$string.damai_alipay_payment_failed_toast));
                }
                AliPayActivity.this.jumpOrderManagerPage();
            } else if (i == 2) {
                AliPayActivity.this.pay();
            }
        }
    };
    private final String mPayName = "zhifubao";
    public boolean mPayResult;
    public String orderId = "";
    public String param;
    public int typewansm = 0;

    private void jumpHNOrderDetailtPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1435054592")) {
            ipChange.ipc$dispatch("-1435054592", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("orderId", this.orderId);
        bundle.putBoolean("payResult", this.mPayResult);
        bundle.putBoolean(FROM_HN_CRETE_ORDER_PAGE, true);
        DMNav.from(this).clearTop().withExtras(bundle).toUri(NavUri.b(gr.h));
    }

    private void jumpOrderListPage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36561455")) {
            ipChange.ipc$dispatch("36561455", new Object[]{this, str});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("from_pay", "zhifubao");
        bundle.putString("pageType", str);
        DMNav.from(this).withExtras(bundle).forResult(1000).toUri(NavUri.b(gr.f));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void jumpOrderManagerPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1298493092")) {
            ipChange.ipc$dispatch("-1298493092", new Object[]{this});
            return;
        }
        if (this.isFromMovie) {
            setResult(1000);
        } else if ("OrderDetailPage".equals(this.mFromPage)) {
            Intent intent = new Intent();
            intent.putExtra("payResult", this.mPayResult);
            setResult(1000, intent);
        } else if (FROM_HN_CRETE_ORDER_PAGE.equals(this.mFromPage)) {
            if (TextUtils.isEmpty(this.orderId)) {
                jumpOrderListPage(null);
            } else if (this.mPayResult) {
                jumpOrderResultPage();
            } else {
                jumpHNOrderDetailtPage();
            }
        } else if (FROM_SM_CRETE_ORDER_PAGE.equals(this.mFromPage)) {
            if (!TextUtils.isEmpty(this.orderId)) {
                Bundle bundle = new Bundle();
                bundle.putString("orderId", this.orderId);
                boolean z = this.mPayResult;
                if (z) {
                    DMNav.from(this).clearTop().withExtras(bundle).toUri(NavUri.b(gr.SCRIPT_COUPON_PAY_RESULT));
                } else {
                    bundle.putBoolean("payResult", z);
                    bundle.putBoolean("CouponCreateOrderPage", true);
                    DMNav.from(this).clearTop().withExtras(bundle).toUri(NavUri.b(gr.COUPON_ORDER_DETAIL));
                }
            } else {
                jumpOrderListPage("jubensha");
            }
            finish();
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putString("from_pay", "zhifubao");
            setResult(1000);
            DMNav.from(this).withExtras(bundle2).toUri(NavUri.b(gr.f));
        }
        finish();
    }

    private void jumpOrderResultPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101391354")) {
            ipChange.ipc$dispatch("-2101391354", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("orderId", this.orderId);
        DMNav.from(this).clearTop().withExtras(bundle).toUri(NavUri.b(gr.e));
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0037, code lost:
        if (r1.equals("FROM_SM_CRETE_ORDER_PAGE") == false) goto L_0x002f;
     */
    public void aliPayFailXFlush(String str, String str2, Object obj) {
        String str3;
        IpChange ipChange = $ipChange;
        char c = 2;
        if (AndroidInstantRuntime.support(ipChange, "-1123194668")) {
            ipChange.ipc$dispatch("-1123194668", new Object[]{this, str, str2, obj});
            return;
        }
        StringBuilder sb = new StringBuilder();
        String str4 = this.mFromPage;
        str4.hashCode();
        switch (str4.hashCode()) {
            case -1071799429:
                if (str4.equals(FROM_HN_CRETE_ORDER_PAGE)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 178335822:
                if (str4.equals("OrderDetailPage")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1082689736:
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                str3 = "麒麟订单确认";
                break;
            case 1:
                str3 = "订单详情";
                break;
            case 2:
                str3 = "剧本杀下单";
                break;
            default:
                str3 = "";
                break;
        }
        String e = s41.e(obj);
        sb.append("┋");
        sb.append("orderId: ");
        sb.append(this.orderId);
        sb.append("┋retMsg: ");
        sb.append("支付包支付失败—SDK错误， 完成信息：" + e);
        sb.append("┋customCode: ");
        sb.append("原-4340");
        sb.append("┋fromWhere: " + str3);
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        yz2.c("alipay", "dmpay", sb2, str, str2);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1194515840")) {
            ipChange.ipc$dispatch("-1194515840", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10001 || i == 10003) {
            onBackPressed();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "112967530")) {
            return R$layout.ali_pay_fragment;
        }
        return ((Integer) ipChange.ipc$dispatch("112967530", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1639994705")) {
            ipChange.ipc$dispatch("1639994705", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671089402")) {
            ipChange.ipc$dispatch("671089402", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1487572835")) {
            ipChange.ipc$dispatch("1487572835", new Object[]{this});
        }
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1028629014")) {
            ipChange.ipc$dispatch("1028629014", new Object[]{this});
            return;
        }
        jumpOrderManagerPage();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154847241")) {
            ipChange.ipc$dispatch("-154847241", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.mPayResult = false;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.param = extras.getString("alipay_param");
            this.isFromMovie = extras.getBoolean("fromMovie");
            this.typewansm = extras.getInt("wanshenme");
            if (extras.containsKey("orderid")) {
                this.orderId = extras.getString("orderid");
            }
            if (extras.containsKey("from")) {
                this.mFromPage = extras.getString("from", "");
            }
        }
        if (!TextUtils.isEmpty(this.param)) {
            pay();
        } else {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209391863")) {
            ipChange.ipc$dispatch("209391863", new Object[]{this});
            return;
        }
        super.onDestroy();
        ScreenShotDetector.k().z(false);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2136567572")) {
            ipChange.ipc$dispatch("-2136567572", new Object[]{this});
            return;
        }
        super.onResume();
        ScreenShotDetector.k().z(true);
    }

    public void pay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477225974")) {
            ipChange.ipc$dispatch("-477225974", new Object[]{this});
            return;
        }
        final String str = this.param;
        new Thread(new Runnable() {
            /* class cn.damai.pay.AliPayActivity.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2034543898")) {
                    ipChange.ipc$dispatch("2034543898", new Object[]{this});
                    return;
                }
                Map<String, String> payV2 = new PayTask(AliPayActivity.this).payV2(str, true);
                Message message = new Message();
                message.what = 1;
                message.obj = payV2;
                AliPayActivity.this.mHandler.sendMessage(message);
            }
        }).start();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1028482142")) {
            return getResources().getString(R$string.damai_alipay_title);
        }
        return (String) ipChange.ipc$dispatch("1028482142", new Object[]{this});
    }

    public void toast(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "7117813")) {
            ipChange.ipc$dispatch("7117813", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            ToastUtil.a().g(this);
        } else {
            ToastUtil.i(str);
        }
    }
}
