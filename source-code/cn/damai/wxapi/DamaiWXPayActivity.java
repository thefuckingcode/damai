package cn.damai.wxapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.share.WXPayParmas;
import cn.damai.pay.AliPayActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.common.Constants;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import tb.bk2;
import tb.gr;
import tb.s41;
import tb.z10;

/* compiled from: Taobao */
public class DamaiWXPayActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FINISH_ACTIVITY = 1000;
    private IWXAPI api;
    boolean b = true;
    public Context context;
    public String mFromPage = "";
    public String orderId = "0";
    public WXPayParmas parmas;
    public String wxPayParm = "";

    private void regToWX() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1485448078")) {
            ipChange.ipc$dispatch("1485448078", new Object[]{this});
            return;
        }
        String a = z10.a(WXEntryActivity.APP_ID_CRYPT);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, a);
        this.api = createWXAPI;
        createWXAPI.registerApp(a);
    }

    public boolean checkWx() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "134223929")) {
            return ((Boolean) ipChange.ipc$dispatch("134223929", new Object[]{this})).booleanValue();
        } else if (getPackageManager().getLaunchIntentForPackage("com.tencent.mm") != null) {
            return true;
        } else {
            DMDialog dMDialog = new DMDialog(this);
            dMDialog.v(bk2.b(this, R$string.data_string_007));
            dMDialog.q(bk2.b(this, R$string.data_string_015));
            dMDialog.n(bk2.b(this, R$string.Ensure), new DialogInterface.OnClickListener() {
                /* class cn.damai.wxapi.DamaiWXPayActivity.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(DialogInterface dialogInterface, int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "717523973")) {
                        ipChange.ipc$dispatch("717523973", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                        return;
                    }
                    try {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse("https://weixin.qq.com/cgi-bin/download302?check=false&uin=&stype=&promote=&fr=&lang=zh_CN&ADTAG=&url=android16"));
                        DamaiWXPayActivity.this.startActivity(intent);
                    } catch (Exception unused) {
                    }
                    dialogInterface.dismiss();
                    DamaiWXPayActivity.this.finish();
                }
            });
            dMDialog.i(bk2.b(this, R$string.Cancel), new DialogInterface.OnClickListener() {
                /* class cn.damai.wxapi.DamaiWXPayActivity.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(DialogInterface dialogInterface, int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1687104996")) {
                        ipChange.ipc$dispatch("1687104996", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                        return;
                    }
                    dialogInterface.dismiss();
                    DamaiWXPayActivity.this.finish();
                }
            });
            dMDialog.show();
            return false;
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1441039276")) {
            ipChange.ipc$dispatch("-1441039276", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "334074134")) {
            return R$layout.wx_pay_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("334074134", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-95635163")) {
            ipChange.ipc$dispatch("-95635163", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1593828954")) {
            ipChange.ipc$dispatch("-1593828954", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "755629367")) {
            ipChange.ipc$dispatch("755629367", new Object[]{this});
            return;
        }
        hideBaseLayout();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-363712093")) {
            ipChange.ipc$dispatch("-363712093", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.context = this;
        regToWX();
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("PayParm")) {
            String stringExtra = getIntent().getStringExtra("PayParm");
            this.wxPayParm = stringExtra;
            if (stringExtra != null) {
                this.wxPayParm = stringExtra.replace("package", Constants.KEY_PACKAGES);
            }
            this.orderId = getIntent().getStringExtra("orderId");
            if (extras.containsKey("from")) {
                this.mFromPage = extras.getString("from", "");
            }
            try {
                wxPay();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1146915412")) {
            ipChange.ipc$dispatch("1146915412", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-743544511")) {
            ipChange.ipc$dispatch("-743544511", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1426456256")) {
            ipChange.ipc$dispatch("1426456256", new Object[]{this});
            return;
        }
        super.onResume();
        if (!this.b) {
            setResult(1000);
            if (!this.mFromPage.equals("OrderDetailPage")) {
                DMNav.from(this).toUri(NavUri.b(gr.f));
            }
            finish();
            this.b = false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1192961782")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-1192961782", new Object[]{this});
    }

    public void wxPay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1061589431")) {
            ipChange.ipc$dispatch("1061589431", new Object[]{this});
        } else if (checkWx()) {
            this.parmas = (WXPayParmas) s41.a(this.wxPayParm, WXPayParmas.class);
            PayReq payReq = new PayReq();
            payReq.appId = this.parmas.appid + "";
            WXPayParmas wXPayParmas = this.parmas;
            payReq.partnerId = wXPayParmas.partnerid;
            payReq.prepayId = wXPayParmas.prepayid;
            payReq.nonceStr = wXPayParmas.noncestr;
            payReq.timeStamp = wXPayParmas.timestamp;
            payReq.packageValue = wXPayParmas.packages;
            payReq.sign = wXPayParmas.sign;
            payReq.extData = this.orderId + "";
            this.api.sendReq(payReq);
            WXPayEntryActivity.context2 = this;
            WXPayEntryActivity.orderId = this.orderId;
            if ("OrderDetailPage".equals(this.mFromPage)) {
                WXPayEntryActivity.setWXPayType(WXPayEntryActivity.FROM_ORDER_DETAIL);
            } else if (AliPayActivity.FROM_HN_CRETE_ORDER_PAGE.equalsIgnoreCase(this.mFromPage)) {
                WXPayEntryActivity.setWXPayType(WXPayEntryActivity.FROM_HN_CREATE_ORDER);
            } else if ("SMCreateOrderPage".equals(this.mFromPage)) {
                WXPayEntryActivity.setWXPayType(WXPayEntryActivity.FROM_SCRIPT_MURDER_CREATE_ORDER);
            }
        }
    }
}
