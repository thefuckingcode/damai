package cn.damai.commonbusiness.qrcode;

import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.bk2;

/* compiled from: Taobao */
public class QrCodeResultActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83249847")) {
            ipChange.ipc$dispatch("83249847", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1492512557")) {
            return R$layout.qr_code_result_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("-1492512557", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885247736")) {
            ipChange.ipc$dispatch("-885247736", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-302014941")) {
            ipChange.ipc$dispatch("-302014941", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "534699674")) {
            ipChange.ipc$dispatch("534699674", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "357302839")) {
            ipChange.ipc$dispatch("357302839", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1724836094")) {
            ipChange.ipc$dispatch("1724836094", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2068280825")) {
            return bk2.b(this, R$string.qrcode_check_info);
        }
        return (String) ipChange.ipc$dispatch("-2068280825", new Object[]{this});
    }
}
